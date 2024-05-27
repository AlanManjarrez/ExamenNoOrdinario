/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajerianegocio.BO;

import com.mycompany.mensajerianegocio.DTOS.DireccionDTO;
import com.mycompany.mensajeriapersistencia.DAOS.DireccionDAO;
import com.mycompany.mensajeriapersistencia.DAOS.IDireccionDAO;
import com.mycompany.mensajeriapersistencia.Dominio.Direccion;

/**
 * Clase que implementa la lógica de negocio para la gestión de direcciones.
 *
 * Esta clase maneja la conversión y consulta de direcciones, utilizando un DAO
 * para interactuar con la base de datos.
 *
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class DireccionBO implements IDireccionBO {

    private IDireccionDAO direccion;

    /**
     * Constructor por defecto que inicializa el DAO de dirección.
     */
    public DireccionBO() {
        this.direccion = new DireccionDAO();
    }

    /**
     * Convierte un objeto DireccionDTO a una entidad Direccion.
     *
     * @param direccionDTO el DTO de la dirección a convertir
     * @return el objeto Direccion convertido
     */
    public Direccion convertirEntidadDireccion(DireccionDTO direccionDTO) {
        Direccion direccion = new Direccion(direccionDTO.getCalle(), direccionDTO.getNumero(), direccionDTO.getCodigoPostal());
        return direccion;
    }

    /**
     * Convierte una entidad Direccion a un objeto DireccionDTO.
     *
     * @param direccion la entidad Direccion a convertir
     * @return el objeto DireccionDTO convertido
     */
    public DireccionDTO convertirDTODireccion(Direccion direccion) {
        DireccionDTO direccionDTO = new DireccionDTO();
        direccionDTO.setCalle(direccion.getCalle());
        direccionDTO.setNumero(direccion.getNumero());
        direccionDTO.setCodigoPostal(direccion.getCodigoPostal());
        return direccionDTO;
    }

    /**
     * Consulta una dirección por el ID del usuario.
     *
     * @param idUsuario el identificador del usuario
     * @return el objeto DireccionDTO de la dirección consultada
     * @throws Exception si ocurre un error al consultar la dirección
     */
    @Override
    public DireccionDTO consultarDireccion(int idUsuario) throws Exception {
        return convertirDTODireccion(direccion.consultarDireccion(idUsuario));
    }

}
