
package com.mycompany.mensajeriapersistencia.DAOS;

import com.mycompany.mensajeriapersistencia.Conexion.Conexion;
import com.mycompany.mensajeriapersistencia.Conexion.IConexion;
import com.mycompany.mensajeriapersistencia.Dominio.Chat;
import com.mycompany.mensajeriapersistencia.Dominio.Usuario;
import com.mycompany.mensajeriapersistencia.PersistenciaException.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz IChatDAO y proporciona la lógica para interactuar 
 * con la capa de persistencia de datos para la entidad Chat en el sistema.
 * 
 * Esta clase se encarga de realizar operaciones como agregar, editar, eliminar y consultar chats 
 * en la base de datos. Utiliza una instancia de la interfaz IConexion para establecer y manejar 
 * la conexión con la base de datos.
 * 
 * Los errores relacionados con la persistencia de datos son registrados utilizando un 
 * {@link Logger} para facilitar el seguimiento y la depuración.
 * 
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class ChatDAO implements IChatDAO {

    IConexion conexion;
    private static final Logger LOG = Logger.getLogger(Usuario.class.getName());
    
    /**
     * Constructor por defecto de la clase ChatDAO.
     */
    public ChatDAO() {
        this.conexion = new Conexion();
    }

    /**
     * Agrega un nuevo chat al sistema.
     *
     * @param chat el chat a ser agregado
     * @return el chat agregado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Chat agregarChat(Chat chat) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement conn = con.prepareCall("{call agregar_chat(?)}")) {

            conn.setString(1, chat.getNombreUsuario());

            int registro = conn.executeUpdate();
            LOG.log(Level.INFO, "Se agrego con éxito {0} ", registro);

            ResultSet registroG = conn.getGeneratedKeys();
            int idGenerado = 0;
            if (registroG.next()) {
                idGenerado = registroG.getInt(1);
            }

            Chat chatNuevo = new Chat(idGenerado,
                    chat.getNombreUsuario()
            );
            return chatNuevo;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se ha podido agregar el chat", e);
            throw new PersistenciaException("No se pudo guardar el chat", e);
        }
    }

    /**
     * Edita un chat existente en el sistema.
     *
     * @param chat el chat con los datos actualizados
     * @return el chat editado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Chat editarChat(Chat chat) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement conn = con.prepareCall("{call editar_chat(?,?)}")) {

            conn.setInt(1, chat.getIdChat());
            conn.setString(2, chat.getNombreUsuario());

            int registro = conn.executeUpdate();
            LOG.log(Level.INFO, "Se edito con exito {0} ", registro);

            Chat chatEditado = new Chat(chat.getIdChat(),
                    chat.getNombreUsuario()
            );
            return chatEditado;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se ha podido agregar el chat", e);
            throw new PersistenciaException("No se pudo guardar el chat", e);
        }
    }

    /**
     * Elimina un chat del sistema utilizando su identificador.
     *
     * @param idChat el identificador del chat a ser eliminado
     * @return el chat eliminado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Chat eliminarChat(int idChat) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement stmt = con.prepareCall("{call eliminar_chat(?)}")) {

            stmt.setInt(1, idChat);

            int registros = stmt.executeUpdate();
            LOG.log(Level.INFO, "Se eliminó con éxito {0} registros", registros);

            return null;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al eliminar el chat", e);
            throw new PersistenciaException("Error al eliminar el chat", e);
        }
    }

    /**
     * Consulta un chat en el sistema utilizando su identificador.
     *
     * @param idChat el identificador del chat a ser consultado
     * @return el chat encontrado, o null si no se encuentra ningún chat con ese
     * identificador
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Chat consultarChat(int idChat) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement cs = con.prepareCall("{call consultar_chat(?)}")) {

            cs.setInt(1, idChat);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                Chat chat = new Chat();
                chat.setIdChat(rs.getInt("ID_CHAT"));
                chat.setNombreUsuario(rs.getString("NOMBRE_USUARIO"));

                return chat;
            } else {
                throw new PersistenciaException("No se encontró ningún chat con el idChat proporcionado");
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al consultar el chat", e);
            throw new PersistenciaException("Error al consultar el chat", e);
        }
    }

}
