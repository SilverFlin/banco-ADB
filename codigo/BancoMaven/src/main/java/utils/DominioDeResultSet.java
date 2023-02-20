package utils;

import dominio.CuentaBancaria;
import dominio.EstadoCuenta;
import dominio.EstadoRetiroSinCuenta;
import dominio.RetiroSinCuenta;
import dominio.Transferencia;
import implementaciones.CuentasBancariasDAO;
import implementaciones.RetirosSinCuentaDAO;
import static implementaciones.RetirosSinCuentaDAO.ESTADO_RETIRO_COBRADO;
import static implementaciones.RetirosSinCuentaDAO.ESTADO_RETIRO_PENDIENTE;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Toled
 */
public class DominioDeResultSet {
    public static CuentaBancaria crearCuentaBancaria(ResultSet result) throws SQLException {
        /*Extraer del ResultSet*/
        Integer resultId = Integer.parseInt(result.getString("id"));
        String noCuenta = result.getString("noCuenta");
        Date fechaApertura = result.getDate("fechaApertura");
        Double saldoMXN = result.getDouble("saldoMXN");
        String estadoCuenta = result.getString("estadoCuenta");
        Integer idCliente = result.getInt("idCliente");

        /* Crear CuentaBancaria*/
        EstadoCuenta enumEstadoCuenta;
        if (estadoCuenta.equals(CuentasBancariasDAO.ESTADO_CUENTA_ACTIVO)) {
            enumEstadoCuenta = EstadoCuenta.ACTIVO;
        } else {
            enumEstadoCuenta = EstadoCuenta.INACTIVO;
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
    
    public static Transferencia crearTransferencia(ResultSet result) throws SQLException {
        /*Extraer del ResultSet*/
        Integer resultId = Integer.parseInt(result.getString("id"));
        String fechaHora = result.getString("fechaHora");
        Double monto = result.getDouble("monto");
        Integer idOrigen = Integer.parseInt(result.getString("idCuentaOrigen"));
        Integer idDestino = Integer.parseInt(result.getString("idCuentaDestino"));

        /* Crear Transferencia*/
        Transferencia transferencia = new Transferencia(monto, idOrigen, idDestino);
        transferencia.setFechaHora(fechaHora);
        transferencia.setId(resultId);
        return transferencia;
    }
    
    public static RetiroSinCuenta crearRetiroSinCuenta(ResultSet result) throws SQLException {
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
