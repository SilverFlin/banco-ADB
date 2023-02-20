package main;

import dominio.Cliente;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;
import presentacion.IniciarSesionForm;

/**
 *
 * @author Toled
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Conexion*/
        IConexionBD conexion = new ConexionBD("jdbc:mysql://localhost:3306/banco_transacciones", "root", System.getenv("passSQL"));

        /*Cuenta de pruebas*/
        IClientesDAO clientesDAO = new ClientesDAO(conexion);
        Cliente cliente = new Cliente("Luis", "Toledo", "Russo", "2022-12-06", 1);
        cliente.setCorreo("admin");
        cliente.setContrasenia(BCrypt.hashpw("admin", BCrypt.gensalt()));
        try {
            clientesDAO.insertar(cliente);
        } catch (PersistenciaException ex) {
            
        }

        /*Iniciar Programa*/
        IniciarSesionForm clienteForm = new IniciarSesionForm(conexion);
        clienteForm.setVisible(true);
        
    }

}
