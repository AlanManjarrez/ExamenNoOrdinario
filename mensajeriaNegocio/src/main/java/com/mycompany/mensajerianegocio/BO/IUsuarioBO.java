/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mensajerianegocio.BO;

import com.mycompany.mensajerianegocio.DTOS.UsuarioDTO;
import com.mycompany.mensajerianegocio.DTOS.UsuarioNuevoDTO;
import java.util.List;

/**
 * Interfaz para la lógica de negocio relacionada con los usuarios.
 *
 * Define los métodos para agregar, consultar y actualizar usuarios.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public interface IUsuarioBO {

    /**
     * Agrega un nuevo usuario.
     *
     * @param usuarioNuevo el DTO con la información del nuevo usuario
     * @return el DTO del usuario agregado
     * @throws Exception si ocurre un error al agregar el usuario
     */
    public UsuarioDTO agregarUsuario(UsuarioNuevoDTO usuarioNuevo) throws Exception;

    /**
     * Consulta un usuario por su teléfono y contraseña.
     *
     * @param usuarioDTO el DTO con el teléfono y la contraseña del usuario
     * @return el DTO del usuario consultado
     * @throws Exception si ocurre un error al consultar el usuario
     */
    public UsuarioDTO consultarUsuarioTelefonoContrasena(UsuarioDTO usuarioDTO) throws Exception;

    /**
     * Consulta usuarios por su teléfono.
     *
     * @param telefono el teléfono del usuario
     * @return una lista de DTOs de los usuarios consultados
     * @throws Exception si ocurre un error al consultar los usuarios
     */
    public List<UsuarioDTO> consultarUsuarioTelefono(String telefono) throws Exception;

    /**
     * Actualiza un usuario existente.
     *
     * @param usuarioNuevo el DTO con la nueva información del usuario
     * @return el DTO del usuario actualizado
     * @throws Exception si ocurre un error al actualizar el usuario
     */
    public UsuarioDTO actualizarUsuario(UsuarioNuevoDTO usuarioNuevo) throws Exception;
}
