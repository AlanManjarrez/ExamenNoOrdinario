/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajeriapersistencia.Dominio;

/**
 * Clase que representa la relación entre usuarios y chats en el sistema.
 *
 * Esta clase encapsula los datos asociados a la participación de un usuario en
 * un chat, como su identificador, el identificador del usuario y el
 * identificador del chat.
 *
 * Los objetos de esta clase pueden ser utilizados para almacenar y manipular
 * información sobre los participantes en los chats del sistema.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class Participantes {

    private int idParticipantes;
    private int idUsuario;
    private int idChat;

    /**
     * Constructor por defecto de la clase Participantes.
     */
    public Participantes() {
    }

    /**
     * Constructor de la clase Participantes con el identificador del usuario y
     * el identificador del chat.
     *
     * @param idUsuario el identificador del usuario
     * @param idChat el identificador del chat
     */
    public Participantes(int idUsuario, int idChat) {
        this.idUsuario = idUsuario;
        this.idChat = idChat;
    }

    /**
     * Constructor de la clase Participantes con el identificador, el
     * identificador del usuario y el identificador del chat.
     *
     * @param idParticipantes el identificador de los participantes
     * @param idUsuario el identificador del usuario
     * @param idChat el identificador del chat
     */
    public Participantes(int idParticipantes, int idUsuario, int idChat) {
        this.idParticipantes = idParticipantes;
        this.idUsuario = idUsuario;
        this.idChat = idChat;
    }

    /**
     * Obtiene el identificador de los participantes.
     *
     * @return el identificador de los participantes
     */
    public int getIdParticipantes() {
        return idParticipantes;
    }

    /**
     * Establece el identificador de los participantes.
     *
     * @param idParticipantes el nuevo identificador de los participantes
     */
    public void setIdParticipantes(int idParticipantes) {
        this.idParticipantes = idParticipantes;
    }

    /**
     * Obtiene el identificador del usuario.
     *
     * @return el identificador del usuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param idUsuario el nuevo identificador del usuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
     * Devuelve una representación de cadena del objeto Participantes.
     *
     * @return una cadena que representa el objeto Participantes, que incluye
     * todos los atributos
     */
    @Override
    public String toString() {
        return "Participantes{" + "idParticipantes=" + idParticipantes + ", idUsuario=" + idUsuario + ", idChat=" + idChat + '}';
    }
}
