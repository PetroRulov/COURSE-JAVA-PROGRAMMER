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

        Badigan bad = new Badigan();
        BadiganShopUI ui = new BadiganShopUI(bad, bad.getServ().getStk());
        //Gesh_GBL_GUI gesh = new Gesh_GBL_GUI(bad, bad.getServ().getStk());
    }

}
