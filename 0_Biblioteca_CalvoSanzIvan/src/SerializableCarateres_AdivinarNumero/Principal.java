package SerializableCarateres_AdivinarNumero;

import DatosPorConsola.*;
import java.io.*;
import java.util.Scanner;

public class Principal {

    static Scanner entrada = new Scanner(System.in);
    static final String ERROR_INPUT = "Dato introducido erroneo";
    static final String MENU_PRINCIPAL
            = "\n************************\n"
            + "**BIENVENIDO AL JUEGO DE ADIVINAR NUMEROS**\n"
            + "************************\n"
            + "1-Jugar de modo interactivo\n"
            + "2-Simular juego\n"
            + "3-Mostrar simulaciones\n"
            + "4-Eliminar fichero de simulaciones\n"
            + "5-Salir de la aplicación\n"
            + "\nIntroduzca la opción deseada (1-5) ";

    /**
     * METODO main genera el menu del programa
     */
    public static void main(String[] args) {
        File f = new File("juego.txt");

        System.out.print(MENU_PRINCIPAL);
        boolean validar;
        int opcion;

        do {  //para salir del programa               
            do {
                opcion = PedidorDeDatos.pedirInt("");
            } while (Validar.validarEntero(opcion) == -1);

            validar = true;
            switch (opcion) {
                case 1:
                    modoIteractivo();
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 2:
                    simularJuego(f);
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 3:
                    mostrarSimulaciones(f);
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 4:
                    eliminarArchivo(f);
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 5:
                    System.out.println("***La aplicacion se ha cerrado***");
                    break;
                default:
                    validar = false;
                    System.out.println("La opcion tiene que ser entre 1 y 5");
                    System.out.println("Introduce opción del Menú:");
            }
        } while (opcion != 5 || !validar);
    }

    /**
     * METODO case 1
     */
    private static void modoIteractivo() {
        int numMaxOculto;
        do {
            numMaxOculto = PedidorDeDatos.pedirInt("Número máximo a adivinar:");
        } while (Validar.validarNumMaxOculto(numMaxOculto) == -1);

        Juego juego = new Juego(numMaxOculto, 1);
        Jugador jugador = new Jugador(1, juego);

        System.out.println("JUEGO PREPARADO");

        int numJugado, limiteInferior = 0, limiteSuperior = 0;
        do {
            do {
                numJugado = PedidorDeDatos.pedirInt("Número a jugar:");
            } while (Validar.validarEntero(numJugado) == -1);

            if (jugador.intento(numJugado, limiteInferior, limiteSuperior, false) == -1) {
                System.out.println("El nº buscado es MAYOR");
            } else if (jugador.intento(numJugado, limiteInferior, limiteSuperior, false) == 1) {
                System.out.println("El nº buscado es MENOR");
            } else if (jugador.intento(numJugado, limiteInferior, limiteSuperior, false) == 0) {
                System.out.println("ACERTATE!!!");
            }
        } while (jugador.intento(numJugado, limiteInferior, limiteSuperior, false) != 0);

    }

    /**
     * METODO case 2
     */
    private static void simularJuego(File f) {
        int numMaxOculto;
        do {
            numMaxOculto = PedidorDeDatos.pedirInt("Número máximo a adivinar:");
        } while (Validar.validarNumMaxOculto(numMaxOculto) == -1);

        int numJugadores;
        do {
            numJugadores = PedidorDeDatos.pedirInt("Número de Jugadores:");
        } while (Validar.validarEntero(numJugadores) == -1);

        Juego juego = new Juego(numMaxOculto, numJugadores);
        Jugador[] jugadores = new Jugador[numJugadores];
        for (int i = 0; i < numJugadores; i++) {
            jugadores[i] = new Jugador((i + 1), juego);
        }

        int resultado, turno, limiteInferior = 10, limiteSuperior = numMaxOculto;
        String imp;

        generarArchivo(f);

        try {
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\n** SIMULACIÓN DE ADIVINAR EL NÚMERO" + "\n");
            imp = "EL NUMERO A ADIVINAR ES: " + juego.getNumOculto() + "\n";
            System.out.println(imp);
            bw.write(imp);

            do {
                turno = juego.getTurno();
                resultado = jugadores[turno - 1].intento(0, limiteInferior, limiteSuperior, true);

                imp = "Jugador:" + turno + " Juega:" + jugadores[turno - 1].getUltNumJugado() + "\n";
                System.out.print(imp);
                bw.write(imp);

                if (resultado == -1) {
                    limiteInferior = jugadores[turno - 1].getUltNumJugado();
                    imp = "El nº buscado es MAYOR, entre [" + limiteInferior + "," + limiteSuperior + "]" + "\n";
                    System.out.print(imp);
                    bw.write(imp);
                } else if (resultado == 1) {
                    limiteSuperior = jugadores[turno - 1].getUltNumJugado();
                    imp = "El nº buscado es MENOR, entre [" + limiteInferior + "," + limiteSuperior + "]" + "\n";
                    System.out.print(imp);
                    bw.write(imp);
                } else if (resultado == 0) {
                    imp = "ACERTATE!!!" + "\n" + "EL JUGADOR " + juego.getGanador() + " ES EL GANADOR!!!" + "\n";
                    System.out.print(imp);
                    bw.write(imp);
                    break;
                }
            } while (resultado != 0);

            bw.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("Error en la operación de Entrada/salida de datos |Error: " + e);
        }

    }

    /**
     * METODO case 3
     */
    private static void mostrarSimulaciones(File f) {
        String linea = "";
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            do {
                linea = br.readLine();
                if (linea != null) {
                    System.out.println(linea);
                }
            } while (linea != null);
            fr.close();
            br.close();

        } catch (FileNotFoundException e) {
            System.err.println("Archivo no existe |Error: " + e);
        } catch (IOException e) {
            System.err.println("Error en la operación de Entrada/salida de datos |Error: " + e);
        }
    }

    /**
     * METODO case 4
     */
    private static void eliminarArchivo(File f) {
        try {
            if (f.exists()) {
                f.delete();
                System.out.println("El fichero se ha borrado correctamente.");
            } else {
                System.out.println("El fichero NO existe.");
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al borrar el archivo |Error: " + e);
        }

    }

    private static void generarArchivo(File f) {
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al generar el archivo: " + e);
        }
    }

}
