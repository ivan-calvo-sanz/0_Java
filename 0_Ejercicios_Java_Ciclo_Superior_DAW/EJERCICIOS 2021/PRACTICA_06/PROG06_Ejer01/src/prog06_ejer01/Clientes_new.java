package prog06_ejer01;
import java.io.Serializable;

public class Clientes_new implements Serializable{
    public static final long serialVersionUID=1L;
    
    private String nif;
    private String nombre;
    private String tlf;
    private String direccion;
    private double deuda;
    
    public Clientes_new(String nif,String nombre,String tlf,String direccion,double deuda){
        this.nif=nif;
        this.nombre=nombre;
        this.tlf=tlf;
        this.direccion=direccion;
        this.deuda=deuda;
    }
    
    public void mostrarClientes(){
        System.out.println(nif+" "+nombre+" "+tlf+" "+direccion+" "+deuda);
    }
    
    public String mostrarNif(){
        return nif;
    }
    
}