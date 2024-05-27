/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajerianegocio.BO;

import com.mycompany.mensajerianegocio.DTOS.ChatDTO;
import com.mycompany.mensajerianegocio.DTOS.ChatNuevoDTO;
import com.mycompany.mensajeriapersistencia.DAOS.ChatDAO;
import com.mycompany.mensajeriapersistencia.DAOS.IChatDAO;
import com.mycompany.mensajeriapersistencia.DAOS.IParticipanteDAO;
import com.mycompany.mensajeriapersistencia.DAOS.IUsuarioDAO;
import com.mycompany.mensajeriapersistencia.DAOS.ParticipanteDAO;
import com.mycompany.mensajeriapersistencia.DAOS.UsuarioDAO;
import com.mycompany.mensajeriapersistencia.Dominio.Chat;
import com.mycompany.mensajeriapersistencia.Dominio.Participante;
import com.mycompany.mensajeriapersistencia.Dominio.Usuario;

/**
 *
 * @author uirtis
 */
public class ChatBO implements IChatBO {
    
    private IUsuarioDAO usuarioDAO;
    private IChatDAO chatDAO;
    private IParticipanteDAO participanteDAO;

    public ChatBO() {
        this.usuarioDAO = new UsuarioDAO();
        this.chatDAO = new ChatDAO();
        this.participanteDAO = new ParticipanteDAO();
    }
    
    
    
    public Chat convertirEntidadChat(ChatDTO chatDTO) {
        Chat chat = new Chat(chatDTO.getNombreUsuario());
        return chat;
    }

    public ChatDTO convertirDTOChat(Chat chat) {
        ChatDTO chatDTO = new ChatDTO();
        chatDTO.setNombreUsuario(chat.getNombreUsuario());
        return chatDTO;
    }
    
    
    @Override
    public ChatDTO agregarChat(ChatNuevoDTO chatNuevoDTO) throws Exception {
        Usuario usuario = usuarioDAO.consultarUsuarioTelefono(chatNuevoDTO.getTelefonoReceptor()).get(0);
        Chat chat = new Chat(chatNuevoDTO.getNombreChat());
        Chat chatCreado = chatDAO.agregarChat(chat);
        System.out.println(chatCreado.getIdChat());
        
        Participante participante1 = new Participante(usuario.getIdUsuario(), chatCreado.getIdChat());
        Participante participante2 = new Participante(chatNuevoDTO.getIdRemitente(), chatCreado.getIdChat());
        
        participanteDAO.agregarParticipante(participante1);
        participanteDAO.agregarParticipante(participante2);
        
        return convertirDTOChat(chat);
    }
    
}
