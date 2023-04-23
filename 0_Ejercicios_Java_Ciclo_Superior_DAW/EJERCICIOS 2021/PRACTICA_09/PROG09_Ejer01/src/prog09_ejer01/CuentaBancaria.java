package prog09_ejer01;

/*
    Clase CuentaBancaria
    clase abstracta de la cual heredan el resto de cuentas
    implementa de la interfaz Imprimible pero al ser clase abstracta (nunca se va 
    a instanciar un objeto de CuentaBancaria) no hay que sobreescribir el método de 
    la interfaz Imprimible, pero si en el resto de clases que hereden de esta.
*/
public abstract class CuentaBancaria implements Imprimible{
    private double saldo;
    private Persona titular;
    private String numCuenta;
    
    public CuentaBancaria(double saldo, Persona titular, String numCuenta){
        this.saldo=saldo;
        this.titular=titular;
        this.numCuenta=numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public Persona getTitular() {
        return titular;
    }
    public void setTitular(Persona titular) {
        this.titular = titular;
    }
    public String getNumCuenta() {
        return numCuenta;
    }
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }
}