package prog04_ejer03;

import java.util.Scanner;

public class PROG04_Ejer03 {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        System.out.println("Introduce numero a evaluar");
        int num=entrada.nextInt();
        int i=2;       
        int result=num;
        
        while(i<=num){
            while((esPrimo(i))&((result%i)==0)){
                System.out.print(i+"*");
                result=result/i;
            }
            i++;
        }    
        System.out.println("1="+num);
    }
    
    public static boolean esPrimo (int num){
        boolean primo=true;
        int i=2;
            while(i<num){
                if((num%i)==0){
                    primo=false;
                }
                i++;
            }
        return primo;
    }
}