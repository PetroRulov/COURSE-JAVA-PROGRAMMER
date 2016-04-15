package enumerations;

public enum Color {

    SAND(1), RED(2), BROWN(3), DARK_BROWN(4), GREEN(5), DARK_GREEN(6), BLUE(7), DARK_BLUE(8),
    SILVER(9), MUSTARD(10), KHAKI(11), BEIGE(12), WHITE(13), BLACK(14), GREY(15), YELLOW(16);

    private int indx;

    private Color(int indx) {
        this.indx = indx;
    }

    private int getIndx() {
        return indx;
    }
}


