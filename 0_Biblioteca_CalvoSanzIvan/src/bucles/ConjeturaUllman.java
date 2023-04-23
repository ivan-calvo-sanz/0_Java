package bucles;
import java.util.Scanner;

/**
 *
 * @author IVAN
 */

/*
Implementa un algoritmo en el que dado un entero n>1 leído por teclado, calcule e imprima los elementos correspondientes a la Conjetura de Ullman (en honor al matemático S. Ullman). La conjetura consiste en lo siguiente:
•	Empieza con cualquier entero positivo.
•	Si es par, se divide entre 2; si es impar se multiplica por 3 se agrega 1.
•	Se itera hasta obtener el número 1.
Al final se obtendrá el número 1, independientemente del entero inicial. Por ejemplo, cuando el entero inicial es 26, la secuencia será:
		26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1
*/

public class ConjeturaUllman {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        System.out.println("Introduce numero:");
        boolean validarNum=false;
        int n=0;
        do{
            if(entrada.hasNextInt()){
                n=entrada.nextInt();
                if(n>1){
                    validarNum=true;
                }else{
                    System.out.println("El numero tiene que ser mayor que 1");
                }
            }else{
                System.out.println("El número tiene que ser un entero");
                entrada.next();
            }
        }while(!validarNum);
        
        conjeturaUllman(n);
    }
    
    public static void conjeturaUllman(int n){
        int parcial=n;
        System.out.print(n+",");
        while(parcial!=1){
            if(parcial%2==0){
                parcial/=2;
            }else{
                parcial=parcial*3+1;
            }
        System.out.print(parcial+",");
        }
    }
    
}