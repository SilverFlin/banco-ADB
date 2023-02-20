/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import dominio.Cliente;
import dominio.CuentaBancaria;
import dominio.EstadoRetiroSinCuenta;
import dominio.Operacion;
import dominio.RetiroSinCuenta;
import dominio.Transferencia;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import implementaciones.CuentasBancariasDAO;
import implementaciones.OperacionesDAO;
import implementaciones.RetirosSinCuentaDAO;
import implementaciones.TransferenciasDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasBancariasDAO;
import interfaces.IOperacionesDAO;
import interfaces.IRetirosSinCuentaDAO;
import interfaces.ITransferenciasDAO;
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
import utils.Mensajes;
import utils.Validaciones;

/**
 *
 * @author Elkur
 */
public class CrearTransferenciaForm extends javax.swing.JFrame {

    private final ITransferenciasDAO transferenciasDAO;
    private final ICuentasBancariasDAO cuentasBancariasDAO;
    private final IOperacionesDAO operacionesDAO;
    
    private final long TIEMPO_EXPIRACION = 1000 * 60 * 10;
    private CuentaBancaria cuentaBancaria;
    private Cliente cliente;
    private final MenuPrincipalForm menuPrincipalForm;

    public CrearTransferenciaForm(IConexionBD conBD, MenuPrincipalForm menuPrincipalForm, Cliente cliente) {
        initComponents();
        this.transferenciasDAO = new TransferenciasDAO(conBD);
        this.cuentasBancariasDAO = new CuentasBancariasDAO(conBD);
        this.operacionesDAO = new OperacionesDAO(conBD);
        this.menuPrincipalForm = menuPrincipalForm;
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
        txtCuentaDestino = new javax.swing.JTextField();
        lblCuentaOrigen = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblCuentaDestino = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnTransferir = new javax.swing.JButton();
        cBoxCuentasOrigen = new javax.swing.JComboBox<>();
        lblMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();

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
        lblTitulo.setText("Nueva Transferencia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
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

        txtCuentaDestino.setForeground(new java.awt.Color(51, 51, 51));
        txtCuentaDestino.setToolTipText("");
        txtCuentaDestino.setBorder(null);
        Background.add(txtCuentaDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 190, 20));

        lblCuentaOrigen.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblCuentaOrigen.setText("Cuenta Origen");
        Background.add(lblCuentaOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 180, 20));
        Background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 190, 10));

        lblCuentaDestino.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblCuentaDestino.setText("Cuenta Destino");
        Background.add(lblCuentaDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, -1, -1));

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

        btnTransferir.setBackground(new java.awt.Color(0, 102, 204));
        btnTransferir.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        btnTransferir.setForeground(new java.awt.Color(255, 255, 255));
        btnTransferir.setText("Transferir");
        btnTransferir.setBorder(null);
        btnTransferir.setBorderPainted(false);
        btnTransferir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });
        Background.add(btnTransferir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 70, 30));

        cBoxCuentasOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cBoxCuentasOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxCuentasOrigenActionPerformed(evt);
            }
        });
        Background.add(cBoxCuentasOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 190, -1));

        lblMonto.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblMonto.setText("Monto");
        Background.add(lblMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));

        txtMonto.setForeground(new java.awt.Color(51, 51, 51));
        txtMonto.setToolTipText("");
        txtMonto.setBorder(null);
        Background.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 190, 20));
        Background.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 190, 10));

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
        this.regresarAMenu();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
        this.crearTransferencia();
    }//GEN-LAST:event_btnTransferirActionPerformed

    private void cBoxCuentasOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxCuentasOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBoxCuentasOrigenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JComboBox<String> cBoxCuentasOrigen;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblCuentaDestino;
    private javax.swing.JLabel lblCuentaOrigen;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCuentaDestino;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables

    private void consultarCuenta() throws PersistenciaException {
        this.cuentaBancaria = this.cuentasBancariasDAO.consultar(String.valueOf(cBoxCuentasOrigen.getSelectedItem()));

    }

    private CuentaBancaria obtenerCuentaDestino() {
        try {
            return this.cuentasBancariasDAO.consultar(this.txtCuentaDestino.getText());
        } catch (PersistenciaException ex) {
            Logger.getLogger(CrearTransferenciaForm.class.getName()).log(Level.SEVERE, null, ex);
            this.mostrarError("La cuenta destino no existe.");
            return null;
        }
    }

    private void llenarComboBox() {
        try {
            List<CuentaBancaria> cuentasBancarias = cuentasBancariasDAO.consultar(new ConfiguracionPaginado(), this.cliente.getId());
            List<String> noCuentasBancarias = extraerNoCuenta(cuentasBancarias);
            this.cBoxCuentasOrigen.setModel(new DefaultComboBoxModel<>(noCuentasBancarias.toArray(new String[0])));
        } catch (PersistenciaException ex) {
            Logger.getLogger(CrearTransferenciaForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private List<String> extraerNoCuenta(List<CuentaBancaria> cuentasBancarias) {
        List<String> noCuentasBancarias = new ArrayList<>();
        cuentasBancarias.forEach((cuenta) -> {
            noCuentasBancarias.add(cuenta.getNoCuenta());
        });
        return noCuentasBancarias;
    }

    private void regresarAMenu() {
        this.menuPrincipalForm.setVisible(true);
        this.setVisible(false);
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
        return BCrypt.checkpw(passwordCandidato, cliente.getContrasenia());
    }

    private void crearTransferencia() {
        try {
            consultarCuenta();
            if (this.cuentaBancaria == null) {
                this.mostrarError("Cuenta Origen existente");
                return;
            }
            CuentaBancaria cuentaDestino = this.obtenerCuentaDestino();

            if (cuentaDestino == null) {
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
            Transferencia transferencia = new Transferencia(obtenerMonto(), this.cuentaBancaria.getId(), cuentaDestino.getId());
            Transferencia transferenciaExitosa = this.transferenciasDAO.insertar(transferencia);
            
            /* Registrar una operacion*/
            int idCuentaOrigen = transferenciaExitosa.getIdCuentaOrigen();
            Operacion operacion = new Operacion(null,Mensajes.generarRegistroTransferencia(transferenciaExitosa.getMonto(), idCuentaOrigen+"", transferenciaExitosa.getIdCuentaDestino()+""),idCuentaOrigen);
            operacionesDAO.insertar(operacion);
            
            this.mostrarExito("Transferencia satisfactoria");
            this.regresarAMenu();
        } catch (PersistenciaException ex) {
            Logger.getLogger(CrearRetiroSinCuentaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean isValidMonto() {
        Double monto = obtenerMonto();
        return !Validaciones.isNull(monto) && Validaciones.isPositivo(monto);
    }

    private Double obtenerMonto() {
        return Conversiones.crearMontoDeTexto(this.txtMonto.getText());
    }

    private boolean fondosSuficientes() {
        double saldo = this.cuentaBancaria.getSaldoMXN();
        return saldo >= this.obtenerMonto();
    }

    private void mostrarExito(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Exito", JOptionPane.INFORMATION_MESSAGE);
    }
}
