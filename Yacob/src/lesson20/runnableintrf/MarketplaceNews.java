package lesson20.runnableintrf;

/**
 * Created by prulov on 29.08.2016.
 */
public class MarketplaceNews implements Runnable {

    @Override
    public void run() {
        System.out.println("The stock market is improving!");
    }
}
