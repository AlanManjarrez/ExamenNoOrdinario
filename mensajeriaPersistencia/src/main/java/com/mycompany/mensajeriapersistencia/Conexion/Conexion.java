package com.mycompany.mensajeriapersistencia.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de IConexion para una base de datos específica.
 * 
 * Proporciona la lógica necesaria para establecer una conexión a la base de datos.
 * 
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public class Conexion implements IConexion {

    final private String cadenaConexion = "jdbc:mysql://localhost:3306/mensajeria";
    final private String usuario = "root";
    final private String contra = "0990";
    private static final Logger LOG = Logger.getLogger(Conexion.class.getName());

    public Conexion() {
    }
    /**
     * Crea una nueva conexión a la base de datos.
     * 
     * Este método debe ser implementado para establecer una conexión a una base 
     * de datos específica y devolver un objeto {@code Connection} que represente 
     * esa conexión.
     * 
     *
     * @return una conexión a la base de datos
     * @throws SQLException si ocurre un error al intentar establecer la conexión
     */
    @Override
    public Connection crearConexion() throws SQLException {
        try {
            Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, contra);
            LOG.log(Level.INFO, "Conexión exitosa: {0}", cadenaConexion);
            return conexion;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Conexión fallida: {0}", cadenaConexion);
            LOG.log(Level.SEVERE, "Error: ", e);
            throw e;
        }
    }
}
