package lesson20.threadsleeps;

/**
 * Created by prulov on 29.08.2016.
 */
public class TestingThreadsFlow {

    public static void main(String[] args) {

        Market mT = new Market("Market news");
        mT.start();
        //mT.interrupt();

        Porto porto = new Porto("Porto Data");
        porto.start();

        System.out.println("The main method of TestingThreadsFlow is finished!");


    }
}
