package ejercicio1;

/**
 *
 * @author IVAN
 */
public class Portero extends Jugador {
    private int golesRecibidos;

    public Portero(int golesRecibidos, int dorsal, int numEstrellas) {
        super(dorsal, numEstrellas);
        this.golesRecibidos = golesRecibidos;
    }

    public Portero() {
    }
    
    @Override
    public int calcularPuntuacion(){
        int punt=super.getNumEstrellas()*2-golesRecibidos;
        super.setPuntuacion(punt);
        return punt;
    }
    
    @Override
    public void simularPuntuacion(){
        golesRecibidos=Main.generarNumAleatorio(0, 10);
        super.setNumEstrellas(Main.generarNumAleatorio(1, 5));
    }    

    @Override
    public String toString() {
        return super.toString()+"Portero{" + "golesRecibidos=" + golesRecibidos + '}';
    }
    
    public int getGolesRecibidos() {
        return golesRecibidos;
    }
    public void setGolesRecibidos(int golesRecibidos) {
        this.golesRecibidos = golesRecibidos;
    }
    
}