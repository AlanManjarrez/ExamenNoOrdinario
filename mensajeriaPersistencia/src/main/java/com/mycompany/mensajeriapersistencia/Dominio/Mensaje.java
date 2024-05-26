/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajeriapersistencia.Dominio;

/**
 * Clase que representa un mensaje en un chat del sistema.
 *
 * Esta clase encapsula los datos asociados a un mensaje, como su identificador,
 * el texto del mensaje, la fecha y hora de registro, la URL de una imagen
 * asociada, el identificador del usuario que envió el mensaje y el
 * identificador del chat al que pertenece el mensaje.
 *
 * Los objetos de esta clase pueden ser utilizados para almacenar y manipular
 * información de mensajes en el sistema.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class Mensaje {

    private int idMensaje;
    private String texto;
    private String fechaHoraRegistro;
    private String imagenMensaje;
    private int idUsuario;
    private int idChat;

    /**
     * Constructor por defecto de la clase Mensaje.
     */
    public Mensaje() {
    }

    /**
     * Constructor de la clase Mensaje con el texto del mensaje, la fecha y hora
     * de registro, la URL de una imagen asociada, el identificador del usuario
     * y el identificador del chat.
     *
     * @param texto el texto del mensaje
     * @param fechaHoraRegistro la fecha y hora de registro del mensaje
     * @param imagenMensaje la URL de una imagen asociada al mensaje
     * @param idUsuario el identificador del usuario que envió el mensaje
     * @param idChat el identificador del chat al que pertenece el mensaje
     */
    public Mensaje(String texto, String fechaHoraRegistro, String imagenMensaje, int idUsuario, int idChat) {
        this.texto = texto;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.imagenMensaje = imagenMensaje;
        this.idUsuario = idUsuario;
        this.idChat = idChat;
    }

    /**
     * Constructor de la clase Mensaje con el identificador del mensaje, el
     * texto del mensaje, la fecha y hora de registro, la URL de una imagen
     * asociada, el identificador del usuario y el identificador del chat.
     *
     * @param idMensaje el identificador del mensaje
     * @param texto el texto del mensaje
     * @param fechaHoraRegistro la fecha y hora de registro del mensaje
     * @param imagenMensaje la URL de una imagen asociada al mensaje
     * @param idUsuario el identificador del usuario que envió el mensaje
     * @param idChat el identificador del chat al que pertenece el mensaje
     */
    public Mensaje(int idMensaje, String texto, String fechaHoraRegistro, String imagenMensaje, int idUsuario, int idChat) {
        this.idMensaje = idMensaje;
        this.texto = texto;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.imagenMensaje = imagenMensaje;
        this.idUsuario = idUsuario;
        this.idChat = idChat;
    }

    /**
     * Constructor de la clase Mensaje con el identificador del mensaje y el
     * texto del mensaje
     *
     * @param idMensaje el identificador del mensaje
     * @param texto el texto del mensaje
     */
    public Mensaje(int idMensaje, String texto) {
        this.idMensaje = idMensaje;
        this.texto = texto;
    }
       /**
     * Constructor de la clase Mensaje con el identificador del mensaje, el
     * texto del mensaje, la fecha y hora de registro y la URL de una imagen
     * asociada.
     *
     * @param idMensaje el identificador del mensaje
     * @param texto el texto del mensaje
     * @param fechaHoraRegistro la fecha y hora de registro del mensaje
     * @param imagenMensaje la URL de una imagen asociada al mensaje
     */
    public Mensaje(int idMensaje, String texto, String fechaHoraRegistro, String imagenMensaje) {
        this.idMensaje = idMensaje;
        this.texto = texto;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.imagenMensaje = imagenMensaje;
    }

    /**
     * Obtiene el identificador del mensaje.
     *
     * @return el identificador del mensaje
     */
    public int getIdMensaje() {
        return idMensaje;
    }

    /**
     * Establece el identificador del mensaje.
     *
     * @param idMensaje el nuevo identificador del mensaje
     */
    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    /**
     * Obtiene el texto del mensaje.
     *
     * @return el texto del mensaje
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Establece el texto del mensaje.
     *
     * @param texto el nuevo texto del mensaje
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Obtiene la fecha y hora de registro del mensaje.
     *
     * @return la fecha y hora de registro del mensaje
     */
    public String getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    /**
     * Establece la fecha y hora de registro del mensaje.
     *
     * @param fechaHoraRegistro la nueva fecha y hora de registro del mensaje
     */
    public void setFechaHoraRegistro(String fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    /**
     * Obtiene la URL de la imagen asociada al mensaje.
     *
     * @return la URL de la imagen asociada al mensaje
     */
    public String getImagenMensaje() {
        return imagenMensaje;
    }

    /**
     * Establece la URL de la imagen asociada al mensaje.
     *
     * @param imagenMensaje la nueva URL de la imagen asociada al mensaje
     */
    public void setImagenMensaje(String imagenMensaje) {
        this.imagenMensaje = imagenMensaje;
    }

    /**
     * Obtiene el identificador del usuario que envió el mensaje.
     *
     * @return el identificador del usuario que envió el mensaje
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador del usuario que envió el mensaje.
     *
     * @param idUsuario el nuevo identificador del usuario que envió el mensaje
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el identificador del chat al que pertenece el mensaje.
     *
     * @return el identificador del chat al que pertenece el mensaje
     */
    public int getIdChat() {
        return idChat;
    }

    /**
     * Establece el identificador del chat al que pertenece el mensaje.
     *
     * @param idChat el nuevo identificador del chat al que pertenece el mensaje
     */
    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    /**
     * Devuelve una representación de cadena del objeto Mensaje.
     *
     * @return una cadena que representa el objeto Mensaje, que incluye todos
     * los atributos
     */
    @Override
    public String toString() {
        return "Mensaje{" + "idMensaje=" + idMensaje + ", texto=" + texto + ", fechaHoraRegistro=" + fechaHoraRegistro + ", imagenMensaje=" + imagenMensaje + ", idUsuario=" + idUsuario + ", idChat=" + idChat + '}';
    }

}
