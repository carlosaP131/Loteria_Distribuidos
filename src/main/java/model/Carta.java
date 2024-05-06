/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author labinfo04
 */
public class Carta {
    
    private int idCarta;
    private String nombre;
    private String rutaCarta;
      public Carta(String nombre, String rutaCarta, int idCarta) {
        this.nombre = nombre;
        this.rutaCarta = rutaCarta;
        this.idCarta= idCarta;
    }
    public int getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(int idCarta) {
        this.idCarta = idCarta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutaCarta() {
        return rutaCarta;
    }

    public void setRutaCarta(String rutaCarta) {
        this.rutaCarta = rutaCarta;
    }
  
    
    
}
