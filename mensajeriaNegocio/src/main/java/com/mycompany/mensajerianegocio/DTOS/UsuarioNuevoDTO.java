/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajerianegocio.DTOS;

/**
 * Clase que encapsula un UsuarioDTO y un DireccionDTO para transferir datos
 * relacionados con la creación de un nuevo usuario.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class UsuarioNuevoDTO {

    private UsuarioDTO usuarioDTO;
    private DireccionDTO direccionDTO;

    /**
     * Constructor por defecto
     */
    public UsuarioNuevoDTO() {
    }

    /**
     * Obtiene el DTO del usuario.
     *
     * @return el DTO del usuario
     */
    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    /**
     * Establece el DTO del usuario.
     *
     * @param usuarioDTO el DTO del usuario a establecer
     */
    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    /**
     * Obtiene el DTO de la dirección.
     *
     * @return el DTO de la dirección
     */
    public DireccionDTO getDireccionDTO() {
        return direccionDTO;
    }

    /**
     * Establece el DTO de la dirección.
     *
     * @param direccionDTO el DTO de la dirección a establecer
     */
    public void setDireccionDTO(DireccionDTO direccionDTO) {
        this.direccionDTO = direccionDTO;
    }

}
