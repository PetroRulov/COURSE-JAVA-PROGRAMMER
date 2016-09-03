package lesson20.multithreading;

/**
 * Created by prulov on 29.08.2016.
 */
public class TestThreads {

    public static void main(String[] args) {

        MarketNews mN = new MarketNews("MARKET NEWS");
        mN.start();

        PortoFolio pF = new PortoFolio("PORTOFOLIO DATA");
        pF.start();

        System.out.println("TestThread is finished!");
    }
}
