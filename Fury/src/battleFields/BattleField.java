package battleFields;

import java.util.Random;

public class BattleField {

    private int BF_WIDTH = 576;
    private int BF_HEIGHT = 576;
    private int squad = 64;
    private int MNQ = 9;
    private int pace = 1;
    private StringFields sFs;
    private String[][] bf;
    private AbstractComponent[][] battleField;

    public BattleField() throws Exception {
        this.sFs = new StringFields();
        this.bf = sFs.defineStringBF();
        this.battleField = fillBFWithObjects(this.bf);

    }

    public BattleField(AbstractComponent[][] battleField) {
        this.battleField = battleField;
    }

    private AbstractComponent switcher(String let, int x, int y) throws Exception {

        switch(let) {
            case "B":
                return new Brick(x, y);
            case "E":
                return new Explosive(x, y);
            case "S":
                return new HQ(x, y);
            case "R":
                return new Rock(x, y);
            case "W":
                return new Water(x, y);
            default:
                return new Plant(x, y);
        }
    }

    public AbstractComponent[][] fillBFWithObjects(String[][] bf) throws Exception {

        AbstractComponent[][] objects = new AbstractComponent[MNQ][MNQ];

        for (int i = 0; i < MNQ; i++){
            for (int j = 0; j < MNQ; j++){
                objects[i][j] = switcher(bf[i][j], j*squad, i*squad);
            }
        }
        return objects;
    }

    public AbstractComponent scanQuadrant(int v, int h) {
        return battleField[v][h];
    }

    public void updateQuadrant(int v, int h, AbstractComponent str) {

        if (battleField[v][h] != null) {
            battleField[v][h] = str;
        }
    }

    public int getDimentionX() {
        return BF_WIDTH / squad;
    }

    public int getDimentionY() {
        return BF_HEIGHT / squad;
    }

    public AbstractComponent[][] getBattleField() {
        return battleField;
    }

    public String[][] getBf() {
        return bf;
    }

    public int getBF_HEIGHT() {
        return BF_HEIGHT;
    }

    public int getBF_WIDTH() {
        return BF_WIDTH;
    }

    public int getMNQ() {
        return MNQ;
    }

    public int getPace() {
        return pace;
    }

    public int getSquad() {
        return squad;
    }

}

