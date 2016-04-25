package actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import battleFields.*;
import interfaces.*;
import tanks.*;
import enumerations.Direct;

public class AI{

    private BattleField bat;
    private ArrayList<IWayable> freeWay;
    private AbstractTank tank;
    //private Slider slid;
    //private Logic log;


    public AI(){}

    public AI(BattleField bat, ArrayList<IWayable> freeWay, AbstractTank tank){

        this.bat = bat;
        this.freeWay = new ArrayList<IWayable>();
        initFreeWay();
        this.tank = tank;

    }

    public ArrayList<IWayable> getFreeWay() {return new ArrayList<IWayable>(freeWay);}

    public void initFreeWay(){

        for(AbstractComponent[] lines : bat.getBattleField()){
            for(AbstractComponent i : lines){
                if(i instanceof IWayable){
                    freeWay.add((IWayable) i);
                }
            }
        }
    }

    public ArrayList<IWayable> nextObjApply(){

        ArrayList<IWayable> route = new ArrayList<IWayable>();
        for(IWayable r : getFreeWay()){
            if(xyApply(r)) {
                route.add(r);
            }
        }
        return route;
    }

    public boolean xyApply(IWayable iW){

        int iWX = iW.getXC(), iWY = iW.getYC() ;
        int x = tank.getX(), y = tank.getY();
        int cx = x - iWX, xc = iWX - x, cy = y - iWY, yc = iWY - y;

        if(cx == Math.abs(64) && iW.getYC() == tank.getY() || iW.getXC() == tank.getX() && cy == Math.abs(64) ||
                xc == Math.abs(64) && iW.getYC() == tank.getY() || iW.getXC() == tank.getX() && yc == Math.abs(64)) {
            return true;
        }
        return false;
    }

    public void wrightMoving(){

    }

    public boolean processPurityCheck() throws Exception {

        if (tank.getNextQuadrant() instanceof Plant){
            return true;
        } else if(tank.getNextQuadrant() instanceof Brick || tank.getNextQuadrant() instanceof HQ) {
            tank.fire();
            return true;
        }
        return false;
    }

    public IWayable scanObject(int x, int y){

        IWayable seeked = null;
        for(IWayable i : getFreeWay()){
            if(i.getXC() == x && i.getYC() == y ){
                seeked = i;
            }
        }
        return seeked;
    }


}

