package battleFields;

import interfaces.IDestructable;
import tanks.BT7;

import java.awt.Color;

public class HQ extends AbstractComponent implements IDestructable {

    public HQ(){}

    public HQ(int x, int y) throws Exception{

        super(x, y);
        this.name = "S";
        this.x = x;
        this.y = y;
        this.color = new Color(0, 200, 150);
    }
}
