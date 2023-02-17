package interfaces;

import dominio.Transferencia;
import excepciones.PersistenciaException;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 *
 * @author Toled
 */
public interface ITransferenciasDAO {

    Transferencia consultarOrigen(int idCuentaOrigen) throws PersistenciaException;

    Transferencia consultarDestino(int idCuentaDestino) throws PersistenciaException;

    Transferencia insertar(Transferencia transferencia) throws PersistenciaException;

    List<Transferencia> consultarOrigen(ConfiguracionPaginado configPaginado, int idCuentaOrigen) throws PersistenciaException;

    List<Transferencia> consultarDestino(ConfiguracionPaginado configPaginado, int idCuentaDestino) throws PersistenciaException;
}
