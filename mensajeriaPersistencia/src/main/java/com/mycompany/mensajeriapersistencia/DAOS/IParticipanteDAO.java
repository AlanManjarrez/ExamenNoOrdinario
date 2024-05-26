/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mensajeriapersistencia.DAOS;

import com.mycompany.mensajeriapersistencia.Dominio.Participante;
import com.mycompany.mensajeriapersistencia.PersistenciaException.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Participante en el sistema.
 *
 * Esta interfaz proporciona métodos para agregar, actualizar, eliminar y
 * consultar participantes en la capa de persistencia de datos. Las
 * implementaciones de esta interfaz deben proporcionar la lógica específica
 * para interactuar con el almacenamiento de datos subyacente, como una base de
 * datos.
 *
 * Las excepciones de tipo {@link PersistenciaException} son lanzadas para
 * indicar problemas relacionados con la persistencia de datos durante la
 * ejecución de estas operaciones.
 *
 * @autor Jose Alan Manjarrez Ontiveros 228982
 */
public interface IParticipanteDAO {

    /**
     * Agrega un nuevo participante al sistema.
     *
     * @param participante el participante a ser agregado
     * @return el participante agregado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Participante agregarParticipante(Participante participante) throws PersistenciaException;

    /**
     * Actualiza los datos de un participante existente en el sistema.
     *
     * @param participante el participante con los datos actualizados
     * @return el participante actualizado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Participante actualizarParticipante(Participante participante) throws PersistenciaException;

    /**
     * Elimina un participante del sistema utilizando su identificador.
     *
     * @param idParticipante el identificador del participante a ser eliminado
     * @return el participante eliminado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Participante eliminarParticipante(int idParticipante) throws PersistenciaException;

    /**
     * Consulta un participante en el sistema utilizando su identificador.
     *
     * @param idParticipante el identificador del participante a ser consultado
     * @return una lista de participantes que coinciden con el identificador
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public List<Participante> consultarParticipante(int idParticipante) throws PersistenciaException;
}
