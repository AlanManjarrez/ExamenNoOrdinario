/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mensajerianegocio.BO;

import com.mycompany.mensajerianegocio.DTOS.DireccionDTO;

/**
 * Interfaz para la lógica de negocio relacionada con las direcciones.
 *
 * Define los métodos para consultar direcciones por ID de usuario.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public interface IDireccionBO {

    /**
     * Consulta una dirección por el ID del usuario.
     *
     * @param idUsuario el identificador del usuario
     * @return el DTO de la dirección consultada
     * @throws Exception si ocurre un error al consultar la dirección
     */
    public DireccionDTO consultarDireccion(int idUsuario) throws Exception;
}
