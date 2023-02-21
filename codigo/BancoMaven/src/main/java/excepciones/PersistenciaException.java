package excepciones;

/**
 *
 * @author Elkur, Toled
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor vacio
     */
    public PersistenciaException() {
    }

    /**
     * Constructor que recibe el mensaje de la excepcion
     *
     * @param string mensaje de la excepcion
     */
    public PersistenciaException(String string) {
        super(string);
    }

    /**
     * Constructor
     *
     * @param string Mensaje
     * @param thrwbl No se
     */
    public PersistenciaException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    /**
     * Constructor
     *
     * @param thrwbl mensaje
     */
    public PersistenciaException(Throwable thrwbl) {
        super(thrwbl);
    }

    /**
     * Constructor
     *
     * @param string Mensaje
     * @param thrwbl Mensaje
     * @param bln booleano
     * @param bln1 booleano
     */
    public PersistenciaException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

}
