package PROG11_Ejer01_JOptionPane;

import JFrames.JFramePrincipal;
import java.sql.*;
import java.util.*;

/**
 *
 * @author IVAN
 */
public class BBDD {
    private static Connection miConexion;
    static PreparedStatement ps;
    static ResultSet rs;
    static Statement miStatement;
    static JFramePrincipal jf=new JFramePrincipal();
    
    public static String ConectarBBDD(){
        String devuelve;    
        try {
                //1-CREAR CONEXION
                miConexion=DriverManager.getConnection("jdbc:Oracle:thin:@//localhost:1521/xe", "Ivan","1234");
                devuelve="Conexion correcta a la BBDD";
            } catch (SQLException ex) {
                devuelve="Se ha producido un problema en la conexión. [Codigo]:" +ex.getErrorCode()+" [Error]:"+ex.getMessage();
            }
        return devuelve;
    }
    
    //METODO DESCONECTA CONEXION
    public static void cerrarConexion(){
        try {
            if(miConexion!=null){
                if(!miConexion.isClosed()){
                    miConexion.close();
                    System.out.println("Desconexión de la BBDD realizada");
                }
            }else{
                System.out.println("La conexión no ha sido realizada");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido cerrar la conexión con la BBDD: "+ex.getErrorCode()+" "+ex.getMessage());
        }
    }
    
    //CASO:1 GENERA TABLA CLIENTES con los atributos de la Clase "Cliente"
    public static String crearTablaClientes(){
        String devuelve;
        try {
            String sql="CREATE TABLE CLIENTES ("
                    + "COD_CLIENTE INTEGER CONSTRAINT PK_COD_CLIENTE PRIMARY KEY,"
                    + "NOMBRE VARCHAR2(50) NOT NULL,"
                    + "TELEFONO VARCHAR2(20) NOT NULL"
                    + ")";
            ps=miConexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            devuelve="Tabla CLIENTES creada correctamente.";
        } catch (SQLException ex) {
            devuelve="Error SQL al crear la Tabla CLIENTES \n[Codigo]:" +ex.getErrorCode()+" [Error]:"+ex.getMessage();
        }
        return devuelve;
    }
    
    //CASO:2 GENERA TABLA ESCRITURAS con los atributos de la Clase "Escritura"
    public static String crearTablaEscrituras(){
        String devuelve;
        try {
            String sql="CREATE TABLE ESCRITURAS ("
                    + "COD_ESCRITURAS INTEGER CONSTRAINT PK_COD_ESCRITURAS PRIMARY KEY,"
                    + "TIPO VARCHAR2(20),"
                    + "NOM_FICH VARCHAR2(50),"
                    + "NUM_INTERV INTEGER"
                    + ")";
            ps=miConexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            devuelve="Tabla ESCRITURAS creada correctamente.";
        } catch (SQLException ex) {
            devuelve="Error SQL al crear la Tabla ESCRITURAS \n[Codigo]:" +ex.getErrorCode()+" [Error]:"+ex.getMessage();
        }
        return devuelve;
    }
    
    //CASO:3 GENERA TABLA ESCCLI relacionando Clientes con Escritura
    public static String crearTablaEsccli(){
        String devuelve;
        try {
            String sql="CREATE TABLE ESCCLI ("
                    + "COD_CLI INTEGER NOT NULL,"
                    + "COD_ESCR INTEGER NOT NULL,"
                    + "CONSTRAINT PK_COD_CLI_COD_ESCR PRIMARY KEY (COD_CLI, COD_ESCR),"
                    + "CONSTRAINT FK_ESCCLI_COD_CLI FOREIGN KEY (COD_CLI) REFERENCES CLIENTES (COD_CLIENTE),"
                    + "CONSTRAINT FK_ESCCLI_COD_ESCR FOREIGN KEY (COD_ESCR) REFERENCES ESCRITURAS (COD_ESCRITURAS)"
                    + ")";
            ps=miConexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            devuelve="Tabla ESCCLI creada correctamente.";
        } catch (SQLException ex) {
            devuelve="Error SQL al crear la Tabla ESCCLI \n[Codigo]:" +ex.getErrorCode()+" [Error]:"+ex.getMessage();
        }  
        return devuelve;
    }
    
    //METODO Inserta Clientes en Tabla CLIENTES, que se le pasa por parámetro
    public static String insertaClientes(ArrayList<Cliente> clientes){
        String devuelve;
        try {
            String sql="INSERT INTO CLIENTES (COD_CLIENTE,NOMBRE,TELEFONO) VALUES (?,?,?)";
            ps=miConexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for(int i=0;i<clientes.size();i++){
                ps.setInt(1, clientes.get(i).getCod());
                ps.setString(2, clientes.get(i).getNombre());
                ps.setString(3, clientes.get(i).getTel());
                ps.executeUpdate();
            }
            devuelve="Datos introduciodos correctamente";
            } catch (SQLException ex) {
                devuelve="Error: "+ex.getErrorCode()+" "+ex.getMessage()+"/n";
        }
        return devuelve;
    }
    
    //METODO Inserta Escrituras en Tabla ESCRITURAS, que se le pasa por parámetro
    public static String insertaEscrituras(ArrayList<Escritura> escrituras){
        String devuelve;
        try {
            String sql="INSERT INTO ESCRITURAS (COD_ESCRITURAS,TIPO,NOM_FICH,NUM_INTERV) VALUES (?,?,?,?)";
            ps=miConexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for(int i=0;i<escrituras.size();i++){
                ps.setInt(1, escrituras.get(i).getCod());
                ps.setString(2, escrituras.get(i).getTipo());
                ps.setString(3, escrituras.get(i).getNomFicha());
                ps.setInt(4, escrituras.get(i).getNumInterv());
                ps.executeUpdate();
            }
            devuelve="Datos introduciodos correctamente";
            } catch (SQLException ex) {
                devuelve="Error: "+ex.getErrorCode()+" "+ex.getMessage();
        } 
        return devuelve;
    }
    
    //METODO Inserta en Tabla ESCCLI la relación entre Escritura y Clientes
    public static void insertaEscCli(int codCliente,int codEscritura){
        try {
            String sql="INSERT INTO ESCCLI (COD_CLI,COD_ESCR) VALUES (?,?)";
            ps=miConexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, codCliente);
            ps.setInt(2, codEscritura);
            ps.executeUpdate();
            System.out.println("Datos introduciodos correctamente");
            } catch (SQLException ex) {
                System.err.println("Error: "+ex.getErrorCode()+" "+ex.getMessage());
        }
    }
    
