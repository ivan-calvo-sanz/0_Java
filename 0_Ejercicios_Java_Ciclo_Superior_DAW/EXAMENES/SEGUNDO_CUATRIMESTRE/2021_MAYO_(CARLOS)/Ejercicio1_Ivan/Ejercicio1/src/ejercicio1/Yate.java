package ejercicio1;

public class Yate extends Embarcacion {

    public enum TipoYate {
        CLASICO, BUCEO, PESCA, VELOCIDAD
    };
    private TipoYate tipo;
    private int numCamarotes;

    public Yate(TipoYate tipo, int numCamarotes, String matricula, int metrosEslora, int anioFabricacion) {
        super(matricula, metrosEslora, anioFabricacion);
        this.tipo = tipo;
        this.numCamarotes = numCamarotes;
        super.setSuplemento(calculaSuplemento());
    }

    @Override
    double calculaSuplemento() {
        double result;
        result = numCamarotes * 2;
        if (tipo == TipoYate.CLASICO) {
            result += 5;
        } else if (tipo == TipoYate.BUCEO) {
            result += 10;
        } else if (tipo == TipoYate.PESCA) {
            result += 15;
        } else if (tipo == TipoYate.VELOCIDAD) {
            result += 20;
        }
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "Yate{" + "tipo=" + tipo + ", numCamarotes=" + numCamarotes + '}';
    }

    public TipoYate getTipo() {
        return tipo;
    }

    public void setTipo(TipoYate tipo) {
        this.tipo = tipo;
    }

    public int getNumCamarotes() {
        return numCamarotes;
    }

    public void setNumCamarotes(int numCamarotes) {
        this.numCamarotes = numCamarotes;
    }

}
