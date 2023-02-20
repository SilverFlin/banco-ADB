/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Operacion;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IOperacionesDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConfiguracionPaginado;

/**
 *
 * @author Elkur
 */
public class OperacionesDAO implements IOperacionesDAO {

    private final IConexionBD GENERADOR_CONEXIONES;
    private static final Logger LOG = Logger.getLogger(DomiciliosDAO.class.getName());

    public OperacionesDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    @Override
    public Operacion consultar(int id) {
        String SQLQuery = "SELECT fechaHora, detalles, idCuentaBancaria FROM operaciones WHERE id = ?";

        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(SQLQuery);) {

            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            Operacion operacion = null;
            if (resultado.next()) {
                Date fechaHora = resultado.getDate("fechaHora");
                String detalles = resultado.getString("detalles");
                int idCuentaBancaria = resultado.getInt("idCuentaBancaria");
                operacion = new Operacion(id, fechaHora, detalles, idCuentaBancaria);
            }

            return operacion;

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }

    @Override
    public Operacion insertar(Operacion operacion) throws PersistenciaException {
        String SQLQuery = "INSERT INTO operaciones(detalles, idCuentaBancaria) VALUES (?,?)";

        try (Connection conexion = GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(SQLQuery, Statement.RETURN_GENERATED_KEYS);) {

            comando.setString(1, operacion.getDetalles());
            comando.setInt(2, operacion.getIdCuentaBancaria());

            comando.executeUpdate();

            ResultSet llavesGeneradas = comando.getGeneratedKeys();

            if (llavesGeneradas.next()) {
                Integer llavePrimaria = llavesGeneradas.getInt(1);
                operacion.setId(llavePrimaria);
                return operacion;
            }
            throw new PersistenciaException("operacion registrado pero ID no generado");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible registrar la operacion");
        }
    }

    @Override
    public List<Operacion> consultar(ConfiguracionPaginado configPaginado, int idCuentaBancaria) throws PersistenciaException {
        String codigoSQL = "SELECT id, fechaHora, detalles, idCuentaBancaria "
                + "FROM operaciones WHERE idCuentaBancaria = ? LIMIT ? OFFSET ?";
        List<Operacion> listaOperaciones = new LinkedList<>();
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {

            comando.setInt(1, idCuentaBancaria);
            comando.setInt(2, configPaginado.getLimite());
            comando.setInt(3, configPaginado.getOffset());
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                Date fechaHora = resultado.getDate("fechaHora");
                String detalles = resultado.getString("detalles");
                Operacion operacion = new Operacion(id, fechaHora, detalles, idCuentaBancaria);
                listaOperaciones.add(operacion);
            }

            return listaOperaciones;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible consultar la lista de clientes");
        }
    }

    @Override
    public List<Operacion> consultar(ConfiguracionPaginado configPaginado, String idCliente) throws PersistenciaException {
        String codigoSQL = "SELECT cu.noCuenta, op.id, op.fechaHora, op.detalles, op.idCuentaBancaria "
                + "FROM operaciones op INNER JOIN cuentasBancarias cu INNER JOIN clientes cl "
                + "ON op.idCuentaBancaria = cu.id AND cu.idCliente = cl.id WHERE cl.id = ? LIMIT ? OFFSET ?";
        List<Operacion> listaOperaciones = new LinkedList<>();
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {

            comando.setInt(1, Integer.parseInt(idCliente));
            comando.setInt(2, configPaginado.getLimite());
            comando.setInt(3, configPaginado.getOffset());
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                String noCuenta = resultado.getString("noCuenta");
                Integer id = resultado.getInt("id");
                Date fechaHora = resultado.getDate("fechaHora");
                String detalles = resultado.getString("detalles");
                int idCuentaBancaria = resultado.getInt("idCuentaBancaria");
                Operacion operacion = new Operacion(id, fechaHora, detalles, idCuentaBancaria, noCuenta);
                listaOperaciones.add(operacion);
            }

            return listaOperaciones;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible consultar la lista de clientes");
        }
    }

}
