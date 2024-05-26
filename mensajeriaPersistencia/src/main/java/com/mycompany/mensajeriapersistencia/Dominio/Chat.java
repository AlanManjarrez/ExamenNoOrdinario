/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajeriapersistencia.Dominio;

/**
 * Clase que representa un chat en el sistema.
 *
 * Esta clase encapsula los datos asociados a un chat, como su identificador y
 * el nombre de usuario asociado.
 *
 * Los objetos de esta clase pueden ser utilizados para almacenar y manipular
 * información de chats en el sistema.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class Chat {

    private int idChat;
    private String nombreUsuario;

    /**
     * Constructor por defecto de la clase Chat.
     */
    public Chat() {
    }

    /**
     * Constructor de la clase Chat con el nombre de usuario.
     *
     * @param nombreUsuario el nombre de usuario asociado al chat
     */
    public Chat(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Constructor de la clase Chat con el identificador de chat y el nombre de
     * usuario.
     *
     * @param idChat el identificador del chat
     * @param nombreUsuario el nombre de usuario asociado al chat
     */
    public Chat(int idChat, String nombreUsuario) {
        this.idChat = idChat;
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene el identificador del chat.
     *
     * @return el identificador del chat
     */
    public int getIdChat() {
        return idChat;
    }

    /**
     * Establece el identificador del chat.
     *
     * @param idChat el nuevo identificador del chat
     */
    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    /**
     * Obtiene el nombre de usuario asociado al chat.
     *
     * @return el nombre de usuario asociado al chat
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre de usuario asociado al chat.
     *
     * @param nombreUsuario el nuevo nombre de usuario asociado al chat
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Devuelve una representación de cadena del objeto Chat.
     *
     * @return una cadena que representa el objeto Chat, que incluye todos los
     * atributos
     */
    @Override
    public String toString() {
        return "Chat{" + "idChat=" + idChat + ", nombreUsuario=" + nombreUsuario + '}';
    }

}
