
package com.mycompany.mensajeriapersistencia.DAOS;

import com.mycompany.mensajeriapersistencia.Dominio.Chat;
import com.mycompany.mensajeriapersistencia.PersistenciaException.PersistenciaException;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Chat en
 * el sistema.
 *
 * Esta interfaz proporciona métodos para agregar, editar, eliminar y consultar
 * chats en la capa de persistencia de datos. Las implementaciones de esta
 * interfaz deben proporcionar la lógica específica para interactuar con el
 * almacenamiento de datos subyacente, como una base de datos.
 *
 * Las excepciones de tipo {@link PersistenciaException} son lanzadas para
 * indicar problemas relacionados con la persistencia de datos durante la
 * ejecución de estas operaciones.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public interface IChatDAO {

    /**
     * Agrega un nuevo chat al sistema.
     *
     * @param chat el chat a ser agregado
     * @return el chat agregado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Chat agregarChat(Chat chat) throws PersistenciaException;

    /**
     * Edita un chat existente en el sistema.
     *
     * @param chat el chat con los datos actualizados
     * @return el chat editado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Chat editarChat(Chat chat) throws PersistenciaException;

    /**
     * Elimina un chat del sistema utilizando su identificador.
     *
     * @param idChat el identificador del chat a ser eliminado
     * @return el chat eliminado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Chat eliminarChat(int idChat) throws PersistenciaException;

    /**
     * Consulta un chat en el sistema utilizando su identificador.
     *
     * @param idChat el identificador del chat a ser consultado
     * @return el chat encontrado, o null si no se encuentra ningún chat con ese
     * identificador
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Chat consultarChat(int idChat) throws PersistenciaException;
}
