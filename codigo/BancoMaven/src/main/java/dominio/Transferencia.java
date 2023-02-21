package dominio;

import java.util.Objects;

/**
 *
 * @author Toled
 */
public class Transferencia {

    /**
     * Identificador de la transferencia
     */
    private int id;
    /**
     * Fecha y hora de la trasferencia
     */
    private String fechaHora;
    /**
     * Monto de la transferenica
     */
    private Double monto;
    /**
     * Identificador de la cuenta origen
     */
    private int idCuentaOrigen;
    /**
     * Identificador de la cuenta destino
     */
    private int idCuentaDestino;

    /**
     * Constructor vacio
     */
    public Transferencia() {
    }

    /**
     * Constructor que recibe sus atributos y los establece
     *
     * @param monto Monto de la transferencia
     * @param idCuentaOrigen Identificador de la cuenta origen
     * @param idCuentaDestino Identificador de la cuenta destino
     */
    public Transferencia(Double monto, int idCuentaOrigen, int idCuentaDestino) {
        this.monto = monto;
        this.idCuentaOrigen = idCuentaOrigen;
        this.idCuentaDestino = idCuentaDestino;
    }

    /**
     * Regresa el identificador de la transferencia
     *
     * @return Identificador de la transferencia
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la trasferencia
     *
     * @param id Identificador de la trasferencia
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Regresa la fecha y hora de la trasferencia
     *
     * @return Fecha y hora de la transferencia
     */
    public String getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la trasferencia
     *
     * @param fechaHora Fecha y hora de la trasferencia
     */
    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Regresa el monto de la transferencia
     *
     * @return Monto de la transferencia
     */
    public Double getMonto() {
        return monto;
    }

    /**
     * Establece el monto de la transferencia
     *
     * @param monto Monto de la transferencia
     */
    public void setMonto(Double monto) {
        this.monto = monto;
    }

    /**
     * Regresa el identificador de la cuenta origen
     *
     * @return Identificador de la cuenta origen
     */
    public int getIdCuentaOrigen() {
        return idCuentaOrigen;
    }

    /**
     * Establece el identificador de la cuenta origen
     *
     * @param idCuentaOrigen Identificador de la cuenta origen
     */
    public void setIdCuentaOrigen(int idCuentaOrigen) {
        this.idCuentaOrigen = idCuentaOrigen;
    }

    /**
     * Regresa el identificador de la cuenta destino
     *
     * @return Identificador de la cuenta destino
     */
    public int getIdCuentaDestino() {
        return idCuentaDestino;
    }

    /**
     * Establece el identificador de la cuenta destino
     *
     * @param idCuentaDestino Identificador de la cuenta destino
     */
    public void setIdCuentaDestino(int idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    /**
     * Cadena que contiene los atributos del retiro
     *
     * @return Cadena con atributos
     */
    @Override
    public String toString() {
        return "Transferencia{" + "id=" + id + ", fechaHora=" + fechaHora + ", monto=" + monto + ", idCuentaOrigen=" + idCuentaOrigen + ", idCuentaDestino=" + idCuentaDestino + '}';
    }

    /**
     * Genera el codigo hash
     *
     * @return Codigo hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.fechaHora);
        hash = 17 * hash + Objects.hashCode(this.monto);
        hash = 17 * hash + this.idCuentaOrigen;
        hash = 17 * hash + this.idCuentaDestino;
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
        final Transferencia other = (Transferencia) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idCuentaOrigen != other.idCuentaOrigen) {
            return false;
        }
        if (this.idCuentaDestino != other.idCuentaDestino) {
            return false;
        }
        if (!Objects.equals(this.fechaHora, other.fechaHora)) {
            return false;
        }
        if (!Objects.equals(this.monto, other.monto)) {
            return false;
        }
        return true;
    }

}
