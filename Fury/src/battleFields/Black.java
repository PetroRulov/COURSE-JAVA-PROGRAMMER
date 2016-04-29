package battleFields;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Black extends AbstractComponent {

    private final static String IMAGE_NAME = "black.png";
    private Image iBlack;

    public Black(){}

    public Black(int x, int y) throws Exception{

        super(x, y);
        this.name = "C";
        this.x = x;
        this.y = y;
        this.color = new Color(0, 0, 0);
        try{
            iBlack = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.err.println("Can't find image of Water: " + IMAGE_NAME);
        }
    }

    @Override
    public void paintComponent(Graphics g){

        g.drawImage(iBlack, x, y, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }
}
