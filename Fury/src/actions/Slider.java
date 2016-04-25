package actions;

import battleFields.*;
import interfaces.IWayable;
import interfaces.INonDestructable;
import tanks.*;
import tanks.AbstractTank;
import enumerations.Direct;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class Slider extends JPanel {

    private BattleField bF = new BattleField();
    private ArrayList<IWayable> freeWay;
    private String agrPos;
    private Bullet bullet;
    private T34 defender;
    private BT7 agressor;
    private Logic log;
    private AI ai;

    public Slider() throws Exception {

        bF = new BattleField();
        agrPos = defineAgressorPos();
        defender = new T34(this, bF, 64, 448, Direct.UP);
        agressor = new BT7(this, bF, Integer.parseInt(agrPos.split("_")[0]), Integer.parseInt(agrPos.split("_")[1]), Direct.RIGHT);
        bullet = new Bullet(600, 600, Direct.MINUS, agressor);
        log = new Logic(this, bF);
        ai = new AI(bF, freeWay, agressor);

        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(500, 50);
        frame.setMinimumSize(new Dimension(bF.getBF_WIDTH() + 16, bF.getBF_HEIGHT() + 40));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    public void runTheGame() throws Exception {

        String str = log.findFrontNotWater();
        System.out.println("SEEKED COORDINATS = " + str);
        if (str != null && !str.equals("256_512") ) {
            int xCoord = Integer.parseInt(str.split("_")[0]);
            int yCoord = Integer.parseInt(str.split("_")[1]);
            //agressor.moveToCoord(xCoord, yCoord);
            agressor.moveToObject(ai.scanObject(xCoord, yCoord));

            // turning to fire on HQ
            if(agressor.getX() > 256){
                agressor.turn(Direct.LEFT);
            }else if(agressor.getX() == 256){
                agressor.turn(Direct.DOWN);
            }else{
                agressor.turn(Direct.RIGHT);
            }
            while (!(bF.getBattleField()[8][4] instanceof Black)) {
                agressor.fire();
            }
        } else if(str.equals("256_512")){
            System.err.println("!!!ERROR: THE HQ IS UNDESTRUCTABLE ON THIS BATTLEFIELD!!!");
        }
    }

    public boolean processInterception() throws Exception {
        String quadrant = getQuadrantYX(bullet.getX(), bullet.getY());
        int v = Integer.valueOf(quadrant.substring(0, quadrant.indexOf("_")));
        int h = Integer.valueOf(quadrant.substring(quadrant.indexOf("_") + 1));
        if(bulletInBFBorders()){
            if (!(bF.scanQuadrant(v, h) instanceof Plant)) {
                if (bF.scanQuadrant(v, h) instanceof Brick) {
                    sparkling(bullet, v, h);
                } else if (bF.scanQuadrant(v, h) instanceof Rock && (bullet.getTank() instanceof T34)) {
                    sparklingRock(bullet, v, h);
                } else if (bF.scanQuadrant(v, h) instanceof Rock && (bullet.getTank() instanceof BT7)) {
                    sparklingRock(bullet, v, h);
                    //new Rock(h * 64, v * 64).destroy();
                } else if (bF.scanQuadrant(v, h) instanceof HQ && (bullet.getTank() instanceof BT7)) {
                    sparklingHQ(bullet, v, h);
                    System.err.println("!!!HEADQUARTERS DESTROYED!!!");
                    System.err.println("!!!GAME OVER!!!");
                }
                return true;
            }
            if (checkInterception(getQuadrantYX(agressor.getX(), agressor.getY()), quadrant) && !bullet.getTank().equals(agressor)) {
                agressor.destroy();
                sparkling(bullet, v, h);
//                Thread.sleep(3000);
//                agressor = new BT7(this, bF, Integer.parseInt(agrPos.split("_")[0]), Integer.parseInt(agrPos.split("_")[1]), Direct.DOWN);
//                repaint();
//                return true;
            }
            if (checkInterception(getQuadrantYX(defender.getX(), defender.getY()), quadrant) && !bullet.getTank().equals(defender)) {
                defender.destroy();
                sparkling(bullet, v, h);
                return true;
            }
        }
        return false;
    }

    private boolean checkInterception(String object, String quadrant) {
        int oy = Integer.valueOf(object.substring(0, object.indexOf("_")));
        int ox = Integer.valueOf(object.substring(object.indexOf("_") + 1));

        int qy = Integer.valueOf(quadrant.substring(0, quadrant.indexOf("_")));
        int qx = Integer.valueOf(quadrant.substring(quadrant.indexOf("_") + 1));

        if (oy >= 0 && oy < 9 && ox >= 0 && ox < 9) {
            if (oy == qy && ox == qx) {
                return true;
            }
        }
        return false;
    }


    public void sparkling(Bullet bullet, int v, int h) throws Exception {

        bF.updateQuadrant(v, h, new Explosive(h * bF.getSquad(), v * bF.getSquad()));
        repaint();
        Thread.sleep(50);
        bF.updateQuadrant(v, h, new Plant(h * bF.getSquad(), v * bF.getSquad()));
        repaint();
        Thread.sleep(50);
        bullet.destroy();
        repaint();
        Thread.sleep(50);
        bF.updateQuadrant(v, h, new Explosive(h * bF.getSquad(), v * bF.getSquad()));
        repaint();
        Thread.sleep(50);
        bF.updateQuadrant(v, h, new Plant(h * bF.getSquad(), v * bF.getSquad()));
        repaint();
        Thread.sleep(50);
    }

    public void sparklingRock(Bullet bullet, int v, int h) throws Exception {

        bF.updateQuadrant(v, h, new Explosive(h * bF.getSquad(), v * bF.getSquad()));
        repaint();
        Thread.sleep(50);
        bF.updateQuadrant(v, h, new Rock(h * bF.getSquad(), v * bF.getSquad()));
        repaint();
        Thread.sleep(50);
        bullet.destroy();
        bF.updateQuadrant(v, h, new Explosive(h * bF.getSquad(), v * bF.getSquad()));
        repaint();
        Thread.sleep(50);
        bF.updateQuadrant(v, h, new Rock(h * bF.getSquad(), v * bF.getSquad()));
        repaint();
        Thread.sleep(50);
    }

    public void sparklingHQ(Bullet bullet, int v, int h) throws Exception {

        bF.updateQuadrant(v, h, new Explosive(h * bF.getSquad(), v * bF.getSquad()));
        repaint();
        Thread.sleep(50);
        bF.updateQuadrant(v, h, new HQ(h * bF.getSquad(), v * bF.getSquad()));
        repaint();
        Thread.sleep(50);
        bullet.destroy();
        bF.updateQuadrant(v, h, new Explosive(h * bF.getSquad(), v * bF.getSquad()));
        repaint();
        Thread.sleep(50);
        bF.updateQuadrant(v, h, new Black(h * bF.getSquad(), v * bF.getSquad()));
        repaint();
        Thread.sleep(50);
    }

    private boolean bulletInBFBorders() {

        if (bullet.getX() > 0 && bullet.getY() > 0 && bullet.getX() < bF.getBF_WIDTH() && bullet.getY() < bF.getBF_HEIGHT()) {
            return true;
        }
        return false;
    }

    public int getQtX(String str) {
        return Integer.parseInt(str.split("_")[1]);
    }

    public int getQtY(String str) {
        return Integer.parseInt(str.split("_")[0]);
    }

    public String getQuadrantYX(int x, int y) {
        return y / bF.getSquad() + "_" + x / bF.getSquad();
    }

    public String getXYCoord(int y, int x) {

        return (x - 1) * bF.getSquad() + "_" + (y - 1) * bF.getSquad();
    }

    public void processTurn(AbstractTank tank) throws Exception {

        Thread.sleep(tank.getSpeed());
        repaint();
    }

    public void processMove(AbstractTank tank) throws Exception {

        if(!(bF.scanQuadrant(8, 4) instanceof Black)){
            processTurn(tank);
            if (ifTankNearBFBorders(tank)) {
                tank.direction = Direct.STOP;
            }
            System.out.println("Moving permitted? " + tank.processPurityCheck() + " - " + tank.getNextQuadrant().toString());
            if(tank.processPurityCheck()){ // AT-83
                moving(tank);
            } else {

                //should to be improoved
                for (int i = 0; i < ai.nextObjApply().size(); i++){
                    tank.moveToObject(ai.nextObjApply().get(i));

                }


            }
        }
    }

    private boolean ifTankNearBFBorders(AbstractTank tank) {

        if (tank.getX() == (bF.getMNQ() - 1) * bF.getSquad() && tank.getDirection() == Direct.RIGHT ||
                tank.getX() == 0 && tank.getDirection() == Direct.LEFT ||
                tank.getY() == (bF.getMNQ() - 1) * bF.getSquad() && tank.getDirection() == Direct.DOWN ||
                tank.getY() == 0 && tank.getDirection() == Direct.UP) {
            return true;
        }
        return false;
    }

    public void moving(AbstractTank tank) throws Exception {
        int pace = 1;
        processTurn(tank);
        int i = 0;
        while (i < bF.getSquad()) {
            i += pace;
            if (tank.direction == Direct.RIGHT) {
                tank.updateX(+pace);
            } else if (tank.direction == Direct.LEFT) {
                tank.updateX(-pace);
            } else if (tank.direction == Direct.UP) {
                tank.updateY(-pace);
            } else if (tank.direction == Direct.DOWN) {
                tank.updateY(+pace);
            }
            Thread.sleep(tank.getSpeed());
            repaint();
            //Thread.sleep(tank.getSpeed());
        }
    }

    public void processFire(Bullet bullet, AbstractTank abstractTank) throws Exception {

        this.bullet = bullet;
        int pace = 1;

        while (bulletWithinBF(bullet)) {

            if (abstractTank.getDirection() == Direct.RIGHT) {
                bullet.updateX(+pace);
            }
            if (abstractTank.getDirection() == Direct.LEFT) {
                bullet.updateX(-pace);
            }
            if (abstractTank.getDirection() == Direct.UP) {
                bullet.updateY(-pace);
            }
            if (abstractTank.getDirection() == Direct.DOWN) {
                bullet.updateY(+pace);
            }
//            if (abstractTank.getDirection() == Direct.STOP) {
//                bullet.updateX(+pace);
//            }

            processInterception();
            repaint();
            Thread.sleep(bullet.getSpeedBullet());
        }
    }

    private boolean bulletWithinBF(Bullet bullet) {
        this.bullet = bullet;
        if (bullet.getX() >= -15 && bullet.getY() >= -15 &&
                bullet.getX() < bF.getBF_WIDTH() + 15 && bullet.getY() < bF.getBF_HEIGHT() + 15) {
            return true;
        }
        return false;
    }

    public String defineAgressorPos() {

        String str = "128_64";
        int i = toRandomI();
        if (i == 0) {
            str = "64_0";
        } else {
            str = i == 1 ? "448_0" : "320_64";
        }
        return str;
    }

    private int toRandomI() {

        Random r = new Random();
        int i = r.nextInt(3);
        return i;
    }

    //-!!!- M A G I C   B E L O W -!!!//
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int j = 0; j < bF.getDimentionY(); j++)
            for (int k = 0; k < bF.getDimentionX(); k++) {
                if (bF.scanQuadrant(j, k) instanceof Explosive) {
                    bF.scanQuadrant(j, k).drawComponent(g);
                } else {
                    bF.scanQuadrant(j, k).paintComponent(g);
                }
            }

        defender.paintComponent(g);
        agressor.drawComponent(g);

        if (bullet.getTank().equals(defender)) {
            bullet.paintComponent(g);;
        } else {
            bullet.drawComponent(g);
        }
    }

//    public Logic getLog() {
//        return log;
//    }

    public BT7 getAgressor() {
        return agressor;
    }

    public BattleField getbF() {
        return bF;
    }

    public Bullet getBullet() {
        return bullet;
    }
}



