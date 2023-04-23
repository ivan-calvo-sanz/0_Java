package ejercicio1;

public class Alquiler {

    private Cliente cliente;
    private int numDias;
    private Embarcacion embarcacion;
    private final double precio;

    public Alquiler(Cliente cliente, int numDias, Embarcacion embarcacion) {
        this.cliente = cliente;
        this.numDias = numDias;
        this.embarcacion = embarcacion;
        this.precio = this.numDias * (this.embarcacion.getPrecioBaseDiario() + this.embarcacion.getSuplemento());
    }

    @Override
    public String toString() {
        String devuelve;
        devuelve = this.cliente.toString() + "\n"
                + this.embarcacion.toString() + "\n"
                + "PRECIO TOTAL DEL ALQUILER= " +this.precio + "€";
        return devuelve;
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

}
