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

    public Carta crearCarta(String nombre, String rutaCarta, int idCarta) {

        Carta carta = new Carta(nombre, rutaCarta, idCarta);

        return carta;
    }

    public void actualizarDatosCarta(Carta carta, String nuevoNombre, String nuevaRuta) {
        carta.setNombre(nuevoNombre);
        carta.setRutaCarta(nuevaRuta);
    }

}
