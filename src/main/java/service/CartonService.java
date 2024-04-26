
package service;

import java.util.ArrayList;
import model.Carta;
import model.Carton;

/**
 *
 * @author labinfo07
 */
public class CartonService {
    private Carton cartonR;
    
    public CartonService(Carton cartonR){
        this.cartonR=cartonR;
    }
    
    public void marcarNumero(Carta carta){
        ArrayList<Carta>cartas=cartonR.getCartasEnCarton();
        int [][] matrizMarcado=cartonR.getMatrizMarcado();
    }
    
}