    //METODO actualiza el NUN_INTERV en Tabla ESCRITURAS
    public static void actualizarNumInterv(int codEscritura){
        int numInterv=0;
        try {
            String sqlEsccli="SELECT COUNT (COD_CLI) "
                + "FROM ESCCLI WHERE COD_ESCR=?";
            String sqlEscritura="UPDATE ESCRITURAS"
                + " SET NUM_INTERV=? WHERE COD_ESCRITURAS=?";
            ps=miConexion.prepareStatement(sqlEsccli, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, codEscritura);
            rs=ps.executeQuery();
            while(rs.next()){
                numInterv=rs.getInt(1);
            }
            ps=miConexion.prepareStatement(sqlEscritura, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, numInterv);
            ps.setInt(2, codEscritura);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: "+ex.getErrorCode()+" "+ex.getMessage());
        }   
    }
    
    //METODO Devuelve los CLIENTES asociados a una Escritura
    public static ArrayList<Cliente> devuelveClientesDeEscritura(Escritura e){
        ArrayList<Cliente> clientes=new ArrayList<Cliente>();
        int codCliente,codEscritura;
        String nombre,tel;
        String sql="SELECT C.COD_CLIENTE,C.NOMBRE,C.TELEFONO " 
                    + " FROM CLIENTES C JOIN ESCCLI E " 
                    + " ON C.COD_CLIENTE=E.COD_CLI"
                    + " WHERE E.COD_ESCR=?";
        codEscritura=e.getCod();
        try {
            ps=miConexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, codEscritura);
            rs=ps.executeQuery();
            while(rs.next()){
                codCliente=rs.getInt(1);
                nombre=rs.getString(2);
                tel=rs.getString(3);
                Cliente c=new Cliente(codCliente,nombre,tel);
                clientes.add(c);
            }
        } catch (SQLException ex) {
            System.err.println("Error: "+ex.getErrorCode()+" "+ex.getMessage());
        }
        return clientes;
    }
    
    //Genera nuevo codigo a un nuevo Cliente.
    public static int generaCodCliente(){
        int newCod=1;
        try {
            String sql="SELECT COUNT (COD_CLIENTE) AS RESULT"
                    + " FROM CLIENTES";
            miStatement=miConexion.createStatement();
            rs=miStatement.executeQuery(sql);
            while(rs.next()){
                newCod=rs.getInt(1)+1;
            }
            
        } catch (SQLException ex) {
            System.err.println("Error: "+ex.getErrorCode()+" "+ex.getMessage());
        }
        return newCod;
    }
    
    //Genera nuevo codigo a una nueva Escritura
    public static int generaCodEscritura(){
        int newCod=1;
        try {
            String sql="SELECT COUNT (COD_ESCRITURAS) AS RESULT"
                    + " FROM ESCRITURAS";
            miStatement=miConexion.createStatement();
            rs=miStatement.executeQuery(sql);
            while(rs.next()){
                newCod=rs.getInt(1)+1;
            }
        } catch (SQLException ex) {
            System.err.println("Error: "+ex.getErrorCode()+" "+ex.getMessage());
        }
        return newCod;
    }
    
    //METODO Recupera Clientes de la TABLA CLIENTES
    public static ArrayList<Cliente> devuelveClientes(){
        ArrayList<Cliente> clientes=new ArrayList<Cliente>();
        int cod;
        String nombre,tel;
        String sql="SELECT COD_CLIENTE,NOMBRE,TELEFONO"
                    + " FROM CLIENTES";
        try {
            miStatement=miConexion.createStatement();
            rs=miStatement.executeQuery(sql);
            while(rs.next()){
                cod=rs.getInt(1);
                nombre=rs.getString(2);
                tel=rs.getString(3);
                Cliente c=new Cliente(cod,nombre,tel);
                clientes.add(c);
            }
        } catch (SQLException ex) {
            System.err.println("Error: "+ex.getErrorCode()+" "+ex.getMessage());
        }
        return clientes;
    }
    
    //METODO Recupera Escrituras de la TABLA ESCRITURAS
    public static ArrayList<Escritura> devuelveEscrituras(){
        ArrayList<Escritura> escrituras=new ArrayList<Escritura>();
        int cod,numInterv;
        String tipo,nomFicha;
        String sql="SELECT * FROM ESCRITURAS";
        try {
            miStatement=miConexion.createStatement();
            rs=miStatement.executeQuery(sql);
            while(rs.next()){
                cod=rs.getInt(1);
                tipo=rs.getString(2);
                nomFicha=rs.getString(3);
                numInterv=rs.getInt(4);
                Escritura e=new Escritura(cod,tipo,nomFicha,numInterv);
                escrituras.add(e);
            }
        } catch (SQLException ex) {
            System.err.println("Error: "+ex.getErrorCode()+" "+ex.getMessage());
        }
        return escrituras;
    }
    
    //Devuelve un Cliente dado el cod
    public static Cliente devuelveCliente(int cod){
        String sql="SELECT * FROM CLIENTES WHERE COD_CLIENTE=?";
        String nombre,tel;
        Cliente c=new Cliente();
        try {
            ps=miConexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cod);
            rs=ps.executeQuery();
            while(rs.next()){
                nombre=rs.getString(2);
                tel=rs.getString(3);
                c=new Cliente(cod,nombre,tel);
            }
        } catch (SQLException ex) {
            System.err.println("Error: "+ex.getErrorCode()+" "+ex.getMessage());
        }
        return c;
    }
    
    //Devuelve una Escritura dado el cod
    public static Escritura devuelveEscritura(int cod){
        String sql="SELECT * FROM ESCRITURAS WHERE COD_ESCRITURAS=?";
        Escritura e=new Escritura();
        try {
            ps=miConexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cod);
            rs=ps.executeQuery();
            while(rs.next()){
                e.setCod(rs.getInt(1));
                e.setTipo(rs.getString(2));
                e.setNomFicha(rs.getString(3));
                e.setNumInterv(rs.getInt(4));
            }
        } catch (SQLException ex) {
            System.err.println("Error: "+ex.getErrorCode()+" "+ex.getMessage());
        }
        return e;
    }
    
    
    
    //ACTUALIZA LOS DATOS DE UN CLIENTE DE LA TABLA CLIENTES
    public static String actualizarCliente(int cod,String nom,String tel){
        Cliente c=devuelveCliente(cod);
        try {
            String sql="UPDATE CLIENTES SET NOMBRE=?, TELEFONO=? WHERE COD_CLIENTE=?";
            ps = miConexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            if(!nom.equals("")&&!tel.equals("")){
                ps.setString(1, nom);
                ps.setString(2, tel);
            }else if(!nom.equals("")&&tel.equals("")){
                ps.setString(1, nom);
                ps.setString(2, c.getTel());                
            }else if(nom.equals("")&&!tel.equals("")){
                ps.setString(1, c.getNombre());
                ps.setString(2, tel);
            }else if(nom.equals("")&&tel.equals("")){
                ps.setString(1, c.getNombre());
                ps.setString(2, c.getTel());
                return "No ha introducido ninguna modificacion en el Cliente: "+c.getNombre();
            }
            ps.setInt(3, cod);
            ps.executeUpdate();
            return "Datos del cliente "+c.getNombre()+" modificados correctamente";  
        } catch (SQLException ex) {
            return "Error: "+ex.getErrorCode()+" "+ex.getMessage();
        }
    }
    
    //ACTUALIZA LOS DATOS DE UNA ESCRITURA DE LA TABLA ESCRITURAS
    public static String actualizarEscritura(int cod,String tipo,String ficha){
        Escritura e=devuelveEscritura(cod);
        try {
            String sql="UPDATE ESCRITURAS SET TIPO=?, NOM_FICH=? WHERE COD_ESCRITURAS=?";
            ps = miConexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            if(!tipo.equals("")&&!ficha.equals("")){
                ps.setString(1, tipo);
                ps.setString(2, ficha);
            }else if(!tipo.equals("")&&ficha.equals("")){
                ps.setString(1, tipo);
                ps.setString(2, e.getNomFicha());                
            }else if(tipo.equals("")&&!ficha.equals("")){
                ps.setString(1, e.getTipo());
                ps.setString(2, ficha);
            }else if(tipo.equals("")&&ficha.equals("")){
                ps.setString(1, e.getTipo());
                ps.setString(2, e.getNomFicha());
                return "No ha introducido ninguna modificacion en la Escritura: "+e.getCod();
            }
            ps.setInt(3, cod);
            ps.executeUpdate();
            return "Datos de la Escritura "+e.getCod()+" modificados correctamente";  
        } catch (SQLException ex) {
            return "Error: "+ex.getErrorCode()+" "+ex.getMessage();
        }
    }
    
    //ELIMINA UN CLIENTE CUYO CODIGO SE LE PASA POR PARAMETRO
    public static String eliminaCliente(int cod){
        String sqlEscCli="DELETE FROM ESCCLI WHERE COD_CLI=?";
        String sqlClientes="DELETE FROM CLIENTES WHERE COD_CLIENTE=?";
        try {
            ps=miConexion.prepareStatement(sqlEscCli,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cod);
            ps.executeUpdate();
            ps=miConexion.prepareStatement(sqlClientes,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cod);
            ps.executeUpdate();
        //ACTUALIZAR NUM_INTERVINIENTES
            actualizaEscCli();
        } catch (SQLException ex) {
            return "Error: "+ex.getErrorCode()+" "+ex.getMessage();
        }
        return "Cliente: "+cod+" borrado con éxito.";
    }
    
    //METODO RECORRE LA TABLA ESCRCLI cuenta el nº de intervinientes de cada Escritura.
    public static void actualizaEscCli(){
        //ArrayList donde se guardan todos los COD_ESCR existentes en TABLA ESCCLI
        ArrayList<Integer> codigosEscritura=new ArrayList<Integer>();
        //Array BIdimensional en el que se relaciona COD_ESCR con Número de intervinientes en esa Escritura
        //int[][] actualizaNumInter=null;
        boolean existe;
        try {
            String sql="SELECT COD_ESCR FROM ESCCLI";
            ps=miConexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            rs=ps.executeQuery();
            while(rs.next()){
                existe=false;
                for(int i=0;i<codigosEscritura.size();i++){
                    if(codigosEscritura.get(i)==rs.getInt(1)){
                        existe=true;
                    }
                }
                if(!existe) codigosEscritura.add(rs.getInt(1));
            }
            /*
            actualizaNumInter=new int[codigosEscritura.size()][2];
            int numInter;
            for(int i=0;i<codigosEscritura.size();i++){
                actualizaNumInter[i][0]=codigosEscritura.get(i);
                sql="SELECT * FROM ESCCLI";
                ps=miConexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                rs=ps.executeQuery();
                numInter=0;
                while(rs.next()){
                    if(rs.getInt(2)==codigosEscritura.get(i)){
                        numInter++;
                    }
                }
                actualizaNumInter[i][1]=numInter;
            }
            */
        } catch (SQLException ex) {
            System.err.println("Error: "+ex.getErrorCode()+" "+ex.getMessage());
        }
        
        for(int i=0;i<codigosEscritura.size();i++){
            actualizarNumInterv(codigosEscritura.get(i));
        }
    }
    
    //METODO DEVUELVE ARRAYLIST con el código de los Clientes que han realizado COMPRA-VENTA (CPVE)
    public static ArrayList<Integer> devuelveCodigoClientesCPVE(){
        ArrayList<Integer> codClientesCPVE=new ArrayList<Integer>();
        boolean existe=false;
        String sqlEsc="SELECT * "
                + "FROM ESCRITURAS E JOIN ESCCLI EC "
                + "ON E.COD_ESCRITURAS=EC.COD_ESCR "
                + "WHERE E.TIPO='CPVE'";
        try {
            ps=miConexion.prepareStatement(sqlEsc,Statement.RETURN_GENERATED_KEYS);
            rs=ps.executeQuery();
            while(rs.next()){
                existe=false;
                for(int i=0;i<codClientesCPVE.size();i++){
                    if(codClientesCPVE.get(i)==rs.getInt(5)){
                        existe=true;
                    }
                }
                if(!existe) codClientesCPVE.add(rs.getInt(5));
            }
        } catch (SQLException ex) {
            System.err.println("Error: "+ex.getErrorCode()+" "+ex.getMessage());
        }
        return codClientesCPVE;
    }    
    
    //CASO:14 BORRA ESCRITURA DE LA TABLA ESCRITURAS
    public static String eliminaEscritura(int cod){
        String sqlEscCli="DELETE FROM ESCCLI WHERE COD_ESCR=?";
        String sqlEscrituras="DELETE FROM ESCRITURAS WHERE COD_ESCRITURAS=?";
        try {
            ps=miConexion.prepareStatement(sqlEscCli,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cod);
            ps.executeUpdate();
            ps=miConexion.prepareStatement(sqlEscrituras,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cod);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return "Error: "+ex.getErrorCode()+" "+ex.getMessage();
        }
        return "Escritura: "+cod+" borrado con éxito.";
    }
    
    //COMPRUEBA SI EXISTE el Codigo Escritura que se pasa por parámetro
    public static String existeCodEscritura(int codEscritura){
        String sql="SELECT COD_ESCRITURAS FROM ESCRITURAS";
        try {
            ps=miConexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt(1)==codEscritura) return "Código Escritura válido";
            }
        } catch (SQLException ex) {
            return "Error: "+ex.getErrorCode()+" "+ex.getMessage();
        }
        return "Código de la Escritura no es válido, introduzca uno válido. ";
    }
    
    //COMPRUEBA SI EXISTE el Codigo Cliente que se pasa por parámetro
    public static String existeCodCliente(int codCliente){
        String sql="SELECT COD_CLIENTE FROM CLIENTES";
        try {
            ps=miConexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt(1)==codCliente) return "Código Cliente válido";
            }
        } catch (SQLException ex) {
            return "Error: "+ex.getErrorCode()+" "+ex.getMessage();
        } catch (Exception e) {
            return "Error: ";
        }
        return "Código del Cliente no es válido, introduzca uno válido. ";
    }
    
    
}