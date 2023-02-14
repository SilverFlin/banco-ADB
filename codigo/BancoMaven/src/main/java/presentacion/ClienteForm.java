/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Elkur
 */
public class ClienteForm extends javax.swing.JFrame {

    private final static int INGRESAR = 1;
    
    
    private final static int REGISTRAR = 2;
    private final RegistroClienteForm regClnFrm;
    
    public ClienteForm() {
        initComponents();
        regClnFrm = new RegistroClienteForm(this);
    }

    private void openNewWindow(int type) {
        switch (type) {
            case INGRESAR:
                this.setVisible(false);
                regClnFrm.setVisible(true);               
                break;
            case REGISTRAR:
                this.setVisible(false);
               regClnFrm.setVisible(true);         
                break;
        }
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
        jPasswordField1 = new javax.swing.JPasswordField();
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

        jPasswordField1.setBorder(null);
        Background.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 190, 20));

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
        openNewWindow(INGRESAR);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblRetiroSinTarjetaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRetiroSinTarjetaMousePressed
        JOptionPane.showMessageDialog(this, "Retiro sin tarjeta");
    }//GEN-LAST:event_lblRetiroSinTarjetaMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JLabel lblRetiroSinTarjeta;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel txtIniciarSesion;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
