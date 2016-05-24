package lesson6.adapters.superobserver;

import java.util.Observable;

public class Worker extends Observable {

    private double jobResult = 0;

    public Worker(){}

    public void doRegularJob(){

        double d = Math.random();
        if(d < 0.5 || d > 10.0){
            System.out.println("Regular Job is done!");
            jobResult = d;
            setChanged();
            notifyObservers();
        }else{
            System.err.println("Regular Job is failed!");
        }
    }

    public void doSpecificJob(){

        double d = Math.random();
        if(d < 0.5 || d > 10.0){
            System.out.println("Specific Job is done!");
            jobResult = d;
            setChanged();
            notifyObservers(new ActionEvent(null));
        }else{
            System.err.println("Specific Job is failed!");
        }
    }

    public double getJobResult() {
        return jobResult;
    }
}
