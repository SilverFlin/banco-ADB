package implementaciones;

import dominio.Domicilio;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IDomiciliosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elkur
 */
public class DomiciliosDAO implements IDomiciliosDAO {

    private final IConexionBD GENERADOR_CONEXIONES;
    private static final Logger LOG = Logger.getLogger(DomiciliosDAO.class.getName());

    public DomiciliosDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    @Override
    public Domicilio consultar(int id) {
        String SQLQuery = "SELECT calle, numero, colonia,codigoPostal FROM direcciones WHERE id = ?";

        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(SQLQuery);) {

            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            Domicilio domicilio = null;
            if (resultado.next()) {
                String calle = resultado.getString("calle");
                String numero = resultado.getString("numero");
                String colonia = resultado.getString("colonia");
                String codigoPostal = resultado.getString("codigoPostal");
                domicilio = new Domicilio(id, calle, numero, colonia, codigoPostal);
            }

            return domicilio;

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }

    @Override
    public Domicilio insertar(Domicilio domicilio) throws PersistenciaException {
        String SQLQuery = "INSERT INTO domicilios(calle,numero, colonia, codigoPostal) VALUES (?,?,?,?)";

        try (Connection conexion = GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(SQLQuery, Statement.RETURN_GENERATED_KEYS);) {

            comando.setString(1, domicilio.getCalle());
            comando.setString(2, domicilio.getNumero());
            comando.setString(3, domicilio.getColonia());
            comando.setString(4, domicilio.getCodigoPostal());

            comando.executeUpdate();

            ResultSet llavesGeneradas = comando.getGeneratedKeys();

            if (llavesGeneradas.next()) {
                Integer llavePrimaria = llavesGeneradas.getInt(1);
                domicilio.setId(llavePrimaria);
                return domicilio;
            }
            throw new PersistenciaException("Direccion registrado pero ID no generado");

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible registrar al cliente");

        }
    }

    @Override
    public Domicilio editar(Domicilio domicilio) throws PersistenciaException {
        String SQLQuery = "UPDATE domicilios SET calle = ?,numero = ?, colonia = ?,codigoPostal = ? WHERE id = ?";

        try (Connection conexion = GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(SQLQuery);) {

            comando.setString(1, domicilio.getCalle());
            comando.setString(2, domicilio.getNumero());
            comando.setString(3, domicilio.getColonia());
            comando.setString(4, domicilio.getCodigoPostal());
            comando.setInt(5, domicilio.getId());

            int numeroClientesEditados = comando.executeUpdate();
            return numeroClientesEditados > 0 ? domicilio : null;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible editar al cliente");

        }
    }

}
