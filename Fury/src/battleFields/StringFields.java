package battleFields;

import java.util.Random;

/**
 * Created by prulov on 27.04.2016.
 */
public class StringFields {

    // BF # 0
    private String[][] bf_0 = {
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

    // BF # 1
    private String[][] bf_1 = {{"P", "P", "R", "P", "P", "R", "P", "P", "B"},
            {"B", "P", "P", "R", "P", "P", "P", "R", "P"}, {"P", "B", "B", "B", "P", "B", "B", "P", "P"},
            {"W", "P", "B", "P", "B", "R", "B", "W", "W"}, {"P", "R", "B", "B", "B", "R", "P", "P", "P"},
            {"B", "B", "P", "P", "B", "B", "B", "B", "P"}, {"P", "B", "P", "W", "P", "B", "B", "B", "R"},
            {"P", "P", "W", "P", "R", "B", "B", "B", "B"}, {"R", "P", "B", "B", "S", "B", "B", "P", "W"}};

    // BF # 2
    private String[][] bf_2 = {{"P", "P", "P", "W", "P", "R", "P", "P", "B"},
            {"B", "P", "P", "P", "P", "P", "P", "P", "P"}, {"P", "B", "B", "B", "R", "B", "B", "P", "P"},
            {"B", "R", "B", "W", "B", "R", "B", "R", "P"}, {"P", "R", "B", "B", "B", "R", "B", "P", "B"},
            {"B", "B", "P", "P", "B", "B", "B", "B", "P"}, {"P", "B", "W", "W", "R", "B", "B", "B", "R"},
            {"B", "P", "B", "P", "B", "B", "B", "B", "B"}, {"B", "B", "B", "B", "S", "B", "P", "B", "B"}};

    // BF # 3
    private String[][] bf_3 = {{"P", "P", "P", "B", "P", "P", "P", "P", "B"},
            {"B", "P", "P", "P", "P", "P", "P", "P", "P"}, {"P", "B", "B", "B", "B", "B", "B", "P", "P"},
            {"B", "R", "B", "P", "B", "R", "B", "P", "P"}, {"R", "W", "R", "W", "R", "W", "R", "B", "R"},
            {"B", "B", "P", "P", "B", "B", "B", "B", "P"}, {"P", "B", "W", "W", "W", "B", "B", "B", "R"},
            {"B", "P", "B", "P", "B", "B", "B", "B", "B"}, {"B", "B", "B", "B", "S", "B", "P", "B", "B"}};

    // BF # 4
    private String[][] bf_4 = {{"P", "P", "P", "W", "P", "R", "P", "P", "B"},
            {"B", "P", "P", "P", "P", "P", "P", "P", "P"}, {"P", "B", "R", "B", "R", "B", "B", "P", "P"},
            {"B", "R", "B", "W", "B", "R", "B", "R", "P"}, {"P", "R", "B", "R", "B", "R", "B", "P", "B"},
            {"B", "B", "P", "P", "R", "B", "B", "B", "P"}, {"P", "B", "W", "W", "P", "B", "B", "B", "R"},
            {"B", "P", "B", "W", "R", "W", "B", "B", "B"}, {"B", "B", "B", "B", "S", "P", "P", "B", "B"}};


    // BF # 5
    private String[][] bf_5 = {{"P", "P", "P", "P", "P", "P", "P", "P", "P"},
            {"P", "P", "P", "P", "P", "P", "B", "P", "P"}, {"P", "B", "B", "P", "P", "P", "P", "P", "P"},
            {"P", "B", "P", "B", "B", "P", "P", "B", "P"}, {"P", "P", "P", "P", "B", "P", "P", "P", "P"},
            {"P", "P", "P", "P", "P", "P", "P", "P", "P"}, {"P", "P", "P", "P", "P", "P", "P", "P", "P"},
            {"P", "P", "P", "P", "R", "B", "P", "P", "P"}, {"W", "W", "R", "W", "S", "W", "P", "W", "W"}};



    public StringFields() {
    }

    public String[][] getBf_0() {
        return bf_0;
    }

    public String[][] getBf_1() {
        return bf_1;
    }

    public String[][] getBf_2() {
        return bf_2;
    }

    public String[][] getBf_3() {
        return bf_3;
    }

    public String[][] getBf_4() {
        return bf_4;
    }

    public String[][] getBf_5() {
        return bf_5;
    }

    public String[][] defineStringBF() {

        String[][] str = bf_0;
        int i = toRandomI();
        if(i == 0 || i == 5){
            str = bf_0;
        }else if(i == 1) {
            str = bf_1;
        }else if(i == 2){
            str = bf_2;
        }else{
            str = i == 3 ? bf_3 : bf_4;
        }
        return str;
    }

    private int toRandomI() {

        Random r = new Random();
        int i = r.nextInt(5);
        return i;
    }
}
