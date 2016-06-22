import guis.GeshGUI;
import guis.Splash;
import util.Service;

/**
 * Created by prulov on 22.03.2016.
 */

public class GeshLauncher {

    public static void main(String[] args)throws InterruptedException {

        new Splash();

//        Demo d = new Demo();
//        d.openBadiganRun();

        Service serv = new Service();
        GeshGUI gGui = new GeshGUI(serv);
        gGui.setDataProvider(serv.getBad());
        gGui.setDataProvider(serv.getBad().getStk());

    }
}
