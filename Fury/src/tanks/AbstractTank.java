package tanks;

import battleFields.*;
import enumerations.Direct;
import interfaces.IObjectable;
import actions.Slider;
import actions.Bullet;

import java.awt.Color;
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

    protected AbstractTank(Slider sdr, BattleField bf){}

    protected AbstractTank(Slider sdr, BattleField bf, int x, int y, Direct direction){

        this.sdr = sdr;
        this.bf = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.bullet = bullet;
    }

    protected Color color;

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
        sdr.processTurn(this); // 164
    }

    public void move() throws Exception {
        sdr.processMove(this);
    }

    public boolean processPurityCheck() throws Exception {

        if (getNextQuadrant() instanceof Brick) {
            System.out.println("tank destroying the Brick!");
            fire();
            return true;
        } else if(getNextQuadrant() instanceof Plant) {
            return true;
        } else {
            return false;
        }
    }

//    public AbstractComponent getCheckQuad(){
//
//        String tankQuadrant = sdr.getQuadrantYX(x, y);
//        AbstractComponent checkQuad = null;
//
//        int aH = sdr.getQtX(tankQuadrant), bV = sdr.getQtY(tankQuadrant), cV = sdr.getQtY(tankQuadrant) - 1;
//        int dH = sdr.getQtX(tankQuadrant) + 1, eH = sdr.getQtX(tankQuadrant) - 1, fV = sdr.getQtY(tankQuadrant) + 1;
//
//        if (direction == Direct.UP && y != 0) {
//            checkQuad = bf.scanQuadrant(Math.abs(cV), Math.abs(aH));
//        }
//        if (direction == Direct.RIGHT && x < bf.getBF_WIDTH() - bf.getSquad()) {
//            checkQuad = bf.scanQuadrant(Math.abs(bV), Math.abs(dH));
//        }
//        if (direction == Direct.LEFT && x != 0) {
//            checkQuad = bf.scanQuadrant(Math.abs(bV), Math.abs(eH));
//        }
//        if (direction == Direct.DOWN && y < bf.getBF_HEIGHT() - bf.getSquad()) {
//            checkQuad = bf.scanQuadrant(Math.abs(fV), Math.abs(aH));
//        }
//        System.out.println(checkQuad.getName());
//        return checkQuad;
//    }

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

    public AbstractComponent getCheckQuadRight() throws Exception {

        String tankQuadrant = sdr.getQuadrantYX(x, y);
        AbstractComponent checkQuad = null;

        int bV = sdr.getQtY(tankQuadrant), dH = sdr.getQtX(tankQuadrant) + 1, eH = sdr.getQtX(tankQuadrant) - 1;

        if(direction == Direct.RIGHT){
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
        sdr.processFire(bullet, this);
        System.out.println(this + " fires");
    }

    public void moveToQuadrant(int v, int h) throws Exception {

        int undScore = sdr.getXYCoord(v, h).indexOf("_");
        int xCoord = Integer.parseInt(sdr.getXYCoord(v, h).substring(0, undScore));
        int yCoord = Integer.parseInt(sdr.getXYCoord(v, h).substring(undScore + 1));

        while (y < yCoord) {
            turn(Direct.DOWN);
            move();
        }
        while (x < xCoord) {
            turn(Direct.RIGHT);
            move();
        }
        while (x > xCoord) {
            turn(Direct.LEFT);
            move();

        }
        while (y > yCoord) {
            turn(Direct.UP);
            move();
        }
    }

//    protected void clean() throws Exception {
//
//        if (y < 320) {
//            moveToQuadrant(1, 1);
//
//            for (int i = 0; i < bf.getMNQ(); i++) {
//                for (int j = 0; j < bf.getMNQ(); j++) {
//                    if (bf.getBattleField()[i][j].equals("B")) {
//                        moveToQuadrant(i + 1, j + 1);
//                        addControlFireTop(i, j);
//                    }
//                }
//            }
//        } else {
//
//            moveToQuadrant(9, 9);
//
//            for (int i = bf.getMNQ() - 1; i > -1; i--) {
//                for (int j = bf.getMNQ() - 1; j > -1; j--) {
//                    if (bf.getBattleField()[i][j].equals("B")) {
//                        moveToQuadrant(i + 1, j + 1);
//                        addControlFireAlow(i, j);
//                    }
//                }
//            }
//        }
//    }
//
//    boolean ifArrayEmpty(String[] arr) {
//
//        for (String str : arr) {
//            if (str.equals("B")) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    void addControlFireTop(int i, int j) throws Exception {
//
//        if (ifArrayEmpty(bf.getBf()[i])) {
//            turn(Direct.DOWN);
//            move();
//            if (j + 1 < 9) {
//                turn(Direct.RIGHT);
//                fire();
//            }
//            if (j + 1 == 9) {
//                turn(Direct.LEFT);
//                fire();
//            }
//            if (j + 1 > 1) {
//                turn(Direct.LEFT);
//                fire();
//            }
//            if (j + 1 == 1) {
//                turn(Direct.RIGHT);
//                fire();
//            }
//        }
//    }
//
//    void addControlFireAlow(int i, int j) throws Exception {
//
//        if (ifArrayEmpty(bf.getBf()[i])) {
//            turn(Direct.UP);
//            move();
//
//            if (j > 0) {
//                turn(Direct.LEFT);
//                fire();
//            }
//            if (j == 0) {
//                turn(Direct.RIGHT);
//                fire();
//            }
//            if (j < 8) {
//                turn(Direct.RIGHT);
//                fire();
//            }
//            if (j == 8) {
//                turn(Direct.LEFT);
//                fire();
//            }
//        }
//    }
//
//    protected void moveRandom() throws Exception {
//        Random r = new Random();
//        Integer i;
//        while (true) {
//            i = r.nextInt(5);
//            if (i > 0) {
//                direction = Direct.getDirect(i);
//                sdr.processTurn(this);
//                sdr.processMove(this);
//            }
//        }
//    }
//
//    protected String setTankInitPos() {
//
//        for (int i = bf.getMNQ() - 1; i > 0; i--) {
//            for (int j = 0; j < bf.getMNQ(); j++) {
//                if (bf.getBattleField()[i][j].equals("") || bf.getBattleField()[i][j].equals(" ")) {
//                    x = j * bf.getSquad();
//                    y = i * bf.getSquad();
//                }
//            }
//        }
//        return x + "_" + y;
//    }

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
    public void paintComponent(java.awt.Graphics g) {

        g.setColor(tank);
        g.fillRect(x + 2, y - 3, 58, 58);

        g.setColor(tower);
        if (direction == Direct.UP) {
            g.fillRect(x + 24, y - 8, 14, 42);
        } else if (direction == Direct.DOWN) {
            g.fillRect(x + 24, y + 24, 16, 42);
        } else if (direction == Direct.LEFT) {
            g.fillRect(x - 6, y + 18, 42, 16);
        } else {
            g.fillRect(x + 30, y + 18, 42, 16);
        }
    }

    @Override
    public void drawComponent(java.awt.Graphics g) {

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

