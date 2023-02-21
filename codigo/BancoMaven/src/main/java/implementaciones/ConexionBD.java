package implementaciones;

import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Elkur
 */
public class ConexionBD implements IConexionBD {
    
    /**
     * Cadena de  texto que contiene la informacion de conexion a la base
     */
    private final String CADENA_CONEXION;
    /**
     * Usuario de acceso a la base
     */
    private final String USUARIO;
    /**
     * Contrasenia de acceso a la base
     */
    private final String PASSWORD;
    
    /**
     * Constructor que recibe las credenciales de acceso a la base
     * @param CADENA_CONEXION Cadena de  texto que contiene la informacion de conexion a la base
     * @param USUARIO Usuario de acceso a la base
     * @param PASSWORD Contrasenia de acceso a la base
     */
    public ConexionBD(String CADENA_CONEXION, String USUARIO, String PASSWORD) {
        this.CADENA_CONEXION = CADENA_CONEXION;
        this.USUARIO = USUARIO;
        this.PASSWORD = PASSWORD;
    }
    
    /**
     * Establece la conexion con la base con las credenciales que almacena
     * @return Objeto de gestion de conexion
     * @throws SQLException Si ocurre una excepcion al conectarse
     */
    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASSWORD);
        return conexion;
    }
}
