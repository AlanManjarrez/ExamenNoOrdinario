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
 *
 * @author uirtis
 */
public class DireccionBO implements IDireccionBO{
    
    private IDireccionDAO direccion;

    public DireccionBO() {
        this.direccion = new DireccionDAO();
    }
    
    public Direccion convertirEntidadDireccion(DireccionDTO direccionDTO) {
        Direccion direccion = new Direccion(direccionDTO.getCalle(), direccionDTO.getNumero(), direccionDTO.getCodigoPostal());
        return direccion;
    }

    public DireccionDTO convertirDTODireccion(Direccion direccion) {
        DireccionDTO direccionDTO = new DireccionDTO();
        direccionDTO.setCalle(direccion.getCalle());
        direccionDTO.setNumero(direccion.getNumero());
        direccionDTO.setCodigoPostal(direccion.getCodigoPostal());
        return direccionDTO;
    }
    
    @Override
    public DireccionDTO consultarDireccion(int idUsuario) throws Exception {
        return convertirDTODireccion(direccion.consultarDireccion(idUsuario));
    }
    
}
