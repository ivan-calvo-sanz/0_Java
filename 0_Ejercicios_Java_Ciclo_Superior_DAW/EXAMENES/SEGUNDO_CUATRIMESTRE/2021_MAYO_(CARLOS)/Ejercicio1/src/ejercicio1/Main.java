package ejercicio1;

import java.util.*;
import java.util.regex.*;

/**
 *
 * @author IVAN
 */
public class Main {
        
        static Map<String,Alquiler> listadoDniAlquiler=new HashMap();
        static Scanner entrada=new Scanner(System.in);
        static Pattern pDni=Pattern.compile("^[A-Za-z]?[0-9]{1,9}[A-Za-z]$");
        static final String DATO_VACIO="ERROR: No se permiten valores nulos o espacios en blanco. \nVuelva a introducir el dato: ";
        static final String DATO_NO_VALIDO="ERROR: El dato introducido no es válido.\nVuelva a introducir el dato: ";
        static final String DNI_NO_VALIDO="ERROR: El DNI introducido no es válido.\nVuelva a introducirlo de nuevo: ";
        static final String ERROR_INPUT="Datos introducidos erroneos";
        static final String MENU_PRINCIPAL
            = "\n************************\n"
            + "*****MENU PRINCIPAL*****\n"
            + "************************\n"
            + "1-ALQUILAR UN AMARRE\n"
            + "2-BUSCAR LOS DATOS DE UN ALQUILER\n"
            + "3-ELIMINAR UN ALQUILER\n"
            + "4-LISTAR TODOS LOS ALQUILERES\n"
            + "5-SALIR\n";
        static final String MENU_EMBARCACION
            = "1-LANCHA\n"
            + "2-YATE";
        static final String MENU_YATES
            = "1-CLASICO\n"
            + "2-BUCEO\n"
            + "3-PESCA\n"
            + "4-GRAN VELOCIDAD";
    
    public static void main(String[] args) {
        System.out.println(MENU_PRINCIPAL);
        System.out.print("Introduce opción del Menú:");
        boolean validar;
        int opcion=-1;
            try {
                do{    
                    //Introduce opcion y valida que es un nº entero
                    do{
                        opcion=validarEntero(entrada.nextLine());
                    }while(opcion==-1);
                    if(opcion>0&&opcion<6){
                        validar=true;
                        switch (opcion){
                            case 1:
                                alquilarAmarre();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 2:
                                mostrarAlquiler();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 3:
                                eliminarAlquiler();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 4:
                                mostrarAlquileres();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 5:
                                System.out.println("¡HASTA PRONTO!");
                                System.out.println("***La aplicacion se ha cerrado***");
                                break;
                        }
                    }else{
                        validar=false;
                        System.err.println("La opcion tiene que ser entre 1 y 5");
                        System.out.println("Introduce opción del Menú:");
                    }
                }while(opcion!=5||!validar);
            } catch (Exception e) {
                System.err.println(ERROR_INPUT+" |Error: "+e);
            }
    }

        private static void alquilarAmarre(){
            System.out.println("Introduce datos del cliente");
            //Introduce y valida DNI
            System.out.print("DNI:");
            String dni;
            do{
                dni=validarDNI(entrada.nextLine());
            }while(dni==null);
            
            if(!listadoDniAlquiler.containsKey(dni)){            
                //Introduce y valida nombre
                System.out.print("Nombre:");
                String nombre;
                do{
                    nombre=validarTexto(entrada.nextLine());
                }while(nombre==null);
                Cliente cliente=new Cliente(nombre,dni);
                
                //Introduce y valida un nº entero
                System.out.print("Nº dias de alquiler:");
                int dias;
                do{
                    dias=validarEntero(entrada.nextLine());
                }while(dias==-1);
                
                //Introduce y valida Matricula
                System.out.print("Matricula:");
                String matricula;
                do{
                    matricula=validarTexto(entrada.nextLine());
                }while(matricula==null);
      
                //Introduce y valida un m eslora
                System.out.print("Metros de eslora:");
                int mEslora;
                do{
                    mEslora=validarEntero(entrada.nextLine());
                }while(mEslora==-1);
                
                //Introduce y valida un m eslora
                System.out.print("Año de fabricación:");
                int añoFab;
                do{
                    añoFab=validarEntero(entrada.nextLine());
                }while(añoFab==-1);
                
                System.out.println("¿Que tipo de embarcacion es?");
                System.out.println(MENU_EMBARCACION);
                int opcion=-1;
                Alquiler alquiler;
                boolean validar;
                    try {
                        do{    
                            //Introduce opcion y valida que es un nº entero
                            do{
                                opcion=validarEntero(entrada.nextLine());
                            }while(opcion==-1);
                            if(opcion>0&&opcion<3){
                                validar=true;
                                switch (opcion){
                                    case 1:
                                        //Introduce y valida potencia
                                        System.out.print("Potencia:");
                                        double potencia;
                                        do{
                                            potencia=validarDouble(entrada.nextLine());
                                        }while(potencia==-1);
                                        //Introduce y valida un nº de pasajeros
                                        System.out.print("Nº de pasajeros:");
                                        int numPasajeros;
                                        do{
                                            numPasajeros=validarEntero(entrada.nextLine());
                                        }while(numPasajeros==-1);
                                        
                                        Lancha lancha=new Lancha(potencia,numPasajeros,matricula,mEslora,añoFab);
                                        alquiler=new Alquiler(cliente,dias,lancha);
                                        listadoDniAlquiler.put(dni, alquiler);
                                        System.out.println("El alquiler ha sido registrado correctamente");
                                        break;
                                    case 2:
                                        //Introduce y valida un nº de camarotes
                                        System.out.print("Nº de camarotes:");
                                        int numCamarotes;
                                        do{
                                            numCamarotes=validarEntero(entrada.nextLine());
                                        }while(numCamarotes==-1);
                                              
                                        System.out.println("Introduce tipo de Yate:");
                                        String tipo="";
                                        System.out.println(MENU_YATES);
                                        opcion=-1;
                                            try {
                                                do{    
                                                    //Introduce opcion y valida que es un nº entero
                                                    do{
                                                        opcion=validarEntero(entrada.nextLine());
                                                    }while(opcion==-1);
                                                    if(opcion>0&&opcion<5){
                                                        validar=true;
                                                        switch (opcion){
                                                            case 1:
                                                                tipo="CLASICO";
                                                                break;
                                                            case 2:
                                                                tipo="BUCEO";
                                                                break;
                                                            case 3:
                                                                tipo="PESCA";
                                                                break;
                                                            case 4:
                                                                tipo="VELOCIDAD";
                                                                break;
                                                        }
                                                    }else{
                                                        validar=false;
                                                        System.err.println("La opcion tiene que ser entre 1 y 4");
                                                        System.out.println("Introduce tipo de Yate:");
                                                    }
                                                }while(!validar);
                                            } catch (Exception e) {
                                                System.err.println(ERROR_INPUT+" |Error: "+e);
                                            }
                                    
                                        Yate yate=new Yate(numCamarotes,tipo,matricula,mEslora,añoFab);
                                        alquiler=new Alquiler(cliente,dias,yate);
                                        listadoDniAlquiler.put(dni, alquiler);
                                        System.out.println("El alquiler ha sido registrado correctamente");
                                        break;
                                }
                            }else{
                                validar=false;
                                System.err.println("La opcion tiene que ser 1 o 2");
                                System.out.println("Introduce opción:");
                            }
                        }while(!validar);
                    } catch (Exception e) {
                        System.err.println(ERROR_INPUT+" |Error: "+e);
                    }
                
                
            }else{
                System.out.println("Este cliente ya tiene un alquiler NO puede alquilar más.");
            }
        }
        
