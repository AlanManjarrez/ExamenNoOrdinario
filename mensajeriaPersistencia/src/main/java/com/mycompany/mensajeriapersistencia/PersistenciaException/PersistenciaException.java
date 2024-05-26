/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajeriapersistencia.PersistenciaException;

/**
 * Excepción personalizada para errores relacionados con la persistencia de
 * datos en el sistema.
 *
 * Esta excepción se utiliza para manejar situaciones excepcionales que pueden
 * ocurrir durante operaciones de persistencia de datos, como errores de
 * conexión a la base de datos o problemas al realizar consultas.
 *
 * Puede ser lanzada por métodos en clases de persistencia para indicar errores
 * específicos relacionados con la persistencia de datos.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor por defecto de la clase PersistenciaException.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor de la clase PersistenciaException con un mensaje de detalle.
     *
     * Crea una nueva instancia de PersistenciaException con el mensaje de
     * detalle especificado.
     *
     * @param message el mensaje de detalle de la excepción
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor de la clase PersistenciaException con un mensaje de detalle y
     * una causa.
     *
     * Crea una nueva instancia de PersistenciaException con el mensaje de
     * detalle y la causa especificados.
     *
     * @param message el mensaje de detalle de la excepción
     * @param cause la causa de la excepción
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor de la clase PersistenciaException con una causa.
     *
     * Crea una nueva instancia de PersistenciaException con la causa
     * especificada.
     *
     * @param cause la causa de la excepción
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor de la clase PersistenciaException con un mensaje de detalle,
     * una causa, habilitación de supresión y habilitación de escritura de
     * traza.
     * 
     * Crea una nueva instancia de PersistenciaException con el mensaje de
     * detalle, la causa, la habilitación de supresión y la habilitación de
     * escritura de traza especificados.
     *
     * @param message el mensaje de detalle de la excepción
     * @param cause la causa de la excepción
     * @param enableSuppression habilitación de supresión
     * @param writableStackTrace habilitación de escritura de traza
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
