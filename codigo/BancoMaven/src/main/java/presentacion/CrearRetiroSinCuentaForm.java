/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import dominio.Cliente;
import dominio.CuentaBancaria;
import dominio.EstadoRetiroSinCuenta;
import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import implementaciones.CuentasBancariasDAO;
import implementaciones.RetirosSinCuentaDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasBancariasDAO;
import interfaces.IRetirosSinCuentaDAO;
import java.awt.Color;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import org.mindrot.jbcrypt.BCrypt;
import utils.ConfiguracionPaginado;
import utils.Conversiones;
import utils.Validaciones;

/**
 *
 * @author Elkur
 */
public class CrearRetiroSinCuentaForm extends javax.swing.JFrame {

    private final IRetirosSinCuentaDAO retirosSinCuentaDAO;
    private final ICuentasBancariasDAO cuentasBancariasDAO;
    private CuentasForm cuentasForm;

    private final long TIEMPO_EXPIRACION = 1000 * 60 * 10;
    private CuentaBancaria cuentaBancaria;
    private Cliente cliente;

    public CrearRetiroSinCuentaForm(IConexionBD conBD, CuentasForm cuentasForm, Cliente cliente) {
        initComponents();
        this.retirosSinCuentaDAO = new RetirosSinCuentaDAO(conBD);
        this.cuentasBancariasDAO = new CuentasBancariasDAO(conBD);
        this.cuentasForm = cuentasForm;
        this.cliente = cliente;

        this.llenarComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        Background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        lblCuenta = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblMonto = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnCrearRetiro = new javax.swing.JButton();
        cBoxNoCuentas = new javax.swing.JComboBox<>();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        lblTitulo.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Retiro Sin Cuenta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(208, 208, 208))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitulo)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        Background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 90));

        txtMonto.setForeground(new java.awt.Color(51, 51, 51));
        txtMonto.setToolTipText("");
        txtMonto.setBorder(null);
        Background.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 190, 20));

        lblCuenta.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblCuenta.setText("No. Cuenta");
        Background.add(lblCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 180, 20));
        Background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 190, 10));

        lblMonto.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblMonto.setText("Monto");
        Background.add(lblMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, -1));

        btnRegresar.setBackground(new java.awt.Color(0, 102, 204));
        btnRegresar.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setBorder(null);
        btnRegresar.setBorderPainted(false);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        Background.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 70, 30));

        btnCrearRetiro.setBackground(new java.awt.Color(0, 102, 204));
        btnCrearRetiro.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        btnCrearRetiro.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearRetiro.setText("Crear");
        btnCrearRetiro.setBorder(null);
        btnCrearRetiro.setBorderPainted(false);
        btnCrearRetiro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCrearRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearRetiroActionPerformed(evt);
            }
        });
        Background.add(btnCrearRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 70, 30));

        cBoxNoCuentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cBoxNoCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxNoCuentasActionPerformed(evt);
            }
        });
        Background.add(cBoxNoCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.regresarACuentas();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCrearRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearRetiroActionPerformed
        this.crearRetiro();
    }//GEN-LAST:event_btnCrearRetiroActionPerformed

    private void cBoxNoCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxNoCuentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBoxNoCuentasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton btnCrearRetiro;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cBoxNoCuentas;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables

    private void crearRetiro() {

        try {
            consultarCuenta();
            if (this.cuentaBancaria == null) {
                this.mostrarError("Cuenta no existente");
                return;
            }
            if (!isValidMonto()) {
                this.mostrarError("Monto invalido");
                return;
            }

            if (!fondosSuficientes()) {
                this.mostrarError("Fondos insuficientes");
                return;
            }

            String password = pedirPassword();
            if (!validarPassword(password)) {
                this.mostrarError("Contraseña invalida");
                return;
            }
            // TODO pedir password de cuenta
            //TODO generar password de retiro
            String passwordRetiro = this.generarPasswordRetiro(); // Mostrar
            RetiroSinCuenta retiroSinCuenta = this.crearRetiro(obtenerMonto(), passwordRetiro);
            System.out.println(retiroSinCuenta);
            System.out.println(passwordRetiro);
            this.mostrarFolioYPassword(passwordRetiro, retiroSinCuenta);
            this.regresarACuentas();
            // TODO mostrar password de retiro y folio y tiempo fin
            //
        } catch (PersistenciaException ex) {
            Logger.getLogger(CrearRetiroSinCuentaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // TODO mover a utils/Validaciones
    private void consultarCuenta() throws PersistenciaException {
        this.cuentaBancaria = this.cuentasBancariasDAO.consultar(String.valueOf(cBoxNoCuentas.getSelectedItem()));

    }

    private boolean isValidMonto() {
        Double monto = obtenerMonto();
        return !Validaciones.isNull(monto) && Validaciones.isPositivo(monto);
    }

    private Double obtenerMonto() {
        return Conversiones.crearMontoDeTexto(this.txtMonto.getText());
    }

    private String generarPasswordRetiro() {

        long longitud = 8L;
        long limiteInferior = (long) Math.pow(10, longitud - 1);
        long limiteSuperior = (long) (Math.pow(10, longitud) - 1.0);
        long randomDigitNum = (long) (limiteInferior + Math.random() * limiteSuperior);
        String password = Long.toString(randomDigitNum);
        return password;
    }

    private RetiroSinCuenta crearRetiro(Double monto, String password) throws PersistenciaException {

        String fechaInicio = new Timestamp(System.currentTimeMillis()).toString();
        String fechaFin = new Timestamp(System.currentTimeMillis() + TIEMPO_EXPIRACION).toString();
        String passwordEncriptada = BCrypt.hashpw(new String(password), BCrypt.gensalt());

        RetiroSinCuenta retiroSinCuenta = new RetiroSinCuenta(
                fechaInicio,
                fechaFin,
                EstadoRetiroSinCuenta.PENDIENTE,
                monto,
                passwordEncriptada,
                "removerFolioDominio",
                this.cuentaBancaria.getId());

        return retirosSinCuentaDAO.insertar(retiroSinCuenta, this.cuentaBancaria);
    }

    private void llenarComboBox() {
        try {
            List<CuentaBancaria> cuentasBancarias = cuentasBancariasDAO.consultar(new ConfiguracionPaginado(), this.cliente.getId());
            List<String> noCuentasBancarias = extraerNoCuenta(cuentasBancarias);
            this.cBoxNoCuentas.setModel(new DefaultComboBoxModel<>(noCuentasBancarias.toArray(new String[0])));
        } catch (PersistenciaException ex) {
            Logger.getLogger(CrearRetiroSinCuentaForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private List<String> extraerNoCuenta(List<CuentaBancaria> cuentasBancarias) {
        List<String> noCuentasBancarias = new ArrayList<>();
        cuentasBancarias.forEach((cuenta) -> {
            noCuentasBancarias.add(cuenta.getNoCuenta());
        });
        return noCuentasBancarias;
    }

    private void mostrarFolioYPassword(String passwordRetiro, RetiroSinCuenta retiroSinCuenta) {
        String msg
                = "Retiro creado"
                + "\nFolio: " + retiroSinCuenta.getFolio()
                + "\nPassword: " + passwordRetiro
                + "\n Caduca a las: " + retiroSinCuenta.getFechaFin();

        JOptionPane.showMessageDialog(this, msg);
    }

    private void regresarACuentas() {
        this.cuentasForm.setVisible(true);
        this.setVisible(false);
    }

    private boolean fondosSuficientes() {
        double saldo = this.cuentaBancaria.getSaldoMXN();
        return saldo >= this.obtenerMonto();
    }

    private void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Algo salio mal", JOptionPane.ERROR_MESSAGE);
    }

    private String pedirPassword() {
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

    private boolean validarPassword(String passwordCandidato) {
        System.out.println(passwordCandidato);
        System.out.println(cliente.getContrasenia());
        return BCrypt.checkpw(passwordCandidato, cliente.getContrasenia());
    }
}
