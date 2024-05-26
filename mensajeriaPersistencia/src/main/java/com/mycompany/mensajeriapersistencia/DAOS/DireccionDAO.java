/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajeriapersistencia.DAOS;

import com.mycompany.mensajeriapersistencia.Conexion.Conexion;
import com.mycompany.mensajeriapersistencia.Conexion.IConexion;
import com.mycompany.mensajeriapersistencia.Dominio.Direccion;
import com.mycompany.mensajeriapersistencia.Dominio.Usuario;
import com.mycompany.mensajeriapersistencia.PersistenciaException.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la interfaz IDireccionDAO y proporciona la lógica para
 * interactuar con la capa de persistencia de datos para la entidad Dirección en
 * el sistema.
 *
 * Esta clase se encarga de realizar operaciones como agregar, actualizar y
 * consultar direcciones en la base de datos. Utiliza una instancia de la
 * interfaz IConexion para establecer y manejar la conexión con la base de
 * datos.
 *
 * Los errores relacionados con la persistencia de datos son registrados
 * utilizando un {@link Logger} para facilitar el seguimiento y la depuración.
 *
 * @author Jose Alan Manjarrez Ontiveros 2228982
 */
public class DireccionDAO implements IDireccionDAO {

    IConexion conexion;
    private static final Logger LOG = Logger.getLogger(Usuario.class.getName());

    /**
     * Constructor por defecto de la clase DireccionDAO.
     */
    public DireccionDAO() {
        this.conexion = new Conexion();
    }

    /**
     * Agrega una nueva dirección al sistema.
     *
     * @param direccion la dirección a ser agregada
     * @return la dirección agregada
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Direccion agregarDireccion(Direccion direccion) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement conn = con.prepareCall("{call agregar_direccion(?,?,?,?)}")) {

            conn.setString(1, direccion.getCalle());
            conn.setString(2, direccion.getNumero());
            conn.setString(3, direccion.getCodigoPostal());
            conn.setInt(4, direccion.getIdUsuario());

            int registro = conn.executeUpdate();
            LOG.log(Level.INFO, "Se agrego con exito la direccion {0} ", registro);

            ResultSet registroG = conn.getGeneratedKeys();
            int idGenerado = 0;
            if (registroG.next()) {
                idGenerado = registroG.getInt(1);
            }

            Direccion direccionNueva = new Direccion(idGenerado,
                    direccion.getCalle(),
                    direccion.getNumero(),
                    direccion.getCodigoPostal(),
                    direccion.getIdUsuario()
            );
            return direccionNueva;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se ha podido agregar la direccion", e);
            throw new PersistenciaException("No se pudo guardar la direccion", e);
        }
    }

    /**
     * Actualiza los datos de una dirección existente en el sistema.
     *
     * @param direccion la dirección con los datos actualizados
     * @return la dirección actualizada
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Direccion actualizarDireccion(Direccion direccion) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement conn = con.prepareCall("{call actualizar_direccion(?,?,?,?)}")) {

            conn.setString(1, direccion.getCalle());
            conn.setString(2, direccion.getNumero());
            conn.setString(3, direccion.getCodigoPostal());
            conn.setInt(4, direccion.getIdUsuario());

            int registro = conn.executeUpdate();
            LOG.log(Level.INFO, "Se actualizo con exito la direccion {0} ", registro);

            ResultSet registroG = conn.getGeneratedKeys();
            int idGenerado = 0;
            if (registroG.next()) {
                idGenerado = registroG.getInt(1);
            }

            Direccion direccionActualizada = new Direccion(idGenerado,
                    direccion.getCalle(),
                    direccion.getNumero(),
                    direccion.getCodigoPostal(),
                    direccion.getIdUsuario()
            );
            return direccionActualizada;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se ha podido actualizar la direccion", e);
            throw new PersistenciaException("No se pudo actualizar la direccion", e);
        }
    }

    /**
     * Consulta una dirección en el sistema utilizando el identificador del
     * usuario asociado.
     *
     * @param idUsuario el identificador del usuario asociado a la dirección
     * @return la dirección encontrada, o null si no se encuentra ninguna
     * dirección asociada al usuario
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    @Override
    public Direccion consultarDireccion(int idUsuario) throws PersistenciaException {
        try ( Connection con = this.conexion.crearConexion();  CallableStatement cs = con.prepareCall("{call consultar_direccion(?)}")) {

            cs.setInt(1, idUsuario);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                Direccion direccion = new Direccion();
                direccion.setCalle(rs.getString("CALLE"));
                direccion.setNumero(rs.getString("NUMERO"));
                direccion.setCodigoPostal(rs.getString("CODIGO_POSTAL"));
                return direccion;
            } else {
                throw new PersistenciaException("No se encontró ningúna direccion con el idUsuario proporcionado");
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al consultar la direccion", e);
            throw new PersistenciaException("Error al consultar la direccion", e);
        }
    }

}
