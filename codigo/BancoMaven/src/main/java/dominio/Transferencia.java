package dominio;

import java.util.Objects;

/**
 *
 * @author Toled
 */
public class Transferencia {

    private int id;
    private String fechaHora;
    private Double monto;
    private int idCuentaOrigen;
    private int idCuentaDestino;

    public Transferencia() {
    }

    public Transferencia( String fechaHora, Double monto, int idCuentaOrigen, int idCuentaDestino) {
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.idCuentaOrigen = idCuentaOrigen;
        this.idCuentaDestino = idCuentaDestino;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public int getIdCuentaOrigen() {
        return idCuentaOrigen;
    }

    public void setIdCuentaOrigen(int idCuentaOrigen) {
        this.idCuentaOrigen = idCuentaOrigen;
    }

    public int getIdCuentaDestino() {
        return idCuentaDestino;
    }

    public void setIdCuentaDestino(int idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "id=" + id + ", fechaHora=" + fechaHora + ", monto=" + monto + ", idCuentaOrigen=" + idCuentaOrigen + ", idCuentaDestino=" + idCuentaDestino + '}';
    }

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
