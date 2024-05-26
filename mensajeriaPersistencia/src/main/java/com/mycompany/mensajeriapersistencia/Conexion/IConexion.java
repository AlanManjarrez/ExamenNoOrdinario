
package com.mycompany.mensajeriapersistencia.Conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interfaz para la creación de conexiones.
 * 
 * Esta interfaz define un método para crear una conexión a una base de datos.
 * Implementaciones específicas proporcionarán los detalles para establecer 
 * la conexión a diferentes tipos de bases de datos.
 * 
 * 
 * @author Jose Alan Manjarrez Ontiveros 228982
 */
public interface IConexion {
    
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
    public Connection crearConexion() throws SQLException;
}
