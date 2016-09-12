package actions;

import domains.Coord;
//import org.jetbrains.annotations.Nullable;
import tanks.AbstractTank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AgrIntel {

    private int lab[][];
    private AbstractTank tank;
    private List freeWay;
    private int map[][] ;


    public AgrIntel(){}

    public AgrIntel(int lab[][], AbstractTank tank) throws Exception {

        this.lab = lab;
        this.tank = tank;
        this.freeWay = new ArrayList<Coord>();
        this.map = new int[lab.length][lab.length];
    }

    private void setPathSteps(Coord c, int stepValue){

        if(map[c.getYC()][c.getXC()] < stepValue){
            return;
        }
        map[c.getYC()][c.getXC()] = stepValue;
        freeWay.add(c);
    }

    //@Nullable
    private Coord takeOffFirst(){

        if(freeWay.isEmpty()){
            return null;
        }
        return (Coord) freeWay.remove(0);
    }

    //@Nullable
    public Coord[] lookingForThePath(Coord start, Coord end){

        int pX = 0, pY = 0, stepValue = 0, p = 0;
        Coord c;

        for(int i = 0; i < map.length; i++){
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }

        setPathSteps(start, 0);

        while((c = takeOffFirst()) != null){
            if(c.equals(end)){
                System.err.println("WE FOUND THE LENGTH OF OUR PATH!");
                break;
            }
            stepValue+= lab[c.getYC()][c.getXC()];

            if((c.getYC() + 1 < lab.length) && lab[c.getYC() + 1][c.getXC()] != 0){ // undestructable points as zero
                setPathSteps(new Coord(c.getXC(), c.getYC() + 1), stepValue);
            }
            if((c.getYC() - 1 >= 0) && (lab[c.getYC() - 1][c.getXC()] != 0)){ // undestructable points as zero
                setPathSteps(new Coord(c.getXC(), c.getYC() - 1), stepValue);
            }
            if((c.getXC() + 1 < lab[c.getYC()].length) && (lab[c.getYC()][c.getXC() + 1] != 0)){ // undestructable points as zero
                setPathSteps(new Coord(c.getXC() + 1, c.getYC()), stepValue);
            }
            if((c.getXC() - 1 >= 0) && (lab[c.getYC()][c.getXC() - 1] != 0)){ // undestructable points as zero
                setPathSteps(new Coord(c.getXC() - 1, c.getYC()), stepValue);
            }
        }
        System.out.println("AgrIntel(lookingForThePath): LENGTH OF THE PATH IS " + stepValue + " STEPS."); // bricks counts as 2(two)

        if(map[end.getYC()][end.getXC()]== Integer.MAX_VALUE){
            System.err.println("PATH CAN NOT BE FOUND!!!");
            return null;
        } else
            System.out.println("SEARCH FOR THE OPTIMAL PATH IS OVER, GO AHEAD!!!");
        List route = new ArrayList<Coord>();
        route.add(end); // starting from the end
        int x = end.getXC();
        int y = end.getYC();
        stepValue = Integer.MAX_VALUE;
        while((x!=start.getXC())||(y!=start.getYC())){
            if(y != (lab.length - 1)){
                if(map[y + 1][x] < stepValue){
                    pX = x; pY= y + 1; p = map[y + 1][x];
                }
            } else {
                if(map[y][x] < stepValue){
                    pX = x; pY= y; p = map[y][x];
                }
            }

            if(y != 0){
                if(map[y-1][x] < stepValue){
                    pX = x; pY = y - 1; p = map[y - 1][x];
                }
            } else {
                if(map[y][x] < stepValue){
                    pX = x; pY = y; p = map[y][x];
                }
            }

            if(x != (lab.length - 1)){
                if(map[y][x + 1] < stepValue){
                    pX = x + 1; pY = y; p = map[y][x + 1];
                }
            } else {
                if(map[y][x] < stepValue){
                    pX = x; pY = y; p = map[y][x];
                }
            }

            if(x != 0){
                if(map[y][x - 1]< stepValue){
                    pX = x - 1; pY = y; p = map[y][x - 1];
                }
            } else {
                if(map[y][x]< stepValue){
                    pX = x; pY = y; p = map[y][x];
                }
            }
            x = pX;
            y = pY;
            stepValue = p;

            route.add(new Coord(x, y)); // we recieved the way back-to-front
        }

        Coord[] path = new Coord[route.size()];
        p = route.size();
        for(Object coord: route)
            path[--p] = (Coord) coord;
        return path;
    }
}

