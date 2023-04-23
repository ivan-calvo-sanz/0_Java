package prog02_ejer06;

public class enumerado {
    enum Meses{Enero,Febrero,Marzo,Abril,Mayo,Junio,Julio,Agosto,Septiembre,
    Octubre,Noviembre,Diciembre}
    public static void main(String[] args) {
        enumerado.Meses m;
        m=Meses.Marzo;
        System.out.println("El mes es: "+m);
    }    
}