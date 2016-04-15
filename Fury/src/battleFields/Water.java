package battleFields;

import java.awt.Color;

public class Water extends AbstractComponent {

    public Water(){}

    public Water(int x, int y) throws Exception{

        super(x, y);
        this.name = "W";
        this.x = x;
        this.y = y;
        this.color = new Color(0, 0, 250);
    }
}
