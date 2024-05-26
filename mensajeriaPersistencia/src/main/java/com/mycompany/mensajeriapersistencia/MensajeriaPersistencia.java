package com.mycompany.mensajeriapersistencia;

import com.mycompany.mensajeriapersistencia.Conexion.IConexion;
import com.mycompany.mensajeriapersistencia.DAOS.ChatDAO;
import com.mycompany.mensajeriapersistencia.DAOS.DireccionDAO;
import com.mycompany.mensajeriapersistencia.DAOS.MensajeDAO;
import com.mycompany.mensajeriapersistencia.DAOS.ParticipanteDAO;
import com.mycompany.mensajeriapersistencia.DAOS.UsuarioDAO;
import com.mycompany.mensajeriapersistencia.Dominio.Chat;
import com.mycompany.mensajeriapersistencia.Dominio.Direccion;
import com.mycompany.mensajeriapersistencia.Dominio.Mensaje;
import com.mycompany.mensajeriapersistencia.Dominio.Participante;
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
        //usuarioDAO.actualizarUsuario(usuarioActualizado);   
        System.out.println(usuarioDAO.consultarUsuario("5557654321"));
        
        Direccion direccion = new Direccion("calle fulana22222", "2222", "22222", 7);
        
        DireccionDAO direccionDAO = new DireccionDAO();
        //direccionDAO.agregarDireccion(direccion);
        //direccionDAO.actualizarDireccion(direccion);
        System.out.println(direccionDAO.consultarDireccion(7));
        
        Chat chat = new Chat(5,"ernesto_torres");
        ChatDAO chatDAO = new ChatDAO();
        
        //chatDAO.agregarChat(chat);
        //chatDAO.editarChat(chat);
        //chatDAO.eliminarChat(5);
        System.out.println(chatDAO.consultarChat(1));
        
        Mensaje mensaje = new Mensaje(3,"COMO VASSSS", "2024-5-26 17:58:24", "imagen.png", 3, 3);
        MensajeDAO mensajeDAO = new MensajeDAO();
        
        //mensajeDAO.agregarMensaje(mensaje);
        //mensajeDAO.editarMensaje(mensaje);
        //mensajeDAO.eliminarMensaje(3);
        System.out.println(mensajeDAO.consultarMensaje("como"));
        
        Participante participante = new Participante(5,2, 1);
        ParticipanteDAO participanteDAO = new ParticipanteDAO();
        
        //participanteDAO.agregarParticipante(participante);
        //participanteDAO.actualizarParticipante(participante);
        //participanteDAO.eliminarParticipante(5);
        System.out.println(participanteDAO.consultarParticipante(2));
        
    }
}
