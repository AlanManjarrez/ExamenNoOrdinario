package com.mycompany.mensajeriapersistencia;

import com.mycompany.mensajeriapersistencia.Conexion.IConexion;
import com.mycompany.mensajeriapersistencia.DAOS.UsuarioDAO;
import com.mycompany.mensajeriapersistencia.Dominio.Usuario;
import com.mycompany.mensajeriapersistencia.PersistenciaException.PersistenciaException;

/**
 *
 * @author uirtis
 */
public class MensajeriaPersistencia {

    public static void main(String[] args) throws PersistenciaException {
        System.out.println("Hello World!");

        Usuario usuario = new Usuario("5553458939", "contrasena123", "M", "2020-2-2", "imagen6.png");
        Usuario usuarioActualizado = new Usuario(9,"6442222222", "newpassword22222", "M", "2001-11-23", "perfil_Nuevo22222.jpg");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        //usuarioDAO.agregarUsuario(usuarioActualizado);
        usuarioDAO.actualizarUsuario(usuarioActualizado);   
        System.out.println(usuarioDAO.consultarUsuario("5557654321"));
        
    }
}
