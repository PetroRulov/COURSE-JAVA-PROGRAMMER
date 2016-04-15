package battleFields;

import tanks.BT7;

import java.awt.Color;

public class Black extends AbstractComponent {

    public Black(){}

    public Black(int x, int y) throws Exception{

        super(x, y);
        this.name = "C";
        this.x = x;
        this.y = y;
        this.color = new Color(0, 0, 0);
    }
}
