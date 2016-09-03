package lesson20.threadsleeps;

/**
 * Created by prulov on 29.08.2016.
 */
public class Market extends Thread {

    public Market(String str){
        super(str);
    }

    public void run(){
        try{
            for(int i = 0; i <10; i++){
                sleep(1000);
                System.out.println("The Market is improving " +i );
            }
        }catch(InterruptedException ie){
            System.out.println(Thread.currentThread().getName() + ie.toString());
        }
    }
}
