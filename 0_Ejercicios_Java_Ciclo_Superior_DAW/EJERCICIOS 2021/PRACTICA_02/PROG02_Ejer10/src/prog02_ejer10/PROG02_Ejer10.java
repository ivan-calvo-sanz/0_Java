package prog02_ejer10;

public class PROG02_Ejer10 {

    public static void main(String[] args) {
        System.out.println("*** CONVERSIONES ENTRE ENTEROS Y COMA FLOTANTE ***");
        float x=4.5f;
        float y=3.0f;
        int i=2;
        int j_entero=i*(int)x;
        float j=(float)i*x;
        System.out.println("Producto int por float (int): 2*4,5="+j_entero);
        System.out.println("Producto int por float (float): 2*4,5="+j);
        
        double dx=2.0;
        double dz=dx*y;
        System.out.println("Producto double por float (double): 2,0*3,0="+dz);
        System.out.println("");
        
        
        System.out.println("*** OPERACIONES CON BYTE ***");
        byte bx=5;
        byte by=2;
        byte bz=(byte)(bx-by);
        System.out.println("byte: "+bx+"-"+by+"="+bz);
        bx=-128;
        by=1;
        bz=(byte)(bx-by);
        System.out.println("byte -128-1="+bz);
        int bz_entero=(int)bx-(int)by;
        System.out.println("(int)(-128-1)="+bz_entero);
        System.out.println("");
        
        
        System.out.println("*** OPERACIONES CON SHORT ***");
        short sx=5;
        short sy=2;
        short sz=(short)(sx-sy);
        System.out.println("short: 5-2= "+sz);
        sx=32767;
        sy=1;
        sz=(short)(sx+sy);
        System.out.println("short 32767+1="+sz);
        System.out.println("");
        
        
        System.out.println("*** OPERACIONES CON CHAR ***");
        char cx='\u000F';
        char cy='\u0001';
        char z=(char)(cx-cy);
        System.out.println("char \u000F - \u0001 ="+z);
                
    }  
}