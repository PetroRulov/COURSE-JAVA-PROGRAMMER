package lesson6.adapters.supervisor;

import java.util.Observer;

/**
 * Created by prulov on 24.05.2016.
 */
public class SuperVisorDemo {

    public static void main(String[] args){

        Publisher pablo = new Publisher();
        Observer obs = new SubScrGUI(pablo);
        pablo.addObserver(obs);

    }
}
