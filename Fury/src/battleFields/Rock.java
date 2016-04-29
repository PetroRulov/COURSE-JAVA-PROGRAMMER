package battleFields;

import interfaces.INonDestructable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Rock extends AbstractComponent implements INonDestructable {

    private final static String IMAGE_NAME = "rock.png";
    private Image iRock;

    private int strength;

    public Rock(){}

    public Rock(int x, int y) throws Exception{

        super(x, y);
        this.wayable = 1_000;
        this.name = "R";
        this.x = x;
        this.y = y;
        this.color = new Color(255, 255, 255);
        strength = 1;
        try{
            iRock = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.err.println("Can't find image of Water: " + IMAGE_NAME);
        }
    }

    @Override
    public void paintComponent(Graphics g){

        g.drawImage(iRock, x, y, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }
}
