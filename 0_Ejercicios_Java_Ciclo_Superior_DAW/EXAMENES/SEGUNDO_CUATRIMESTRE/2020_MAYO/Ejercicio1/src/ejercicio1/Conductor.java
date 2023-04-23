package ejercicio1;

/**
 *
 * @author IVAN
 */
public class Conductor {
    private String nmbre;
    private String apellidos;
    private String dni;

    public Conductor(String nmbre, String apellidos, String dni) {
        this.nmbre = nmbre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    public String getNmbre() {
        return nmbre;
    }
    public void setNmbre(String nmbre) {
        this.nmbre = nmbre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    
}