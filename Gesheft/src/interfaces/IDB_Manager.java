package interfaces;

import domain.Client;
import domain.waters.Water;

/**
 * Created by prulov on 05.07.2016.
 */
public interface IDB_Manager {

    void sellTransaction(int id, String date, Client guest, Water wat, int quant);

    void addNewClient(int id, String surName, String name, String age, String sex, String eMail);

    void soldWaterMinus(Water wat, int quant);
}
