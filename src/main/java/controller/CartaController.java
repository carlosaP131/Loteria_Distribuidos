package controller;

import model.Carta;
import service.CartaService;

public class CartaController {

    private CartaService cartaService;

    public CartaController() {
        this.cartaService = new CartaService();
    }

    // Método para crear una nueva carta
    public Carta crearCarta(String nombre, String rutaCarta, int idCarta) {
        return cartaService.crearCarta(nombre, rutaCarta, idCarta);
    }

    // Método para actualizar los datos de una carta
    public void actualizarDatosCarta(Carta carta, String nuevoNombre, String nuevaRuta) {
        cartaService.actualizarDatosCarta(carta, nuevoNombre, nuevaRuta);
    }
}
