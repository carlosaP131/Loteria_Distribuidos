package service;

import model.Carton;

public class CartonService {

    // Método para crear un nuevo cartón
    public Carton crearCarton(int[][] matrizMarcado) {
        Carton carton = new Carton();
        carton.setMatrizMarcado(matrizMarcado);
        return carton;
    }

    // Método para marcar una carta en el cartón
    public void marcarCarta(Carton carton, int fila, int columna) {
        int[][] matrizMarcado = carton.getMatrizMarcado();
        matrizMarcado[fila][columna] = 1;
        carton.setMatrizMarcado(matrizMarcado);
    }

    // Método para desmarcar una carta en el cartón
    public void desmarcarCarta(Carton carton, int fila, int columna) {
        int[][] matrizMarcado = carton.getMatrizMarcado();
        matrizMarcado[fila][columna] = 0;
        carton.setMatrizMarcado(matrizMarcado);
    }

    // Método para verificar si la matriz marcada está llena
    public String verificarMatrizLlena(Carton carton) {
        int[][] matrizMarcado = carton.getMatrizMarcado();
        for (int i = 0; i < matrizMarcado.length; i++) {
            for (int j = 0; j < matrizMarcado[i].length; j++) {
                if (matrizMarcado[i][j] == 0) {
                    return "No llena";
                }
            }
        }
        return "Llena";
    }
}
