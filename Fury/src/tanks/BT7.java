package tanks;

import battleFields.BattleField;
import enumerations.Direct;
import actions.Slider;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BT7 extends AbstractTank {

    private String IMAGE_UP = "bt7_UP.png";
    private String IMAGE_DOWN = "bt7_DOWN.png";
    private String IMAGE_LEFT = "bt7_LEFT.png";
    private String IMAGE_RIGHT = "bt7_RIGHT.png";


    public BT7(Slider sdr, BattleField bf){
        super(sdr, bf, 128, 128, Direct.LEFT);
    }

    public BT7(Slider sdr, BattleField bf, int x, int y, Direct direction) throws Exception {
        super(sdr, bf, x, y, direction);
        this.name = "Tank BT7";
        this.tank = new Color(80, 80, 80);
        this.tower = new Color(0, 0, 0);
        this.speed = 18;
        setImages();
    }

    protected void setImages(){

        images = new Image[4];
        try{
            images[0] = ImageIO.read(new File(IMAGE_UP));
            images[1] = ImageIO.read(new File(IMAGE_DOWN));
            images[2] = ImageIO.read(new File(IMAGE_RIGHT));
            images[3] = ImageIO.read(new File(IMAGE_LEFT));
        }catch(IOException e){
            for(Image i : images){
                System.err.println("Can't find image of BT7: " + i.toString());
            }
        }
    }
}


