/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajerianegocio.BO;

import com.mycompany.mensajerianegocio.DTOS.ChatDTO;
import com.mycompany.mensajerianegocio.DTOS.ChatNuevoDTO;
import com.mycompany.mensajerianegocio.DTOS.MensajeDTO;
import com.mycompany.mensajerianegocio.DTOS.MensajeNuevoDTO;
import com.mycompany.mensajerianegocio.DTOS.ParticipanteDTO;
import com.mycompany.mensajeriapersistencia.DAOS.ChatDAO;
import com.mycompany.mensajeriapersistencia.DAOS.IChatDAO;
import com.mycompany.mensajeriapersistencia.DAOS.IMensajeDAO;
import com.mycompany.mensajeriapersistencia.DAOS.IParticipanteDAO;
import com.mycompany.mensajeriapersistencia.DAOS.IUsuarioDAO;
import com.mycompany.mensajeriapersistencia.DAOS.MensajeDAO;
import com.mycompany.mensajeriapersistencia.DAOS.ParticipanteDAO;
import com.mycompany.mensajeriapersistencia.DAOS.UsuarioDAO;
import com.mycompany.mensajeriapersistencia.Dominio.Chat;
import com.mycompany.mensajeriapersistencia.Dominio.Mensaje;
import com.mycompany.mensajeriapersistencia.Dominio.Participante;
import com.mycompany.mensajeriapersistencia.Dominio.Usuario;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author uirtis
 */
public class ChatBO implements IChatBO {

    private IUsuarioDAO usuarioDAO;
    private IChatDAO chatDAO;
    private IParticipanteDAO participanteDAO;
    private IMensajeDAO mensajeDAO;

    public ChatBO() {
        this.usuarioDAO = new UsuarioDAO();
        this.chatDAO = new ChatDAO();
        this.participanteDAO = new ParticipanteDAO();
        this.mensajeDAO = new MensajeDAO();
    }

    public Chat convertirEntidadChat(ChatDTO chatDTO) {
        Chat chat = new Chat(chatDTO.getNombreUsuario());
        if (chatDTO.getIdChat() > 0) {
            chat.setIdChat(chatDTO.getIdChat());
        }
        return chat;
    }

    public ChatDTO convertirDTOChat(Chat chat) {
        ChatDTO chatDTO = new ChatDTO();
        chatDTO.setNombreUsuario(chat.getNombreUsuario());
        if (chat.getIdChat() > 0) {
            chatDTO.setIdChat(chat.getIdChat());
        }
        return chatDTO;
    }

    public static MensajeDTO convertirAMensajeDTO(Mensaje mensaje) {
        MensajeDTO mensajeDTO = new MensajeDTO();
        mensajeDTO.setIdChat(mensaje.getIdChat());
        mensajeDTO.setIdMensaje(mensaje.getIdMensaje());
        mensajeDTO.setTexto(mensaje.getTexto());
        mensajeDTO.setImagenMensaje(mensaje.getImagenMensaje());
        mensajeDTO.setFechaHoraRegistro(mensaje.getFechaHoraRegistro());
        mensajeDTO.setIdUsuario(mensaje.getIdUsuario());
        return mensajeDTO;
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

    @Override
    public List<ChatDTO> consultarChat(int idParticipante) throws Exception {
        List<Participante> participantes = participanteDAO.consultarParticipante(idParticipante);
        List<ChatDTO> listaChats = new ArrayList<>();

        System.out.println(participantes);

        for (Participante participante : participantes) {
            listaChats.add(convertirDTOChat(chatDAO.consultarChat(participante.getIdChat())));
        }
        return listaChats;
    }

    @Override
    public List<Participante> consultarParticipante(int idParticipante) throws Exception {
        return participanteDAO.consultarParticipante(idParticipante);
    }

    @Override
    public MensajeDTO agregarMensaje(MensajeNuevoDTO mensajeDTO) throws Exception {

        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String formattedDate = sdf.format(date);

        Mensaje mensaje = new Mensaje();
        mensaje.setIdChat(mensajeDTO.getIdChat());
        mensaje.setTexto(mensajeDTO.getTexto());
        mensaje.setImagenMensaje(mensajeDTO.getImagenMensaje());
        mensaje.setFechaHoraRegistro(formattedDate);
        mensaje.setIdUsuario(mensajeDTO.getIdUsuario());

        Mensaje mensajeCreado = mensajeDAO.agregarMensaje(mensaje);
        return convertirAMensajeDTO(mensajeCreado);
    }

    @Override
    public List<MensajeDTO> consultarMensajesChat(int idChat) throws Exception {
        
        List<MensajeDTO> mensajes = new ArrayList<>();
        for (Mensaje mensaje : mensajeDAO.consultarMensajeChat(idChat)) {
            mensajes.add(convertirAMensajeDTO(mensaje));
        }
        return mensajes;
    }

}
