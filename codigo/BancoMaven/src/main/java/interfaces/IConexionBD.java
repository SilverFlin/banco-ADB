/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Elkur
 */
public interface IConexionBD  {
    
    Connection crearConexion()throws SQLException;
    
}
