/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajerianegocio.DTOS;

/**
 * Clase que representa el Data Transfer Object (DTO) para la entidad Usuario.
 *
 * Esta clase se utiliza para transferir datos de usuario entre las capas de la
 * aplicación sin exponer directamente la entidad del modelo de datos. Incluye
 * propiedades básicas del usuario como idUsuario, telefono, contrasena, sexo,
 * fechaNacimiento e imagenPerfil.
 *
 * Los objetos de esta clase son utilizados para encapsular y transportar datos
 * relacionados con el usuario a través de los diferentes componentes del
 * sistema.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class UsuarioDTO {

    private int idUsuario;
    private String telefono;
    private String contrasena;
    private String sexo;
    private String fechaNacimiento;
    private byte[] imagenPerfil;

    /**
     * Constructor por defecto de la clase UsuarioDTO
     */
    public UsuarioDTO() {
    }

    /**
     * Constructor de la clase UsuarioDTO sin el identificador.
     *
     * @param telefono el número de teléfono del usuarioDTO
     * @param contrasena la contraseña del usuarioDTO
     * @param sexo el género del usuarioDTO
     * @param fechaNacimiento la fecha de nacimiento del usuarioDTO
     * @param imagenPerfil la URL de la imagen de perfil del usuarioDTO
     */
    public UsuarioDTO(String telefono, String contrasena, String sexo, String fechaNacimiento, byte[] imagenPerfil) {
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.imagenPerfil = imagenPerfil;
    }

    /**
     * Constructor que inicializa los atributos de teléfono, contraseña, sexo y
     * fecha de nacimiento del usuario.
     *
     * @param telefono el número de teléfono del usuario
     * @param contrasena la contraseña del usuario
     * @param sexo el sexo del usuario
     * @param fechaNacimiento la fecha de nacimiento del usuario
     */
    public UsuarioDTO(String telefono, String contrasena, String sexo, String fechaNacimiento) {
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el identificador del usuarioDTO.
     *
     * @return el identificador del usuarioDTO
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador del usuarioDTO.
     *
     * @param idUsuario el nuevo identificador del usuarioDTO
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el número de teléfono del usuarioDTO.
     *
     * @return el número de teléfono del usuarioDTO
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuarioDTO.
     *
     * @param telefono el nuevo número de teléfono del usuarioDTO
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la contraseña del usuarioDTO.
     *
     * @return la contraseña del usuarioDTO
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuarioDTO.
     *
     * @param contrasena la nueva contraseña del usuarioDTO
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el sexo del usuarioDTO.
     *
     * @return el sexo del usuarioDTO
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo del usuarioDTO.
     *
     * @param sexo el nuevo sexo del usuarioDTO
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Obtiene la fecha de nacimiento del usuarioDTO.
     *
     * @return la fecha de nacimiento del usuarioDTO
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuarioDTO.
     *
     * @param fechaNacimiento la nueva fecha de nacimiento del usuarioDTO
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene la URL de la imagen de perfil del usuarioDTO.
     *
     * @return la URL de la imagen de perfil del usuarioDTO
     */
    public byte[] getImagenPerfil() {
        return imagenPerfil;
    }

    /**
     * Establece la URL de la imagen de perfil del usuarioDTO.
     *
     * @param imagenPerfil la nueva URL de la imagen de perfil del usuarioDTO
     */
    public void setImagenPerfil(byte[] imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    /**
     * Devuelve una representación de cadena del objeto UsuarioDTO.
     *
     * @return una cadena que representa el objeto Usuario, que incluye todos
     * los atributos
     */
    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", telefono=" + telefono + ", contrasena=" + contrasena + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", imagenPerfil=" + imagenPerfil + '}';
    }
}
