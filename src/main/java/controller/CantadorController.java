/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Cantador;
import model.Carta;

/**
 *
 * @author labinfo02
 */
public class CantadorController {
     private Cantador cantador;

    public CantadorController(Cantador cantador) {
        this.cantador = cantador;
    }

    public void agregarCarta(Carta carta) {
        cantador.getCartasEnCantaro().add(carta);
    }

    public Carta sacarCarta() {
        if (!cantador.getCartasEnCantaro().isEmpty()) {
            Carta carta = cantador.getCartasEnCantaro().remove(0);
            cantador.getCartasSacadas().add(carta);
            return carta;
        } else {
            System.out.println("No hay cartas en el cantaro.");
            return null;
        }
    }

}
