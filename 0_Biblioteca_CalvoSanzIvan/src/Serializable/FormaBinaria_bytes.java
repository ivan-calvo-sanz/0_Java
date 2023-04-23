package Serializable;

import java.io.Serializable;

public class FormaBinaria_bytes implements Serializable {

    public static final long serialVersionUID = 1L;

    //GUARDAR OBJETO SERIALIZADO    
    //envia un Objeto instancia de la Clase Departamento
    //tenemos el archivo f donde se guarda el objeto Serializado (bytes)
    private static void guardarDepartamento(Departamento departamento) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(f, true);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(departamento);
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no existe |Error: " + e);
        } catch (IOException e) {
            System.err.println("Error en la operación de Entrada/salida de datos |Error: " + e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    oos.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el Canal de salida de datos |Error: " + e);
                }
            }
        }
    }

    //DEVUELVE OBJETO SERIALIZADO    
    //devuelve un Objeto instancia de la Clase Departamento
    //tenemos el archivo f donde está guardado la instancia del objeto Serializado (bytes)
    private static Departamento devuelveDepartamento(File f) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            Departamento departamento;
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            departamento = (Departamento) ois.readObject();
            return departamento;
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no existe |Error: " + e);
        } catch (IOException e) {
            System.err.println("Error en la operación de Entrada/salida de datos |Error: " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error al generar la Clase |Error: " + e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    ois.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el Canal de entrada de datos |Error: " + e);
                }
            }
        }
        return null;
    }

}
