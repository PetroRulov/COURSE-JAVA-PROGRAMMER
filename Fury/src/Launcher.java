import actions.Slider;
import ugis.FuryGUI;
import ugis.Splash;

public class Launcher {


    public static void main(String[] args) throws Exception {

        new Splash();

        FuryGUI fG = new FuryGUI();

        while(fG.youCanStartTheGame()){

        }
        Thread.sleep(1000);
        Slider slide = new Slider();
        slide.runTheGame();
    }
}


