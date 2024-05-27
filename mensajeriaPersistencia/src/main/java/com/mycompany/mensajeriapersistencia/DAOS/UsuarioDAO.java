
package com.mycompany.mensajeriapersistencia.DAOS;

import com.mycompany.mensajeriapersistencia.Conexion.Conexion;
import com.mycompany.mensajeriapersistencia.Conexion.IConexion;
import com.mycompany.mensajeriapersistencia.Dominio.Usuario;
import com.mycompany.mensajeriapersistencia.PersistenciaException.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz IUsuarioDAO y proporciona la lógica para interactuar 
 * con la capa de persistencia de datos para la entidad Usuario en el sistema.
 * 
 * Esta clase se encarga de realizar operaciones como agregar, actualizar y consultar usuarios 
 * en la base de datos. Utiliza una instancia de la interfaz IConexion para establecer y manejar 
 * la conexión con la base de datos.
 * 
 * Los errores relacionados con la persistencia de datos son registrados utilizando un 
 * {@link Logger} para facilitar el seguimiento y la depuración.
 * 
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class UsuarioDAO implements IUsuarioDAO {

    IConexion conexion;
    private static final Logger LOG = Logger.getLogger(Usuario.class.getName());
    /**
     * Constructor por defecto de la clase UsuarioDAO.
     */
    public UsuarioDAO() {
        this.conexion = new Conexion();
    }

    /**
     * Agrega un nuevo usuario al sistema.
     *
     * @param usuario el usuario a ser agregado
     * @return el usuario agregado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Usuario agregarUsuario(Usuario usuario) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement conn = con.prepareCall("{call agregar_usuario(?,?,?,?,?)}")) {

            conn.setString(1, usuario.getTelefono());
            conn.setString(2, usuario.getContrasena());
            conn.setString(3, usuario.getSexo());
            conn.setString(4, usuario.getFechaNacimiento());
            conn.setString(5, usuario.getImagenPerfil());

            int registro = conn.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con éxito {0} ", registro);

            ResultSet registroG = conn.getGeneratedKeys();
            int idGenerado = 0;
            if (registroG.next()) {
                idGenerado = registroG.getInt(1);
            }

            Usuario usuarioNuevo = new Usuario(idGenerado,
                    usuario.getTelefono(),
                    usuario.getContrasena(),
                    usuario.getSexo(),
                    usuario.getFechaNacimiento(),
                    usuario.getImagenPerfil()
            );
            return usuarioNuevo;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se ha podido agregar el usuario", e);
            throw new PersistenciaException("No se pudo guardar el usuario", e);
        }
    }

    /**
     * Actualiza los datos de un usuario existente en el sistema.
     *
     * @param usuario el usuario con los datos actualizados
     * @return el usuario actualizado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement conn = con.prepareCall("{call actualizar_usuario(?,?,?,?,?,?)}")) {

            conn.setInt(1, usuario.getIdUsuario());
            conn.setString(2, usuario.getTelefono());
            conn.setString(3, usuario.getContrasena());
            conn.setString(4, usuario.getSexo());
            conn.setString(5, usuario.getFechaNacimiento());
            conn.setString(6, usuario.getImagenPerfil());

            int registro = conn.executeUpdate();
            LOG.log(Level.INFO, "Se actualizó con éxito {0} ", registro);

            Usuario usuarioActualizado = new Usuario(usuario.getIdUsuario(),
                    usuario.getTelefono(),
                    usuario.getContrasena(),
                    usuario.getSexo(),
                    usuario.getFechaNacimiento(),
                    usuario.getImagenPerfil()
            );
            return usuarioActualizado;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se ha podido actualizar el usuario", e);
            throw new PersistenciaException("No se pudo actualizar al usuario", e);
        }
    }

    /**
     * Consulta un usuario en el sistema utilizando su número de teléfono y contraseña.
     *
     * @param telefono el número de teléfono del usuario a consultar
     * @param contrasena la contraseña del usuario a consultar
     * @return el usuario encontrado, o null si no se encuentra ningún usuario
     * con ese número de teléfono
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Usuario consultarUsuarioTelefonoContrasena(String telefono, String contrasena) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement cs = con.prepareCall("{call consultar_usuario_telefono_contrasena(?,?)}")) {

            cs.setString(1, telefono);
            cs.setString(2, contrasena);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                usuario.setTelefono(rs.getString("TELEFONO"));
                usuario.setContrasena(rs.getString("CONTRASENA"));
                usuario.setSexo(rs.getString("SEXO"));
                usuario.setFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
                usuario.setImagenPerfil(rs.getString("IMAGEN_PERFIL"));
                return usuario;
            } else {
                throw new PersistenciaException("No se encontró ningún usuario con el teléfono proporcionado");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar el usuario", e);
        }
    }
    /**
     * Consulta un usuario en el sistema utilizando su número de teléfono.
     *
     * @param telefono el número de teléfono del usuario a consultar
     * @return el usuario encontrado, o null si no se encuentra ningún usuario
     * con ese número de teléfono
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Usuario consultarUsuarioTelefono(String telefono) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement cs = con.prepareCall("{call consultar_usuario_telefono(?)}")) {

            cs.setString(1, telefono);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                usuario.setTelefono(rs.getString("TELEFONO"));
                usuario.setContrasena(rs.getString("CONTRASENA"));
                usuario.setSexo(rs.getString("SEXO"));
                usuario.setFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
                usuario.setImagenPerfil(rs.getString("IMAGEN_PERFIL"));
                return usuario;
            } else {
                throw new PersistenciaException("No se encontró ningún usuario con el teléfono proporcionado");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar el usuario", e);
        }
    }
}
