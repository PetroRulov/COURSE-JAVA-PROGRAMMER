public enum Genre {

    FICTION(0), FANTASY(1), POETRY(2), COMPUTERS(3), COOKBOOKS(4), HISTORY(5), INDEFINITE(6);

    private int id;

    private Genre(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
