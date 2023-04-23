package prog04_ejer02;

import java.util.Scanner;

public class PROG04_Ejer02 {

    public static void main(String[] args) {
        int mes,año;
        Scanner entrada=new Scanner(System.in);
        System.out.println("Introduce el mes:");
        mes=entrada.nextInt();
        System.out.println("Introduce el año:");
        año=entrada.nextInt();
        boolean bisiesto=false;
        
        if((año%4==0)&(año%100!=0)){
            bisiesto=true;
        }else if((año%4==0)&(año%400==0)){
            bisiesto=true;
        }
        
        switch (mes){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                System.out.println("El mes "+mes+" del año "+año+" tiene 31 dias");
                break;
            case 4: case 6: case 9: case 11:
                System.out.println("El mes "+mes+" del año"+año+" tiene 30 dias");
                break;
            case 2:
                if (bisiesto){
                    System.out.println("El mes "+mes+" del año "+año+" tiene 29 dias");
                }else{
                    System.out.println("El mes "+mes+" del año "+año+" tiene 28 dias");
                }   
                break;
        }           
    }
}