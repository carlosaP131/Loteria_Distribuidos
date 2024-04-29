
package service;

import java.util.ArrayList;
import model.Cantador;
import model.Carta;
import model.Juego;
import model.Jugador;

/**
 *
 * @author Nancy
 */
public class JuegoService {
    private CantadorService cantadorService;
    private CartonService cartonService;

    public JuegoService() {
        this.cantadorService = new CantadorService();
        this.cartonService = new CartonService();
    }

    public void inicializarJuego(Juego juego, ArrayList<Jugador> jugadores, ArrayList<Carta> cartas) {
        Cantador cantador = new Cantador();
        cantadorService.inicializarCantador(cantador, cartas);
        juego.setCantador(cantador);
        juego.setJugadores(jugadores);
    }

    public boolean jugarTurno(Juego juego) {
        Carta carta = cantadorService.sacarCarta(juego.getCantador());
        if (carta != null) {
            for (Jugador jugador : juego.getJugadores()) {
                cartonService.marcarCarta(jugador.getCarton(), carta);
            }
            return false; // El juego continúa
        }
        return true; // No hay más cartas, el juego termina
    }

    public Jugador verificarGanador(Juego juego) {
        for (Jugador jugador : juego.getJugadores()) {
            if (cartonService.verificarGanador(jugador.getCarton())) {
                return jugador;
            }
        }
        return null;
    }
}
