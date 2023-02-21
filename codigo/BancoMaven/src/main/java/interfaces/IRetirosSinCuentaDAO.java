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

    /**
     * Consulta la base de dato y trae el retiro que coincida con la id dada
     *
     * @param id identificador a buscar
     * @return Retiro sin cuenta encontrado
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    RetiroSinCuenta consultar(int id) throws PersistenciaException;

    /**
     * Consulta la base y trae el retiro que tenga el folio dado
     *
     * @param folio folio a buscar
     * @return Retiro sin cuenta encontrado
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    RetiroSinCuenta consultar(String folio) throws PersistenciaException;

    /**
     * consulta en la base los retiros sin cuenta que coincidan con la id de
     * cuenta dada
     *
     * @param configPaginado Configuracion de paginado
     * @param idCuentaBancaria identificador de cuenta para buscar
     * @return Lista de retiros sin cuenta
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    List<RetiroSinCuenta> consultar(ConfiguracionPaginado configPaginado, int idCuentaBancaria) throws PersistenciaException;

    /**
     * Inserta en la base el retiro sin cuenta dado en el parametro
     *
     * @param retiroSinCuenta Retiro sin cuenta a insertar
     * @param cuentaBancaria Cuenta auxiliar
     * @return Retiro sin cuenta insertado
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    RetiroSinCuenta insertar(RetiroSinCuenta retiroSinCuenta, CuentaBancaria cuentaBancaria) throws PersistenciaException;

    /**
     * Actualiza en la base el retiro dado en el parametro
     *
     * @param retiroSinCuenta retiro a actualizar
     * @return retiro actualizado
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    RetiroSinCuenta actualizar(RetiroSinCuenta retiroSinCuenta) throws PersistenciaException;

    /**
     * Elimina de la base el retiro que tenga la misma id dada
     *
     * @param id identificador a eliminar
     * @return Retiro eliminado
     */
    RetiroSinCuenta eliminar(Integer id);

    /**
     * Retira y actualiza el retiro sin cuenta de la base
     *
     * @param retiroSinCuenta retiro a realizar
     * @return Retiro realizado
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    RetiroSinCuenta retirar(RetiroSinCuenta retiroSinCuenta) throws PersistenciaException;
}
