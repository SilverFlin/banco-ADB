/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConfiguracionPaginado;

/**
 *
 * @author Elkur
 */
public class ClientesDAO implements IClientesDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES;

    public ClientesDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    @Override
    public Cliente consultar(String correo) {
        String SQLQuery = "SELECT id, nombres, apellidoPaterno,apellidoMaterno, fechaNacimiento,idDomicilio,password FROM CLIENTES WHERE correo=?;";

        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(SQLQuery);) {

            comando.setString(1, correo);
            ResultSet resultado = comando.executeQuery();

            Cliente cliente = null;
            if (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombres");
                String apellidoPaterno = resultado.getString("apellidoPaterno");
                String apellidoMaterno = resultado.getString("apellidoMaterno");
                String fechaNacimiento = resultado.getString("fechaNacimiento");
                Integer idDireccion = resultado.getInt("idDomicilio");
                cliente = new Cliente(id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, idDireccion);
                cliente.setContrasenia(resultado.getString("password"));
            }

            return cliente;

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }

    @Override
    public Cliente insertar(Cliente cliente) throws PersistenciaException {
        String SQLQuery = "INSERT INTO clientes(nombres,apellidoPaterno, apellidoMaterno, fechaNacimiento, idDomicilio, correo, password) VALUES (?,?,?,?,?,?,?)";

        try (Connection conexion = GENERADOR_CONEXIONES.crearConexion(); 
                PreparedStatement comando = conexion.prepareStatement(SQLQuery, Statement.RETURN_GENERATED_KEYS);
                ) {

            comando.setString(1, cliente.getNombres());
            comando.setString(2, cliente.getApellidoP());
            comando.setString(3, cliente.getApellidoM());
            comando.setString(4, cliente.getFechaNacimiento());
            comando.setInt(5, cliente.getIdDomicilio());
            comando.setString(6, cliente.getCorreo());
            comando.setString(7, cliente.getContrasenia());
            comando.executeUpdate();

            ResultSet llavesGeneradas = comando.getGeneratedKeys();

            if (llavesGeneradas.next()) {
                Integer llavePrimaria = llavesGeneradas.getInt(1);
                cliente.setId(llavePrimaria);
                return cliente;
            }
            throw new PersistenciaException("Cliente registrado pero ID no generado");

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible registrar al cliente");

        }
    }


    @Override
    public Cliente editar(Cliente cliente) throws PersistenciaException {
        String SQLQuery = "UPDATE clientes SET password = ? WHERE id = ?";

        try (Connection conexion = GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(SQLQuery);) {

            comando.setString(1, cliente.getContrasenia());
            comando.setInt(2, cliente.getId());

            int numeroClientesEditados = comando.executeUpdate();
            return numeroClientesEditados > 0 ? cliente : null;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible editar al cliente");

        }
    }

    @Override
    public List<Cliente> consultar(ConfiguracionPaginado configPaginado) throws PersistenciaException {
        String SQLQuery = "SELECT id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, idDomicilio "
                + "FROM clientes LIMIT ? OFFSET ?";
        List<Cliente> listaClientes = new LinkedList<>();
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); 
                PreparedStatement comando = conexion.prepareStatement(SQLQuery);
                ) {

            comando.setInt(1, configPaginado.getLimite());
            comando.setInt(2, configPaginado.getOffset());
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                
                Integer id = resultado.getInt("id");
                String nombre = resultado.getString("nombres");
                String apellido_paterno = resultado.getString("apellidoPaterno");
                String apellido_materno = resultado.getString("apellidoMaterno");
                String fechaNacimiento = resultado.getString("fechaNacimiento");
                Integer idDireccion = resultado.getInt("idDomicilio");
                
                Cliente cliente = new Cliente(id, nombre, apellido_paterno, apellido_materno,fechaNacimiento, idDireccion);
                listaClientes.add(cliente);
            }

            return listaClientes;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible consultar la lista de clientes");
        }
    }

}
