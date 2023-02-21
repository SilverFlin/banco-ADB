package implementaciones;

import dominio.Operacion;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IOperacionesDAO;
import java.sql.Connection;
import java.sql.Date;
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
public class OperacionesDAO implements IOperacionesDAO {

    /**
     * Generador de conexiones
     */
    private final IConexionBD GENERADOR_CONEXIONES;
    /**
     * Logger de excepciones
     */
    private static final Logger LOG = Logger.getLogger(DomiciliosDAO.class.getName());

    /**
     * Constructor que recibe el generador de conexiones
     *
     * @param GENERADOR_CONEXIONES Generador de conexiones
     */
    public OperacionesDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    /**
     * Consulta la base de datos y trae la operacion que coincida con la id dada
     *
     * @param id identificador a encontrar
     * @return Operacion encontrada
     */
    @Override
    public Operacion consultar(int id) {
        /* Consultas */
        String SQLQuery = "SELECT fechaHora, detalles, idCuentaBancaria FROM operaciones WHERE id = ?";

        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(SQLQuery);) {
            /*
            Insertamos los valores a la consulta
             */
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            Operacion operacion = null;
            /*
            Extraemos la informacion de la consulta
             */
            if (resultado.next()) {
                Date fechaHora = resultado.getDate("fechaHora");
                String detalles = resultado.getString("detalles");
                int idCuentaBancaria = resultado.getInt("idCuentaBancaria");
                operacion = new Operacion(id, fechaHora, detalles, idCuentaBancaria);
            }

            /*
            Regresamos lo que encontramos
             */
            return operacion;

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }

    /**
     * Inserta en la base de datos la operacion dada
     *
     * @param operacion Operacion a insertar
     * @return Operacion insertada
     * @throws PersistenciaException Si ocurre una excepcion al conectarse a la
     * base
     */
    @Override
    public Operacion insertar(Operacion operacion) throws PersistenciaException {
        /* Consultas */
        String SQLQuery = "INSERT INTO operaciones(detalles, idCuentaBancaria) VALUES (?,?)";

        try (Connection conexion = GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(SQLQuery, Statement.RETURN_GENERATED_KEYS);) {
            /*
            Insertamos nuestros valores a la insercion
             */
            comando.setString(1, operacion.getDetalles());
            comando.setInt(2, operacion.getIdCuentaBancaria());

            comando.executeUpdate();

            ResultSet llavesGeneradas = comando.getGeneratedKeys();

            /*
            Extraemos las llave generadas
             */
            if (llavesGeneradas.next()) {
                Integer llavePrimaria = llavesGeneradas.getInt(1);
                operacion.setId(llavePrimaria);
                return operacion;
            }
            /*
            Lanzamos una excepcion si no genero llaves
             */
            throw new PersistenciaException("operacion registrado pero ID no generado");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible registrar la operacion");
        }
    }

    /**
     * Consulta la lista de operaciones de una cuenta bancaria mediante su ID
     *
     * @param configPaginado Configuracion del paginado
     * @param idCuentaBancaria Identificador de la cuenta para buscar
     * operaciones
     * @return Lista de operaciones de la cuenta
     * @throws PersistenciaException Si ocurre una excepcion al conectarse a la
     * base
     */
    @Override
    public List<Operacion> consultar(ConfiguracionPaginado configPaginado, int idCuentaBancaria) throws PersistenciaException {
        /* Consultas */
        String codigoSQL = "SELECT id, fechaHora, detalles, idCuentaBancaria "
                + "FROM operaciones WHERE idCuentaBancaria = ? LIMIT ? OFFSET ?";
        List<Operacion> listaOperaciones = new LinkedList<>();
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            /*
            Insertamos nuestra informacion en la consulta
             */
            comando.setInt(1, idCuentaBancaria);
            comando.setInt(2, configPaginado.getLimite());
            comando.setInt(3, configPaginado.getOffset());
            ResultSet resultado = comando.executeQuery();

            /*
            Extraemos la informacion
             */
            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                Date fechaHora = resultado.getDate("fechaHora");
                String detalles = resultado.getString("detalles");
                Operacion operacion = new Operacion(id, fechaHora, detalles, idCuentaBancaria);
                listaOperaciones.add(operacion);
            }
            /*
            Mandamos la informacion
             */
            return listaOperaciones;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible consultar la lista de clientes");
        }
    }

    /**
     * Consulta en la base la lista de operaciones asociadas al id del cliente
     * dado
     *
     * @param configPaginado Configuracion de paginado
     * @param idCliente Identificador del cliente para buscar
     * @return Lista de operaciones asociadas a la cuenta
     * @throws PersistenciaException Si ocurre una excepcion al conectarse a la
     * base
     */
    @Override
    public List<Operacion> consultar(ConfiguracionPaginado configPaginado, String idCliente) throws PersistenciaException {
        /* Consultas */
        String codigoSQL = "SELECT cu.noCuenta, op.id, op.fechaHora, op.detalles, op.idCuentaBancaria "
                + "FROM operaciones op INNER JOIN cuentasBancarias cu INNER JOIN clientes cl "
                + "ON op.idCuentaBancaria = cu.id AND cu.idCliente = cl.id WHERE cl.id = ? LIMIT ? OFFSET ?";
        List<Operacion> listaOperaciones = new LinkedList<>();
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            
            /*
            Insertamos en la consulta la informacion que tenemos
            */
            comando.setInt(1, Integer.parseInt(idCliente));
            comando.setInt(2, configPaginado.getLimite());
            comando.setInt(3, configPaginado.getOffset());
            ResultSet resultado = comando.executeQuery();
            
            /*
            Extraemos la informacion
            */
            while (resultado.next()) {
                String noCuenta = resultado.getString("noCuenta");
                Integer id = resultado.getInt("id");
                Date fechaHora = resultado.getDate("fechaHora");
                String detalles = resultado.getString("detalles");
                int idCuentaBancaria = resultado.getInt("idCuentaBancaria");
                Operacion operacion = new Operacion(id, fechaHora, detalles, idCuentaBancaria, noCuenta);
                listaOperaciones.add(operacion);
            }
            
            /*
            Regresamos la informacion
            */
            return listaOperaciones;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible consultar la lista de clientes");
        }
    }

}
