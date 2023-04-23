package ejercicio1_v2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
    public enum comprobacion{ACIERTO,MENOR,MAYOR}
    static Scanner entrada=new Scanner(System.in);
    static File f=new File("juego.txt");
    
    public static void main(String[] args) {
        
        int opcion;
        try {
            do{
                System.out.println("** BIENVENIDO AL JUEGO DE ADIVINAR NUMEROS **");
                System.out.println("1-Jugar de modo interactivo");
                System.out.println("2-Simular juego");
                System.out.println("3-Mostrar simulaciones");
                System.out.println("4-Eliminar fichero de simulaciones");
                System.out.println("5-Salir de la aplicación");
                System.out.println("Introduzca la opción deseada (1-5)");

                opcion=entrada.nextInt();
                if(opcion<1||opcion>5){
                    System.out.println("Opción incorrecta. Debe elegir entre la opción (1-5)");
                }
                    switch (opcion){
                        case 1:
                            modoInteractivo();
                            System.out.println("*********************************************");
                            break;
                        case 2:
                            simularJuego();
                            System.out.println("*********************************************");
                            break;
                        case 3:
                            visualizarFichero();
                            System.out.println("*********************************************");
                            break;
                        case 4:
                            eliminarFichero();
                            System.out.println("*********************************************");
                            break;
                        case 5:
                            System.out.println("¡HASTA PRONTO!");
                            System.out.println("***La aplicacion se ha cerrado***");
                            break;
                        }  
            }while(opcion!=5);
        } catch (Exception e) {
            System.err.println("Opción incorrecta.");
        }
    }
    
    private static void modoInteractivo(){
        System.out.println("Definiendo juego");
        System.out.println("Se adivinaran numeros entre 1 y MAX.");
        System.out.println("Introduce un valor para MAX (Minimo 10):");
        int numMax;
        do{
            numMax=entrada.nextInt();
        }while(!validaNumMax(numMax));
        System.out.println("***********************************************");
        System.out.println("** JUEGO DE ADIVINAR EL NUMERO MODO INTERACTIVO");
        System.out.println("** Hay que adivinar un numero entre 1 y "+numMax);
        System.out.println("** El numero de Jugadores es 1");
        System.out.println("***********************************************");
        Juego juego=new Juego(numMax,1);
        Jugador jugador=new Jugador(1,juego);
        
        int numJugado;
        comprobacion resultado;
        do{
            System.out.println("Introduce un número entre 1 y "+numMax);
            do{
                numJugado=entrada.nextInt();
            }while(!validaNumJugado(numJugado,numMax));
            
            System.out.println("Jugador "+jugador.getIdJugador()+" juega "+numJugado);
            resultado=jugador.intento(numJugado,0,false);
            if(resultado==comprobacion.ACIERTO){
                System.out.println("       Es el numero buscado");
                System.out.println("Ha ganado el jugador "+jugador.getIdJugador());
            }else if(resultado==comprobacion.MENOR){
                System.out.println("El número buscado es menor");
            }else if(resultado==comprobacion.MAYOR){
                System.out.println("El número buscado es mayor");
            }
        }while(resultado!=comprobacion.ACIERTO);   
    }
    
    private static void simularJuego(){
        System.out.println("Definiendo juego");
        System.out.println("Se adivinaran numeros entre 1 y MAX.");
        System.out.println("Introduce un valor para MAX (Minimo 10):");
        int numMax=entrada.nextInt();
        int limiteInferior=1;
        int limiteSuperior=numMax;
        System.out.println("Introduce el número de jugadores (Minimo 1):");
        int numJugadores=entrada.nextInt();
        System.out.println("***********************************************");
        System.out.println("** JUEGO DE ADIVINAR EL NUMERO MODO SIMULACION");
        System.out.println("** Hay que adivinar un numero entre 1 y "+numMax);
        System.out.println("** El numero de Jugadores es "+numJugadores);
        System.out.println("***********************************************");
        Juego juego=new Juego(numMax,numJugadores);
        Jugador[] jugador=new Jugador[numJugadores];
        
        for(int i=0;i<numJugadores;i++){
            jugador[i]=new Jugador((i+1),juego);
            //System.out.println("jugador creado"+jugador[i]);
        }
        
        comprobacion resultado;
        int turno;
        generarArchivo();
        
        try {
            FileWriter fw=new FileWriter(f,true);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write("*********************************************");
            bw.write("\n** SIMULACIÓN DE ADIVINAR EL NÚMERO");
            bw.write("\n** Hay que adivinar un numero entre 1 y "+numMax);
            bw.write("\n** El número a adivinar es "+juego.getNumOculto());
            bw.write("\n** El número de jugadores es "+numJugadores);
            bw.write("\n*********************************************");
        
        do{
            turno=juego.getTurno();
            //System.out.print("Jugador "+turno);
            resultado=jugador[turno-1].intento(limiteInferior,limiteSuperior,true);
            if(resultado==comprobacion.ACIERTO){
                //System.out.println("       Es el numero buscado");
                //System.out.println("Ha ganado el jugador "+juego.getGanador());
                System.out.println("Ha finalizado la Simulacion!");
                bw.write("\nJugador "+jugador[turno-1].getIdJugador()+" juega "+jugador[turno-1].getNumJugado());
                bw.write("\n     Es igual que "+juego.getNumOculto());
                bw.write("\nHa ganado el jugador "+juego.getGanador());
                bw.write("\n*********************************************");
                bw.write("\n***********FIN DE LA SIMULACION**************");
                bw.write("\n*********************************************\n");
            }else if(resultado==comprobacion.MENOR){
                //System.out.println("El número buscado es menor");
                limiteSuperior=jugador[turno-1].getNumJugado()-1;
                bw.write("\nJugador "+jugador[turno-1].getIdJugador()+" juega "+jugador[turno-1].getNumJugado());
                bw.write("\n     Es mayor que "+juego.getNumOculto());
            }else if(resultado==comprobacion.MAYOR){
                //System.out.println("El número buscado es mayor");
                limiteInferior=jugador[turno-1].getNumJugado()+1;
                bw.write("\nJugador "+jugador[turno-1].getIdJugador()+" juega "+jugador[turno-1].getNumJugado());
                bw.write("\n     Es menor que "+juego.getNumOculto());
            }
            //System.out.println("limiteSuperior "+limiteSuperior);
            //System.out.println("limiteInferior "+limiteInferior);
        }while(resultado!=comprobacion.ACIERTO);
        bw.close();
        fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void generarArchivo(){
        try {
            if(!f.exists()){
                f.createNewFile();
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al generar el archivo: "+e);
        }
    }
    private static void visualizarFichero(){
        abrirFichero();
        String linea=null;
        try {
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            
            do{
                linea=br.readLine();
                if(linea!=null){
                    System.out.println(linea);
                }
            }while(linea!=null);
            fr.close();
            br.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void abrirFichero(){
        try {
            if(!f.exists()){
                System.err.println("El fichero "+f+" no existe");
            }else{
                System.out.println("abriendo archivo...");
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al abrir el archivo: "+e);
        }
    }
    
    private static void eliminarFichero(){
        try {
            if(!f.exists()){
                System.err.println("El fichero "+f+" no existe");
            }else{
                f.delete();
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al borar el archivo: "+e);
        }   
    }
    
    private static boolean validaNumMax(int n){
        try {
            if(n<10){
                System.out.println("El numero debe ser mayor o igual a 10, vuelve a introducirlo.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Se ha produciro un error al introducir el numero Max.");
        }
        return true;
    }
    
    private static boolean validaNumJugado(int numJugado,int numMax){
        try {
            if(numJugado<1||numJugado>numMax){
                System.out.println("El numero debe ser mayor que 0 y menor o igual a "+numMax);
                return false;
            }
        } catch (Exception e) {
            System.out.println("Se ha produciro un error al introducir el numero jugado");
        }
        return true;
    }
    
}