package ejercicio1_v2;

class Jugador {
    private int idJugador;
    private Juego juego;
    int numJugado;
    
    public Jugador(int idJugador, Juego juego){
        this.idJugador=idJugador;
        this.juego=juego;
    }
    
    public Principal.comprobacion intento(int num1,int num2,boolean auto){
        if(auto){
            numJugado=juego.generarNumAleatorio(num1,num2);
            //System.out.println(" juega "+numJugado);
            return(juego.jugada(idJugador,numJugado));
        }else{
            numJugado=num1;
            return(juego.jugada(idJugador,numJugado));
        }
    }

    public int getIdJugador() {
        return idJugador;
    }
    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }
    public Juego getJuego() {
        return juego;
    }
    public void setJuego(Juego juego) {
        this.juego = juego;
    }
    public int getNumJugado() {
        return numJugado;
    }
    public void setNumJugado(int numJugado) {
        this.numJugado = numJugado;
    }
    
}