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

    /**
     * Consulta en la base de datos el cliente que tenga el correo mandado en el
     * parametro
     *
     * @param correo Correo a comparar
     * @return Cliente que tenga el correo
     */
    Cliente consultar(String correo);

    /**
     * Consulta a los clientes con una configuracion de paginado
     *
     * @param configPaginado Configuracion del paginado
     * @return Lista de clientes
     * @throws PersistenciaException Si no se tiene acceso a la base
     */
    List<Cliente> consultar(ConfiguracionPaginado configPaginado) throws PersistenciaException;

    /**
     * Inserta en la base de datos a un cliente dado en el parametro
     *
     * @param cliente Cliente a insertar
     * @return Cliente insertado
     * @throws PersistenciaException Si no se puede acceder a la base
     */
    Cliente insertar(Cliente cliente) throws PersistenciaException;

    /**
     * Actualiza al cliente en la base de datos que coincida con el del
     * parametro
     *
     * @param cliente Cliente a actualizar
     * @return Cliente actualizado
     * @throws PersistenciaException Si no se tiene acceso a la base
     */
    Cliente actualizar(Cliente cliente) throws PersistenciaException;

}
