/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Carta;

/**
 *
 * @author labinfo04
 */
public class CartaService {
     public void agregarCarta(List<Carta> cartas, Carta carta) {
        cartas.add(carta);
    }

    public void eliminarCarta(List<Carta> cartas, int idCarta) {
        cartas.removeIf(carta -> carta.getIdCarta() == idCarta);
    }

    public Carta buscarCartaPorId(List<Carta> cartas, int idCarta) {
        for (Carta carta : cartas) {
            if (carta.getIdCarta() == idCarta) {
                return carta;
            }
        }
        return null;
    }

}
