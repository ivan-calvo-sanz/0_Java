package ejercicio1;

/**
 *
 * @author IVAN
 */
public final class Yate extends Embarcacion{
    private int numCamarotes;
    private String tipo;    //clásico, de buceo, de pesa y de gran velocidad.

    public Yate(int numCamarotes, String tipo, String matricula, int mEslora, int añoFab) {
        super(matricula, mEslora, añoFab);
        this.numCamarotes = numCamarotes;
        this.tipo = tipo;
        super.setPrecioBaseDiario(calcularPrecioBaseDiario());
    }

    public int getNumCamarotes() {
        return numCamarotes;
    }
    public void setNumCamarotes(int numCamarotes) {
        this.numCamarotes = numCamarotes;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public double calcularPrecioBaseDiario(){
            int cantidad=0;
            if(tipo.equalsIgnoreCase("CLASICO")){
                cantidad=5;
            }else if(tipo.equalsIgnoreCase("BUCEO")){
                cantidad=10;
            }else if(tipo.equalsIgnoreCase("PESCA")){
                cantidad=15;
            }else if(tipo.equalsIgnoreCase("VELOCIDAD")){
                cantidad=20;
            }
        return super.getmEslora()*100+(2000-super.getAñoFab())*10+(numCamarotes*2+cantidad);
    }

    @Override
    public String toString() {
        return super.toString()+"Yate{" + "numCamarotes=" + numCamarotes + ", tipo=" + tipo + '}';
    }
    
}