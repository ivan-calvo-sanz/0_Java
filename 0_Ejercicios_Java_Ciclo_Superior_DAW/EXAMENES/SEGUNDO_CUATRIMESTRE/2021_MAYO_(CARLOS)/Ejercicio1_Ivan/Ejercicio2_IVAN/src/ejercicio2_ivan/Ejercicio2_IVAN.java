package ejercicio2_ivan;

import java.sql.Connection;

public class Ejercicio2_IVAN {

    private static Connection miConexion;

    public static void main(String[] args) {
        // Parámetros de la conexión:
        final String SERVIDOR = "localhost";
        final int PUERTO = 3307;
        final String USUARIO = "root";
        final String CLAVE = "root";
        final String BASE_DATOS = "concesionario";

        if (BBDD.openConnection(SERVIDOR, PUERTO, USUARIO, CLAVE, BASE_DATOS, true)) {
            miConexion = BBDD.getConexion();
            
            

        }

    }
}
