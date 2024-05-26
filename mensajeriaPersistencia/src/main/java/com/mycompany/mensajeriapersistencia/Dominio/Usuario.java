/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajeriapersistencia.Dominio;

/**
 * Clase que representa un usuario en el sistema.
 *
 * Esta clase encapsula los datos asociados a un usuario, como su identificador,
 * teléfono, contraseña, sexo, fecha de nacimiento y la URL de su imagen de
 * perfil.
 *
 * Los objetos de esta clase pueden ser utilizados para almacenar y manipular
 * información de usuario en el sistema.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class Usuario {

    private int idUsuario;
    private String telefono;
    private String contrasena;
    private String sexo;
    private String fechaNacimiento;
    private String imagenPerfil;

    /**
     * Constructor por defecto de la clase Usuario
     */
    public Usuario() {
    }

    /**
     * Constructor de la clase Usuario con todos los atributos.
     *
     * @param idUsuario el identificador del usuario
     * @param telefono el número de teléfono del usuario
     * @param contrasena la contraseña del usuario
     * @param sexo el género del usuario
     * @param fechaNacimiento la fecha de nacimiento del usuario
     * @param imagenPerfil la URL de la imagen de perfil del usuario
     */
    public Usuario(int idUsuario, String telefono, String contrasena, String sexo, String fechaNacimiento, String imagenPerfil) {
        this.idUsuario = idUsuario;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.imagenPerfil = imagenPerfil;
    }

    /**
     * Constructor de la clase Usuario sin el identificador.
     *
     * @param telefono el número de teléfono del usuario
     * @param contrasena la contraseña del usuario
     * @param sexo el género del usuario
     * @param fechaNacimiento la fecha de nacimiento del usuario
     * @param imagenPerfil la URL de la imagen de perfil del usuario
     */
    public Usuario(String telefono, String contrasena, String sexo, String fechaNacimiento, String imagenPerfil) {
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.imagenPerfil = imagenPerfil;
    }

    /**
     * Obtiene el identificador del usuario.
     *
     * @return el identificador del usuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param idUsuario el nuevo identificador del usuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     *
     * @return el número de teléfono del usuario
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuario.
     *
     * @param telefono el nuevo número de teléfono del usuario
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return la contraseña del usuario
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena la nueva contraseña del usuario
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el sexo del usuario.
     *
     * @return el sexo del usuario
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo del usuario.
     *
     * @param sexo el nuevo sexo del usuario
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     *
     * @return la fecha de nacimiento del usuario
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fechaNacimiento la nueva fecha de nacimiento del usuario
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene la URL de la imagen de perfil del usuario.
     *
     * @return la URL de la imagen de perfil del usuario
     */
    public String getImagenPerfil() {
        return imagenPerfil;
    }

    /**
     * Establece la URL de la imagen de perfil del usuario.
     *
     * @param imagenPerfil la nueva URL de la imagen de perfil del usuario
     */
    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    /**
     * Devuelve una representación de cadena del objeto Usuario.
     *
     * @return una cadena que representa el objeto Usuario, que incluye todos
     * los atributos
     */
    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", telefono=" + telefono + ", contrasena=" + contrasena + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", imagenPerfil=" + imagenPerfil + '}';
    }

}
