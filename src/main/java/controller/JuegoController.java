package controller;

import model.Cantador;
import model.Juego;
import model.Jugador;
import service.JuegoService;

import java.util.ArrayList;

public class JuegoController {
    private JuegoService juegoService;

    public JuegoController() {
        this.juegoService = new JuegoService();
    }

    // Método para crear un nuevo juego
    public Juego crearJuego(Cantador cantador, ArrayList<Jugador> jugadores) {
        return juegoService.crearJuego(cantador, jugadores);
    }

    // Método para agregar un jugador al juego
    public void agregarJugador(Juego juego, Jugador jugador) {
        juegoService.agregarJugador(juego, jugador);
    }

    // Método para eliminar un jugador del juego
    public void eliminarJugador(Juego juego, Jugador jugador) {
        juegoService.eliminarJugador(juego, jugador);
    }

    // Método para obtener la cantidad de jugadores en el juego
    public int obtenerCantidadJugadores(Juego juego) {
        return juegoService.obtenerCantidadJugadores(juego);
    }

    // Método para obtener el estado del cántaro del juego
    public ArrayList<Cantador> obtenerEstadoCantaro(Juego juego) {
        return juegoService.obtenerEstadoCantaro(juego);
    }
    
        public Jugador obtenerJugadorId(Juego juego,int id){
            return juegoService.obtenerJugadorId(juego, id);
        }
}