        private static void mostrarAlquiler(){
            //Introduce y valida DNI
            System.out.print("Introduce DNI del alquiler buscado:");
            String dni;
            do{
                dni=validarDNI(entrada.nextLine());
            }while(dni==null);
            
            if(!listadoDniAlquiler.containsKey(dni)){
                System.out.println("No existe el cliente indicado.");
            }else{
                System.out.println(listadoDniAlquiler.get(dni).getCliente().toString());
                System.out.println(listadoDniAlquiler.get(dni).getEmbarcacion().toString());
                System.out.println("PRECIO TOTAL DEL ALQUILER: "+listadoDniAlquiler.get(dni).getPrecio()+"€");
            }
        }
        
        private static void eliminarAlquiler(){
            //Introduce y valida DNI
            System.out.print("Introduce DNI del alquiler a eliminar:");
            String dni;
            do{
                dni=validarDNI(entrada.nextLine());
            }while(dni==null);
            if(!listadoDniAlquiler.containsKey(dni)){
                System.out.println("No existe el cliente indicado.");
            }else{
                listadoDniAlquiler.remove(dni);
                System.out.println("Alquiler del cliente: "+dni+" eliminado.");
            }
        }
        
        private static void mostrarAlquileres(){
            if(listadoDniAlquiler.size()>0){
                System.out.println("LISTADO DE ALQUILERES:");
                for(Map.Entry<String,Alquiler> alq: listadoDniAlquiler.entrySet()){
                    System.out.println(alq.getValue().toString());
                }
            }else{
                System.out.println("No hay alquileres.");
            }
        }
        
        
    
    /*
        METODOS VALIDAN DATOS INTRODUCIDOS POR CONSOLA
    */
    
    //METODO Verifica DNI
    private static String validarDNI(String dni){
        String dniDevuelto=null;
        Matcher mDni;
        try {
            //se comprueba si el atributo cumple o no el patron
            mDni=pDni.matcher(dni);
            if(!mDni.matches()){
                System.err.println(DNI_NO_VALIDO);
            }else{
                dniDevuelto=dni.toUpperCase();
            }
        } catch (Exception e) {
            System.err.println(DATO_NO_VALIDO+" |Error: "+e);
        }
        return dniDevuelto;
    }
        
    //METODO Verifica que el texto NO está vacio NI contiene espacios en blanco
    private static String validarTexto(String texto){
        String textoDevuelto=null;
        try {
            if(texto.isEmpty()||texto.contains(" ")){
                System.err.println(DATO_VACIO);
            }else{
                textoDevuelto=texto;
            }
        } catch (Exception e) {
            System.err.println(DATO_NO_VALIDO+" |Error: "+e);
        }
        return textoDevuelto;
    }  
    
    //METODO Verifica que es numero entero
    private static int validarEntero(String num){
        int numDevuelto=-1;
        try {
            numDevuelto=Integer.parseInt(num);
        } catch (Exception e) {
            System.err.println(DATO_NO_VALIDO+" |Error: "+e);
        }
        return numDevuelto;
    }  
    
    //METODO Verifica que es un double
    private static double validarDouble(String num){
        double numDevuelto=-1;
        try {
            numDevuelto=Double.parseDouble(num);
        } catch (Exception e) {
            System.err.println(DATO_NO_VALIDO+" |Error: "+e);
        }
        return numDevuelto;
    }
    
}