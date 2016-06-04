package actions;

import battleFields.*;
import domains.Bullet;
import enumerations.Direct;
import tanks.AbstractTank;
import tanks.BT7;
import tanks.T34;
import tanks.Tiger;
import ugis.FuryGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Slider extends JPanel {

    private BattleField bF;
    private int[][] lab; // how the tanks see the BattleField;
    private String agrPos;
    private Bullet bullet;
    private T34 defender;
    private BT7 agressor;
    private Tiger ogr;
    private AgrLogic agrLog;
    private AgrIntel agrInt;
    private AgrIntel tigrInt;
    private  TigerLogic tiLog;
    private JFrame frame;

    public Slider() throws Exception {

        bF = new BattleField();
        lab = setLab(bF.getBf());

        defender = new T34(this, bF, 64, 448, Direct.UP);

        agrPos = defineAgressorPos();
        agressor = new BT7(this, bF, Integer.parseInt(agrPos.split("_")[0]), Integer.parseInt(agrPos.split("_")[1]), Direct.RIGHT);

        agrPos = defineAgressorPos();
        ogr = new Tiger(this, bF, Integer.parseInt(agrPos.split("_")[0]), Integer.parseInt(agrPos.split("_")[1]), Direct.DOWN);

        bullet = new Bullet(600, 600, Direct.MINUS, ogr);

        agrInt = new AgrIntel(bF, lab, agressor);
        tigrInt = new AgrIntel(bF, lab, ogr);
        agrLog = new AgrLogic(this, bF, agressor);
        tiLog = new TigerLogic(this, bF, ogr);

        //JFrame frame = new JFrame("FURY BATTLEFIELD");
        frame = new JFrame("FURY BATTLEFIELD");
        frame.setLocation(0, 0);
        frame.setMinimumSize(new Dimension(bF.getBF_WIDTH() + 16, bF.getBF_HEIGHT() + 40));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        //runTheGame();

    }

    public AgrIntel getAgrInt() {
        return agrInt;
    }

    public AgrIntel getTigrInt(){return tigrInt;}

    public Slider runTheGame() throws Exception {

        // /**TIGERS WAY*/
        System.out.println("How Tiger sees the battlefield:");
        for (int[] lines : tigrInt.getLab()) {
            System.out.print("\n");
            for (int i : lines) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
        System.out.println();


        try{
            tiLog.tigerStartAttack();
        }catch(NullPointerException e){
            System.err.printf("!!!NullPointerException had been catched!!!" + "\n" +
            "!!!ERROR: THE HQ IS UNDESTRUCTABLE ON THIS BATTLEFIELD!!!" + "\n" +
            "!!!THERE IS NO SUITABLE PATH TO HQ!!!" + "\n" + " G A M E   O V E R!");
        }
        System.out.println();

        // /**AGRESSORS WAY*/
         /*displaying how agressor sees the BattleField*/
        System.out.println("How Agressor sees the battlefield:");
        System.out.println();
        for (int[] lines : agrInt.getLab()) {
            System.out.print("\n");
            for (int i : lines) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
        System.out.println();

        try{
            agrLog.agressorsStartAttack();
        }catch(NullPointerException e){
            System.err.printf("!!!NullPointerException had been catched!!!" + "\n" +
            "!!!ERROR: THE HQ IS UNDESTRUCTABLE ON THIS BATTLEFIELD!!!" + "\n" +
            "!!!THERE IS NO SUITABLE PATH TO HQ!!!" + "\n" + " GAME OVER!");
        }
        return this;
    }

    public int switcherLab(String let){

        switch(let) {
            case "B":
                return 6;
            case "E":
                return 0;
            case "S":
                return 0;
            case "R":
                return 0;
            case "W":
                return 0;
            default:
                return 1;
        }
    }

    public int[][] setLab(String[][] map) throws Exception {

        int[][] lab = new int[bF.getMNQ()][bF.getMNQ()];

        for (int i = 0; i < bF.getMNQ(); i++){
            for (int j = 0; j < bF.getMNQ(); j++){
                lab[i][j] = switcherLab(map[i][j]);
            }
        }
        return lab;
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
                } else if (bF.scanQuadrant(v, h) instanceof HQ && (bullet.getTank() instanceof BT7) ||
                        bF.scanQuadrant(v, h) instanceof HQ && (bullet.getTank() instanceof Tiger)) {
                    sparklingHQ(bullet, v, h);
                    System.err.println("!!!HEADQUARTERS DESTROYED!!!");
                    System.out.println("!!!G A M E   O V E R!!!");
                    //frame.getContentPane().removeAll();
                    frame.dispose();
                    new FuryGUI();

                }
                return true;
            }
//            if (checkInterception(getQuadrantYX(agressor.getX(), agressor.getY()), quadrant) && !bullet.getTank().equals(agressor)) {
//                agressor.destroy();
//                sparkling(bullet, v, h);
//                Thread.sleep(3000);
//                agressor = new BT7(this, bF, Integer.parseInt(agrPos.split("_")[0]), Integer.parseInt(agrPos.split("_")[1]), Direct.DOWN);
//                repaint();
//                return true;
//            }
            if (checkInterception(getQuadrantYX(ogr.getX(), ogr.getY()), quadrant) && !bullet.getTank().equals(ogr)) {
                ogr.destroy();
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
        bF.updateString(v, h, "P");
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

    public boolean sparklingHQ(Bullet bullet, int v, int h) throws Exception {

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
        return true;
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
            if(tank.processPurityCheck()){ // AT-83
                moving(tank);
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

        String str = "64_0";
        int i = toRandomI();
        if(i == 0){
            str = "64_0";
        }else if(i == 1){
            str = "128_64";
        }else{
            str = i == 2 ? "448_0" : "320_64";
        }
        return str;
    }

    private int toRandomI() {

        Random r = new Random();
        int i = r.nextInt(4);
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

        defender.drawComponent(g);
        agressor.paintComponent(g);
        ogr.paintComponent(g);
        bullet.drawComponent(g);

    }

    public BT7 getAgressor() {
        return agressor;
    }

    public Tiger getOgr(){
        return ogr;
    }

    public T34 getDefender() {
        return defender;
    }

    public BattleField getbF() {
        return bF;
    }

    public Bullet getBullet() {
        return bullet;
    }

}



