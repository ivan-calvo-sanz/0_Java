package prog03_ejer02;

import java.util.Scanner;

public class PROG03_Ejer02 {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        
        Persona p=new Persona();
        System.out.println("Introduce nombre:");
        p.modificar_Nombre(entrada.nextLine());
        System.out.println("Introduce edad");
        p.modificar_edad(entrada.nextInt());
        System.out.println("Introduce altura");
        p.modificar_altura(entrada.nextFloat());
        
        System.out.println("El nombre es:"+p.obtener_Nombre());
        System.out.println("La edad es"+p.obtener_edad());
        System.out.println("La altura es:"+p.obtener_altura());   
    }   
}