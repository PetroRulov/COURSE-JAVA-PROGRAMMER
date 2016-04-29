package actions;

import battleFields.*;
import domains.Coord;
import enumerations.Direct;
import tanks.AbstractTank;

public class AgrLogic {

    private AbstractTank tank;
    private BattleField bf;
    private Slider sdr;

    public AgrLogic(Slider sdr, BattleField bf, AbstractTank tank) throws Exception {

        this.tank = tank;
        this.bf = bf;
        this.sdr = sdr;
    }

    public void agressorsStartAttack() throws Exception {

        String str = findFrontNotWater();
        System.out.println("Slider: FIRING COORDINATES = " + str);
        if (str != null && !str.equals("256_512") ) {
            int xCoord = Integer.parseInt(str.split("_")[0]);
            int yCoord = Integer.parseInt(str.split("_")[1]);
            Coord start = new Coord(tank.getX() / 64, tank.getY() / 64);
            Coord end = new Coord(xCoord / 64, yCoord / 64);
            Coord[] path = sdr.getAgrInt().lookingForThePath(start, end);
            for(Coord c: path){
                tank.moveToCoord(c);
            }
            turningToHQ();
        } else if(str.equals("256_512")){
            System.err.println("!!!ERROR: THE HQ IS UNDESTRUCTABLE ON THIS BATTLEFIELD!!!");
        }
    }

    private void turningToHQ() throws Exception {

        if(tank.getX() > 256){
            tank.turn(Direct.LEFT);
        }else if(tank.getX() == 256){
            tank.turn(Direct.DOWN);
        }else{
            tank.turn(Direct.RIGHT);
        }
        while (!(bf.getBattleField()[8][4] instanceof Black)) {
            tank.fire();
        }
    }

    private AbstractComponent[] frontLine(){

        AbstractComponent[] frontL = new AbstractComponent[bf.getMNQ() - 1];
        for(int i = bf.getMNQ() - 2, j = 0; i >= 0; i--, j++){
            frontL[j] = bf.getBattleField()[i][4];
            System.out.println(frontL[j].toString() + ", ");
        }
        return frontL;
    }

    private boolean lineHasRock(AbstractComponent[] line){

        for(AbstractComponent i : line){
            if(i instanceof Rock){
                return true;
            }
        }
        return false;
    }

    private String findFrontPlaceOfFire(AbstractComponent[] line){ // on line x = 256

        String str = null;
        System.out.println("fFPofFire: Checking FrontLine");
        AbstractComponent checked = getACbyCoords(256, 0);;
        if(lineHasRock(line)){
            for(AbstractComponent i : line) {
                if (i instanceof Rock) {
                    checked = i;
                    System.out.println("front-checked = " + checked.toString());
                    break;
                }
            }
            if(checked.getY() != 448){
                str = 256 + "_" + (checked.getY() + bf.getSquad());
            } else { // if HQ is closed by a Rock from front side
                if(tank.getX() < 320){
                    System.out.println("fFPofFire: FrontLine is closed by Rock, try LeftLine");
                    str = findLeftNotWater();
                } else {
                    System.out.println("fFPofFire: FrontLine is closed by Rock, try RightLine");
                    str = findRightNotWater();
                }
            }
            return str;
        } else { // if there is no Rocks at all
            System.out.println("RightLine Water line:");
            for(AbstractComponent i : line){
                System.out.println(i.toString());
                if(i instanceof Water){
                    if(i.getY() != 0){
                        str = i.getX() + "_" + (i.getY() - bf.getSquad());
                        break;
                    } else {
                        str = i.getX() + "_" + (i.getY() + bf.getSquad());
                        break;
                    }
                } else { // if there is no Water and Rock
                    str = "256_0";
                    break;
                }
            }
            return str;
        }
    }

    public String findFrontNotWater(){

        String str = findFrontPlaceOfFire(frontLine());
        if(str != null){
            int xCoord = Integer.parseInt(str.split("_")[0]);
            int yCoord = Integer.parseInt(str.split("_")[1]);
            while(bf.getBattleField()[yCoord / bf.getSquad()][xCoord / bf.getSquad()] instanceof Water){
                yCoord += bf.getSquad();
                if(yCoord == 512){
                    System.out.println("findFrontNotWater: FrontLine is Closed by Water: try LeftLine");
                    return findLeftNotWater();
                }
            }
            return xCoord + "_" + yCoord;
        } else {
            if(tank.getX() < 320) {
                System.out.println("LEFT Way chosen");
                return findLeftNotWater();
            } else {
                System.out.println("RIGHT Way chosen");
                return findRightNotWater();
            }
        }
    }

    private AbstractComponent[] leftLine(){

        AbstractComponent[]lL = new AbstractComponent[4];
        System.out.println("LEFTLine:");
        for(int i = (bf.getMNQ() / 2 - 1), j = 0; i >= 0 ; i--, j++){
            lL[j]=bf.getBattleField()[8][i];
            System.out.println(lL[j].toString() + ", ");
        }
        return lL;
    }

