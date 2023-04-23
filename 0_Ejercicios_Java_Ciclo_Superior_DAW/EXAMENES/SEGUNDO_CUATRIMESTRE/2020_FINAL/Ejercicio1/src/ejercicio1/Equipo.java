package ejercicio1;

import java.util.ArrayList;

/**
 *
 * @author IVAN
 */
public class Equipo {
    //private String nombre;
    private int id;
    private ArrayList<Jugador> jugadores=new ArrayList<Jugador>();

    public Equipo(int id,ArrayList<Jugador> j) {
        this.id = id;
        this.jugadores=j;
    }
    
    public int calcularPuntuacion(){
        int puntuacion=0;
        for(int i=0;i<jugadores.size();i++){
            puntuacion+=jugadores.get(i).calcularPuntuacion();
        }
        return puntuacion;
    } 

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

}