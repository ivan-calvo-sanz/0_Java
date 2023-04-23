package cpe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        String datoIntroducido = null;
        int numEmpleado = -1;
        
        // Datos de conexión a la base de datos.
        
        final String SERVIDOR = "localhost";
        final int PUERTO = 3306;
        final String BASE_DATOS = "programacion";
        final String USUARIO = "root";
        final String CLAVE = "";
        
        do {
            
            // Primero solicitamos el número de empleado al usuario.
            
            System.out.print("Introduce el número de empleado: ");
            datoIntroducido = teclado.nextLine();
            
            /* 
                Utilizamos la función validarEntero para comprobar que el número sea correcto.
                Le pasamos el dato introducido por el usuario (datoIntroducido) y ponemos true
                para que si el dato no es válido, la función muestre el error por pantalla.
            */
            
            numEmpleado = validarEntero(datoIntroducido, true);
            
            // Una vez que el dato sea correcto, lanzamos la consulta a la base de datos.
            
            try {
                //Class.forName("com.mysql.jdbc.Driver");

                Connection conexion = DriverManager.getConnection("jdbc:mysql://" + SERVIDOR + ":" + PUERTO + "/" + BASE_DATOS + "?" +
                                                                  "user=" + USUARIO + "&password=" + CLAVE);
                
                // Definir la consulta SQL.
                
                String query = "SELECT " +
                               "   empleados.apellido, " +
                               "   empleados.oficio, " +
                               "   empleados.salario, " +
                               "   departamentos.dnombre " +
                               "FROM " +
                               "   empleados, " +
                               "   departamentos " +
                               "WHERE " +
                               "   empleados.dept_no = departamentos.dept_no " +
                               "AND " +
                               "   empleados.emp_no = ?";
                
                PreparedStatement ps = conexion.prepareStatement(query);
                
                // Asignamos a la consulta el num del empleado.
                
                ps.setInt(1, numEmpleado);
                
                // Ejecutamos la consulta y almacenamos los resultados en el ResultSet para poder visualizarlos.
                
                ResultSet rs = ps.executeQuery();
                
                // Comprobamos si el cliente que queremos buscar, existe. Si no hay resultados es porque no existe.
                
                if (!rs.next()) {
                    System.out.println("El cliente introducido no existe en la base de datos.");
                } else {
                    
                    System.out.println("Apellido: " + rs.getString(1) + " Oficio: " + rs.getString(2) +
                                       " Salario: " + rs.getDouble(3) + " Nombre Dpto: " + rs.getString(4));
                    
                }
                
                // Cerramos el ResultSet, PreparedStatement y la conexión a la base de datos.
                
                rs.close();
                ps.close();
                conexion.close();
                
            } catch (SQLException e) {
                System.out.println("ERROR: No se ha podido establecer una conexión a la base de datos.");
            }
            
            
            
        } while(numEmpleado == -1);
        
        
    }
    
    /*
        Valida una cadena de texto (String) y si es válida, retornará el mismo
        valor pero de tipo int (entero).
    */
    
    public static int validarEntero(String numero, boolean mostrarError) {
        
        int numeroConvertido = -1;
        
        try {
            numeroConvertido = Integer.parseInt(numero);
        } catch(InputMismatchException | NumberFormatException ex) {
            if (mostrarError)
                System.out.println("ERROR: El número introducido es erróneo.");
        }
        
        return numeroConvertido;
        
    }
    
}
