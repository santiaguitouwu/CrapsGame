package juegoCraps;

import java.util.Random;
/**
 * generate a random value between 1 and 6
 * @author Santiago Jimenez/santiago.abihatar.jimenez@correounivalle.edu.co
 * @version 1.0.0
 **/
public class Dado {
    private int cara;

    public int getCara() {
        Random aleatorio = new Random();
        cara = aleatorio.nextInt(6) + 1;
        return cara;
    }
}
