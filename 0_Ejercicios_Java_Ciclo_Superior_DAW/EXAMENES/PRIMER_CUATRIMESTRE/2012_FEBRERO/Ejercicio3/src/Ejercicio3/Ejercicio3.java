package Ejercicio3;
import java.util.Scanner;

/**
 *
 * @author IVAN
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        //System.out.println(""+factorial(0));
        Scanner entrada=new Scanner(System.in);
        boolean validarNum=false;
        int n=0, k=0;
        System.out.println("Introduce el valor de n");
        do{    
            if(entrada.hasNextInt()){
                n=entrada.nextInt();
                    if(n>0){
                        validarNum=true;
                    }else{
                        System.out.println("Debe introducir un numero mayor que 0");
                    }
            }else{
                System.out.println("El numero tiene que ser un int. Intentelo de nuevo.");
                entrada.next();
            }
        }while(!validarNum);
        validarNum=false;
        System.out.println("Introduce el valor de k");
        do{
            if(entrada.hasNextInt()){
                k=entrada.nextInt();
                if(k>0){
                    validarNum=true;
                }else{
                    System.out.println("Debe introducir un numero mayor que 0");
                }
            }else{
                System.out.println("El numero tiene que ser un int. Intentelo de nuevo.");
                entrada.next();
            }
        }while(!validarNum);
        
        System.out.println("El Coeficiente Binomial de: ("+n+","+k+")="+coeficienteBinomial(n,k));
    }
    
    public static int factorial(int n){
        int factorial=1;
        if(n==0){
            factorial=1;
        }else{
            for(int i=n;i>1;i--){
                factorial*=i;
            }
        }
        return factorial;
    }
    
    public static int coeficienteBinomial(int n,int k){
        return factorial(n)/(factorial(k)*factorial(n-k));
    }
            
}