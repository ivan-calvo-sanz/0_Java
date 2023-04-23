package ejercicio1;
import java.io.Serializable;
import java.util.regex.Pattern;


public class Evento implements Serializable{
    public static final long serialVersionUID = 1L;
    private String nombre;
    private String fecha;
    private String lugar;
    private double precio;
    private int numEspectadoresEvento;
    private double recaudacion;
    Estadio estadio;
    
    public Evento(){
    }
    
    public Evento(String nombre,String fecha,Estadio estadio,double precio){
        this.nombre=nombre;
        this.fecha=fecha;
        this.estadio=estadio;
        this.precio=precio;
        numEspectadoresEvento=0;
        recaudacion=0;
    }
    
    public void modificarRecaudacion(int numEspectadores){
        recaudacion=precio*numEspectadores;
    }
    
    public boolean validaNombre(String nom){
        //El nombre del Evento tiene que tener entre 3 y 50 caracteres
        if(nom.length()>3&&nom.length()<50){
            return true;
        }
        System.out.println("El nombre del Evento tiene que tener entre 4 y 50 caracteres.");
        return false;
    }
    
    public boolean validaFecha(String fecha){
        Pattern fechaPattern=Pattern.compile("[0-9]{2}-[0-9]{2}-[0-9]{4}");
        if(fechaPattern.matcher(fecha).matches()){
            return true;
        }
        System.out.println("La fecha debe cumplir el formato dd-mm-aaaa");
        return false;
    }
    
    public boolean validaLugar(String nom){
        if(nom.length()>3&&nom.length()<50){
            return true;
        }
        System.out.println("El nombre del Lugar del Evento tiene que tener entre 4 y 50 caracteres.");
        return false;
    }
       
    public boolean validaPrecio(double precio) throws Exception{
        if(precio>0){
            return true;
        }
        throw new Exception("El precio debe ser mayor a 0");
    }
    
    public boolean validaNumEspectadores(int num) throws Exception{
        if(num>0 && num<150000){
            return true;
        }
        throw new Exception("La capacidad del evento debe ser menor de 150.000");
    }
    
    public void mostrarEvento(){
        System.out.print("EVENTO:"+nombre+" | Fecha:"+fecha+" | Precio:"+precio+"€"+" | Nº de espectadores en el"
                + " evento:"+numEspectadoresEvento+"personas"+" | Recaudacion:"+recaudacion+"€ ");
        estadio.mostrarEstadio();
    }
    
    public void modificarNumEspectadoresEvento(int num){
        this.numEspectadoresEvento=num;
    }
    
    public void modificarRecaudacion(){
        recaudacion=numEspectadoresEvento*precio;
    }
    
    public double devuelveRecaudacion(){
        return recaudacion;
    }
    
}