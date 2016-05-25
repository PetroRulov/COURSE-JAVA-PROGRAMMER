package lesson6.adapters.superobserver;

import java.util.Observable;
import java.util.Observer;

public class Superviser implements Observer {

    @Override
    public void update(Observable o, Object arg) {

        if(arg instanceof ActionEvent){
            System.out.println(this.toString() + " notified. Event " + ((ActionEvent) arg).getName());
        }else {
            System.out.println(this.toString() + " notified.");
        }
        Worker w = (Worker) o;
        System.out.println("Job result " + w.getJobResult());

    }
}
