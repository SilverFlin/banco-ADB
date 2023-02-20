package interfaces;

import dominio.Operacion;
import excepciones.PersistenciaException;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 *
 * @author Elkur
 */
public interface IOperacionesDAO {

    public Operacion consultar(int id);

    public Operacion insertar(Operacion operacion) throws PersistenciaException;

    List<Operacion> consultar(ConfiguracionPaginado configPaginado, int idCuentaBancaria) throws PersistenciaException;

    List<Operacion> consultar(ConfiguracionPaginado configPaginado, String idCliente) throws PersistenciaException;

}
