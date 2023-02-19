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
    private final String ESTADO_RETIRO_EXPIRADO = "Expirado";

    public RetirosSinCuentaDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    @Override
    public RetiroSinCuenta consultar(int id) throws PersistenciaException {
        /* Consultas */
        String query
                = "SELECT id, password, monto, folio, "
                + " estado, fechaInicio, fechaFin, idCuentaBancaria "
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
                + " estado, fechaInicio, fechaFin, idCuentaBancaria "
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

    @Override
    public RetiroSinCuenta insertar(RetiroSinCuenta retiroSinCuenta, CuentaBancaria cuentaBancaria) throws PersistenciaException {
        /* Consultas */
        String insertStatement = "INSERT INTO " + NOMBRE_TABLA
                + " (password, monto, folio, estado, fechaInicio, fechaFin, "
                + "idCuentaBancaria) VALUES (?,?,?,?,?,?,?);";
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement insertRetiro = con.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);) {

            /* Asignar valores a consulta INSERT*/
            insertRetiro.setString(1, retiroSinCuenta.getPassword());
            insertRetiro.setDouble(2, retiroSinCuenta.getMonto());
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
            insertRetiro.setString(3, retiroSinCuenta.getFolio());
            insertRetiro.setString(4, estado);
            insertRetiro.setString(5, retiroSinCuenta.getFechaInicio());
            insertRetiro.setString(6, retiroSinCuenta.getFechaFin());
            insertRetiro.setInt(7, cuentaBancaria.getId());
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

        /* Consultas */
        String updateStatement = "UPDATE " + NOMBRE_TABLA + " SET "
                + "estado = ? "
                + "WHERE id = ?";
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement updateRetiro = con.prepareStatement(updateStatement, Statement.RETURN_GENERATED_KEYS);) {

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
            throw new PersistenciaException("Error en la conexión");
        }
    }

    private RetiroSinCuenta crearRetiroSinCuenta(ResultSet result) throws SQLException {
        /*Extraer del ResultSet*/
        Integer resultId = Integer.parseInt(result.getString("id"));
        String password = result.getString("password");
        Double monto = result.getDouble("monto");
        String folio = result.getString("folio");
        String estadoTransferencia = result.getString("estado");
        String fechaInicio = result.getString("fechaInicio");
        String fechaFin = result.getString("fechaFin");
        Integer idCuenta = result.getInt("idCuentaBancaria");

        /* Crear CuentaBancaria*/
        EstadoRetiroSinCuenta enumEstadoCuenta;
        if (estadoTransferencia.equals(ESTADO_RETIRO_COBRADO)) {
            enumEstadoCuenta = EstadoRetiroSinCuenta.COBRADO;
        } else if (estadoTransferencia.equals(ESTADO_RETIRO_PENDIENTE)) {
            enumEstadoCuenta = EstadoRetiroSinCuenta.PENDIENTE;
        } else {
            enumEstadoCuenta = EstadoRetiroSinCuenta.EXPIRADO;
        }
        RetiroSinCuenta retiroSinCuenta;
        retiroSinCuenta = new RetiroSinCuenta(fechaInicio, fechaFin, enumEstadoCuenta, monto, password, idCuenta);
        retiroSinCuenta.setId(resultId);
        retiroSinCuenta.setFolio(folio);
        return retiroSinCuenta;
    }

}
