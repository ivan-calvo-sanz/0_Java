package ejercicio4;
import java.util.Scanner;

/**
 *
 * @author IVAN
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        System.out.println("Introduce numero:");
        boolean validarNum=false;
        int n=0;
        do{
            if(entrada.hasNextInt()){
                n=entrada.nextInt();
                if(n>1){
                    validarNum=true;
                }else{
                    System.out.println("El numero tiene que ser mayor que 1");
                }
            }else{
                System.out.println("El número tiene que ser un entero");
                entrada.next();
            }
        }while(!validarNum);
        
        conjeturaUllman(n);
    }
    
    public static void conjeturaUllman(int n){
        int parcial=n;
        System.out.print(n+",");
        while(parcial!=1){
            if(parcial%2==0){
                parcial/=2;
            }else{
                parcial=parcial*3+1;
            }
        System.out.print(parcial+",");
        }
    }
    
}