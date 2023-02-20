package implementaciones;

import dominio.Transferencia;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ITransferenciasDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConfiguracionPaginado;

/**
 *
 * @author Toled
 */
public class TransferenciasDAO implements ITransferenciasDAO {

    private static final Logger LOG = Logger.getLogger(CuentasBancariasDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES;
    private final String NOMBRE_TABLA = "transferencias";

    public TransferenciasDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    @Override
    public Transferencia consultarOrigen(int idCuentaOrigen) throws PersistenciaException {
        /* Consultas */
        String query
                = "SELECT id, fechaHora, monto, idCuentaOrigen, idCuentaDestino "
                + "FROM " + NOMBRE_TABLA + " WHERE idCuentaOrigen = ?;";
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement selectTransferencias = con.prepareStatement(query);) {


            /* Asignar valores a consulta*/
            Integer posicionId = 1;
            selectTransferencias.setInt(posicionId, idCuentaOrigen);
            /* Ejecutar Consulta */
            ResultSet result = selectTransferencias.executeQuery();
            if (result.next()) {
                /* Sacar valores de la consulta y crear usuario*/
                Transferencia transferencia = crearTransferencia(result);
                return transferencia;
            }
            throw new PersistenciaException("No se encontro la transferencia");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("Error en la conexion");

        }
    }

    @Override
    public Transferencia consultarDestino(int idCuentaDestino) throws PersistenciaException {
        /* Consultas */
        String query
                = "SELECT id, fechaHora, monto, idCuentaOrigen, idCuentaDestino "
                + "FROM " + NOMBRE_TABLA + " WHERE idCuentaDestino = ?;";
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion();  PreparedStatement selectTransferencias = con.prepareStatement(query);) {


            /* Asignar valores a consulta*/
            Integer posicionId = 1;
            selectTransferencias.setInt(posicionId, idCuentaDestino);
            /* Ejecutar Consulta */
            ResultSet result = selectTransferencias.executeQuery();
            if (result.next()) {
                /* Sacar valores de la consulta y crear usuario*/
                Transferencia transferencia = crearTransferencia(result);
                return transferencia;
            }
            throw new PersistenciaException("No se encontro la transferencia");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("Error en la conexion");

        }
    }

    /**
     * @param configPaginado
     * @param id
     * @return
     * @throws PersistenciaException
     */
    @Override
    public List<Transferencia> consultarOrigen(ConfiguracionPaginado configPaginado, int idCuentaOrigen) throws PersistenciaException {
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion()) {
            /* Consultas */
            String query
                    = "SELECT id, fechaHora, monto, idCuentaOrigen, idCuentaDestino "
                    + "FROM " + NOMBRE_TABLA + " WHERE idCuentaOrigen = ? "
                    + " LIMIT ? OFFSET ?;";

            /* Crear Consultas */
            PreparedStatement updateClientes = con.prepareStatement(query);
            updateClientes.setInt(1, idCuentaOrigen);
            updateClientes.setInt(2, configPaginado.getLimite());
            updateClientes.setInt(3, configPaginado.getOffset());
            List<Transferencia> listaTransferencias = new LinkedList<>();
            /* Ejecutar Consulta */
            ResultSet result = updateClientes.executeQuery();
            while (result.next()) {
                /* Sacar valores de la consulta y crear transferencia*/
                Transferencia cuentaBancaria = crearTransferencia(result);
                listaTransferencias.add(cuentaBancaria);
            }
            return listaTransferencias;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("Error al consultar cuentas");
        }
    }

    @Override
    public List<Transferencia> consultarDestino(ConfiguracionPaginado configPaginado, int idCuentaDestino) throws PersistenciaException {
        try ( Connection con = this.GENERADOR_CONEXIONES.crearConexion()) {
            /* Consultas */
            String query
                    = "SELECT id, fechaHora, monto, idCuentaOrigen, idCuentaDestino "
                    + "FROM " + NOMBRE_TABLA + " WHERE idCuentaDestino = ? "
                    + " LIMIT ? OFFSET ?;";

            /* Crear Consultas */
            PreparedStatement updateClientes = con.prepareStatement(query);
            updateClientes.setInt(1, idCuentaDestino);
            updateClientes.setInt(2, configPaginado.getLimite());
            updateClientes.setInt(3, configPaginado.getOffset());
            List<Transferencia> listaTransferencias = new LinkedList<>();
            /* Ejecutar Consulta */
            ResultSet result = updateClientes.executeQuery();
            while (result.next()) {
                /* Sacar valores de la consulta y crear transferencia*/
                Transferencia cuentaBancaria = crearTransferencia(result);
                listaTransferencias.add(cuentaBancaria);
            }
            return listaTransferencias;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("Error al consultar cuentas");
        }
    }

    @Override
    public Transferencia insertar(Transferencia transferencia) throws PersistenciaException {
        /* Consultas */
        String insertStatement = "{CALL ReflejarTransferencia(?,?,?,?)}";
        Connection con = null;
        try {
            con = this.GENERADOR_CONEXIONES.crearConexion();
            CallableStatement callableStatement = con.prepareCall(insertStatement);
            /*Iniciando Transaccion*/
            con.setAutoCommit(false);

            /* Asignar valores a Stored Procedure*/
            callableStatement.setDouble(1, transferencia.getMonto());
            callableStatement.setInt(2, transferencia.getIdCuentaOrigen());
            callableStatement.setInt(3, transferencia.getIdCuentaDestino());
            callableStatement.registerOutParameter(4, Types.INTEGER);

            /* Ejecutar las consultas */
            callableStatement.execute();
            Integer llavesGeneradas = callableStatement.getInt(4);

            con.commit();

            if (llavesGeneradas != null) {
                transferencia.setId(llavesGeneradas);
                return transferencia;
            }
            throw new PersistenciaException("Error al insertar transferencia");

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    LOG.log(Level.SEVERE, ex.getMessage());
                    throw new PersistenciaException("Error al hacer rollback");
                }
            }
            throw new PersistenciaException("Error en la conexión");
        }
    }

    private Transferencia crearTransferencia(ResultSet result) throws SQLException {
        /*Extraer del ResultSet*/
        Integer resultId = Integer.parseInt(result.getString("id"));
        String fechaHora = result.getString("fechaHora");
        Double monto = result.getDouble("monto");
        Integer idOrigen = Integer.parseInt(result.getString("idCuentaOrigen"));
        Integer idDestino = Integer.parseInt(result.getString("idCuentaDestino"));

        /* Crear Transferencia*/
        Transferencia transferencia = new Transferencia(monto, idOrigen, idDestino);
        transferencia.setFechaHora(fechaHora);
        transferencia.setId(resultId);
        return transferencia;
    }

}
