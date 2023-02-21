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
public class Utils {

    public static String generarPasswordRetiro() {
        long longitud = 8L;
        long limiteInferior = (long) Math.pow(10, longitud - 1);
        long limiteSuperior = (long) (Math.pow(10, longitud) - 1.0);
        long randomDigitNum = (long) (limiteInferior + Math.random() * limiteSuperior);
        String password = Long.toString(randomDigitNum);
        return password;
    }
}
