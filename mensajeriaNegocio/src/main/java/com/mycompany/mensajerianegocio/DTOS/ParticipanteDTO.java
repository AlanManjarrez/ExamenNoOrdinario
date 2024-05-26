/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajerianegocio.DTOS;

/**
 * Clase que representa el Data Transfer Object (DTO) para la entidad
 * Participante.
 * 
 * Esta clase se utiliza para transferir datos de participante entre las capas
 * de la aplicación sin exponer directamente la entidad del modelo de datos.
 * Incluye propiedades básicas del participante como idParticipantes, idUsuario
 * y idChat.
 * 
 * Los objetos de esta clase son utilizados para encapsular y transportar datos
 * relacionados con el participante a través de los diferentes componentes del
 * sistema.
 *
 * @autor Jose Alan Manjarrez Ontiveros 228982
 */
public class ParticipanteDTO {

    private int idParticipantes;
    private int idUsuario;
    private int idChat;

    /**
     * Constructor por defecto de la clase ParticipanteDTO.
     */
    public ParticipanteDTO() {
    }

    /**
     * Constructor de la clase ParticipanteDTO con el identificador del usuario
     * y el identificador del chat.
     *
     * @param idUsuario el identificador del usuario
     * @param idChat el identificador del chat
     */
    public ParticipanteDTO(int idUsuario, int idChat) {
        this.idUsuario = idUsuario;
        this.idChat = idChat;
    }

    /**
     * Constructor de la clase ParticipanteDTO con el identificador, el
     * identificador del usuario y el identificador del chat.
     *
     * @param idParticipantes el identificador de los participanteDTO
     * @param idUsuario el identificador del usuario
     * @param idChat el identificador del chat
     */
    public ParticipanteDTO(int idParticipantes, int idUsuario, int idChat) {
        this.idParticipantes = idParticipantes;
        this.idUsuario = idUsuario;
        this.idChat = idChat;
    }

    /**
     * Obtiene el identificador del participanteDTO.
     *
     * @return el identificador del participanteDTO
     */
    public int getIdParticipantes() {
        return idParticipantes;
    }

    /**
     * Establece el identificador de los participantesDTO.
     *
     * @param idParticipantes el nuevo identificador de los participantesDTO
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
     * Devuelve una representación de cadena del objeto ParticipanteDTO.
     *
     * @return una cadena que representa el objeto Participante, que incluye
     * todos los atributos
     */
    @Override
    public String toString() {
        return "Participantes{" + "idParticipantes=" + idParticipantes + ", idUsuario=" + idUsuario + ", idChat=" + idChat + '}';
    }
}
