package lesson20.multithreading;

/**
 * Created by prulov on 29.08.2016.
 */
public class PortoFolio extends Thread {

    public PortoFolio(String threadName){
        super(threadName);
    }

    public void run(){
        System.out.println("You have 5.000 shares of TSLA ");
    }
}
