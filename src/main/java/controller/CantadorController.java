package controller;

import java.util.ArrayList;
import model.Cantador;
import model.Carta;
import service.CantadorService;

public class CantadorController {

    private CantadorService cantadorService;

    public CantadorController(ArrayList<Carta> cartasEnCantaro) {
        this.cantadorService = new CantadorService(cartasEnCantaro);
    }

    // Método para agregar una carta al cántaro
    public void agregarCarta(Cantador cantador, Carta carta) {
        cantadorService.agregarCarta(cantador, carta);
    }

    // Método para sacar una carta del cántaro
    public Carta sacarCarta() {
        return cantadorService.sacarCarta();
    }

    // Método para reiniciar el cántaro
    public void reiniciarCantaro() {
        cantadorService.reiniciarCantaro();
    }
}
