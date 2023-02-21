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

    /**
     * Regresa la cuenta bancaria en base al id proporcionado
     *
     * @param id Identificador de la cuenta bancaria
     * @return Cuenta bancaria encontrada
     * @throws PersistenciaException Si ocurrio una exception al conectarse con
     * la base
     */
    CuentaBancaria consultar(int id) throws PersistenciaException;

    /**
     * Consulta la base de datos de cuentas bancarias y trae la que tenga el
     * numero de cuenta especificado
     *
     * @param noCuenta Numero de cuenta a buscar
     * @return Cuenta bancaria
     * @throws PersistenciaException Si ocurre una excepcion al conectarse a la
     * base de datos
     */
    CuentaBancaria consultar(String noCuenta) throws PersistenciaException;

    /**
     * Consulta las cuentas bancarias asociadas al identificador del cliente
     * dado
     *
     * @param configPaginado Configuracion del paginado
     * @param idCliente identificador del cliente que se le buscan
     * @return Lista de cuentas asociadas
     * @throws PersistenciaException Si ocurre una excepcion al conectarse a la
     * base
     */
    List<CuentaBancaria> consultar(ConfiguracionPaginado configPaginado, int idCliente) throws PersistenciaException;

    /**
     * Inserta una cuenta bancaria, relacionandose con el id de un cliente.
     *
     * @param cuentaBancaria Cuenta bancaria a insertar
     * @param cliente Cliente a emplear
     * @return la cuenta bancaria, pero con el id asignado por la base de datos.
     * @throws PersistenciaException
     */
    CuentaBancaria insertar(CuentaBancaria cuentaBancaria, Cliente cliente) throws PersistenciaException;

    /**
     * Actualiza la informacion de la cuenta bancaria en la base de datos con la
     * informacion de la cuenta dada
     *
     * @param cuentaBancaria Cuenta a actualizar
     * @return Cuenta actualizada
     * @throws PersistenciaException Si ocurre una excepcion al conectarse a la
     * base
     */
    CuentaBancaria actualizar(CuentaBancaria cuentaBancaria) throws PersistenciaException;

    /**
     * Elimina la cuenta bancaria de la base de datos, usando su id
     *
     * @param id identificador dela cuenta a eliminar
     * @return la cuenta bancaria eliminada o null si no existia
     */
    CuentaBancaria eliminar(Integer id);

}
