package tanks;

import battleFields.BattleField;
import enumerations.Direct;
import actions.Slider;

/**
 * Created by prulov on 22.03.2016.
 */
public class T34 extends AbstractTank {

    public T34(Slider sdr, BattleField bf){
        super(sdr, bf, 448, 64, Direct.LEFT);
    }

    public T34(Slider sdr, BattleField bf, int x, int y, Direct direction) throws Exception {
        super(sdr, bf, x, y, direction);
        this.speed = 8;
    }

}



