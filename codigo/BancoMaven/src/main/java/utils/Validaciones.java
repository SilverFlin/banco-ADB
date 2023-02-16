/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Toled
 */
public class Validaciones {
    

    /**
     * Checa si el monto es un numero positivo
     * @param monto
     * @return positivo, si el numero es mayor a 0
     */
    public static boolean isPositivo(Double monto){
        return !Validaciones.isNull(monto)&& monto >= 0;
    }
    
    public static <T> boolean isNull(T elemento){
        return elemento == null;
    }
}
