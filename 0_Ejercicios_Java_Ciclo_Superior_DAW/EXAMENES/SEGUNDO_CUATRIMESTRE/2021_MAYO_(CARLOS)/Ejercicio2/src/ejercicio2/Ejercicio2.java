package ejercicio2;

import java.util.Scanner;

/**
 *
 * @author IVAN
 */
public class Ejercicio2 {
    static Scanner entrada=new Scanner(System.in);   
    static final String DATO_NO_VALIDO="ERROR: El dato introducido no es válido.\nVuelva a introducir el dato: ";

    public static void main(String[] args) {
        BBDD.conectarBBDD();
        System.out.println("Introduce numero de Empleado:");
        //Introduce y valida un nº entero
        int num;
        do{
            num=validarEntero(entrada.nextLine());
        }while(num==-1);
        
        String[] resultado=BBDD.devuelveEmpleado(num);
        if(resultado.length>0){
            System.out.println("APELLIDO:"+resultado[0]);
            System.out.println("OFICIO:"+resultado[1]);
            System.out.println("SALARIO:"+resultado[2]+"€");
            System.out.println("NOMBRE DE DEPARTAMENTO:"+resultado[3]);
        }else{
            System.out.println("El numero:"+num+" NO existe como Empleado");
        }    
        BBDD.cerrarConexion();
    }
    
    //METODO Verifica que es numero entero
    private static int validarEntero(String num){
        int numDevuelto=-1;
        try {
            numDevuelto=Integer.parseInt(num);
        } catch (Exception e) {
            System.err.println(DATO_NO_VALIDO+" |Error: "+e);
        }
        return numDevuelto;
    }  
    
}