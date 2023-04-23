package prog07_ejer01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author IVAN
 */
public class EditorTextos {
    
    public EditorTextos(){
    }
    
    //Abrir un archivo de texto
    public String abrirArchivoTexto(File f){      
        String linea;
        String txt="";
        FileReader fr;
        BufferedReader br;
        try{
            fr=new FileReader(f);
            br=new BufferedReader(fr);
            while((linea=br.readLine())!=null){
                txt+=linea+"\n";
            }
            fr.close();
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EditorTextos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EditorTextos.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return txt;
    }
    
    public String guardaTexto(File f, String txt){
        String respuesta="Fallo al escribir en el archivo";
        try{
            FileWriter fw=new FileWriter(f,true);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write(txt);
            respuesta="Escritura realizada correctamente";
            bw.close();            
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(EditorTextos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    
}