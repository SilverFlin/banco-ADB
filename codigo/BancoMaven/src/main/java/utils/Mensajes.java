package utils;

/**
 *
 * @author Elkur
 */
public class Mensajes {

    public static String generarRegistroTransferencia(double monto, String noCuenta1, String noCuenta2) {
        return "Transaccion de la cuenta " + noCuenta1 + " a la cuenta " + noCuenta2 + ", por la cantidad de " + monto;
    }

    public static String generarRegistroRetiroSinCuenta(double monto) {
        return "Se genero un retiro sin cuenta por la cantidad de " + monto;
    }

    public static String generarRegistroDeposito(double monto) {
        return "Se deposito la cantidad de " + monto;
    }

    public static String generarRegistroRetiro(double monto) {
        return "Se retiro la cantidad de " + monto;
    }
}
