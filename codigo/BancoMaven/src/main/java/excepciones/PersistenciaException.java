package excepciones;

/**
 *
 * @author Elkur, Toled
 */
public class PersistenciaException extends Exception {

    public PersistenciaException() {
    }

    public PersistenciaException(String string) {
        super(string);
    }

    public PersistenciaException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public PersistenciaException(Throwable thrwbl) {
        super(thrwbl);
    }

    public PersistenciaException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

}
