package lesson5.theme5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Frame_5_5_4_AngeredFriend extends JPanel {

    int x = 300;
    int y = 300;


    public Frame_5_5_4_AngeredFriend() {

        JFrame frame = new JFrame("CLICK ME:-)!");
        frame.setLocation(50, 0);
        frame.setMinimumSize(new Dimension(700, 700));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {

                if (e.getX() <= 350 && e.getY() <= 350) {
                    x = e.getX() + 25;
                    y = e.getY() + 25;
                    repaint();
                } else if (e.getX() > 350 && e.getY() <= 350) {
                    x = e.getX() - 75;
                    y = e.getY() + 25;
                    repaint();
                } else if (e.getX() <= 350 && e.getY() > 350) {
                    x = e.getX() + 25;
                    y = e.getY() - 75;
                    repaint();
                } else {
                    x = e.getX() - 75;
                    y = e.getY() - 75;
                    repaint();
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {

                if (e.getX() <= 350 && e.getY() <= 350) {
                    x = e.getX() + 25;
                    y = e.getY() + 25;
                    repaint();
                } else if (e.getX() > 350 && e.getY() <= 350) {
                    x = e.getX() - 75;
                    y = e.getY() + 25;
                    repaint();
                } else if (e.getX() <= 350 && e.getY() > 350) {
                    x = e.getX() + 25;
                    y = e.getY() - 75;
                    repaint();
                } else {
                    x = e.getX() - 75;
                    y = e.getY() - 75;
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
        g2d.setColor(new Color(255, 0, 0));
        g.fillOval(x, y, 75, 75);
        g2d.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Garamond", Font.BOLD, 10));
        g.drawString("Click me!", x + 17, y + 45);
    }

    public static void main(String[] args){

        new Frame_5_5_4_AngeredFriend();
    }

}
