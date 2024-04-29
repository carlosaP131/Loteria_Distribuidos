
package controller;

import java.util.ArrayList;
import model.Carta;
import model.Carton;
import service.CartonService;

/**
 *
 * @author Nancy
 */
public class CartonController {
    
     private CartonService cartonService;

    public CartonController() {
        this.cartonService = new CartonService();
    }

    public void crearCarton(ArrayList<Carta> cartasDisponibles) {
        Carton carton = new Carton();
        cartonService.inicializarCarton(carton, cartasDisponibles);
        // Puede ser necesario guardar el cartón o pasarlo a la vista
    }

    public void marcarCartaEnCarton(Carton carton, Carta carta) {
        cartonService.marcarCarta(carton, carta);
        if (cartonService.verificarGanador(carton)) {
            System.out.println("¡Tenemos un ganador!");
            // Realizar acciones después de que se gana el juego, como reiniciar o actualizar la vista
        }
    }
    
}
