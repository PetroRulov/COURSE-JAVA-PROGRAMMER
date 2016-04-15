package battleFields;

import java.awt.Color;

public class Plant extends AbstractComponent {

    public Plant(){}

    public Plant(int x, int y) throws Exception{

        super(x, y);
        this.name = "P";
        this.x = x;
        this.y = y;
        this.color = new Color(180, 180, 180);

    }
}