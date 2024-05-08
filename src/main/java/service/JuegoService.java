package service;

import model.Cantador;
import model.Juego;
import model.Jugador;

import java.util.ArrayList;

public class JuegoService {

    // Método para crear un nuevo juego
    public Juego crearJuego(Cantador cantador, ArrayList<Jugador> jugadores) {
        Juego juego = new Juego();
        juego.setCantador(cantador);
        juego.setJugadores(jugadores);
        return juego;
    }

    // Método para agregar un jugador al juego
    public void agregarJugador(Juego juego, Jugador jugador) {
        ArrayList<Jugador> jugadores = juego.getJugadores();
        jugadores.add(jugador);
        juego.setJugadores(jugadores);
    }

    // Método para eliminar un jugador del juego
    public void eliminarJugador(Juego juego, Jugador jugador) {
        ArrayList<Jugador> jugadores = juego.getJugadores();
        jugadores.remove(jugador);
        juego.setJugadores(jugadores);
    }

    // Método para obtener la cantidad de jugadores en el juego
    public int obtenerCantidadJugadores(Juego juego) {
        ArrayList<Jugador> jugadores = juego.getJugadores();
        return jugadores.size();
    }

    // Método para obtener el estado del cántaro del juego
    public ArrayList<Cantador> obtenerEstadoCantaro(Juego juego) {
        ArrayList<Cantador> estadoCantaro = new ArrayList<>();
        estadoCantaro.add(juego.getCantador());
        return estadoCantaro;
    }
}
