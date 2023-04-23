package Serializable;

import java.io.Serializable;

public class FormaCaracteres implements Serializable {

    public static final long serialVersionUID = 1L;

    //ESCRIBE en archivo .txt        
    
        try {
            FileWriter fw = new FileWriter(f, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("\n** SIMULACIÓN DE ADIVINAR EL NÚMERO" + "\n");

        do {
            turno = juego.getTurno();
            numJugado = generarNumAleatorio(numMin, numMax);

            imp = "Jugador:" + turno + " Juega:" + numJugado + "\n";
            System.out.print(imp);
            bw.write(imp);

            caso = juego.jugada(numJugado);

            if (caso == -1) {
                numMin = numJugado;
                imp = "El nº buscado es MAYOR, entre [" + numMin + "," + numMax + "]" + "\n";
                System.out.print(imp);
                bw.write(imp);
            } else if (caso == 1) {
                numMax = numJugado;
                imp = "El nº buscado es MENOR, entre [" + numMin + "," + numMax + "]" + "\n";
                System.out.print(imp);
                bw.write(imp);
            } else if (caso == 0) {
                imp = "ACERTATE!!!" + "\n";
                System.out.print("ACERTATE!!!" + "\n");
                bw.write(imp);
                break;
            }
        } while (caso != 0);

//cerrar canal
        bw.close();
        fw.close();
    }
    catch (IOException e

    
        ) {
            System.err.println("Error en la operación de Entrada/salida de datos |Error: " + e);
    }

    //LEE desde un archivo .txt 
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

}
