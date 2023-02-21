/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dominio.Cliente;
import javax.swing.JLabel;

/**
 *
 * @author Toled
 */
public class FormUtils {
    public static void cargarMensajeBienvenida(JLabel label,Cliente cliente) {
        label.setText("Hola, " + cliente.getNombres() + "!");
    }
}
