package battleFields;

import javax.security.auth.Destroyable;
import java.awt.Color;

public class Rock extends AbstractComponent {

    private int strength;

    public Rock(){}

    public Rock(int x, int y) throws Exception{

        super(x, y);
        this.name = "R";
        this.x = x;
        this.y = y;
        this.color = new Color(255, 255, 255);
        strength = 1;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void updateStrength(int decreaseStrength) {

        if (strength != 0) {
            this.strength += decreaseStrength;
        } else {
            this.strength = 0;
        }
    }

    @Override
    public void destroy() throws Exception {

        if (strength == 1) {
            updateStrength(-1);
        } else {
            super.destroy();
        }
    }

    @Override
    public boolean isDeleted() {
        return false;
    }
}
