package battleFields;

import interfaces.INonDestructable;

import java.awt.Color;

public class Water extends AbstractComponent implements INonDestructable{

    public Water(){}

    public Water(int x, int y) throws Exception{

        super(x, y);
        this.wayable = 1000;
        this.name = "W";
        this.x = x;
        this.y = y;
        this.color = new Color(0, 0, 250);
    }
}
