package ejercicio2;

import java.sql.*;

public class BBDD {
    private static Connection miConexion;
    final static String SERVIDOR = "localhost";
    final static int PUERTO = 3307;
    final static String BASE_DATOS = "programacion";
    final static String USUARIO = "root";
    final static String CLAVE = "root";
    //final static String SERVIDOR = "localhost";
    //final static int PUERTO = 1521;
    //final static String BASE_DATOS = "BDPractica10";
    //final static String USUARIO = "ivan";
    //final static String CLAVE = "1234";
    
    public static void conectarBBDD(){
            try {
                //1-CREAR CONEXION
                //miConexion = DriverManager.getConnection("jdbc:mysql://" + SERVIDOR + ":" + PUERTO + "/" + BASE_DATOS + "?" + "user=" + USUARIO + "&password=" + CLAVE);
                //miConexion = DriverManager.getConnection("jdbc:mysql://localhost/programacion","root","");
                miConexion=DriverManager.getConnection("jdbc:Oracle:thin:@//localhost:1521/xe", "Ivan", "1234");
                System.out.println("Conexion correcta a la BBDD");
            } catch (SQLException ex) {
                System.err.println("Se ha producido un problema en la conexión. [Codigo]:" +ex.getErrorCode()+" [Error]:"+ex.getMessage());
            }
    }
    
    public static void cerrarConexion(){
        try {
            if(miConexion!=null){
                if(!miConexion.isClosed()){
                    miConexion.close();
                    System.out.println("Desconexión de la BBDD realizada correctamente");
                }
            }else{
                System.out.println("La conexión no ha sido realizada");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido cerrar la conexión con la BBDD: "+ex.getErrorCode()+" "+ex.getMessage());
        }
    }
    
    public static String[] devuelveEmpleado(int num){
        String[] devuelve=new String[4];
        String sql="SELECT E.APELLIDO,E.OFICIO,E.SALARIO,D.DNOMBRE " 
                    + " FROM DEPARTAMENTOS D JOIN EMPLEADOS E " 
                    + " ON D.DEPT_NO=E.DEPT_NO"
                    + " WHERE E.EMP_NO=?";
        try {
            PreparedStatement ps = miConexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                devuelve[0]=rs.getString(1);
                devuelve[1]=rs.getString(2);
                devuelve[2]=rs.getString(3);
                devuelve[3]=rs.getString(4);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error SQL\n[Codigo]:" +ex.getErrorCode()+" [Error]:"+ex.getMessage());
        }
        return devuelve;
    }
    
}