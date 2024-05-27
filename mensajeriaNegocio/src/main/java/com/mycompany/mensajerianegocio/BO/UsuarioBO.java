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
 *
 * @author uirtis
 */
public class UsuarioBO implements IUsuarioBO {

    private IUsuarioDAO usuario;
    private IDireccionDAO direccion;

    public UsuarioBO() {
        this.usuario = new UsuarioDAO();
        this.direccion = new DireccionDAO();
    }

    public Usuario convertirEntidadUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO.getTelefono(), usuarioDTO.getContrasena(),
                usuarioDTO.getSexo(), usuarioDTO.getFechaNacimiento(), usuarioDTO.getImagenPerfil());
        if (usuarioDTO.getIdUsuario() > 0) {
            usuario.setIdUsuario(usuarioDTO.getIdUsuario());
        }
        return usuario;
    }

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

    public Direccion convertirEntidadDireccion(DireccionDTO direccionDTO) {
        Direccion direccion = new Direccion(direccionDTO.getCalle(), direccionDTO.getNumero(), direccionDTO.getCodigoPostal());
        if (direccionDTO.getIdUsuario() > 0) {
            direccion.setIdUsuario(direccionDTO.getIdUsuario());
        }
        return direccion;
    }

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

    @Override
    public UsuarioDTO agregarUsuario(UsuarioNuevoDTO usuarioNuevo) throws Exception {
        Usuario usuarioCreado = usuario.agregarUsuario(convertirEntidadUsuario(usuarioNuevo.getUsuarioDTO()));
        Direccion direccionConvertida = convertirEntidadDireccion(usuarioNuevo.getDireccionDTO());
        direccionConvertida.setIdUsuario(usuarioCreado.getIdUsuario());
        direccion.agregarDireccion(direccionConvertida);
        return convertirDTOUsuario(usuarioCreado);
    }

    @Override
    public UsuarioDTO consultarUsuarioTelefonoContrasena(UsuarioDTO usuarioDTO) throws Exception {
        return convertirDTOUsuario(usuario.consultarUsuarioTelefonoContrasena(usuarioDTO.getTelefono(), usuarioDTO.getContrasena()));
    }

    @Override
    public List<UsuarioDTO> consultarUsuarioTelefono(String telefono) throws Exception {
        List<Usuario> usuarios = usuario.consultarUsuarioTelefono(telefono);
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuariosDTO.add(convertirDTOUsuario(usuario));
        }
        return usuariosDTO;
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioNuevoDTO usuarioNuevo) throws Exception {
        Usuario usuarioCreado = usuario.actualizarUsuario(convertirEntidadUsuario(usuarioNuevo.getUsuarioDTO()));
        Direccion direccionConvertida = convertirEntidadDireccion(usuarioNuevo.getDireccionDTO());
        direccionConvertida.setIdUsuario(usuarioCreado.getIdUsuario());
        direccion.actualizarDireccion(direccionConvertida);
        return convertirDTOUsuario(usuarioCreado);
    }

}
