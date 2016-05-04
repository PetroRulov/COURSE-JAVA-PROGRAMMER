package shapes;

import java.awt.*;

public class Circle extends AbstractShape{

    public Circle(){

        System.out.println("CIRCLE");
    }

    @Override
    public void draw(java.awt.Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(0, 150, 150));
        g2d.setStroke(new BasicStroke(10));
        g.drawOval(50, 25, 250, 250); // (x, y, xR, yR)
        g2d.setColor(new Color(255, 255, 0));
        g.fillOval(50, 25, 250, 250);
        System.out.println("Drawing CIRCLE!!!");
    }
}

