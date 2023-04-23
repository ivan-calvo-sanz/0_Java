package ejercicio2;
import java.util.Scanner;

/*
class Ejercicio2
descripción: realiza ejercicio 2 del examen Primer Parcial de Febrero 2020
autor: Iván Calvo Sanz
ejemplo de numeros amigos: 220 y 284
divisores propios de 220 son 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 y 110. Su suma es 284
divisores propios de 284 son 1, 2, 4, 71 y 142. Su suma es 220
*/

public class Ejercicio2 {

    public static void main(String[] args) throws Exception{
        Scanner entrada=new Scanner(System.in);
        System.out.println("Introduce primer numero: ");
        int num1=entrada.nextInt();
        System.out.println("Introduce segundo numero: ");
        int num2=entrada.nextInt();
        
        int sum1=calSumaDivisores(num1);
        int sum2=calSumaDivisores(num2);
        
        System.out.println();
        if(sum1==num2 && sum2==num1){
            System.out.println(num1+" y "+num2+" son amigos!");
        }else{
            System.out.println(num1+" y "+num2+" NO son amigos.");
        }
    }   
    
    private static int calSumaDivisores(int num){
        int suma=0;
        System.out.print("Los divisores propios de "+num+" son: ");
        for (int i=1;i<((num/2)+1);i++){
            if(num%i==0){
                System.out.print(i+" ");
                suma=suma+i;
            } 
        }
        System.out.println();
        return suma;
    }
}