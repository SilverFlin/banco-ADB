/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import dominio.Cliente;
import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import implementaciones.CuentasBancariasDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasBancariasDAO;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Elkur
 */
public class ClienteForm extends javax.swing.JFrame {

    private final static int INGRESAR = 1;
    private final static int REGISTRAR = 2;
    
    private final RegistroClienteForm registroClienteForm;
    private MenuPrincipalForm menuPrincipalForm;
    private IConexionBD conBD;
    private final IClientesDAO clientesDAO;
    private final ICuentasBancariasDAO cuentasBancariasDAO;
    private Cliente cliente;

    public ClienteForm(IConexionBD conBD) {
        initComponents();
        this.conBD = conBD;
        this.registroClienteForm = new RegistroClienteForm(this,conBD);
        
        this.clientesDAO = new ClientesDAO(conBD);
        this.cuentasBancariasDAO = new CuentasBancariasDAO(conBD);
    }

    private void openNewWindow(int type) {
        switch (type) {
            case INGRESAR:
                this.setVisible(false);
                this.menuPrincipalForm = new MenuPrincipalForm(this.conBD, cliente);
                this.menuPrincipalForm.setVisible(true);
                break;
            case REGISTRAR:
                this.setVisible(false);
                registroClienteForm.setVisible(true);
                break;
        }
    }

    private void login() {
        if (validarCampos()) {
            if (validarCredenciales()) {
                openNewWindow(INGRESAR);
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales no validas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validarCampos() {
        String correo = txtUsuario.getText();
        String contraseña = new String(txtContraseña.getPassword());

        return correo.length() > 0 && contraseña.length() > 0;

    }

    private boolean validarCredenciales() {
        Cliente tempCliente = clientesDAO.consultar(txtUsuario.getText());
        this.cliente = tempCliente;

        if (tempCliente != null) {
            return validarPassword(tempCliente.getContrasenia());
        }else{
            return false;
        }
    }
    
    private boolean validarPassword(String password){
        String passwordCandidato = new String(txtContraseña.getPassword());
        System.out.println(passwordCandidato);
        System.out.println(password);
	return BCrypt.checkpw(passwordCandidato, password);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        Background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblBienvenido = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblUsuario = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblContraseña = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        txtIniciarSesion = new javax.swing.JLabel();
        lblRegistrar = new javax.swing.JLabel();
        lblRetiroSinTarjeta = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        lblBienvenido.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        lblBienvenido.setForeground(new java.awt.Color(255, 255, 255));
        lblBienvenido.setText("Bienvenido");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(245, Short.MAX_VALUE)
                .addComponent(lblBienvenido)
                .addGap(243, 243, 243))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblBienvenido)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        Background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 90));

        txtUsuario.setForeground(new java.awt.Color(51, 51, 51));
        txtUsuario.setToolTipText("");
        txtUsuario.setBorder(null);
        Background.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 190, 20));
        Background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 190, 10));

        lblUsuario.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblUsuario.setText("Usuario");
        Background.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 180, 20));
        Background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 190, 10));

        lblContraseña.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblContraseña.setText("Contraseña");
        Background.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, -1));

        txtContraseña.setBorder(null);
        Background.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 190, 20));

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ingresar");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Background.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 70, 30));

        txtIniciarSesion.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 16)); // NOI18N
        txtIniciarSesion.setText("Iniciar sesion");
        Background.add(txtIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        lblRegistrar.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblRegistrar.setForeground(new java.awt.Color(0, 153, 255));
        lblRegistrar.setText("Registrarse");
        lblRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRegistrarMousePressed(evt);
            }
        });
        Background.add(lblRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        lblRetiroSinTarjeta.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblRetiroSinTarjeta.setForeground(new java.awt.Color(0, 153, 255));
        lblRetiroSinTarjeta.setText("Retiro sin tarjeta");
        lblRetiroSinTarjeta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblRetiroSinTarjeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRetiroSinTarjetaMousePressed(evt);
            }
        });
        Background.add(lblRetiroSinTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, -1, -1));

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

    private void lblRegistrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarMousePressed
        openNewWindow(REGISTRAR);
    }//GEN-LAST:event_lblRegistrarMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.login();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblRetiroSinTarjetaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRetiroSinTarjetaMousePressed
        RetirarSinCuentaForm retiroSinCuentaForm = new RetirarSinCuentaForm(this.conBD);
        retiroSinCuentaForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblRetiroSinTarjetaMousePressed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JLabel lblRetiroSinTarjeta;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JLabel txtIniciarSesion;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
