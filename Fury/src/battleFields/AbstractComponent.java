package battleFields;

import domains.Bullet;
import actions.Slider;
import interfaces.IDestroyable;
import interfaces.IDrawable;

import java.awt.*;

public abstract class AbstractComponent implements IDrawable, IDestroyable {

    final int SQUAD = 64;
    protected String name;
    protected Slider sdr;
    protected Bullet bullet;
    protected int x;
    protected int y;
    protected Color color;
    protected int wayable;


    public AbstractComponent(){}

    public AbstractComponent(int x, int y)  {

        this.name = name;
        this.sdr = sdr;
        this.bullet = bullet;
        this.wayable = wayable;
        this.x = x;
        this.y = y;

        this.color = new Color(180, 180, 180);
    }

    public String getName(){return name;}

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWayable() {
        return wayable;
    }

    @Override
    public void paintComponent(Graphics g) {

        g.setColor(color);
        g.fillRect(x, y, SQUAD, SQUAD);
    }

    @Override
    public void drawComponent(Graphics g){

        g.setColor(color);
        g.fillRect(x - 5, y - 5, SQUAD + 10, SQUAD + 10);
    }

    @Override
    public void destroy() throws Exception {

        sdr.sparkling(bullet, getY() / 64, getX() / 64);
        System.out.println(this + " destroyed!!!");
        return;
    }

    @Override
    public boolean isDeleted() {
        return false;
    }

    public String toString(){

        return name + ", location = " + getX() + "_" + getY();
    }

}

