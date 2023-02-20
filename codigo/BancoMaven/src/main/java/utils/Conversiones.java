package utils;

/**
 *
 * @author Toled
 */
public final class Conversiones {

    private Conversiones() {
    }
    
    /**
     * Regresa el monto en double, si es que es valido, null en caso contrario.
     *
     * @param txtMonto
     * @return
     */
    public static Double crearMontoDeTexto(String txtMonto) {
        Double monto;

        try {
            monto = new Double(txtMonto);
        } catch (NumberFormatException e) {
            return null;
        }
        return monto;
    }

    

}
