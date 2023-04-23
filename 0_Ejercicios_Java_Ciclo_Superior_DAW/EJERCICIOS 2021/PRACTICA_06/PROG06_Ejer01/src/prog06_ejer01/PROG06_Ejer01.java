package prog06_ejer01;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PROG06_Ejer01 {
    public static final long serialVersionUID=1L;
    static Scanner sc=new Scanner(System.in);
    static File f=new File("Clientes.txt");
    static File fAux;

    public static void main(String[] args) {
        
        int opcion;
        
        System.out.println("Introduce opción:");
        System.out.println("1-Añadir cliente.");
        System.out.println("2-Listar clientes.");
        System.out.println("3-Buscar clientes.");
        System.out.println("4-Borrar cliente.");
        System.out.println("5-Borrar fichero.");
        System.out.println("6-Salir de la aplicacion.");
        do{
            opcion=sc.nextInt();
            switch(opcion){
                case 1:
                    añadirCliente();
                    System.out.println("*************************");
                    break;
                case 2:
                    listarClientes();
                    System.out.println("*************************");
                    break;
                case 3:
                    buscarCliente();
                    System.out.println("*************************");
                    break;
                case 4:
                    borrarCliente();
                    System.out.println("*************************");
                    break;
                case 5:
                    borrarFichero();
                    System.out.println("*************************");
                    break;
                case 6:
                    System.out.println("¡HASTA PRONTO!");
                    System.out.println("***La aplicacion se ha cerrado***");
                    break;
            }
        }while(opcion!=6);
    }

    private static void añadirCliente(){
            String nif="",nombre="",tlf="",direccion="";
            double deuda;
            System.out.println("Introduce los datos del Cliente:");
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            
        try { 
            System.out.println("NIF:");
            nif=reader.readLine();
            System.out.println("Nombre:");
            nombre=reader.readLine();
            System.out.println("Telefono:");
            tlf=reader.readLine();
            System.out.println("Direccion:");
            direccion=reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(PROG06_Ejer01.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Deuda:");
            deuda=sc.nextDouble();
            
            FileOutputStream fos=null;
            ObjectOutputStream oos=null;
            
        try {
            fos=new FileOutputStream(f,true);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(new Clientes_new(nif,nombre,tlf,direccion,deuda));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PROG06_Ejer01.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PROG06_Ejer01.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(fos!=null){
                try {
                    fos.close();
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(PROG06_Ejer01.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private static void listarClientes(){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        //int i=0;
        Clientes_new c;
        
        try {
            fis=new FileInputStream(f);
            while(true){
                ois=new ObjectInputStream(fis);
                c=(Clientes_new)ois.readObject();
                c.mostrarClientes();
                //i++;
            }
        } catch (FileNotFoundException error) {
            System.out.println("Archivo no existe");
        }catch (EOFException ef){
        } catch (IOException e) {
            System.out.println("Error al listar el archivo");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PROG06_Ejer01.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(fis!=null){
                try {
                    fis.close();
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(PROG06_Ejer01.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
    }

    private static void buscarCliente(){
        boolean encontrado=false;
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        int i=0;
        Clientes_new c;
        System.out.println("Introduce nif del cliente que busca:");
        String nif_buscado=sc.next();
        try {
            fis=new FileInputStream(f);
            while(true){
                ois=new ObjectInputStream(fis);
                c=(Clientes_new)ois.readObject();
                if(c.mostrarNif().equals(nif_buscado)){
                    System.out.println("El cliente SI existe");
                    c.mostrarClientes();
                    encontrado=true;
                    break;
                }
                i++;
            }
        } catch (FileNotFoundException error) {
            System.out.println("Archivo no existe");
        }catch (EOFException ef){
        } catch (IOException e) {
            System.out.println("Error al listar el Archivo");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PROG06_Ejer01.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(fis!=null){
                try {
                    fis.close();
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(PROG06_Ejer01.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(encontrado==false)System.out.println("Cliente NO existe.");
    }
    
    private static void borrarCliente(){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        
        System.out.println("Introduce nif del cliente que quiere borrar:");
        String nif_borrar=sc.next();
        
        int i=0;
        Clientes_new c;
        
        fAux=new File("ClientesAux.txt");
        
        try {
            fis=new FileInputStream(f);
            fos=new FileOutputStream(fAux,true);
            while(true){
                ois=new ObjectInputStream(fis);
                c=(Clientes_new)ois.readObject();
                if(!c.mostrarNif().equals(nif_borrar)){
                    oos=new ObjectOutputStream(fos);
                    oos.writeObject(c);
                }
                
                i++;
            }
        } catch (FileNotFoundException error) {
            System.out.println("Archivo no existe");
        }catch (EOFException ef){
        } catch (IOException e) {
            System.out.println("Error al listar el Archivo");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PROG06_Ejer01.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(fis!=null){
                try {
                    fis.close();
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(PROG06_Ejer01.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(PROG06_Ejer01.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        f.delete();
        fAux.renameTo(new File("Clientes.txt"));
        fAux.delete();
    }

    private static void borrarFichero(){
        System.out.println("Fichero "+f+" borrado");
        f.delete();
    }
    
}