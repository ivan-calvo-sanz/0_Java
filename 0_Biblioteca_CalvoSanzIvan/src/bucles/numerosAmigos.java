package bucles;

import DatosPorConsola.*;

public class numerosAmigos {

    /*Realiza un programa en java que sea capaz de comprobar si dos números son amigos. 
    Para ello hay que comprobar que la suma de todos los divisores propios del primer número 
    (sus divisores sin contar con el) es el segundo número, y que la suma de todos los divisores propios 
    del segundo número (sus divisores sin contar con él) es el primer número. Por ejemplo:
    Los divisores propios de 220 son 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 y 110. Su suma es 284.
    Los divisores propios de 284 son 1, 2, 4, 71 y 142. Su suma es 220.
    Por lo tanto, 220 y 284 son amigos.
     */
    
    public static void main(String[] args) {
        int num1, num2, suma1 = 0, suma2 = 0;
        do {
            num1 = PedidorDeDatos.pedirInt("Primer Número:");
        } while (Validar.validarEntero(num1) == -1);

        do {
            num2 = PedidorDeDatos.pedirInt("Segundo Número:");
        } while (Validar.validarEntero(num2) == -1);

        System.out.print("Los divisores propios de " + num1 + " son ");
        for (int i = 1; i < num1 - 1; i++) {
            if (num1 % i == 0) {
                suma1 += i;
                System.out.print(i + ",");
            }
        }
        System.out.println(" Su suma es " + suma1);

        System.out.print("Los divisores propios de " + num2 + " son ");
        for (int i = 1; i < num2 - 1; i++) {
            if (num2 % i == 0) {
                suma2 += i;
                System.out.print(i + ",");
            }
        }
        System.out.println(" Su suma es " + suma2);

        if (suma1 == num2 && suma2 == num1) {
            System.out.println(num1 + " y " + num2 + " son amigos");
        } else {
            System.out.println(num1 + " y " + num2 + " NO son amigos");
        }

    }

}
