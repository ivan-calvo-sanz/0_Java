package prog09_ejer01;

import java.util.Hashtable;

public class CuentaCorrienteEmpresa extends CuentaCorriente{
    private double tipoInteresDescubierto;
    private double maxDescubiertoPermitido;
    private double comisionFijaPorDescubierto;

    public CuentaCorrienteEmpresa(double tipoInteresDescubierto, double maxDescubiertoPermitido, double comisionFijaPorDescubierto, Hashtable listaEntidad, double saldo, Persona titular, String numCuenta) {
        super(listaEntidad, saldo, titular, numCuenta);
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.maxDescubiertoPermitido = maxDescubiertoPermitido;
        this.comisionFijaPorDescubierto = comisionFijaPorDescubierto;
    }
    
    @Override
    public String mostrarInfo(){
        StringBuilder infoCuentaEmpresa=new StringBuilder();
        infoCuentaEmpresa.append("INFORMACION CUENTA CORRIENTE DE EMPRESA \n");
        infoCuentaEmpresa.append("CCC: "+getNumCuenta()+"\n");
        infoCuentaEmpresa.append(getTitular().mostrarInfo()+"\n");
        infoCuentaEmpresa.append("Saldo actual: "+getSaldo()+"\n");
        infoCuentaEmpresa.append("Tipo de Interes Descubierto: "+getTipoInteresDescubierto()+"\n");
        infoCuentaEmpresa.append("Máximo Descubierto Permitido: "+getMaxDescubiertoPermitido()+"\n");
        infoCuentaEmpresa.append("Comision Fija por Descubierto: "+getComisionFijaPorDescubierto()+"\n");
        
        return infoCuentaEmpresa.toString();
    }
    
    public double getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }
    public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }
    public double getMaxDescubiertoPermitido() {
        return maxDescubiertoPermitido;
    }
    public void setMaxDescubiertoPermitido(double maxDescubiertoPermitido) {
        this.maxDescubiertoPermitido = maxDescubiertoPermitido;
    }
    public double getComisionFijaPorDescubierto() {
        return comisionFijaPorDescubierto;
    }
    public void setComisionFijaPorDescubierto(double comisionFijaPorDescubierto) {
        this.comisionFijaPorDescubierto = comisionFijaPorDescubierto;
    }
    
}