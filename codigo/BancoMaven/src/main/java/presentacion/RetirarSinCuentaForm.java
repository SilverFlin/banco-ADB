package presentacion;

import dominio.EstadoRetiroSinCuenta;
import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;
import implementaciones.CuentasBancariasDAO;
import implementaciones.RetirosSinCuentaDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasBancariasDAO;
import interfaces.IRetirosSinCuentaDAO;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Dialogs;
import static utils.Validaciones.validarCaducidadRetiro;
import static utils.Validaciones.validarCuentaActiva;
import static utils.Validaciones.validarPassword;

/**
 *
 * @author Elkur
 */
public class RetirarSinCuentaForm extends javax.swing.JFrame {

    private final IRetirosSinCuentaDAO retirosSinCuentaDAO;
    private final ICuentasBancariasDAO cuentasBancariasDAO;
    private IniciarSesionForm clienteForm;

    private static final Logger LOG = Logger.getLogger(RetirarSinCuentaForm.class.getName());
    private RetiroSinCuenta retiroSinCuenta;

    public RetirarSinCuentaForm(IConexionBD conBD) {
        initComponents();
        this.retirosSinCuentaDAO = new RetirosSinCuentaDAO(conBD);
        this.cuentasBancariasDAO = new CuentasBancariasDAO(conBD);
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
        this.regresar();
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
            this.retiroSinCuenta = consultarRetiro();
            if (!this.validarRetiro()) {
                return;
            }

            retirosSinCuentaDAO.retirar(retiroSinCuenta);
            Dialogs.mostrarMensajeExito(this, "Retiro de $" + retiroSinCuenta.getMonto() + " efectuado");
            this.regresar();

        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }

    private RetiroSinCuenta consultarRetiro() throws PersistenciaException {
        return retirosSinCuentaDAO.consultar(txtFolio.getText());

    }

    private void regresar() {
        this.clienteForm.setVisible(true);
        this.setVisible(false);
    }

    private boolean validarRetiro() throws PersistenciaException {
        if (this.retiroSinCuenta == null) {
            Dialogs.mostrarMensajeError(this, "Folio inexistente");
            return false;
        }
        this.retiroSinCuenta = validarCaducidadRetiro(this.retirosSinCuentaDAO, retiroSinCuenta);
        if (this.retiroSinCuenta.getEstado() == EstadoRetiroSinCuenta.COBRADO) {
            Dialogs.mostrarMensajeError(this, "Este retiro ya fue cobrado");
            return false;
        }
        if (this.retiroSinCuenta.getEstado() == EstadoRetiroSinCuenta.EXPIRADO) {
            Dialogs.mostrarMensajeError(this, "Este retiro ha expirado");
            return false;
        }

        if (this.retiroSinCuenta.getEstado() != EstadoRetiroSinCuenta.PENDIENTE) {
            Dialogs.mostrarMensajeError(this, "Retiro invalido");
            return false;
        }
        if (!validarPassword(retiroSinCuenta.getPassword(), Arrays.toString(txtContraseña.getPassword()))) {
            Dialogs.mostrarMensajeError(this, "Credenciales invalidas");
            return false;
        }
        if (!validarCuentaActiva(this.cuentasBancariasDAO, retiroSinCuenta)) {
            Dialogs.mostrarMensajeError(this, "La cuenta se encuentra inactiva.");
            return false;
        }

        return true;
    }

}
