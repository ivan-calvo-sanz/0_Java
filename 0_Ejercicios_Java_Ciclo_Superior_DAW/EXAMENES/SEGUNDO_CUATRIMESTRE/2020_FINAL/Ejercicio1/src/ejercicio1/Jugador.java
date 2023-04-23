package ejercicio1;

/**
 *
 * @author IVAN
 */
public abstract class Jugador {
    private int dorsal;
    private int numEstrellas;
    private int puntuacion;

    public Jugador(int dorsal, int numEstrellas) {
        this.dorsal = dorsal;
        this.numEstrellas = numEstrellas;
    }

    public Jugador() {
    }   

    @Override
    public String toString() {
        return "Jugador{" + "dorsal=" + dorsal + ", numEstrellas=" + numEstrellas + '}';
    }
 
    public abstract int calcularPuntuacion();
    
    public abstract void simularPuntuacion();

    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    public int getNumEstrellas() {
        return numEstrellas;
    }
    public void setNumEstrellas(int numEstrellas) {
        this.numEstrellas = numEstrellas;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    
    
}