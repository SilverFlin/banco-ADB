package interfaces;

import dominio.Domicilio;
import excepciones.PersistenciaException;

/**
 *
 * @author Elkur
 */
public interface IDomiciliosDAO {

    /**
     * Consulta la base de datos y trae el domicilio que coincida con el id dada
     *
     * @param id identificador a buscar
     * @return Domicilio encontrado
     */
    Domicilio consultar(int id);

    /**
     * Inserta en la base de datos el domicilio dado
     *
     * @param domicilio Domicilio a insertar
     * @return Domicilio insertado
     * @throws PersistenciaException Si ocurre una excepcion al conectarse a la
     * base
     */
    Domicilio insertar(Domicilio domicilio) throws PersistenciaException;

    /**
     * Actualiza el domicilio en la base que coincida con el dado en el
     * parametro
     *
     * @param domicilio Domicilio a actualizar
     * @return Domicilio actualizado
     * @throws PersistenciaException Si ocurre una excepcion al conectarse a la
     * base
     */
    Domicilio actualizar(Domicilio domicilio) throws PersistenciaException;

}
