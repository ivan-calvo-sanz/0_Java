package ejercicio2;
import java.util.Scanner;

/**
 * 
 * @author IVAN
 */

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        int opcion=0;
        double num=0;
        boolean numeroValido;
        do{
           //lectura de un valor Double valido
           numeroValido=false;
           do{
               System.out.println("Introduzca un numero double válido: ");
                    if(entrada.hasNextDouble()){
                        num=entrada.nextDouble();
                        numeroValido=true;
                    }else{
                        System.out.println("Numero double NO válido. Vuelva a ntentarlo");
                        entrada.next();
                    }
            }while(!numeroValido); 
            //mostramos el menú de opciones
            numeroValido=false;
            System.out.println("¿Qué desea hacer con el numero?");
            System.out.println("(1) Obtener parte entera");
            System.out.println("(2) Obtener parte decimal");
            System.out.println("(3) Salir de la aplicación");
            do{
                System.out.println("Introduce que opción desea realizar");
                if(entrada.hasNextInt()){
                    opcion=entrada.nextInt();
                    if(opcion>0&&opcion<4){
                        numeroValido=true;
                    }else{
                        System.out.println("Debe introducir un valor entre 1 y 3");
                    }
                }else{
                    System.out.println("Número erroeno. Vuelva a intentarlo");
                    entrada.nextInt();
                }
            }while(!numeroValido);
            //Según la opcion introducida hacemos la accion deseada
                switch(opcion){
                    case 1:
                        System.out.println("La parte entera de "+num+" es "+getParteEntera(num));
                        break;
                    case 2:
                        System.out.println("La parte decimal de "+num+" es "+getParteDecimal(num));
                        break;
                    case 3:
                        System.out.println("Aplicación cerrada!");
                        break;
                }
        }while(opcion!=3);
    }
    
    private static int getParteEntera(double numero){
        String snumero=String.valueOf(numero);
        int posicionComa=snumero.indexOf('.');
        int parteEntera=Integer.valueOf(snumero.substring(0, posicionComa));
        return parteEntera;
    }
    
    private static int getParteDecimal(double numero){
        String snumero=String.valueOf(numero);
        int posicionComa=snumero.indexOf('.');
        int parteDecimal=Integer.valueOf(snumero.substring(posicionComa+1));
        return parteDecimal;
    }
    
}