package dominio;

import java.sql.Date;

/**
 *
 * @author Toled
 */
public class Operacion {

    private int id;
    private Date fechaHora;
    private String detalles;
    private int idCuentaBancaria;
    private String noCuenta;

    /**
     * Constructor principal que establece todos los atributos recibidos
     *
     * @param id Identificador de la operacion
     * @param fechaHora Fecha y hora de la operacion
     * @param detalles Detalles de la operacion
     * @param idCuentaBancaria Identificador de la cuenta bancaria que lo
     * realizo
     */
    public Operacion(int id, Date fechaHora, String detalles, int idCuentaBancaria) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.detalles = detalles;
        this.idCuentaBancaria = idCuentaBancaria;
    }

    /**
     * Constructor secundario que no recibe identificador
     *
     * @param fechaHora Fecha y hora de la operacion
     * @param detalles Detalles de la operacion
     * @param idCuentaBancaria Identificador de la cuenta bancaria que lo
     * realizo
     */
    public Operacion(Date fechaHora, String detalles, int idCuentaBancaria) {
        this.fechaHora = fechaHora;
        this.detalles = detalles;
        this.idCuentaBancaria = idCuentaBancaria;
    }

    /**
     * Constructor secundario que establece todos los parametros recibidos
     *
     * @param id Identificador de la operacion
     * @param fechaHora Fecha y hora de la operacion
     * @param detalles Detalles de la operacion
     * @param idCuentaBancaria Identificador de la cuenta bancaria que lo
     * realizo
     * @param noCuenta Numero de cuenta que lo realizo
     */
    public Operacion(int id, Date fechaHora, String detalles, int idCuentaBancaria, String noCuenta) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.detalles = detalles;
        this.idCuentaBancaria = idCuentaBancaria;
        this.noCuenta = noCuenta;
    }

    /**
     * Regresa el identificador de la operacion
     *
     * @return Identificador de la operacion
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la operacion
     *
     * @param id identificador de la operacion
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Regresa la fecha y hora de la operacion
     *
     * @return Fecha y hora de la operacion
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la operacion
     *
     * @param fechaHora Fecha y hora de la operacion
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Regresa los detalles de la operacion
     *
     * @return Detalles de la operacion
     */
    public String getDetalles() {
        return detalles;
    }

    /**
     * Establece los detalles de la operacion
     *
     * @param detalles Detalles de la operacion
     */
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    /**
     * Regresa el identificador de la cuenta asociada a la operacion
     *
     * @return Identifidor de la cuenta
     */
    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    /**
     * Establece el identificador de la cuenta asociada a la operacion
     *
     * @param idCuentaBancaria Identificador de la cuenta asociada
     */
    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    /**
     * Regresa el numero de cuenta asociada a la operacion
     *
     * @return Numero de cuenta asociada a la operacion
     */
    public String getNoCuenta() {
        return noCuenta;
    }

    /**
     * Establece el numero de cuenta asociada
     *
     * @param noCuenta Numero de cuenta asociada
     */
    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    /**
     * Genera el codigo hash
     *
     * @return codigo hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
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
        final Operacion other = (Operacion) obj;
        return this.id == other.id;
    }

    /**
     * Cadena con los atributos de la operacion
     *
     * @return Cadena con los atributos
     */
    @Override
    public String toString() {
        return "Operacion{" + "id=" + id + ", monto=" + ", fechaHora=" + fechaHora + ", detalles=" + detalles + ", idCuentaBancaria=" + idCuentaBancaria + '}';
    }

}
