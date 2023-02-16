/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import dominio.CuentaBancaria;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ICuentasBancariasDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConfigPaginado;

/**
 *
 * @author Toled
 */
public class CuentasBancariasDAO implements ICuentasBancariasDAO {

    private static final Logger LOG = Logger.getLogger(CuentasBancariasDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES;

    private final String ESTADO_CUENTA_ACTIVO = "Activo";
    private final String ESTADO_CUENTA_INACTIVO = "Inactivo";

    public CuentasBancariasDAO(IConexionBD generarConexion) {
        this.GENERADOR_CONEXIONES = generarConexion;
    }

    @Override
    public CuentaBancaria consultar(int id) throws PersistenciaException {
        /* Consultas */
        String query
                = "SELECT id, noCuenta, fechaApertura, saldoMXN, "
                + " estadoCuenta, idCliente "
                + "FROM cuentasBancarias WHERE id = ?;";
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement updateClientes = con.prepareStatement(query);) {


            /* Asignar valores a consulta*/
            Integer posicionId = 1;
            updateClientes.setInt(posicionId, id);
            /* Ejecutar Consulta */
            ResultSet result = updateClientes.executeQuery();
            if (result.next()) {
                /* Sacar valores de la consulta*/
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
            throw new PersistenciaException("No se encontro la cuenta bancaria");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("Error en la conexion");

        }
    }

    @Override
    public CuentaBancaria insertar(CuentaBancaria cuentaBancaria) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CuentaBancaria eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CuentaBancaria> consultar(ConfigPaginado configPaginado) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
