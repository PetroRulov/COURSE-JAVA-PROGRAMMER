import domain.Stock;
import enumerations.Drink;
import enumerations.Tare;
import waters.Water;

/**
 * Created by prulov on 22.03.2016.
 */
public class Launcher {

    public static void main(String[] args) {

//        Demo d = new Demo();
//        d.openBadiganRun();

        Service serv = new Service();
        BadiganShopUI ui = new BadiganShopUI(serv);

        //Gesh_GBL_GUI gesh = new Gesh_GBL_GUI(serv);

        // !!! something uncleared
//        Service serv = new Service(/*bad.getServ().getStk()*/);
//        BadiganShopUI ui = new BadiganShopUI(serv);
//        ui.setStk(new Stock());
//        ui.createSellingPannel();
    }

}
