/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Objects;

/**
 *
 * @author Toled
 */
public class RetiroSinCuenta {

    private int id;
    private String fechaInicio;
    private String fechaFin;
    private EstadoRetiroSinCuenta estado;
    private Double monto;
    private String password;
    private String folio;
    private int idCuentaBancaria;
    private String tiempoExpiracionMinutos;

    public RetiroSinCuenta() {
    }

    public RetiroSinCuenta(int id) {
        this.id = id;
    }

    public RetiroSinCuenta(String fechaInicio, String fechaFin, EstadoRetiroSinCuenta estado, Double monto, String password, int idCuentaBancaria) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.monto = monto;
        this.password = password;
        this.idCuentaBancaria = idCuentaBancaria;
        this.tiempoExpiracionMinutos = "10";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getTiempoExpiracion() {
        return tiempoExpiracionMinutos;
    }

    public void setTiempoExpiracion(String tiempoExpiracion) {
        this.tiempoExpiracionMinutos = tiempoExpiracion;
    }
    
    

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EstadoRetiroSinCuenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoRetiroSinCuenta estado) {
        this.estado = estado;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    @Override
    public String toString() {
        return "RetiroSinCuenta{" + "id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + ", monto=" + monto + ", password=" + password + ", folio=" + folio + ", idCuentaBancaria=" + idCuentaBancaria + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.folio);
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
