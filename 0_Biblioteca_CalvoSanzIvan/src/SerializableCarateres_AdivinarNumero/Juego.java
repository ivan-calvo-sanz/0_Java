package SerializableCarateres_AdivinarNumero;

import java.io.Serializable;

public class Juego implements Serializable {

    public static final long serialVersionUID = 1L;

    private int numOculto;
    private int numMaximoOculto;
    private int turno;
    private int ganador;
    private int numJugadores;

    public Juego(int numMaximoOculto, int numJugadores) {
        this.numMaximoOculto = numMaximoOculto;
        this.numJugadores = numJugadores;
        this.numOculto = (int) (Math.random() * this.numMaximoOculto + 1);
        this.turno = 1;
    }

    public int jugada(int id, int numJugado) {
        if (numJugado < this.numOculto) {
            actualizaTurno();
            return -1;
        } else if (numJugado == this.numOculto) {
            this.ganador = this.turno;
            return 0;
        } else {
            actualizaTurno();
            return 1;
        }
    }

    private void actualizaTurno() {
        if (this.turno == this.numJugadores) {
            this.turno = 1;
        } else {
            this.turno += 1;
        }
    }

    public int getNumOculto() {
        return numOculto;
    }

    public void setNumOculto(int numOculto) {
        this.numOculto = numOculto;
    }

    public int getNumMaximoOculto() {
        return numMaximoOculto;
    }

    public void setNumMaximoOculto(int numMaximoOculto) {
        this.numMaximoOculto = numMaximoOculto;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

}
