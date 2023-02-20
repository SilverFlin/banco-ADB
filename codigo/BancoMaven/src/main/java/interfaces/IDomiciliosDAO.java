package interfaces;

import dominio.Domicilio;
import excepciones.PersistenciaException;

/**
 *
 * @author Elkur
 */
public interface IDomiciliosDAO {

    Domicilio consultar(int id);

    Domicilio insertar(Domicilio domicilio) throws PersistenciaException;

    Domicilio actualizar(Domicilio domicilio) throws PersistenciaException;

}
