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
