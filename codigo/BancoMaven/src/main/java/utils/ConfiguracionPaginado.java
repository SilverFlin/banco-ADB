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
        calcOffset();
        return offset;
    }

    public int getLimite() {
        return limite;
    }

    private void calcOffset() {
        this.offset = (this.limite * this.numPagina);
    }

    public void avanzarPag() {
        numPagina++;
    }

    public void retrocederPag() {
        if (this.numPagina != 0) {
            this.numPagina--;
        }
    }
}
