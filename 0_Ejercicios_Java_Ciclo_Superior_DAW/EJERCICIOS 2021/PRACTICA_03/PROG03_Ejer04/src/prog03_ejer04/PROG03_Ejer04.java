package prog03_ejer04;

public class PROG03_Ejer04 {

    public static void main(String[] args) {
        Persona p=new Persona("Maria",35,1.5f);
        
        System.out.println("El nombre es: "+p.obtener_Nombre());
        System.out.println("La edad es: "+p.obtener_edad());
        System.out.println("La altura es: "+p.obtener_altura());       
    }
}