package prog09_ejer01;

import java.util.Date;

/*
    Clase Persona 
    define un cliente
*/
public class Persona implements Imprimible {
    private String nombre;
    private String apellidos;
    private String fechaNac;

    public Persona(String nombre, String apellidos, String fechaNac) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
    }
    
    @Override
    public String mostrarInfo(){
        //String info=nombre+apellidos;
        return "Nombre: "+getNombre()+" "+getApellidos()+"\n"+"Fecha de nacimiento: "+getFechaNac();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getFechaNac() {
        return fechaNac;
    }
    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

  
    
    
    
}