package ejercicio2_ivan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * CLASE BBDD Clase para realizar todas las operaciones con la BBDD
 *
 * @author Iván Calvo Sanz / 1ºDAW
 * @version 1.0, 2022/04/22
 */
public class BBDD {

    private static Connection miConexion;
    final static String SERVIDOR = "localhost";
    final static int PUERTO = 3307;
    final static String BASE_DATOS = "programacion";
    final static String USUARIO = "root";
    final static String CLAVE = "root";

    public static void conectarBBDD() {
        try {
            //1-CREAR CONEXION
            //miConexion = DriverManager.getConnection("jdbc:mysql://" + SERVIDOR + ":" + PUERTO + "/" + BASE_DATOS + "?" + "user=" + USUARIO + "&password=" + CLAVE);
            //miConexion = DriverManager.getConnection("jdbc:mysql://localhost/programacion","root","");
            miConexion = DriverManager.getConnection("jdbc:Oracle:thin:@//localhost:1521/xe", "Ivan", "1234");
            System.out.println("Conexion correcta a la BBDD");
        } catch (SQLException ex) {
            System.err.println("Se ha producido un problema en la conexión. [Codigo]:" + ex.getErrorCode() + " [Error]:" + ex.getMessage());
        }
    }

    private static Connection miConexion;

    /**
     * METODO conecta con la BBDD
     *
     * @return boolean (true si la conexion es satisfactoria, false si no lo es)
     */
    public static boolean openConnection(String servidor, int puerto, String usuario, String clave, String baseDeDatos, boolean infoConexion) {
        boolean conexionCorrecta = false;
        if (miConexion == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                miConexion = DriverManager.getConnection("jdbc:mysql://" + servidor + ":" + puerto + "/" + baseDeDatos + "?"
                        + "user=" + usuario + "&password=" + clave);
                conexionCorrecta = true;
                if (infoConexion) {
                    System.out.println("Se ha conectado correctamente a la base de datos '" + baseDeDatos + "'.");
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("Se ha producido un error: " + ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("Se ha producido un problema en la conexión. [Cod Error] => " + ex.getErrorCode() + " [Causa] => " + ex.getMessage());
            }
        }
        return conexionCorrecta;
    }

    /**
     * METODO devuelve la conexión generada en el método openConnection
     *
     */
    public static Connection getConexion() {
        return miConexion;
    }

    /**
     * METODO cierra la conexión con la BBD
     *
     *
     */
    public static void closeConnection(boolean infoDesconexion) {
        try {
            if (miConexion != null) {
                if (!miConexion.isClosed()) {
                    miConexion.close();
                    if (infoDesconexion) {
                        System.out.println("La conexión se ha cerrado correctamente.");
                    }
                }
            } else {
                if (infoDesconexion) {
                    System.err.println("No se puede cerrar una conexión que no ha sido establecida.");
                }
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido cerrar la conexión => [" + ex.getErrorCode() + "] => " + ex.getMessage());
        }
    }

}
