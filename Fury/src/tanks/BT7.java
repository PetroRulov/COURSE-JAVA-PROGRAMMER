package tanks;

import battleFields.BattleField;
import enumerations.Direct;
import actions.Slider;

import java.awt.*;


/**
 * Created by prulov on 22.03.2016.
 */
public class BT7 extends AbstractTank {

    public BT7(Slider sdr, BattleField bf){
        super(sdr, bf, 128, 128, Direct.LEFT);
    }

    public BT7(Slider sdr, BattleField bf, int x, int y, Direct direction) throws Exception {
        super(sdr, bf, x, y, direction);
        this.tank = new Color(80, 80, 80);
        this.tower = new Color(0, 0, 0);
        this.speed = 18;
    }

}


