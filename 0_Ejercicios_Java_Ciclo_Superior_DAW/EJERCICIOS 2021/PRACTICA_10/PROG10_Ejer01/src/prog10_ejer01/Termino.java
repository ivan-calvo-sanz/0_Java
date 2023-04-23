package prog10_ejer01;

import java.util.ArrayList;

/**
 *
 * @author IVAN
 */
public class Termino {
    private int id;
    private String palabra;
    private int numVisto;
    private ArrayList<Idioma> idiomas;

    public Termino() {
    }

    public Termino(String palabra, ArrayList<Idioma> idiomas) {
        this.palabra = palabra;
        this.numVisto = 0;
        this.idiomas = idiomas;
    }
    
    public Termino(int id, String palabra, int numVisto, ArrayList<Idioma> idiomas) {
        this.id = id;
        this.palabra = palabra;
        this.numVisto = numVisto;
        this.idiomas = idiomas;
    }
    
    public Termino(int id, String palabra, int numVisto) {
        this.id = id;
        this.palabra = palabra;
        this.numVisto = numVisto;
        this.idiomas = new ArrayList();
    }
    
    
    public void addIdioma(Idioma idioma){
        this.idiomas.add(idioma);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPalabra() {
        return palabra;
    }
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
    public int getNumVisto() {
        return numVisto;
    }
    public void setNumVisto(int numVisto) {
        this.numVisto = numVisto;
    }
    public ArrayList<Idioma> getIdiomas() {
        return idiomas;
    }
    public void setIdiomas(ArrayList<Idioma> idiomas) {
        this.idiomas = idiomas;
    }
    
    public void imprimeTermino(){
        System.out.println("<- "+this.palabra +" ID:"+this.id+" Visto: "+this.numVisto+" ->");
        for(int i=0;i<this.idiomas.size();i++){
            System.out.println("Idioma: "+this.idiomas.get(i).getIdioma()+" Traduccion: "+this.idiomas.get(i).getTraduccion());
        }
    }
    
}