/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Toled
 */
public class ConfiguracionPaginado {
    int limite;
    int numPagina;
    int offset;

    public ConfiguracionPaginado() {
        this.numPagina = 0;
        this.limite = 5;
        this.calcOffset();
    }

    
    
    public ConfiguracionPaginado(int limite, int numPagina) {
        this.limite = limite;
        this.numPagina = numPagina;
        this.calcOffset();
    }

    public int getOffset() {
        return offset;
    }

    public int getLimite() {
        return limite;
    }
    

    private void calcOffset() {
        this.offset = (this.limite * this.numPagina);
    }
    
    
}
