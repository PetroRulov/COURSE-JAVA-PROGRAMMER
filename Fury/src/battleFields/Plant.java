package battleFields;

import interfaces.IDestructable;

import java.awt.Color;

public class Plant extends AbstractComponent implements IDestructable {

    public Plant(){}

    public Plant(int x, int y) throws Exception{

        super(x, y);
        this.wayable = 1;
        this.name = "P";
        this.x = x;
        this.y = y;
        this.color = new Color(180, 180, 180);

    }
}