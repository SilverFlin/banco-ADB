package utils;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author Toled
 */
public class Dialogs {

    public static void mostrarMensajeError(Component componente, String msg) {
        JOptionPane.showMessageDialog(componente, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarMensajeExito(Component componente, String msg) {
        JOptionPane.showMessageDialog(componente, msg, "Exito", JOptionPane.PLAIN_MESSAGE);
    }

    public static String pedirPassword() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Ingresa una contraseña:");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancelar"};
        int option = JOptionPane.showOptionDialog(null, panel, "Credenciales",
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[1]);
        // pressing OK button
        if (option == 0) {
            char[] password = pass.getPassword();
            return new String(password);
        }
        return "";
    }

    public static String pedirInputUsuario(Component componente, String titulo, String texto) {
        return (String) JOptionPane.showInputDialog(componente, texto, titulo, JOptionPane.QUESTION_MESSAGE);
    }

}
