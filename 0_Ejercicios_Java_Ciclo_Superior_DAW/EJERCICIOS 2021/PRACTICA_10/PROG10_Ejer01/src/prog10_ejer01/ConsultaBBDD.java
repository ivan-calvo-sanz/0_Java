package prog10_ejer01;

import java.sql.*;

/**
 *
 * @author IVAN
 */
public class ConsultaBBDD {
    private static Connection miConexion;
        
    public static void ConectarBBDD(){
        try{
            //1-CREAR CONEXION
            miConexion=DriverManager.getConnection("jdbc:Oracle:thin:@//localhost:1521/xe", "Ivan", "1234");
            //2-CREAR OBJETO STATEMENT
            System.out.println("Conexión correcta a la BBDD");
        } catch (Exception e) {
            System.err.println("No conecta."+e);
        }       
    }
    
    public static Connection getConexion(){
        return miConexion;
    }
    
    public static void cerrarConexion(){
        try {
            if(miConexion!=null){
                if(!miConexion.isClosed()){
                    miConexion.close();
                    System.out.println("Desconexión de la BBDD realizada.");
                }
            }else{
                System.out.println("La conexión no ha sido realizada.");
            }
        } catch (SQLException e) {
            System.err.println("No se ha podido cerrar la conexión con la BBDD "+e.getErrorCode()+" "+e.getMessage());
        }
    }
    
}