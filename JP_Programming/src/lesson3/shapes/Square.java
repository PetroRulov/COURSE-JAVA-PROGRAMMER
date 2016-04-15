package lesson3.shapes;

import java.awt.*;

public class Square extends Rectangle {

    public Square(){

        System.out.println("SQUARE");
    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(40));
        g.setColor(new Color(200, 0, 255));
        g.drawRect(400, 300, 250, 250);
        g.setColor(new Color(180, 250, 100));
        g.fillRect(400, 300, 250, 250);
        System.out.println("DRAWING SQUARE!!!");
    }
}
