package presentacion;

import dominio.Cliente;
import dominio.CuentaBancaria;
import dominio.Operacion;
import dominio.Transferencia;
import excepciones.PersistenciaException;
import implementaciones.CuentasBancariasDAO;
import implementaciones.OperacionesDAO;
import implementaciones.TransferenciasDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasBancariasDAO;
import interfaces.IOperacionesDAO;
import interfaces.ITransferenciasDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import utils.ConfiguracionPaginado;
import utils.Conversiones;
import static utils.Dialogs.pedirPassword;
import utils.Mensajes;
import utils.Validaciones;
import static utils.Dialogs.mostrarMensajeError;
import static utils.Dialogs.mostrarMensajeExito;
import static utils.Validaciones.tieneFondosSuficientes;
import static utils.Validaciones.validarPassword;

/**
 *
 * @author Elkur
 */
public class CrearTransferenciaForm extends javax.swing.JFrame {

    /**
     * Accedo a datos de transferencias
     */
    private final ITransferenciasDAO transferenciasDAO;
    /**
     * Accedo a datos de cuentas bancarias
     */
    private final ICuentasBancariasDAO cuentasBancariasDAO;
    /**
     * Accedo a datos de operaciones
     */
    private final IOperacionesDAO operacionesDAO;

    /**
     * Calculo del tiempo de expiracion
     */
    private final long TIEMPO_EXPIRACION = 1000 * 60 * 10;
    /**
     * Cuenta origen de transacciones
     */
    private CuentaBancaria cuentaBancaria;
    /**
     * Cliente logeado
     */
    private Cliente cliente;
    /**
     * Frame anterior
     */
    private final MenuPrincipalForm menuPrincipalForm;

    /**
     * Logger de excepciones
     */
    private static final Logger LOG = Logger.getLogger(CrearTransferenciaForm.class.getName());
    /**
     * Cuenta destino de transaccion
     */
    private CuentaBancaria cuentaDestino;

    /**
     * Constructor que recibe una conexion, el frame anterior y el cliente
     * logueado
     *
     * @param conBD Conexion a BD
     * @param menuPrincipalForm Frame anterior
     * @param cliente Cliente logeado
     */
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
    /**
     * Boton que regresa a la pagina anterior
     * @param evt evento que lo acciona
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.regresarAMenu();
    }//GEN-LAST:event_btnRegresarActionPerformed
    /**
     * Boton para realizar la transferencia
     * @param evt evento que lo acciona
     */
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

    /**
     * Extrae el numero de cuenta y consulta la BD para obtener su informacion
     *
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    private void consultarCuenta() throws PersistenciaException {
        this.cuentaBancaria = this.cuentasBancariasDAO.consultar(String.valueOf(cBoxCuentasOrigen.getSelectedItem()));

    }

    /**
     * Extrae el numero de cuenta y consulta la BD para obtener su informacion
     */
    private void obtenerCuentaDestino() {
        try {
            this.cuentaDestino = this.cuentasBancariasDAO.consultar(this.txtCuentaDestino.getText());
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            mostrarMensajeError(this, "La cuenta destino no existe.");
        }
    }

    /**
     * Consulta las cuentas asociadas al cliente y las trae para llegar el
     * combobox
     */
    private void llenarComboBox() {
        try {
            List<CuentaBancaria> cuentasBancarias = cuentasBancariasDAO.consultar(new ConfiguracionPaginado(50, 0), this.cliente.getId());
            List<String> noCuentasBancarias = extraerNoCuenta(cuentasBancarias);
            this.cBoxCuentasOrigen.setModel(new DefaultComboBoxModel<>(noCuentasBancarias.toArray(new String[0])));
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }

    }

    /**
     * Extrae de la lista solamente los numeros de cuenta de las cuentas
     *
     * @param cuentasBancarias lista de cuentas
     * @return lista de numeros de cuenta
     */
    private List<String> extraerNoCuenta(List<CuentaBancaria> cuentasBancarias) {
        List<String> noCuentasBancarias = new ArrayList<>();
        cuentasBancarias.forEach((cuenta) -> {
            noCuentasBancarias.add(cuenta.getNoCuenta());
        });
        return noCuentasBancarias;
    }

    /**
     * Regresa al frame anterior
     */
    private void regresarAMenu() {
        this.menuPrincipalForm.setVisible(true);
        this.setVisible(false);
    }

    /**
     * Inserta en la BD la transferencia y la operacion
     */
    private void crearTransferencia() {
        try {
            /*Validaciones*/
            if (!this.validarTransferencia()) {
                return;
            }

            /*Crear transferencia*/
            Transferencia transferencia = new Transferencia(obtenerMonto(), this.cuentaBancaria.getId(), this.cuentaDestino.getId());
            Transferencia transferenciaExitosa = this.transferenciasDAO.insertar(transferencia);

            /* Registrar una operacion*/
            int idCuentaOrigen = transferenciaExitosa.getIdCuentaOrigen();
            String mensajeOperacion = Mensajes.generarRegistroTransferencia(transferenciaExitosa.getMonto(), idCuentaOrigen + "", transferenciaExitosa.getIdCuentaDestino() + "");
            Operacion operacion = new Operacion(null, mensajeOperacion, idCuentaOrigen);
            operacionesDAO.insertar(operacion);
            mostrarMensajeExito(this, "Transferencia satisfactoria");
            this.regresarAMenu();
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }

    /**
     * Valida si el monto existe y es positivo
     *
     * @return Si el monto existe y es positivo
     */
    private boolean isValidMonto() {
        Double monto = obtenerMonto();
        return !Validaciones.isNull(monto) && Validaciones.isPositivo(monto);
    }

    /**
     * Extrae y transforma el monto en un valor numerico
     *
     * @return Monto
     */
    private Double obtenerMonto() {
        return Conversiones.crearMontoDeTexto(this.txtMonto.getText());
    }

    /**
     * Realiza las distintas validaciones de una transferencia
     *
     * @return Si cumplio con todas
     * @throws PersistenciaException Si ocurrio una excepcion al consultar la
     * base
     */
    private boolean validarTransferencia() throws PersistenciaException {
        this.consultarCuenta();

        if (this.cuentaBancaria == null) {
            mostrarMensajeError(this, "Cuenta Origen inexistente");
            return false;
        }
        this.obtenerCuentaDestino();

        if (this.cuentaDestino == null) {
            return false;
        }

        if (this.cuentaBancaria.getNoCuenta().equals(this.cuentaDestino.getNoCuenta())) {
            mostrarMensajeError(this, "No puedes depositar a la cuenta de origen");
            return false;
        }

        if (!isValidMonto()) {
            mostrarMensajeError(this, "Monto invalido");
            return false;
        }

        String password = pedirPassword();
        if (password.isEmpty()) {
            return false;
        }
        if (!validarPassword(password, this.cliente)) {
            mostrarMensajeError(this, "Contraseña invalida");
            return false;
        }
        if (!Validaciones.validarCuentaActiva(cuentasBancariasDAO, cuentaBancaria)) {
            mostrarMensajeError(this, "La cuenta se encuentra inactiva.");
            return false;
        }
        if (!tieneFondosSuficientes(cuentaBancaria, obtenerMonto())) {
            mostrarMensajeError(this, "Fondos insuficientes");
            return false;
        }
        return true;
    }

}
