package cpe;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    static Scanner teclado = new Scanner(System.in);
    static final String DATO_VACIO_EB = "ERROR: No se permiten valores nulos o espacios en blanco.";
    static final String DATO_NO_VALIDO = "ERROR: El dato introducido no es válido.";
    static Map<String, Alquiler> listadoAlquilerClientes = new HashMap(); // Alquileres de los clientes.
    
    public static void main(String[] args) {
        
        boolean cerrarAplicacion = false;
        int opcion = -1;
        
        do {
            
            do {

                System.out.println("=========================");
                System.out.println("= MENU DE LA APLICACION =");
                System.out.println("=========================");

                System.out.println("1. Alquiler un amarre.");
                System.out.println("2. Buscar los datos de un alquiler.");
                System.out.println("3. Eliminar un alquiler.");
                System.out.println("4. Listar todos los alquileres.");
                System.out.println("5. Salir.");

                System.out.print("Escoger opcion: ");
                opcion = teclado.nextInt();

                if (opcion < 1 || opcion > 5) {
                    System.out.println("ERROR: La opción escogida no es válida.");
                }
                
                switch(opcion) {
                    
                    case 1:
                        
                        alquilarAmarre();
                        opcion = -1;
                        break;
                        
                    case 2:
                        
                        buscarDatosAlquiler();
                        opcion = -1;
                        break;
                        
                    case 3:
                        
                        eliminarAlquiler();
                        opcion = -1;
                        break;
                        
                    case 4:
                        
                        listarAlquileres();
                        opcion = -1;
                        break;
                        
                    case 5:
                        
                        cerrarAplicacion = true;
                        System.out.println("Cerrando aplicación...");
                        break;
                    
                    
                }
                
            
            } while(opcion < 1 || opcion > 5);
            
        } while(!cerrarAplicacion);
        
    }
    
    public static void alquilarAmarre() {
        
        String nombreCliente = null;
        String dniCliente = null;
        int numDiasAlquiler = -1;
        
        System.out.println("======================");
        System.out.println("=[ALQUILER DE AMARRE]=");
        System.out.println("======================\n");
        
        do {
            System.out.print("Introduce el DNI del cliente: ");
            dniCliente = validarTexto(teclado.nextLine(), true);
        } while(dniCliente == null);
        
        // Datos de la embarcación.
        
        int opcion = -1;
        
        if (!listadoAlquilerClientes.containsKey(dniCliente)) { // Si el cliente no tiene alquileres, se registra el alquiler.
            
            String matricula = null;
            int metrosEslora = -1;
            int anoFabricacion = -1;
            
            do {
                System.out.print("Introduce el nombre del cliente: ");
                nombreCliente = validarTexto(teclado.nextLine(), true);
            } while(nombreCliente == null);
            
            // Se crea el objeto cliente.
            
            Cliente cliente = new Cliente(nombreCliente, dniCliente);
            
            do {
                System.out.print("Introduce el número de días del alquiler: ");
                numDiasAlquiler = validarEntero(teclado.nextLine(), true);
            } while(numDiasAlquiler == -1);
            
            do {
                System.out.print("Introduce la matrícula: ");
                matricula = validarTexto(teclado.nextLine(), true);
            }while(matricula == null);

            do {
                System.out.print("Introduce los metros de eslora: ");
                metrosEslora = validarEntero(teclado.nextLine(), true);
            }while(metrosEslora == -1);

            do {
                System.out.print("Introduce el año de fabricacion: ");
                anoFabricacion = validarEntero(teclado.nextLine(), true);
            }while(anoFabricacion == -1);
            
            // Mostrar el menú con los dos tipos de embarcaciones disponibles.
            
            do {
            
                System.out.println("Escoge el tipo de embarcación a alquilar: ");
                System.out.println("1. Lancha deportiva.");
                System.out.println("2. Yate.");

                opcion = validarEntero(teclado.nextLine(), false);
                
                if (opcion < 1 || opcion > 2) {
                    System.out.println(DATO_NO_VALIDO);
                }
                
            } while(opcion < 1 || opcion > 2);
            
            switch(opcion) {
                
                case 1: // Lancha deportiva.
                    
                    int potenciaMotor = -1;
                    int numPasajeros = -1;
                    
                    do {
                        System.out.print("Introduce la potencia del motor: ");
                        potenciaMotor = validarEntero(teclado.nextLine(), true);
                    }while(potenciaMotor == -1);
                    
                    do {
                        System.out.print("Introduce el número de pasajeros: ");
                        numPasajeros = validarEntero(teclado.nextLine(), true);
                    }while(numPasajeros == -1);
                    
                    LanchaDeportiva lancha = new LanchaDeportiva(matricula, metrosEslora, anoFabricacion, potenciaMotor, numPasajeros);
                    
                    Alquiler alquilerA = new Alquiler(cliente, numDiasAlquiler, lancha);
                    
                    listadoAlquilerClientes.put(dniCliente, alquilerA); // Registramos el alquiler del cliente.
                    
                    break;
                    
                case 2: // Yate
                    
                    int numCamarotes = -1;
                    int numTipoYate = -1;
                    
                    do {
                        System.out.print("Introduce el número de camarotes: ");
                        numCamarotes = validarEntero(teclado.nextLine(), true);
                    } while(numCamarotes == -1);
                    
                    // Mostrar los tipos de yate disponibles.
                    
                    do {
                        
                        for (iTipoYate.TipoYate tp: iTipoYate.TipoYate.values()) {
                            System.out.println(tp.ordinal() + " -> " + tp.name());
                        }
                        
                        System.out.print("\nEscoge el tipo de yate: ");
                        numTipoYate = validarEntero(teclado.nextLine(), false);
                        
                        if (numTipoYate < 0 || numTipoYate > 3) {
                            System.out.println("ERROR: El tipo de yate escogido no es válido.");
                            numTipoYate = -1;
                        }
                        
                    }while(numTipoYate == -1);
                    
                    Yate yate = new Yate(matricula, metrosEslora, anoFabricacion, numCamarotes, Yate.TipoYate.values()[numTipoYate]);
                    
                    Alquiler alquilerB = new Alquiler(cliente, numDiasAlquiler, yate);
                    
                    listadoAlquilerClientes.put(dniCliente, alquilerB); // Registramos el alquiler del cliente.
                    
                    System.out.println("El alquiler ha sido registrado correctamente.");
                    
                    break;
                    
            }
            
        } else {
            System.out.println("ERROR: No se puede realizar el alquiler ya que por política de empresa solo se permite un alquiler por cliente.");
        }
        
        // Datos de la embarcacion.
        
        
            
    }
    
    public static void buscarDatosAlquiler() {
        
        String dniCliente = null;
        
        System.out.println("============================");
        System.out.println("=[BUSCAR DATOS DE ALQUILER]=");
        System.out.println("============================\n");
        
        do {
            System.out.print("Introduce el DNI del cliente: ");
            dniCliente = validarTexto(teclado.nextLine(), true);
        } while(dniCliente == null);
        
        if (!listadoAlquilerClientes.containsKey(dniCliente)) {
            System.out.println("ERROR: No existe ningún cliente con el DNI proporcionado.");
        } else {
            Alquiler alquiler = listadoAlquilerClientes.get(dniCliente);
            System.out.println(alquiler.toString());
        }
        
    }
    
    public static void eliminarAlquiler() {
        
        String dniCliente = null;
        int opcion = -1;
        
        System.out.println("=====================");
        System.out.println("=[ELIMINAR ALQUILER]=");
        System.out.println("=====================\n");
        
        do {
            System.out.print("Introduce el DNI del cliente: ");
            dniCliente = validarTexto(teclado.nextLine(), true);
        } while(dniCliente == null);
        
        if (!listadoAlquilerClientes.containsKey(dniCliente)) {
            System.out.println("ERROR: No existe ningún cliente con el DNI proporcionado.");
        } else {
            
            do {
                System.out.print("¿Estás seguro que quieres eliminar el alquiler del cliente? 0 - No/1 - Si: ");
                opcion = validarEntero(teclado.nextLine(), true);
            } while(opcion < 0 || opcion > 1);
            
            if (opcion == 1) {
                listadoAlquilerClientes.remove(dniCliente);
                System.out.println("El alquiler del cliente con dni " + dniCliente + " ha sido eliminado correctamente.");
            }
        }
        
    }
    
    public static void listarAlquileres() {
        
        if (listadoAlquilerClientes.size() > 0) {
        
            for (Map.Entry<String, Alquiler> alq : listadoAlquilerClientes.entrySet()) {

                System.out.println("=================================");
                System.out.println("= LISTADO GENERAL DE ALQUILERES =");
                System.out.println("=================================\n");

                System.out.println("=================================\n");
                System.out.println(alq.getValue().toString());
                System.out.println("\n=================================\n");
                
            }
            
        } else {
            System.out.println("No hay alquieres disponibles en este momento.");
        }
        
        
    }
    
    public static String validarTexto(String texto, boolean mostrarError) {
        
        String textoComprobacion = null;
        
        try {

            // Comprobar que el dato no esté vacío o contenga espacios en blanco.

            if (texto.isEmpty() || texto.contains(" ")) {
                if (mostrarError)
                    System.out.println(DATO_VACIO_EB);
            } else {
                textoComprobacion = texto;
            }

        } catch (InputMismatchException ex) {
            if (mostrarError)
                System.out.println(DATO_NO_VALIDO);
        }
        
        return textoComprobacion;
        
    }
    
    public static int validarEntero(String numero, boolean mostrarError) {
        
        int numeroConvertido = -1;
        
        try {
            numeroConvertido = Integer.parseInt(numero);
        } catch(InputMismatchException | NumberFormatException ex) {
            if (mostrarError)
                System.out.println(DATO_NO_VALIDO);
        }
        
        return numeroConvertido;
        
    }
    
}
