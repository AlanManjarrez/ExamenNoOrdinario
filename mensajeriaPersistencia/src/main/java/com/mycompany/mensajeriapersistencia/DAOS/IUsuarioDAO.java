package com.mycompany.mensajeriapersistencia.DAOS;

import com.mycompany.mensajeriapersistencia.Dominio.Usuario;
import com.mycompany.mensajeriapersistencia.PersistenciaException.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Usuario
 * en el sistema.
 *
 * Esta interfaz proporciona métodos para agregar, actualizar y consultar
 * usuarios en la capa de persistencia de datos. Las implementaciones de esta
 * interfaz deben proporcionar la lógica específica para interactuar con el
 * almacenamiento de datos subyacente, como una base de datos.
 *
 * Las excepciones de tipo {@link PersistenciaException} son lanzadas para
 * indicar problemas relacionados con la persistencia de datos durante la
 * ejecución de estas operaciones.
 *
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public interface IUsuarioDAO {

    /**
     * Agrega un nuevo usuario al sistema.
     *
     * @param usuario el usuario a ser agregado
     * @return el usuario agregado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Usuario agregarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Actualiza los datos de un usuario existente en el sistema.
     *
     * @param usuario el usuario con los datos actualizados
     * @return el usuario actualizado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Usuario actualizarUsuario(Usuario usuario) throws PersistenciaException;

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
    public Usuario consultarUsuarioTelefonoContrasena(String telefono, String contrasena) throws PersistenciaException;

    /**
     * Consulta un usuario en el sistema utilizando su número de teléfono.
     *
     * @param telefono el número de teléfono del usuario a consultar
     * @return el usuario encontrado, o null si no se encuentra ningún usuario
     * con ese número de teléfono
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Usuario consultarUsuarioTelefono(String telefono) throws PersistenciaException;

}
