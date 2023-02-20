/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import dominio.Cliente;
import dominio.EstadoRetiroSinCuenta;
import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import implementaciones.RetirosSinCuentaDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.IRetirosSinCuentaDAO;
import java.awt.Color;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;
import utils.Dialogs;

/**
 *
 * @author Elkur
 */
public class RetirarSinCuentaForm extends javax.swing.JFrame {

    private final IRetirosSinCuentaDAO retirosSinCuentaDAO;
    private IniciarSesionForm clienteForm;

    public RetirarSinCuentaForm(IConexionBD conBD) {
        initComponents();
        this.retirosSinCuentaDAO = new RetirosSinCuentaDAO(conBD);
        this.clienteForm = new IniciarSesionForm(conBD);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        Background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblFolio = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblContraseña = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        btnRegresar = new javax.swing.JButton();
        txtIniciarSesion = new javax.swing.JLabel();
        btnRetirar = new javax.swing.JButton();

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

        txtFolio.setForeground(new java.awt.Color(51, 51, 51));
        txtFolio.setToolTipText("");
        txtFolio.setBorder(null);
        Background.add(txtFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 190, 20));
        Background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 190, 10));

        lblFolio.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblFolio.setText("Folio");
        Background.add(lblFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 180, 20));
        Background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 190, 10));

        lblContraseña.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblContraseña.setText("Contraseña");
        Background.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, -1));

        txtContraseña.setBorder(null);
        Background.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 190, 20));

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

        txtIniciarSesion.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 16)); // NOI18N
        Background.add(txtIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));

        btnRetirar.setBackground(new java.awt.Color(0, 102, 204));
        btnRetirar.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        btnRetirar.setForeground(new java.awt.Color(255, 255, 255));
        btnRetirar.setText("Retirar");
        btnRetirar.setBorder(null);
        btnRetirar.setBorderPainted(false);
        btnRetirar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });
        Background.add(btnRetirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 70, 30));

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
        this.clienteForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed
        this.retirar();
    }//GEN-LAST:event_btnRetirarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblFolio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JLabel txtIniciarSesion;
    // End of variables declaration//GEN-END:variables

    private void retirar() {

        try {
            RetiroSinCuenta retiroSinCuenta = consultarRetiro();
            if (retiroSinCuenta == null) {
                Dialogs.mostrarError(this, "Folio inexistente");
                return;
            }
            
            retiroSinCuenta = this.validarCaducidad(retiroSinCuenta);
            if (retiroSinCuenta.getEstado() == EstadoRetiroSinCuenta.COBRADO) {
                Dialogs.mostrarError(this, "Este retiro ya fue cobrado");
                return;
            }
            if (retiroSinCuenta.getEstado() == EstadoRetiroSinCuenta.EXPIRADO) {
                Dialogs.mostrarError(this, "Este retiro ha expirado");
                return;
            }
            if (retiroSinCuenta.getEstado() == EstadoRetiroSinCuenta.PENDIENTE) {
                if (validarPassword(retiroSinCuenta.getPassword())) {
                    retirosSinCuentaDAO.retirar(retiroSinCuenta);
                }else{
                    Dialogs.mostrarError(this, "Credenciales invalidas");
                    return;
                }
            }

        } catch (PersistenciaException ex) {
            Logger.getLogger(RetirarSinCuentaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // TODO mover a utils/Validaciones
    private RetiroSinCuenta consultarRetiro() throws PersistenciaException {
        return retirosSinCuentaDAO.consultar(txtFolio.getText());

    }

    private boolean validarPassword(String password) {
        String passwordCandidato = new String(txtContraseña.getPassword());
        System.out.println(passwordCandidato);
        System.out.println(password);
        return BCrypt.checkpw(passwordCandidato, password);
    }

    private RetiroSinCuenta validarCaducidad(RetiroSinCuenta retiroSinCuenta) throws PersistenciaException {
        Date fechaFin = new Date(retiroSinCuenta.getFechaFin());
        
        if(fechaFin.after(new Date())){
            retiroSinCuenta.setEstado(EstadoRetiroSinCuenta.EXPIRADO);
            retiroSinCuenta = retirosSinCuentaDAO.actualizar(retiroSinCuenta);
        }
        
        return retiroSinCuenta;
        
    }
}
