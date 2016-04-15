package lesson5.theme1;

import javax.swing.*;
import java.awt.*;

public class FJPanelAnonymousClass {

    public FJPanelAnonymousClass(){

        JFrame f = new JFrame("Drawing JPanel");
        f.setLocation(100, 100);
        f.setMinimumSize(new Dimension(800, 600));

        f.getContentPane().add(new JPanel(){
                @Override
                protected void paintComponent(Graphics g){

                    super.paintComponent(g);
                    g.setColor(Color.GREEN);
                    g.fillRect(0, 0, 800, 600);

                }
            });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args){

        FJPanelAnonymousClass fjp = new FJPanelAnonymousClass();
    }
}


