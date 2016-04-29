package battleFields;

import interfaces.IWayable;

import javax.imageio.ImageIO;
import java.awt.Color;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Brick extends AbstractComponent implements IWayable{

    private final static String IMAGE_NAME = "bricks.png";
    private Image iBrick;

    public Brick(){}

    public Brick(int x, int y) throws Exception{

        super(x, y);
        this.wayable = 2;
        this.name = "B";
        this.x = x;
        this.y = y;
        this.color = new Color(220, 50, 0);
        try{
            iBrick = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.err.println("Can't find image of Water: " + IMAGE_NAME);
        }
    }

    @Override
    public void paintComponent(Graphics g){

        g.drawImage(iBrick, x, y, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }

}
