package ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author IVAN
 */
public class Main {

        static Scanner entrada=new Scanner(System.in);   
        static final String ERROR_INPUT="Dato introducido erroneo";
        static final String MENU_PRINCIPAL
            = "\n************************\n"
            + "*****MENU PRINCIPAL*****\n"
            + "************************\n"
            + "1-AÑADIR TRANSPORTES (SIN SOLICITAR DATOS POR PANTALLA)\n"
            + "2-LISTAR FLOTA\n"
            + "3-LISTAR FLOTA ACTIVA\n"
            + "4-BUSCAR POR MATRICULA\n"
            + "5-AÑADIR VIAJE\n"
            + "6-AÑADIR MANTENIMIENTO\n"
            + "7-COMPROBAR GASTOS/INGRESOS\n"
            + "8-SALIR\n";
        static final String DATO_NO_VALIDO="ERROR: El dato introducido no es válido.\nVuelva a introducir el dato: ";
        static FlotaTransporte flota;

    public static void main(String[] args) {
        flota=new FlotaTransporte();
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
                    if(opcion>0&&opcion<9){
                        validar=true;
                        switch (opcion){
                            case 1:
                                anadirTransportes();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 2:
                                flota.listarFlota();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 3:
                                flota.listarFlotaActiva();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 4:
                                buscarMatricula();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 5:
                                anadirViaje();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 6:
                                anadirMantenimiento();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 7:
                                balanceIngresosGastos();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 8:
                                System.out.println("***La aplicacion se ha cerrado***");
                                break;
                        }
                    }else{
                        validar=false;
                        System.err.println("La opcion tiene que ser entre 1 y 8");
                        System.out.println("Introduce opción del Menú:");
                    }
                }while(opcion!=8||!validar);
            } catch (Exception e) {
                System.err.println(ERROR_INPUT+" |Error: "+e);
            }

    }
    
    //CASO 1:
    private static void anadirTransportes(){
        System.out.print("¿Cuantos Transportes quiere añadir?: ");
                int num;
                do{
                    num=validarEntero(entrada.nextLine());
                }while(num==-1);
        for(int i=0;i<num;i++){
            flota.anadirTransportes();
        }
        System.out.println("Transportes añadidos");
    }
    
    //CASO 2:
    private static void buscarMatricula(){
        System.out.print("Introduce matricular a buscar: ");
                int m;
                do{
                    m=validarEntero(entrada.nextLine());
                }while(m==-1);
        String matricula=String.valueOf(m);
                
        int i=flota.buscaMatricula(matricula);
        if(i!=-1){
            System.out.println(flota.getTransportes().get(i).toString());
        }else{
            System.out.println("La matrícula NO existe");
        }
    }
        
        
      //CASO 5:  
      private static void anadirViaje(){
          ArrayList<Transporte> transportes=flota.getTransportes();
          System.out.print("Introduce matricula del Tansporte al que añadir viaje: ");
                int m;
                do{
                    m=validarEntero(entrada.nextLine());
                }while(m==-1);
                String matricula=String.valueOf(m);
 
              System.out.print("Introduce kilometros de la ruta: ");
                int kms;
                do{
                    kms=validarEntero(entrada.nextLine());
                }while(kms==-1);  
                
              System.out.print("Introduce gasto de combustible: ");
                int gasto;
                do{
                    gasto=validarEntero(entrada.nextLine());
                }while(gasto==-1);
                
            boolean estado=false;
            for(int i=0;i<transportes.size();i++){
                if(transportes.get(i).getMatricula().equalsIgnoreCase(matricula)){
                    estado=transportes.get(i).isEnFuncionamiento();
                }
            }
            
                if(estado){
                    int result=flota.añadirViaje(matricula,kms,gasto);
                    if(result==-1){
                        System.out.println("La matrícula NO existe");
                    }else{
                        System.out.println("Nuevo viaje añadido.");
                    }   
                }else{
                    System.out.println("Viaje NO añadido. El transporte NO está en funcionamiento.");
                }
      }
      
            //CASO 6:  
      private static void anadirMantenimiento(){
          ArrayList<Transporte> transportes=flota.getTransportes();
          System.out.print("Introduce matricula del Tansporte al que añadir Mantenimiento: ");
                int m;
                do{
                    m=validarEntero(entrada.nextLine());
                }while(m==-1);
                String matricula=String.valueOf(m);
 
                System.out.print("Introduce gasto de Mantenimiento: ");
                double gasto;
                do{
                    gasto=validarDouble(entrada.nextLine());
                }while(gasto==-1);
                
            boolean estado=false;
            for(int i=0;i<transportes.size();i++){
                if(transportes.get(i).getMatricula().equalsIgnoreCase(matricula)){
                    estado=transportes.get(i).isEnFuncionamiento();
                }
            }
            
                if(estado){
                    int result=flota.anadirMantenimiento(matricula,gasto);
                    if(result==-1){
                        System.out.println("La matrícula NO existe");
                    }else{
                        System.out.println("Mantenimiento añadido.");
                    }   
                }else{
                    System.out.println("Mantenimiento NO añadido. El transporte NO está en funcionamiento.");
                }
      }
      
      //CASO 7:
      private static void balanceIngresosGastos(){
          double gastosEstimados=flota.gastosEstimados();
          double gastosReales=flota.gastosReales();
          double ingresoTotal=flota.ingresosTotal();
          double beneficio=ingresoTotal-gastosReales;
          
          System.out.printf("GASTOS (Etimados | Reales): %.2f | %.2f \n",gastosEstimados,gastosReales);
          System.out.printf("INGRESOS: %.2f \n",ingresoTotal);
          System.out.printf("BENEFICIO (Ingreso - Gasto Real): %.2f",beneficio);
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
    
    /*
    //METODO formatea decimales de un double
    public static Double formatearDecimales(Double numero, Integer numeroDecimales) {
        return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
    }
    */

}