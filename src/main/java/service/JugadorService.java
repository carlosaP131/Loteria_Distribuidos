package service;

import java.util.List;
import model.Carton;
import model.Jugador;

public class JugadorService {

    // Método para crear un nuevo jugador
    public Jugador crearJugador(int idJugador, String nombre, Carton carton) {
        Jugador jugador = new Jugador();
        jugador.setIdJugador(idJugador);
        jugador.setNombre(nombre);
        jugador.setCarton(carton);
        return jugador;
    }

    // Método para actualizar el cartón de un jugador
    public void actualizarCarton(Jugador jugador, Carton nuevoCarton) {
        jugador.setCarton(nuevoCarton);
    }

    // Método para buscar un jugador por su ID en una lista de jugadores
    public Jugador buscarPorId(List<Jugador> jugadores, int id) {
        for (Jugador jugador : jugadores) {
            if (jugador.getIdJugador() == id) {
                return jugador;
            }
        }
        return null; // Retorna null si no se encuentra el jugador con el ID dado
    }

    // Método para buscar un jugador por su nombre en una lista de jugadores
    public Jugador buscarPorNombre(List<Jugador> jugadores, String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombre)) {
                return jugador;
            }
        }
        return null; // Retorna null si no se encuentra el jugador con el nombre dado
    }
}
