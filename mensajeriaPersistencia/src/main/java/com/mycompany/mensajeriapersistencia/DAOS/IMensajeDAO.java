/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mensajeriapersistencia.DAOS;

import com.mycompany.mensajeriapersistencia.Dominio.Mensaje;
import com.mycompany.mensajeriapersistencia.PersistenciaException.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Mensaje
 * en el sistema.
 *
 * Esta interfaz proporciona métodos para agregar, editar, eliminar y consultar
 * mensajes en la capa de persistencia de datos. Las implementaciones de esta
 * interfaz deben proporcionar la lógica específica para interactuar con el
 * almacenamiento de datos subyacente, como una base de datos.
 *
 * Las excepciones de tipo {@link PersistenciaException} son lanzadas para
 * indicar problemas relacionados con la persistencia de datos durante la
 * ejecución de estas operaciones.
 *
 * @autor Jose Alan Manjarrez Ontiveros 228982
 */
public interface IMensajeDAO {

    /**
     * Agrega un nuevo mensaje al sistema.
     *
     * @param mensaje el mensaje a ser agregado
     * @return el mensaje agregado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Mensaje agregarMensaje(Mensaje mensaje) throws PersistenciaException;

    /**
     * Edita un mensaje existente en el sistema.
     *
     * @param mensaje el mensaje con los datos actualizados
     * @return el mensaje editado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Mensaje editarMensaje(Mensaje mensaje) throws PersistenciaException;

    /**
     * Elimina un mensaje del sistema utilizando su identificador.
     *
     * @param idMensaje el identificador del mensaje a ser eliminado
     * @return el mensaje eliminado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Mensaje eliminarMensaje(int idMensaje) throws PersistenciaException;

    /**
     * Consulta mensajes en el sistema utilizando un texto de búsqueda.
     *
     * @param texto el texto a ser buscado en los mensajes
     * @return una lista de mensajes que coinciden con el texto de búsqueda
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public List<Mensaje> consultarMensaje(String texto) throws PersistenciaException;
}
