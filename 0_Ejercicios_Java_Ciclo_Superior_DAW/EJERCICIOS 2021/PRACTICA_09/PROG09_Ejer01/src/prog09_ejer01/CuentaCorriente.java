package prog09_ejer01;

import java.util.Hashtable;

/*
    Clase CuentaCorriente
    hereda de CuentaBancaria y es clase abstracta por lo que no se tiene que
    sobreescribir el método de la interfaz imprimible
*/
public abstract class CuentaCorriente extends CuentaBancaria{
    private Hashtable listaEntidad;

    public CuentaCorriente(Hashtable listaEntidad, double saldo, Persona titular, String numCuenta) {
        super(saldo, titular, numCuenta);
        this.listaEntidad = listaEntidad;
    }

    public Hashtable getListaEntidad() {
        return listaEntidad;
    }
    public void setListaEntidad(Hashtable listaEntidad) {
        this.listaEntidad = listaEntidad;
    }
    
}