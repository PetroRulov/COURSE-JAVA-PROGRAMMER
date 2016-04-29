package enumerations;

public enum Direct {

    UP(0), DOWN(1), RIGHT(2), LEFT(3), STOP(4), MINUS(5);


    private int indx;

    private Direct(int indx) {
        this.indx = indx;
    }

    public int getIndx() {
        return indx;
    }

    // for moveRandom() -variable int i-;
    public static Direct getDirect(int indx) {
        switch (indx) {
            case 1:
                return UP;
            case 2:
                return DOWN;
            case 3:
                return LEFT;
            case 4:
                return RIGHT;
            default:
                return STOP;
        }
    }
}

