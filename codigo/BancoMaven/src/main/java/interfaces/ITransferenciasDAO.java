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

    /**
     * Consulta en la base la transferencia mediante la cuenta origen
     *
     * @param idCuentaOrigen Identificador de la cuenta origen
     * @return Transferencia encontrada
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    Transferencia consultarOrigen(int idCuentaOrigen) throws PersistenciaException;

    /**
     * Consulta la base de trasferencias asociadas a una cuenta origen
     *
     * @param configPaginado Configuracion de paginado
     * @param idCuentaOrigen Identificador de la cuenta origen
     * @return Lista de transferencias
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    List<Transferencia> consultarOrigen(ConfiguracionPaginado configPaginado, int idCuentaOrigen) throws PersistenciaException;

    /**
     * Consulta en la base la transferencia mediante la cuenta destino
     *
     * @param idCuentaDestino Identificador de la cuenta destino
     * @return Transferencia encontrada
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    Transferencia consultarDestino(int idCuentaDestino) throws PersistenciaException;

    /**
     * Consulta la base de trasferencias asociadas a una cuenta destino
     *
     * @param configPaginado Configuracion de paginado
     * @param idCuentaDestino Identificador de la cuenta destino
     * @return Lista de transferencias
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    List<Transferencia> consultarDestino(ConfiguracionPaginado configPaginado, int idCuentaDestino) throws PersistenciaException;

    /**
     * Inserta en la base una transferencia dada
     *
     * @param transferencia Transferencia a insertar
     * @return Transferencia insertada
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    Transferencia insertar(Transferencia transferencia) throws PersistenciaException;

}
