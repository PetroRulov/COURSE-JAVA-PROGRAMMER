package actions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import battleFields.BattleField;
import battleFields.*;
import interfaces.IDestructable;
import tanks.AbstractTank;

public class AI{

    private LinkedList<IDestructable> freeWay;
    private BattleField bat;
    private AbstractTank tank;

    public AI(BattleField bat){

        this.bat = bat;
        this.freeWay = freeWay;
        //initFreeWay();
    }

    public LinkedList<IDestructable> getFreeWay() {return new LinkedList<IDestructable>(freeWay);}




}

