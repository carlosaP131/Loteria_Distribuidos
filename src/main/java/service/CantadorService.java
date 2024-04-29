
package service;

import java.util.ArrayList;
import java.util.Collections;
import model.Cantador;
import model.Carta;

/**
 *
 * @author Nancy
 */
public class CantadorService {
     // Constructor para inicializar el servicio si es necesario
    public CantadorService() {
    }

    // Método para inicializar el cantador con las cartas y mezclarlas
    public void inicializarCantador(Cantador cantador, ArrayList<Carta> cartas) {
        cantador.setCartasEnCantaro(new ArrayList<>(cartas)); // Copia de las cartas al cantaro
        cantador.setCartasSacadas(new ArrayList<>());         // Lista vacía para las cartas sacadas
        mezclarCartas(cantador);                              // Mezclar las cartas
    }

    // Método para mezclar las cartas dentro del cantador
    private void mezclarCartas(Cantador cantador) {
        Collections.shuffle(cantador.getCartasEnCantaro());
    }

    // Método para sacar una carta del cantador
    public Carta sacarCarta(Cantador cantador) {
        if (!cantador.getCartasEnCantaro().isEmpty()) {
            Carta carta = cantador.getCartasEnCantaro().remove(0); // Sacar la primera carta
            cantador.getCartasSacadas().add(carta);                // Agregar a la lista de sacadas
            return carta;
        }
        return null; // Retorna null si no hay más cartas
    }
}
