package domains;

public class Coord{

    private int xC;
    private int yC;

    public Coord(int xC, int yC){
        this.xC = xC;
        this.yC = yC;
    }

    public int getXC() {
        return xC;
    }

    public int getYC() {
        return yC;
    }

    public String toString(){

        return getXC() * 64 + "_" + getYC() * 64;
    }

}
