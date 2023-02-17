/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.ClienteBorrar;
import dominio.CuentaBancaria;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ICuentasBancariasDAO;
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
 * @author Toled
 */
public class CuentasBancariasDAO implements ICuentasBancariasDAO {

    private static final Logger LOG = Logger.getLogger(CuentasBancariasDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES;

    private final String NOMBRE_TABLA = "cuentasBancarias";
    private final String ESTADO_CUENTA_ACTIVO = "Activa";
    private final String ESTADO_CUENTA_INACTIVO = "Inactiva";

    public CuentasBancariasDAO(IConexionBD generarConexion) {
        this.GENERADOR_CONEXIONES = generarConexion;
    }

    /**
     * Regresa la cuenta bancaria en base al id proporcionado
     *
     * @param id
     * @return
     * @throws PersistenciaException
     */
    @Override
    public CuentaBancaria consultar(int id) throws PersistenciaException {
        /* Consultas */
        String query
                = "SELECT id, noCuenta, fechaApertura, saldoMXN, "
                + " estadoCuenta, idCliente "
                + "FROM " + NOMBRE_TABLA + " WHERE id = ?;";
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement updateClientes = con.prepareStatement(query);) {


            /* Asignar valores a consulta*/
            Integer posicionId = 1;
            updateClientes.setInt(posicionId, id);
            /* Ejecutar Consulta */
            ResultSet result = updateClientes.executeQuery();
            if (result.next()) {
                /* Sacar valores de la consulta y crear usuario*/
                CuentaBancaria cuentaBancaria = crearCuentaBancaria(result);
                return cuentaBancaria;
            }
            throw new PersistenciaException("No se encontro la cuenta bancaria");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("Error en la conexion");

        }
    }

