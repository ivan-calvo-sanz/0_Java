package ejercicio1;
import java.io.Serializable;

public class Estadio implements Serializable{
    public static final long serialVersionUID = 1L;
    private String nombre;
    private String ubicacion;
    private int numEspectadoresEstadio;
    
    public Estadio(){
        
    }
    
    public Estadio(String nombre,String ubicacion,int num){
        this.nombre=nombre;
        this.ubicacion=ubicacion;
        numEspectadoresEstadio=num;
    }
    
    public boolean validaNombre(String nom){
        //El nombre del Evento tiene que tener entre 3 y 50 caracteres
        if(nom.length()>3&&nom.length()<50){
            return true;
        }
        System.out.println("El nombre del Estadio tiene que tener entre 4 y 50 caracteres.");
        return false;
    }
    
    public boolean validaUbicacion(String nom){
        //El nombre del Evento tiene que tener entre 3 y 50 caracteres
        if(nom.length()>3&&nom.length()<50){
            return true;
        }
        System.out.println("La ubicacion del Estadio tiene que tener entre 4 y 50 caracteres.");
        return false;
    }
    
    public boolean validaNumEspectadores(int num) throws Exception{
        if(num>0 && num<150000){
            return true;
        }
        throw new Exception("La capacidad debe ser menor de 150.000");
    }
    
    public void mostrarEstadio(){
        System.out.println("| ESTADIO:"+nombre+" | Ubicación:"+ubicacion+" | Aforo max.:"+numEspectadoresEstadio+" personas");
    }
    
    public int devuelveMaxAforoEstadio(){
        return numEspectadoresEstadio;
    }
    
}
