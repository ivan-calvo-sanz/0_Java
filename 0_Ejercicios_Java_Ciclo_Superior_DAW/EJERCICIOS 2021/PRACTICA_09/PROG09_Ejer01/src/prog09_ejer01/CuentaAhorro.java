package prog09_ejer01;

/*
    Clase CuentaAhorro
    hereda de CuentaBancaria y tiene que sobreescribir el método de la interfaz imprimible
    mostrarInfo()
*/
public class CuentaAhorro extends CuentaBancaria{
    private double tipoInteres;

    public CuentaAhorro(double tipoInteres, double saldo, Persona titular, String numCuenta) {
        super(saldo, titular, numCuenta);
        this.tipoInteres = tipoInteres;
    }
    
    @Override
    public String mostrarInfo(){
        StringBuilder infoCuentaAhorro=new StringBuilder();
        infoCuentaAhorro.append("INFORMACION CUENTA AHORRO \n");
        infoCuentaAhorro.append("CCC: "+getNumCuenta()+"\n");
        infoCuentaAhorro.append(getTitular().mostrarInfo()+"\n");
        infoCuentaAhorro.append("Saldo actual: "+getSaldo()+"\n");
        infoCuentaAhorro.append("Tipo de Interes: "+getTipoInteres()+"\n");
        
        return infoCuentaAhorro.toString();
    }
    
    

    public double getTipoInteres() {
        return tipoInteres;
    }
    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }
    
}