package datamanagers;

import domain.Client;
import domain.Sale;
import domain.waters.Water;

import java.util.List;

/**
 * Created by prulov on 08.07.2016.
 */
public interface IDBInterface {

    //shop initiation
    List<Water> initStock();
    List<Client> initClientsBase();
    List<Sale> initSalesJournal();

    List<Client> getClts();

    List<Sale> getSales();

    List<Water> getWaters();


    // sale transaction
    List<Sale> updateSales(Sale sale);
    void soldWaterMinus(Water wat, int quant);

    // add new Client
    List<Client> updateClientBase(Client client);

}