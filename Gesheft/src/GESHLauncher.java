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
        GeshGUI gGui = new GeshGUI(serv);
        gGui.setBadigan(serv.getBad());

    }
}
