package tanks;

import battleFields.BattleField;
import enumerations.Direct;
import actions.Slider;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class BT7 extends AbstractTank {

    private Image[] images;
    private final static String IMAGE_UP = "bt7_UP.png";
    private final static String IMAGE_DOWN = "bt7_DOWN.png";
    private final static String IMAGE_LEFT = "bt7_LEFT.png";
    private final static String IMAGE_RIGHT = "bt7_RIGHT.png";
    private Image iBT7;

    public BT7(Slider sdr, BattleField bf){
        super(sdr, bf, 128, 128, Direct.LEFT);
    }

    public BT7(Slider sdr, BattleField bf, int x, int y, Direct direction) throws Exception {
        super(sdr, bf, x, y, direction);
        this.tank = new Color(80, 80, 80);
        this.tower = new Color(0, 0, 0);
        this.speed = 18;
        setImages();

    }

    private void setImages(){

        images = new Image[4];
        try{
            images[0] = ImageIO.read(new File(IMAGE_UP));
            images[1] = ImageIO.read(new File(IMAGE_DOWN));
            images[2] = ImageIO.read(new File(IMAGE_LEFT));
            images[3] = ImageIO.read(new File(IMAGE_RIGHT));
        }catch(IOException e){
            for(Image i : images){
                System.err.println("Can't find image BT7: " + i.toString());
            }
        }
    }

    @Override
    public void drawComponent(Graphics g) {

        if(this.getDirection() == Direct.UP) {
            iBT7 = images[0];
            g.drawImage(iBT7, x, y, new ImageObserver() {

                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        } else if(this.getDirection() == Direct.DOWN) {
            iBT7 = images[1];
            g.drawImage(iBT7, x, y, new ImageObserver() {

                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        } else if(this.getDirection() == Direct.LEFT) {
            iBT7 = images[2];
            g.drawImage(iBT7, x, y, new ImageObserver() {

                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        } else {
            iBT7 = images[3];
            g.drawImage(iBT7, x, y, new ImageObserver() {

                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        }
    }

}


