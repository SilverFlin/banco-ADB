package interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Elkur, Toled
 */
public interface IConexionBD {

    /**
     * Establece la conexion con la base con las credenciales que almacena
     *
     * @return Objeto de gestion de conexion
     * @throws SQLException Si ocurre una excepcion al conectarse
     */
    Connection crearConexion() throws SQLException;

}
