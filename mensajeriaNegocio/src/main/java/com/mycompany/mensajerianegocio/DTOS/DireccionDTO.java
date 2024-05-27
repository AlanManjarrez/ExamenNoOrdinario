/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajerianegocio.DTOS;

/**
 * Clase que representa el Data Transfer Object (DTO) para la entidad Direccion.
 *
 * Esta clase se utiliza para transferir datos de dirección entre las capas de
 * la aplicación sin exponer directamente la entidad del modelo de datos.
 * Incluye propiedades básicas de la dirección como idDireccion, calle, numero,
 * codigoPostal e idUsuario.
 *
 * Los objetos de esta clase son utilizados para encapsular y transportar datos
 * relacionados con la dirección a través de los diferentes componentes del
 * sistema.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class DireccionDTO {

    private int idDireccion;
    private String calle;
    private String numero;
    private String codigoPostal;
    private int idUsuario;

    /**
     * Constructor por defecto de la clase DireccionDTO.
     */
    public DireccionDTO() {
    }

    /**
     * Constructor de la clase DireccionDTO con la calle, número, código postal
     * y el identificador del usuario.
     *
     * @param calle la calle de la direcciónDTO
     * @param numero el número de la direcciónDTO
     * @param codigoPostal el código postal de la direcciónDTO
     * @param idUsuario el identificador del usuario asociado a la direcciónDTO
     */
    public DireccionDTO(String calle, String numero, String codigoPostal, int idUsuario) {
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.idUsuario = idUsuario;
    }

    /**
     * Constructor que inicializa los atributos calle, número y código postal de
     * la dirección.
     *
     * @param calle la calle de la dirección
     * @param numero el número de la dirección
     * @param codigoPostal el código postal de la dirección
     */
    public DireccionDTO(String calle, String numero, String codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Obtiene el identificador de la direcciónDTO.
     *
     * @return el identificador de la direcciónDTO
     */
    public int getIdDireccion() {
        return idDireccion;
    }

    /**
     * Establece el identificador de la direcciónDTO.
     *
     * @param idDireccion el nuevo identificador de la direcciónDTO
     */
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * Obtiene la calle de la direcciónDTO.
     *
     * @return la calle de la direcciónDTO
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la direcciónDTO.
     *
     * @param calle la nueva calle de la direcciónDTO
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el número de la direcciónDTO.
     *
     * @return el número de la direcciónDTO
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de la direcciónDTO.
     *
     * @param numero el nuevo número de la direcciónDTO
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el código postal de la direcciónDTO.
     *
     * @return el código postal de la direcciónDTO
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal de la direcciónDTO.
     *
     * @param codigoPostal el nuevo código postal de la direcciónDTO
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Obtiene el identificador del usuario asociado a la direcciónDTO.
     *
     * @return el identificador del usuario asociado a la direcciónDTO
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador del usuario asociado a la direcciónDTO.
     *
     * @param idUsuario el nuevo identificador del usuario asociado a la
     * direcciónDTO
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Devuelve una representación de cadena del objeto DireccionDTO.
     *
     * @return una cadena que representa el objeto DireccionDTO, que incluye
     * todos los atributos
     */
    @Override
    public String toString() {
        return "Direccion{" + "idDireccion=" + idDireccion + ", calle=" + calle + ", numero=" + numero + ", codigoPostal=" + codigoPostal + ", idUsuario=" + idUsuario + '}';
    }

}
