package presentacion;

import dominio.Cliente;
import dominio.CuentaBancaria;
import excepciones.PersistenciaException;
import implementaciones.CuentasBancariasDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasBancariasDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import presentacion.MovimientoBancarioForm.TipoMovimiento;
import utils.ConfiguracionPaginado;
import static utils.Dialogs.mostrarMensajeError;
import static utils.Dialogs.pedirInputUsuario;
import static utils.Dialogs.pedirPassword;
import static utils.FormUtils.cargarMensajeBienvenida;
import static utils.Validaciones.validarCuentaActiva;
import static utils.Validaciones.validarPassword;

/**
 *
 * @author Elkur
 */
public class CuentasForm extends javax.swing.JFrame {

    /**
     * Creates new form EditarClienteForm
     */
    private static final Logger LOG = Logger.getLogger(CuentasForm.class.getName());
    private final ICuentasBancariasDAO cuentasBancariasDAO;
    private ConfiguracionPaginado configPaginado;
    private Cliente cliente;
    private final IConexionBD conBD;

    public CuentasForm(IConexionBD conBD, Cliente cliente) {
        this.cuentasBancariasDAO = new CuentasBancariasDAO(conBD);
        this.conBD = conBD;
        this.cliente = cliente;
        initComponents();
        this.configPaginado = new ConfiguracionPaginado(this.tablaCuentas.getModel().getRowCount(), 0);
        this.llenarTablaCuentas();
        cargarMensajeBienvenida(txtBienvenida, this.cliente);
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
        txtBienvenida = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnEditarCuenta = new javax.swing.JButton();
        panelTablaCuentas = new javax.swing.JScrollPane();
        tablaCuentas = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnOperaciones = new javax.swing.JButton();
        btnAvanzarPagina = new javax.swing.JButton();
        btnRetiroSinTarjeta = new javax.swing.JButton();
        btnRetrocederPagina = new javax.swing.JButton();
        brnDesactivarCuenta1 = new javax.swing.JButton();
        btnDepositar = new javax.swing.JButton();
        btnRetirar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background3.setBackground(new java.awt.Color(255, 255, 255));
        background3.setMaximumSize(new java.awt.Dimension(600, 400));
        background3.setMinimumSize(new java.awt.Dimension(600, 400));
        background3.setPreferredSize(new java.awt.Dimension(600, 400));
        background3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head3.setBackground(new java.awt.Color(0, 102, 255));

        txtBienvenida.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        txtBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        txtBienvenida.setText("Bienvenido");

        btnCerrarSesion.setBackground(new java.awt.Color(0, 102, 255));
        btnCerrarSesion.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnEditarCuenta.setBackground(new java.awt.Color(0, 102, 255));
        btnEditarCuenta.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnEditarCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarCuenta.setText("Editar Cuenta");
        btnEditarCuenta.setBorder(null);
        btnEditarCuenta.setBorderPainted(false);
        btnEditarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout head3Layout = new javax.swing.GroupLayout(head3);
        head3.setLayout(head3Layout);
        head3Layout.setHorizontalGroup(
            head3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(head3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtBienvenida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(btnEditarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        head3Layout.setVerticalGroup(
            head3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(head3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(head3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBienvenida)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        background3.add(head3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 90));

        tablaCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No. Cuenta", "Fecha Apertura", "Saldo MXN", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCuentas.setColumnSelectionAllowed(true);
        panelTablaCuentas.setViewportView(tablaCuentas);
        tablaCuentas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        background3.add(panelTablaCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 560, 190));

        btnRegresar.setBackground(new java.awt.Color(0, 102, 255));
        btnRegresar.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setBorder(null);
        btnRegresar.setBorderPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        background3.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 20));

        btnOperaciones.setBackground(new java.awt.Color(0, 102, 255));
        btnOperaciones.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnOperaciones.setForeground(new java.awt.Color(255, 255, 255));
        btnOperaciones.setText("Operaciones");
        btnOperaciones.setBorder(null);
        btnOperaciones.setBorderPainted(false);
        btnOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperacionesActionPerformed(evt);
            }
        });
        background3.add(btnOperaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 120, 30));

        btnAvanzarPagina.setBackground(new java.awt.Color(0, 102, 255));
        btnAvanzarPagina.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnAvanzarPagina.setForeground(new java.awt.Color(255, 255, 255));
        btnAvanzarPagina.setText(">");
        btnAvanzarPagina.setBorder(null);
        btnAvanzarPagina.setBorderPainted(false);
        btnAvanzarPagina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarPaginaActionPerformed(evt);
            }
        });
        background3.add(btnAvanzarPagina, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 30, 30));

        btnRetiroSinTarjeta.setBackground(new java.awt.Color(0, 102, 255));
        btnRetiroSinTarjeta.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnRetiroSinTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        btnRetiroSinTarjeta.setText("Retiro Sin Tarjeta");
        btnRetiroSinTarjeta.setBorder(null);
        btnRetiroSinTarjeta.setBorderPainted(false);
        btnRetiroSinTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroSinTarjetaActionPerformed(evt);
            }
        });
        background3.add(btnRetiroSinTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 120, 30));

        btnRetrocederPagina.setBackground(new java.awt.Color(0, 102, 255));
        btnRetrocederPagina.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnRetrocederPagina.setForeground(new java.awt.Color(255, 255, 255));
        btnRetrocederPagina.setText("<");
        btnRetrocederPagina.setBorder(null);
        btnRetrocederPagina.setBorderPainted(false);
        btnRetrocederPagina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederPaginaActionPerformed(evt);
            }
        });
        background3.add(btnRetrocederPagina, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 30, 30));

        brnDesactivarCuenta1.setBackground(new java.awt.Color(0, 102, 255));
        brnDesactivarCuenta1.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        brnDesactivarCuenta1.setForeground(new java.awt.Color(255, 255, 255));
        brnDesactivarCuenta1.setText("Desactivar Cuenta");
        brnDesactivarCuenta1.setBorder(null);
        brnDesactivarCuenta1.setBorderPainted(false);
        brnDesactivarCuenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnDesactivarCuenta1ActionPerformed(evt);
            }
        });
        background3.add(brnDesactivarCuenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 120, 30));

        btnDepositar.setBackground(new java.awt.Color(0, 102, 255));
        btnDepositar.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnDepositar.setForeground(new java.awt.Color(255, 255, 255));
        btnDepositar.setText("Depositar");
        btnDepositar.setBorder(null);
        btnDepositar.setBorderPainted(false);
        btnDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarActionPerformed(evt);
            }
        });
        background3.add(btnDepositar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 120, 30));

        btnRetirar.setBackground(new java.awt.Color(0, 102, 255));
        btnRetirar.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnRetirar.setForeground(new java.awt.Color(255, 255, 255));
        btnRetirar.setText("Retirar");
        btnRetirar.setBorder(null);
        btnRetirar.setBorderPainted(false);
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });
        background3.add(btnRetirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 120, 30));

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

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MenuPrincipalForm menuPrincipal = new MenuPrincipalForm(this.conBD, cliente);
        menuPrincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperacionesActionPerformed
        CuentasOperacionForm cuentasOperacionForm = new CuentasOperacionForm(this.conBD, this, this.cliente);
        cuentasOperacionForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnOperacionesActionPerformed

    private void btnAvanzarPaginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarPaginaActionPerformed
        configPaginado.avanzarPag();
        this.llenarTablaCuentas();
    }//GEN-LAST:event_btnAvanzarPaginaActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.cerrarSesion();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnEditarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCuentaActionPerformed
        this.editarCuenta();
    }//GEN-LAST:event_btnEditarCuentaActionPerformed

    private void btnRetiroSinTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroSinTarjetaActionPerformed
        MovimientoBancarioForm crearRetiroSinCuentaForm = new MovimientoBancarioForm(this.conBD, this, this.cliente, TipoMovimiento.RETIRO_SIN_CUENTA);
        crearRetiroSinCuentaForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRetiroSinTarjetaActionPerformed

    private void btnRetrocederPaginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederPaginaActionPerformed
        configPaginado.retrocederPag();
        this.llenarTablaCuentas();
    }//GEN-LAST:event_btnRetrocederPaginaActionPerformed

    private void brnDesactivarCuenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnDesactivarCuenta1ActionPerformed
        this.desactivar();
    }//GEN-LAST:event_brnDesactivarCuenta1ActionPerformed

    private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarActionPerformed
        MovimientoBancarioForm crearRetiroSinCuentaForm = new MovimientoBancarioForm(this.conBD, this, this.cliente, TipoMovimiento.DEPOSITO_CUENTA);
        crearRetiroSinCuentaForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDepositarActionPerformed

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed
        MovimientoBancarioForm crearRetiroSinCuentaForm = new MovimientoBancarioForm(this.conBD, this, this.cliente, TipoMovimiento.RETIRO_CUENTA);
        crearRetiroSinCuentaForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRetirarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background3;
    private javax.swing.JButton brnDesactivarCuenta1;
    private javax.swing.JButton btnAvanzarPagina;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnDepositar;
    private javax.swing.JButton btnEditarCuenta;
    private javax.swing.JButton btnOperaciones;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JButton btnRetiroSinTarjeta;
    private javax.swing.JButton btnRetrocederPagina;
    private javax.swing.JPanel head3;
    private javax.swing.JScrollPane panelTablaCuentas;
    private javax.swing.JTable tablaCuentas;
    private javax.swing.JLabel txtBienvenida;
    // End of variables declaration//GEN-END:variables

    public void llenarTablaCuentas() {
        try {

            List<CuentaBancaria> listaCuentas = this.cuentasBancariasDAO.consultar(this.configPaginado, this.cliente.getId());
            if (listaCuentas.isEmpty()) {
                this.configPaginado.retrocederPag();
                return;
            }
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaCuentas.getModel();
            modeloTabla.setRowCount(0);

            for (CuentaBancaria cuenta : listaCuentas) {
                Object[] fila = {
                    cuenta.getNoCuenta(),
                    cuenta.getFechaApertura(),
                    cuenta.getSaldoMXN(),
                    cuenta.getEstadoCuenta()
                };
                modeloTabla.addRow(fila);

            }

        } catch (PersistenciaException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    private void desactivar() {

        String input = pedirInputUsuario(this, "Desactivar Cuenta", "Ingresa el numero de cuenta");
        try {
            CuentaBancaria cuentaBancaria = this.cuentasBancariasDAO.consultar(input);

            if (!this.validarDesactivo(cuentaBancaria)) {
                return;
            }

            cuentaBancaria.desactivarCuenta();
            this.cuentasBancariasDAO.actualizar(cuentaBancaria);
            this.llenarTablaCuentas();
        } catch (PersistenciaException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            mostrarMensajeError(this, "Ingresa un Numero de Cuenta valido");
        }
    }

    private void cerrarSesion() {
        IniciarSesionForm clienteForm = new IniciarSesionForm(conBD);
        clienteForm.setVisible(true);
        this.setVisible(false);
    }

    private void editarCuenta() {
        EditarClienteForm editarClienteForm = new EditarClienteForm(this, this.conBD, this.cliente);
        editarClienteForm.setVisible(true);
        this.setVisible(false);
    }

    private boolean validarDesactivo(CuentaBancaria cuentaBancaria) throws PersistenciaException {
        String password = pedirPassword();
        if(password.isEmpty())return false;
        if (!validarPassword(password, this.cliente)) {
            mostrarMensajeError(this, "Contraseña invalida");
            return false;
        }

        if (!validarCuentaActiva(cuentasBancariasDAO, cuentaBancaria)) {
            mostrarMensajeError(this, "La cuenta ya se encuentra inactiva.");
            return false;
        }
        return true;
    }
}
