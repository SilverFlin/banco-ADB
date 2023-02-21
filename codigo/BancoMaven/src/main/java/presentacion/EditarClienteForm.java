package presentacion;

import dominio.Cliente;
import dominio.Domicilio;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import implementaciones.DomiciliosDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static utils.Dialogs.mostrarMensajeError;
import static utils.Dialogs.mostrarMensajeExito;
import static utils.Validaciones.validarPassword;

/**
 *
 * @author Toled
 */
public class EditarClienteForm extends javax.swing.JFrame {

    /**
     * Creates new form EditarClienteForm
     */
    private static final Logger LOG = Logger.getLogger(CuentasForm.class.getName());
    private final IClientesDAO clientesDAO;
    private final IConexionBD conBD;
    private final JFrame frameAnterior;
    private final Cliente cliente;
    private final DomiciliosDAO domiciliosDAO;

    public EditarClienteForm(JFrame frame, IConexionBD conBD, Cliente cliente) {
        initComponents();
        this.conBD = conBD;
        this.frameAnterior = frame;
        this.cliente = cliente;
        this.clientesDAO = new ClientesDAO(conBD);
        this.domiciliosDAO = new DomiciliosDAO(conBD);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background3 = new javax.swing.JPanel();
        head3 = new javax.swing.JPanel();
        txtEditar = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtCalle = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        lblCalle = new javax.swing.JLabel();
        txtColonia = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        lblContrasena = new javax.swing.JLabel();
        txtCodigoPostal = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        lblCodigoPostal = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        lblColonia1 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background3.setBackground(new java.awt.Color(255, 255, 255));
        background3.setMaximumSize(new java.awt.Dimension(600, 400));
        background3.setMinimumSize(new java.awt.Dimension(600, 400));
        background3.setPreferredSize(new java.awt.Dimension(600, 400));
        background3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head3.setBackground(new java.awt.Color(0, 102, 255));

        txtEditar.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        txtEditar.setForeground(new java.awt.Color(255, 255, 255));
        txtEditar.setText("Editar");

        javax.swing.GroupLayout head3Layout = new javax.swing.GroupLayout(head3);
        head3.setLayout(head3Layout);
        head3Layout.setHorizontalGroup(
            head3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(head3Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(txtEditar)
                .addContainerGap(268, Short.MAX_VALUE))
        );
        head3Layout.setVerticalGroup(
            head3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, head3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(txtEditar)
                .addGap(36, 36, 36))
        );

        background3.add(head3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 90));
        background3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 210, 10));

        txtCalle.setForeground(new java.awt.Color(51, 51, 51));
        txtCalle.setToolTipText("");
        txtCalle.setBorder(null);
        background3.add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 100, 20));
        background3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 100, 10));

        lblCalle.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblCalle.setText("Calle");
        background3.add(lblCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 90, 20));

        txtColonia.setForeground(new java.awt.Color(51, 51, 51));
        txtColonia.setToolTipText("");
        txtColonia.setBorder(null);
        background3.add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 100, 20));
        background3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 100, 10));

        lblContrasena.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblContrasena.setText("Contraseña");
        background3.add(lblContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 80, 20));

        txtCodigoPostal.setForeground(new java.awt.Color(51, 51, 51));
        txtCodigoPostal.setToolTipText("");
        txtCodigoPostal.setBorder(null);
        background3.add(txtCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 100, 20));
        background3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 100, 10));

        lblCodigoPostal.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblCodigoPostal.setText("Codigo postal");
        background3.add(lblCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 90, 20));

        btnGuardar.setBackground(new java.awt.Color(0, 102, 255));
        btnGuardar.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setBorderPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        background3.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 80, 30));

        lblColonia1.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblColonia1.setText("Colonia");
        background3.add(lblColonia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 50, 20));

        txtContrasena.setBorder(null);
        background3.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 210, 20));

        btnCancelar.setBackground(new java.awt.Color(0, 102, 255));
        btnCancelar.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setBorderPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        background3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 80, 30));

        lblNumero.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblNumero.setText("Numero");
        background3.add(lblNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 90, 20));

        txtNumero.setForeground(new java.awt.Color(51, 51, 51));
        txtNumero.setToolTipText("");
        txtNumero.setBorder(null);
        background3.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 100, 20));
        background3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 100, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.regresar();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background3;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel head3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblCodigoPostal;
    private javax.swing.JLabel lblColonia1;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCodigoPostal;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JLabel txtEditar;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables

    private void guardar() {

        if (this.validarCampos()) {
            Domicilio domicilio = new Domicilio(this.cliente.getIdDomicilio(), txtCalle.getText(), txtNumero.getText(), txtColonia.getText(), txtCodigoPostal.getText());
            try {
                domiciliosDAO.actualizar(domicilio);
                mostrarMensajeExito(this, "Datos Actualizados");
                this.regresar();
            } catch (PersistenciaException ex) {
                mostrarMensajeError(this, "Error al actualizar datos, intenta de nuevo.");
                LOG.log(Level.SEVERE, ex.getMessage());
            }
        }

    }

    private boolean validarCampos() {
        if (!validarCamposVacios()) {
            JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacios");
            return false;
        }

        if (!validarPassword(Arrays.toString(txtContrasena.getPassword()), this.cliente)) {
            JOptionPane.showMessageDialog(this, "Password invalida");
            return false;
        }
        return true;
    }

    private boolean validarCamposVacios() {
        String calle = txtCalle.getText();
        String colonia = txtColonia.getText();
        String codigoPostal = txtCodigoPostal.getText();
        String contrasenha = txtContrasena.getText();

        return !calle.isEmpty()
                && !colonia.isEmpty()
                && !codigoPostal.isEmpty()
                && !contrasenha.isEmpty();

    }

    private void regresar() {
        this.frameAnterior.setVisible(true);
        this.setVisible(false);
    }

}
