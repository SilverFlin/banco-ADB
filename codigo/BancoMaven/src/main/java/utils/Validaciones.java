package utils;

import dominio.Cliente;
import dominio.CuentaBancaria;
import dominio.EstadoRetiroSinCuenta;
import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;
import interfaces.ICuentasBancariasDAO;
import interfaces.IRetirosSinCuentaDAO;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Toled
 */
public class Validaciones {

    public static final int NOMBRE = 1;
    public static final int DIRECCION = 2;
    public static final int CODIGOPOSTAL = 3;

    /**
     * Checa si el monto es un numero positivo
     *
     * @param monto
     * @return positivo, si el numero es mayor a 0
     */
    public static boolean isPositivo(Double monto) {
        return !Validaciones.isNull(monto) && monto > 0;
    }

    public static <T> boolean isNull(T elemento) {
        return elemento == null;
    }

    public static void restringirCaracteres(KeyEvent evt, int caracteres, JTextField txt, int tipo) {
        restringirLargoCaracteres(evt, caracteres, txt);

        restringirTipoCaracteres(evt, caracteres, txt, tipo);
    }

    public static void restringirLargoCaracteres(KeyEvent evt, int caracteres, JTextField txt) {
        if (txt.getText().length() >= caracteres) {
            evt.consume();
        }
    }

    private static void restringirTipoCaracteres(KeyEvent evt, int caracteres, JTextField txt, int tipo) {
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;
        boolean numeros = key >= 48 && key <= 57;
        boolean aux = true;

        switch (tipo) {
            case DIRECCION:
                aux = espacio || numeros;
                break;
            case NOMBRE:
                aux = espacio;
                break;
            case CODIGOPOSTAL:
                if (!numeros) {
                    evt.consume();
                }
                return;
        }

        if (!(minusculas || mayusculas || aux)) {
            evt.consume();
        }
    }

    public static boolean validarEmail(String texto) {

        String patron = "[\\w-\\.]{1,30}+@[a-zA-Z0-9]{1,30}+\\.([a-zA-Z]{2,4})";

        Pattern pattern = Pattern.compile(patron);

        Matcher matcher = pattern.matcher(texto);

        return matcher.matches();
    }

    public static boolean validarContrasena(String pass) {
        String patron = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";

        Pattern pattern = Pattern.compile(patron);

        Matcher matcher = pattern.matcher(pass);

        return matcher.matches();
    }

    public static boolean validarNombreCompleto(String nom, String apeP, String apeM) {
        boolean validacion = Validaciones.isAName(nom) && Validaciones.isAName(apeP) && Validaciones.isAName(apeM);
        return validacion;
    }

    private static boolean isAName(String texto) {
        String patron = "[a-zA-z]+([ '-][a-zA-Z]+)*{1,50}";

        Pattern pattern = Pattern.compile(patron);

        Matcher matcher = pattern.matcher(texto);

        return matcher.matches();
    }

    public static boolean validarCuentaActiva(ICuentasBancariasDAO cuentasBancariasDAO, RetiroSinCuenta retiroSinCuenta) throws PersistenciaException {
        CuentaBancaria cuentaBancaria = cuentasBancariasDAO.consultar(retiroSinCuenta.getIdCuentaBancaria());
        String estado = cuentaBancaria.getEstadoCuenta();
        return "Activa".equals(estado);
    }

    public static boolean validarCuentaActiva(ICuentasBancariasDAO cuentasBancariasDAO, CuentaBancaria cuentaBancaria) throws PersistenciaException {
        String estado = cuentaBancaria.getEstadoCuenta();
        return "Activa".equals(estado);
    }

    public static boolean validarPassword(String passwordCandidato, Cliente cliente) {
        return BCrypt.checkpw(passwordCandidato, cliente.getContrasenia());
    }

    public static boolean validarPassword(String passwordCandidato, String passwordHashed) {
        return BCrypt.checkpw(passwordCandidato, passwordHashed);
    }

    public static boolean tieneFondosSuficientes(CuentaBancaria cuentaBancaria, Double monto) {
        double saldo = cuentaBancaria.getSaldoMXN();
        return saldo >= monto;
    }

    public static RetiroSinCuenta validarCaducidadRetiro(IRetirosSinCuentaDAO retirosSinCuentaDAO, RetiroSinCuenta retiroSinCuenta) throws PersistenciaException {

        Timestamp fechaFin = Timestamp.valueOf(retiroSinCuenta.getFechaFin());
        Timestamp ahora = new Timestamp(System.currentTimeMillis());

        if (fechaFin.before(ahora)) {
            retiroSinCuenta.setEstado(EstadoRetiroSinCuenta.EXPIRADO);
            retiroSinCuenta = retirosSinCuentaDAO.actualizar(retiroSinCuenta);
        }

        return retiroSinCuenta;

    }

}
