/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajerianegocio.DTOS;

/**
 * Clase de transferencia de datos para la creación de un nuevo mensaje.
 * 
 * Esta clase representa los datos necesarios para crear un nuevo mensaje, 
 * incluyendo el texto del mensaje, la fecha y hora de registro, la imagen del mensaje, 
 * el identificador del usuario y el identificador del chat al que pertenece.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class MensajeNuevoDTO {

    private int idMensaje;
    private String texto;
    private String fechaHoraRegistro;
    private byte[] imagenMensaje;
    private int idUsuario;
    private int idChat;

    /**
     * Constructor por defecto de la clase MensajeDTO.
     */
    public MensajeNuevoDTO() {
    }

    /**
     * Constructor de la clase MensajeDTO con el texto del mensaje, la fecha y
     * hora de registro, la URL de una imagen asociada, el identificador del
     * usuario y el identificador del chat.
     *
     * @param texto el texto del mensajeDTO
     * @param fechaHoraRegistro la fecha y hora de registro del mensajeDTO
     * @param imagenMensaje la URL de una imagen asociada al mensajeDTO
     * @param idUsuario el identificador del usuario que envió el mensajeDTO
     * @param idChat el identificador del chat al que pertenece el mensajeDTO
     */
    public MensajeNuevoDTO(String texto, String fechaHoraRegistro, byte[] imagenMensaje, int idUsuario, int idChat) {
        this.texto = texto;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.imagenMensaje = imagenMensaje;
        this.idUsuario = idUsuario;
        this.idChat = idChat;
    }

    /**
     * Constructor de la clase MensajeDTO con el identificador del mensaje y el
     * texto del mensaje
     *
     * @param idMensaje el identificador del mensajeDTO
     * @param texto el texto del mensajeDTO
     */
    public MensajeNuevoDTO(int idMensaje, String texto) {
        this.idMensaje = idMensaje;
        this.texto = texto;
    }

    /**
     * Constructor de la clase MensajeDTO con el identificador del mensaje, el
     * texto del mensaje, la fecha y hora de registro y la URL de una imagen
     * asociada.
     *
     * @param idMensaje el identificador del mensajeDTO
     * @param texto el texto del mensajeDTO
     * @param fechaHoraRegistro la fecha y hora de registro del mensajeDTO
     * @param imagenMensaje la URL de una imagen asociada al mensajeDTO
     */
    public MensajeNuevoDTO(int idMensaje, String texto, String fechaHoraRegistro, byte[] imagenMensaje) {
        this.idMensaje = idMensaje;
        this.texto = texto;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.imagenMensaje = imagenMensaje;
    }

    /**
     * Obtiene el identificador del mensajeDTO.
     *
     * @return el identificador del mensajeDTO
     */
    public int getIdMensaje() {
        return idMensaje;
    }

    /**
     * Establece el identificador del mensajeDTO.
     *
     * @param idMensaje el nuevo identificador del mensajeDTO
     */
    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    /**
     * Obtiene el texto del mensajeDTO.
     *
     * @return el texto del mensajeDTO
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Establece el texto del mensajeDTO.
     *
     * @param texto el nuevo texto del mensajeDTO
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Obtiene la fecha y hora de registro del mensajeDTO.
     *
     * @return la fecha y hora de registro del mensajeDTO
     */
    public String getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    /**
     * Establece la fecha y hora de registro del mensajeDTO.
     *
     * @param fechaHoraRegistro la nueva fecha y hora de registro del mensajeDTO
     */
    public void setFechaHoraRegistro(String fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    /**
     * Obtiene la URL de la imagen asociada al mensajeDTO.
     *
     * @return la URL de la imagen asociada al mensajeDTO
     */
    public byte[] getImagenMensaje() {
        return imagenMensaje;
    }

    /**
     * Establece la URL de la imagen asociada al mensajeDTO.
     *
     * @param imagenMensaje la nueva URL de la imagen asociada al mensajeDTO
     */
    public void setImagenMensaje(byte[] imagenMensaje) {
        this.imagenMensaje = imagenMensaje;
    }

    /**
     * Obtiene el identificador del usuario que envió el mensajeDTO.
     *
     * @return el identificador del usuario que envió el mensajeDTO
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador del usuario que envió el mensajeDTO.
     *
     * @param idUsuario el nuevo identificador del usuario que envió el
     * mensajeDTO
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el identificador del chat al que pertenece el mensajeDTO.
     *
     * @return el identificador del chat al que pertenece el mensajeDTO
     */
    public int getIdChat() {
        return idChat;
    }

    /**
     * Establece el identificador del chat al que pertenece el mensajeDTO.
     *
     * @param idChat el nuevo identificador del chat al que pertenece el
     * mensajeDTO
     */
    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    /**
     * Devuelve una representación de cadena del objeto MensajeDTO.
     *
     * @return una cadena que representa el objeto Mensaje, que incluye todos
     * los atributos
     */
    @Override
    public String toString() {
        return "Mensaje{" + "idMensaje=" + idMensaje + ", texto=" + texto + ", fechaHoraRegistro=" + fechaHoraRegistro + ", imagenMensaje=" + imagenMensaje + ", idUsuario=" + idUsuario + ", idChat=" + idChat + '}';
    }
}
