package actions;

import java.util.*;

import battleFields.*;
import interfaces.*;
import org.jetbrains.annotations.Nullable;
import tanks.*;
import enumerations.Direct;

public class AgrIntel {

    private BattleField bat;
    private List freeWay;
    private int[][] map;
    private int[][] lab;
    private AbstractTank tank;
    public class Coord{

        private int xC;
        private int yC;

        Coord(int xC, int yC){
            this.xC = xC;
            this.yC = yC;
        }

        public int getXC() {
            return xC;
        }

        public int getYC() {
            return yC;
        }

    };

    public AgrIntel(){}

    public AgrIntel(BattleField bat,  int[][] lab, AbstractTank tank) throws Exception {

        this.bat = bat;
        this.lab = lab;
        this.tank = tank;
        this.freeWay = new ArrayList<Coord>();
        this.map = new int[bat.getMNQ()][bat.getMNQ()];
    }

    public int[][] getLab() {return lab;}

    public ArrayList<Coord> getFreeWay() {return new ArrayList<Coord>(freeWay);}

    private void push(Coord c, int wayLength){

        if(map[c.getYC()][c.getXC()] <= wayLength){
            return;
        }
        map[c.getYC()][c.getXC()] = wayLength;
        freeWay.add(c);
    }

    @Nullable
    private Coord takeOff(){

        if(freeWay.isEmpty()){
            return null;
        }
        return (Coord) freeWay.remove(0);
    }

    @Nullable
    public Coord[] lookingForThePath(Coord start, Coord end){

        int pX = 0, pY = 0, wayLength = 0, p = 0;
        Coord c;

        for(int i = 0; i < map.length; i++){
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        push(start, 0);

        while((c = takeOff()) != null){
            if(c.equals(end)){
                System.err.println("WE FOUND THE LENGTH!");
            }
            wayLength = map[c.getYC()][c.getXC()] + lab[c.getYC()][c.getXC()];
            if((c.getYC() + 1 <lab.length) && lab[c.getYC() + 1][c.getXC()] != 0){
                push(new Coord(c.getXC(), c.getYC() + 1), wayLength);
            }
            if((c.getYC() - 1 >= 0) && (lab[c.getYC() - 1][c.getXC()] != 0)){
                push(new Coord(c.getXC(), c.getYC() - 1), wayLength);
            }
            if((c.getXC() + 1 < lab[c.getYC()].length) && (lab[c.getYC()][c.getXC() + 1] != 0)){
                push(new Coord(c.getXC() + 1, c.getYC()), wayLength);
            }
            if((c.getXC() - 1 >= 0) && (lab[c.getYC()][c.getXC() - 1] != 0)){
                push(new Coord(c.getXC() - 1, c.getYC()), wayLength);
            }
        }
        System.out.println("LENGTH OF THE PATH IS " + wayLength + " STEPS.");

        if(map[end.getYC()][end.getXC()]==Integer.MAX_VALUE){
            System.err.println("THERE PATH CAN NOT BE FOUND!!!");
            return null;
        } else
            System.out.println("SEARCH FOR THE OPTIMAL PATH IS OVER, GO AHEAD!!!");
        List route = new ArrayList();
        route.add(end);
        int x = end.getXC();
        int y = end.getYC();
        wayLength = Integer.MAX_VALUE;
        while((x!=start.getXC())||(y!=start.getYC())){
            if(y !=8){
                if(map[y + 1][x] < wayLength){pX = x; pY= y + 1; p = map[y + 1][x];}
            } else {
                if(map[y][x] < wayLength){pX = x; pY= y; p = map[y][x];}
            }

            if(y != 0){
                if(map[y-1][x] < wayLength){pX = x; pY = y - 1; p = map[y - 1][x];}
            } else {
                if(map[y][x] < wayLength){pX = x; pY = y; p = map[y][x];}
            }

            if(x != 8){
                if(map[y][x + 1] < wayLength){pX = x + 1; pY = y; p = map[y][x + 1];}
            } else {
                if(map[y][x] < wayLength){pX = x; pY = y; p = map[y][x];}
            }

            if(x != 0){
                if(map[y][x - 1]< wayLength){pX = x - 1; pY = y; p = map[y][x - 1];}
            } else {
                if(map[y][x]< wayLength){pX = x; pY = y; p = map[y][x];}
            }
            x = pX;
            y = pY;
            wayLength = p;
            route.add(new Coord(x,y));
        }

        Coord[] path = new Coord[route.size()];
        p = route.size();
        for(Object coord: route)
            path[--p] = (Coord) coord;
        return path;
    }

    private Coord[] setPath(List route){

        int steps = route.size();
        Coord[] path = new Coord[steps];
        for(Object coord: route)
            path[--steps] = (Coord) coord;
        return path;
    }
}

