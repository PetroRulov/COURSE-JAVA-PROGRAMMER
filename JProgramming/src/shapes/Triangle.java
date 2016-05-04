package shapes;

import java.awt.*;

public class Triangle extends AbstractShape {

    public Triangle(){

        System.out.println("TRIANGLE");
    }

    @Override
    public void draw(Graphics g){

        int[]x = new int[]{525, 400, 650}; int[]y = new int[]{50, 250, 250};// (X = top, left, right) - (Y = top, left, right)

        Graphics2D g2d = (Graphics2D) g;
        g.setColor(new Color(255, 0, 0));
        g2d.setStroke(new BasicStroke(30));
        g.drawPolygon(x, y, 3);
        g.setColor(new Color(0, 255, 0));
        g.fillPolygon(x, y, 3);
        System.out.println("Drawing TRIANGLE!!!");
    }
}