package dominio;

import java.util.Objects;

/**
 *
 * @author Toled
 */
public class RetiroSinCuenta {

    /**
     * Identificador del retiro sin cuenta
     */
    private int id;
    /**
     * Fecha de inicio del retiro sin cuenta
     */
    private String fechaInicio;
    /**
     * Fecha fin del retiro sin cuenta
     */
    private String fechaFin;
    /**
     * Estado actual del retiro sin cuenta
     */
    private EstadoRetiroSinCuenta estado;
    /**
     * Monto del retiro
     */
    private Double monto;
    /**
     * Contrasenia para acceder al retiro
     */
    private String password;
    /**
     * Folio para acceder al retiro
     */
    private String folio;
    /**
     * Identificador de la cuenta asociada al retiro
     */
    private int idCuentaBancaria;
    /**
     * Tiempo que durara el retiro sin cuenta disponible
     */
    private String tiempoExpiracionMinutos;

    /**
     * Constructor vacio
     */
    public RetiroSinCuenta() {
    }

    /**
     * Constructor que solo inicializa el identificador
     *
     * @param id Identificador del retiro
     */
    public RetiroSinCuenta(int id) {
        this.id = id;
    }

    /**
     * Constructor que establece todos los los atributos recibidos
     *
     * @param fechaInicio Fecha en la que inicio el retiro
     * @param fechaFin Fecha en la que caduca el retiro
     * @param estado Estado actual del retiro
     * @param monto Monto del retiro
     * @param password Contrasenia de accedo del retiro
     * @param idCuentaBancaria Identificador de la cuenta asociada al retiro
     */
    public RetiroSinCuenta(String fechaInicio, String fechaFin, EstadoRetiroSinCuenta estado, Double monto, String password, int idCuentaBancaria) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.monto = monto;
        this.password = password;
        this.idCuentaBancaria = idCuentaBancaria;
        this.tiempoExpiracionMinutos = "10";
    }

    /**
     * Regresa el identificador del retiro sin cuenta
     *
     * @return Identificador del retiro
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del retiro
     *
     * @param id Identificador del retiro
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Regresa la fecha de inicio del retiro
     *
     * @return Fecha de inicio del retiro
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Regresa el tiempo de expiracion en minutos
     *
     * @return Tiempo de expiracion
     */
    public String getTiempoExpiracion() {
        return tiempoExpiracionMinutos;
    }

    /**
     * Establece el tiempo de expiracion del retiro
     *
     * @param tiempoExpiracion Tiempo de expiracion en minutos
     */
    public void setTiempoExpiracion(String tiempoExpiracion) {
        this.tiempoExpiracionMinutos = tiempoExpiracion;
    }

    /**
     * Establece la fecha de inicio del retiro
     *
     * @param fechaInicio Fecha de inicio del retiro
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Regresa la fecha de inicio del retiro
     *
     * @return Fecha de inicio del retiro
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de fin del retiro
     *
     * @param fechaFin Fecha fin del retiro
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Regresa el estado del retiro sin cuenta
     *
     * @return Estado de cuenta del retiro
     */
    public EstadoRetiroSinCuenta getEstado() {
        return estado;
    }

    /**
     * Establece el estado del retiro sin cuenta
     *
     * @param estado Estado del retiro
     */
    public void setEstado(EstadoRetiroSinCuenta estado) {
        this.estado = estado;
    }

    /**
     * Regresa el monto del retiro
     *
     * @return Monto del retiro
     */
    public Double getMonto() {
        return monto;
    }

    /**
     * Establece el monto del retiro
     *
     * @param monto Monto del retiro
     */
    public void setMonto(Double monto) {
        this.monto = monto;
    }

    /**
     * Regresa la contrasenia del retiro
     *
     * @return Contrasenia del retiro
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contrasenia del retiro
     *
     * @param password Contrasenia del retiro
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Regresa el folio del retiro
     *
     * @return Folio del retiro
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Establece el folio del retiro
     *
     * @param folio Folio del retiro
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * Regresa el identificador de la cuenta asociada al retiro
     *
     * @return Identificador de la cuenta
     */
    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    /**
     * Establece el identificador de la cuenta asociada
     *
     * @param idCuentaBancaria Identificador de la cuenta
     */
    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    /**
     * Cadena que contiene los atributos del retiro
     *
     * @return Cadena con atributos
     */
    @Override
    public String toString() {
        return "RetiroSinCuenta{" + "id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + ", monto=" + monto + ", password=" + password + ", folio=" + folio + ", idCuentaBancaria=" + idCuentaBancaria + '}';
    }

    /**
     * Genera el codigo hash
     *
     * @return Codigo hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.folio);
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
        final RetiroSinCuenta other = (RetiroSinCuenta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.folio, other.folio)) {
            return false;
        }
        return true;
    }

}
