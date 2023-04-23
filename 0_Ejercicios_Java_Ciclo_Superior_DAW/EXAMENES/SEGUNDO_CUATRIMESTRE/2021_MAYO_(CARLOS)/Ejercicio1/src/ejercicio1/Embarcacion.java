package ejercicio1;

/**
 *
 * @author IVAN
 */
public abstract class Embarcacion{
    private String matricula;
    private int mEslora;
    private int añoFab;
    private double precioBaseDiario;

    public Embarcacion(String matricula, int mEslora, int añoFab) {
        this.matricula = matricula;
        this.mEslora = mEslora;
        this.añoFab = añoFab;
    }
    
    public abstract double calcularPrecioBaseDiario();

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getmEslora() {
        return mEslora;
    }
    public void setmEslora(int mEslora) {
        this.mEslora = mEslora;
    }

    public int getAñoFab() {
        return añoFab;
    }
    public void setAñoFab(int añoFab) {
        this.añoFab = añoFab;
    }

    public double getPrecioBaseDiario() {
        return precioBaseDiario;
    }
    public void setPrecioBaseDiario(double precioBaseDiario) {
        this.precioBaseDiario = precioBaseDiario;
    }
    
    @Override
    public String toString() {
        return "Embarcacion{" + "matricula=" + matricula + ", mEslora=" + mEslora + ", a\u00f1oFab=" + añoFab + ", precioBaseDiario=" + precioBaseDiario + '}';
    }
    
}