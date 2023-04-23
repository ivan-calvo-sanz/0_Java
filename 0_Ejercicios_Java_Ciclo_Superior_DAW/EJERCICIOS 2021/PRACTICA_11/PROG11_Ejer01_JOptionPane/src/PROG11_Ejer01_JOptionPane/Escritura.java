package PROG11_Ejer01_JOptionPane;

/**
 *
 * @author IVAN
 */
public class Escritura {
    private int cod;
    private String tipo;
    private String nomFicha;
    private int numInterv;

    public Escritura() {
    }

    public Escritura(int cod, String tipo, String nomFicha) {
        this.cod = cod+1000;
        this.tipo = tipo;
        this.nomFicha = nomFicha;
        this.numInterv = 0;
    }

    public Escritura(int cod, String tipo, String nomFicha, int numInterv) {
        this.cod = cod;
        this.tipo = tipo;
        this.nomFicha = nomFicha;
        this.numInterv = numInterv;
    }
    
    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomFicha() {
        return nomFicha;
    }
    public void setNomFicha(String nomFicha) {
        this.nomFicha = nomFicha;
    }

    public int getNumInterv() {
        return numInterv;
    }
    public void setNumInterv(int numInterv) {
        this.numInterv = numInterv;
    }
    
    public String imprimeEscritura(){
        return "ESCRITURA:"+cod+" // TIPO:"+tipo+" // Nombre Ficha:"+nomFicha+" // nº Intervinientes:"+numInterv;
    }
    
}