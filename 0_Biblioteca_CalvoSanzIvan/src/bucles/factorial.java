package bucles;
import java.util.Scanner;

/**
 *
 * @author IVAN
 */

/*
Realizaremos un programa que calcule el valor de los coeficientes binomiales. Los coeficientes binomiales son ampliamente utilizados en distintas ramas de las matemáticas, como por ejemplo la estadística. Se representan como un binomio (dos valores) entre paréntesis (similar a una fracción pero sin la barra horizontal). La fórmula para calcular el coeficiente binomial de dos valores n y k, lo representaremos como (n,k) es la siguiente:
 
donde ! representa el factorial y n y k mayores o iguales que 0.
Para realizar este ejercicio sigue los siguientes pasos:
a)	Se implementará una función que calcule el factorial de un número. El número se pasará por parámetro y retornará el factorial calculado. La declaración de la función será como sigue:	public static int factorial(int n)
El factorial de un número n, n! Se calcula de la siguiente manera:
	1, si n=0
	n*n-1…*1, si n>0
Por ejemplo, el factorial de 3 -> 3!=3*2*1=6
b)	Se implementará una función que calcule el coeficiente binomial. Los valores de n y k se pasarán por parámetro y la función devolverá el coeficiente calculado. Se utilizará la función factorial() para realizar este cálculo. La declaración de la función será como sigue:			public static int coeficienteBinomial(int n, int k)
c)	El programa principal (main) deberá pedir al usuario que introduzca os valores de n y k (mayor o igual que 0). Se calculará el valor del binomio llamando a la función coeficienteBinomial() y se mostrarán los resultados obtenidos por pantalla.
*/

public class factorial {

    public static void main(String[] args) {
        //System.out.println(""+factorial(0));
        Scanner entrada=new Scanner(System.in);
        boolean validarNum=false;
        int n=0, k=0;
        System.out.println("Introduce el valor de n");
        do{    
            if(entrada.hasNextInt()){
                n=entrada.nextInt();
                    if(n>0){
                        validarNum=true;
                    }else{
                        System.out.println("Debe introducir un numero mayor que 0");
                    }
            }else{
                System.out.println("El numero tiene que ser un int. Intentelo de nuevo.");
                entrada.next();
            }
        }while(!validarNum);
        validarNum=false;
        System.out.println("Introduce el valor de k");
        do{
            if(entrada.hasNextInt()){
                k=entrada.nextInt();
                if(k>0){
                    validarNum=true;
                }else{
                    System.out.println("Debe introducir un numero mayor que 0");
                }
            }else{
                System.out.println("El numero tiene que ser un int. Intentelo de nuevo.");
                entrada.next();
            }
        }while(!validarNum);
        
        System.out.println("El Coeficiente Binomial de: ("+n+","+k+")="+coeficienteBinomial(n,k));
    }
    
    public static int factorial(int n){
        int factorial=1;
        if(n==0){
            factorial=1;
        }else{
            for(int i=n;i>1;i--){
                factorial*=i;
            }
        }
        return factorial;
    }
    
    public static int coeficienteBinomial(int n,int k){
        return factorial(n)/(factorial(k)*factorial(n-k));
    }
            
}