package CuentaBancaria;
/**
 *
 * @author IVAN
 */
public class CuentaBancaria {
    // ATRIBUTOS
    private final String titular;
    private final String cCC;
    private double saldo;
    private final String nCuenta;
    private final String entidad;
    private final String nDC;
    private final String oficina;
    
    //CONSTRUCTOR CON PARAMETROS
    public CuentaBancaria(String titular,String cCC,double saldo){
        this.titular=titular;
        this.cCC=cCC;
        this.saldo=saldo;
        entidad=cCC.substring(0,4);
        oficina=cCC.substring(4,8);
        nCuenta=cCC.substring(10,20);
        nDC=cCC.substring(8,10);
    }
    
    //METODO STATIC ValidaNombre
    public static boolean ValidaNombre(String nomTitular){
            if (nomTitular.length()<10) return true;
            //Controlamos la excepción para que no se ingrese un nombre con más de 10 carácteres
            throw new IllegalArgumentException("El nombre tiene que tener menos de 10 carácteres.");
    }
    
    //METODO STATIC ValidaCCC
    //Comprueba que el cCC tiene 20 dígitos y son numericos
    public static boolean ValidaCCC(String cCC){
        if(cCC.length()!=20){
            return false;
        }else{
            for(int i=0; i<cCC.length();i++){
                    if(cCC.charAt(i)-48<0 || cCC.charAt(i)-48>9){
                        return false;
                    }
            }
        }
        return true;
    }
    
    //METODO STATIC ValidaDC (Digitos de Control)
    //Valida el cCC comprobando que los Digitos de Control son correctos
    //fórmula adjunta en la carpeta de la aplicación
    public static boolean ValidaDC(String cCC){
        double pD=(char)cCC.charAt(8)-48;
        double sD=(char)cCC.charAt(9)-48;
        //System.out.println("pD: "+pD+" sD: "+sD);
        
        double sumaPrimera=(((char)cCC.charAt(0)-48)*4)+(((char)cCC.charAt(1)-48)*8)+(((char)cCC.charAt(2)-48)*5)
                +(((char)cCC.charAt(3)-48)*10)+(((char)cCC.charAt(4)-48)*9)+(((char)cCC.charAt(5)-48)*7)
                +(((char)cCC.charAt(6)-48)*3)+(((char)cCC.charAt(7)-48)*6);
        double primerDigito=11-(sumaPrimera%11);
        if(primerDigito==10){
            primerDigito=1;
        }else if(primerDigito==11){
            primerDigito=0;
        }
        
        double sumaSegunda=(((char)cCC.charAt(10)-48)*1)+(((char)cCC.charAt(11)-48)*2)+(((char)cCC.charAt(12)-48)*4)
                +(((char)cCC.charAt(13)-48)*8)+(((char)cCC.charAt(14)-48)*5)+(((char)cCC.charAt(15)-48)*10)
                +(((char)cCC.charAt(16)-48)*9)+(((char)cCC.charAt(17)-48)*7)+(((char)cCC.charAt(18)-48)*3)+(((char)cCC.charAt(19)-48)*6);
        double segundoDigito=11-(sumaSegunda%11);
        if(segundoDigito==10){
            segundoDigito=1;
        }else if(segundoDigito==11){
            segundoDigito=0;
        }    
        
        //System.out.println("primerDigito: "+primerDigito+" segundoDigito: "+segundoDigito);
        if(primerDigito==pD && segundoDigito==sD){
            return true;
        }
        
        throw new IllegalArgumentException("SU Código Cuenta Cliente (CCC) es ERRONEO. Aplicacion cerrada.");
    }
    
    //METODO SET gestionaIngreso
    //Pasando por parámetro la cantidad a ingresar
    //Controlamos la excepción para que no se ingrese una cantidad negativa
    public void gestionaIngreso(double cantidad){
        if(cantidad>0){
            saldo=saldo+cantidad;
        }else{
            throw new IllegalArgumentException("El ingreso tiene que ser positivo");
        }
    }    
    
    //METODO SET gestionaRetiradaEfectivo
    //Pasando por parámetro la cantidad a retirar
    //Controlamos la excepción para que no se retire una cantidad negativa
    public void gestionaRetiradaEfectivo(double cantidad) {
        if(cantidad>0 && cantidad<saldo){
            saldo=saldo-cantidad;
        }else{
            throw new IllegalArgumentException("La retirada de efectivo NO es correcta");
        }
    }
    
    //METODO GET obtiene el saldo
    //Muestra el saldo actual de la cuenta
    //Mostrando por pantalla el atributo saldo
    public void getSaldo(){
        System.out.println("Su saldo en cuenta son: "+saldo+"€");
    }
    
    //METODO GET obtiene titular
    //Muestra el titular de la cuenta
    //Mostrando por pantalla el atributo titular
    public void getTitular(){
        System.out.println("El titular de la cuenta es: "+titular);
    }
    
    //METODO GET obtiene Codigo de entidad
    //Muestra el Código de entidad de la cuenta
    //Mostrando por pantalla el atributo entidad
    public void getCodigoEntidad(){
        System.out.println("La Entidad es: "+entidad);
    }
    
    //METODO GET obtiene Codigo Oficina
    //Muestra el Código Oficina de la cuenta
    //Mostrando por pantalla el atributo oficina
    public void getCodigoOficina(){
        System.out.println("La Oficina es: "+oficina);
    }
    
    //METODO GET obtiene Número de Cuenta
    //Muestra el Número de Cuenta
    //Mostrando por pantalla el atributo nCuenta
    public void getCuenta(){
        System.out.println("El nº de Cuenta es: "+nCuenta);
    }
    
    //METODO GET obtiene Digitos de Control
    //Muestra los Digitos de Control
    //Mostrando por pantalla el atributo nDC
    public void getDC(){
        System.out.println("Los digitos de control son: "+nDC);
    }
      
    //METODO GET obtener informacion de la cuenta
    //Muestra la info de la cuenta
    //Mostrando por pantalla los atributos
    public void getInfo(){        
        System.out.println("La Entidad es: "+entidad);
        System.out.println("La Oficina es: "+oficina);
        System.out.println("Los Dígitos de Control son: "+nDC);
        System.out.println("El nº de cuenta es: "+nCuenta);
        System.out.println("El titular de la cuenta es: "+titular);
    }
    
}