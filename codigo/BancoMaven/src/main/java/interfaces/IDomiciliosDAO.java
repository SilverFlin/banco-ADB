/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Domicilio;
import excepciones.PersistenciaException;

/**
 *
 * @author Elkur
 */
public interface IDomiciliosDAO {

    Domicilio consultar(int id);

    Domicilio insertar(Domicilio domicilio) throws PersistenciaException;

    Domicilio editar(Domicilio domicilio) throws PersistenciaException;

}
