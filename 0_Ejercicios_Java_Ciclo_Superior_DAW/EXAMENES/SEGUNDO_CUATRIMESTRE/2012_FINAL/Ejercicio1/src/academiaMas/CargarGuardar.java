package academiaMas;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author IVAN
 */
public class CargarGuardar<T> {
    //T es el parámetro de tipo genérico
    public boolean guardar(ArrayList<T> lista,File fichero){
            try {
                ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fichero));
                oos.writeObject(lista);
                oos.flush();
                oos.close();
                return true;
            } catch (FileNotFoundException e){
                System.err.println("Archivo NO encontrado");
                return false;
            } catch (IOException ex) {
                System.err.println("Error al guardar");
                return false;
            }
    }
    
    public ArrayList<T> cargar(File fichero){        
        ArrayList<T> lista=null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            lista=(ArrayList<T>)ois.readObject();
            ois.close();
            return lista;
        } catch (ClassNotFoundException e) {
            System.err.println("Error de Clase al cargar fichero");
            return null;
        } catch (FileNotFoundException ex) {
            System.err.println("Archivo NO encontrado");
            return null;
        } catch (IOException ex) {
            System.err.println("Error al cargar");
            return null;
        }
    }
        
}
