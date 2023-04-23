package ejercicio1_v2;

public class Juego {
    private int numOculto;
    private int numMax;
    private int turno;
    private int ganador;
    private int numJugadores;
    
    public Juego(int numMax, int numJugadores){
        numOculto=generarNumAleatorio(1,numMax);
        this.numMax=numMax;
        turno=1;
        ganador=-1;
        this.numJugadores=numJugadores;
    }
    
    public Juego(){
    }
    
    public static int generarNumAleatorio(int n1,int n2){
        //int numeroAleatorio=(int)(Math.random()*n+1);
        int numeroAleatorio=(int)(Math.random()*((n2+1)-n1))+n1;
        return numeroAleatorio;
    }
    
    public int jugada(int idJugador,int numJugado){
        if(numJugado==numOculto){
            ganador=idJugador;
            return 0;
        }else if(numJugado>numOculto){
            turno=actualizaTurno(turno);
            return -1;
        }else{
            turno=actualizaTurno(turno);
            return 1;
        }
    }
    
    public int actualizaTurno(int turno){
        if(turno<numJugadores){
            turno++;
        }else{
            turno =1;
        }
        return turno;
    }

    public int getNumOculto() {
        return numOculto;
    }
    public void setNumOculto(int numOculto) {
        this.numOculto = numOculto;
    }
    public int getNumMax() {
        return numMax;
    }
    public void setNumMax(int numMax) {
        this.numMax = numMax;
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