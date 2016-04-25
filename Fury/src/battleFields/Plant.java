package battleFields;

import interfaces.IWayable;
import java.awt.Color;

public class Plant extends AbstractComponent implements IWayable {

    public Plant(){}

    public Plant(int x, int y) throws Exception{

        super(x, y);
        this.wayable = 1;
        this.name = "P";
        this.x = x;
        this.y = y;
        this.color = new Color(180, 180, 180);

    }

    @Override
    public int getXC() {
        return x;
    }

    @Override
    public int getYC() {
        return y;
    }
}