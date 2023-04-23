package ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author IVAN
 */
public class Main {
        static ArrayList<Equipo> equipos=new ArrayList<Equipo>();
        static Scanner entrada=new Scanner(System.in);   
        static final String ERROR_INPUT="Dato introducido erroneo";
        static final String MENU_PRINCIPAL
            = "\n************************\n"
            + "*****SUPER LIGA*****\n"
            + "************************\n"
            + "1-CREAR EQUIPOS\n"
            + "2-SIMULAR JORNADA\n"
            + "3-VER RESULTADOS FINALES\n"
            + "4-VER EQUIPO\n"
            + "5-VER MEJOR JUGADOR\n"
            + "0-SALIR\n";
        static final String DATO_NO_VALIDO="ERROR: El dato introducido no es válido.\nVuelva a introducir el dato: ";

    public static void main(String[] args) {
        System.out.println(MENU_PRINCIPAL);
        System.out.print("Introduce opción del Menú:");
        boolean validar;
        int opcion=-1;
            try {
                do{    
                 	//Introduce opcion y valida que es un nº entero
                    	do{
                            opcion=validarEntero(entrada.nextLine());
                    	}while(opcion==-1);
                    if(opcion>-1&&opcion<6){
                        validar=true;
                        switch (opcion){
                            case 1:
                                crearEquipos();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 2:
                                simularJornada();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 3:
                                verResultadosFinales();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 4:
                                verEquipo();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 5:
                                mejorJugador();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 0:
                                System.out.println("***La aplicacion se ha cerrado***");
                                break;
                        }
                    }else{
                        validar=false;
                        System.err.println("La opcion tiene que ser entre 0 y 5");
                        System.out.println("Introduce opción del Menú:");
                    }
                }while(opcion!=0||!validar);
            } catch (Exception e) {
                System.err.println(ERROR_INPUT+" |Error: "+e);
            }
    }
    
    //CASE: 1
    private static void crearEquipos(){
        Equipo equipo;
        //String nombre;
        int id;
        ArrayList<Jugador> jugadores;
        JugadorDeCampo jugador;
        Portero portero;
        int dorsal,numEstrellas,goles,golesRecibidos;
        
        for(int i=0;i<2;i++){
            //generar nombre automatico
            id=i+1;
            jugadores=new ArrayList<Jugador>();
            
            for(int j=0;j<11;j++){
                dorsal=j+1;
                numEstrellas=0;
                if(dorsal==1){
                    golesRecibidos=0;
                    portero=new Portero(golesRecibidos,dorsal,numEstrellas);
                    jugadores.add(portero);
                }else{
                    goles=0;
                    jugador=new JugadorDeCampo(goles,dorsal,numEstrellas);
                    jugadores.add(jugador);
                }
            }
            equipo=new Equipo(id,jugadores);
            equipos.add(equipo);
            System.out.println("Equipo "+id+" generado.");
        }
    }
    
    
    //CASE: 2
    private static void simularJornada(){
        if(equipos.isEmpty()){
            System.out.println("No existen equipos");
        }else{
            System.out.println("Calculando puntuación de la Jornada");
            for(int i=0;i<equipos.size();i++){
                for(int j=0;j<equipos.get(i).getJugadores().size();j++){
                    equipos.get(i).getJugadores().get(j).simularPuntuacion();
                }
            }
        }
    }
    
    //CASE: 3
    private static void verResultadosFinales(){
        int puntuacion;
        if(equipos.isEmpty()){
            System.out.println("No existen equipos");
        }else{
            System.out.println("ALINEACIONES:");
            for(int i=0;i<equipos.size();i++){
                puntuacion=0;
                System.out.println("Equipo "+(i+1));
                //System.out.println(equipos.get(i).getJugadores().size());
                for(int j=0;j<equipos.get(i).getJugadores().size();j++){
                    System.out.println(equipos.get(i).getJugadores().get(j).toString());
                    puntuacion+=equipos.get(i).getJugadores().get(j).calcularPuntuacion();
                }
                System.out.println("PUNTUACION TOTAL DE EQUIPO "+(i+1)+" -> "+puntuacion+" PUNTOS.");
            }
        }
    }
    
    //CASE 4
    private static void verEquipo(){
                //Introduce y valida un nº entero
                System.out.print("Introduce id del equipo a visualizar:");
                int id;
                do{
                    id=validarEntero(entrada.nextLine());
                }while(id==-1);
        if(equipos.isEmpty()){
            System.out.println("No existen equipos");
        }else{
            System.out.println("ALINEACION EQUIPO: "+id);
                for(int j=0;j<equipos.get(id-1).getJugadores().size();j++){
                    System.out.println(equipos.get(id-1).getJugadores().get(j).toString()+
                            " | PUNTUACION: "+equipos.get(id-1).getJugadores().get(j).calcularPuntuacion());
                }
        }
    }
    
    //CASE 5
    public static void mejorJugador(){
        int punt,mayorPunt=0;
        if(equipos.isEmpty()){
            System.out.println("No existen equipos");
        }else{
            for(int i=0;i<equipos.size();i++){
                for(int j=0;j<equipos.get(i).getJugadores().size();j++){
                    punt=equipos.get(i).getJugadores().get(j).getPuntuacion();
                    if(punt>mayorPunt){
                        mayorPunt=punt;
                    }

                }  
            }
            System.out.println("MAYOR PUNTUACION ES: "+mayorPunt);
            for(int i=0;i<equipos.size();i++){
                for(int j=0;j<equipos.get(i).getJugadores().size();j++){
                    if(equipos.get(i).getJugadores().get(j).getPuntuacion()==mayorPunt){
                        System.out.println("MEJOR JUGADOR: "+equipos.get(i).getJugadores().get(j).toString()+" Pertenece al Equipo: "+(i+1));
                    }

                }  
            }
            
            
        }
        
        
    }
        
    
            
            
    
    
               
            
    
    //METODO Verifica que es numero entero
    private static int validarEntero(String num){
        int numDevuelto=-1;
        try {
            numDevuelto=Integer.parseInt(num);
        } catch (Exception e) {
            System.err.println(DATO_NO_VALIDO+" |Error: "+e);
        }
        return numDevuelto;
    }  
    
    //GENERA nº aleatorio
    public static int generarNumAleatorio(int n1,int n2){
        //genera un numero aleatrorio hasta máximo n
        //int numeroAleatorio=(int)(Math.random()*n+1);
        //genera un numero aleatrorio entre n1 y n2
        int numeroAleatorio=(int)(Math.random()*((n2+1)-n1))+n1;
        return numeroAleatorio;
    }

}