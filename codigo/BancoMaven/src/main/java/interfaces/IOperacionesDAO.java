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

    /**
     * Consulta la base de datos y trae la operacion que coincida con la id dada
     *
     * @param id identificador a encontrar
     * @return Operacion encontrada
     */
    public Operacion consultar(int id);

    /**
     * Consulta la lista de operaciones de una cuenta bancaria mediante su ID
     *
     * @param configPaginado Configuracion del paginado
     * @param idCuentaBancaria Identificador de la cuenta para buscar
     * operaciones
     * @return Lista de operaciones de la cuenta
     * @throws PersistenciaException Si ocurre una excepcion al conectarse a la
     * base
     */
    List<Operacion> consultar(ConfiguracionPaginado configPaginado, int idCuentaBancaria) throws PersistenciaException;

    /**
     * Consulta en la base la lista de operaciones asociadas al id del cliente
     * dado
     *
     * @param configPaginado Configuracion de paginado
     * @param idCliente Identificador del cliente para buscar
     * @return Lista de operaciones asociadas a la cuenta
     * @throws PersistenciaException Si ocurre una excepcion al conectarse a la
     * base
     */
    List<Operacion> consultar(ConfiguracionPaginado configPaginado, String idCliente) throws PersistenciaException;

    /**
     * Inserta en la base de datos la operacion dada
     *
     * @param operacion Operacion a insertar
     * @return Operacion insertada
     * @throws PersistenciaException Si ocurre una excepcion al conectarse a la
     * base
     */
    public Operacion insertar(Operacion operacion) throws PersistenciaException;

}
