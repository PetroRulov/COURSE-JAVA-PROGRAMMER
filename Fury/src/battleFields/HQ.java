package battleFields;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class HQ extends AbstractComponent {

    private final static String IMAGE_NAME = "eagle.png";
    private Image iHQ;

    public HQ(){}

    public HQ(int x, int y) throws Exception{

        super(x, y);
        this.name = "S";
        this.x = x;
        this.y = y;
        this.color = new Color(0, 200, 150);
        try{
            iHQ = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.err.println("Can't find image of Plant: " + IMAGE_NAME);
        }
    }

    @Override
    public void paintComponent(Graphics g){

        g.drawImage(iHQ, x, y, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }
}
