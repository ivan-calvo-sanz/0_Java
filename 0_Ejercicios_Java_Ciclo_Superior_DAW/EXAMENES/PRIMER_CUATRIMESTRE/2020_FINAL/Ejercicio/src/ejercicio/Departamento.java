package ejercicio;
import java.io.Serializable;

public class Departamento implements Serializable{
    public static final long serialVersionUID=1L;   
    private String nombre;
    Director director;

    public Departamento(String nombre, Director director) {
        this.nombre = nombre;
        this.director = director;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }
   
}