    @Override
    public CuentaBancaria consultar(String noCuenta) throws PersistenciaException {
        /* Consultas */
        String query
                = "SELECT id, noCuenta, fechaApertura, saldoMXN, "
                + " estadoCuenta, idCliente "
                + "FROM " + NOMBRE_TABLA + " WHERE noCuenta = ?;";
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement updateClientes = con.prepareStatement(query);) {


            /* Asignar valores a consulta*/
            Integer posicionId = 1;
            updateClientes.setString(posicionId, noCuenta);
            /* Ejecutar Consulta */
            ResultSet result = updateClientes.executeQuery();
            if (result.next()) {
                /* Sacar valores de la consulta y crear usuario*/
                CuentaBancaria cuentaBancaria = crearCuentaBancaria(result);
                return cuentaBancaria;
            }
            throw new PersistenciaException("No se encontro la cuenta bancaria");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("Error en la conexion");

        }
    }

    /**
     * Inserta una cuenta bancaria, relacionandose con el id de un cliente.
     *
     * @param cuentaBancaria
     * @param cliente
     * @return la cuenta bancaria, pero con el id asignado por la base de datos.
     * @throws PersistenciaException
     */
    @Override
    public CuentaBancaria insertar(CuentaBancaria cuentaBancaria, ClienteBorrar cliente) throws PersistenciaException {

        /* Consultas */
        String insertStatement = "INSERT INTO " + NOMBRE_TABLA + " (noCuenta, saldoMXN, idCliente) "
                + "VALUES (?,?,?)";
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement insertCuenta = con.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);) {

            /* Asignar valores a consulta INSERT*/
            insertCuenta.setString(1, cuentaBancaria.getNoCuenta());
            insertCuenta.setDouble(2, cuentaBancaria.getSaldoMXN());
            insertCuenta.setInt(3, cliente.getId());

            /* Ejecutar las consultas */
            insertCuenta.executeUpdate();

            ResultSet llavesGeneradas = insertCuenta.getGeneratedKeys();
            /* Validar consultas*/
            if (llavesGeneradas.next()) {
                cuentaBancaria.setId(llavesGeneradas.getInt(Statement.RETURN_GENERATED_KEYS));
                return cuentaBancaria;
            }

            throw new PersistenciaException("Error al insertar cuenta");

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("Error en la conexión");
        }

    }

    /**
     * Elimina la cuenta bancaria de la base de datos, usando su id
     *
     * @param id
     * @return la cuenta bancaria eliminada o null si no existia
     */
    @Override
    public CuentaBancaria eliminar(Integer id) {
        /* Consultas */
        String deleteStatement = "DELETE FROM " + NOMBRE_TABLA + " WHERE id = ?;";
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement deleteClientes = con.prepareStatement(deleteStatement);) {


            /* Verificar si la cuenta existe*/
            CuentaBancaria cuentaBancaria = null;
            try {
                cuentaBancaria = this.consultar(id); // Remover
            } catch (PersistenciaException ex) {
                LOG.log(Level.SEVERE, ex.getMessage());
            }

            if (cuentaBancaria == null) {
                return null;
            }

            /* Asignar valores a consulta INSERT*/
            deleteClientes.setInt(1, id);

            /* Ejecutar las consultas */
            deleteClientes.executeUpdate(); // Regresa las lineas alteradas

            return cuentaBancaria;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }

    }

    @Override
    public List<CuentaBancaria> consultar(ConfiguracionPaginado configPaginado, int idCliente) throws PersistenciaException {
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion()) {
            /* Consultas */
            String query
                    = "SELECT id, noCuenta, fechaApertura, saldoMXN, "
                    + " estadoCuenta, idCliente "
                    + " FROM " + NOMBRE_TABLA
                    + " WHERE idCliente = ? "
                    + " LIMIT ? OFFSET ?;";
            /* Crear Consultas */
            PreparedStatement updateClientes = con.prepareStatement(query);
            updateClientes.setInt(1, idCliente);
            updateClientes.setInt(2, configPaginado.getLimite());
            updateClientes.setInt(3, configPaginado.getOffset());
            List<CuentaBancaria> listaCuentas = new LinkedList<>();
            /* Ejecutar Consulta */
            ResultSet result = updateClientes.executeQuery();
            while (result.next()) {
                /* Sacar valores de la consulta y crear usuario*/
                CuentaBancaria cuentaBancaria = crearCuentaBancaria(result);
                listaCuentas.add(cuentaBancaria);
            }
            return listaCuentas;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("Error al consultar cuentas");
        }
    }

    private CuentaBancaria crearCuentaBancaria(ResultSet result) throws SQLException {
        /*Extraer del ResultSet*/
        Integer resultId = Integer.parseInt(result.getString("id"));
        String noCuenta = result.getString("noCuenta");
        Date fechaApertura = result.getDate("fechaApertura");
        Double saldoMXN = result.getDouble("saldoMXN");
        String estadoCuenta = result.getString("estadoCuenta");
        Integer idCliente = result.getInt("idCliente");

        /* Crear CuentaBancaria*/
        CuentaBancaria.EstadoCuenta enumEstadoCuenta;
        if (estadoCuenta.equals(ESTADO_CUENTA_ACTIVO)) {
            enumEstadoCuenta = CuentaBancaria.EstadoCuenta.ACTIVO;
        } else {
            enumEstadoCuenta = CuentaBancaria.EstadoCuenta.INACTIVO;
        }
        CuentaBancaria cuentaBancaria;
        cuentaBancaria = new CuentaBancaria(
                resultId,
                noCuenta,
                fechaApertura,
                saldoMXN,
                idCliente,
                enumEstadoCuenta);
        return cuentaBancaria;
    }

    @Override
    public CuentaBancaria actualizar(CuentaBancaria cuentaBancaria) throws PersistenciaException {
        /* Consultas */
        String updateStatement = "UPDATE " + NOMBRE_TABLA + " SET "
                + "saldoMXN = ? ,"
                + "estadoCuenta = ? "
                + "WHERE id = ?";
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement updateCuenta = con.prepareStatement(updateStatement, Statement.RETURN_GENERATED_KEYS);) {

            /* Asignar valores a consulta INSERT*/
            updateCuenta.setDouble(1, cuentaBancaria.getSaldoMXN());
            updateCuenta.setString(2, cuentaBancaria.getEstadoCuenta());
            updateCuenta.setInt(3, cuentaBancaria.getId());

            /* Ejecutar las consultas */
            updateCuenta.executeUpdate();

            return cuentaBancaria;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("Error en la conexión");
        }
    }

}
