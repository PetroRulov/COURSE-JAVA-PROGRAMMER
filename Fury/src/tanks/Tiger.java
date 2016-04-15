package tanks;

import battleFields.BattleField;
import enumerations.Direct;
import actions.Slider;


import java.awt.Color;

public class Tiger extends AbstractTank {

    private int armour;

    public Tiger(Slider sdr, BattleField bf){
        super(sdr, bf, 64, 256, Direct.LEFT);
        this.tank = new Color(40, 40, 40);
        this.tower = new Color(0, 0, 0);
        this.armour = 1;
        this.speed = 20;
    }

    public Tiger(Slider sdr, BattleField bf, int x, int y, Direct direction) throws Exception {
        super(sdr, bf, x, y, direction);
        this.tank = new Color(40, 40, 40);
        this.tower = new Color(0, 0, 0);
        this.armour = 1;
        this.speed = 20;

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