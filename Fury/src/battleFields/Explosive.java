package battleFields;

import java.awt.Color;

public class Explosive extends AbstractComponent{

    public Explosive(){}

    public Explosive(int x, int y) throws Exception{

        super(x, y);
        this.name = "E";
        this.x = x;
        this.y = y;
        this.color = new Color(255, 255, 0);
    }
}
