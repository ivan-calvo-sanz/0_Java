package prog10_ejer01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IVAN
 */
public class PROG10_Ejer01 {

    /**
     * @param args the command line arguments
     */
    
    static Scanner entrada=new Scanner(System.in);
    static ArrayList<Idioma> idiomas=new ArrayList();
    static ArrayList<Termino> terminos=new ArrayList();
    static Termino objTermino;
    static Connection miConexion;
    static Statement miStatement;
    static final String ERROR_INPUT="Datos introducidos erroneos";
    static final String MENU_PRINCIPAL
            = "\n************************\n"
            + "*****MENU PRINCIPAL*****\n"
            + "************************\n"
            + "1-INSERTAR NUEVO TERMINO\n"
            + "2-BORRAR TERMINO EXISTENTE\n"
            + "3-TRADUCIR TERMINO EXISTENTE\n"
            + "4-CONSULTAR TERMINO\n"
            + "5-SALIR\n";
    
    public static void main(String[] args) {
        ConsultaBBDD.ConectarBBDD();
        miConexion=ConsultaBBDD.getConexion();
        System.out.println(MENU_PRINCIPAL);
        System.out.println("Introduce opción del Menú:");
        int opcion;
        boolean validar;
            try {
                do{    
                    opcion=entrada.nextInt();
                    if(opcion>0&&opcion<6){
                        validar=true;
                        switch (opcion){
                            case 1:
                                insertarTermino();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 2:
                                borrarTermino();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 3:
                                traducirTermino();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 4:
                                consultaTermino();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 5:
                                ConsultaBBDD.cerrarConexion();
                                System.out.println("¡HASTA PRONTO!");
                                System.out.println("***La aplicacion se ha cerrado***");
                                break;
                        }
                    }else{
                        validar=false;
                        System.err.println("La opcion tiene que ser entre 1 y 5");
                        System.out.println("Introduce opción del Menú:");
                    }
                }while(opcion!=5||!validar);
            } catch (Exception e) {
                System.err.println(ERROR_INPUT);
            }
    }
    
    public static void insertarTermino(){
        int opcion;
        String palabra,idioma,traduccion;
        System.out.println("Introduce nueva palabra al diccionario:");
        entrada.nextLine();    //consumir Buffer
        do{
            palabra=entrada.nextLine();
        }while(!validaNuevaPalabra(palabra));
            System.out.println("¿Quiere traducir a un idioma? (SI-'1'  NO='2')");
            opcion=entrada.nextInt();
            entrada.nextLine();    //consumir Buffer
        while(opcion==1){
            System.out.println("Introduce idioma");
            idioma=entrada.nextLine();
            System.out.println("Introduce traduccion");
            traduccion=entrada.nextLine();
            Idioma objIdioma=new Idioma(idioma,traduccion);
            idiomas.add(objIdioma);
            System.out.println("¿Quiere traducir a otro idiomai? -> (1=SI | 2=NO)");
            opcion=entrada.nextInt();
            entrada.nextLine();    //consumir Buffer
        } 
        objTermino=new Termino(palabra,idiomas);
        guardarTerminoBBDD(objTermino);
    }

    
    /*********************
    METODOS DE OPERACION Y CONSULTA CON LA BBDD
    *********************/    

    //Guarda un nuevo Termino en el Diccionario
    private static void guardarTerminoBBDD(Termino termino){
            int id=obtenerID();
            String sentenciaTraduccion;
            try {
                //PREPARA CONSULTA TABLA DICCIONARIO
                String sentenciaDiccionario="INSERT INTO DICCIONARIO (ID,TERMINO,NUM_VISTO) VALUES (?,?,?)";
                PreparedStatement ps=miConexion.prepareStatement(sentenciaDiccionario, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, id);
                ps.setString(2, termino.getPalabra().toUpperCase());
                ps.setInt(3, 0);
                //EJECUTA CONSULTA TABLA DICCIONARIO
                ps.executeUpdate();
                //PREPARA CONSULTA TABLA TRADUCCION
                for(int i=0;i<termino.getIdiomas().size();i++){
                    sentenciaTraduccion="INSERT INTO TRADUCCION (CODIGO,ID_TERMINO,IDIOMA,TRADUCCION) VALUES (?,?,?,?)";
                    ps=miConexion.prepareStatement(sentenciaTraduccion, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, obtenerCodigo());
                    ps.setInt(2, id);
                    ps.setString(3,termino.getIdiomas().get(i).getIdioma().toUpperCase());
                    ps.setString(4,termino.getIdiomas().get(i).getTraduccion().toUpperCase());
                    //EJECUTA CONSULTA TABLA TRADUCCION
                    ps.executeUpdate();
                }            
                System.out.println("Datos introduciodos correctamente");
            } catch (SQLException e) {
                System.err.println("Error: "+e.getErrorCode()+" "+e.getMessage());
            }    
    }

