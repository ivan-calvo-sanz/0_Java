package cpe;

public class Yate extends Embarcacion implements iTipoYate {
    
    private int numCamarotes;
    private TipoYate yate;
    
    public Yate() {}
    
    public Yate(String matricula, int metrosEslora, int anoFabricacion, int numCamarotes, TipoYate yate) {
        super(matricula, metrosEslora, anoFabricacion);
        this.numCamarotes = numCamarotes;
        this.yate = yate;
    }

    public int getNumCamarotes() {
        return numCamarotes;
    }

    public void setNumCamarotes(int numCamarotes) {
        this.numCamarotes = numCamarotes;
    }

    public TipoYate getYate() {
        return yate;
    }

    public void setYate(TipoYate yate) {
        this.yate = yate;
    }
    
    @Override
    public String toString() {
        return super.toString() +
        "\n[Número de camarotes] => " + getNumCamarotes() + 
        "\n[Tipo de yate] => " + getYate();
    }
    
}
