package lesson5.theme5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Frame_5_5_3_MagicRectangle extends JPanel /*implements MouseListener*/ {

    Color color = new Color(0, 0, 0);

    public Frame_5_5_3_MagicRectangle() {

        JFrame frame = new JFrame("MAGIC RECTANGLE");
        frame.setLocation(50, 50);
        frame.setMinimumSize(new Dimension(500, 350));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if(e.getX() >= 125 && e.getX() <= 375 && e.getY() >= 25 && e.getY() <= 275){
                    color = defineColor();
                    repaint();
                }
            }
        });

        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

    }

    public void paintComponent (Graphics g){

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g.fillRect(125, 25, 250, 250);
    }

    public Color defineColor() {

        Color color  = new Color(0, 0, 0);

        int i = toRandomI();
        if(i == 0){
            color = new Color(0, 100, 0);
        }else if(i == 1) {
            color = new Color(100, 0, 0);
        }else if(i == 2){
            color = new Color(0, 0, 255);
        }else if(i == 3){
            color = new Color(0, 255, 255);
        }else if(i == 4){
            color = new Color(0, 0, 0);
        }else{
            color = i == 5 ? new Color(255, 255, 0) : new Color (200, 0, 0);
        }
        return color;
    }

    private int toRandomI() {

        Random r = new Random();
        int i = r.nextInt(6);
        return i;
    }

    public static void main(String[] args){

        new Frame_5_5_3_MagicRectangle();
    }

}
