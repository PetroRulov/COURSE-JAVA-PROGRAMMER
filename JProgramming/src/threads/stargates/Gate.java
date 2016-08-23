package threads.stargates;

import java.awt.*;
import java.util.Random;

public class Gate{
    private int x;
    private int y;
    private Color color;
    private int speed;
    private boolean isOpen;

    public Gate() {
        speed = initSpeed();
        x=300;
        y = 50 ;
        color = initColor();
        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private Color initColor(){
        Random r = new Random();
        int i =r.nextInt(255);
        int b = r.nextInt(255);
        int a = r.nextInt(255);
        return new Color(i, b, a);
    }

    private int initSpeed(){
        int speed;
        Random r = new Random();
        speed = r.nextInt(40);
        return speed;
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(x, y, 20 , 100);
    }

    public void open(){
        y++;
        if (y==400){
            isOpen = true;
        }
    }
}