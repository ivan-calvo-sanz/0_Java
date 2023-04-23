package ejercicio1;

/**
 *
 * @author IVAN
 */
public class TransportePublico extends Transporte {

    public TransportePublico(String matricula, String marcaModelo, TipoCombustible combustible, int kmsMaximos, int kmsRecorridos, boolean enFuncionamiento, double gastoMantenimiento, double gastoCombustible) {
        super(matricula, marcaModelo, combustible, kmsMaximos, kmsRecorridos, enFuncionamiento, gastoMantenimiento, gastoCombustible);
    }

    @Override
    public double calcularIngresos() {
        return (super.getGastoMantenimiento()+super.getGastoCombustible())*1.3;
    }
    
    public void añadirViaje(int km){
        if(km>super.getKmsMaximos()){
            super.setEnFuncionamiento(false);
        }
    }

    @Override
    public String toString() {
        return "TransportePublico{" + '}'+super.toString();
    }
    
}