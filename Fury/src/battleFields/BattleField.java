package battleFields;

import java.util.Random;

public class BattleField {

    private int BF_WIDTH = 576;
    private int BF_HEIGHT = 576;
    private int squad = 64;
    private int MNQ = 9;
    private int pace = 1;
//    private String[][] bf = {{"P", "P", "R", "P", "P", "R", "P", "P", "B"},
//            {"B", "P", "B", "R", "P", "P", "P", "R", "P"}, {"P", "B", "B", "B", "P", "B", "B", "P", "P"},
//            {"W", "P", "B", "P", "B", "R", "B", "W", "W"}, {"P", "R", "B", "B", "B", "R", "P", "P", "P"},
//            {"B", "B", "P", "P", "B", "B", "B", "B", "P"}, {"P", "B", "P", "W", "P", "B", "B", "B", "R"},
//            {"P", "P", "W", "P", "R", "B", "B", "B", "B"}, {"R", "P", "B", "B", "S", "B", "B", "P", "W"}};
//
//    private String[][] bf = {{"P", "P", "P", "W", "P", "R", "P", "P", "B"},
//            {"B", "P", "P", "P", "P", "P", "P", "P", "P"}, {"P", "B", "B", "B", "R", "B", "B", "P", "P"},
//            {"B", "R", "B", "W", "B", "R", "B", "R", "P"}, {"P", "R", "B", "B", "B", "R", "B", "P", "B"},
//            {"B", "B", "P", "P", "B", "B", "B", "B", "P"}, {"P", "B", "W", "W", "R", "B", "B", "B", "R"},
//            {"B", "P", "B", "P", "B", "B", "B", "B", "B"}, {"B", "B", "B", "B", "S", "B", "P", "B", "B"}};

//    private String[][] bf = {{"P", "P", "P", "B", "P", "P", "P", "P", "B"},
//            {"B", "P", "P", "P", "P", "P", "P", "P", "P"}, {"P", "B", "B", "B", "B", "B", "B", "P", "P"},
//            {"B", "R", "B", "P", "B", "R", "B", "P", "P"}, {"R", "W", "R", "W", "R", "W", "R", "B", "R"},
//            {"B", "B", "P", "P", "B", "B", "B", "B", "P"}, {"P", "B", "W", "W", "W", "B", "B", "B", "R"},
//            {"B", "P", "B", "P", "B", "B", "B", "B", "B"}, {"B", "B", "B", "B", "S", "B", "P", "B", "B"}};

//    private String[][] bf = {{"P", "P", "P", "P", "P", "P", "P", "P", "P"},
//            {"P", "P", "P", "P", "P", "P", "B", "P", "P"}, {"P", "B", "B", "P", "P", "P", "P", "P", "P"},
//            {"P", "B", "P", "B", "B", "P", "P", "B", "P"}, {"P", "P", "P", "P", "B", "P", "P", "P", "P"},
//            {"P", "P", "P", "P", "P", "P", "P", "P", "P"}, {"P", "P", "P", "P", "P", "P", "P", "P", "P"},
//            {"P", "P", "P", "P", "R", "B", "P", "P", "P"}, {"W", "W", "R", "W", "S", "W", "P", "W", "W"}};

//    private String[][] bf = {{"P", "P", "P", "W", "P", "R", "P", "P", "B"},
//            {"B", "P", "P", "P", "P", "P", "P", "P", "P"}, {"P", "B", "R", "B", "R", "B", "B", "P", "P"},
//            {"B", "R", "B", "W", "B", "R", "B", "R", "P"}, {"P", "R", "B", "R", "B", "R", "B", "P", "B"},
//            {"B", "B", "P", "P", "R", "B", "B", "B", "P"}, {"P", "B", "W", "W", "P", "B", "B", "B", "R"},
//            {"B", "P", "B", "W", "R", "W", "B", "B", "B"}, {"B", "B", "B", "B", "S", "P", "P", "B", "B"}};

    private String[][] bf = {
            {"B", "P", "P", "W", "R", "W", "P", "P", "B"},
            {"B", "P", "P", "R", "P", "P", "P", "P", "P"},
            {"P", "P", "P", "R", "P", "P", "P", "P", "P"},
            {"B", "R", "W", "P", "P", "R", "P", "R", "P"},
            {"P", "R", "P", "P", "R", "R", "B", "P", "B"},
            {"B", "B", "P", "R", "R", "B", "B", "B", "P"},
            {"P", "B", "W", "W", "W", "B", "R", "B", "R"},
            {"B", "P", "R", "R", "W", "R", "R", "B", "B"},
            {"B", "R", "R", "B", "S", "B", "W", "W", "P"}
    };






    private AbstractComponent[][] battleField;

    public BattleField() throws Exception {
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

