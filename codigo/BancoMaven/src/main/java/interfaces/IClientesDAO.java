/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cliente;
import excepciones.PersistenciaException;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 *
 * @author Elkur
 */
public interface IClientesDAO {

    Cliente consultar(String correo);

    Cliente insertar(Cliente cliente) throws PersistenciaException;
    
    Cliente editar(Cliente cliente) throws PersistenciaException;

    List<Cliente> consultar(ConfiguracionPaginado configPaginado) throws PersistenciaException;

}
