package prog03_ejer04;

public class Persona {
    String nombre;
    int edad;
    float altura;
    
    Persona(){
        nombre="Luisa Perez";
        edad=22;
        altura=1.70f;
    }
    
    Persona(String nombre,int edad,float altura){
        this.nombre=nombre;
        this.edad=edad;
        this.altura=altura;
    }
    
    String obtener_Nombre(){
        return nombre;
    }
    void modificar_Nombre(String nom){
        nombre=nom;
    }
    
    int obtener_edad(){
        return edad;
    }
    void modificar_edad(int edad){
        this.edad=edad;
    }
    
    float obtener_altura(){
        return altura;
    }
    void modificar_altura(float altura){
        this.altura=altura;
    }
}