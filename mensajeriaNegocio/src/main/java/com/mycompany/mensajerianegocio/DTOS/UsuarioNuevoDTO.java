/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajerianegocio.DTOS;

/**
 *
 * @author uirtis
 */
public class UsuarioNuevoDTO {
    
    private UsuarioDTO usuarioDTO;
    private DireccionDTO direccionDTO;

    public UsuarioNuevoDTO() {
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public DireccionDTO getDireccionDTO() {
        return direccionDTO;
    }

    public void setDireccionDTO(DireccionDTO direccionDTO) {
        this.direccionDTO = direccionDTO;
    }
    
}
