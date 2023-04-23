package ejercicio1;

public abstract class Embarcacion {

    private String matricula;
    private int metrosEslora;
    private int anioFabricacion;
    private double precioBaseDiario;
    private double suplemento;

    public Embarcacion(String matricula, int metrosEslora, int anioFabricacion) {
        this.matricula = matricula;
        this.metrosEslora = metrosEslora;
        this.anioFabricacion = anioFabricacion;
        this.precioBaseDiario = calculaPrecioBaseDiario(metrosEslora, anioFabricacion);
    }

    private double calculaPrecioBaseDiario(int metrosEslora, int anioFabricacion) {
        double result;
        result = (metrosEslora * 100);
        double penalizacion = 0;
        if (anioFabricacion < 2000) {
            penalizacion = 10 * (2000 - anioFabricacion);
        }
        result += penalizacion;
        return result;
    }

    abstract double calculaSuplemento();

    @Override
    public String toString() {
        return "Embarcacion{" + "matricula=" + matricula + ", metrosEslora=" + metrosEslora + ", anioFabricacion=" + anioFabricacion + ", precioBaseDiario=" + precioBaseDiario + ", suplemento=" + suplemento + '}';
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getMetrosEslora() {
        return metrosEslora;
    }

    public void setMetrosEslora(int metrosEslora) {
        this.metrosEslora = metrosEslora;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public double getPrecioBaseDiario() {
        return precioBaseDiario;
    }

    public void setPrecioBaseDiario(double precioBaseDiario) {
        this.precioBaseDiario = precioBaseDiario;
    }

    public double getSuplemento() {
        return suplemento;
    }

    public void setSuplemento(double suplemento) {
        this.suplemento = suplemento;
    }

}
