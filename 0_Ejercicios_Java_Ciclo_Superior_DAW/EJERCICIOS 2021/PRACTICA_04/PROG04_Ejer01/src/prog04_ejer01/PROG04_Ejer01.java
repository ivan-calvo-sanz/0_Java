package prog04_ejer01;

import java.util.Scanner;

public class PROG04_Ejer01 {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        System.out.println("Introduce el numero a evaluar:");
        int num=entrada.nextInt();
        
        if(num%2==0){
            System.out.println("El número es PAR");
        }else{
            System.out.println("El número NO es PAR");
        }
    }
}