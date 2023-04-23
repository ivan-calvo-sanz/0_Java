package prog04_ejer04;

import java.util.Scanner;

public class PROG04_Ejer04 {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        int edad;
        String nombre;
        do{
            System.out.println("Introduce su nombre:");
            nombre=entrada.next();
            System.out.println("Introduce su edad:");
            edad=entrada.nextInt();
        }while(edad<1);
        
        int edadFutura=edad+10;
        
        char categoria='A';
        if (edadFutura>25) categoria='B';
        if (edadFutura>50) categoria='C';     
        
        System.out.println(nombre+" pertenece a la categoria: "+categoria);
    }   
}