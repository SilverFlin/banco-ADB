package implementaciones;

import dominio.CuentaBancaria;
import dominio.EstadoRetiroSinCuenta;
import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IRetirosSinCuentaDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConfiguracionPaginado;
import static utils.DominioDeResultSet.crearRetiroSinCuenta;

/**
 *
 * @author Toled
 */
public class RetirosSinCuentaDAO implements IRetirosSinCuentaDAO {

    /**
     * Logger de excepciones
     */
    private static final Logger LOG = Logger.getLogger(RetirosSinCuentaDAO.class.getName());
    /**
     * Generador de conexiones
     */
    private final IConexionBD GENERADOR_CONEXIONES;

    /**
     * Nombre de la tabla empleada comunmente
     */
    private final String NOMBRE_TABLA = "retirosSinCuenta";
    /**
     * Estados del retiro sin cuenta
     */
    public static final String ESTADO_RETIRO_COBRADO = "Cobrado";
    public static final String ESTADO_RETIRO_PENDIENTE = "Pendiente";
    public static final String ESTADO_RETIRO_EXPIRADO = "Expirado";

    /**
     * Constructor que recibe el generador de conexiones
     *
     * @param GENERADOR_CONEXIONES Generador de conexiones
     */
    public RetirosSinCuentaDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    /**
     * Consulta la base de dato y trae el retiro que coincida con la id dada
     *
     * @param id identificador a buscar
     * @return Retiro sin cuenta encontrado
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    @Override
    public RetiroSinCuenta consultar(int id) throws PersistenciaException {
        /* Consultas */
        String query
                = "SELECT id, password, monto, folio, "
                + " estado, fechaInicio, fechaFin, idCuentaBancaria "
                + "FROM " + NOMBRE_TABLA + " WHERE id = ?;";
        try (Connection con = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement updateClientes = con.prepareStatement(query);) {


            /* Asignar valores a consulta*/
            Integer posicionId = 1;
            updateClientes.setInt(posicionId, id);
            /* Ejecutar Consulta */
            ResultSet result = updateClientes.executeQuery();
            if (result.next()) {
                /* Sacar valores de la consulta y crear RetiroSinCuenta*/
                RetiroSinCuenta retiroSinCuenta = crearRetiroSinCuenta(result);
                return retiroSinCuenta;
            }
            throw new PersistenciaException("No se encontro el retiro");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("Error en la conexion");
        }
    }

    /**
     * Consulta la base y trae el retiro que tenga el folio dado
     *
     * @param folio folio a buscar
     * @return Retiro sin cuenta encontrado
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    @Override
    public RetiroSinCuenta consultar(String folio) throws PersistenciaException {
        /* Consultas */
        String query
                = "SELECT id, password, monto, folio, "
                + " estado, fechaInicio, fechaFin, idCuentaBancaria "
                + "FROM " + NOMBRE_TABLA + " WHERE folio = ?;";
        try (Connection con = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement updateClientes = con.prepareStatement(query);) {


            /* Asignar valores a consulta*/
            Integer posicionFolio = 1;
            updateClientes.setString(posicionFolio, folio);
            /* Ejecutar Consulta */
            ResultSet result = updateClientes.executeQuery();
            if (result.next()) {
                /* Sacar valores de la consulta y crear RetiroSinCuenta*/
                RetiroSinCuenta retiroSinCuenta = crearRetiroSinCuenta(result);
                return retiroSinCuenta;
            }
            throw new PersistenciaException("No se encontro el retiro");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("Error en la conexion");
        }
    }

    /**
     * consulta en la base los retiros sin cuenta que coincidan con la id de
     * cuenta dada
     *
     * @param configPaginado Configuracion de paginado
     * @param idCuentaBancaria identificador de cuenta para buscar
     * @return Lista de retiros sin cuenta
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    @Override
    public List<RetiroSinCuenta> consultar(ConfiguracionPaginado configPaginado, int idCuentaBancaria) throws PersistenciaException {
        try (Connection con = this.GENERADOR_CONEXIONES.crearConexion()) {
            /* Consultas */
            String query
                    = "SELECT id, password, monto, folio, "
                    + " estado, fechaInicio, fechaFin, idCuentaBancaria "
                    + "FROM " + NOMBRE_TABLA + " WHERE idCuentaBancaria = ? "
                    + " LIMIT ? OFFSET ?;";
            /* Crear Consultas */
            PreparedStatement updateClientes = con.prepareStatement(query);
            updateClientes.setInt(1, idCuentaBancaria);
            updateClientes.setInt(2, configPaginado.getLimite());
            updateClientes.setInt(3, configPaginado.getOffset());
            List<RetiroSinCuenta> listaRetiros = new LinkedList<>();
            /* Ejecutar Consulta */
            ResultSet result = updateClientes.executeQuery();
            while (result.next()) {
                /* Sacar valores de la consulta y crear el retiro*/
                RetiroSinCuenta retiroSinCuenta = crearRetiroSinCuenta(result);
                listaRetiros.add(retiroSinCuenta);
            }
            return listaRetiros;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("Error al consultar cuentas");
        }
    }

    /**
     * Inserta en la base el retiro sin cuenta dado en el parametro
     *
     * @param retiroSinCuenta Retiro sin cuenta a insertar
     * @param cuentaBancaria Cuenta auxiliar
     * @return Retiro sin cuenta insertado
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    @Override
    public RetiroSinCuenta insertar(RetiroSinCuenta retiroSinCuenta, CuentaBancaria cuentaBancaria) throws PersistenciaException {
        /* Consultas */
        String insertStatement = "{CALL CustomExpiracionRetiroSinCuenta(?,?,?,?,?)}";
        Connection con = null;
        try {
            con = this.GENERADOR_CONEXIONES.crearConexion();
            CallableStatement callableStatement = con.prepareCall(insertStatement);
            /*Iniciando Transaccion*/
            con.setAutoCommit(false);

            /* Asignar valores a Stored Procedure*/
            callableStatement.setString(1, retiroSinCuenta.getPassword());
            callableStatement.setDouble(2, retiroSinCuenta.getMonto());
            callableStatement.setString(3, retiroSinCuenta.getTiempoExpiracion());
            callableStatement.setInt(4, retiroSinCuenta.getIdCuentaBancaria());
            callableStatement.registerOutParameter(5, Types.INTEGER);


            /* Ejecutar las consultas */
            callableStatement.execute();
            int id = callableStatement.getInt(5);
            retiroSinCuenta.setId(id);

            con.commit();

            return retiroSinCuenta;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    LOG.log(Level.SEVERE, ex.getMessage());
                    throw new PersistenciaException("Error al hacer rollback");
                }
            }
            throw new PersistenciaException("Error en la conexi??n");
        }
    }

    /**
     * Elimina de la base el retiro que tenga la misma id dada
     *
     * @param id identificador a eliminar
     * @return Retiro eliminado
     */
    @Override
    public RetiroSinCuenta eliminar(Integer id) {
        /* Consultas */
        String deleteStatement = "DELETE FROM " + NOMBRE_TABLA + " WHERE id = ?;";
        try (Connection con = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement deleteRetiro = con.prepareStatement(deleteStatement);) {
            /* Verificar si la cuenta existe*/
            RetiroSinCuenta retiroSinCuenta = null;
            try {
                retiroSinCuenta = this.consultar(id); // Remover
            } catch (PersistenciaException ex) {
                LOG.log(Level.SEVERE, ex.getMessage());
            }

            if (retiroSinCuenta == null) {
                return null;
            }

            /* Asignar valores a consulta INSERT*/
            deleteRetiro.setInt(1, id);

            /* Ejecutar las consultas */
            deleteRetiro.executeUpdate(); // Regresa las lineas alteradas

            return retiroSinCuenta;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    /**
     * Actualiza en la base el retiro dado en el parametro
     *
     * @param retiroSinCuenta retiro a actualizar
     * @return retiro actualizado
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    @Override
    public RetiroSinCuenta actualizar(RetiroSinCuenta retiroSinCuenta) throws PersistenciaException {

        /* Consultas */
        String updateStatement = "UPDATE " + NOMBRE_TABLA + " SET "
                + "estado = ? "
                + "WHERE id = ?";
        try (Connection con = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement updateRetiro = con.prepareStatement(updateStatement, Statement.RETURN_GENERATED_KEYS);) {

            /* Asignar valores a consulta INSERT*/
            // TODO Mover
            String estado;
            switch (retiroSinCuenta.getEstado()) {
                case COBRADO:
                    estado = ESTADO_RETIRO_COBRADO;
                    break;
                case PENDIENTE:
                    estado = ESTADO_RETIRO_PENDIENTE;
                    break;
                default:
                    estado = ESTADO_RETIRO_EXPIRADO;
                    break;
            }
            updateRetiro.setString(1, estado);
            updateRetiro.setInt(2, retiroSinCuenta.getId());

            /* Ejecutar las consultas */
            updateRetiro.executeUpdate();

            return retiroSinCuenta;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("Error en la conexi??n");
        }
    }

    /**
     * Retira y actualiza el retiro sin cuenta de la base
     *
     * @param retiroSinCuenta retiro a realizar
     * @return Retiro realizado
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    @Override
    public RetiroSinCuenta retirar(RetiroSinCuenta retiroSinCuenta) throws PersistenciaException {
        /* Consultas */
        String insertStatement = "{CALL CobrarRetiroSinCuenta(?,?,?)}";
        Connection con = null;
        try {
            con = this.GENERADOR_CONEXIONES.crearConexion();
            CallableStatement callableStatement = con.prepareCall(insertStatement);
            /*Iniciando Transaccion*/
            con.setAutoCommit(false);

            /* Asignar valores a Stored Procedure*/
            callableStatement.setString(1, retiroSinCuenta.getFolio());
            callableStatement.setInt(2, retiroSinCuenta.getIdCuentaBancaria());
            callableStatement.setDouble(3, retiroSinCuenta.getMonto());

            /* Ejecutar las consultas */
            callableStatement.execute();

            con.commit();

            retiroSinCuenta.setEstado(EstadoRetiroSinCuenta.COBRADO);
            return retiroSinCuenta;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    LOG.log(Level.SEVERE, ex.getMessage());
                    throw new PersistenciaException("Error al hacer rollback");
                }
            }
            throw new PersistenciaException("Error en la conexi??n");
        }
    }

}
