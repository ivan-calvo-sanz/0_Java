package ejercicio1;

/**
 *
 * @author IVAN
 */
public final class Lancha extends Embarcacion{
    private double potencia;
    private int numPasajeros;

    public Lancha(double potencia, int numPasajeros, String matricula, int mEslora, int añoFab) {
        super(matricula, mEslora, añoFab);
        this.potencia = potencia;
        this.numPasajeros = numPasajeros;
        super.setPrecioBaseDiario(calcularPrecioBaseDiario());
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

    @Override
    public String toString() {
        return super.toString()+" Lancha{" + "potencia=" + potencia + ", numPasajeros=" + numPasajeros + '}';
    }
    
    @Override
    public double calcularPrecioBaseDiario(){
        return super.getmEslora()*100+(2000-super.getAñoFab())*10+(potencia/numPasajeros);
    }
    
}