package battleFields;

import java.awt.Color;

public class Brick extends AbstractComponent {

    public Brick(){}

    public Brick(int x, int y) throws Exception{

        super(x, y);
        this.name = "B";
        this.x = x;
        this.y = y;
        this.color = new Color(220, 50, 0);
    }
}
