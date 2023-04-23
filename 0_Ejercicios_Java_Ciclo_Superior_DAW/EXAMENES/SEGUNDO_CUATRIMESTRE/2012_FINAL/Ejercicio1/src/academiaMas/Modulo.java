package academiaMas;

import java.io.Serializable;

/**
 *
 * @author IVAN
 */
public class Modulo implements Serializable{
    private String nombre;
    private int horas;
    private int unidades;

    public Modulo(String nombre, int horas, int unidades) {
        if(horas<0||unidades<0) throw new IllegalArgumentException ("Valor negativo");
        this.nombre = nombre;
        this.horas = horas;
        this.unidades = unidades;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getHoras() {
        return horas;
    }
    public void setHoras(int horas) {
        if(horas<0) throw new IllegalArgumentException ("Valor negativo");
        this.horas = horas;
    }
    public int getUnidades() {
        return unidades;
    }
    public void setUnidades(int unidades) {
        if(unidades<0) throw new IllegalArgumentException ("Valor negativo");
        this.unidades = unidades;
    }
    
}