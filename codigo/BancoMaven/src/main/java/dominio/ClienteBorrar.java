/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
