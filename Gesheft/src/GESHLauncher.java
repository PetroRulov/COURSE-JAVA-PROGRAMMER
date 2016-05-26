import guis.BuyControl;
import guis.GeshGUI;
import util.Service;

/**
 * Created by prulov on 22.03.2016.
 */

public class GeshLauncher {

    public static void main(String[] args) {

//        Demo d = new Demo();
//        d.openBadiganRun();

        Service serv = new Service();
        GeshGUI geshGUI = new GeshGUI(serv);
        new BuyControl(serv, geshGUI);
        //new SaleJTable(serv);

    }

}
