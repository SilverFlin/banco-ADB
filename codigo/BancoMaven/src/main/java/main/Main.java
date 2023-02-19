/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import dominio.Cliente;
import dominio.ClienteBorrar;
import dominio.CuentaBancaria;
import dominio.EstadoRetiroSinCuenta;
import dominio.RetiroSinCuenta;
import dominio.Transferencia;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import implementaciones.CuentasBancariasDAO;
import implementaciones.RetirosSinCuentaDAO;
import implementaciones.TransferenciasDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasBancariasDAO;
import interfaces.IRetirosSinCuentaDAO;
import interfaces.ITransferenciasDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;
import presentacion.IniciarSesionForm;
import presentacion.CuentasForm;
import presentacion.MenuPrincipalForm;
import presentacion.RegistroClienteForm;
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
        IConexionBD conexion = new ConexionBD("jdbc:mysql://localhost:3306/banco_transacciones", "root", System.getenv("passSQL"));

        /*Prueba Cuenta Bancaria*/
        IClientesDAO clientesDAO = new ClientesDAO(conexion);
        Cliente cliente = new Cliente("Luis", "Toledo", "Russo", "2022-12-06", 1);
        cliente.setCorreo("admin");
        cliente.setContrasenia(BCrypt.hashpw("admin", BCrypt.gensalt()));
        try {
            clientesDAO.insertar(cliente);
        } catch (PersistenciaException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        IniciarSesionForm clienteForm = new IniciarSesionForm(conexion);
        clienteForm.setVisible(true);
        
    }

}
