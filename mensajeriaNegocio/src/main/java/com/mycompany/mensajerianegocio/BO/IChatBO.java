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
 *
 * @author uirtis
 */
public interface IChatBO {
    public ChatDTO agregarChat(ChatNuevoDTO chatNuevoDTO) throws Exception;
    
    public List<ChatDTO> consultarChat(int idParticipante)throws Exception;
    
    public List<Participante> consultarParticipante(int idParticipante)throws Exception;
    
    public MensajeDTO agregarMensaje(MensajeNuevoDTO mensajeDTO) throws Exception;
}
