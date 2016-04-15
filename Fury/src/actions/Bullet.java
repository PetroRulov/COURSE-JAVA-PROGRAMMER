package actions;

import enumerations.Direct;
import interfaces.IObjectable;
import tanks.AbstractTank;
import java.awt.*;

public class Bullet implements IObjectable {

    private int speedBullet = 6;
    private int x;
    private int y;
    private Direct direction;
    private AbstractTank tank;
    private Color bullColor = new Color(0, 0, 0);

    public Bullet(int x, int y, Direct direction, AbstractTank tank) {

        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tank = tank;
    }

    public int getSpeedBullet() {
        return speedBullet;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direct getDirection() {
        return direction;
    }

    public AbstractTank getTank() {
        return tank;
    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }

    @Override
    public void destroy(){

        x = -100;
        y = -100;
        direction = Direct.MINUS;
    }

    @Override
    public boolean isDeleted() {

        if(x == -100){
            return true;
        }
        return false;
    }

    @Override
    public void paintComponent(java.awt.Graphics g) {

        g.setColor(bullColor);

        if (tank.getDirection() == Direct.UP || tank.getDirection() == Direct.DOWN) {
            g.fillRect(x, y, 6, 18);
        } else {
            g.fillRect(x, y, 16, 6);
        }
    }

    @Override
    public void drawComponent(Graphics g) {

        g.setColor(new Color(255, 255, 0));

        if (tank.getDirection() == Direct.UP || tank.getDirection() == Direct.DOWN) {
            g.fillRect(x, y, 6, 18);
        } else {
            g.fillRect(x, y, 16, 6);
        }
    }
}



