package presentacion;

import dominio.Cliente;
import dominio.CuentaBancaria;
import dominio.EstadoRetiroSinCuenta;
import dominio.Operacion;
import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;
import implementaciones.CuentasBancariasDAO;
import implementaciones.OperacionesDAO;
import implementaciones.RetirosSinCuentaDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasBancariasDAO;
import interfaces.IOperacionesDAO;
import interfaces.IRetirosSinCuentaDAO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;
import utils.ConfiguracionPaginado;
import utils.Conversiones;
import static utils.Dialogs.mostrarMensajeError;
import static utils.Dialogs.mostrarMensajeExito;
import static utils.Dialogs.pedirPassword;
import utils.Mensajes;
import static utils.Utils.generarPasswordRetiro;
import utils.Validaciones;
import static utils.Validaciones.tieneFondosSuficientes;
import static utils.Validaciones.validarPassword;

/**
 *
 * @author Elkur
 */
public class MovimientoBancarioForm extends javax.swing.JFrame {

    /**
     * Acceso a datos de retiros sin cuenta
     */
    private final IRetirosSinCuentaDAO retirosSinCuentaDAO;
    /**
     * Acceso a dato de cuentas bancarias
     */
    private final ICuentasBancariasDAO cuentasBancariasDAO;
    /**
     * Acceso a datos de operaciones
     */
    private final IOperacionesDAO operacionesDAO;
    /**
     * Ventana anterior
     */
    private CuentasForm cuentasForm;

    /**
     * Calculo del tiempo de expiracion
     */
    private final long TIEMPO_EXPIRACION = 1000 * 60 * 10;
    /**
     * Cuenta bancaria de gestion
     */
    private CuentaBancaria cuentaBancaria;
    /**
     * Cliente logueado
     */
    private Cliente cliente;
    /**
     * Tipo de movimiento a realizar
     */
    private TipoMovimiento tipoMovimiento;
    /**
     * Logger de excepciones
     */
    private static final Logger LOG = Logger.getLogger(MovimientoBancarioForm.class.getName());

    /**
     * Enumeradores de tipos de movimientos
     */
    public enum TipoMovimiento {
        RETIRO_CUENTA, DEPOSITO_CUENTA, RETIRO_SIN_CUENTA
    };

