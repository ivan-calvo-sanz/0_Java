package SerializableCarateres_AdivinarNumero;

import java.io.Serializable;

public class Jugador implements Serializable {

    public static final long serialVersionUID = 1L;

    private int id;
    private Juego juego;
    private int ultNumJugado;
    
    

    public Jugador(int id, Juego juego) {
        this.id = id;
        this.juego = juego;
    }

    public int intento(int numJugado,int limiteInferior, int limiteSuperior, boolean auto) {
        if(auto){
            ultNumJugado=(int)(Math.random()*((limiteSuperior+1)-limiteInferior))+limiteInferior;
            return juego.jugada(id,ultNumJugado);
        }else{
            ultNumJugado=numJugado;
            return juego.jugada(id, ultNumJugado);   
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public int getUltNumJugado() {
        return ultNumJugado;
    }

    public void setUltNumJugado(int ultNumJugado) {
        this.ultNumJugado = ultNumJugado;
    }

}
