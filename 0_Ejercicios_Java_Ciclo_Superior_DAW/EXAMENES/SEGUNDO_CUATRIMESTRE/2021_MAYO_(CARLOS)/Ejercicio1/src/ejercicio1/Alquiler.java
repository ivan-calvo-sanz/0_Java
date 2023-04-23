package ejercicio1;

/**
 *
 * @author IVAN
 */
public class Alquiler {
    private Cliente cliente;
    private int numDias;
    private Embarcacion embarcacion;
    private double precio;

    public Alquiler(Cliente cliente, int numDias, Embarcacion embarcacion) {
        this.cliente = cliente;
        this.numDias = numDias;
        this.embarcacion = embarcacion;
        this.precio=numDias*embarcacion.getPrecioBaseDiario();
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumDias() {
        return numDias;
    }
    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

    public Embarcacion getEmbarcacion() {
        return embarcacion;
    }
    public void setEmbarcacion(Embarcacion embarcacion) {
        this.embarcacion = embarcacion;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "Alquiler{" + "cliente=" + cliente + ", numDias=" + numDias + ", embarcacion=" + embarcacion + ", precio=" + precio + '}';
    }
    
}