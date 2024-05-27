/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajeriapersistencia.DAOS;

import com.mycompany.mensajeriapersistencia.Conexion.Conexion;
import com.mycompany.mensajeriapersistencia.Conexion.IConexion;
import com.mycompany.mensajeriapersistencia.Dominio.Mensaje;
import com.mycompany.mensajeriapersistencia.Dominio.Usuario;
import com.mycompany.mensajeriapersistencia.PersistenciaException.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz IMensajeDAO y proporciona la lógica para
 * interactuar con la capa de persistencia de datos para la entidad Mensaje en
 * el sistema.
 *
 * Esta clase se encarga de realizar operaciones como agregar, editar, eliminar
 * y consultar mensajes en la base de datos. Utiliza una instancia de la
 * interfaz IConexion para establecer y manejar la conexión con la base de
 * datos.
 *
 * Los errores relacionados con la persistencia de datos son registrados
 * utilizando un {@link Logger} para facilitar el seguimiento y la depuración.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class MensajeDAO implements IMensajeDAO {

    IConexion conexion;
    private static final Logger LOG = Logger.getLogger(Usuario.class.getName());

    /**
     * Constructor por defecto de la clase MensajeDAO.
     */
    public MensajeDAO() {
        this.conexion = new Conexion();
    }

    /**
     * Agrega un nuevo mensaje al sistema.
     *
     * @param mensaje el mensaje a ser agregado
     * @return el mensaje agregado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Mensaje agregarMensaje(Mensaje mensaje) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement conn = con.prepareCall("{call agregar_mensaje(?,?,?,?,?)}")) {

            conn.setString(1, mensaje.getTexto());
            conn.setString(2, mensaje.getFechaHoraRegistro());
            conn.setBytes(3, mensaje.getImagenMensaje());
            conn.setInt(4, mensaje.getIdUsuario());
            conn.setInt(5, mensaje.getIdChat());

            int registro = conn.executeUpdate();
            LOG.log(Level.INFO, "Se agrego con éxito {0} ", registro);

            ResultSet registroG = conn.getGeneratedKeys();
            int idGenerado = 0;
            if (registroG.next()) {
                idGenerado = registroG.getInt(1);
            }

            Mensaje mensajeNuevo = new Mensaje(idGenerado,
                    mensaje.getTexto(),
                    mensaje.getFechaHoraRegistro(),
                    mensaje.getImagenMensaje(),
                    mensaje.getIdUsuario(),
                    mensaje.getIdChat()
            );
            return mensajeNuevo;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se ha podido agregar el mensaje", e);
            throw new PersistenciaException("No se pudo guardar el mensaje", e);
        }
    }

    /**
     * Edita un mensaje existente en el sistema.
     *
     * @param mensaje el mensaje con los datos actualizados
     * @return el mensaje editado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Mensaje editarMensaje(Mensaje mensaje) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement conn = con.prepareCall("{call editar_mensaje(?,?)}")) {

            conn.setInt(1, mensaje.getIdMensaje());
            conn.setString(2, mensaje.getTexto());

            int registro = conn.executeUpdate();
            LOG.log(Level.INFO, "Se edito con éxito {0} ", registro);

            Mensaje mensajeNuevo = new Mensaje(mensaje.getIdMensaje(),
                    mensaje.getTexto()
            );
            return mensajeNuevo;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se ha podido actualizar el mensaje", e);
            throw new PersistenciaException("No se pudo actualizar el mensaje", e);
        }
    }

    /**
     * Elimina un mensaje del sistema utilizando su identificador.
     *
     * @param idMensaje el identificador del mensaje a ser eliminado
     * @return el mensaje eliminado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Mensaje eliminarMensaje(int idMensaje) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement stmt = con.prepareCall("{call eliminar_mensaje(?)}")) {

            stmt.setInt(1, idMensaje);

            int registros = stmt.executeUpdate();
            LOG.log(Level.INFO, "Se eliminó con éxito {0}", registros);

            return null;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al eliminar el mensaje", e);
            throw new PersistenciaException("Error al eliminar el mensaje", e);
        }
    }

    /**
     * Consulta mensajes en el sistema utilizando un texto de búsqueda.
     *
     * @param texto el texto a ser buscado en los mensajes
     * @return una lista de mensajes que coinciden con el texto de búsqueda
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public List<Mensaje> consultarMensaje(String texto) throws PersistenciaException {
        List<Mensaje> mensajes = new ArrayList<>();
        try ( Connection con = this.conexion.crearConexion();  CallableStatement cs = con.prepareCall("{call consultar_mensaje(?)}")) {

            cs.setString(1, texto);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int idMensaje = rs.getInt("ID_MENSAJE");
                String mensajeTexto = rs.getString("TEXTO");
                String fechaHoraRegistro = rs.getString("FECHA_HORA_REGISTRO");
                byte[] imagenMensaje = rs.getBytes("IMAGEN_MENSAJE");

                Mensaje mensaje = new Mensaje(idMensaje, mensajeTexto, fechaHoraRegistro, imagenMensaje);
                mensajes.add(mensaje);
            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al consultar el mensaje", e);
            throw new PersistenciaException("Error al consultar el mensaje", e);
        }
        return mensajes;
    }

    /**
     * Consulta todos los mensajes asociados a un chat específico.
     *
     * @param idChat el identificador del chat cuyos mensajes se desean
     * consultar
     * @return una lista de objetos Mensaje que pertenecen al chat especificado
     * @throws PersistenciaException si ocurre un error al acceder a la base de
     * datos
     */
    @Override
    public List<Mensaje> consultarMensajeChat(int idChat) throws PersistenciaException {
        List<Mensaje> mensajes = new ArrayList<>();
        try ( Connection con = this.conexion.crearConexion();  CallableStatement cs = con.prepareCall("{call consultar_mensaje_chat(?)}")) {

            cs.setInt(1, idChat);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int idMensaje = rs.getInt("ID_MENSAJE");
                String mensajeTexto = rs.getString("TEXTO");
                String fechaHoraRegistro = rs.getString("FECHA_HORA_REGISTRO");
                byte[] imagenMensaje = rs.getBytes("IMAGEN_MENSAJE");
                int idUsuario = rs.getInt("ID_USUARIO");
                int idChats = rs.getInt("ID_CHAT");

                Mensaje mensaje = new Mensaje(idMensaje, mensajeTexto, fechaHoraRegistro, imagenMensaje, idUsuario, idChats);
                mensajes.add(mensaje);
            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al consultar el mensaje", e);
            throw new PersistenciaException("Error al consultar el mensaje", e);
        }
        return mensajes;
    }
}
