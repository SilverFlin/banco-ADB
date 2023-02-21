package dominio;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Toled
 */
public class CuentaBancaria {

    /**
     * Identificador de la cuenta
     */
    private Integer id;
    /**
     * Numero de cuenta
     */
    private String noCuenta;
    /**
     * fecha de apertura de la cuenta
     */
    private Date fechaApertura;
    /**
     * Saldo de la cuenta
     */
    private Double saldoMXN;
    /**
     * Identificador del cliente asociada a la cuenta
     */
    private Integer idCliente;
    /**
     * Estado de la cuenta
     */
    private EstadoCuenta estadoCuenta;

    /**
     * Constructor basico que establece el salgo en 0
     */
    public CuentaBancaria() {
        generarNoCuenta();
        this.saldoMXN = 0.0;
        this.estadoCuenta = EstadoCuenta.ACTIVO;
    }

    /**
     * Constructor que establece el saldo indicado
     *
     * @param saldoMXN Saldo inicial de la cuenta
     */
    public CuentaBancaria(Double saldoMXN) {
        generarNoCuenta();
        this.saldoMXN = saldoMXN;
        this.estadoCuenta = EstadoCuenta.ACTIVO;
    }

    /**
     * Constructor que inicializa todos los atributos dados en los parametros
     *
     * @param id Identificador de la cuenta
     * @param noCuenta Numero de cuenta
     * @param fechaApertura Fecha de apertura de la cuenta
     * @param saldoMXN Saldo de la cuenta en pesos
     * @param idCliente Identificador del propietario de la cuenta
     * @param estadoCuenta Estado actual de la cuenta
     */
    public CuentaBancaria(Integer id, String noCuenta, Date fechaApertura, Double saldoMXN, Integer idCliente, EstadoCuenta estadoCuenta) {
        this.id = id;
        this.noCuenta = noCuenta;
        this.fechaApertura = fechaApertura;
        this.saldoMXN = saldoMXN;
        this.idCliente = idCliente;
        this.estadoCuenta = estadoCuenta;
    }

    /**
     * Genera un String de 16 numeros con espaciado cada 4 y lo guarda en
     * noCuenta
     */
    private void generarNoCuenta() {
        /*Numero aleatorio de 16 digitos*/
        long rawNumCuenta = (long) (Math.random() * 9000_0000_0000_0000L
                + 1000_0000_0000_0000L);

        /*Separa el numero*/
        String[] arrNumCuenta = Long.toString(rawNumCuenta).split("(?<=\\G....)");
        String numCuenta = "";
        for (int i = 0; i < 4; i++) {
            if (i != 3) {
                numCuenta += arrNumCuenta[i] + " ";
            } else {
                numCuenta += arrNumCuenta[i];
            }
        }

        this.noCuenta = numCuenta;
    }

    /**
     * Agrega saldo a la cuenta bancaria
     *
     * @param cantidad cantidad a agregar a la cuenta
     */
    public void agregarSaldo(double cantidad) {

        if (cantidad <= 0) {
            return;
        }

        this.setSaldoMXN(this.getSaldoMXN() + cantidad);
    }

    /**
     * Establece el estado de cuenta a Activo
     */
    public void activarCuenta() {
        this.estadoCuenta = EstadoCuenta.ACTIVO;
    }

    /**
     * Establece el estado de cuenta a Inactivo
     */
    public void desactivarCuenta() {
        this.estadoCuenta = EstadoCuenta.INACTIVO;
    }

    /**
     * Regresa el identificador de la cuenta
     *
     * @return Identificador de la cuenta
     */
    public Integer getId() {
        return id;
    }

    /**
     * Obtener el numero de cuenta
     *
     * @return Numero de cuenta
     */
    public String getNoCuenta() {
        return noCuenta;
    }

    /**
     * Regresa la fecha de apertura
     *
     * @return Fecha de apertura
     */
    public Date getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Obtiene el saldo de la cuenta en pesos
     *
     * @return Saldo de la cuenta en pesos
     */
    public Double getSaldoMXN() {
        return saldoMXN;
    }

    /**
     * Obtiene el identificador del cliente propietario de la cuenta
     *
     * @return identificador del cliente propietario
     */
    public Integer getClientePropietario() {
        return idCliente;
    }

    /**
     * Regresa el estado de la cuenta
     *
     * @return Estado de la cuenta
     */
    public String getEstadoCuenta() {
        return estadoCuenta == EstadoCuenta.ACTIVO ? "Activa" : "Inactiva";
    }

    /**
     * Establece el saldo de la cuenta
     *
     * @param saldoMXN Saldo de la cuenta en pesos
     */
    public void setSaldoMXN(Double saldoMXN) {
        this.saldoMXN = saldoMXN;
    }

    /**
     * Establece el identificador del cliente propietario
     *
     * @param clientePropietario Identificador del cliente propietario
     */
    public void setClientePropietario(Integer clientePropietario) {
        this.idCliente = clientePropietario;
    }

    /**
     * Establece el estado de la cuenta
     *
     * @param estadoCuenta Estado de la cuenta
     */
    public void setEstadoCuenta(EstadoCuenta estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    /**
     * Establece el identificador de la cuenta
     *
     * @param id Identificador de la cuenta
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Establece el numero de la cuenta
     *
     * @param noCuenta Numero de la cuenta
     */
    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    /**
     * Establece la fecha de apertura de la cuenta
     *
     * @param fechaApertura Fecha de apertura de la cuenta
     */
    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Cadena que contiene los atributos de la cuenta
     *
     * @return Cadena con los atributos
     */
    @Override
    public String toString() {
        return "CuentaBancaria{" + "id=" + id + ", noCuenta=" + noCuenta + ", fechaApertura=" + fechaApertura + ", saldoMXN=" + saldoMXN + ", idCliente=" + idCliente + ", estadoCuenta=" + estadoCuenta + '}';
    }

    /**
     * Genera el hash de la cuenta
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.noCuenta);
        return hash;
    }

    /**
     * Compara un objeto consigo mismo
     *
     * @param obj Objeto a comparar
     * @return Si son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CuentaBancaria other = (CuentaBancaria) obj;
        if (!Objects.equals(this.noCuenta, other.noCuenta)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * Resta el monto al saldo actual de la cuenta
     *
     * @param monto Monto a restar
     */
    public void retirar(Double monto) {
        this.setSaldoMXN(this.getSaldoMXN() - monto);
    }

    /**
     * Suma el monto al saldo actual de la cuenta
     *
     * @param monto Monto a sumar
     */
    public void depositar(Double monto) {
        this.setSaldoMXN(this.getSaldoMXN() + monto);
    }

}
