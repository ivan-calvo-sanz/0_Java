package ejercicio1;

/**
 *
 * @author IVAN
 */
public interface Combustible {
    
    public enum TipoCombustible {GASOLINA,DIESEL,BIODIESEL};
    public final double[] CONSUMO_MEDIO = new double[3];
    public final double[] PRECIO_MEDIO = new double[3];
    
    public double estimarGastoCombustible(int numKm, TipoCombustible tipo);
    
}