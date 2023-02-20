package interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Elkur, Toled
 */
public interface IConexionBD  {
    
    Connection crearConexion()throws SQLException;
    
}
