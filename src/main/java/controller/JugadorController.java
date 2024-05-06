package controller;

import java.util.List;
import model.Carton;
import model.Jugador;
import service.JugadorService;

public class JugadorController {

    private JugadorService jugadorService;

    public JugadorController() {
        this.jugadorService = new JugadorService();
    }

    // Método para crear un nuevo jugador
    public Jugador crearJugador(int idJugador, String nombre, Carton carton) {
        return jugadorService.crearJugador(idJugador, nombre, carton);
    }

    // Método para actualizar el cartón de un jugador
    public void actualizarCarton(Jugador jugador, Carton nuevoCarton) {
        jugadorService.actualizarCarton(jugador, nuevoCarton);
    }

    // Método para buscar un jugador por su ID en una lista de jugadores
    public Jugador buscarPorId(List<Jugador> jugadores, int id) {
        return jugadorService.buscarPorId(jugadores, id);
    }

    // Método para buscar un jugador por su nombre en una lista de jugadores
    public Jugador buscarPorNombre(List<Jugador> jugadores, String nombre) {
        return jugadorService.buscarPorNombre(jugadores, nombre);
    }
}
