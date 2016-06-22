import util.Service;

/**
 * Created by prulov on 22.03.2016.
 */
public class Demo {

    Service serv = new Service();
//    GeshGUI geshGUI = new GeshGUI(serv);
//    BuyControl bc = new BuyControl(serv, geshGUI);

    public void openBadiganRun() {


        // unchecked
        //System.out.println(geshGUI.getTfDate().getAccessibleContext());



        // test methods
        serv.printClientsBase(serv.getBad().getClts());

        // check-point
        System.err.println(serv.getBad().getStk().getWaters().get(5).toString());


        /*-d i s p l a y i n g     t h e     q u a n t i t y     o f      G o o d s     i n     S t o c k-*/
        serv.getBad().getStk().printWat();
        serv.getBad().getStk().printWaters();

        /*-d i s p l a y i n g     P R I C E      L I S T-*/
        serv.printPriceList();

        /*-d i s p l a y i n g     C A T A L O G U E-*/
        serv.printCatalogue();

        /*-d i s p l a y i n g     S a l e s    r e p o r t s-*/
        serv.dailyReport();
        System.out.println();
        serv.periodReport();

    }

}


