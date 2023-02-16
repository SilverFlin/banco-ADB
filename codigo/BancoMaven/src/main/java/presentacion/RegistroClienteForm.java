/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import implementaciones.DomiciliosDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.IDomiciliosDAO;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Elkur
 */
public class RegistroClienteForm extends javax.swing.JFrame {

    ClienteForm clnFrm;
    private final IClientesDAO clientesDAO;
    private final IDomiciliosDAO domiciliosDAO;

    public RegistroClienteForm(ClienteForm clnFrm, IConexionBD conexionBD) {
        initComponents();
        this.clnFrm = clnFrm;
        this.clientesDAO = new ClientesDAO(conexionBD);
        this.domiciliosDAO = new DomiciliosDAO(conexionBD);
    }

    private void registrar() {
        if (validarCampos()) {
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background3 = new javax.swing.JPanel();
        head3 = new javax.swing.JPanel();
        txtRegistar = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtApellidoP = new javax.swing.JTextField();
        lblApellidoP = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtApellidoM = new javax.swing.JTextField();
        lblApellidoM = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lblFechaNacimiento = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        lblCorreo = new javax.swing.JLabel();
        txtColonia = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        lblContrasena = new javax.swing.JLabel();
        txtCodigoPostal = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        lblCodigoPostal = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        lblColonia1 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        jSeparator8 = new javax.swing.JSeparator();
        dtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        txtCalle = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        lblCalle1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));

        background3.setBackground(new java.awt.Color(255, 255, 255));
        background3.setMaximumSize(new java.awt.Dimension(600, 400));
        background3.setMinimumSize(new java.awt.Dimension(600, 400));
        background3.setPreferredSize(new java.awt.Dimension(600, 400));
        background3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head3.setBackground(new java.awt.Color(0, 102, 255));

        txtRegistar.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        txtRegistar.setForeground(new java.awt.Color(255, 255, 255));
        txtRegistar.setText("Registrar");

        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAtrasMousePressed(evt);
            }
        });

        javax.swing.GroupLayout head3Layout = new javax.swing.GroupLayout(head3);
        head3.setLayout(head3Layout);
        head3Layout.setHorizontalGroup(
            head3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, head3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addComponent(txtRegistar)
                .addGap(248, 248, 248))
        );
        head3Layout.setVerticalGroup(
            head3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, head3Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(head3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRegistar)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        background3.add(head3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 90));
        background3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 190, 10));

        txtNombre.setForeground(new java.awt.Color(51, 51, 51));
        txtNombre.setToolTipText("");
        txtNombre.setBorder(null);
        background3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 190, 20));

        lblNombre.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblNombre.setText("Nombre");
        background3.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 180, 20));
        background3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 190, 10));

        txtApellidoP.setForeground(new java.awt.Color(51, 51, 51));
        txtApellidoP.setToolTipText("");
        txtApellidoP.setBorder(null);
        background3.add(txtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 190, 20));

        lblApellidoP.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblApellidoP.setText("Apellido paterno");
        background3.add(lblApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 180, 20));
        background3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 210, 10));

        txtApellidoM.setForeground(new java.awt.Color(51, 51, 51));
        txtApellidoM.setToolTipText("");
        txtApellidoM.setBorder(null);
        background3.add(txtApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 190, 20));

        lblApellidoM.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblApellidoM.setText("Apellido materno");
        background3.add(lblApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 180, 20));
        background3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 190, 10));

        lblFechaNacimiento.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblFechaNacimiento.setText("Fecha de nacimiento");
        background3.add(lblFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 200, 20));

        txtCorreo.setForeground(new java.awt.Color(51, 51, 51));
        txtCorreo.setToolTipText("");
        txtCorreo.setBorder(null);
        background3.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 210, 20));
        background3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 210, 10));

        lblCorreo.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblCorreo.setText("Correo");
        background3.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 90, 20));

        txtColonia.setForeground(new java.awt.Color(51, 51, 51));
        txtColonia.setToolTipText("");
        txtColonia.setBorder(null);
        background3.add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 100, 20));
        background3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 100, 10));

        lblContrasena.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblContrasena.setText("Contraseña");
        background3.add(lblContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 80, 20));

        txtCodigoPostal.setForeground(new java.awt.Color(51, 51, 51));
        txtCodigoPostal.setToolTipText("");
        txtCodigoPostal.setBorder(null);
        background3.add(txtCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 100, 20));
        background3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 100, 10));

        lblCodigoPostal.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblCodigoPostal.setText("Codigo postal");
        background3.add(lblCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 90, 20));

        btnRegistrar.setBackground(new java.awt.Color(0, 102, 255));
        btnRegistrar.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(null);
        btnRegistrar.setBorderPainted(false);
        background3.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 200, 30));

        lblColonia1.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblColonia1.setText("Colonia");
        background3.add(lblColonia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 50, 20));

        txtContrasena.setBorder(null);
        background3.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 210, 20));
        background3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 190, 10));

        dtFechaNacimiento.setName("dtFechaNacimiento"); // NOI18N
        background3.add(dtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 190, -1));

        txtCalle.setForeground(new java.awt.Color(51, 51, 51));
        txtCalle.setToolTipText("");
        txtCalle.setBorder(null);
        background3.add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 210, 20));
        background3.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 210, 10));

        lblCalle1.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblCalle1.setText("Calle");
        background3.add(lblCalle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 90, 20));

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

    private void btnAtrasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMousePressed
        this.setVisible(false);
        clnFrm.setVisible(true);
    }//GEN-LAST:event_btnAtrasMousePressed

    private boolean validarCampos() {
        String nombre = txtNombre.getText();
        String apellidoP = txtApellidoP.getText();
        String apellidoM = txtApellidoM.getText();
        Date fechaNacimiento = dtFechaNacimiento.getDate();
        String correo = txtCorreo.getText();
        String calle = txtCorreo.getText();
        String colonia = txtColonia.getText();
        String codigoPostal = txtCodigoPostal.getText();
        String contraseña = txtContrasena.getText();

        return !nombre.isEmpty() && !apellidoP.isEmpty()
                && !apellidoM.isEmpty() && dtFechaNacimiento == null
                && !calle.isEmpty() && !colonia.isEmpty()
                && !codigoPostal.isEmpty() && !contraseña.isEmpty()
                && (!correo.isEmpty() && validarEmail(correo));
    }

    public boolean validarEmail(String texto) {

        String patron = "[\\w-\\.]{1,20}+@[a-zA-Z0-9]{1,20}+\\.([a-zA-Z]{2,4})";

        Pattern pattern = Pattern.compile(patron);

        Matcher matcher = pattern.matcher(texto);

        return matcher.matches();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background3;
    private javax.swing.JLabel btnAtras;
    private javax.swing.JButton btnRegistrar;
    private com.toedter.calendar.JDateChooser dtFechaNacimiento;
    private javax.swing.JPanel head3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblApellidoM;
    private javax.swing.JLabel lblApellidoP;
    private javax.swing.JLabel lblCalle1;
    private javax.swing.JLabel lblCodigoPostal;
    private javax.swing.JLabel lblColonia1;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCodigoPostal;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JLabel txtRegistar;
    // End of variables declaration//GEN-END:variables
}
