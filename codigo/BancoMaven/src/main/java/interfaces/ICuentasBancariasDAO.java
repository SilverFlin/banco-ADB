/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Cliente;
import dominio.CuentaBancaria;
import excepciones.PersistenciaException;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 *
 * @author Toled
 */
public interface ICuentasBancariasDAO {

    CuentaBancaria consultar(int id) throws PersistenciaException;
    
    CuentaBancaria consultar(String noCuenta) throws PersistenciaException;

    List<CuentaBancaria> consultar(ConfiguracionPaginado configPaginado,int idCliente) throws PersistenciaException;
    
    CuentaBancaria insertar(CuentaBancaria cuentaBancaria,Cliente cliente) throws PersistenciaException;

    CuentaBancaria eliminar(Integer id);

    CuentaBancaria actualizar(CuentaBancaria cuentaBancaria)throws PersistenciaException;
}
