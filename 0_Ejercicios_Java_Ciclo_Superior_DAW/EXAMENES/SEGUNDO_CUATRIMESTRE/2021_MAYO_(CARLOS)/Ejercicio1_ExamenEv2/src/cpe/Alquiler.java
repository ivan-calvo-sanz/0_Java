package cpe;

public class Alquiler {
    
    private Cliente cliente;
    private int numDias;
    private Embarcacion embarcacion;
    
    Alquiler() {}
    
    Alquiler(Cliente cliente, int numDias, Embarcacion embarcacion) {
        this.cliente = cliente;
        this.numDias = numDias;
        this.embarcacion = embarcacion;
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
    
    public String toString() {
        return cliente.toString() + "\n" +
               "[Número de días] => " + getNumDias() +
               embarcacion.toString();
    }
    
}
