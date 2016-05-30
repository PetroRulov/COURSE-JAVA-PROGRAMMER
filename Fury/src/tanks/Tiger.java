package tanks;

import battleFields.BattleField;
import enumerations.Direct;
import actions.Slider;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Tiger extends AbstractTank {

    private int armour;

    private String IMAGE_UP = "tiger_UP.png";
    private String IMAGE_DOWN = "tiger_DOWN.png";
    private String IMAGE_LEFT = "tiger_LEFT.png";
    private String IMAGE_RIGHT = "tiger_RIGHT.png";

    public Tiger(Slider sdr, BattleField bf){
        super(sdr, bf, 64, 256, Direct.LEFT);
        this.tank = new Color(40, 40, 40);
        this.tower = new Color(0, 0, 0);
        this.armour = 1;
        this.speed = 20;
    }

    public Tiger(Slider sdr, BattleField bf, int x, int y, Direct direction) throws Exception {
        super(sdr, bf, x, y, direction);
        this.name = "Tank TIGER";
        this.tank = new Color(40, 40, 40);
        this.tower = new Color(0, 0, 0);
        this.armour = 1;
        this.speed = 20;
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
                System.err.println("Can't find image : " + i.toString());
            }
        }
    }

    public void updateArmour(int destroyArmour) {

        if (armour != 0) {
            this.armour += destroyArmour;
        } else {
            this.armour = 0;
        }
    }

    @Override
    public void destroy(){

        if (armour == 1) {
            updateArmour(-1);
        } else {
            super.destroy();
        }
    }

}