package numeros;

public class PROG03_Ejer05 {

    public static void main(String[] args) {
        Complejo c1=new Complejo();
        Complejo c2=new Complejo(5,10);
        
        System.out.println("Consulta parte real: "+c1.consulta_Real());
        System.out.println("Consulta parte imaginaria: "+c1.consulta_Imag());
        System.out.println("Consulta parte real: "+c2.consulta_Real());
        System.out.println("Consulta parte imaginaria: "+c2.consulta_Imag());
        
        c1.cambia_Real(50);
        c1.cambia_Imag(100);
        System.out.println("Consulta parte real: "+c1.consulta_Real());
        System.out.println("Consulta parte imaginaria: "+c1.consulta_Imag());  
        
        System.out.println(c1.toString());
        
        c1.sumar(c2);
        System.out.println(c1.toString());
        
    }
}