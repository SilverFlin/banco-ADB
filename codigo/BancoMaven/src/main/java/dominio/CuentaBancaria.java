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
public class CuentaBancaria {
    private Integer id;
    private String noCuenta;
    private String fechaApertura;
    private Double saldoMXN;
    private Cliente clientePropietario;
    
    public CuentaBancaria() {
        generarNoCuenta();
        this.saldoMXN = 0.0;
    }
    
    
   private void generarNoCuenta(){
       /*Numero aleatorio de 16 digitos*/
       long rawNumCuenta = (long) (Math.random() * 9000_0000_0000_0000L + 1000_0000_0000_0000L );
       
       /*Separa el numero*/
       String[] arrNumCuenta = Long.toString(rawNumCuenta).split("(?<=\\G....)");
       String numCuenta = "";
       for (int i = 0; i < 4; i++) {
           if(i!=3){
               numCuenta += arrNumCuenta[i] + " ";
           }else numCuenta += arrNumCuenta[i];
       }
       
       this.noCuenta = numCuenta;
   }
   
   /**
    * Agrega saldo a la cuenta bancaria
    * @param cantidad 
    */
   public void agregarSaldo(double cantidad){
       
       if(cantidad <= 0)return;
       
       this.setSaldoMXN(this.getSaldoMXN() + cantidad);
   }

    public Integer getId() {
        return id;
    }

    public String getNoCuenta() {
        return noCuenta;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public Double getSaldoMXN() {
        return saldoMXN;
    }

    public Cliente getClientePropietario() {
        return clientePropietario;
    }

    public void setSaldoMXN(Double saldoMXN) {
        this.saldoMXN = saldoMXN;
    }

    public void setClientePropietario(Cliente clientePropietario) {
        this.clientePropietario = clientePropietario;
    }
    
    
    @Override
    public String toString() {
        return "CuentaBancaria{" + "id=" + id + ", noCuenta=" + noCuenta + ", fechaApertura=" + fechaApertura + ", saldoMXN=" + saldoMXN + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.noCuenta);
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
        final CuentaBancaria other = (CuentaBancaria) obj;
        if (!Objects.equals(this.noCuenta, other.noCuenta)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
   
    
    
   
    
}
