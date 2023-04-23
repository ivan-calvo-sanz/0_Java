package prog02_ejer05;

import java.util.Scanner;

public class PROG02_Ejer05 {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        int num1,num2;
        System.out.println("Introduce primer numero");
        num1=entrada.nextInt();
        System.out.println("Introduce segundo numero");
        num2=entrada.nextInt();
        
        System.out.println("num1 es:"+num1);
        System.out.println("num2 es:"+num2);
        
        if(num1%num2==0){
            System.out.println("num1 es multiplo de num2: ");
        }else{
            System.out.println("num1 NO es multiplo de num2: ");
        }
    }   
}