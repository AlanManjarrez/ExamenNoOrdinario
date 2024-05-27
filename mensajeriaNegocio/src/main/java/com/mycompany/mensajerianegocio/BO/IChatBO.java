/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mensajerianegocio.BO;

import com.mycompany.mensajerianegocio.DTOS.ChatDTO;
import com.mycompany.mensajerianegocio.DTOS.ChatNuevoDTO;

/**
 *
 * @author uirtis
 */
public interface IChatBO {
    public ChatDTO agregarChat(ChatNuevoDTO chatNuevoDTO) throws Exception;
}
