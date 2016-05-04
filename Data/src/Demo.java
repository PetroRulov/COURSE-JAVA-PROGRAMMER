import domain.Data;
import interfaces.BLI;

import java.util.List;

/**
 * Created by prulov on 25.04.2016.
 */
public class Demo {

    public static void main(String[] args){

        GUI gui = new GUI();
        gui.setBL(new BL());
        gui.buttonClick();

    }
}
