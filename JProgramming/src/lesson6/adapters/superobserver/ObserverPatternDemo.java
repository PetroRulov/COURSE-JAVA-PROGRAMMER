package lesson6.adapters.superobserver;

import java.util.Observer;

public class ObserverPatternDemo {

    public static void main(String[] args){

        System.out.println("OBSERVER PATTERN DEMO: LESSON 6 THEME 2 \"Observer\"");
        System.out.println();

        Worker s = new Worker();

        Observer o1 = new Superviser();
        Observer p2 = new Superviser();

        s.addObserver(o1);
        s.addObserver(p2);

        for(int i = 0; i < 10; i++){

            s.doRegularJob();
            System.out.println();

        }

        s.deleteObserver(p2);

        for(int i = 0; i < 10; i++){

            s.doSpecificJob();
            System.out.println();

        }




    }
}
