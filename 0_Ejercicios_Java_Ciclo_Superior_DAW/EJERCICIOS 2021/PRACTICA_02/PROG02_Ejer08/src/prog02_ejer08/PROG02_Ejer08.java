package prog02_ejer08;

import java.util.Scanner;

public class PROG02_Ejer08 {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        float num1, num2;
        System.out.println("Introduce el primer numero:");
        num1=entrada.nextFloat();
        System.out.println("Introduce el segundo numero:");
        num2=entrada.nextFloat();
        float suma=num1+num2;
        float resta=num1-num2;
        float mult=num1*num2;
        float div=num1/num2;
        double potencia=Math.pow(num1, 2);
        double raiz=Math.sqrt(num1);
        
        System.out.println("El primer numero es: "+num1);
        System.out.println("El segundo numero es: "+num2);
        System.out.println("x + y = "+suma);
        System.out.println("x - y = "+resta);
        System.out.println("x * y = "+mult);
        System.out.println("x / y = "+div);
        System.out.println("x ^ 2 = "+potencia);
        System.out.println("Raiz cuadrada de x = "+raiz);        
    }
}