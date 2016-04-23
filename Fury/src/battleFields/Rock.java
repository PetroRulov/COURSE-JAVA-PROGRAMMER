package battleFields;

import interfaces.INonDestructable;

import javax.security.auth.Destroyable;
import java.awt.Color;

public class Rock extends AbstractComponent implements INonDestructable {

    private int strength;

    public Rock(){}

    public Rock(int x, int y) throws Exception{

        super(x, y);
        this.wayable = 100;
        this.name = "R";
        this.x = x;
        this.y = y;
        this.color = new Color(255, 255, 255);
        strength = 1;
    }
}
