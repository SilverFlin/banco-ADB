package presentacion;

import dominio.Cliente;
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
public class ActividadesForm extends javax.swing.JFrame {
    /**
     * Conexion a la base
     */
    private final IConexionBD conBD;
    /**
     * Cliente logeado
     */
    private Cliente cliente;
    /**
     * Conexion con el frame anterior
     */
    private MenuPrincipalForm menuPrincipalForm;
    /**
     * Configuracion de paginado
     */
    private ConfiguracionPaginado configPaginado;
    /**
     * Acceso a datos
     */
    private IOperacionesDAO operacionesDAO;
    /**
     * Logger de excepciones
     */
    private static final Logger LOG = Logger.getLogger(ActividadesForm.class.getName());
    
    /**
     * Constructor que recibe la conexion, el cliente logeado y el frame anterior
     * @param conBD Conexion a BD
     * @param cliente Cliente que esta logueado
     * @param menuPrincipalForm Frame que llamoa este
     */
    public ActividadesForm(IConexionBD conBD, Cliente cliente, MenuPrincipalForm menuPrincipalForm) {
        initComponents();
        this.conBD = conBD;
        this.cliente = cliente;
        this.menuPrincipalForm = menuPrincipalForm;
        this.configPaginado = new ConfiguracionPaginado(this.tbActividades.getModel().getRowCount(), 0);
        operacionesDAO = new OperacionesDAO(conBD);
        cargarTablaOperaciones();
    }
    
    /**
     * Carga en la tabla las operaciones del cliente y sus cuentas
     */
    private void cargarTablaOperaciones() {
        try {
            /*
            Consulta las operaciones del cliente
            */
            List<Operacion> listaOperaciones = this.operacionesDAO.consultar(this.configPaginado, cliente.getId() + "");
            if (listaOperaciones.isEmpty()) {
                this.configPaginado.retrocederPag();
                return;
            }
            /*
            Las ingresa en un modelo y luego a la tabla
            */
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tbActividades.getModel();
            modeloTabla.setRowCount(0);
            for (Operacion operacion : listaOperaciones) {
                Object[] fila = {operacion.getNoCuenta(), operacion.getFechaHora(), operacion.getDetalles()};
                modeloTabla.addRow(fila);
            }
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }
    
    /**
     * Regresa al frame anterior, haciendose invisible y visible al otro
     */
    public void regresarAMenu() {
        this.setVisible(false);
        menuPrincipalForm.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbActividades = new javax.swing.JTable();
        btnRetroceder = new javax.swing.JButton();
        btnAdelante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        lblTitulo.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Actividad del cliente");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(189, 189, 189))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        Background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 90));

        tbActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No. Cuenta", "Fecha", "Detalles"
            }
        ));
        jScrollPane1.setViewportView(tbActividades);

        Background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 520, 230));

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
        Background.add(btnRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 30, 30));

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
        Background.add(btnAdelante, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 30, 30));

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
     * Boton que acciona el ir a al menu anterior
     * @param evt evento que lo acciona
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.regresarAMenu();
    }//GEN-LAST:event_btnRegresarActionPerformed
    /**
     * Boton que retrocede en la pagina de la tabla
     * @param evt Evento que lo acciona
     */
    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        this.configPaginado.retrocederPag();
        this.cargarTablaOperaciones();
    }//GEN-LAST:event_btnRetrocederActionPerformed
    
    /**
     * Boton que adelanta en la pagina de la tabla
     * @param evt Evento que lo acciona
     */
    private void btnAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdelanteActionPerformed
        this.configPaginado.avanzarPag();
        this.cargarTablaOperaciones();
    }//GEN-LAST:event_btnAdelanteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton btnAdelante;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tbActividades;
    // End of variables declaration//GEN-END:variables
}
