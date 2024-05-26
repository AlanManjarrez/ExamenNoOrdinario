/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajeriapersistencia.DAOS;

import com.mycompany.mensajeriapersistencia.Conexion.Conexion;
import com.mycompany.mensajeriapersistencia.Conexion.IConexion;
import com.mycompany.mensajeriapersistencia.Dominio.Chat;
import com.mycompany.mensajeriapersistencia.Dominio.Mensaje;
import com.mycompany.mensajeriapersistencia.Dominio.Participante;
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
 * Clase que implementa la interfaz IParticipanteDAO y proporciona la lógica
 * para interactuar con la capa de persistencia de datos para la entidad
 * Participante en el sistema.
 *
 * Esta clase se encarga de realizar operaciones como agregar, actualizar,
 * eliminar y consultar participantes en la base de datos. Utiliza una instancia
 * de la interfaz IConexion para establecer y manejar la conexión con la base de
 * datos.
 *
 * Los errores relacionados con la persistencia de datos son registrados
 * utilizando un {@link Logger} para facilitar el seguimiento y la depuración.
 *
 * @autor Jose Alan Manjarrez Ontiveros 228982
 */
public class ParticipanteDAO implements IParticipanteDAO {

    IConexion conexion;
    private static final Logger LOG = Logger.getLogger(Usuario.class.getName());

    /**
     * Constructor por defecto de la clase ParticipanteDAO.
     */
    public ParticipanteDAO() {
        this.conexion = new Conexion();
    }

    /**
     * Agrega un nuevo participante al sistema.
     *
     * @param participante el participante a ser agregado
     * @return el participante agregado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Participante agregarParticipante(Participante participante) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement conn = con.prepareCall("{call agregar_participante(?,?)}")) {

            conn.setInt(1, participante.getIdUsuario());
            conn.setInt(2, participante.getIdChat());

            int registro = conn.executeUpdate();
            LOG.log(Level.INFO, "Se agrego con éxito {0} ", registro);

            ResultSet registroG = conn.getGeneratedKeys();
            int idGenerado = 0;
            if (registroG.next()) {
                idGenerado = registroG.getInt(1);
            }

            Participante participanteNuevo = new Participante(idGenerado,
                    participante.getIdUsuario(),
                    participante.getIdChat()
            );
            return participanteNuevo;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se ha podido agregar el participante", e);
            throw new PersistenciaException("No se pudo guardar el participante", e);
        }
    }

    /**
     * Actualiza los datos de un participante existente en el sistema.
     *
     * @param participante el participante con los datos actualizados
     * @return el participante actualizado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Participante actualizarParticipante(Participante participante) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement conn = con.prepareCall("{call actualizar_participante(?,?,?)}")) {

            conn.setInt(1, participante.getIdParticipantes());
            conn.setInt(2, participante.getIdUsuario());
            conn.setInt(3, participante.getIdChat());

            int registro = conn.executeUpdate();
            LOG.log(Level.INFO, "Se actualizo con éxito {0} ", registro);

            Participante participanteNuevo = new Participante(participante.getIdParticipantes(),
                    participante.getIdUsuario(),
                    participante.getIdChat()
            );
            return participanteNuevo;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se ha podido actualizar el participante", e);
            throw new PersistenciaException("No se pudo actualizar el participante", e);
        }
    }

    /**
     * Elimina un participante del sistema utilizando su identificador.
     *
     * @param idParticipante el identificador del participante a ser eliminado
     * @return el participante eliminado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Participante eliminarParticipante(int idParticipante) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement stmt = con.prepareCall("{call eliminar_participante(?)}")) {

            stmt.setInt(1, idParticipante);

            int registros = stmt.executeUpdate();
            LOG.log(Level.INFO, "Se eliminó con éxito {0}", registros);

            return null;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al eliminar el chat", e);
            throw new PersistenciaException("Error al eliminar el chat", e);
        }
    }

    /**
     * Consulta un participante en el sistema utilizando su identificador.
     *
     * @param idParticipante el identificador del participante a ser consultado
     * @return una lista de participantes que coinciden con el identificador
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public List<Participante> consultarParticipante(int idParticipante) throws PersistenciaException {
        List<Participante> participantes = new ArrayList<>();
        try ( Connection con = this.conexion.crearConexion();  CallableStatement cs = con.prepareCall("{call consultar_participante(?)}")) {

            cs.setInt(1, idParticipante);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int idParticipantes = rs.getInt("ID_PARTICIPANTE");
                int idUsuario = rs.getInt("ID_USUARIO");
                int idChat = rs.getInt("ID_CHAT");

                Participante participante = new Participante(idParticipantes, idUsuario, idChat);
                participantes.add(participante);
            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al consultar el mensaje", e);
            throw new PersistenciaException("Error al consultar el mensaje", e);
        }
        return participantes;
    }
}
