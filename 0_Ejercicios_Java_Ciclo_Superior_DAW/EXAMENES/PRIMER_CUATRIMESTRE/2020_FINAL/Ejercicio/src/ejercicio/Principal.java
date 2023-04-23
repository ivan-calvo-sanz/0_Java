package ejercicio;
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
// Contraseña:  WXYZ
// Cifrada:     ABCD
// CLAVE 4

public class Principal {
    public static final long serialVersionUID = 1L;
    static Scanner entrada=new Scanner(System.in);
    static File f=new File("departamento.txt");
    static Usuario USUARIO=new Usuario();
    
    public static void main(String[] args) {
        
        //Usuario usuario=new Usuario("ivanovich","WXYZ",4,false);
        //System.out.println("Cifrada "+usuario.getContraseñaCifrada());
        
        //Usuario usuario=new Usuario("ivanovich","ABCD",4,true);
        //System.out.println("Cifrada "+usuario.getContraseña());
        
        int opcion;
        do{
            System.out.println("Bienvenido al sistema de gestion empresarial");
            System.out.println("(1) Dar de alta un departamento");
            System.out.println("(2) Recuperar el último departamento");
            System.out.println("(3) Eliminar el último departamento");
            System.out.println("(0) Salir");
            System.out.println("Introduce opción desada (0-3)");
            opcion=entrada.nextInt();
            if(opcion>=0&&opcion<4){
                switch(opcion){
                    case 1:
                        nuevaAlta();
                        break;
                    case 2:
                        devuelveDepartamento();
                        break;
                    case 3:
                        eliminarFichero();
                        break;
                    case 0:
                        System.out.println("Aplicación cerrada!");
                        break;
                }
            }else{
                System.out.println(opcion+" NO es opción posible. Introduzca opción correcta.");
            }
        }while(opcion!=0);
    }
    
    private static void nuevaAlta(){
        System.out.println("Introduce el nombre del departamento:");
        String nombreDepartamento=entrada.next();
        System.out.println("Introduce el id del Director:");
        int idDirector=entrada.nextInt();
        System.out.println("Introduce el nombre del Director:");
        String nombreDirector=entrada.next();
        System.out.println("Introduce el login del usuario:");
        String loginUsuario=entrada.next();
        System.out.println("Introduce la contraseña del usuario:");
        String contraseñaUsuario=entrada.next();
        System.out.println("Introduce la clave de cifrado:");
        int claveCifrado=entrada.nextInt();
        
        Usuario usuario=new Usuario(loginUsuario,contraseñaUsuario,claveCifrado);
        Director director=new Director(idDirector,nombreDirector,usuario);
        Departamento departamento=new Departamento(nombreDepartamento,director);
        
        System.out.println("Datos introducidos correctamente");
        System.out.println("Nombre del Departamento: "+departamento.getNombre());
        System.out.println("Nombre del director "+director.getNombre());
        System.out.println("Login del usuario "+usuario.getLogin());
        System.out.println("Contraseña cifrada del usuario "+usuario.getContraseñaCifrada());
        System.out.println("Clave de cifrado "+usuario.getClaveCifrado());
        
        generarArchivo();
        guardarObjeto(departamento);
        
    }
    
    private static void generarArchivo(){
        try {
            if(!f.exists()){
                f.createNewFile();
            }else{
                f.delete();
                f.createNewFile();
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al generar el archivo: "+e);
        }
    }
    
    private static void guardarObjeto(Departamento departamento){
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            fos=new FileOutputStream(f,true);
            oos=new ObjectOutputStream(fos);
            oos.writeObject(departamento);
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
    
    private static void devuelveDepartamento(){
        Departamento departamento;
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            departamento=(Departamento)ois.readObject();
            String contraseña=USUARIO.desCifrarContraseña(departamento.director.usuario.getContraseñaCifrada(), 
                    departamento.director.usuario.getClaveCifrado());
                System.out.println("El Departamento guardado es");
                System.out.println("Nombre del Departamento: "+departamento.getNombre());
                System.out.println("Nombre del director "+departamento.director.getNombre());
                System.out.println("Login del usuario "+departamento.director.usuario.getLogin());
                System.out.println("Contraseña del usuario "+contraseña);
                System.out.println("Clave de cifrado "+departamento.director.usuario.getClaveCifrado());
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
    }
    
    private static void eliminarFichero(){
        try {
            if(f.exists()){
                f.delete();
                System.out.println("El fichero se ha borrado correctamente.");
            }else{
                System.out.println("El fichero NO existe.");
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al generar el archivo: "+e);
        }
    }

    
}