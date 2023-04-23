package prog03_ejer01;

public class Persona {
    String nombre;
    int edad;
    float altura;
    
    String consulta_Nombre(){
        return nombre;
    }
    
    void cambia_Nombre(String nom){
        nombre=nom;
    }
}