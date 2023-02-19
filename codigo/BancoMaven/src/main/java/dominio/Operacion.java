/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public Operacion(int id, Date fechaHora, String detalles, int idCuentaBancaria) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.detalles = detalles;
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public Operacion(Date fechaHora, String detalles, int idCuentaBancaria) {
        this.fechaHora = fechaHora;
        this.detalles = detalles;
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
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
        final Operacion other = (Operacion) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Operacion{" + "id=" + id + ", monto=" + monto + ", fechaHora=" + fechaHora + ", detalles=" + detalles + ", idCuentaBancaria=" + idCuentaBancaria + '}';
    }
    
     
}
