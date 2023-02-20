/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Toled
 */
public class Dialogs {
    public static void mostrarError(Component componente, String msg) {
        JOptionPane.showMessageDialog(componente, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarMensajeExito(Component componente,String msg) {
        JOptionPane.showMessageDialog(componente, msg, "Exito", JOptionPane.PLAIN_MESSAGE);
    }
}
