package prog05_ejer01;

public class CuentaBancaria {
    private String nombre;
    private String CCC;
    private double saldo;
    private String entidad;
    private String oficina;
    private String nDC;
    private String nCuenta;

    public CuentaBancaria(String nom, String CCC){
        nombre=nom;
        this.CCC=CCC;
        saldo=1000;
        entidad=CCC.substring(0,4);
        oficina=CCC.substring(4,8);
        nDC=CCC.substring(8,10);
        nCuenta=CCC.substring(10,20);
    }
    
    public void muestraCCC(){
        System.out.println("El CCC es: "+CCC);
    }
    public void muestraTitular(){
        System.out.println("El titular es: "+nombre);
    }
    public void muestraCodigoEntidad(){
        System.out.println("El código de la entidad es: "+entidad);
    }
    public void muestraCodigoOficina(){
        System.out.println("El código de la Oficina es: "+oficina);
    }
    public void muestraNumeroCuenta(){
        System.out.println("El número de cuenta es: "+nCuenta);
    }
    public void muestraDC(){
        System.out.println("Primer DC: "+((char)CCC.charAt(8)-48));
        System.out.println("Segundo DC: "+((char)CCC.charAt(9)-48));
    }
    public void ingresar(double cantidad)throws Exception{
        if(cantidad>0){
            saldo=saldo+cantidad;
            System.out.println("Saldo ingresado correctamente.");
        }else{
            throw new IllegalArgumentException("El ingreso tiene que ser positivo");
        }
    }
    public void muestraSaldo(){
        System.out.println("El saldo actual es: "+saldo+"€");
    }
    public void retirar(double cantidad)throws Exception{
        if(cantidad>0 && cantidad<=saldo){
            saldo=saldo-cantidad;
            System.out.println("Cantidad retirada correctamente.");
        }else if(cantidad>saldo){
            System.out.println("No dispone de esa cantidad.");
        }else{
            throw new IllegalArgumentException("No es posible realizar la retirada de efectivo.");
        }
    }
    
    public static boolean compruebaCCC(String ccc){
        if(ccc.length()!=20){
            System.out.println("CCC ERRONEO, NO tiene 20 digitos.");
            return false;
        }else{
            for(int i=0;i<ccc.length();i++){
                if(ccc.charAt(i)-48<0 || ccc.charAt(i)-48>9){
                    System.out.println("CCC ERRONEO, tiene algún caracter que No es número.");
                    return false;
                }
            }
        }
        double pD=(char)ccc.charAt(8)-48;
        double sD=(char)ccc.charAt(9)-48;
        
        double sumaPrimera=(((char)ccc.charAt(0)-48)*4)+(((char)ccc.charAt(1)-48)*8)+(((char)ccc.charAt(2)-48)*5)
                +(((char)ccc.charAt(3)-48)*10)+(((char)ccc.charAt(4)-48)*9)+(((char)ccc.charAt(5)-48)*7)
                +(((char)ccc.charAt(6)-48)*3)+(((char)ccc.charAt(7)-48)*6);
        double primerDigito=11-(sumaPrimera%11);
            if(primerDigito==10){
                primerDigito=1;
            }else if(primerDigito==11){
                primerDigito=0;
            }
        
        double sumaSegunda=(((char)ccc.charAt(10)-48)*1)+(((char)ccc.charAt(11)-48)*2)+(((char)ccc.charAt(12)-48)*4)+
                            (((char)ccc.charAt(13)-48)*8)+(((char)ccc.charAt(14)-48)*5)+(((char)ccc.charAt(15)-48)*10)+
                            (((char)ccc.charAt(16)-48)*9)+(((char)ccc.charAt(17)-48)*7)+(((char)ccc.charAt(18)-48)*3)+
                            (((char)ccc.charAt(19)-48)*6);
        double segundoDigito=11-(sumaSegunda%11);
            if(segundoDigito==10){
                segundoDigito=1;
            }else if(segundoDigito==11){
                segundoDigito=0;
            }
        
        if(primerDigito==pD && segundoDigito==sD){
            System.out.println("CCC CORRECTO");
            return true;
        }else{
            System.out.println("CCC ERRONEO, Digitos de control NO son validos.");
            return false;
        }        
    }
    
    public static boolean compruebaNombre(String nom){
        if(nom.length()<=10){
            System.out.println("Nombre validado.");
            return true;
        }
        System.out.println("Nombre erroneo, tiene más de 10 caracteres.");
        return false;
    }
}