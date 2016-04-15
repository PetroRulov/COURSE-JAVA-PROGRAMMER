package lesson5.theme1;

import javax.swing.*;
import java.awt.*;

public class HowToDraw extends JPanel {


    public HowToDraw() {

        JFrame frame = new JFrame("DAY 5, 2D Graphics");
        frame.setLocation(300, 100);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JPanel jP = new JPanel();
//        frame.getContentPane().add(jP);
        frame.getContentPane().add(this);

        frame.pack();
        frame.setVisible(true);

        repaint();
    }

    public static void main(String[] args){

        new HowToDraw();
    }
}
