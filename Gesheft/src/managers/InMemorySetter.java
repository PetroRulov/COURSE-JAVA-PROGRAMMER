package managers;

import domain.Client;
import domain.waters.Water;
import interfaces.IDB_Manager;
import main.Badigan;

/**
 * Created by prulov on 05.07.2016.
 */
public class InMemorySetter implements IDB_Manager {

    private Badigan bad;

    @Override
    public void sellTransaction(int id, String date, Client guest, Water wat, int quant) {

    }

    @Override
    public void addNewClient(int id, String surName, String name, String age, String sex, String eMail) {

        if(surName != null && name != null && age != null && sex != null && eMail != null){
            Client novus = new Client(id, surName, name, age, sex, eMail);
            bad.getClts().add(novus);
//            setChanged();
//            notifyObservers(novus);
        }else{
            System.err.println("New Client cannot be added because of invalid data");
        }
    }

    @Override
    public void soldWaterMinus(Water wat, int quant) {

    }
}
