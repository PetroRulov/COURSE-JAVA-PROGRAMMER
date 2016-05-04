package shapes;

import java.awt.*;

public abstract class AbstractShape implements IDrawable{

    protected Color color;

    public Color getColor() {
        return color;
    }

    @Override
    public void draw(Graphics g){
        throw new IllegalStateException("This method should be overrided.");
    }

}
