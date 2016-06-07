package ugis;

import actions.Slider;
import battleFields.BattleField;
import battleFields.Black;


public class FuryLauncher {

    private Slider slider;
    private BattleField bF;
    private FuryGUI fG;


    public FuryLauncher(FuryGUI fG, BattleField bF)throws Exception {

        if (bF.getBattleField()[8][4] instanceof Black){

            System.out.println();
            System.out.println("STARTING NEW GAME");

            fG = new FuryGUI();

            while(fG.youCanStartTheGame()){

            }
            Thread.sleep(1000);


            new Slider().runTheGame();
        }




    }
}
