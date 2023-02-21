package presentacion;

import dominio.Cliente;
import dominio.CuentaBancaria;
import dominio.Operacion;
import excepciones.PersistenciaException;
import implementaciones.OperacionesDAO;
import interfaces.IConexionBD;
import interfaces.IOperacionesDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import utils.ConfiguracionPaginado;

/**
 *
 * @author Elkur
 */
public class OperacionesForm extends javax.swing.JFrame {

    /**
     * Acceso a datos de operaciones
     */
    private IOperacionesDAO operacionesDAO;
    /**
     * Configuracion de paginado
     */
    private ConfiguracionPaginado configPaginado;
    /**
     * Logger de excepciones
     */
    private static final Logger LOG = Logger.getLogger(OperacionesForm.class.getName());
    /**
     * Cuenta bancaria a mostrar
     */
    private CuentaBancaria cuentaBancaria;
    /**
     * Conexion a BD
     */
    private final IConexionBD conBD;
    /**
     * Cliente logueado
     */
    private final Cliente cliente;

    /**
     * Inicializa la conexion conexion a BD BD, cliente logueado y la
     * cuentaBancaria a mostrar
     *
     * @param conBD conexion a BD
     * @param cliente cliente logueado
     * @param cuentaBancaria cuentaBancaria a mostrar
     */
    public OperacionesForm(IConexionBD conBD, Cliente cliente, CuentaBancaria cuentaBancaria) {
        initComponents();
        this.cuentaBancaria = cuentaBancaria;
        this.lblNoCuenta.setText(cuentaBancaria.getNoCuenta() + "");
        this.cliente = cliente;
        this.conBD = conBD;
        this.operacionesDAO = new OperacionesDAO(this.conBD);
        this.configPaginado = new ConfiguracionPaginado(this.tblOperaciones.getModel().getRowCount(), 0);
        cargarTablaOperaciones();
    }

    /**
     * Consulta las operaciones asociadas a la cuenta y las carga en la tabla
     */
    private void cargarTablaOperaciones() {
        try {
            List<Operacion> listaOperaciones = this.operacionesDAO.consultar(this.configPaginado, cuentaBancaria.getId());
            if (listaOperaciones.isEmpty()) {
                this.configPaginado.retrocederPag();
                return;
            }
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblOperaciones.getModel();
            modeloTabla.setRowCount(0);
            for (Operacion operacion : listaOperaciones) {
                Object[] fila = {operacion.getId(), operacion.getFechaHora(), operacion.getDetalles()};
                modeloTabla.addRow(fila);
            }
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblOperaciones = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        panelTablaCuentas = new javax.swing.JScrollPane();
        tblOperaciones = new javax.swing.JTable();
        lblNoCuenta = new javax.swing.JLabel();
        lblCuenta = new javax.swing.JLabel();
        btnAdelante = new javax.swing.JButton();
        btnRetroceder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        lblOperaciones.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        lblOperaciones.setForeground(new java.awt.Color(255, 255, 255));
        lblOperaciones.setText("Operaciones");

        btnAtras.setBackground(new java.awt.Color(0, 102, 255));
        btnAtras.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setText("Atras");
        btnAtras.setBorder(null);
        btnAtras.setBorderPainted(false);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168)
                .addComponent(lblOperaciones)
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOperaciones)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 90));

        tblOperaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Fecha", "Detalles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOperaciones.setColumnSelectionAllowed(true);
        panelTablaCuentas.setViewportView(tblOperaciones);
        tblOperaciones.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblOperaciones.getColumnModel().getColumnCount() > 0) {
            tblOperaciones.getColumnModel().getColumn(2).setPreferredWidth(450);
        }

        Background.add(panelTablaCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 560, 190));

        lblNoCuenta.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 16)); // NOI18N
        lblNoCuenta.setText("-");
        Background.add(lblNoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 250, -1));

        lblCuenta.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 16)); // NOI18N
        lblCuenta.setText("No. Cuenta");
        Background.add(lblCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        btnAdelante.setBackground(new java.awt.Color(0, 102, 255));
        btnAdelante.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnAdelante.setForeground(new java.awt.Color(255, 255, 255));
        btnAdelante.setText(">");
        btnAdelante.setBorder(null);
        btnAdelante.setBorderPainted(false);
        btnAdelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdelanteActionPerformed(evt);
            }
        });
        Background.add(btnAdelante, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 30, 30));

        btnRetroceder.setBackground(new java.awt.Color(0, 102, 255));
        btnRetroceder.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        btnRetroceder.setForeground(new java.awt.Color(255, 255, 255));
        btnRetroceder.setText("<");
        btnRetroceder.setBorder(null);
        btnRetroceder.setBorderPainted(false);
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });
        Background.add(btnRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 30, 30));

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
     * Dirige a la ventana anterior
     *
     * @param evt Evento que lo acciono
     */
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        CuentasForm cuentasForm = new CuentasForm(this.conBD, this.cliente);
        cuentasForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAtrasActionPerformed
    /**
     * Avanza en la pagina de operaciones
     *
     * @param evt Evento que lo acciono
     */
    private void btnAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdelanteActionPerformed
        this.configPaginado.avanzarPag();
        this.cargarTablaOperaciones();
    }//GEN-LAST:event_btnAdelanteActionPerformed
    /**
     * Retrocede en la pagina de operaciones
     *
     * @param evt Evento que lo acciono
     */
    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        this.configPaginado.retrocederPag();
        this.cargarTablaOperaciones();
    }//GEN-LAST:event_btnRetrocederActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton btnAdelante;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblNoCuenta;
    private javax.swing.JLabel lblOperaciones;
    private javax.swing.JScrollPane panelTablaCuentas;
    private javax.swing.JTable tblOperaciones;
    // End of variables declaration//GEN-END:variables
}
