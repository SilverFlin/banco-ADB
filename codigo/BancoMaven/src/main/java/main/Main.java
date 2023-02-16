/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import dominio.ClienteBorrar;
import dominio.CuentaBancaria;
import excepciones.PersistenciaException;
import implementacion.ConexionBD;
import implementacion.CuentasBancariasDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasBancariasDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentacion.MenuPrincipalForm;
import utils.ConfiguracionPaginado;

/**
 *
 * @author Toled
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Pruebas, borrar*/
        IConexionBD conexion = new ConexionBD("jdbc:mysql://localhost:3306/banco_transacciones", "root", "325a7fd7a79a");
        ICuentasBancariasDAO cuentasBancariasDAO = new CuentasBancariasDAO(conexion);
        CuentaBancaria cuentaBancaria;
        ClienteBorrar cliente = new ClienteBorrar(5);
        MenuPrincipalForm menuPrincipal = new MenuPrincipalForm(cuentasBancariasDAO,cliente);
        menuPrincipal.setVisible(true);
        
        
    }
    
}
