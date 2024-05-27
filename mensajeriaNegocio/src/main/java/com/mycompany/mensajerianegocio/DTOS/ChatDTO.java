/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajerianegocio.DTOS;

/**
 * Clase que representa el Data Transfer Object (DTO) para la entidad Chat.
 * 
 * Esta clase se utiliza para transferir datos de chat entre las capas de la aplicación 
 * sin exponer directamente la entidad del modelo de datos. Incluye propiedades básicas del chat 
 * como idChat y nombreUsuario.
 * 
 * Los objetos de esta clase son utilizados para encapsular y transportar datos relacionados 
 * con el chat a través de los diferentes componentes del sistema.
 * 
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class ChatDTO {
    private int idChat;
    private String nombreUsuario;

    /**
     * Constructor por defecto de la clase ChatDTO.
     */
    public ChatDTO() {
    }

    /**
     * Constructor de la clase ChatDTO con el nombre de usuario.
     *
     * @param nombreUsuario el nombre de usuario asociado al chatDTO
     */
    public ChatDTO(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Constructor de la clase ChatDTO con el identificador de chat y el nombre de
     * usuario.
     *
     * @param idChat el identificador del chatDTO
     * @param nombreUsuario el nombre de usuario asociado al chatDTO
     */
    public ChatDTO(int idChat, String nombreUsuario) {
        this.idChat = idChat;
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene el identificador del chatDTO.
     *
     * @return el identificador del chatDTO
     */
    public int getIdChat() {
        return idChat;
    }

    /**
     * Establece el identificador del chatDTO.
     *
     * @param idChat el nuevo identificador del chatDTO
     */
    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    /**
     * Obtiene el nombre de usuario asociado al chatDTO.
     *
     * @return el nombre de usuario asociado al chatDTO
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre de usuario asociado al chatDTO.
     *
     * @param nombreUsuario el nuevo nombre de usuario asociado al chatDTO
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Devuelve una representación de cadena del objeto ChatDTO.
     *
     * @return una cadena que representa el objeto ChatDTO, que incluye todos los
     * atributos
     */
    @Override
    public String toString() {
        return "Chat{" + "idChat=" + idChat + ", nombreUsuario=" + nombreUsuario + '}';
    }
}
