/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.Cantador;
import model.Carta;

/**
 *
 * @author labinfo02
 */
public class CantadorService {
       public void agregarCarta(Cantador cantador, Carta carta) {
        List<Carta> cartasEnCantaro = cantador.getCartasEnCantaro();
        cartasEnCantaro.add(carta);
        cantador.setCartasEnCantaro((ArrayList<Carta>) cartasEnCantaro);
    }

    public Carta sacarCarta(Cantador cantador) {
        List<Carta> cartasEnCantaro = cantador.getCartasEnCantaro();
        if (!cartasEnCantaro.isEmpty()) {
            Carta carta = cartasEnCantaro.remove(0);
            List<Carta> cartasSacadas = cantador.getCartasSacadas();
            cartasSacadas.add(carta);
            cantador.setCartasSacadas((ArrayList<Carta>) cartasSacadas);
            cantador.setCartasEnCantaro((ArrayList<Carta>) cartasEnCantaro);
            return carta;
        } else {
            System.out.println("No hay cartas en el cantaro.");
            return null;
        }
    }

    
    
    
    
}
