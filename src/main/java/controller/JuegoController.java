
package controller;

import java.util.ArrayList;
import model.Carta;
import model.Juego;
import model.Jugador;
import service.JuegoService;

/**
 *
 * @author Nancy
 */
public class JuegoController {
     private JuegoService juegoService;
    private Juego juego;

    public JuegoController() {
        this.juegoService = new JuegoService();
        this.juego = new Juego();
    }

    public void iniciarJuego(ArrayList<Jugador> jugadores, ArrayList<Carta> cartas) {
        juegoService.inicializarJuego(juego, jugadores, cartas);
        // Notificar a la vista que el juego ha empezado, actualizar UI, etc.
    }

    public void jugarTurno() {
        if (juegoService.jugarTurno(juego)) {
            // No hay más cartas, terminar juego
            // Notificar a la vista que el juego ha terminado, actualizar UI, etc.
        } else {
            Jugador ganador = juegoService.verificarGanador(juego);
            if (ganador != null) {
                // Notificar a la vista que hay un ganador, actualizar UI, etc.
            }
        }
    }
}
