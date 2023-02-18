/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.CuentaBancaria;
import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 *
 * @author Toled
 */
public interface IRetirosSinCuentaDAO {

    RetiroSinCuenta consultar(int id) throws PersistenciaException;

    RetiroSinCuenta consultar(String folio) throws PersistenciaException;

    List<RetiroSinCuenta> consultar(ConfiguracionPaginado configPaginado, int idCuentaBancaria) throws PersistenciaException;

    RetiroSinCuenta insertar(RetiroSinCuenta retiroSinCuenta, CuentaBancaria cuentaBancaria) throws PersistenciaException;

    RetiroSinCuenta eliminar(Integer id);

    RetiroSinCuenta actualizar(RetiroSinCuenta retiroSinCuenta) throws PersistenciaException;
}
