package shapes;

import java.awt.Dimension;
import java.io.IOException;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ShapesTemplate extends JPanel {

    IDrawable[] shapes;

    public ShapesTemplate(IDrawable[] shapes2) throws IOException {
        this.shapes = shapes2;
        if (shapes2 == null || shapes2.length < 1) {
            throw new IOException("Check IDrawable arrays elements");
        }

        JFrame frame = new JFrame("DAY 3, 2D Graphics");
        frame.setLocation(250, 25); // position on the screen (x, y)
        frame.setMinimumSize(new Dimension(725, 625)); // size (h x v)
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        for (IDrawable s : shapes) {
            s.draw(g);
        }
    }
}

