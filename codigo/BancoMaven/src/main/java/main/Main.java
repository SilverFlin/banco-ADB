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
import implementaciones.ConexionBD;
import implementaciones.CuentasBancariasDAO;
import implementaciones.RetirosSinCuentaDAO;
import implementaciones.TransferenciasDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasBancariasDAO;
import interfaces.IRetirosSinCuentaDAO;
import interfaces.ITransferenciasDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentacion.ClienteForm;
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
        IConexionBD conexion = new ConexionBD("jdbc:mysql://localhost:3306/banco_transacciones", "root", System.getenv("MySQLpass"));

        /*Prueba Cuenta Bancaria*/
        ICuentasBancariasDAO cuentasBancariasDAO = new CuentasBancariasDAO(conexion);
//        CuentaBancaria cuentaBancaria;
        Cliente cliente = new Cliente(101);
//        MenuPrincipalForm menuPrincipal = new MenuPrincipalForm(cuentasBancariasDAO,cliente);
//        menuPrincipal.setVisible(true);

        /*Prueba transferencia*/
//        ITransferenciasDAO transferenciasDAO = new TransferenciasDAO(conexion);
//        try {
//            transferenciasDAO.insertar(new Transferencia("2021-04-24 21:26:41", 15.3, 2, 5));
//            transferenciasDAO.insertar(new Transferencia("2021-04-24 21:26:41", 15.3, 2, 6));
//            System.out.println(transferenciasDAO.consultarOrigen(new ConfiguracionPaginado(), 2));
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        ClienteForm cuentasForm = new ClienteForm(conexion);
//        cuentasForm.setVisible(true);

        /*Prueba Retiros*/
        IRetirosSinCuentaDAO retirosSinCuentaDAO = new RetirosSinCuentaDAO(conexion);
//        try {
//            CuentaBancaria cuentaBancaria = cuentasBancariasDAO.consultar(1);
//            System.out.println(cuentaBancaria);
//            RetiroSinCuenta retiroSinCuenta = new RetiroSinCuenta(
//                    "2021-04-24 21:26:41",
//                    "2021-05-24 21:26:41", 
//                    EstadoRetiroSinCuenta.PENDIENTE,
//                    15.3,
//                    "123123",
//                    "33333", 
//                    cuentaBancaria.getId());
//            
//            
//            retiroSinCuenta = retirosSinCuentaDAO.insertar(retiroSinCuenta, cuentaBancaria);
//            System.out.println(retirosSinCuentaDAO.consultar("33333"));
//            System.out.println(retirosSinCuentaDAO.consultar(retiroSinCuenta.getId()));
//            retiroSinCuenta.setEstado(EstadoRetiroSinCuenta.EXPIRADO);
//            retirosSinCuentaDAO.actualizar(retiroSinCuenta);
//            System.out.println(retirosSinCuentaDAO.consultar(retiroSinCuenta.getId()));
//            retirosSinCuentaDAO.eliminar(retiroSinCuenta.getId());
//            System.out.println(retirosSinCuentaDAO.consultar(retiroSinCuenta.getId()));
//        } catch (PersistenciaException e) {
//            System.out.println(e.getMessage());
//        }
            ClienteForm clienteForm = new ClienteForm(conexion);
            clienteForm.setVisible(true);

//            6068 6841 2454 6781 > 69390936
    }

}
