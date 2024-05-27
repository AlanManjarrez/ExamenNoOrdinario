/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajeriapersistencia.Dominio;

/**
 * Clase que representa una dirección asociada a un usuario en el sistema.
 *
 * Esta clase encapsula los datos asociados a una dirección, como su
 * identificador, calle, número, código postal y el identificador del usuario al
 * que pertenece la dirección.
 *
 * Los objetos de esta clase pueden ser utilizados para almacenar y manipular
 * información de direcciones en el sistema.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class Direccion {

    private int idDireccion;
    private String calle;
    private String numero;
    private String codigoPostal;
    private int idUsuario;

    /**
     * Constructor por defecto de la clase Direccion.
     */
    public Direccion() {
    }

    /**
     * Constructor de la clase Direccion con la calle, número, código postal y
     * el identificador del usuario.
     *
     * @param calle la calle de la dirección
     * @param numero el número de la dirección
     * @param codigoPostal el código postal de la dirección
     * @param idUsuario el identificador del usuario asociado a la dirección
     */
    public Direccion(String calle, String numero, String codigoPostal, int idUsuario) {
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.idUsuario = idUsuario;
    }

    /**
     * Constructor de la clase Direccion con el identificador, calle, número,
     * código postal y el identificador del usuario.
     *
     * @param idDireccion el identificador de la dirección
     * @param calle la calle de la dirección
     * @param numero el número de la dirección
     * @param codigoPostal el código postal de la dirección
     * @param idUsuario el identificador del usuario asociado a la dirección
     */
    public Direccion(int idDireccion, String calle, String numero, String codigoPostal, int idUsuario) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.idUsuario = idUsuario;
    }

    public Direccion(String calle, String numero, String codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Obtiene el identificador de la dirección.
     *
     * @return el identificador de la dirección
     */
    public int getIdDireccion() {
        return idDireccion;
    }

    /**
     * Establece el identificador de la dirección.
     *
     * @param idDireccion el nuevo identificador de la dirección
     */
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * Obtiene la calle de la dirección.
     *
     * @return la calle de la dirección
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la dirección.
     *
     * @param calle la nueva calle de la dirección
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el número de la dirección.
     *
     * @return el número de la dirección
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de la dirección.
     *
     * @param numero el nuevo número de la dirección
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el código postal de la dirección.
     *
     * @return el código postal de la dirección
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal de la dirección.
     *
     * @param codigoPostal el nuevo código postal de la dirección
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Obtiene el identificador del usuario asociado a la dirección.
     *
     * @return el identificador del usuario asociado a la dirección
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador del usuario asociado a la dirección.
     *
     * @param idUsuario el nuevo identificador del usuario asociado a la
     * dirección
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Devuelve una representación de cadena del objeto Direccion.
     *
     * @return una cadena que representa el objeto Direccion, que incluye todos
     * los atributos
     */
    @Override
    public String toString() {
        return "Direccion{" + "idDireccion=" + idDireccion + ", calle=" + calle + ", numero=" + numero + ", codigoPostal=" + codigoPostal + ", idUsuario=" + idUsuario + '}';
    }

}
