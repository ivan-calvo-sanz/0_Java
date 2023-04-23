package CuentaBancaria;
import java.util.Scanner;
/**
 * NUMEROS DE CUENTA DE PRUEBA COMPROBADOS 
 * 24313213564564311321
 * 54644643174654321456
 * 34343543744354643646
 * @author IVAN
 */
public class AplicacionCuentaBancaria {
    //CLASE principal (main)
    public static void main(String[] args) {
        String nomTitular;
        //Mediante la Clase Scanner instanciamos el objeto sc
        //para leer datos desde la consola
        Scanner sc=new Scanner(System.in);   
        
        //mientras el nomTitular no sea correcto sigue preguntando
        do{
            System.out.println("Introduce el nombre del titular (Max. 10 caracteres)");
            nomTitular=sc.nextLine();
            if (CuentaBancaria.ValidaNombre(nomTitular)==false){
                System.out.println("El nombre");
            }else{
                System.out.println("Nombre del titular: "+nomTitular+" es correcto");
            }
        }while(CuentaBancaria.ValidaNombre(nomTitular)==false); 
        
        System.out.println("Introduce el Código Cuenta Cliente (CCC))");
        String cCC=sc.nextLine();
        
        //Llama a los Métodos Estaticos ValidaCCC y ValidaDC para comprobar que el CCC es correcto
        if(CuentaBancaria.ValidaCCC(cCC)==true && CuentaBancaria.ValidaDC(cCC)==true){
            //Comprobado que CCC es correcto instanciamos el objeto cuenta de la clase CuentaBancaria
            //Pasamos por parámetro los atributos necesarios del Constructor
            CuentaBancaria cuenta=new CuentaBancaria(nomTitular,cCC,10000);
            System.out.println("SU Código Cuenta Cliente (CCC) ES CORRECTO.");
            System.out.println("¿Qué gestión quiere realizar?");
                System.out.println("(1) Ver el número de cuenta completo (CCC - Código Cuenta Cliente)");
                System.out.println("(2) Ver el titular de la cuenta");
                System.out.println("(3) Ver el código de la entidad");
                System.out.println("(4) Ver el código de la oficina");
                System.out.println("(5) Ver el número de la cuenta");
                System.out.println("(6) Ver los dígitos de control de la cuenta");
                System.out.println("(7) Realizar un ingreso en €");
                System.out.println("(8) Retirar efectivo");
                System.out.println("(9) Consultar saldo");
                System.out.println("(10) Salir de la aplicación");
                
                //Pide opción correcta mientras no esté entre las opciones
                int nOpcion=0;
                do{
                    nOpcion=Integer.parseInt(sc.nextLine());
                    if(nOpcion<1 || nOpcion>10){
                        System.out.println("Seleccione opcion correcta");
                    }
                }while(nOpcion<1 || nOpcion>10);
                //Para cada caso llamamos al Método correspondiente
                
                switch (nOpcion){
                    case 1:
                        //Llamada al Método GET
                        cuenta.getInfo();
                        break;  
                    case 2:
                        //Llamada al Método GET
                        cuenta.getTitular();
                        break; 
                    case 3:
                        //Llamada al Método GET
                        cuenta.getCodigoEntidad();
                        break; 
                    case 4:
                        //Llamada al Método GET
                        cuenta.getCodigoOficina(); 
                        break; 
                    case 5:
                        //Llamada al Método GET
                        cuenta.getCuenta();
                        break; 
                    case 6:
                        //Llamada al Método GET
                        cuenta.getDC();   
                        break; 
                    case 7:
                        System.out.println("¿Qué cantidad de € quiere ingresar?");
                        double ingreso=Double.parseDouble(sc.nextLine());
                        //Llamada al Método SET pasando por parámetro
                        cuenta.gestionaIngreso(ingreso);  
                        //Llamada al Método GET
                        cuenta.getSaldo();
                        break; 
                    case 8:
                        System.out.println("¿Qué cantidad de € quiere retirar?");
                        double retirada=Double.parseDouble(sc.nextLine());
                        //Llamada al Método SET pasando por parámetro
                        cuenta.gestionaRetiradaEfectivo(retirada); 
                        //Llamada al Método GET
                        cuenta.getSaldo();  
                        break; 
                    case 9:
                        //Llamada al Método GET
                        cuenta.getSaldo();
                        break; 
                    case 10:
                        System.out.println("¡¡¡HASTA PRONTO!!!");
                        System.out.println("*****La aplicación se ha cerrado*****");
                        //Salimos del switch
                        break;                        
                }
        } 
    }
    
}