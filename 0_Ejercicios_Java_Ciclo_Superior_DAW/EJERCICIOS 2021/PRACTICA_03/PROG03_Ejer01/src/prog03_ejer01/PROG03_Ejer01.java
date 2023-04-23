package prog03_ejer01;

import java.util.Scanner;

public class PROG03_Ejer01 {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        String nombre;
        System.out.println("Introduce nombre del usuario");
        nombre=entrada.nextLine();
        
        Persona p=new Persona();
        p.cambia_Nombre(nombre);
        
        System.out.println("El nombre es: "+p.consulta_Nombre());
    }
}