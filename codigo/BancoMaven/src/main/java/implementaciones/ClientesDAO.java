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

    /**
     * Logger de excepciones
     */
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    /**
     * Generador de conexiones
     */
    private final IConexionBD GENERADOR_CONEXIONES;

    /**
     * Constructor que recibe el generador de conexiones
     *
     * @param GENERADOR_CONEXIONES Generador de conexiones
     */
    public ClientesDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    /**
     * Consulta en la base de datos el cliente que tenga el correo mandado en el
     * parametro
     *
     * @param correo Correo a comparar
     * @return Cliente que tenga el correo
     */
    @Override
    public Cliente consultar(String correo) {
        /* Consultas */
        String SQLQuery = "SELECT id, nombres, apellidoPaterno,apellidoMaterno, fechaNacimiento,idDomicilio,password FROM CLIENTES WHERE correo=?;";

        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(SQLQuery);) {
            /*
            Establecemos el correo del parametro en la consulta
             */
            comando.setString(1, correo);
            ResultSet resultado = comando.executeQuery();

            Cliente cliente = null;
            /*
            Extraemos el cliente de la consulta
             */
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

            /*
            Regresamos el cliente obtenido
             */
            return cliente;

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            /*
            En caso de alguna excepcion se regresa null de todas maneras
             */
            return null;
        }
    }

    /**
     * Inserta en la base de datos a un cliente dado en el parametro
     *
     * @param cliente Cliente a insertar
     * @return Cliente insertado
     * @throws PersistenciaException Si no se puede acceder a la base
     */
    @Override
    public Cliente insertar(Cliente cliente) throws PersistenciaException {
        /* Consultas */
        String SQLQuery = "INSERT INTO clientes(nombres,apellidoPaterno, apellidoMaterno, fechaNacimiento, idDomicilio, correo, password) VALUES (?,?,?,?,?,?,?)";

        try (Connection conexion = GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(SQLQuery, Statement.RETURN_GENERATED_KEYS);) {

            /*
            Establecemos los atributos del cliente en la insercion
             */
            comando.setString(1, cliente.getNombres());
            comando.setString(2, cliente.getApellidoP());
            comando.setString(3, cliente.getApellidoM());
            comando.setString(4, cliente.getFechaNacimiento());
            comando.setInt(5, cliente.getIdDomicilio());
            comando.setString(6, cliente.getCorreo());
            comando.setString(7, cliente.getContrasenia());
            comando.executeUpdate();

            ResultSet llavesGeneradas = comando.getGeneratedKeys();

            /*
            Extraemos la llave primaria que se genero en la insercion
             */
            if (llavesGeneradas.next()) {
                Integer llavePrimaria = llavesGeneradas.getInt(1);
                cliente.setId(llavePrimaria);
                /*
                Regresamos al cliente con su id generada
                 */
                return cliente;
            }
            /**
             * En caso de que no se genere una llave, se lanza una excepcion
             */
            throw new PersistenciaException("Cliente registrado pero ID no generado");

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible registrar al cliente");

        }
    }

    /**
     * Actualiza al cliente en la base de datos que coincida con el del
     * parametro
     *
     * @param cliente Cliente a actualizar
     * @return Cliente actualizado
     * @throws PersistenciaException Si no se tiene acceso a la base
     */
    @Override
    public Cliente actualizar(Cliente cliente) throws PersistenciaException {
        /* Consultas */
        String SQLQuery = "UPDATE clientes SET password = ? WHERE id = ?";

        try (Connection conexion = GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(SQLQuery);) {

            /*
            Establecemos los parametros del update
             */
            comando.setString(1, cliente.getContrasenia());
            comando.setInt(2, cliente.getId());

            int numeroClientesEditados = comando.executeUpdate();
            /*
            Si lo editamos regresamos el cliente, si no mandamos null
             */
            return numeroClientesEditados > 0 ? cliente : null;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible editar al cliente");

        }
    }

    /**
     * Consulta a los clientes con una configuracion de paginado
     *
     * @param configPaginado Configuracion del paginado
     * @return Lista de clientes
     * @throws PersistenciaException Si no se tiene acceso a la base
     */
    @Override
    public List<Cliente> consultar(ConfiguracionPaginado configPaginado) throws PersistenciaException {
        /* Consultas */
        String SQLQuery = "SELECT id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, idDomicilio "
                + "FROM clientes LIMIT ? OFFSET ?";
        List<Cliente> listaClientes = new LinkedList<>();
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(SQLQuery);) {

            /*
            Establecemos los atributos del paginado a la consulta
             */
            comando.setInt(1, configPaginado.getLimite());
            comando.setInt(2, configPaginado.getOffset());
            ResultSet resultado = comando.executeQuery();

            /*
            Guardamos los resultados en una lista
             */
            while (resultado.next()) {

                Integer id = resultado.getInt("id");
                String nombre = resultado.getString("nombres");
                String apellido_paterno = resultado.getString("apellidoPaterno");
                String apellido_materno = resultado.getString("apellidoMaterno");
                String fechaNacimiento = resultado.getString("fechaNacimiento");
                Integer idDireccion = resultado.getInt("idDomicilio");

                Cliente cliente = new Cliente(id, nombre, apellido_paterno, apellido_materno, fechaNacimiento, idDireccion);
                listaClientes.add(cliente);
            }

            /*
            Regresamos la lista de clientes
             */
            return listaClientes;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible consultar la lista de clientes");
        }
    }

}
