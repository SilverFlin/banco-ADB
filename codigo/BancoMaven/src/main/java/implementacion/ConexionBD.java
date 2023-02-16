/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

/**
 *
 * @author Toled
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.IConexionBD;

/**
 *
 * @author Toled
 */
public class ConexionBD implements IConexionBD{
    private String CADENA_CONEXION;
    private String USUARIO;
    private String PASSWORD;

    public ConexionBD(String cadenaConexion, String usuario, String password) {
        this.CADENA_CONEXION = cadenaConexion;
        this.USUARIO = usuario;
        this.PASSWORD = password;
       
    }
    
    @Override
    public Connection crearConexion() throws SQLException{
        
         Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASSWORD);
         if(conexion == null) throw new SQLException();
         
        return conexion;
    }
    
}

