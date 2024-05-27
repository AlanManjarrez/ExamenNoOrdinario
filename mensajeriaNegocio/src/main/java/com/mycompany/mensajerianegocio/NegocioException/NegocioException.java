/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajerianegocio.NegocioException;

/**
 * Excepción personalizada para representar errores en la lógica de negocio.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class NegocioException extends Exception {

    /**
     * Constructor por defecto
     */
    public NegocioException() {
    }

    /**
     * Constructor que recibe un mensaje de error.
     *
     * @param message el mensaje de error
     */
    public NegocioException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje de error y una causa.
     *
     * @param message el mensaje de error
     * @param cause la causa de la excepción
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que recibe una causa de la excepción.
     *
     * @param cause la causa de la excepción
     */
    public NegocioException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que recibe un mensaje de error, una causa, y especifica si se
     * debe habilitar la supresión y si el rastreo es modificable.
     *
     * @param message el mensaje de error
     * @param cause la causa de la excepción
     * @param enableSuppression especifica si se debe habilitar la supresión
     * @param writableStackTrace especifica si el rastreo es modificable
     */
    public NegocioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