    //Determina el siguiente valor de ID
    private static int obtenerID(){
        int id=0;
        try {
            miStatement=miConexion.createStatement();
            //3-EJECUTAR SQL (devuelve un objeto tipo ResultSet)
            ResultSet miResulset=miStatement.executeQuery("SELECT ID FROM DICCIONARIO");
                    while(miResulset.next()){
                        id=miResulset.getInt("ID")+1;
                    }
            } catch (Exception e) {
            }
        return id;
    }

    //Determina el siguiente valor de CODIGO
    private static int obtenerCodigo(){
        int cod=0;
        try {
            miStatement=miConexion.createStatement();
            //3-EJECUTAR SQL (devuelve un objeto tipo ResultSet)
            ResultSet miResulset=miStatement.executeQuery("SELECT CODIGO FROM TRADUCCION");
                    while(miResulset.next()){
                        cod=miResulset.getInt("CODIGO")+1;
                    }
            } catch (Exception e) {
            }
        return cod;
    }

    //Borra termino de la BD
    public static void borrarTermino(){
        entrada.nextLine();    //consumir Buffer
        System.out.println("Introduce palabra a borrar del diccionario:");
        String palabra=entrada.nextLine().toUpperCase();
        int opc,id;
        if(buscaPalabra(palabra)){
            System.out.println("Está seguro que desea borrar del diccionario la palabra: "+palabra+" ?  -> (1=SI | 2=NO)");
            opc=entrada.nextInt();
            if(opc==1){
                try {
                    id=devuelveId(palabra);
                    //PREPARA CONSULTA TABLA TRADUCCION
                    String sentenciaTraduccion="DELETE FROM TRADUCCION WHERE ID_TERMINO=?";
                    PreparedStatement psTraduccion=miConexion.prepareStatement(sentenciaTraduccion,Statement.RETURN_GENERATED_KEYS);
                    psTraduccion.setInt(1, id);
                    //PREPARA CONSULTA TABLA DICCIONARIO
                    String sentenciaDiccionario="DELETE FROM DICCIONARIO WHERE ID=?";
                    PreparedStatement psDiccionario=miConexion.prepareStatement(sentenciaDiccionario,Statement.RETURN_GENERATED_KEYS);
                    psDiccionario.setInt(1, id);
                    //EJECUTA CONSULTA TABLA TRADUCCION Y CONSULTA TABLA DICCIONARIO
                        if(psTraduccion.executeUpdate()==1 && psDiccionario.executeUpdate()==1){
                            System.out.println("La palabra "+palabra+" ha sido borrada del diccionario.");
                        }
                    } catch (SQLException ex) {
                        System.out.println("ERROR: "+ex.getErrorCode()+" "+ex.getMessage());
                }
            }
            
        }else{
            System.out.println("La palabra: "+palabra+" NO existe en el Diccionario");
        }
    }
    
    //Busca en TABLA DICCIONARIO si existe la palabra
    public static boolean buscaPalabra(String palabara){
        boolean result=false;
        try {
            miStatement=miConexion.createStatement();
            //3-EJECUTAR SQL (devuelve un objeto tipo ResultSet)
            ResultSet miResulset=miStatement.executeQuery("SELECT TERMINO FROM DICCIONARIO");
                    while(miResulset.next()){
                        if(miResulset.getString("TERMINO").equalsIgnoreCase(palabara)) result=true;
                    }
        } catch (Exception e) {
        }
        return result;
    }
    
