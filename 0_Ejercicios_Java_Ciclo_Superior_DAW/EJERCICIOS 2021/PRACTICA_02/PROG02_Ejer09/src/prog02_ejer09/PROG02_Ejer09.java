package prog02_ejer09;

import java.util.Scanner;

public class PROG02_Ejer09 {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        System.out.println("Introduce numero de 5 digitos: ");
        int num=entrada.nextInt();
        
        String cadena=String.valueOf(num);
        System.out.print(   cadena.substring(0, 1)+" "+
                            cadena.substring(1, 2)+" "+
                            cadena.substring(2, 3)+" "+
                            cadena.substring(3, 4)+" "+
                            cadena.substring(4, 5)
                        );
    }
}