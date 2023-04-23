package ejercicio2;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author IVAN
 */
public class Main {
    static Scanner entrada=new Scanner(System.in);   
    static final String DATO_VACIO="ERROR: No se permiten valores nulos o espacios en blanco. \nVuelva a introducir el dato: ";
    static final String DATO_NO_VALIDO="ERROR: El dato introducido no es válido.\nVuelva a introducir el dato: ";
    private static Connection miConexion;
    
    public static void main(String[] args) {
            System.out.print("Introduce Nombre:");
            String nombre;
            do{
                nombre=validarTexto(entrada.nextLine());
            }while(nombre==null);

            try {
                //1-CREAR CONEXION
                miConexion=DriverManager.getConnection("jdbc:Oracle:thin:@//localhost:1521/xe", "Ivan", "1234");
                System.out.println("Conexion correcta a la BBDD");
            } catch (SQLException ex) {
                System.err.println("Se ha producido un problema en la conexión. [Codigo]:" +ex.getErrorCode()+" [Error]:"+ex.getMessage());
            }
        
        String texto="%"+nombre+"%";
        String sql="SELECT COUNT (*) "
                    + "FROM HR.EMPLOYEES "
                    + "WHERE FIRST_NAME LIKE ? ";
        String sqlI="SELECT COUNT (*) "
                    + "FROM EMPLEADOS "
                    + "WHERE APELLIDO LIKE ? ";
                
        try {
            PreparedStatement ps=miConexion.prepareStatement(sqlI, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, texto);
            ResultSet rs=ps.executeQuery();
            String count="";
            while(rs.next()){
                count=rs.getString(1);
            }
            rs.close();
            ps.close();

            System.out.println("nº de empleados encontrados: "+count);
            
            if(Integer.valueOf(count)>0){
                sql="SELECT FIRST_NAME,LAST_NAME,JOB_TITLE,DEPARTMENT_NAME "
                    + "FROM HR.EMPLOYEES "
                    + "WHERE FIRST_NAME LIKE ? ";             
                sqlI="SELECT APELLIDO,OFICIO "
                    + "FROM EMPLEADOS "
                    + "WHERE APELLIDO LIKE ? ";
                ps=miConexion.prepareStatement(sqlI, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, texto);
                rs=ps.executeQuery();
                int i=0;
                while(rs.next()){
                    i++;
                    //System.out.println(i+" | FIRST_NAME: "+rs.getString(1)+" | LAST_NAME: "+rs.getString(2)+" | JOB_TITLE: "+rs.getString(3)+" | DEPARTMENT_NAME: "+rs.getString(4));
                    System.out.println(i+" | FiApellido: "+rs.getString(1)+" | Oficio: "+rs.getString(2));
                }
                rs.close();
                ps.close();

            }else{
                sql="SELECT FIRST_NAME,LAST_NAME,JOB_TITLE,DEPARTMENT_NAME "
                    + "FROM HR.EMPLOYEES ";
                sqlI="SELECT APELLIDO,OFICIO "
                    + "FROM EMPLEADOS ";
                ps=miConexion.prepareStatement(sqlI, Statement.RETURN_GENERATED_KEYS);
                rs=ps.executeQuery();
                int i=0;
                while(rs.next()){
                    i++;
                    //System.out.println(i+" | FIRST_NAME: "+rs.getString(1)+" | LAST_NAME: "+rs.getString(2)+" | JOB_TITLE: "+rs.getString(3)+" | DEPARTMENT_NAME: "+rs.getString(4));
                    System.out.println(i+" | Apellido: "+rs.getString(1)+" | Oficio: "+rs.getString(2));
                } 
                rs.close();
                ps.close();
            }
        } catch (SQLException ex) {
            System.err.println("Error: "+ex.getErrorCode()+" "+ex.getMessage());
        }
        
    }
    
    
    /*
        METODOS VALIDAN DATOS INTRODUCIDOS POR CONSOLA
    */

//METODO Verifica que el texto NO está vacio NI contiene espacios en blanco
    private static String validarTexto(String texto){
        String textoDevuelto=null;
        try {
            if(texto.isEmpty()||texto.contains(" ")){
                System.err.println(DATO_VACIO);
            }else{
                textoDevuelto=texto;
            }
        } catch (Exception e) {
            System.err.println(DATO_NO_VALIDO +" |Error: "+e);
        }
        return textoDevuelto;
    }

    
}
