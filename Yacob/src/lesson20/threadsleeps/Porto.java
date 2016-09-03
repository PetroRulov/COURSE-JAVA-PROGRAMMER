package lesson20.threadsleeps;

/**
 * Created by prulov on 29.08.2016.
 */
public class Porto extends Thread{

    public Porto(String str){
        super(str);
    }

    public void run(){
        try{
            for(int i = 0; i <10; i++){
                sleep(750);
                System.out.println("You have " +5000+i+ " shares of TESLA" );
            }
        }catch(InterruptedException ie){
            System.out.println(Thread.currentThread().getName() + ie.toString());
        }
    }
}
