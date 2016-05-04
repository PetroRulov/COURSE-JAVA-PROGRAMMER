package lesson5.theme1;

import javax.swing.*;
import java.awt.*;

public class HowToDraw extends JPanel {

    static int x = 100;
    static int z = 125;
    static int y = 150;


    public HowToDraw() {

        JFrame frame = new JFrame("DAY 5, 2D Graphics");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JPanel jP = new JPanel();
//        frame.getContentPane().add(jP);
        frame.getContentPane().add(this);

        frame.pack();
        frame.setVisible(true);

        //repaint();
    }

    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillRect(x, 50, 20, 20);

        g.setColor(Color.YELLOW);
        g.fillRect(x, 100, 20, 20);

        g.setColor(Color.BLUE);
        g.fillRect(y, 150, 20, 20);
    }


    public static void main(String[] args) throws Exception{

        HowToDraw htd = new HowToDraw();

        Thread.sleep(500);
        System.out.println("Wake up!");


        for(int i = 0; i < 20; i++){

            x += 20;
            z += 15;
            y += 10;
            Thread.sleep(500);
            htd.repaint();
        }
    }
}
