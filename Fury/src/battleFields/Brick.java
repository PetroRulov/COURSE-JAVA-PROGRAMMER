package battleFields;

import interfaces.IDestructable;

import java.awt.Color;

public class Brick extends AbstractComponent implements IDestructable{

    public Brick(){}

    public Brick(int x, int y) throws Exception{

        super(x, y);
        this.wayable = 2;
        this.name = "B";
        this.x = x;
        this.y = y;
        this.color = new Color(220, 50, 0);
    }
}
