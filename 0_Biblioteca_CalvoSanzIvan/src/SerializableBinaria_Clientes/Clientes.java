package SerializableBinaria_Clientes;
import java.io.Serializable;


public class Clientes implements Serializable{
    public static final long serialVersionUID = 1L;
    
    private final String nif;
    private final String nombre;
    private final String tlf;
    private final String direccion;
    private final double deuda;
    
    public Clientes(String nif, String nombre, String tlf, String direccion, double deuda){
        this.nif=nif;
        this.nombre=nombre;
        this.tlf=tlf;
        this.direccion=direccion;
        this.deuda=deuda;
    }
    
    public void mostrarClientes(){
        System.out.println(nif+" "+nombre+" "+tlf+" "+direccion+" "+deuda);
    }
    
    public String obtenerNif(){
        return nif;
    }
    
    
}
