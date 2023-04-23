package prog05_ejer01;
import java.util.Scanner;

/**
NUMEROS DE CUENTA DE PRUEBA COMPROBADOS
24313213564564311321
*/

public class AplicacionCuentaBancaria {

    public static void main(String[] args) throws Exception{
        String ccc;
        String nombre;
        Scanner entrada=new Scanner(System.in);
        double cantidad;
        do{
            System.out.println("Introduce Nombre del titular:");
            nombre=entrada.nextLine();
            System.out.println("Introduce Código cuenta cliente:");
            ccc=entrada.nextLine();
        }while(CuentaBancaria.compruebaCCC(ccc)==false || CuentaBancaria.compruebaNombre(nombre)==false);
        CuentaBancaria Cuenta=new CuentaBancaria(nombre,ccc);
        
        //Menu//
        int opcion;
        
        System.out.println("Introduce opción del Menú:");
        System.out.println("1-Ver el número de cuenta completo.");
        System.out.println("2-Ver el titular de la cuenta.");
        System.out.println("3-Ver el código de la entidad.");
        System.out.println("4-Ver el código de la oficina.");
        System.out.println("5-Ver el número de la cuenta.");
        System.out.println("6-Ver los dígitos de control de la cuenta.");
        System.out.println("7-Realizar un ingreso.");
        System.out.println("8-Retirar efectivo.");
        System.out.println("9-Consultar saldo.");
        System.out.println("10-Salir de la aplicación.");
            
        do{    
            opcion=entrada.nextInt();
            switch (opcion){
                case 1:
                    Cuenta.muestraCCC();
                    System.out.println("*************************");
                    break;
                case 2:
                    Cuenta.muestraTitular();
                    System.out.println("*************************");
                    break;
                case 3:
                    Cuenta.muestraCodigoEntidad();
                    System.out.println("*************************");
                    break;
                case 4:
                    Cuenta.muestraCodigoOficina();
                    System.out.println("*************************");
                    break;
                case 5:
                    Cuenta.muestraNumeroCuenta();
                    System.out.println("*************************");
                    break;
                case 6:
                    Cuenta.muestraDC();
                    System.out.println("*************************");
                    break;
                case 7:
                    System.out.println("¿Qué cantidad desea ingresar?");
                    cantidad=entrada.nextDouble();
                    Cuenta.ingresar(cantidad);
                    System.out.println("*************************");
                    break;
                case 8:
                    System.out.println("¿Qué cantidad desea retirar?");
                    cantidad=entrada.nextDouble();
                    Cuenta.retirar(cantidad);
                    System.out.println("*************************");
                    break;
                case 9:
                    Cuenta.muestraSaldo();
                    System.out.println("*************************");
                    break;
                case 10:
                    System.out.println("¡HASTA PRONTO!");
                    System.out.println("***La aplicacion se ha cerrado***");
                    System.out.println("*************************");
                    break;
            }    
        }while(opcion!=10);           
    }   
}