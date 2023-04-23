package ejercicio1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.InputMismatchException;

public class Principal {
    public static final long serialVersionUID = 1L;
    static File f=new File("ejercicio2.txt");
    static Scanner entrada=new Scanner(System.in);
    static Evento EVENTO=new Evento();
    static Estadio ESTADIO=new Estadio();
    
    public static void main(String[] args) throws Exception {
               
        int opcion;
        System.out.println("1-Crear un nuevo evento");
        System.out.println("2-Simular espectadores");
        System.out.println("3-Mostrar evento");
        System.out.println("4-Borrar evento");
        System.out.println("0-Salir");
                do{    
                    System.out.println("Introduce opción del Menú:");
                    opcion=entrada.nextInt();
                    switch (opcion){
                        case 1:
                            nuevoEvento();
                            System.out.println("*************************");
                            break;
                        case 2:
                            simulaEspectadores();
                            System.out.println("*************************");
                            break;
                        case 3:
                            mostrarEvento();
                            System.out.println("*************************");
                            break;
                        case 4:
                            borraEvento();
                            System.out.println("*************************");
                            break;
                        case 0:
                            System.out.println("¡HASTA PRONTO!");
                            System.out.println("***La aplicacion se ha cerrado***");
                            break;
                }    
                }while(opcion!=0);
    }
    
    private static void nuevoEvento() throws Exception{
        String nombreEvento,fecha,nombreEstadio,ubicacion;
        int aforoMax=0;
        double precio=0;
            System.out.println("Introduce los datos del Nuevo Evento:");
            do{
                System.out.println("Nombre del Evento:");
                nombreEvento=entrada.next();
            }while(!EVENTO.validaNombre(nombreEvento));
            do{
                System.out.println("Fecha del Evento:");
                fecha=entrada.next();
            }while(!EVENTO.validaFecha(fecha));
            do{
                System.out.println("Nombre del Estadio:");
                nombreEstadio=entrada.next();    
            }while(!ESTADIO.validaNombre(nombreEstadio));
            do{
                System.out.println("Ubicacion del Estadio:");
                ubicacion=entrada.next();
            }while(!ESTADIO.validaUbicacion(ubicacion));
            do{
                try{
                    System.out.println("Aforo max. del Estadio:");
                    aforoMax=entrada.nextInt();
                }catch(Exception e){
                    System.out.println("Se ha producido un error");
                }
            }while(!ESTADIO.validaNumEspectadores(aforoMax));
            do{
                try {
                    System.out.println("Precio de la entrada:");
                    precio=entrada.nextDouble();
                } catch (Exception e) {
                    System.out.println("Se ha producido un error.");
                }
            }while(!EVENTO.validaPrecio(precio));
            
            borrarFichero();
            
            //if(!f.exists()){
            //    crearFichero();
            //}else if(f.exists()){
            //    borrarFichero();
            //    crearFichero();
            //}
            
            Estadio estadio=new Estadio(nombreEstadio,ubicacion,aforoMax);
            System.out.println("Estadio creado");
            Evento evento=new Evento(nombreEvento,fecha,estadio,precio);
            System.out.println("Evento creado");
            
            guardarObjeto(evento);
    }
    
    private static void guardarObjeto(Evento evento){
            FileOutputStream fos=null;
            ObjectOutputStream oos=null;
                try {    
                    fos=new FileOutputStream(f,true);
                    oos=new ObjectOutputStream(fos);
                    oos.writeObject(evento);
                    System.out.println("Evento realizado correctamente");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                    if(fos!=null){
                        try {
                            fos.close();
                            oos.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
    }
    
    private static void crearFichero(){
                try {
                    System.out.println("Creando fichero...");
                    f=new File("ejercicio1.txt");
                    //f.createNewFile();
                } catch (Exception e) {
                    System.out.println("Se ha producido un error: "+e);
                }
    }
        
    private static void borrarFichero(){
                try {
                    System.out.println("Sobreescribiendo fichero...");
                    f.delete();
                } catch (Exception e) {
                    System.out.println("Se ha producido un error: "+e);
                }
    }
    
    private static void simulaEspectadores() throws Exception{
        if(f.exists()){
            Evento e=recuperaEvento();
            int maxAforo=e.estadio.devuelveMaxAforoEstadio();
            int numAleatorio=(int)(Math.random()*maxAforo+1);
            e.modificarNumEspectadoresEvento(numAleatorio);
            e.modificarRecaudacion();
            borrarFichero();
            guardarObjeto(e);
            System.out.println("Simulación de espectadores realizado con éxito! "+numAleatorio+" espectadores y "
                    + "la recaudación asciende a:"+e.devuelveRecaudacion()+"€");
        }else{
            System.out.println("Error, NO existe evento");
            throw new Exception("NO existe evento");
        }
            
    }
    
    private static Evento recuperaEvento(){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        Evento e=new Evento();
        
        try {
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            e=(Evento)ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(fis!=null){
                try {
                    fis.close();
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        return e;
    }
    
    private static void mostrarEvento() throws Exception{
        if(f.exists()){
            Evento e=recuperaEvento();
            e.mostrarEvento();
        }else{
            System.out.println("Error, NO existe evento");
            throw new Exception("NO existe evento");
        }
    }    
    
    private static void borraEvento() throws Exception{
        if(f.exists()){
            f.delete();
            System.out.println("Fichero externo eliminado correctamente.");
        }else{
            System.out.println("Error, NO existe evento");
            throw new Exception("NO existe evento");
        }        
        
    }
   
}