    /**
     * Constructor que inicializa la conexion a BD, la ventana anterior, cliente
     * logueado y el tipo de movimiento
     *
     * @param conBD Conexion a BD
     * @param cuentasForm Ventanaa anterior
     * @param cliente Cliente logueado
     * @param tipoMovimiento Tipo de movimiento a realizar
     */
    public MovimientoBancarioForm(IConexionBD conBD, CuentasForm cuentasForm, Cliente cliente, TipoMovimiento tipoMovimiento) {
        initComponents();
        this.retirosSinCuentaDAO = new RetirosSinCuentaDAO(conBD);
        this.cuentasBancariasDAO = new CuentasBancariasDAO(conBD);
        this.operacionesDAO = new OperacionesDAO(conBD);
        this.cuentasForm = cuentasForm;
        this.cliente = cliente;
        this.tipoMovimiento = tipoMovimiento;

        this.llenarComboBox();
        this.ajustarLabels();
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
        btnAceptar = new javax.swing.JButton();
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

        btnAceptar.setBackground(new java.awt.Color(0, 102, 204));
        btnAceptar.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorder(null);
        btnAceptar.setBorderPainted(false);
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        Background.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 70, 30));

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
    /**
     * Boton que te dirige a la ventana anterior
     *
     * @param evt Evento que lo acciona
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.regresarACuentas();
    }//GEN-LAST:event_btnRegresarActionPerformed
    /**
     * Acepta la accion segun lo que se desee hacer
     *
     * @param evt Evento que lo acciona
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        this.aceptar();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cBoxNoCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxNoCuentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBoxNoCuentasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton btnAceptar;
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

    /**
     * Genera y consulta los diferentes elementos necesarios para poder realizar
     * el retiro sin cuenta
     */
    private void realizarRetiroSinCuenta() {

        try {
            consultarCuenta();
            if (!this.validarRetiro()) {
                return;
            }

            String passwordRetiro = generarPasswordRetiro();
            RetiroSinCuenta retiroSinCuenta = this.crearRetiro(obtenerMonto(), passwordRetiro);
            /*Registrar operacion*/
            Operacion operacion = new Operacion(null, Mensajes.generarRegistroRetiroSinCuenta(retiroSinCuenta.getMonto()), retiroSinCuenta.getIdCuentaBancaria());
            this.operacionesDAO.insertar(operacion);

            this.mostrarFolioYPassword(passwordRetiro, retiroSinCuenta);
            this.regresarACuentas();
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            mostrarMensajeError(this, "Error al crear retiro sin cuenta");
        }
    }

    /**
     * Extrae de la combobox y consulta la BD
     *
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    private void consultarCuenta() throws PersistenciaException {
        this.cuentaBancaria = this.cuentasBancariasDAO.consultar(String.valueOf(cBoxNoCuentas.getSelectedItem()));
    }

    /**
     * Verifica si es un monto no nulo y positivo
     *
     * @return Si es valido
     */
    private boolean isValidMonto() {
        Double monto = obtenerMonto();
        return !Validaciones.isNull(monto) && Validaciones.isPositivo(monto);
    }

    /**
     * Extrae la informacion del txt y la transforma en un monto
     *
     * @return monto
     */
    private Double obtenerMonto() {
        return Conversiones.crearMontoDeTexto(this.txtMonto.getText());
    }

    /**
     * Genera y consulta la informacion necesaria para crear un retiro sin
     * cuenta
     *
     * @param monto Monto a retirar
     * @param password pass del retiro
     * @return El retiro sin cuenta
     * @throws PersistenciaException
     */
    private RetiroSinCuenta crearRetiro(Double monto, String password) throws PersistenciaException {

        String fechaInicio = new Timestamp(System.currentTimeMillis()).toString();
        String fechaFin = new Timestamp(System.currentTimeMillis() + TIEMPO_EXPIRACION).toString();
        String passwordEncriptada = BCrypt.hashpw(password, BCrypt.gensalt());

        RetiroSinCuenta retiroSinCuenta = new RetiroSinCuenta(
                fechaInicio,
                fechaFin,
                EstadoRetiroSinCuenta.PENDIENTE,
                monto,
                passwordEncriptada,
                this.cuentaBancaria.getId());
        retiroSinCuenta = retirosSinCuentaDAO.insertar(retiroSinCuenta, this.cuentaBancaria);
        retiroSinCuenta = retirosSinCuentaDAO.consultar(retiroSinCuenta.getId());
        return retiroSinCuenta;
    }

    /**
     * Consulta las cuentas del cliente y llena el combobox con ellas
     */
    private void llenarComboBox() {
        try {
            List<CuentaBancaria> cuentasBancarias = cuentasBancariasDAO.consultar(new ConfiguracionPaginado(50, 0), this.cliente.getId());
            List<String> noCuentasBancarias = extraerNoCuenta(cuentasBancarias);
            this.cBoxNoCuentas.setModel(new DefaultComboBoxModel<>(noCuentasBancarias.toArray(new String[0])));
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }

    }

    /**
     * Extrae los numeros de cuenta de una lista de cuentas
     *
     * @param cuentasBancarias Lista de cuentas
     * @return Lista de numeros de cuenta
     */
    private List<String> extraerNoCuenta(List<CuentaBancaria> cuentasBancarias) {
        List<String> noCuentasBancarias = new ArrayList<>();
        cuentasBancarias.forEach((cuenta) -> {
            noCuentasBancarias.add(cuenta.getNoCuenta());
        });
        return noCuentasBancarias;
    }

    /**
     * Muestra la informacion al cliente con respecto a su retiro sin cuenta
     *
     * @param passwordRetiro contrasenia del retiro
     * @param retiroSinCuenta Retiro realizado
     */
    private void mostrarFolioYPassword(String passwordRetiro, RetiroSinCuenta retiroSinCuenta) {
        String msg
                = "Retiro creado"
                + "\nFolio: " + retiroSinCuenta.getFolio()
                + "\nPassword: " + passwordRetiro
                + "\n Caduca a las: " + retiroSinCuenta.getFechaFin();

        JOptionPane.showMessageDialog(this, msg);
    }

    /**
     * Regresar a la ventana anterior
     */
    private void regresarACuentas() {
        this.cuentasForm.llenarTablaCuentas();
        this.cuentasForm.setVisible(true);
        this.setVisible(false);
    }

    /**
     * Ajusta la vista del frame en base al tipo de movimiento
     */
    private void ajustarLabels() {

        switch (this.tipoMovimiento) {
            case DEPOSITO_CUENTA:
                this.lblTitulo.setText("Deposito a Cuenta");
                break;
            case RETIRO_CUENTA:
                this.lblTitulo.setText("Retiro de Cuenta");
                break;
            case RETIRO_SIN_CUENTA:
                this.lblTitulo.setText("Retiro sin Cuenta");
                break;
            default:
                break;

        }
    }

    /**
     * Realiza distintas accones en base a el tipo de movimiento
     */
    private void aceptar() {
        switch (this.tipoMovimiento) {
            case DEPOSITO_CUENTA:
                realizarDeposito();
                break;
            case RETIRO_CUENTA:
                this.realizarRetiro();
                break;
            case RETIRO_SIN_CUENTA:
                this.realizarRetiroSinCuenta();
                break;
            default:
                break;
        }

    }

    /**
     * Consulta y realiza el deposito indicado
     */
    private void realizarDeposito() {
        try {
            consultarCuenta();

            if (!this.validarRetiro()) {
                return;
            }

            this.cuentaBancaria.depositar(this.obtenerMonto());
            this.cuentasBancariasDAO.actualizar(this.cuentaBancaria);

            /*Registrar operacion*/
            Operacion operacion = new Operacion(null, Mensajes.generarRegistroDeposito(this.obtenerMonto()), this.cuentaBancaria.getId());
            this.operacionesDAO.insertar(operacion);
            mostrarMensajeExito(this, "Deposito realizado");
            this.regresarACuentas();
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            mostrarMensajeError(this, "Error al depositar");
        }
    }

    /**
     * Consulta y realiza el deposito indicado
     */
    private void realizarRetiro() {
        try {
            consultarCuenta();

            if (!this.validarRetiro()) {
                return;
            }

            this.cuentaBancaria.retirar(this.obtenerMonto());
            this.cuentasBancariasDAO.actualizar(this.cuentaBancaria);

            /*Registrar operacion*/
            Operacion operacion = new Operacion(null, Mensajes.generarRegistroRetiro(this.obtenerMonto()), this.cuentaBancaria.getId());
            this.operacionesDAO.insertar(operacion);
            mostrarMensajeExito(this, "Deposito realizado");
            this.regresarACuentas();
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            mostrarMensajeError(this, "Error al retirar");
        }
    }

    /**
     * Realiza distintas validaciones para antes de generar un retiro
     *
     * @return Si cumple los requitos
     * @throws PersistenciaException Si ocurre una excepcion al consultar la
     * base
     */
    private boolean validarRetiro() throws PersistenciaException {
        if (this.cuentaBancaria == null) {
            mostrarMensajeError(this, "Cuenta no existente");
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

        if ((this.tipoMovimiento != TipoMovimiento.DEPOSITO_CUENTA) && !tieneFondosSuficientes(this.cuentaBancaria, obtenerMonto())) {
            mostrarMensajeError(this, "Fondos insuficientes");
            return false;
        }
        return true;
    }
}
