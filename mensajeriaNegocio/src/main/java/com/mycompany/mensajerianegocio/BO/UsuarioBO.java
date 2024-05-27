/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajerianegocio.BO;

import com.mycompany.mensajerianegocio.DTOS.DireccionDTO;
import com.mycompany.mensajerianegocio.DTOS.UsuarioDTO;
import com.mycompany.mensajerianegocio.DTOS.UsuarioNuevoDTO;
import com.mycompany.mensajeriapersistencia.DAOS.DireccionDAO;
import com.mycompany.mensajeriapersistencia.DAOS.IDireccionDAO;
import com.mycompany.mensajeriapersistencia.DAOS.IUsuarioDAO;
import com.mycompany.mensajeriapersistencia.DAOS.UsuarioDAO;
import com.mycompany.mensajeriapersistencia.Dominio.Direccion;
import com.mycompany.mensajeriapersistencia.Dominio.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la lógica de negocio para los usuarios.
 *
 * Esta clase maneja las operaciones relacionadas con los usuarios, como
 * agregar, consultar y actualizar usuarios, interactuando con los DAOs
 * correspondientes.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class UsuarioBO implements IUsuarioBO {

    private IUsuarioDAO usuario;
    private IDireccionDAO direccion;

    /**
     * Constructor por defecto que inicializa los DAOs de usuario y dirección.
     */
    public UsuarioBO() {
        this.usuario = new UsuarioDAO();
        this.direccion = new DireccionDAO();
    }

    /**
     * Convierte un DTO de Usuario a una entidad Usuario.
     *
     * @param usuarioDTO el DTO de usuario
     * @return la entidad Usuario
     */
    public Usuario convertirEntidadUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO.getTelefono(), usuarioDTO.getContrasena(),
                usuarioDTO.getSexo(), usuarioDTO.getFechaNacimiento(), usuarioDTO.getImagenPerfil());
        if (usuarioDTO.getIdUsuario() > 0) {
            usuario.setIdUsuario(usuarioDTO.getIdUsuario());
        }
        return usuario;
    }

    /**
     * Convierte una entidad Usuario a un DTO de Usuario.
     *
     * @param usuario la entidad Usuario
     * @return el DTO de Usuario
     */
    public UsuarioDTO convertirDTOUsuario(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioDTO.setTelefono(usuario.getTelefono());
        usuarioDTO.setContrasena(usuario.getContrasena());
        usuarioDTO.setSexo(usuario.getSexo());
        usuarioDTO.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioDTO.setImagenPerfil(usuario.getImagenPerfil());
        return usuarioDTO;
    }

    /**
     * Convierte un DTO de Dirección a una entidad Dirección.
     *
     * @param direccionDTO el DTO de dirección
     * @return la entidad Dirección
     */
    public Direccion convertirEntidadDireccion(DireccionDTO direccionDTO) {
        Direccion direccion = new Direccion(direccionDTO.getCalle(), direccionDTO.getNumero(), direccionDTO.getCodigoPostal());
        if (direccionDTO.getIdUsuario() > 0) {
            direccion.setIdUsuario(direccionDTO.getIdUsuario());
        }
        return direccion;
    }

    /**
     * Convierte una entidad Dirección a un DTO de Dirección.
     *
     * @param direccion la entidad Dirección
     * @return el DTO de Dirección
     */
    public DireccionDTO convertirDTODireccion(Direccion direccion) {
        DireccionDTO direccionDTO = new DireccionDTO();
        direccionDTO.setCalle(direccion.getCalle());
        direccionDTO.setNumero(direccion.getNumero());
        direccionDTO.setCodigoPostal(direccion.getCodigoPostal());
        if (direccion.getIdUsuario() > 0) {
            direccionDTO.setIdUsuario(direccion.getIdUsuario());
        }
        return direccionDTO;
    }

    /**
     * Agrega un nuevo usuario junto con su dirección.
     *
     * @param usuarioNuevo el DTO que contiene los datos del nuevo usuario y su
     * dirección
     * @return el DTO del usuario agregado
     * @throws Exception si ocurre un error al agregar el usuario
     */
    @Override
    public UsuarioDTO agregarUsuario(UsuarioNuevoDTO usuarioNuevo) throws Exception {
        Usuario usuarioCreado = usuario.agregarUsuario(convertirEntidadUsuario(usuarioNuevo.getUsuarioDTO()));
        Direccion direccionConvertida = convertirEntidadDireccion(usuarioNuevo.getDireccionDTO());
        direccionConvertida.setIdUsuario(usuarioCreado.getIdUsuario());
        direccion.agregarDireccion(direccionConvertida);
        return convertirDTOUsuario(usuarioCreado);
    }

    /**
     * Consulta un usuario por su teléfono y contraseña.
     *
     * @param usuarioDTO el DTO con el teléfono y la contraseña del usuario
     * @return el DTO del usuario consultado
     * @throws Exception si ocurre un error al consultar el usuario
     */
    @Override
    public UsuarioDTO consultarUsuarioTelefonoContrasena(UsuarioDTO usuarioDTO) throws Exception {
        return convertirDTOUsuario(usuario.consultarUsuarioTelefonoContrasena(usuarioDTO.getTelefono(), usuarioDTO.getContrasena()));
    }

    /**
     * Consulta usuarios por su teléfono.
     *
     * @param telefono el teléfono del usuario
     * @return una lista de DTOs de los usuarios consultados
     * @throws Exception si ocurre un error al consultar los usuarios
     */
    @Override
    public List<UsuarioDTO> consultarUsuarioTelefono(String telefono) throws Exception {
        List<Usuario> usuarios = usuario.consultarUsuarioTelefono(telefono);
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuariosDTO.add(convertirDTOUsuario(usuario));
        }
        return usuariosDTO;
    }

    /**
     * Actualiza un usuario existente junto con su dirección.
     *
     * @param usuarioNuevo el DTO que contiene los datos actualizados del
     * usuario y su dirección
     * @return el DTO del usuario actualizado
     * @throws Exception si ocurre un error al actualizar el usuario
     */
    @Override
    public UsuarioDTO actualizarUsuario(UsuarioNuevoDTO usuarioNuevo) throws Exception {
        Usuario usuarioCreado = usuario.actualizarUsuario(convertirEntidadUsuario(usuarioNuevo.getUsuarioDTO()));
        Direccion direccionConvertida = convertirEntidadDireccion(usuarioNuevo.getDireccionDTO());
        direccionConvertida.setIdUsuario(usuarioCreado.getIdUsuario());
        direccion.actualizarDireccion(direccionConvertida);
        return convertirDTOUsuario(usuarioCreado);
    }

}
