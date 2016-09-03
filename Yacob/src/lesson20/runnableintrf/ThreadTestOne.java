package lesson20.runnableintrf;

/**
 * Created by prulov on 29.08.2016.
 */
public class ThreadTestOne {

    public static void main(String[] args) {

        MarketplaceNews mPN = new MarketplaceNews();
        Thread mpn = new Thread(mPN, "MARKETPLACE NEWS");
        mpn.start();

        Runnable portFt = new PortFoliant();
        Thread pft = new Thread(portFt, "PORTOFOLIANTDATA");
        pft.start();

        System.out.println("THREADTESTONE IS FINISHED!");
    }
}
