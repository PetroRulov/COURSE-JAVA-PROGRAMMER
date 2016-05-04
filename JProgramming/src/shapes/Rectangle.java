package shapes;

import java.awt.*;

public class Rectangle extends AbstractShape {

    public Rectangle(){

        System.out.println("RECTANGLE");
    }

    @Override
    public void draw(java.awt.Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(0, 0, 255));
        g2d.setStroke(new BasicStroke(20));
        g.drawRect(50, 300, 250, 250);
        g2d.setColor(new Color(255, 255, 255));
        g.fillRect(50, 300, 250, 250);
        System.out.println("Drawing RECTANGLE!!!");

    }
}