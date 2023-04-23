package ejercicio1;

/**
 *
 * @author IVAN
 */
public abstract class Transporte implements Combustible{
    public final double MANTENIMIENTO_MEDIO=280;
    private String matricula;
    private String marcaModelo;
    private TipoCombustible combustible;
    private int	kmsMaximos;
    private int	kmsRecorridos;
    private boolean enFuncionamiento;
    private double gastoMantenimiento;  //GASTOS REALES
    private double gastoCombustible;   //GASTOS REALES
    
    public static String[] MarcaModelo={"RENAULT","VOLVO","MERCEDES","AUDI"};

    public Transporte(String matricula, String marcaModelo, TipoCombustible combustible, int kmsMaximos, int kmsRecorridos, boolean enFuncionamiento, double gastoMantenimiento, double gastoCombustible) {
        this.matricula = matricula;
        this.marcaModelo = marcaModelo;
        this.combustible = combustible;
        this.kmsMaximos = kmsMaximos;
        this.kmsRecorridos = kmsRecorridos;
        this.enFuncionamiento = enFuncionamiento;
        this.gastoMantenimiento = gastoMantenimiento;
        this.gastoCombustible = gastoCombustible;
    }
    
    public abstract double calcularIngresos();
    
    public void añadirViaje(int km, double gastoCombustible){
        kmsRecorridos+=km;
        this.gastoCombustible+=gastoCombustible;
    }

    @Override
    public String toString() {
        return "Transporte{" + "MANTENIMIENTO_MEDIO=" + MANTENIMIENTO_MEDIO + ", matricula=" + matricula + ", marcaModelo=" + marcaModelo + ", combustible=" + combustible + ", kmsMaximos=" + kmsMaximos + ", kmsRecorridos=" + kmsRecorridos + ", enFuncionamiento=" + enFuncionamiento + ", gastoMantenimiento=" + gastoMantenimiento + ", gastoCombustible=" + gastoCombustible + '}';
    }
    
    public void añadirMantenimiento(double gastoMantenimiento){
        this.gastoMantenimiento+=gastoMantenimiento;
    }
    
    @Override
    public double estimarGastoCombustible(int numKm, TipoCombustible tipo){
        double gasto=-1;
        if(tipo==TipoCombustible.valueOf("GASOLINA")){
            gasto=numKm/100*CONSUMO_MEDIO[0]*PRECIO_MEDIO[0];
        }else if(tipo==TipoCombustible.valueOf("DIESEL")){
            gasto=numKm/100*CONSUMO_MEDIO[1]*PRECIO_MEDIO[1];
        }else if(tipo==TipoCombustible.valueOf("BIODIESEL")){
            gasto=numKm/100*CONSUMO_MEDIO[2]*PRECIO_MEDIO[2];
        }
        return gasto;
    }
    
    //Estimacion de GASTO
    public double estimarGastoTotal(){
        return estimarGastoCombustible(kmsRecorridos,combustible)+MANTENIMIENTO_MEDIO*kmsRecorridos;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarcaModelo() {
        return marcaModelo;
    }
    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public TipoCombustible getCombustible() {
        return combustible;
    }
    public void setCombustible(TipoCombustible combustible) {
        this.combustible = combustible;
    }

    public int getKmsMaximos() {
        return kmsMaximos;
    }
    public void setKmsMaximos(int kmsMaximos) {
        this.kmsMaximos = kmsMaximos;
    }
    
    public int getKmsRecorridos() {
        return kmsRecorridos;
    }
    public void setKmsRecorridos(int kmsRecorridos) {
        this.kmsRecorridos = kmsRecorridos;
    }
    
    public boolean isEnFuncionamiento() {
        return enFuncionamiento;
    }
    public void setEnFuncionamiento(boolean enFuncionamiento) {
        this.enFuncionamiento = enFuncionamiento;
    }
    public double getGastoMantenimiento() {
        return gastoMantenimiento;
    }

    public void setGastoMantenimiento(double gastoMantenimiento) {
        this.gastoMantenimiento = gastoMantenimiento;
    }

    public double getGastoCombustible() {
        return gastoCombustible;
    }
    public void setGastoCombustible(double gastoCombustible) {
        this.gastoCombustible = gastoCombustible;
    }
    
}