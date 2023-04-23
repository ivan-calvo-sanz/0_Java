package ejercicio1;

/**
 *
 * @author IVAN
 */
public class JugadorDeCampo extends Jugador{
    private int goles;

    public JugadorDeCampo(int goles, int dorsal, int numEstrellas) {
        super(dorsal, numEstrellas);
        this.goles = goles;
    }
    
    @Override
    public int calcularPuntuacion(){
        int punt=super.getNumEstrellas()*2+goles*3;
        super.setPuntuacion(punt);
        return punt;
    }
    
    @Override
    public void simularPuntuacion(){
        goles=Main.generarNumAleatorio(0, 10);
        super.setNumEstrellas(Main.generarNumAleatorio(1, 5));
    }

    @Override
    public String toString() {
        return super.toString()+"JugadorDeCampo{" + "goles=" + goles + '}';
    }

    public int getGoles() {
        return goles;
    }
    public void setGoles(int numGoles) {
        this.goles = numGoles;
    }
    
}