package prog08_ejer01;

import java.util.ArrayList;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellidos;
    private ArrayList<Telefono> telefonos;
    private ArrayList<Email> emails;
    
    //Constructores
    public Cliente(){
    }
    public Cliente(String dni,String nombre,String apellidos,ArrayList<Telefono> telefonos,ArrayList<Email> email){
        this.dni=dni;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.telefonos=telefonos;
        this.emails=emails;
    }

    //Métodos get y set
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
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
    public ArrayList<Telefono> getTelefonos() {
        return telefonos;
    }
    public void setTelefonos(ArrayList<Telefono> telefonos) {
        this.telefonos = telefonos;
    }
    public ArrayList<Email> getEmails() {
        return emails;
    }
    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }
}