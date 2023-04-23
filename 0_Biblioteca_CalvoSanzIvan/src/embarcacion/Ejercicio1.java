package embarcacion;

import DatosPorConsola.PedidorDeDatos;
import DatosPorConsola.Validar;
import embarcacion.Yate.TipoYate;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {

    static Scanner entrada = new Scanner(System.in);
    static final String ERROR_INPUT = "Dato introducido erroneo";
    static final String MENU_PRINCIPAL
            = "\n************************\n"
            + "*****MENU PRINCIPAL*****\n"
            + "************************\n"
            + "1-ALQUILAR UN AMARRE\n"
            + "2-BUSCAR LOS DATOS DE UN ALQUILER\n"
            + "3-ELIMINAR UN ALQUILER\n"
            + "4-LISTAR TODOS LOS ALQUILERES\n"
            + "5-SALIR\n"
            + "\nIntroduce opción del Menú: ";

    public static void main(String[] args) {

        ArrayList<Alquiler> alquileres = new ArrayList<Alquiler>();

        System.out.print(MENU_PRINCIPAL);
        boolean validar;
        int opcion;
        do { //para salir del programa 
            do {
                opcion = PedidorDeDatos.pedirInt("");
            } while (Validar.validarEntero(opcion) == -1);
            validar = true;
            switch (opcion) {
                case 1:
                    alquilarAmarre(alquileres);
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 2:
                    buscarAlquiler(alquileres);
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 3:
                    eliminarAlquiler(alquileres);
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 4:
                    listarAlquiler(alquileres);
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
     *
     */
    private static void alquilarAmarre(ArrayList<Alquiler> alquileres) {
        boolean valido = true;
        String nombre;
        do {
            nombre = PedidorDeDatos.pedirString("Nombre:");
        } while (!Validar.validarString(nombre));
        String dni;
        do {
            dni = PedidorDeDatos.pedirString("DNI:");
        } while (!Validar.validarString(dni));
        Cliente cliente = new Cliente(nombre, dni);

        for (int i = 0; i < alquileres.size(); i++) {
            if (alquileres.get(i).getCliente().getDni().equalsIgnoreCase(dni)) {
                valido = false;
            }
        }

        if (valido) {
            int numDias;
            do {
                numDias = PedidorDeDatos.pedirInt("Número de dias:");
            } while (Validar.validarEntero(numDias) == -1);

            String matricula;
            do {
                matricula = PedidorDeDatos.pedirString("Matricula:");
            } while (!Validar.validarString(matricula));
            int metrosEslora;
            do {
                metrosEslora = PedidorDeDatos.pedirInt("Metros de eslora:");
            } while (Validar.validarEntero(metrosEslora) == -1);
            int anioFab;
            do {
                anioFab = PedidorDeDatos.pedirInt("Año de Fabricación:");
            } while (Validar.validarEntero(anioFab) == -1);

            Embarcacion embarcacion = null;
            String tipoEmbarcacion;
            do {
                tipoEmbarcacion = PedidorDeDatos.pedirString("Tipo de Embarcación "
                        + "\n[L] Lancha"
                        + "\n[Y] Yate\n");
            } while (!Validar.validarStringLY(tipoEmbarcacion));

            //generar el objeto correspondiente
            if (tipoEmbarcacion.equalsIgnoreCase("L")) {
                double potencia;
                do {
                    potencia = PedidorDeDatos.pedirDouble("Potencia:");
                } while (Validar.validarDouble(potencia) == -1);
                int numPasajeros;
                do {
                    numPasajeros = PedidorDeDatos.pedirInt("Número de Pasajeros:");
                } while (Validar.validarEntero(numPasajeros) == -1);

                //creo objeto Lancha
                embarcacion = new Lancha(potencia, numPasajeros, matricula, metrosEslora, anioFab);

            } else if (tipoEmbarcacion.equalsIgnoreCase("Y")) {
                String tipoYate = "";
                do {
                    tipoEmbarcacion = PedidorDeDatos.pedirString("Tipo de Yate "
                            + "\n[C] Clasico"
                            + "\n[B] Buceo"
                            + "\n[P] Pesca"
                            + "\n[V] Velocidad\n");
                } while (!Validar.validarStringCBPV(tipoEmbarcacion));

                TipoYate tipo = null;
                if (tipoYate.equalsIgnoreCase("C")) {
                    tipo = TipoYate.CLASICO;
                } else if (tipoYate.equalsIgnoreCase("B")) {
                    tipo = TipoYate.BUCEO;
                } else if (tipoYate.equalsIgnoreCase("P")) {
                    tipo = TipoYate.PESCA;
                } else if (tipoYate.equalsIgnoreCase("V")) {
                    tipo = TipoYate.VELOCIDAD;
                }

                int numCamarotes;
                do {
                    numCamarotes = PedidorDeDatos.pedirInt("Número de Camarotes:");
                } while (Validar.validarEntero(numCamarotes) == -1);

                //creo objeto Yate
                embarcacion = new Yate(tipo, numCamarotes, matricula, metrosEslora, anioFab);
            }

            Alquiler alquiler = new Alquiler(cliente, numDias, embarcacion);

            alquileres.add(alquiler);
            System.out.println("La embarcación Ha sido insertada correctamente");

        } else {
            System.out.println("El cliente ya existe. No puede insertar mas alquileres con el mismo cliente");
        }
    }

    /**
     * METODO case 2
     *
     */
    private static void buscarAlquiler(ArrayList<Alquiler> alquileres) {
        String dni;
        do {
            dni = PedidorDeDatos.pedirString("DNI:");
        } while (!Validar.validarString(dni));

        boolean existe = false;
        for (int i = 0; i < alquileres.size(); i++) {
            if (alquileres.get(i).getCliente().getDni().equalsIgnoreCase(dni)) {
                System.out.println(alquileres.get(i).toString());
                existe = true;
            }
        }

        if (!existe) {
            System.out.println("NO existe ningún cliente con ese DNI");
        }
    }

    /**
     * METODO case 3
     *
     */
    private static void eliminarAlquiler(ArrayList<Alquiler> alquileres) {
        String dni;
        do {
            dni = PedidorDeDatos.pedirString("DNI:");
        } while (!Validar.validarString(dni));

        boolean existe = false;
        for (int i = 0; i < alquileres.size(); i++) {
            if (alquileres.get(i).getCliente().getDni().equalsIgnoreCase(dni)) {
                alquileres.remove(i);
                System.out.println("Alquiler eliminado correctamente");
                existe = true;
            }
        }
        if (!existe) {
            System.out.println("NO existe ningún cliente con ese DNI");
        }
    }

    /**
     * METODO case 4
     *
     */
    private static void listarAlquiler(ArrayList<Alquiler> alquileres) {
        if (alquileres.size() > 0) {
            for (int i = 0; i < alquileres.size(); i++) {
                System.out.println("***** ALQUILER " + (i + 1) + " *****");
                System.out.println(alquileres.get(i).toString());
            }
        } else {
            System.out.println("NO existe ningún Alquiler");
        }
    }

}
