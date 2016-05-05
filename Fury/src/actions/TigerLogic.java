package actions;

import battleFields.*;
import domains.Coord;
import enumerations.Direct;
import tanks.AbstractTank;

import java.util.ArrayList;

/**
 * Created by prulov on 04.05.2016.
 */
public class TigerLogic {

    private AbstractTank tank;
    private BattleField bf;
    private Slider sdr;

    public TigerLogic(Slider sdr, BattleField bf, AbstractTank tank) throws Exception {

        this.tank = tank;
        this.bf = bf;
        this.sdr = sdr;
    }

    public void tigerStartAttack() throws Exception {

        String str = findFrontNotWater();
        System.out.println("Slider: FIRING COORDINATES = " + str);
        if (str != null && !str.equals(findDefendersCoords())) {
            int xCoord = Integer.parseInt(str.split("_")[0]);
            int yCoord = Integer.parseInt(str.split("_")[1]);
            Coord start = new Coord(tank.getX() / 64, tank.getY() / 64);
            Coord end = new Coord(xCoord / 64, yCoord / 64);
            Coord[] path = sdr.getTigrInt().lookingForThePath(start, end);
            for(Coord c: path){
                tank.moveToCoord(c);
            }
            turningToDefender();
        } else if(str.equals(findDefendersCoords())){
            System.err.println("!!!ERROR: THE DEFENDER IS UNDESTRUCTABLE ON THIS BATTLEFIELD!!!");
        }
    }

    private void turningToDefender() throws Exception {

        if(tank.getX() > Integer.parseInt(findDefendersCoords().split("_")[0]) * 64){
            tank.turn(Direct.LEFT);
        }else if(tank.getX() == Integer.parseInt(findDefendersCoords().split("_")[0]) * 64){
            tank.turn(Direct.DOWN);
        }else{
            tank.turn(Direct.RIGHT);
        }
        while (!(sdr.getDefender().isDeleted())) {
            tank.fire();
        }
    }

    public String findDefendersCoords(){

        //System.out.println(sdr.getDefender().getX() / 64 + "_" + sdr.getDefender().getY() / 64);
        return sdr.getDefender().getX() / 64 + "_" + sdr.getDefender().getY() / 64;
    }

    public ArrayList<AbstractComponent> frontLine(){

        int line = Integer.parseInt(findDefendersCoords().split("_")[0]);
        int deepth = Integer.parseInt(findDefendersCoords().split("_")[1]);
        ArrayList<AbstractComponent> frontL = new ArrayList<AbstractComponent>();
        for(int i = deepth - 1; i >= 0 ; i--){
            frontL.add(bf.getBattleField()[i][line]);
        }
        return frontL;
    }

    public boolean lineHasRock(ArrayList<AbstractComponent> line){

        for(AbstractComponent i : line){
            if(i instanceof Rock){
                return true;
            }
        }
        return false;
    }

    public String findFrontPlaceOfFire(ArrayList<AbstractComponent> line){ // on line x = 256

        String str = null;
        int dX = Integer.parseInt(findDefendersCoords().split("_")[0]);
        int dY = Integer.parseInt(findDefendersCoords().split("_")[1]);
        System.out.println("fFPofFire: Checking FrontLine");
        AbstractComponent checked = getACbyCoords(dX * bf.getSquad(), 0);;
        if(lineHasRock(line)){
            for(AbstractComponent i : line) {
                if (i instanceof Rock) {
                    checked = i;
                    System.out.println("front-checked = " + checked.toString());
                    break;
                }
            }
            if(checked.getY() != (dY - 1) * bf.getSquad()){
                str = dX * bf.getSquad() + "_" + (checked.getY() + bf.getSquad());
            }else{ // if Defender is closed by a Rock from front side
                if(tank.getX() < 320){
                    System.out.println("fFPofFire: FrontLine is closed by Rock, try LeftLine");
                    str = findLeftNotWater();
                }
//                else {
//                    System.out.println("fFPofFire: FrontLine is closed by Rock, try RightLine");
//                    str = findRightNotWater();
//                }
            }
            return str;
        } else { // if there is no Rocks at all
            System.out.println("FrontLine Water line:");
            for(AbstractComponent i : line){
                System.out.println(i.toString());
                if(i instanceof Water){
                    if(i.getY() != 0){
                        str = i.getX() + "_" + (i.getY() - bf.getSquad());
                        //break;
                    } else {
                        str = i.getX() + "_" + (i.getY() + bf.getSquad());
                        //break;
                    }
                } else { // if there is no Water and Rock
                    str = dX * bf.getSquad() + "_" + 0;
                    break;
                }
            }
            return str;
        }
    }

    public String findFrontNotWater(){

        String str = findFrontPlaceOfFire(frontLine());
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
    }

    public ArrayList<AbstractComponent> leftLine(){

        int hor = Integer.parseInt(findDefendersCoords().split("_")[0]);
        int vert = Integer.parseInt(findDefendersCoords().split("_")[1]);
        ArrayList<AbstractComponent> lL = new ArrayList<AbstractComponent>();
        System.out.println("LEFTLine:");
        if(hor != 0){
            for(int i = hor; i >= 0 ; i--){
                lL.add(bf.getBattleField()[vert][i]);
            }
            lL.remove(0);
        }else{
            // ... something should be here
        }
        return lL;
    }

