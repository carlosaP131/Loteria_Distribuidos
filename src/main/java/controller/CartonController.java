package controller;

import model.Carton;
import service.CartonService;

public class CartonController {
    private CartonService cartonService;

    public CartonController() {
        this.cartonService = new CartonService();
    }

    // Método para crear un nuevo cartón
    public Carton crearCarton(int[][] matrizMarcado) {
        return cartonService.crearCarton(matrizMarcado);
    }

    // Método para marcar una carta en el cartón
    public void marcarCarta(Carton carton, int fila, int columna) {
        cartonService.marcarCarta(carton, fila, columna);
    }

    // Método para desmarcar una carta en el cartón
    public void desmarcarCarta(Carton carton, int fila, int columna) {
        cartonService.desmarcarCarta(carton, fila, columna);
    }

    // Método para verificar si la matriz marcada está llena
    public String verificarMatrizLlena(Carton carton) {
        return cartonService.verificarMatrizLlena(carton);
    }
}
