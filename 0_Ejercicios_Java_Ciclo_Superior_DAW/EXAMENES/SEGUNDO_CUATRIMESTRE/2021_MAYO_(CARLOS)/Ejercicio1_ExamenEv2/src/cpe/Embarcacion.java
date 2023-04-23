package cpe;

public class Embarcacion {
    
    private String matricula;
    private int metrosEslora;
    private int anoFabricacion;
    
    public Embarcacion() {}
    
    public Embarcacion(String matricula, int metrosEslora, int anoFabricacion) {
        this.matricula = matricula;
        this.metrosEslora = metrosEslora;
        this.anoFabricacion = anoFabricacion;
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

    public int getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(int anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }
    
    @Override
    public String toString() {
        return "\n[Matricula] => " + getMatricula() + "\n[Mestros eslora] => " + getMetrosEslora() + "\n[Año fabricación] => " + getAnoFabricacion();
    }

}