    private String findLeftPlaceOfFire(ArrayList<AbstractComponent> line){

        String str = null;
        int dX = Integer.parseInt(findDefendersCoords().split("_")[0]);
        int dY = Integer.parseInt(findDefendersCoords().split("_")[1]);
        System.out.println("findLeftPlaceOfFire: Checking LeftLine");
        AbstractComponent checked = null;
        if(lineHasRock(line)){
            for(AbstractComponent i : line) {
                if (i instanceof Rock) {
                    checked = i;
                    System.out.println("left-checked = " + checked.toString());
                    break;
                }
            }
            if(checked.getX() != (dX - 1) * bf.getSquad() && !(isRockOrWater(checked.getX(), (dY - 1) * bf.getSquad())) ){
                str = (checked.getX() + bf.getSquad() ) + "_" + dY * bf.getSquad();
            }
//            else {
//                System.out.println("findLeftPlaceOfFire: LeftLine is closed: try RIGHT LINE!");
//                str = findRightNotWater();
//            }
            return str;
        } else { // if there are no Rocks in LeftLine
            for(AbstractComponent i : line) {
                if (i instanceof Water) {
                    checked = i;
                    System.out.println("right-checked = " + checked);
                    break;
                }
            }
            if (checked.getX() == 0) {
                System.out.println("MOVE BEFORE the Water");
                str = (checked.getX() + bf.getSquad()) + "_" + dY * bf.getSquad();;
            } else if(checked.getX() != 0) {
                System.out.println("MOVE BEHIND the Water");
                str = (checked.getX() - bf.getSquad()) + "_" + dY * bf.getSquad();;
            } else {
                System.out.println("FLPofF: no Water, LeftLine is opened - MOVE AND FIRE");
                if(dX != 0) {
                    str = (dX - 1) * bf.getSquad() + "_" + dY * bf.getSquad();
                }else{
                    str = dX * bf.getSquad() + "_" + dY * bf.getSquad();
                }
            }
            return str;
        }
    }

    private String findLeftNotWater(){

        String str = findLeftPlaceOfFire(leftLine());
        int dX = Integer.parseInt(findDefendersCoords().split("_")[0]);
        int dY = Integer.parseInt(findDefendersCoords().split("_")[1]);
        if(str != null){
            int xCoord = Integer.parseInt(str.split("_")[0]);
            while (bf.getBattleField()[dY][xCoord / 64] instanceof Water) {
                if(xCoord == (dY - 1) * bf.getSquad()){
                    System.out.println("findLeftNotWater: LeftLine is Closed by Water: try RightLine");
                    return findRightNotWater();
                }else{
                    xCoord -= bf.getSquad();
                }
            }
            return xCoord + "_" + dY * bf.getSquad();
        } else {
            return "findLeftNotWater !!!STOP!!!";
        }
    }

    public ArrayList<AbstractComponent> rightLine(){

        int hor = Integer.parseInt(findDefendersCoords().split("_")[0]);
        int vert = Integer.parseInt(findDefendersCoords().split("_")[1]);

        ArrayList<AbstractComponent> rL = new ArrayList<AbstractComponent>();
        System.out.println("RIGHTLine:");
        if(hor != 8){
            for(int i = hor; i <= 8 ; i++){
                rL.add(bf.getBattleField()[vert][i]);
            }
            rL.remove(0);
        }
        return rL;
    }

    private String findRightPlaceOfFire(ArrayList<AbstractComponent> line) {

        String str = null;
        int dX = Integer.parseInt(findDefendersCoords().split("_")[0]);
        int dY = Integer.parseInt(findDefendersCoords().split("_")[1]);
        System.out.println("findRightPlaceOfFire: Checking RIGHTLine");
        AbstractComponent checked = null;
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
            if (checked.getX() != (dX + 1) * bf.getSquad() && !(isRockOrWater(checked.getX(), (dY + 1) * bf.getSquad()))) {
                str = (checked.getX() - bf.getSquad()) + "_" + dY * bf.getSquad();
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
            if (checked.getX() != (bf.getMNQ() - 1) * bf.getSquad()) {
                System.out.println("MOVE BEHIND the Water");
                str = (checked.getX() + bf.getSquad()) + "_" + dY * bf.getSquad();
            } else if(checked.getX() == (bf.getMNQ() - 1) * bf.getSquad()) {
                System.out.println("MOVE BEFORE the Water");
                str = (checked.getX() - bf.getSquad()) + "_" + dY * bf.getSquad();
            } else {
                System.out.println("FRPofF: no Water, RightLine is opened - MOVE AND FIRE");
                if(dX != bf.getMNQ() - 1) {
                    str = (dX + 1) * bf.getSquad() + "_" + dY * bf.getSquad();
                }else{
                    str = dX * bf.getSquad() + "_" + dY * bf.getSquad();
                }
            }
            return str;
        }
    }


    private String findRightNotWater(){

        String str = findRightPlaceOfFire(rightLine());
        int dX = Integer.parseInt(findDefendersCoords().split("_")[0]);
        int dY = Integer.parseInt(findDefendersCoords().split("_")[1]);
        if(str != null){
            int xCoord = Integer.parseInt(str.split("_")[0]);
            if(xCoord == (bf.getMNQ() - 1) * bf.getSquad()){
                return xCoord + "_" + dY * bf.getSquad();
            }else {
                while (bf.getBattleField()[dY][xCoord / 64] instanceof Water) {
                    if(xCoord == (dX + 1) * 64){
                        return findLeftNotWater();
                    }else{
                        xCoord += bf.getSquad();
                    }
                }
            }
            return xCoord + "_" + dY * bf.getSquad();
        } else {
            return "findLeftNotWater !!!STOP!!!";
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
