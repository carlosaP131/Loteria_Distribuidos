/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Carta;

/**
 *
 * @author labinfo04
 */
public class CartaController {
    private List<Carta> cartas;

    public CartaController() {
        this.cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public List<Carta> getCartas() {
        return cartas;
    }

}
