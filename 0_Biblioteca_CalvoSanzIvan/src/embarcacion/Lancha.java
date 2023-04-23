package embarcacion;

public class Lancha extends Embarcacion {

    private double potencia;
    private int numPasajeros;

    public Lancha(double potencia, int numPasajeros, String matricula, int metrosEslora, int anioFabricacion) {
        super(matricula, metrosEslora, anioFabricacion);
        this.potencia = potencia;
        this.numPasajeros = numPasajeros;
        super.setSuplemento(calculaSuplemento());
    }

    @Override
    double calculaSuplemento() {
        double result;
        result = this.potencia / this.numPasajeros;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "Lancha{" + "potencia=" + potencia + ", numPasajeros=" + numPasajeros + '}';
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

}
