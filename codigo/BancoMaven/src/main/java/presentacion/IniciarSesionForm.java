package presentacion;

import dominio.Cliente;
import implementaciones.ClientesDAO;
import implementaciones.CuentasBancariasDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasBancariasDAO;
import java.util.Arrays;
import javax.swing.JOptionPane;
import static utils.Validaciones.validarPassword;

/**
 *
 * @author Elkur
 */
public class IniciarSesionForm extends javax.swing.JFrame {
    /**
     * Valor para ingresar a la ventana de cuentas
     */
    private final static int INGRESAR = 1;
    /**
     * Ventana para ingresar a la ventana de registrar
     */
    private final static int REGISTRAR = 2;
    
    /**
     * Ventana de registro
     */
    private final RegistroClienteForm registroClienteForm;
    /**
     * Menu principal para despues de loguearte
     */
    private MenuPrincipalForm menuPrincipalForm;
    /**
     * Conexion a BD
     */
    private IConexionBD conBD;
    /**
     * Acceso a datos de clientes
     */
    private final IClientesDAO clientesDAO;
    /**
     * Acceso a datos de cuentas bancarias
     */
    private final ICuentasBancariasDAO cuentasBancariasDAO;
    /**
     * Cliente a loguear
     */
    private Cliente cliente;

    /**
     * Constructor que recibe la conexion a BD
     * @param conBD Conexion a BD
     */
    public IniciarSesionForm(IConexionBD conBD) {
        initComponents();
        this.conBD = conBD;
        this.registroClienteForm = new RegistroClienteForm(this, conBD);

        this.clientesDAO = new ClientesDAO(conBD);
        this.cuentasBancariasDAO = new CuentasBancariasDAO(conBD);
    }
    
    /**
     * Cambia entre las diferentes ventanas
     * @param type tipo de ventana
     */
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
    /**
     * Ingresa a una nueva ventana si cumple con las condiciones
     */
    private void login() {
        if (!validarCampos()) {
            JOptionPane.showMessageDialog(this, "Credenciales no validas", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!validarCredenciales()) {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        openNewWindow(this.INGRESAR);
    }
    
    /**
     * Valida si los campos no estan vacios
     * @return si los campos no estan vacios
     */
    private boolean validarCampos() {
        String correo = this.txtCorreo.getText();
        String password = new String(this.txtContraseña.getPassword());

        return correo.length() > 0 && password.length() > 0;

    }
    
    /**
     * Verifica en la BD si las credenciales son validas
     * @return 
     */
    private boolean validarCredenciales() {
        Cliente tempCliente = this.clientesDAO.consultar(txtCorreo.getText());
        this.cliente = tempCliente;

        if (tempCliente == null) {
            return false;
        }
        
        if(!validarPassword(new String(txtContraseña.getPassword()), this.cliente.getContrasenia())){
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        Background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblBienvenido = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblCorreo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblContraseña = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
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

        txtCorreo.setForeground(new java.awt.Color(51, 51, 51));
        txtCorreo.setToolTipText("");
        txtCorreo.setBorder(null);
        Background.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 190, 20));
        Background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 190, 10));

        lblCorreo.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblCorreo.setText("Correo");
        Background.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 180, 20));
        Background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 190, 10));

        lblContraseña.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lblContraseña.setText("Contraseña");
        Background.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, -1));

        txtContraseña.setBorder(null);
        Background.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 190, 20));

        btnIngresar.setBackground(new java.awt.Color(0, 102, 204));
        btnIngresar.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setBorder(null);
        btnIngresar.setBorderPainted(false);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        Background.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 70, 30));

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
    /**
     * Dijire a registro de clients
     * @param evt Evento que lo acciona
     */
    private void lblRegistrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarMousePressed
        openNewWindow(REGISTRAR);
    }//GEN-LAST:event_lblRegistrarMousePressed
    
    /**
     * Inicia el proceso de login
     * @param evt Evento que lo acciona
     */
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        this.login();
    }//GEN-LAST:event_btnIngresarActionPerformed
    
    /**
     * Dirige a la ventana de retiro sin cuenta
     * @param evt Evento que lo acciona
     */
    private void lblRetiroSinTarjetaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRetiroSinTarjetaMousePressed
        RetirarSinCuentaForm retiroSinCuentaForm = new RetirarSinCuentaForm(this.conBD);
        retiroSinCuentaForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblRetiroSinTarjetaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JLabel lblRetiroSinTarjeta;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JLabel txtIniciarSesion;
    // End of variables declaration//GEN-END:variables
}
