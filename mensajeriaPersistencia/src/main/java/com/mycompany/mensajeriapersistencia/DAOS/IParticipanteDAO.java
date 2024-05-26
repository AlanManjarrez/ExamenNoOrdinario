/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mensajeriapersistencia.DAOS;

import com.mycompany.mensajeriapersistencia.Dominio.Participante;
import com.mycompany.mensajeriapersistencia.PersistenciaException.PersistenciaException;
import java.util.List;

/**
 *
 * @author uirtis
 */
public interface IParticipanteDAO {
    public Participante agregarParticipante(Participante participante) throws PersistenciaException;
    
    public Participante actualizarParticipante(Participante participante) throws PersistenciaException;
    
    public Participante eliminarParticipante(int idParticipante) throws PersistenciaException;
    
    public List<Participante> consultarParticipante(int idParticipante) throws PersistenciaException;
    
    
}
