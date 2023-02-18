/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.CuentaBancaria;
import dominio.EstadoRetiroSinCuenta;
import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IRetirosSinCuentaDAO;
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
 * @author Toled
 */
public class RetirosSinCuentaDAO implements IRetirosSinCuentaDAO {

    private static final Logger LOG = Logger.getLogger(RetirosSinCuentaDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES;

    private final String NOMBRE_TABLA = "retirosSinCuenta";
    private final String ESTADO_RETIRO_COBRADO = "Cobrado";
    private final String ESTADO_RETIRO_PENDIENTE = "Pendiente";

    public RetirosSinCuentaDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    @Override
    public RetiroSinCuenta consultar(int id) throws PersistenciaException {
        /* Consultas */
        String query
                = "SELECT id, password, monto, folio, "
                + " Estado, fechaInicio, fechaFin, idCuentaBancaria "
                + "FROM " + NOMBRE_TABLA + " WHERE id = ?;";
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement updateClientes = con.prepareStatement(query);) {


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

    @Override
    public RetiroSinCuenta consultar(String folio) throws PersistenciaException {
        /* Consultas */
        String query
                = "SELECT id, password, monto, folio, "
                + " Estado, fechaInicio, fechaFin, idCuentaBancaria "
                + "FROM " + NOMBRE_TABLA + " WHERE folio = ?;";
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement updateClientes = con.prepareStatement(query);) {


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

    @Override
    public List<RetiroSinCuenta> consultar(ConfiguracionPaginado configPaginado, int idCuentaBancaria) throws PersistenciaException {
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion()) {
            /* Consultas */
            String query
                    = "SELECT id, password, monto, folio, "
                    + " Estado, fechaInicio, fechaFin, idCuentaBancaria "
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

    @Override
    public RetiroSinCuenta insertar(RetiroSinCuenta retiroSinCuenta, CuentaBancaria cuentaBancaria) throws PersistenciaException {
        /* Consultas */
        String insertStatement = "INSERT INTO " + NOMBRE_TABLA
                + " (password, monto, folio, Estado, fechaInicio, fechaFin, "
                + "idCuentaBancaria) VALUES (?,?,?,?,?,?)";
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement insertRetiro = con.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);) {

            /* Asignar valores a consulta INSERT*/
            insertRetiro.setString(1, retiroSinCuenta.getPassword());
            insertRetiro.setDouble(2, retiroSinCuenta.getMonto());
            String estado = retiroSinCuenta.getEstado() == EstadoRetiroSinCuenta.COBRADO ? ESTADO_RETIRO_COBRADO : ESTADO_RETIRO_PENDIENTE;
            insertRetiro.setString(3, estado);
            insertRetiro.setString(4, retiroSinCuenta.getFechaInicio());
            insertRetiro.setString(5, retiroSinCuenta.getFechaFin());
            insertRetiro.setInt(6, retiroSinCuenta.getId());

            /* Ejecutar las consultas */
            insertRetiro.executeUpdate();

            ResultSet llavesGeneradas = insertRetiro.getGeneratedKeys();
            /* Validar consultas*/
            if (llavesGeneradas.next()) {
                retiroSinCuenta.setId(llavesGeneradas.getInt(Statement.RETURN_GENERATED_KEYS));
                return retiroSinCuenta;
            }

            throw new PersistenciaException("Error al insertar retiro");

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("Error en la conexión");
        }
    }

    @Override
    public RetiroSinCuenta eliminar(Integer id) {
        /* Consultas */
        String deleteStatement = "DELETE FROM " + NOMBRE_TABLA + " WHERE id = ?;";
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement deleteRetiro = con.prepareStatement(deleteStatement);) {
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

    @Override
    public RetiroSinCuenta actualizar(RetiroSinCuenta retiroSinCuenta) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private RetiroSinCuenta crearRetiroSinCuenta(ResultSet result) throws SQLException {
        /*Extraer del ResultSet*/
        Integer resultId = Integer.parseInt(result.getString("id"));
        String password = result.getString("password");
        Double monto = result.getDouble("monto");
        String folio = result.getString("folio");
        String estadoTransferencia = result.getString("Estado");
        String fechaInicio = result.getString("fechaInicio");
        String fechaFin = result.getString("fechaFin");
        Integer idCuenta = result.getInt("idCuentaBancaria");

        /* Crear CuentaBancaria*/
        EstadoRetiroSinCuenta enumEstadoCuenta;
        if (estadoTransferencia.equals(ESTADO_RETIRO_COBRADO)) {
            enumEstadoCuenta = EstadoRetiroSinCuenta.COBRADO;
        } else {
            enumEstadoCuenta = EstadoRetiroSinCuenta.PENDIENTE;
        }
        RetiroSinCuenta retiroSinCuenta;
        retiroSinCuenta = new RetiroSinCuenta(fechaInicio, fechaFin, enumEstadoCuenta, monto, password, folio, idCuenta);
        retiroSinCuenta.setId(resultId);
        return retiroSinCuenta;
    }

}