    //Devuelve id de una palabra existente en TABLA DICCIONARIO
    private static int devuelveId(String palabra){
        int id=0;
        try {
            //PREPARA CONSULTA TABLA DICCIONARIO
            String sentenciaDiccionario="SELECT ID FROM DICCIONARIO WHERE TERMINO=?";
            PreparedStatement ps=miConexion.prepareStatement(sentenciaDiccionario, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,palabra);
            //EJECUTA CONSULTA TABLA DICCIONARIO
            ResultSet rs=ps.executeQuery();
            while(rs.next()){        
                id=rs.getInt("ID");
            }
        } catch (SQLException ex) {
        }
        return id;
    }
    
    //Introduce nueva traduccion a una palabra ya existente en el Diccionario
    private static void traducirTermino(){
        entrada.nextLine();    //consumir Buffer
        System.out.println("Introduce palabra a la que quieres añadir nueva traduccion:");
        String palabra=entrada.nextLine().toUpperCase();
        int id;
        boolean valida=false;
        if(buscaPalabra(palabra)){
            id=devuelveId(palabra);
            String idioma,traduccion=null;
            do{
                System.out.println("Introduce el idioma al que quiere traducir");
                idioma=entrada.nextLine().toUpperCase();
                if(verificarTraduccion(id,idioma)){
                    valida=true;
                    System.out.println("Introduce traduccion");
                    traduccion=entrada.nextLine().toUpperCase();
                }else{
                    System.out.println("La traduccion en este idioma ya existe, introduce nueva traduccion.");
                }
            }while(!valida);
                Idioma nIdioma=new Idioma(idioma,traduccion);
           try {     
                String sentenciaTraduccion="INSERT INTO TRADUCCION (CODIGO,ID_TERMINO,IDIOMA,TRADUCCION) VALUES (?,?,?,?)";
                PreparedStatement ps=miConexion.prepareStatement(sentenciaTraduccion, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, obtenerCodigo());
                ps.setInt(2, id);
                ps.setString(3,nIdioma.getIdioma().toUpperCase());
                ps.setString(4,nIdioma.getTraduccion().toUpperCase());
                //EJECUTA CONSULTA TABLA TRADUCCION
                ps.executeUpdate();
            } catch (SQLException ex) {
            }
            System.out.println("Datos introduciodos correctamente");
        }else{
            System.out.println("La palabra "+palabra+" NO existe en el diccionario");
        }
    }
        
    //Verifica si existe esa traduccion de ese termino
    private static boolean verificarTraduccion(int id,String idioma){
        ArrayList<Termino> terminos=obtenerTerminos();
        Termino t=new Termino();
        for(int i=0;i<terminos.size();i++){
            if(terminos.get(i).getId()==id){
                t=terminos.get(i);
            }
        }
        ArrayList<Idioma> idiomas=obtenerIdiomas(t);
        for(int i=0;i<idiomas.size();i++){
            if(idiomas.get(i).getIdioma().equals(idioma)){
                return false;
            }
        }
        return true;
    }
    
