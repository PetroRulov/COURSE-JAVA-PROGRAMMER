package lesson5.theme1.theme2;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Imagination extends JPanel {

    private final static String IMAGE_NAME = "strawberry.jpg";
    private Image iStrawberry;
    private Image img;

    public Imagination(){

        try{
            iStrawberry = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.err.println("Can't find image: " + IMAGE_NAME);
        }
    }

    @Override
    protected void paintComponent(Graphics g){

        //super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 800, 600);

        g.setColor(new Color (0, 250, 250));
        g.fillRect(500, 400, 30, 30);
        g.draw3DRect(400, 300, 50, 50, false);

        g.setColor(new Color (250, 250, 0));
        g.fillRect(400, 300, 50, 50);
        g.draw3DRect(400, 300, 50, 50, true);

        g.drawString("STRAWBERRY", 100, 190);

        g.drawImage(iStrawberry, 100, 200, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }

    public static void main(String[] args){

        JFrame frame = new JFrame("DAY 5, Imagination, Frame 5_2_4");
        frame.setLocation(300, 100);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new Imagination());

        frame.pack();
        frame.setVisible(true);
    }
}
