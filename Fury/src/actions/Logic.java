package actions;

import battleFields.*;
import enumerations.Direct;
import tanks.AbstractTank;

import java.util.ArrayList;

public class Logic {

    private AbstractTank tank;
    private Bullet bullet;
    private BattleField bf;
    private Slider sdr;

    public Logic(Slider sdr, BattleField bf) throws Exception {

        this.sdr = sdr;
        this.bf = bf;
        this.tank = sdr.getAgressor();
        this.bullet = sdr.getBullet();
    }

    private ArrayList<AbstractComponent> frontLine(){

        ArrayList<AbstractComponent> fL = new ArrayList<AbstractComponent>();
        for(int i = bf.getMNQ() - 1; i > 0; i--){
            fL.add(bf.getBattleField()[i][4]);
        }
        return fL;
    }

    private boolean lineHasRock(ArrayList<AbstractComponent> list){

        for(AbstractComponent i : list){
            if(i instanceof Rock){
                return true;
            }
        }
        return false;
    }

    private String findFrontPlaceOfFire(ArrayList<AbstractComponent> list){

        String str = null;
        if(lineHasRock(list)){
            for(AbstractComponent i : list){
                if(i instanceof Rock){
                    if(i.getY() != 448){
                        str = i.getX() + "_" + (i.getY() + bf.getSquad());
                        break;
                    } else {
                        str = findLeftNotWater();
                        break;
                    }
                }
            }
            return str;
        } else {
            for(AbstractComponent i : list){
                if(i instanceof Water){
                    if(i.getY() != 0){
                        str = i.getX() + "_" + (i.getY() - bf.getSquad());
                        break;
                    } else {
                        str = i.getX() + "_" + (i.getY() + bf.getSquad());
                        break;
                    }
                } else {
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
            while(bf.getBattleField()[yCoord / 64][xCoord / 64] instanceof Water){
                yCoord += 64;
            }
            return xCoord + "_" + yCoord;
        } else {
            if(tank.getX() <= 256) {
                return findLeftNotWater();
            } else {
                return findRightNotWater();
            }
        }
    }

    private ArrayList<AbstractComponent> leftLine(){

        ArrayList<AbstractComponent> lL = new ArrayList<AbstractComponent>();
        for(int i = (bf.getMNQ() / 2 - 1); i >= 0 ; i--){
            lL.add(bf.getBattleField()[8][i]);
        }
        return lL;
    }

    private String findLeftPlaceOfFire(ArrayList<AbstractComponent> list){

        String str = null;
        if(lineHasRock(list)){
            for(AbstractComponent i : list){
                if(i instanceof Rock){
                    if(i.getX() != 192){
                        str = (i.getX() + bf.getSquad() ) + "_" + 512;
                        break;
                    } else {
                        str = findRightNotWater();
                        break;
                    }
                }
            }
            System.out.println("flpof1 " + str);
            return str;
        } else {
            for(AbstractComponent i : list){
                if(i instanceof Water){
                    if(i.getX() != 0){
                        str = (i.getX() - bf.getSquad()) + "_" + 512;
                        break;
                    } else {
                        str = (i.getX() + bf.getSquad()) + "_" + 512;
                        break;
                    }
                } else {
                    str = "0_512";
                    break;
                }
            }
            System.out.println("flpof2 + " + str);
            return str;
        }
    }

    private String findLeftNotWater(){

        String str = findLeftPlaceOfFire(leftLine());
        if(str != null){
            int xCoord = Integer.parseInt(str.split("_")[0]);
            //int yCoord = Integer.parseInt(str.split("_")[1]);
            while(bf.getBattleField()[8][xCoord / 64] instanceof Water){
                xCoord += 64;
            }
            return xCoord + "_" + 512;
        } else {
            return "findLeftNotWater !!!STOP!!!";
        }
    }

    private ArrayList<AbstractComponent> rightLine(){

        ArrayList<AbstractComponent> rL = new ArrayList<AbstractComponent>();
        for(int i = 5; i < bf.getMNQ(); i++){
                rL.add(bf.getBattleField()[8][i]);
        }
        return rL;
    }

    //not wright!!!
    private String findRightNotWater(){

        String str = findRightPlaceOfFire(rightLine());
        if(str != null){
            int xCoord = Integer.parseInt(str.split("_")[0]);
            //int yCoord = Integer.parseInt(str.split("_")[1]);
            while(bf.getBattleField()[8][xCoord / 64] instanceof Water){
                xCoord -= 64;
            }
            return xCoord + "_" + 512;
        } else {
            return "findLeftNotWater !!!STOP!!!";
        }
    }

    //not wright!!!
    private String findRightPlaceOfFire(ArrayList<AbstractComponent> list){

        String str = null;
        if(lineHasRock(list)){
            for(AbstractComponent i : list){
                if(i instanceof Rock){
                    if(i.getX() != 320){
                        str = (i.getX() - bf.getSquad() ) + "_" + 512;
                        break;
                    } else {
                        str = "!!!HQ IS UNDESTRUCTABLE!!!";
                        break;
                    }
                }
            }
            System.out.println("fRpof1 " + str);
            return str;
        } else {
            for(AbstractComponent i : list){
                if(i instanceof Water){
                    if(i.getX() != 512){
                        str = (i.getX() + bf.getSquad()) + "_" + 512;
                        break;
                    } else {
                        str = (i.getX() - bf.getSquad()) + "_" + 512;
                        break;
                    }
                } else {
                    str = "512_512";
                    break;
                }
            }
            System.out.println("fRpof2 + " + str);
            return str;
        }
    }

    public void infoShow(ArrayList<AbstractComponent> list){

        for(AbstractComponent i : list){
            System.out.println(i.toString());
        }
    }

    private boolean tankOnLineOfFire() throws Exception {

        if(tank.getX() == 256 || tank.getY() == 512){
            return true;
        }
        return false;
    }


    public void lookForWrightWay() throws Exception {



    }
}

