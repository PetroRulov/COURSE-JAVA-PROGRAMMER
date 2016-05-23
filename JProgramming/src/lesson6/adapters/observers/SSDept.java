package lesson6.adapters.observers;

import lesson6.adapters.observers.domains.PrintMedia;
import lesson6.adapters.observers.domains.Subscriber;
import lesson6.adapters.observers.domains.Subscription;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by prulov on 23.05.2016.
 */
public class SSDept {

    private PrintMedia pm;
    private LinkedList<Subscription> sss;
    private List<PrintMedia> pms;

    public SSDept(){
        this.pm = pm;
        this.sss = new LinkedList<Subscription>();
        this.pms = new ArrayList<PrintMedia>();
        initPML();

    }

    private void initPML(){

        pms.add(new PrintMedia("Magazine", "IT Pro", "25th of every month", 81.6));
        pms.add(new PrintMedia("Newspaper", "IT News", " the next Thursday", 49.2));
    }

    public List<PrintMedia> getPms() {
        return new ArrayList<PrintMedia>(pms);
    }

    public LinkedList<Subscription> getSss() {
        return new LinkedList<Subscription>(sss);
    }

    public void subScriptionTransaction(Subscriber guest, PrintMedia pm){

        if(guest != null && pm != null){
            sss.add(new Subscription(guest, pm));
        }else{
            System.out.println("This subscription is not subject to handling!");
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
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------|");
    }


}
