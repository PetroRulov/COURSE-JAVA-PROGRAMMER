import actions.Slider;
import ugis.FurGUI;
import ugis.Splash;

public class FurLauncher {


    public static void main(String[] args) throws Exception {

        new Splash();
        Slider slider = new Slider();
        //slider.runTheGame();
        new FurGUI(slider);

    }
}


