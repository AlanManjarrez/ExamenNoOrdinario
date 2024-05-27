/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mensajerianegocio.BO;

import com.mycompany.mensajerianegocio.DTOS.ChatDTO;
import com.mycompany.mensajerianegocio.DTOS.ChatNuevoDTO;
import com.mycompany.mensajerianegocio.DTOS.MensajeDTO;
import com.mycompany.mensajerianegocio.DTOS.MensajeNuevoDTO;
import com.mycompany.mensajerianegocio.DTOS.ParticipanteDTO;
import com.mycompany.mensajeriapersistencia.Dominio.Chat;
import com.mycompany.mensajeriapersistencia.Dominio.Participante;
import java.util.List;

/**
 * Interfaz para la lógica de negocio relacionada con los chats.
 *
 * Define los métodos para agregar chats, consultar chats por participante,
 * consultar participantes, agregar mensajes y consultar mensajes de un chat.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public interface IChatBO {

    /**
     * Agrega un nuevo chat.
     *
     * @param chatNuevoDTO el DTO con la información del nuevo chat
     * @return el DTO del chat agregado
     * @throws Exception si ocurre un error al agregar el chat
     */
    public ChatDTO agregarChat(ChatNuevoDTO chatNuevoDTO) throws Exception;
    
    /**
     * Consulta los chats de un participante.
     * 
     * @param idParticipante el ID del participante
     * @return una lista de DTOs de los chats del participante
     * @throws Exception si ocurre un error al consultar los chats
     */
    public List<ChatDTO> consultarChat(int idParticipante) throws Exception;
    
    /**
     * Consulta los participantes de un chat.
     * 
     * @param idParticipante el ID del participante
     * @return una lista de participantes del chat
     * @throws Exception si ocurre un error al consultar los participantes
     */
    public List<Participante> consultarParticipante(int idParticipante) throws Exception;
    
    /**
     * Agrega un nuevo mensaje a un chat.
     * 
     * @param mensajeDTO el DTO con la información del nuevo mensaje
     * @return el DTO del mensaje agregado
     * @throws Exception si ocurre un error al agregar el mensaje
     */
    public MensajeDTO agregarMensaje(MensajeNuevoDTO mensajeDTO) throws Exception;
    
    /**
     * Consulta los mensajes de un chat.
     * 
     * @param idChat el ID del chat
     * @return una lista de DTOs de los mensajes del chat
     * @throws Exception si ocurre un error al consultar los mensajes
     */
    public List<MensajeDTO> consultarMensajesChat(int idChat) throws Exception;
}
