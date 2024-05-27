/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mensajerianegocio.BO;

import com.mycompany.mensajerianegocio.DTOS.DireccionDTO;

/**
 *
 * @author uirtis
 */
public interface IDireccionBO {
    public DireccionDTO consultarDireccion(int idUsuario) throws Exception;
}
