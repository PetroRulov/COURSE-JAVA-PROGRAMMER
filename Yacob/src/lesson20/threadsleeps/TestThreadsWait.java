package lesson20.threadsleeps;

/**
 * Created by prulov on 29.08.2016.
 */
public class TestThreadsWait {

    public TestThreadsWait(){

        Market mT = new Market("Market news");
        mT.start();
        Porto porto = new Porto("Porto Data");
        porto.start();
        synchronized(this){
            try{
                wait(15000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("The main method of TestThreadsWait is FINISHED!");
    }
}
