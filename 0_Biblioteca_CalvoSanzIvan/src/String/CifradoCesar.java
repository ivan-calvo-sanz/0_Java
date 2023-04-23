package String;

/*
El cifrado César es una técnica de codificación que consiste en trasladar las palabras 
de un texto a cifrar un número determinado de posiciones en el alfabeto, 
teniendo en cuenta que el número de posiciones viene dado por el usuario.
Por ejemplo, si hay que desplazar las letras 3 posiciones, la a se sustituirá 
por la d, la b por la e, la c por la f, etc.
*/

public class CifradoCesar {

    public static String cifradoCesar(String con, int clave) {
        String conCifrado = "";
        char letra, letraCifrada;
        int dif;

        for (int i = 0; i < con.length(); i++) {
            letra = (char) (con.charAt(i));
            if (letra > 64 && letra < 91) {
                if ((letra + clave) > 90) {
                    dif = letra + clave - 90;
                    letraCifrada = (char) (dif + 64);
                } else {
                    letraCifrada = (char) (letra + clave);
                }
                conCifrado += letraCifrada;
            }

            if (letra > 96 && letra < 123) {
                if ((letra + clave) > 122) {
                    dif = letra + clave - 122;
                    letraCifrada = (char) (dif + 96);
                } else {
                    letraCifrada = (char) (letra + clave);
                }
                conCifrado += letraCifrada;
            }
        }
        return conCifrado;
    }

    public static String desCifradoCesar(String con, int clave) {
        String conDesCifrado = "";
        char letra, letraDesCifrada;
        int dif;

        for (int i = 0; i < con.length(); i++) {
            letra = (char) (con.charAt(i));
            if (letra > 64 && letra < 91) {
                if ((letra - clave) < 65) {
                    dif = letra + clave - 65;
                    letraDesCifrada = (char) (91 - dif);
                } else {
                    letraDesCifrada = (char) (letra - clave);
                }
                conDesCifrado += letraDesCifrada;
            }

            if (letra > 96 && letra < 123) {
                if ((letra - clave) < 97) {
                    dif = letra + clave - 97;
                    letraDesCifrada = (char) (123 - dif);
                } else {
                    letraDesCifrada = (char) (letra - clave);
                }
                conDesCifrado += letraDesCifrada;
            }
        }
        return conDesCifrado;
    }

}