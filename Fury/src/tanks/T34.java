package tanks;

import battleFields.BattleField;
import enumerations.Direct;
import actions.Slider;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class T34 extends AbstractTank {

    private String IMAGE_UP = "t34_UP.png";
    private String IMAGE_DOWN = "t34_DOWN.png";
    private String IMAGE_LEFT = "t34_LEFT.png";
    private String IMAGE_RIGHT = "t34_RIGHT.png";
    private Image iT34;


    public T34(Slider sdr, BattleField bf){
        super(sdr, bf, 448, 64, Direct.LEFT);
    }

    public T34(Slider sdr, BattleField bf, int x, int y, Direct direction) throws Exception {
        super(sdr, bf, x, y, direction);
        this.speed = 8;
        setImages();
    }

    public void setImages(){

        images = new Image[4];
        try{
            images[0] = ImageIO.read(new File(IMAGE_UP));
            images[1] = ImageIO.read(new File(IMAGE_DOWN));
            images[2] = ImageIO.read(new File(IMAGE_RIGHT));
            images[3] = ImageIO.read(new File(IMAGE_LEFT));
        }catch(IOException e){
            for(Image i : images){
                System.err.println("Can't find image T-34: " + i.toString());
            }
        }
    }

    @Override
    public void drawComponent(Graphics g) {

        if(this.getDirection() == Direct.UP) {
            iT34 = images[0];
            g.drawImage(iT34, x, y, new ImageObserver() {

                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        } else if(this.getDirection() == Direct.DOWN) {
            iT34 = images[1];
            g.drawImage(iT34, x, y, new ImageObserver() {

                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        } else if(this.getDirection() == Direct.LEFT) {
            iT34 = images[2];
            g.drawImage(iT34, x, y, new ImageObserver() {

                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        } else {
            iT34 = images[3];
            g.drawImage(iT34, x, y, new ImageObserver() {

                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        }
    }
}



