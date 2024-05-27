/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajerianegocio.DTOS;

/**
 * Clase de transferencia de datos para la creación de un nuevo chat.
 *
 * Esta clase representa los datos necesarios para crear un nuevo chat,
 * incluyendo el identificador del remitente, el teléfono del receptor y el
 * nombre del chat.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class ChatNuevoDTO {

    private int idChatNuevo;
    private int idRemitente;
    private String telefonoReceptor;
    private String nombreChat;

    /**
     * Constructor por defecto.
     */
    public ChatNuevoDTO() {
    }

    /**
     * Obtiene el identificador del nuevo chat.
     *
     * @return el identificador del nuevo chat
     */
    public int getIdChatNuevo() {
        return idChatNuevo;
    }

    /**
     * Establece el identificador del nuevo chat.
     *
     * @param idChatNuevo el identificador del nuevo chat
     */
    public void setIdChatNuevo(int idChatNuevo) {
        this.idChatNuevo = idChatNuevo;
    }

    /**
     * Obtiene el identificador del remitente.
     *
     * @return el identificador del remitente
     */
    public int getIdRemitente() {
        return idRemitente;
    }

    /**
     * Establece el identificador del remitente.
     *
     * @param idRemitente el identificador del remitente
     */
    public void setIdRemitente(int idRemitente) {
        this.idRemitente = idRemitente;
    }

    /**
     * Obtiene el teléfono del receptor.
     *
     * @return el teléfono del receptor
     */
    public String getTelefonoReceptor() {
        return telefonoReceptor;
    }

    /**
     * Establece el teléfono del receptor.
     *
     * @param telefonoReceptor el teléfono del receptor
     */
    public void setTelefonoReceptor(String telefonoReceptor) {
        this.telefonoReceptor = telefonoReceptor;
    }

    /**
     * Obtiene el nombre del chat.
     *
     * @return el nombre del chat
     */
    public String getNombreChat() {
        return nombreChat;
    }

    /**
     * Establece el nombre del chat.
     *
     * @param nombreChat el nombre del chat
     */
    public void setNombreChat(String nombreChat) {
        this.nombreChat = nombreChat;
    }

    /**
     * Representación en cadena de la clase ChatNuevoDTO.
     *
     * @return una cadena que representa los datos del nuevo chat
     */
    @Override
    public String toString() {
        return "ChatNuevoDTO{" + "idChatNuevo=" + idChatNuevo + ", idRemitente=" + idRemitente + ", telefonoReceptor=" + telefonoReceptor + ", nombreChat=" + nombreChat + '}';
    }
}
