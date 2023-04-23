package ejercicio1;

/**
 *
 * @author IVAN
 */
public class TransportePrivado extends Transporte{
    private  int codConductor;

    public TransportePrivado(int codConductor, String matricula, String marcaModelo, TipoCombustible combustible, int kmsMaximos, int kmsRecorridos, boolean enFuncionamiento, double gastoMantenimiento, double gastoCombustible) {
        super(matricula, marcaModelo, combustible, kmsMaximos, kmsRecorridos, enFuncionamiento, gastoMantenimiento, gastoCombustible);
        this.codConductor = codConductor;
    }

    @Override
    public double calcularIngresos() {
        return (super.getGastoCombustible()+super.getGastoMantenimiento())*1.2;
    }

    @Override
    public String toString() {
        return "TransportePrivado{" + "codConductor=" + codConductor + '}'+super.toString();
    }

    public int getCodConductor() {
        return codConductor;
    }
    public void setCodConductor(int codConductor) {
        this.codConductor = codConductor;
    }

}