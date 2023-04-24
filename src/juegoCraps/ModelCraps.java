package juegoCraps;

/**
 * Class modelCraps apply craps rules
 * estado = 1 Natural, winner
 * estado = 2 Craps, looser
 * estado = 3 establish punto
 * estado = 4 punto, winner
 * estado = 5 punto, looser
 * @author Santiago Jimenez/santiago.abihatar.jimenez@correounivalle.edu.co
 * @version 1.0.0
 **/

public class ModelCraps {
    private Dado dado1, dado2;
    private int tiro, punto, estado, flag;
    private String estadoToString;
    private int[] caras; //arreglo que me guarda las caras del dado(0-5)

    /**
    *Class constructor
    */
    public ModelCraps(){
        dado1 = new Dado();
        dado2 = new Dado();
        caras = new int[2];
    }

    /**
     * establish the tiro value according to each dice
     */
    public void calcularTiro(){
        caras[0] = dado1.getCara();
        caras[1] = dado2.getCara();
        tiro = caras[0] + caras[1];
        flag = 0;
    }

    /**
     * establish game state according to:
     * estado = 1 Natural, winner
     * estado = 2 Craps, looser
     * estado = 3 establish punto
     * estado = 4 punto, winner
     * estado = 5 punto, looser
     */
    public void determinarJuego(){
        if(flag==0){//ronda inicial
            if(tiro==7 || tiro==10){
                estado=1;
            }
            else{
                if(tiro==2 || tiro==3 || tiro==12){
                    estado = 2;
                }
                else{
                    estado = 3;
                    punto = tiro;
                    flag = 1;
                }
            }
        }
        else{//ronda de punto
            rondaPunto();
        }

    }

    /**
     * establish state game according to estado atribute value:
     * estado = 1 Natural, winner
     * estado = 2 Craps, looser
     * estado = 3 establish punto
     * estado = 4 punto, winner
     * estado = 5 punto, looser
     */
    private void rondaPunto() {
        if(tiro==punto){
            estado = 4;
            flag = 0;
        }
        if(tiro == 7){
            estado = 5;
            flag = 0;
        }
    }

    public int getTiro() {
        return tiro;
    }

    public int getPunto() {
        return punto;
    }

    /**
     * establish message game state according to estado atribute value
     * @return Message for the View class
     */
    public String getEstadoToString() {
        switch (estado){
            case 1: estadoToString="Sacaste natural, ganaste!";
                    break;
            case 2: estadoToString="Sacaste Craps, perdiste :(";
                    break;
            case 3: estadoToString="Estableciste punto en " + punto + ", debes seguir lanzando"+
                                    "\n pero si sacas 7 antes que " + punto + "perderás";
                    break;
            case 4: estadoToString="Volviste a sacar " + punto + ", has ganado!";
                    break;
            case 5: estadoToString="Sacaste 7 antes que " + punto + ", entonces has perdido";
                    break;
        }
        return estadoToString;
    }

    public int[] getCaras() {
        return caras;
    }
}
