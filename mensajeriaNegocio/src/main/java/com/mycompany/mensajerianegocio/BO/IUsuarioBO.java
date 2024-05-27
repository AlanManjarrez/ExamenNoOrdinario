/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mensajerianegocio.BO;

import com.mycompany.mensajerianegocio.DTOS.UsuarioDTO;
import com.mycompany.mensajerianegocio.DTOS.UsuarioNuevoDTO;

/**
 *
 * @author uirtis
 */
public interface IUsuarioBO {

    public UsuarioDTO agregarUsuario(UsuarioNuevoDTO usuarioNuevo) throws Exception;
    
    public UsuarioDTO consultarUsuario(UsuarioDTO usuarioDTO) throws Exception;
}
