package lesson5.theme1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by prulov on 15.04.2016.
 */
public class FJP_WithOwnClass {

    public FJP_WithOwnClass(){

        JFrame f = new JFrame("Drawing JPanel");
        f.setLocation(100, 100);
        f.setMinimumSize(new Dimension(800, 600));

        JPanel p = new JPanel(){

            @Override
            protected void paintComponent(Graphics g){

                super.paintComponent(g);
                g.setColor(Color.GREEN);
                g.fillRect(0, 0, 800, 600);

            }
        };

        f.getContentPane().add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.pack();
        f.setVisible(true);

    }

    public static void main(String[] args){

        FJP_WithOwnClass fjp = new FJP_WithOwnClass();

    }
}
