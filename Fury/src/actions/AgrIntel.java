package actions;

import java.util.*;

import battleFields.*;
import domains.Coord;
import tanks.*;

import org.jetbrains.annotations.Nullable;

public class AgrIntel {

    private BattleField bat;
    private int[][] lab;
    private AbstractTank tank;
    private List freeWay;
    private int[][] map;


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

    private void setPathSteps(Coord c, int wayLength){

        if(map[c.getYC()][c.getXC()] <= wayLength){
            return;
        }
        map[c.getYC()][c.getXC()] = wayLength;
        freeWay.add(c);
    }

    @Nullable
    private Coord takeOffFirst(){

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
        setPathSteps(start, 0);

        while((c = takeOffFirst()) != null){
            if(c.equals(end)){
                System.err.println("WE FOUND THE LENGTH!");
            }
            wayLength = map[c.getYC()][c.getXC()] + lab[c.getYC()][c.getXC()];
            if((c.getYC() + 1 < lab.length) && lab[c.getYC() + 1][c.getXC()] != 0){ // undestructable points as zero
                setPathSteps(new Coord(c.getXC(), c.getYC() + 1), wayLength);
            }
            if((c.getYC() - 1 >= 0) && (lab[c.getYC() - 1][c.getXC()] != 0)){ // undestructable points as zero
                setPathSteps(new Coord(c.getXC(), c.getYC() - 1), wayLength);
            }
            if((c.getXC() + 1 < lab[c.getYC()].length) && (lab[c.getYC()][c.getXC() + 1] != 0)){ // undestructable points as zero
                setPathSteps(new Coord(c.getXC() + 1, c.getYC()), wayLength);
            }
            if((c.getXC() - 1 >= 0) && (lab[c.getYC()][c.getXC() - 1] != 0)){ // undestructable points as zero
                setPathSteps(new Coord(c.getXC() - 1, c.getYC()), wayLength);
            }
        }
        System.out.println("AgrIntel: LENGTH OF THE PATH IS " + wayLength + " STEPS."); // bricks counts as 2(two)

        if(map[end.getYC()][end.getXC()]==Integer.MAX_VALUE){
            System.err.println("PATH CAN NOT BE FOUND!!!");
            return null;
        } else
            System.out.println("SEARCH FOR THE OPTIMAL PATH IS OVER, GO AHEAD!!!");
        List route = new ArrayList<Coord>();
        route.add(end); // starting from the end
        int x = end.getXC();
        int y = end.getYC();
        wayLength = Integer.MAX_VALUE;
        while((x!=start.getXC())||(y!=start.getYC())){
            if(y != (bat.getMNQ() - 1)){
                if(map[y + 1][x] < wayLength){
                    pX = x; pY= y + 1; p = map[y + 1][x];
                }
            } else {
                if(map[y][x] < wayLength){
                    pX = x; pY= y; p = map[y][x];
                }
            }

            if(y != 0){
                if(map[y-1][x] < wayLength){
                    pX = x; pY = y - 1; p = map[y - 1][x];
                }
            } else {
                if(map[y][x] < wayLength){
                    pX = x; pY = y; p = map[y][x];
                }
            }

            if(x != (bat.getMNQ() - 1)){
                if(map[y][x + 1] < wayLength){
                    pX = x + 1; pY = y; p = map[y][x + 1];
                }
            } else {
                if(map[y][x] < wayLength){
                    pX = x; pY = y; p = map[y][x];
                }
            }

            if(x != 0){
                if(map[y][x - 1]< wayLength){
                    pX = x - 1; pY = y; p = map[y][x - 1];
                }
            } else {
                if(map[y][x]< wayLength){
                    pX = x; pY = y; p = map[y][x];
                }
            }
            x = pX;
            y = pY;
            wayLength = p;

            route.add(new Coord(x, y)); // we recieved the way back-to-front
        }

        Coord[] path = new Coord[route.size()];
        p = route.size();
        for(Object coord: route)
            path[--p] = (Coord) coord;
        return path;
    }
}

