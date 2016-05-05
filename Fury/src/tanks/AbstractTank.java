package tanks;

import actions.AgrIntel;
import battleFields.*;
import domains.Coord;
import domains.Bullet;
import enumerations.Direct;
import interfaces.IObjectable;
import actions.Slider;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public abstract class AbstractTank implements IObjectable {

    protected long speed = 12;
    protected int x;
    protected int y;

    public Direct direction;

    protected Slider sdr;
    protected BattleField bf;

    protected Bullet bullet;

    protected Color tank = new Color(0, 100, 0);
    protected Color tower = new Color(10, 40, 0);

    protected Image[] images;
    protected String IMAGE_UP;
    protected String IMAGE_DOWN;
    protected String IMAGE_LEFT;
    protected String IMAGE_RIGHT;


    protected AbstractTank(Slider sdr, BattleField bf){}

    protected AbstractTank(Slider sdr, BattleField bf, int x, int y, Direct direction){

        this.sdr = sdr;
        this.bf = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.bullet = bullet;
    }

    protected abstract void setImages();

    public Slider getSDR() {
        return sdr;
    }

    public BattleField getBF() {
        return bf;
    }

    public long getSpeed() {
        return speed;
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

    public void updateX(int x) { this.x += x; }

    public void updateY(int y) {
        this.y += y;
    }


    public void turn(Direct direction) throws Exception {
        this.direction = direction;
        sdr.processTurn(this); // Slider 191
    }

    public void move() throws Exception {
        sdr.processMove(this); // Slider 227
    }

    public boolean processPurityCheck() throws Exception {

        if (getNextQuadrant() instanceof Plant){
            return true;
        } else if(getNextQuadrant() instanceof Brick || getNextQuadrant() instanceof HQ) {
            fire();
            if (getNextQuadrant() instanceof Plant)
            return true;
        }
        return false;
    }

    public AbstractComponent getNextQuadrant() throws Exception {

        String tankQuadrant = sdr.getQuadrantYX(x, y);
        AbstractComponent checkQuad = null;

        int aH = sdr.getQtX(tankQuadrant), bV = sdr.getQtY(tankQuadrant), cV = sdr.getQtY(tankQuadrant) - 1;
        int dH = sdr.getQtX(tankQuadrant) + 1, eH = sdr.getQtX(tankQuadrant) - 1, fV = sdr.getQtY(tankQuadrant) + 1;

        if(direction == Direct.UP){
            if(y >= bf.getSquad()){ // y >= 64
                checkQuad = bf.scanQuadrant(Math.abs(cV), Math.abs(aH));
            } else { // y = 0
                turn(Direct.DOWN);
                checkQuad = bf.scanQuadrant(Math.abs(fV), Math.abs(aH));
            }
        } else if(direction == Direct.DOWN){
            if(y < (bf.getBF_HEIGHT() - bf.getSquad())){ // y < 512
                checkQuad = bf.scanQuadrant(Math.abs(fV), Math.abs(aH));
            } else { // y = 512
                turn(Direct.UP);
                checkQuad = bf.scanQuadrant(Math.abs(cV), Math.abs(aH));
            }
        } else if(direction == Direct.LEFT) {
            if (x >= bf.getSquad()) { // x >= 64
                checkQuad = bf.scanQuadrant(Math.abs(bV), Math.abs(eH));
            } else { // x = 0
                turn(Direct.RIGHT);
                checkQuad = bf.scanQuadrant(Math.abs(bV), Math.abs(dH));
            }
        } else if(direction == Direct.RIGHT){
            if(x < (bf.getBF_HEIGHT() - bf.getSquad())){ // x < 512
                checkQuad = bf.scanQuadrant(Math.abs(bV), Math.abs(dH));
            } else { // x = 512
                turn(Direct.LEFT);
                checkQuad = bf.scanQuadrant(Math.abs(bV), Math.abs(eH));
            }
        }
        return checkQuad;
    }

    public boolean ifTankNearBFBorders() {

        if (x == (bf.getMNQ() - 1) * bf.getSquad() && direction == Direct.RIGHT ||
                x == 0 && direction == Direct.LEFT ||
                y == (bf.getMNQ() - 1) * bf.getSquad() && direction == Direct.DOWN ||
                y == 0 && direction == Direct.UP) {
            return true;
        }
        return false;
    }

    public void fire() throws Exception {

        Bullet bullet = new Bullet((x + 28), (y + 25), direction, this);
        sdr.processFire(bullet, this); // Slider 245
    }

    public void moveToCoord(Coord c) throws Exception {

        int xCoord = c.getXC() * 64, yCoord = c.getYC() * 64;

        while (x < xCoord) {
            turn(Direct.RIGHT);
            move(); // 79
        }

        while (x > xCoord) {
            turn(Direct.LEFT);
            move(); // 79

        }

        while (y < yCoord) {
            turn(Direct.DOWN);
            move(); // 79
        }

        while (y > yCoord) {
            turn(Direct.UP);
            move(); // 79
        }

    }

    public void moveRandom() throws Exception {
        Random r = new Random();
        Integer i;
        while (true) {
            i = r.nextInt(5);
            if (i > 0) {
                direction = Direct.getDirect(i);
                sdr.processTurn(this);
                sdr.processMove(this);
            }
        }
    }

    @Override
    public void destroy(){

        x = -512;
        y = -512;
        direction = Direct.STOP;
        System.out.println(this + " destroyed!!!");
        return;
    }

    @Override
    public boolean isDeleted(){

        if(x == -512 && y == -512){
            return true;
        }
        return false;
    }

    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(images[getDirection().getIndx()], getX(), getY(), new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }

    @Override
    public void drawComponent(Graphics g) {

        g.setColor(tank);
        g.fillRect(x, y, 64, 64);

        g.setColor(tower);
        if (direction == Direct.UP) {
            g.fillRect(x + 24, y - 8, 14, 42);
        } else if (direction == Direct.DOWN) {
            g.fillRect(x + 24, y + 24, 16, 42);
        } else if (direction == Direct.LEFT) {
            g.fillRect(x - 6, y + 24, 42, 16);
        } else {
            g.fillRect(x + 30, y + 24, 42, 16);
        }
    }

}

