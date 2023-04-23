package prog09_ejer01;

import java.util.Hashtable;

public class CuentaCorrientePersonal extends CuentaCorriente{
    private double comisionMant;

    public CuentaCorrientePersonal(double comisionMant, Hashtable listaEntidad, double saldo, Persona titular, String numCuenta) {
        super(listaEntidad, saldo, titular, numCuenta);
        this.comisionMant = comisionMant;
    }
    
    @Override
    public String mostrarInfo(){
        StringBuilder infoCuentaPersonal=new StringBuilder();
        infoCuentaPersonal.append("INFORMACION CUENTA CORRIENTE PERSONAL \n");
        infoCuentaPersonal.append("CCC: "+getNumCuenta()+"\n");
        infoCuentaPersonal.append(getTitular().mostrarInfo()+"\n");
        infoCuentaPersonal.append("Saldo actual: "+getSaldo()+"\n");
        infoCuentaPersonal.append("Comision de mantenimiento: "+getComisionMant()+"\n");
        
        return infoCuentaPersonal.toString();
    }

    public double getComisionMant() {
        return comisionMant;
    }
    public void setComisionMant(double comisionMant) {
        this.comisionMant = comisionMant;
    }
}