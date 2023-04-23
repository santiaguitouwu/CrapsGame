package juegoCraps;

;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used as view craps class
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {

    private static final String MENSAJE_INICIO = "BIENVENIDO A CRAPS\n"
            +"Oprime el botón lanzar para iniciar el juego"
            +"\n Sí tu tiro de salida es 7 u 11 ganas con natural"
            +"\n Sí tu tiro de salida es 2, 3 u 12 pierdes con Craps"
            +"\n Sí sacas cualquier otro valor estableces el Punto"
            +"\n Estando en punto podrás seguir lanzando los dados"
            +"\n pero ahora ganarás si sacas el valor del Punto"
            +"\n sin que previamente hayas sacado 7";
    private Header headerProject;
    private JLabel dado1, dado2;
    private JButton lanzar;
    private JPanel panelDados, panelResultados;
    private ImageIcon imageDado;
    private JTextArea resultados;

    /**
     * Constructor of myProject.GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Craps Game");
        //this.setSize(800,270);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the myProject.GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        //Set up JComponents
        headerProject = new Header("Mesa de Juego Craps", Color.BLACK);

        this.add(headerProject,BorderLayout.NORTH);

        imageDado = new ImageIcon(getClass().getResource("/resources/dado.png"));
        dado1 = new JLabel(imageDado);
        dado2 = new JLabel(imageDado);

        lanzar = new JButton("Lanzar");

        panelDados = new JPanel();
        panelDados.setPreferredSize(new Dimension(300,200));
        panelDados.setBorder(BorderFactory.createTitledBorder("Tus dados"));
        panelDados.add(dado1);
        panelDados.add(dado2);
        panelDados.add(lanzar);

        this.add(panelDados, BorderLayout.CENTER);

        resultados = new JTextArea(7,31);
        resultados.setText(MENSAJE_INICIO);
        resultados.setBorder(BorderFactory.createTitledBorder("Que debes hacer"));
        JScrollPane scroll = new JScrollPane(resultados);
        this.add(scroll, BorderLayout.EAST);
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by myProject.GUI class
     */
    private class Escucha {

    }
}
