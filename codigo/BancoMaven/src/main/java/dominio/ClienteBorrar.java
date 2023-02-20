package dominio;

/**
 *
 * @author Toled
 */
public class ClienteBorrar {
    private Integer id;
    private String nombre;
    

    public ClienteBorrar(Integer id) {
        this.id = id;
        this.nombre = "Luis";
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
}