    private String findLeftPlaceOfFire(AbstractComponent[] line){

        String str = null;
        System.out.println("findLeftPlaceOfFire: Checking LeftLine");
        AbstractComponent checked = getACbyCoords(192, 512);
        if(lineHasRock(line)){
            for(AbstractComponent i : line) {
                if (i instanceof Rock) {
                    checked = i;
                    System.out.println("left-checked = " + checked.toString());
                    break;
                }
            }
            if(checked.getX() != 192 && !(isRockOrWater(checked.getX(), 448)) ){
                str = (checked.getX() + bf.getSquad() ) + "_" + 512;
            } else {
                System.out.println("findLeftPlaceOfFire: LeftLine is closed: try RIGHT LINE!");
                str = findRightNotWater();
            }
            return str;
        } else {
            for(AbstractComponent i : line) {
                if (i instanceof Water) {
                    checked = i;
                    System.out.println("right-checked = " + checked);
                    break;
                }
            }
            if (checked.getX() == 0) {
                System.out.println("MOVE BEFORE the Water");
                str = (checked.getX() + bf.getSquad()) + "_" + 512;;
            } else if(checked.getX() != 0) {
                System.out.println("MOVE BEHIND the Water");
                str = (checked.getX() - bf.getSquad()) + "_" + 512;;
            } else {
                System.out.println("FLPofF: no Water, LeftLine is opened - MOVE AND FIRE");
                str = "192_512";
            }
            return str;
        }
    }

    private String findLeftNotWater(){

        String str = findLeftPlaceOfFire(leftLine());
        if(str != null){
            int xCoord = Integer.parseInt(str.split("_")[0]);
            while (bf.getBattleField()[8][xCoord / 64] instanceof Water) {
                if(xCoord == 192){
                    System.out.println("findLeftNotWater: LeftLine is Closed by Water: try RightLine");
                    return findRightNotWater();
                }else{
                    xCoord -= 64;
                }
            }
            return xCoord + "_" + 512;
        } else {
            return "findLeftNotWater !!!STOP!!!";
        }
    }

    public AbstractComponent[] rightLine(){

        AbstractComponent[] rL = new AbstractComponent[4];
        System.out.println("RIGHTLine:");
        for(int i = 5, j = 0; i < bf.getMNQ(); i++, j++){
            rL[j] = bf.getBattleField()[8][i];
            System.out.println(rL[j].toString() + ", ");
        }
        return rL;
    }

    private String findRightNotWater(){

        String str = findRightPlaceOfFire(rightLine());
        if(str != null){
            int xCoord = Integer.parseInt(str.split("_")[0]);
            if(xCoord == 512){
                return xCoord + "_" + 512;
            }else {
                while (bf.getBattleField()[8][xCoord / 64] instanceof Water) {
                    if(xCoord == 320){
                        return findLeftNotWater();
                    }else{
                        xCoord += 64;
                    }
                }
            }
            return xCoord + "_" + 512;
        } else {
            return "findLeftNotWater !!!STOP!!!";
        }
    }

    private String findRightPlaceOfFire(AbstractComponent[] line) {

        String str = null;
        System.out.println("findRightPlaceOfFire: Checking RIGHTLine");
        AbstractComponent checked = getACbyCoords(320, 512);
        if (lineHasRock(line)) {
            System.out.println("RightLine:");
            for (AbstractComponent i : line) {
                System.out.println(i.toString());
                if (i instanceof Rock) {
                    checked = i;
                    System.out.println("right-checked = " + checked);
                    break;
                }
            }
            if (checked.getX() != 320 && !(isRockOrWater(checked.getX(), 448))) {
                str = (checked.getX() - bf.getSquad()) + "_" + 512;
            } else {
                System.out.println("TRY LEFTLINE AGAIN");
                str = findLeftNotWater();
            }
            return str;
        } else { // if there is no Rock in right line
            for(AbstractComponent i : line) {
                if (i instanceof Water) {
                    checked = i;
                    System.out.println("right-checked = " + checked);
                    break;
                }
            }
            if (checked.getX() != 512) {
                System.out.println("MOVE BEHIND the Water");
                str = (checked.getX() + bf.getSquad()) + "_" + 512;
            } else if(checked.getX() == 512) {
                System.out.println("MOVE BEFORE the Water");
                str = (checked.getX() - bf.getSquad()) + "_" + 512;
            } else {
                    System.out.println("FRPofF: no Water, RightLine is opened - MOVE AND FIRE");
                    str = "320_512";
            }
            return str;
        }
    }

    private boolean isRockOrWater(int x, int y){

        if(bf.getBattleField()[y / bf.getSquad()][x / bf.getSquad()] instanceof Rock ||
        bf.getBattleField()[y / bf.getSquad()][x / bf.getSquad()] instanceof Water){
           return true;
        }
        return false;
    }

    public AbstractComponent getACbyCoords(int x, int y){

        AbstractComponent ac = null;
        for(AbstractComponent[] lines : bf.getBattleField()){
            for(AbstractComponent i : lines){
                if(i.getX() == x && i.getY() == y){
                    ac = i;
                }
            }
        }
        return ac;
    }
}

