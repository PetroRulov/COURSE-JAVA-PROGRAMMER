package enumerations;

public enum Direct {

    UP, DOWN, RIGHT, LEFT, STOP, MINUS;

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

