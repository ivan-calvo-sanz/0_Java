package ejercicio5;
import java.util.Scanner;

/**
 *
 * @author IVAN
 */
public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        System.out.println("Introduce String a cifrar:");
        String aCifrar=entrada.next();
        System.out.println("El cifrado de: "+aCifrar+" es: "+cifradoCesar(aCifrar));
    }
    
    public static String cifradoCesar(String cadenaACifrar){
        String cadenaCifrada="";
        int letraACifrar;
        int dispersion=0;
        for(int i=0;i<cadenaACifrar.length();i++){
            letraACifrar=(char)cadenaACifrar.toUpperCase().charAt(i);
            if(letraACifrar+3>90){
                dispersion=letraACifrar+3-90;
                cadenaCifrada+=(char)(64+dispersion);
            }else{
                cadenaCifrada+=(char)(letraACifrar+3);
            }
        }
        return cadenaCifrada;
    }
    
}