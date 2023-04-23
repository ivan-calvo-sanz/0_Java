package prog02_ejer03;

/*
class ejerciciovariables
descripción: realiza ejercicio de Programacion de DAW
autor: Iván Calvo Sanz
*/
public class tarea_2_3 {

public static void main(String[] args) { 	// declaración de variables
	boolean casado=true;		
	final int MAXIMO=999999;	
	byte diasem=1;   		
	short diaanual=300;		
        char sexo='M';			 
        long miliseg=1298332800000l;	
        float totalfactura=10350.677734f;
        long poblacion=6775235741l;
        
        System.out.println("El valor de la variable casado es: "+casado);
        System.out.println("El valor de la variable MAXIMO es: "+MAXIMO);
        System.out.println("El valor de la variable diasem es: "+diasem);
        System.out.println("El valor de la variable diaanual es: "+diaanual);
        System.out.println("El valor de la variable miliseg es: "+miliseg);
        System.out.println("El valor de la variable totalfactura es: "+totalfactura);
        System.out.println("El valor de la variable poblacion es: "+poblacion);
        System.out.println("El valor de la variable sexo es: "+sexo);
        System.out.println("*************************");

        System.out.print("El valor de la variable casado es: "+casado+"\n");
        System.out.print("El valor de la variable MAXIMO es: "+MAXIMO+"\n");
        System.out.print("El valor de la variable diasem es: "+diasem+"\n");
        System.out.print("El valor de la variable diaanual es: "+diaanual+"\n");
        System.out.print("El valor de la variable miliseg es: "+miliseg+"\n");
        System.out.print("El valor de la variable totalfactura es: "+totalfactura+"\n");
        System.out.print("El valor de la variable poblacion es: "+poblacion+"\n");
        System.out.print("El valor de la variable sexo es: "+sexo+"\n");
        System.out.println("*************************");

        System.out.printf("El valor de la variable casado es: %b %n", casado);
        System.out.printf("El valor de la variable MAXIMO es: %d %n", MAXIMO);
        System.out.printf("El valor de la variable diasem es: %b %n", diasem);
        System.out.printf("El valor de la variable diaanual es: %h %n", diaanual);
        System.out.printf("El valor de la variable miliseg es: %d %n", miliseg);
        System.out.printf("El valor de la variable totalfactura es: %.1f %n", totalfactura);
        System.out.printf("El valor de la variable totalfactura es: %E %n", totalfactura);
        System.out.printf("El valor de la variable poblacion es: %d %n", poblacion);
        System.out.printf("El valor de la variable sexo es: %c %n", sexo);

}  // cierre main
}  // cierre class ejerciciovariables