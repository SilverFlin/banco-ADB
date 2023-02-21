package dominio;

/**
 *
 * @author Toled
 */
public class Cliente {

    /**
     * Identificador del cliente
     */
    private int id;
    /**
     * Nombres del cliente
     */
    private String nombres;
    /**
     * Apellido paterno del cliente
     */
    private String apellidoP;
    /**
     * Apellido materno del cliente
     */
    private String apellidoM;
    /**
     * Fecha de nacimiento del cliente
     */
    private String fechaNacimiento;
    /**
     * Identificador del domicilio del cliente
     */
    private int idDomicilio;
    /**
     * Contrasenia del cliente
     */
    private String contrasenia;
    /**
     * Correo del cliente
     */
    private String correo;

    /**
     * Constructor principal del cliente
     *
     * @param id Identificador del cliente
     * @param nombres Nombres del cliente
     * @param apellidoP Apellido paterno del cliente
     * @param apellidoM Apellido materno del cliente
     * @param fechaNacimiento Fecha de nacimiento del cliente
     * @param idDomicilio identificador del domicilio del cliente
     */
    public Cliente(int id, String nombres, String apellidoP, String apellidoM, String fechaNacimiento, int idDomicilio) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNacimiento = fechaNacimiento;
        this.idDomicilio = idDomicilio;

    }

    /**
     * Constructor secundario del cliente
     *
     * @param nombres Nombres del cliente
     * @param apellidoP Apellido paterno del cliente
     * @param apellidoM Apellido materno del cliente
     * @param fechaNacimiento Fecha de nacimiento del cliente
     * @param idDomicilio identificador del domicilio del cliente
     */
    public Cliente(String nombres, String apellidoP, String apellidoM, String fechaNacimiento, int idDomicilio) {
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNacimiento = fechaNacimiento;
        this.idDomicilio = idDomicilio;
    }

    /**
     * Constructor que unicamente emplea un id
     *
     * @param id identificador del cliente
     */
    public Cliente(int id) {
        this.id = id;
    }

    /**
     * Regresa el identificador del cliente
     *
     * @return identificador del cliente
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del cliente
     *
     * @param id Identificador del cliente
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Regresa los nombres del cliente
     *
     * @return Nombre del cliente
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres del cliente
     *
     * @param nombres Nombres del cliente
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Regresa el apellido paterno del cliente
     *
     * @return Apellido paterno del cliente
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     * Establece el apellido paterno del cliente
     *
     * @param apellidoP Apellido paterno del cliente
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     * Regresa el apellido materno del cliente
     *
     * @return Apellido materno del cliente
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * Establece el apellido materno del cliente
     *
     * @param apellidoM Apellido materno del cliente
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /**
     * Regresa la fecha de nacimiento del cliente
     *
     * @return Fecha de nacimiento del cliente
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del cliente
     *
     * @param fechaNacimiento Fecha de nacimiento del cliente
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Regresa el identificador del domicilio del cliente
     *
     * @return Identificador del domicilio del cliente
     */
    public int getIdDomicilio() {
        return idDomicilio;
    }

    /**
     * Establece el identificador del domicilio del cliente
     *
     * @param idDomicilio Identificador del domicilio del cliente
     */
    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    /**
     * Regresa la contrasenia del cliente
     *
     * @return Contrasenia del cliente
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contrasenia del cliente
     *
     * @param contrasenia Contrasenia del cliente
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Regresa el correo del cliente
     *
     * @return Correo del cliente
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo del cliente
     *
     * @param correo Correo del cliente
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Genera el hash del cliente
     *
     * @return hash code 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        return hash;
    }

    /**
     * Compara los objetos
     *
     * @param obj Objeto a comparar
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
        final Cliente other = (Cliente) obj;
        return this.id == other.id;
    }

    /**
     * Regresa una cadena de texto con los atributos del cliente
     *
     * @return Cadena con los atributos del cliente
     */
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombres=" + nombres + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", fechaNacimiento=" + fechaNacimiento + ", idDomicilio=" + idDomicilio + ", contrase\u00f1a=" + contrasenia + '}';
    }

}
