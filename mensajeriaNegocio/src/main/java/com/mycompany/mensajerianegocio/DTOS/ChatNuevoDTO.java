/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajerianegocio.DTOS;

/**
 *
 * @author uirtis
 */
public class ChatNuevoDTO {
    private int idChatNuevo;
    private int idRemitente;
    private String telefonoReceptor;
    private String nombreChat;

    public ChatNuevoDTO() {
    }

    public int getIdChatNuevo() {
        return idChatNuevo;
    }

    public void setIdChatNuevo(int idChatNuevo) {
        this.idChatNuevo = idChatNuevo;
    }

    public int getIdRemitente() {
        return idRemitente;
    }

    public void setIdRemitente(int idRemitente) {
        this.idRemitente = idRemitente;
    }

    public String getTelefonoReceptor() {
        return telefonoReceptor;
    }

    public void setTelefonoReceptor(String telefonoReceptor) {
        this.telefonoReceptor = telefonoReceptor;
    }

    public String getNombreChat() {
        return nombreChat;
    }

    public void setNombreChat(String nombreChat) {
        this.nombreChat = nombreChat;
    }

    @Override
    public String toString() {
        return "ChatNuevoDTO{" + "idChatNuevo=" + idChatNuevo + ", idRemitente=" + idRemitente + ", telefonoReceptor=" + telefonoReceptor + ", nombreChat=" + nombreChat + '}';
    }
    
    
    
}
