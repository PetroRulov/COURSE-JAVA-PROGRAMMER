package battleFields;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Plant extends AbstractComponent {

    private final static String IMAGE_NAME = "plant.png";
    private Image iPlant;

    public Plant(){}

    public Plant(int x, int y) throws Exception{

        super(x, y);
        this.wayable = 1;
        this.name = "P";
        this.x = x;
        this.y = y;
        this.color = new Color(180, 180, 180);
        try{
            iPlant = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.err.println("Can't find image of Plant: " + IMAGE_NAME);
        }

    }

    @Override
    public void paintComponent(Graphics g){

        g.drawImage(iPlant, x, y, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }

}