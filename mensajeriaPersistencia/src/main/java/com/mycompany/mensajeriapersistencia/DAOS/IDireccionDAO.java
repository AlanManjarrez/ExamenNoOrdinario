/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mensajeriapersistencia.DAOS;

import com.mycompany.mensajeriapersistencia.Dominio.Direccion;
import com.mycompany.mensajeriapersistencia.PersistenciaException.PersistenciaException;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Dirección en el sistema.
 *
 * Esta interfaz proporciona métodos para agregar, actualizar y consultar
 * direcciones en la capa de persistencia de datos. Las implementaciones de esta
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
public interface IDireccionDAO {

    /**
     * Agrega una nueva dirección al sistema.
     *
     * @param direccion la dirección a ser agregada
     * @return la dirección agregada
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Direccion agregarDireccion(Direccion direccion) throws PersistenciaException;

    /**
     * Actualiza los datos de una dirección existente en el sistema.
     *
     * @param direccion la dirección con los datos actualizados
     * @return la dirección actualizada
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Direccion actualizarDireccion(Direccion direccion) throws PersistenciaException;

    /**
     * Consulta una dirección en el sistema utilizando el identificador del
     * usuario asociado.
     *
     * @param idUsuario el identificador del usuario asociado a la dirección
     * @return la dirección encontrada, o null si no se encuentra ninguna
     * dirección asociada al usuario
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Direccion consultarDireccion(int idUsuario) throws PersistenciaException;
}
