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
 * Clase que implementa la lógica de negocio para la gestión de chats.
 *
 * Esta clase maneja la creación, conversión y consulta de chats y sus
 * participantes, utilizando diferentes DAO para interactuar con la base de
 * datos.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class ChatBO implements IChatBO {

    private IUsuarioDAO usuarioDAO;
    private IChatDAO chatDAO;
    private IParticipanteDAO participanteDAO;
    private IMensajeDAO mensajeDAO;

    /**
     * Constructor por defecto que inicializa los DAOs necesarios.
     */
    public ChatBO() {
        this.usuarioDAO = new UsuarioDAO();
        this.chatDAO = new ChatDAO();
        this.participanteDAO = new ParticipanteDAO();
        this.mensajeDAO = new MensajeDAO();
    }

    /**
     * Convierte un objeto ChatDTO a una entidad Chat.
     *
     * @param chatDTO el DTO del chat a convertir
     * @return el objeto Chat convertido
     */
    public Chat convertirEntidadChat(ChatDTO chatDTO) {
        Chat chat = new Chat(chatDTO.getNombreUsuario());
        if (chatDTO.getIdChat() > 0) {
            chat.setIdChat(chatDTO.getIdChat());
        }
        return chat;
    }

    /**
     * Convierte una entidad Chat a un objeto ChatDTO.
     *
     * @param chat la entidad Chat a convertir
     * @return el objeto ChatDTO convertido
     */
    public ChatDTO convertirDTOChat(Chat chat) {
        ChatDTO chatDTO = new ChatDTO();
        chatDTO.setNombreUsuario(chat.getNombreUsuario());
        if (chat.getIdChat() > 0) {
            chatDTO.setIdChat(chat.getIdChat());
        }
        return chatDTO;
    }

    /**
     * Convierte una entidad Mensaje a un objeto MensajeDTO.
     *
     * @param mensaje la entidad Mensaje a convertir
     * @return el objeto MensajeDTO convertido
     */
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

    /**
     * Agrega un nuevo chat y sus participantes.
     *
     * @param chatNuevoDTO el DTO del nuevo chat a agregar
     * @return el objeto ChatDTO del chat agregado
     * @throws Exception si ocurre un error al agregar el chat
     */
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

    /**
     * Consulta todos los chats de un participante.
     *
     * @param idParticipante el identificador del participante
     * @return una lista de objetos ChatDTO
     * @throws Exception si ocurre un error al consultar los chats
     */
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

    /**
     * Consulta todos los participantes de un chat.
     *
     * @param idParticipante el identificador del participante
     * @return una lista de objetos Participante
     * @throws Exception si ocurre un error al consultar los participantes
     */
    @Override
    public List<Participante> consultarParticipante(int idParticipante) throws Exception {
        return participanteDAO.consultarParticipante(idParticipante);
    }

    /**
     * Agrega un nuevo mensaje a un chat.
     *
     * @param mensajeDTO el DTO del nuevo mensaje a agregar
     * @return el objeto MensajeDTO del mensaje agregado
     * @throws Exception si ocurre un error al agregar el mensaje
     */
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

    /**
     * Consulta todos los mensajes de un chat.
     *
     * @param idChat el identificador del chat
     * @return una lista de objetos MensajeDTO
     * @throws Exception si ocurre un error al consultar los mensajes
     */
    @Override
    public List<MensajeDTO> consultarMensajesChat(int idChat) throws Exception {

        List<MensajeDTO> mensajes = new ArrayList<>();
        for (Mensaje mensaje : mensajeDAO.consultarMensajeChat(idChat)) {
            mensajes.add(convertirAMensajeDTO(mensaje));
        }
        return mensajes;
    }

}
