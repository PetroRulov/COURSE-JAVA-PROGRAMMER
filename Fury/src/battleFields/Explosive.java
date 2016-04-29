package battleFields;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Explosive extends AbstractComponent{

    private final static String IMAGE_NAME = "explosive.png";
    private Image iExplosive;

    public Explosive(){}

    public Explosive(int x, int y) throws Exception{

        super(x, y);
        this.name = "E";
        this.x = x;
        this.y = y;
        //this.color = new Color(255, 255, 0);
        try{
            iExplosive = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.err.println("Can't find image: " + IMAGE_NAME);
        }

    }

    @Override
    public void drawComponent(Graphics g){

        g.drawImage(iExplosive, x, y, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }
}
