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

    /**
     * Generador de conexiones
     */
    private final IConexionBD GENERADOR_CONEXIONES;
    /**
     * Logger de excepciones
     */
    private static final Logger LOG = Logger.getLogger(DomiciliosDAO.class.getName());

    /**
     * Constructor que recibe el generador de conexiones
     *
     * @param GENERADOR_CONEXIONES Generador de conexiones
     */
    public DomiciliosDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    /**
     * Consulta la base de datos y trae el domicilio que coincida con el id dada
     *
     * @param id identificador a buscar
     * @return Domicilio encontrado
     */
    @Override
    public Domicilio consultar(int id) {
        /* Consultas */
        String SQLQuery = "SELECT calle, numero, colonia,codigoPostal FROM domicilios WHERE id = ?";

        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(SQLQuery);) {
            /*
            Se inserta el identificador en la consulta
             */
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            Domicilio domicilio = null;
            /*
            Se extrae la informacion de la consulta
             */
            if (resultado.next()) {
                String calle = resultado.getString("calle");
                String numero = resultado.getString("numero");
                String colonia = resultado.getString("colonia");
                String codigoPostal = resultado.getString("codigoPostal");
                domicilio = new Domicilio(id, calle, numero, colonia, codigoPostal);
            }
            /*
            Se regresa lo que se obtuvo
             */
            return domicilio;

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }

    /**
     * Inserta en la base de datos el domicilio dado
     *
     * @param domicilio Domicilio a insertar
     * @return Domicilio insertado
     * @throws PersistenciaException Si ocurre una excepcion al conectarse a la
     * base
     */
    @Override
    public Domicilio insertar(Domicilio domicilio) throws PersistenciaException {
        /* Consultas */
        String SQLQuery = "INSERT INTO domicilios(calle,numero, colonia, codigoPostal) VALUES (?,?,?,?)";

        try (Connection conexion = GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(SQLQuery, Statement.RETURN_GENERATED_KEYS);) {

            /*
            Se inserta la informacion en la insercion
             */
            comando.setString(1, domicilio.getCalle());
            comando.setString(2, domicilio.getNumero());
            comando.setString(3, domicilio.getColonia());
            comando.setString(4, domicilio.getCodigoPostal());

            comando.executeUpdate();

            ResultSet llavesGeneradas = comando.getGeneratedKeys();

            /*
            Extraemos las llaves generadas y las insertamos en el domicilio
             */
            if (llavesGeneradas.next()) {
                Integer llavePrimaria = llavesGeneradas.getInt(1);
                domicilio.setId(llavePrimaria);
                return domicilio;
            }
            /*
            Se lanzara una excepcion si no se nos genero un id
             */
            throw new PersistenciaException("Direccion registrado pero ID no generado");

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible registrar al cliente");

        }
    }

    /**
     * Actualiza el domicilio en la base que coincida con el dado en el
     * parametro
     *
     * @param domicilio Domicilio a actualizar
     * @return Domicilio actualizado
     * @throws PersistenciaException Si ocurre una excepcion al conectarse a la
     * base
     */
    @Override
    public Domicilio actualizar(Domicilio domicilio) throws PersistenciaException {
        /* Consultas */
        String SQLQuery = "UPDATE domicilios SET calle = ?,numero = ?, colonia = ?,codigoPostal = ? WHERE id = ?";

        try (Connection conexion = GENERADOR_CONEXIONES.crearConexion(); PreparedStatement comando = conexion.prepareStatement(SQLQuery);) {
            
            /*
            Se insertan la informacion a actualizar en el UPDATE
            */
            comando.setString(1, domicilio.getCalle());
            comando.setString(2, domicilio.getNumero());
            comando.setString(3, domicilio.getColonia());
            comando.setString(4, domicilio.getCodigoPostal());
            comando.setInt(5, domicilio.getId());
            
            
            int numeroClientesEditados = comando.executeUpdate();
            /*
            Regresaremos lo que actualizamos, en caso contrario un null
            */
            return numeroClientesEditados > 0 ? domicilio : null;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible editar al cliente");

        }
    }

}
