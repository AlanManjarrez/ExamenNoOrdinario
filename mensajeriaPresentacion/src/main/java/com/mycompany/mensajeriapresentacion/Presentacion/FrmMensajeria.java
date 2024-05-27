/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mensajeriapresentacion.Presentacion;

import com.mycompany.mensajerianegocio.BO.ChatBO;
import com.mycompany.mensajerianegocio.BO.IChatBO;
import com.mycompany.mensajerianegocio.BO.IUsuarioBO;
import com.mycompany.mensajerianegocio.BO.UsuarioBO;
import com.mycompany.mensajerianegocio.DTOS.ChatDTO;
import com.mycompany.mensajerianegocio.DTOS.MensajeDTO;
import com.mycompany.mensajerianegocio.DTOS.MensajeNuevoDTO;
import com.mycompany.mensajerianegocio.DTOS.UsuarioDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author uirtis
 */
public class FrmMensajeria extends javax.swing.JFrame {

    private UsuarioDTO usuarioConsultado;
    private IChatBO chatBO;
    private IUsuarioBO usuarioBO;

    /**
     * Creates new form FrmIniciarSesion
     */
    public FrmMensajeria(UsuarioDTO usuarioConsultado, String chat) {
        this.chatBO = new ChatBO();
        this.usuarioBO = new UsuarioBO();
        this.usuarioConsultado = usuarioConsultado;
        initComponents();
        labelNombreUsuario.setText(chat);

        final ChatDTO[] chatConsultado = {null};

        try {
            List<ChatDTO> chats = chatBO.consultarChat(usuarioConsultado.getIdUsuario());
            for (ChatDTO chatDTO : chats) {
                if (chatDTO.getNombreUsuario().equalsIgnoreCase(chat)) {
                    chatConsultado[0] = chatDTO;
                    break; // Encontramos el chat, salimos del loop
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        llenarLista(chatConsultado[0].getIdChat(), chat);
        txtMensaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto ingresado
                String inputText = txtMensaje.getText();

                if (chatConsultado[0] != null) {
                    MensajeNuevoDTO mensajeNuevoDTO = new MensajeNuevoDTO();
                    mensajeNuevoDTO.setIdChat(chatConsultado[0].getIdChat());
                    System.out.println(chatConsultado[0].getIdChat());
                    mensajeNuevoDTO.setTexto(inputText);
                    mensajeNuevoDTO.setIdUsuario(usuarioConsultado.getIdUsuario());
                    mensajeNuevoDTO.setImagenMensaje(null);

                    try {
                        MensajeDTO mensajeDTO = chatBO.agregarMensaje(mensajeNuevoDTO);
                        llenarLista(chatConsultado[0].getIdChat(), chat);
                        txtMensaje.setText("");
                    } catch (Exception ex) {

                    }
                }

            }
        });
//        UsuarioDTO usuarioDTO = usuario.
//        ImageIcon mIcono = null;
//        try {
//            byte[] imagen = usuarioDTO.getImagenPerfil();
//            if (imagen != null && imagen.length > 0) {
//                InputStream inputStream = new ByteArrayInputStream(imagen);
//                BufferedImage bufferedImage = ImageIO.read(inputStream);
//                if (bufferedImage != null) {
//                    mIcono = new ImageIcon(bufferedImage.getScaledInstance(60, 60, BufferedImage.SCALE_SMOOTH));
//                    rowHeight = Math.max(rowHeight, mIcono.getIconHeight());
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Puedes manejar el error aquí, como mostrar un mensaje de error o asignar una imagen predeterminada.
//        }
    }

    private void llenarLista(int idChat, String nombreChat) {
        int anchoMaximo = 100; // Ajusta esto según sea necesario
        String alineacionTexto;
        String alineacionFecha;

        this.txtaMensaje.setText("");
        try {
            List<MensajeDTO> mensajes = chatBO.consultarMensajesChat(idChat);

            for (MensajeDTO mensajeDTO : mensajes) {
                String nombre;
                if (mensajeDTO.getIdUsuario() == usuarioConsultado.getIdUsuario()) {
                    nombre = "Tu";
                    alineacionTexto = String.format("%" + anchoMaximo + "s", String.format("%s: %s", nombre, mensajeDTO.getTexto()));
                    alineacionFecha = String.format("%" + anchoMaximo + "s", mensajeDTO.getFechaHoraRegistro());
                } else {
                    nombre = nombreChat;
                    alineacionTexto = String.format("%-1s", String.format("%s: %s", nombre, mensajeDTO.getTexto()));
                    alineacionFecha = String.format("%-1s", mensajeDTO.getFechaHoraRegistro());
                }
                this.txtaMensaje.append(alineacionTexto + "\n");
                this.txtaMensaje.append(alineacionFecha + "\n");
            }
        } catch (Exception ex) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtMensaje = new javax.swing.JTextField();
        labelNombreUsuario = new javax.swing.JLabel();
        scrollMensaje = new javax.swing.JScrollPane();
        txtaMensaje = new javax.swing.JTextArea();
        btnVolver = new javax.swing.JButton();

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Chats");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conversación");

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Juatsapp");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(287, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtMensaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMensajeKeyTyped(evt);
            }
        });

        labelNombreUsuario.setBackground(new java.awt.Color(255, 255, 255));
        labelNombreUsuario.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        labelNombreUsuario.setForeground(new java.awt.Color(51, 51, 51));
        labelNombreUsuario.setText("Chats");

        txtaMensaje.setColumns(20);
        txtaMensaje.setRows(5);
        scrollMensaje.setViewportView(txtaMensaje);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelNombreUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver))
                    .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreUsuario)
                    .addComponent(btnVolver))
                .addGap(27, 27, 27)
                .addComponent(scrollMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMensajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMensajeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMensajeKeyTyped

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        FrmChats frmChats = new FrmChats(usuarioConsultado);
        frmChats.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmChats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmChats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmChats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmChats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmChats().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelNombreUsuario;
    private javax.swing.JScrollPane scrollMensaje;
    private javax.swing.JTextField txtMensaje;
    private javax.swing.JTextArea txtaMensaje;
    // End of variables declaration//GEN-END:variables
}
