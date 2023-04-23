package SerializableBinaria_Clientes;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Aplicacion {
    public static final long serialVersionUID = 1L;
    static File f=new File("Clientes.txt");
    static File fAux;
    static Scanner sc=new Scanner(System.in);
    
    public static void main(String[] args){
        
        int opcion;
        do{
            System.out.println("MENU");
            System.out.println("(1) Añadir cliente");
            System.out.println("(2) Listar clientes");
            System.out.println("(3) Buscar clientes");
            System.out.println("(4) Borarr clientes");
            System.out.println("(5) Borrar fichero de clientes");
            System.out.println("(6) Salir de la aplicación");
            System.out.println("Introduce que opción desea realizar");
            opcion=sc.nextInt();      
            if(opcion>0||opcion<7){
                switch(opcion){
                    case 1:
                        añadirCliente();
                        break;
                    case 2:
                        listarClientes();
                        break;
                    case 3:
                        buscarCliente();
                        break;
                    case 4:
                        borrarCliente();
                        break;
                    case 5:
                        borrarFichero();
                        break;
                    case 6:
                        System.out.println("Aplicación cerrada!");
                        break;
                }
            }else{
                System.out.println(opcion+" NO es opción posible. Introduzca opción correcta.");   
            }
        }while(opcion!=6);
    }
    
    private static void añadirCliente(){
        System.out.println("Introduce los datos del cliente:");
        String nif="",nombre="",tlf="",direccion="";
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("NIF:");
            nif = reader.readLine();
            System.out.println("Nombre:");
            nombre = reader.readLine();
            System.out.println("Telefono:");
            tlf = reader.readLine();    
            System.out.println("Direccion:");
            direccion=reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Deuda:");
        double deuda=sc.nextDouble();
        
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        
        try {
            fos=new FileOutputStream(f,true);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(new Clientes(nif,nombre,tlf,direccion,deuda));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(fos!=null){
                try {
                    fos.close();
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private static void listarClientes(){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        int i=0;
        Clientes c;
        
        try {
            fis=new FileInputStream(f);
            while(true){
                ois=new ObjectInputStream(fis);
                c=(Clientes)ois.readObject();
                c.mostrarClientes();
                i++;
            }
        }catch (FileNotFoundException error){
            System.out.println("Archivo no existe");
        }catch (EOFException ef){
        }catch (IOException e) {
            System.out.println("Error al listar el Archivo");
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(fis!=null){
                try {
                    fis.close();
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private static void buscarCliente(){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        Clientes c;
        int i=0;
        boolean encontrado=false;
        
        System.out.println("Introduce nif del Cliente que busca: ");
        String nifBuscado=sc.next();
        
        try {
            fis=new FileInputStream(f);
            while(true){
                ois=new ObjectInputStream(fis);
                c=(Clientes)ois.readObject();
                if(c.obtenerNif().equals(nifBuscado)){
                    System.out.println("SI es cliente:");
                    encontrado= true;
                    c.mostrarClientes();
                    break;
                }                
                i++;
            }
        }catch (FileNotFoundException error){
            System.out.println("Archivo no existe");
        }catch (EOFException ef){
        }catch (IOException e) {
            System.out.println("Error al listar el Archivo");
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(fis!=null){
                try {
                    fis.close();
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(!encontrado)System.out.println("El NIF "+nifBuscado+" NO es cliente:");
    }
    
    private static void borrarCliente(){
        fAux=new File("ClientesAux.txt");
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        
        System.out.println("Introduce NIF del cliente a borrar");
        String nifBorrar=sc.next();
        
        Clientes c;
        
        try {
            fis=new FileInputStream(f);
            fos=new FileOutputStream(fAux,true);
            while(true){
                ois=new ObjectInputStream(fis);
                c=(Clientes)ois.readObject();
                if(!c.obtenerNif().equals(nifBorrar)){
                    oos=new ObjectOutputStream(fos);
                    oos.writeObject(c);
                }            
            }
        }catch (FileNotFoundException error){
            System.out.println("Archivo no existe");
        }catch (EOFException ef){
        }catch (IOException e) {
            System.out.println("Error al listar el Archivo");
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(fis!=null){
                try {
                    fis.close();
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    f.delete();
    fAux.renameTo(new File("Clientes.txt"));
    fAux.delete();
    }
    
    private static void borrarFichero(){
        System.out.println("Archivo "+f+" BORRADO");
        f.delete();
    }
}