package prog09_ejer01;

/**
NUMEROS DE CUENTA DE PRUEBA COMPROBADOS
24313213564564311321
00246912501234567891
00302053091234567895
00492352082414205416
20852066623456789011
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AplicacionCuentabancaria {

    static ArrayList<CuentaBancaria> cuentasBancarias;
    static Hashtable entidadesAutorizadas=new Hashtable();
    static Scanner entrada=new Scanner(System.in);
    static Pattern pFecha=Pattern.compile("^[0-9]{2}/[0-9]{2}/[0-9]{4}$");
       
    public static void main(String[] args) {
        
        //Añadir al Hashtable parejas de datos
        entidadesAutorizadas.put("Iberdrola", 1000);
        entidadesAutorizadas.put("Movistar", 500.5);
        entidadesAutorizadas.put("Netflix", 300);
        entidadesAutorizadas.put("HBO", 200.8);
        
        int opcion;
        System.out.println("*************************");
        System.out.println("MENU APLICACION BANCARIA");
        System.out.println("*************************");
        System.out.println("1-Abrir nueva cuenta");
        System.out.println("2-Ver un listado de las cuentas disponibles");
        System.out.println("3-Obtener los datos de una cuenta concreta");
        System.out.println("4-Realizar un ingreso en una cuenta");
        System.out.println("5-Retirar efectivo de una cuenta");
        System.out.println("6-Consultar el saldo actual de una cuenta");
        System.out.println("7-Salir de la aplicación");       
        do{    
            System.out.println("INTRODUCE OPCION DEL MENU PRINCIPAL");
            opcion=entrada.nextInt();
            switch (opcion){
                case 1:
                    abrirCuenta();
                    System.out.println("*************************");
                    break;
                case 2:
                    verListadoCuentas();
                    System.out.println("*************************");
                    break;
                case 3:
                    obtenerDatosCuenta();
                    System.out.println("*************************");
                    break;
                case 4:
                    realizarIngreso();
                    System.out.println("*************************");
                    break;
                case 5:
                    retirarEfectivo();
                    System.out.println("*************************");
                    break;
                case 6:
                    consultarSaldo();
                    System.out.println("*************************");
                    break;
                case 7:
                    System.out.println("¡HASTA PRONTO!");
                    System.out.println("***La aplicacion se ha cerrado***");
                    break;
            }    
        }while(opcion!=7);
    }
    
    private static void abrirCuenta(){
        System.out.println("*************************");
        System.out.println("¿QUE TIPO DE CUENTA QUIERE ABRIR?");
        System.out.println("*************************");
        System.out.println("1-Abrir Cuenta Ahorro");
        System.out.println("2-Abrir Cuenta Corriente Personal");
        System.out.println("3-Abrir Ceunta Corriente Empresa");
        int opcion;  
            System.out.println("Introduce opción");
            opcion=entrada.nextInt();
         entrada.nextLine();    //consumir Buffer   
         
        //Atributos de la clase Persona
        String nombre,apellidos,fechaNacimiento;
        System.out.println("Introduce Nombre del titular");
        nombre=entrada.nextLine();
        System.out.println("Introduce Apellidos");
        apellidos=entrada.nextLine();
        System.out.println("Introduce Fecha de nacimiento");
        do{
            fechaNacimiento=entrada.nextLine();
        }while(!validaFecha(fechaNacimiento));
        //Crear objeto de la clase Persona
        Persona titular=new Persona(nombre,apellidos,fechaNacimiento);
        
        //Atributos de la clase Cuenta Bancaria
        String numCuenta;
        double saldo;
        System.out.println("Introduce nº de Cuenta");
        do{
            numCuenta=entrada.nextLine();
        }while(!validaCuenta(numCuenta));
        System.out.println("Introduce Saldo en cuenta");
        do{
            saldo=entrada.nextDouble();
        }while(!validaIngreso(saldo));
        
        // Genera el tipo de Cuenta que ha seleccionado el usuario
        //Crea un Objeto de la Clase Cuenta Ahorro
        if(opcion==1){
            double tipoInteres; //Atributo de la clase Cuenta Ahorro
            System.out.println("Introduzca el tipo de interés anual:");
            do{
                tipoInteres=entrada.nextDouble();
            }while(!validaPositivo(tipoInteres));
            //Crear el objeto de la Clase Cuenta Ahorro
            CuentaAhorro cAhorro=new CuentaAhorro(tipoInteres,saldo,titular,numCuenta); 
            //Agrega la Cuenta Ahorro creada al ArrayList de Cuentas Bancarias
            cuentasBancarias.add(cAhorro);
            System.out.println("Cuenta Ahorro Creada");
        //Crea un Objeto de la Clase Cuenta Corriente Personal
        }else if(opcion==2){    
            double comisionMant;
            System.out.println("Introduzca la comisión por mantenimiento:");
            do{
                comisionMant=entrada.nextDouble();
            }while(!validaPositivo(comisionMant));
            //Crear el objeto de la Clase Cuenta Corriente Personal
            CuentaCorrientePersonal cCorrientePersonal=new CuentaCorrientePersonal(comisionMant,entidadesAutorizadas,saldo,titular,numCuenta);
            //Agrega la Cuenta Corriente Personal creada al ArrayList de Cuentas Bancarias
            cuentasBancarias.add(cCorrientePersonal);
            System.out.println("Cuenta Corriente Personal Creada");
        //Crea un Objeto de la Clase Cuenta Corriente Empresa
        }else if(opcion==3){
            double tipoInteresDescubierto;
            double maxDescubiertoPermitido;
            double comisionFijaPorDescubierto;
            System.out.println("Introduzca el tipo de Interés Descubierto:");
            do{
                tipoInteresDescubierto=entrada.nextDouble();
            }while(!validaPositivo(tipoInteresDescubierto));
            System.out.println("Introduzca el máximo Descubierto Permitido:");
            do{
                maxDescubiertoPermitido=entrada.nextDouble();
            }while(!validaPositivo(maxDescubiertoPermitido));
            System.out.println("Introduzca la Comisión Fija por Descubierto:");
            do{
                comisionFijaPorDescubierto=entrada.nextDouble();
            }while(!validaPositivo(comisionFijaPorDescubierto));
            //Crear el objeto de la Clase Cuenta Corriente Empresa
            CuentaCorrienteEmpresa cCorrienteEmpresa=new CuentaCorrienteEmpresa(tipoInteresDescubierto,maxDescubiertoPermitido,
            comisionFijaPorDescubierto,entidadesAutorizadas,saldo,titular,numCuenta);
            //Agrega la Cuenta Corriente Empresa creada al ArrayList de Cuentas Bancarias
            cuentasBancarias.add(cCorrienteEmpresa);
            System.out.println("Cuenta Corriente Empresa Creada");
        }
    }
    
    private static void verListadoCuentas(){
        for(int i=0;i<cuentasBancarias.size();i++){
            System.out.println("---------- CUENTA: "+(i+1)+" ----------");
            System.out.println(cuentasBancarias.get(i).mostrarInfo());
        }
        System.out.println("---------- FIN DEL LISTADO ----------");
    }
    
    private static void obtenerDatosCuenta(){
        String numCuentaBuscado;
        System.out.println("Introduce nº de Cuenta buscado:");
        entrada.nextLine();    //consumir Buffer  
        do{
            numCuentaBuscado=entrada.nextLine();
        }while(!validaCuenta(numCuentaBuscado));
        
        CuentaBancaria cuenta=buscaCuenta(numCuentaBuscado);
        if(cuenta!=null){
                System.out.println(cuenta.mostrarInfo());
        }
    }
    
    private static void realizarIngreso(){
        String numCuentaBuscado;
        double ingreso;
        System.out.println("Introduce nº de Cuenta en la que quiere realizar el ingreso:");
        entrada.nextLine();    //consumir Buffer  
        do{
            numCuentaBuscado=entrada.nextLine();
        }while(!validaCuenta(numCuentaBuscado));
        
        CuentaBancaria cuenta=buscaCuenta(numCuentaBuscado);
        if(cuenta!=null){
            System.out.println("Introduce la cantidad a ingresar:");
            do{
                ingreso=entrada.nextDouble();
            }while(!validaPositivo(ingreso));
            cuenta.setSaldo(cuenta.getSaldo()+ingreso);
            System.out.println("Ingreso realizado correctamente.");
        }
    }
    
    private static void retirarEfectivo(){
        //24313213564564311321
        ArrayList<Double>valoresMax=new ArrayList<>();
        System.out.println("Lista de entidades autorizadas:");
        Enumeration<String> enumeration=entidadesAutorizadas.keys();
        int contador=1;
        int entidad;
        while(enumeration.hasMoreElements()){
            String key=enumeration.nextElement();
            System.out.println(contador+" "+key+" Cantidad max. permitida: "+entidadesAutorizadas.get(key));
            valoresMax.add(Double.parseDouble(entidadesAutorizadas.get(key).toString()));
            contador++;
        }
        System.out.println("Elige entidad:");
        do{
            entidad=entrada.nextInt();
            if(entidad<=0||entidad>valoresMax.size()){
                System.out.println("Introduce una entidad correcta.");
            }
        }while(entidad<=0||entidad>valoresMax.size());
        //entrada.nextInt();    //consumir Buffer
        String numCuentaBuscado;
        double retirar;
        entrada.nextLine();    //consumir Buffer
        System.out.println("Introduce nº de Cuenta en la que quiere retirar efectivo:");
          
        do{
            numCuentaBuscado=entrada.nextLine();
        }while(!validaCuenta(numCuentaBuscado));
        
        CuentaBancaria cuenta=buscaCuenta(numCuentaBuscado);
        if(cuenta!=null){
            System.out.println("Introduce la cantidad a retirar:");
            do{
                retirar=entrada.nextDouble();
                if(!(retirar<=valoresMax.get(entidad-1))){
                    System.out.println("El maximo permitido son: "+valoresMax.get(entidad-1)+"€ \n"
                            + "introduzca un valor correcto:");
                }
            }while(!validaPositivo(retirar)||!validaSaldo(cuenta,retirar)||!(retirar<=valoresMax.get(entidad-1)));
            cuenta.setSaldo(cuenta.getSaldo()-retirar);
            System.out.println("Ha retirado efectivo correctamente.");
        }
    }
            
    
    private static void consultarSaldo(){
        String numCuentaBuscado;
        System.out.println("Introduce nº de Cuenta que quiere consultar el Saldo:");
        entrada.nextLine();    //consumir Buffer  
        do{
            numCuentaBuscado=entrada.nextLine();
        }while(!validaCuenta(numCuentaBuscado));
        
        CuentaBancaria cuenta=buscaCuenta(numCuentaBuscado);
        if(cuenta!=null){
            System.out.println("La cuenta nº: "+cuenta.getNumCuenta()+" tiene un saldo de: "+cuenta.getSaldo()+"€");
        }
    }
    
/*
    METODOS DE VALIDACION DE DATOS INTRODUCIDOS POR CONSOLA
*/
    private static boolean validaFecha(String fechaNacimiento){
        Matcher mFecha;
        mFecha=pFecha.matcher(fechaNacimiento);
        try{
            if(!mFecha.matches()){
                System.out.println("La fecha no es correcta, vuelve a introducirla.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Se ha produciro un error al introducir la fecha");
        }
        return true;
    }
    
    private static boolean validaIngreso(double saldo){
        try{
            if(saldo<0){
                System.out.println("No puede ingresar una cantidad negativa, introduzca una cantidad positiva:");
                return false;
            }
        } catch (Exception e) {;
            System.err.println("Se ha producido un error al ingresar efectivo");
        }
        return true;
    }
    
    private static boolean validaCuenta(String ccc){
        if(ccc.length()!=20){
           System.out.println("CCC ERRONEO, NO tiene 20 digitos \n"
                   + "Introduzca Número de cuenta válido:");
           return false;
        }else{
            for(int i=0;i<ccc.length();i++){
                if(ccc.charAt(i)-48<0||ccc.charAt(i)-48>9){
                    System.out.println("CCC ERRONEO, tiene algún caracter que NO es numérico \n"
                            + "Introduzca Número de cuenta válido:");
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
        
        double sumaSegunda=(((char)ccc.charAt(10)-48)*1)+(((char)ccc.charAt(11)-48)*2)+(((char)ccc.charAt(12)-48)*4)
                            +(((char)ccc.charAt(13)-48)*8)+(((char)ccc.charAt(14)-48)*5)+(((char)ccc.charAt(15)-48)*10)
                            +(((char)ccc.charAt(16)-48)*9)+(((char)ccc.charAt(17)-48)*7)+(((char)ccc.charAt(18)-48)*3)
                            +(((char)ccc.charAt(19)-48)*6);
        double segundoDigito=11-(sumaSegunda%11);
        if(segundoDigito==10){
            segundoDigito=1;
        }else if(segundoDigito==11){
            segundoDigito=0;
        }
    
        if(primerDigito==pD && segundoDigito==sD){
            return true;
        }else{
            System.out.println("CCC ERRONEO, Digitos de control NO son válidos. \n"
                    + "Introduzca Número de cuenta válido:");
            return false;
        }
    }
    
    private static boolean validaPositivo(double num){
        try{
            if(num<0){
                System.out.println("El valor tiene que ser positivo, \n"
                        + "introduzca un valor positivo:");
                return false;
            }
        } catch (Exception e) {;
            System.err.println("Se ha producido un error al introducir el valor");
        }
        return true;
    }
    
    private static CuentaBancaria buscaCuenta(String ccc){
        CuentaBancaria cuenta=null;
        for(int i=0;i<cuentasBancarias.size();i++){
            if(cuentasBancarias.get(i).getNumCuenta().equals(ccc)){
                return cuentasBancarias.get(i);
            }
        }
        System.out.println("El nº de cuenta NO existe.");
        return cuenta;
    }
    
    private static boolean validaSaldo (CuentaBancaria cuenta, double retirar){
        if(cuenta.getSaldo()>=retirar){
            return true;
        }
        System.out.println("NO tiene saldo suficiente en la cuenta. \n"
                + "Introduzca una cantidad válida.");
        return false;
    }
    
}