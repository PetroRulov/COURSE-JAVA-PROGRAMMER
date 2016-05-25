package lesson6.adapters.supervisor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import lesson6.adapters.supervisor.domains.*;

/**
 * Created by prulov on 24.05.2016.
 */
public class Publisher extends Observable {

    private LinkedList<Subscription> sss;
    private List<Media> mL;

    public Publisher(){

        this.sss = new LinkedList<Subscription>();
        this.mL = new ArrayList<Media>();
        initPML();
    }

    private void initPML(){

        mL.add(new Media("Magazine", "IT Pro", "25th of every month", 81.6));
        mL.add(new Media("Newspaper", "IT News", "the next Thursday", 49.2));
        mL.add(new Media("Weekly Videoblog", "Weekday America", returnWednesday(), 56.2));
    }

    public List<Media> getML() {
        return new ArrayList<Media>(mL);
    }

    public LinkedList<Subscription> getSss() {
        return new LinkedList<Subscription>(sss);
    }

    public void subScriptionTransaction(Subscriber guest, Media ch){

        if(guest != null && ch != null && !guest.equals("") && !ch.equals("")){
            Subscription novus = new Subscription(guest, ch);
            sss.add(novus);
            setChanged();
            notifyObservers(novus);
        }else{
            System.err.println("This subscription is not SUBJECT to handling!");
        }
    }

    public void printSubScriptionsJournal(List<Subscription> done) {

        System.out.println("SUBSCRIPTIONS JOURNAL");
        System.out.println("-----------------------------------------------------------------------------------------------------------------|");
        System.out.printf("%-26s%-35s%-10s%n", "| Subscriber's name ", "| Type and name of PrintMedia ", "| Price ", "|");
        System.out.println("-----------------------------------------------------------------------------------------------------------------|");
        int j = 0;
        for (int i = 0; i < done.size(); i++) {
            j++;
            if (done.get(i) != null) {
                System.out.print(j);
                done.get(i).subScriptionInfoShow();
                setChanged();
                notifyObservers();
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------|");
    }

    private String returnWednesday(){

        return " every next Wednesday";
    }


}
