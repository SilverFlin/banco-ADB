package interfaces;

import dominio.Cliente;
import excepciones.PersistenciaException;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 *
 * @author Elkur
 */
public interface IClientesDAO {

    Cliente consultar(String correo);

    List<Cliente> consultar(ConfiguracionPaginado configPaginado) throws PersistenciaException;
    
    Cliente insertar(Cliente cliente) throws PersistenciaException;
    
    Cliente actualizar(Cliente cliente) throws PersistenciaException;


}
