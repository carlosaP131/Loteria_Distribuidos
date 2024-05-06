/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.Cantador;
import model.Carta;

/**
 *
 * @author labinfo02
 */
public class CantadorService {

    private ArrayList<Carta> cartasEnCantaro;
    private ArrayList<Carta> cartasSacadas;

    public CantadorService(ArrayList<Carta> cartasEnCantaro) {
        this.cartasEnCantaro = cartasEnCantaro;
        this.cartasSacadas = new ArrayList<>();
    }

    public void agregarCarta(Cantador cantador, Carta carta) {
        cartasEnCantaro = cantador.getCartasEnCantaro();
        cartasEnCantaro.add(carta);
        cantador.setCartasEnCantaro((ArrayList<Carta>) cartasEnCantaro);
    }

    public Carta sacarCarta() {
        if (!cartasEnCantaro.isEmpty()) {
            Carta cartaSacada = cartasEnCantaro.remove(0);
            cartasSacadas.add(cartaSacada);
            return cartaSacada;
        } else {
            return null;
        }
    }

    public void reiniciarCantaro() {
        cartasEnCantaro.addAll(cartasSacadas);
        cartasSacadas.clear();
        //mezclarCartas();
    }

}
