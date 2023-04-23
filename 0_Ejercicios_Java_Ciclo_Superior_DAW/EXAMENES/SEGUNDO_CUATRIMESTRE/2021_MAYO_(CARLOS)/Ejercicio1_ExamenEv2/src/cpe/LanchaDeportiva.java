package cpe;

public class LanchaDeportiva extends Embarcacion {
    
    private int potenciaMotor;
    private int numeroPasajeros;
    
    public LanchaDeportiva() {}
    
    public LanchaDeportiva(String matricula, int metrosEslora, int anoFabricacion, int potenciaMotor, int numeroPasajeros) {
        super(matricula, metrosEslora, anoFabricacion);
        this.potenciaMotor = potenciaMotor;
        this.numeroPasajeros = numeroPasajeros;
    }

    public int getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(int potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }
    
    @Override
    public String toString() {
        return super.toString() +
            "\n[Potencia del motor] => " + getPotenciaMotor() + "\n[Número de pasajeros] => " + getNumeroPasajeros();
    }
    
}
