package dominio;

/**
 *
 * @author Toled
 */
public class Domicilio {

    /**
     * Identificador del domicilio
     */
    private int id;
    /**
     * Calle
     */
    private String calle;
    /**
     * Numero de la vivienda
     */
    private String numero;
    /**
     * Colonia de la vivienda
     */
    private String colonia;
    /**
     * Ciudad de la vivienda
     */
    private String ciudad;
    /**
     * Estado de la vivienda
     */
    private String estado;
    /**
     * Pais de la vivienda
     */
    private String pais;
    /**
     * Codigo postal de la vivienda
     */
    private String codigoPostal;

    /**
     * Constructor principal que recibe todos sus atributos
     *
     * @param id Identificador del domicilio
     * @param calle Calle de la vivienda
     * @param numero Numero de la vivienda
     * @param colonia Colonia de la vivienda
     * @param ciudad Ciudad de la vivienda
     * @param estado Estado de la vivienda
     * @param pais Pais de la vivienda
     * @param codigoPostal Codigo postal de la vivienda
     */
    public Domicilio(int id, String calle, String numero, String colonia, String ciudad, String estado, String pais, String codigoPostal) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Constructor secundario que no recibe el identificador
     *
     * @param calle Calle de la vivienda
     * @param numero Numero de la vivienda
     * @param colonia Colonia de la vivienda
     * @param ciudad Ciudad de la vivienda
     * @param estado Estado de la vivienda
     * @param pais Pais de la vivienda
     * @param codigoPostal Codigo postal de la vivienda
     */
    public Domicilio(String calle, String numero, String colonia, String ciudad, String estado, String pais, String codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Constructor que recibe los minimos requerimientos
     *
     * @param id Identificador del domicilio
     * @param calle Calle de la vivienda
     * @param numero Numero de la vivienda
     * @param colonia Colonia de la vivienda
     * @param codigoPostal Codigo postal de la vivienda
     */
    public Domicilio(int id, String calle, String numero, String colonia, String codigoPostal) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Regresa la calle de la vivienda
     *
     * @return Calle de la vivienda
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la vivienda
     *
     * @param calle Calle de la vivienda
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Regresa el numero de la vivienda
     *
     * @return Numero de la vivienda
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el numero de la vivienda
     *
     * @param numero Numero de la vivienda
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Regresa la colonia de la vivienda
     *
     * @return Colonia de la vivienda
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia de la vivienda
     *
     * @param colonia Colonia de la vivienda
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene la ciudad de la vivienda
     *
     * @return Ciudad de la vivienda
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad de la vivienda
     *
     * @param ciudad Ciudad de la vivienda
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Regresa el estado de la vivienda
     *
     * @return Estado de la vivienda
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la vivienda
     *
     * @param estado Estado de la vivienda
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Regresa el pais de la vivienda
     *
     * @return Pais de la vivienda
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el pais de la vivienda
     *
     * @param pais Pais de la vivienda
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Regresa el codigo postal de la vivienda
     *
     * @return Codigo postal de la vivienda
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el codigo postal de la vivienda
     *
     * @param codigoPostal Codigo postal de la vivienda
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Regresa el identificador del domicilio
     *
     * @return Identificador del domicilio
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del domicilio
     *
     * @param id Identificador del domicilio
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Genera el codigo hash de domicilio
     *
     * @return Codigo hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        return hash;
    }

    /**
     * Compara un objeto consigo mismo
     *
     * @param obj objeto a comparar
     * @return Si son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Domicilio other = (Domicilio) obj;
        return this.id == other.id;
    }

    /**
     * Regresa una cadena con los atributos del domicilio
     *
     * @return Cadena con los atributos
     */
    @Override
    public String toString() {
        return "Domicilio{" + "id=" + id + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", ciudad=" + ciudad + ", estado=" + estado + ", pais=" + pais + ", codigoPostal=" + codigoPostal + '}';
    }

}
