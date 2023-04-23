package prog02_ejer07;

import java.util.Scanner;

public class PROG02_Ejer07 {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        float c1,c2,result;
        System.out.println("Introduce C1:");
        c1=entrada.nextFloat();
        System.out.println("Introduce C2:");
        c2=entrada.nextFloat();
        result=((-c2)/(c1));
        
        System.out.println("La ecuacion es: "+c1+"*X+"+c2+"=0");
        System.out.println("X="+result);
    }
}