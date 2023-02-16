/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.ClienteBorrar;
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

    CuentaBancaria insertar(CuentaBancaria cuentaBancaria,ClienteBorrar cliente) throws PersistenciaException;

    CuentaBancaria eliminar(Integer id);

    List<CuentaBancaria> consultar(ConfiguracionPaginado configPaginado,int idCliente) throws PersistenciaException;
}
