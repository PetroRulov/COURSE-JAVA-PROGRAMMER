package threads.stargates;

import java.awt.*;
import java.util.Random;

public class SomeThing{

    private int x;
    private int y;
    private Color color;
    private int speed;

    public SomeThing() {
        speed = initSpeed();
        x=10;
        y = 100 ;
        color = initColor();

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
        g.fillOval(x, y, 20 , 20);

    }

    public void fly(){
        x++;
    }
}
