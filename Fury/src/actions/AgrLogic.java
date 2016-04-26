package actions;

import battleFields.*;
import enumerations.Direct;
import tanks.AbstractTank;

import java.util.ArrayList;

public class AgrLogic {

    private AbstractTank tank;
    private Bullet bullet;
    private BattleField bf;
    private Slider sdr;

    public AgrLogic(Slider sdr, BattleField bf, AbstractTank tank) throws Exception {

        this.sdr = sdr;
        this.bf = bf;
        this.tank = /*sdr.getAgressor()*/ tank;
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

    private boolean lineHasWater(ArrayList<AbstractComponent> list){

        for(AbstractComponent i : list){
            if(i instanceof Water){
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
                    } else { // if HQ is closed by a Rock from front side
                        if(tank.getX() < 320){
                            str = findLeftNotWater();
                        }else{
                            str = findRightNotWater();
                        }
                        break;
                    }
                }
            }
            return str;
        } else { // if there is no Rocks at all
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
            while(bf.getBattleField()[yCoord / bf.getSquad()][xCoord / bf.getSquad()] instanceof Water){
                yCoord += bf.getSquad();
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

    private ArrayList<AbstractComponent> leftLine(){

        ArrayList<AbstractComponent> lL = new ArrayList<AbstractComponent>();
        for(int i = (bf.getMNQ() / 2 - 1); i >= 0 ; i--){
            lL.add(bf.getBattleField()[8][i]);
        }
        return lL;
    }

    // not wright!!!
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
            return str;
        } else {
            for (AbstractComponent i : list) {
                if (i instanceof Water) {
                    if (i.getX() == 0) {
                        str = (i.getX() + bf.getSquad()) + "_" + 512;
                        break;
                    } else {
                        str = (i.getX() - bf.getSquad()) + "_" + 512;
                        break;
                    }
                } else {
                    str = "192_512";
                    break;
                }
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

    private ArrayList<AbstractComponent> rightLine(){

        ArrayList<AbstractComponent> rL = new ArrayList<AbstractComponent>();
        for(int i = 5; i < bf.getMNQ(); i++){
                rL.add(bf.getBattleField()[8][i]);
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
            return str;
        } else {
            for (AbstractComponent i : list) {
                if (i instanceof Water) {
                    if (i.getX() == 512) {
                        str = (i.getX() - bf.getSquad()) + "_" + 512;
                        break;
                    } else {
                        str = (i.getX() + bf.getSquad()) + "_" + 512;
                        break;
                    }
                } else {
                    str = "320_512";
                    break;
                }
            }
            return str;
        }
    }
}