    //Devuelve ArrayList con todos los términos de la BBDD ordenados por ID
    private static ArrayList<Termino> obtenerTerminos(){
        ArrayList<Termino> terminos=new ArrayList();
        try {
            String sentencia="SELECT ID,TERMINO,NUM_VISTO FROM DICCIONARIO ORDER BY ID";
            PreparedStatement ps=miConexion.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            //EJECUTA SELECCION
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Termino t=new Termino();
                t.setId(rs.getInt(1));
                t.setPalabra(rs.getString(2));
                t.setNumVisto(rs.getInt(3));
                terminos.add(t);
            }
        } catch (SQLException ex) {
            System.err.println("No conecta."+ex.getErrorCode()+" "+ex.getMessage());
        }
        return terminos;
    }
    
    //Obtemer idiomas de un Termino
    private static ArrayList<Idioma> obtenerIdiomas(Termino t){
        ArrayList<Idioma> idiomas=new ArrayList();
        try {
            int id_termino=t.getId();
            String sentencia="SELECT CODIGO,ID_TERMINO,IDIOMA,TRADUCCION FROM TRADUCCION WHERE ID_TERMINO=?";
            PreparedStatement ps=miConexion.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_termino);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Idioma i=new Idioma();
                i.setIdioma(rs.getString(3));
                i.setTraduccion(rs.getString(4));
                idiomas.add(i);
            }         
        } catch (SQLException ex) {
            System.err.println("No conecta."+ex.getErrorCode()+" "+ex.getMessage());
        }
        return idiomas;
    }
    
    
    
    //Consulta termino existente en la BD
    private static void consultaTermino(){
        int opcion;
        String texto;
        System.out.println("Introduce opción de consulta:");
        System.out.println("1-Busca términos que empiece por un valor determinado");
        System.out.println("2-Busca términos que terminen por un valor determinado");
        System.out.println("3-Busca términos que contengan un valor determinado");
        System.out.println("4-Busca término explícito");
        System.out.println("5-Salir");
        opcion=entrada.nextInt();
        entrada.nextLine();    //consumir Buffer
        ArrayList<Termino> terminos=new ArrayList();
        if(opcion!=5){    
            System.out.println("Introduce texto a buscar");
            texto=entrada.nextLine().toUpperCase();
            try {
                String sentenciaDiccTra="SELECT D.ID,D.TERMINO,D.NUM_VISTO,T.IDIOMA,T.TRADUCCION "
                        + "FROM DICCIONARIO D JOIN TRADUCCION T "
                        + "ON D.ID=T.ID_TERMINO "
                        + "WHERE D.TERMINO LIKE ?";
                    switch (opcion){
                        case 1:
                            texto=texto+"%";
                            break;
                        case 2:
                            texto="%"+texto;
                            break;
                        case 3:
                            texto="%"+texto+"%";
                            break;
                        case 4:
                            texto=texto;
                            break;
                        case 5:
                            break;
                    }
                    
                int id,numVisto,iEncontrado;
                String palabra,idioma,traduccion;
                PreparedStatement ps=miConexion.prepareStatement(sentenciaDiccTra, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, texto);
                String sentenciaNumVisto="UPDATE DICCIONARIO SET NUM_VISTO=? WHERE ID=?";
                PreparedStatement psNumVisto=miConexion.prepareStatement(sentenciaNumVisto, Statement.RETURN_GENERATED_KEYS);
                //EJECUTA SELECCION
                ResultSet rs=ps.executeQuery();
                while(rs.next()){        
                    id=rs.getInt("ID");
                    palabra=rs.getString("TERMINO");
                    numVisto=rs.getInt("NUM_VISTO");
                    idioma=rs.getString("IDIOMA");
                    traduccion=rs.getString("TRADUCCION");
                    iEncontrado=-1;
                    for(int i=0;i<terminos.size();i++){
                        if(terminos.get(i).getId()==id){
                            iEncontrado=i;
                        }
                    }
                    
                    if(iEncontrado>=0){
                        Idioma inuevo=new Idioma(idioma,traduccion);
                        terminos.get(iEncontrado).addIdioma(inuevo);
                    }else{
                            numVisto++;
                            psNumVisto.setInt(1, numVisto);
                            psNumVisto.setInt(2, id);
                            psNumVisto.executeUpdate();
                            Idioma inuevo=new Idioma(idioma,traduccion);
                            Termino tnuevo=new Termino(id,palabra,numVisto);
                            tnuevo.addIdioma(inuevo);
                            terminos.add(tnuevo);     
                    }
                }
                
            } catch (SQLException ex) {
                System.err.println("No conecta."+ex.getErrorCode()+" "+ex.getMessage());
            }
            
            System.out.println("Tamaño de terminos es: "+terminos.size());
            for(int i=0;i<terminos.size();i++){
                terminos.get(i).imprimeTermino();
            }   
        }
    }
    
    
    /*********************
    METODOS DE VALIDACION DE DATOS INTRODUCIDOS POR CONSOLA
    *********************/ 

    //comprueba que la palabra a introducir no existe en el diccionario    
    private static boolean validaNuevaPalabra(String palabra){
            try {
                miStatement=miConexion.createStatement();
                //3-EJECUTAR SQL (devuelve un objeto tipo ResultSet)
                ResultSet miResulset=miStatement.executeQuery("SELECT TERMINO FROM DICCIONARIO");
                //4-RECORRER ResulSet (es una tabla virtual)
                while(miResulset.next()){
                    //System.out.println(miResulset.getString("TERMINO"));
                    if(miResulset.getString("TERMINO").equalsIgnoreCase(palabra)){
                        System.out.println("Esta palabra ya existe en el diccionario, introduce otra:");
                        return false;
                    }
                }
            } catch (SQLException e) {
                System.err.println("No conecta."+e.getErrorCode()+" "+e.getMessage());
            }    
        return true;
    }
    
    
}