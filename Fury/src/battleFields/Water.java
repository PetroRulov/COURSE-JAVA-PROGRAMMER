package battleFields;

import interfaces.INonDestructable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Water extends AbstractComponent implements INonDestructable{

    private final static String IMAGE_NAME = "water.png";
    private Image iWater;

    public Water(){}

    public Water(int x, int y) throws Exception{

        super(x, y);
        this.wayable = 10_000;
        this.name = "W";
        this.x = x;
        this.y = y;
        this.color = new Color(0, 0, 250);
        try{
            iWater = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.err.println("Can't find image of Water: " + IMAGE_NAME);
        }
    }

    @Override
    public void paintComponent(Graphics g){

        Graphics2D g2D = (Graphics2D) g;
        Composite org = g2D.getComposite();

        if(this.getY() <= 320) {
            Composite translucent = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f);
            g2D.setComposite(translucent);
        }else{
            g2D.setComposite(org);
        }

        g.drawImage(iWater, x, y, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
        g2D.setComposite(org);
    }
}
