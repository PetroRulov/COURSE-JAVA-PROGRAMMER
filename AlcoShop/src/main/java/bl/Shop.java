package bl;

import datamanagers.IDBInterface;
import domain.Client;
import domain.Sale;
import domain.waters.Water;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

/**
 * Created by prulov on 08.07.2016.
 */
public class Shop extends Observable {

    private IDBInterface idbI;
    // shop
    private List<Client> clts;
    private List<Sale> sales;
    //stock
    private List<Water> waters;


    public Shop(){

        this.waters = new ArrayList<Water>();
        this.clts = new ArrayList<Client>();
        this.sales = new LinkedList<Sale>();
    }

    public IDBInterface getIdbI() {
        return idbI;
    }

    public void setDBManager(IDBInterface idbI) {
        this.idbI = idbI;
    }

    public List<Client> getClts() {

        if(clts == null || clts.isEmpty()){
            idbI.initClientsBase();
        }
        return new ArrayList<Client>(clts);
    }

    public void setClts(List<Client> clientsBase) {
        this.clts = clientsBase;
    }

    public void addNewClient(Client client){

        clts = idbI.updateClientBase(client);
        setChanged();
        notifyObservers(client);
        setClts(clts);
    }

    public List<Water> getWaters(){

        if(waters == null || waters.isEmpty()){
            idbI.initStock();
        }
        return new ArrayList<Water>(waters);
    }

    public List<Sale> getSales() {

        if(sales == null){
            idbI.initSalesJournal();
        }
        return new LinkedList<Sale>(sales);
    }

    public void setSales(List<Sale> history) {
        this.sales = history;
    }

    public void addSaleTransaction(Sale sale){

        sales = idbI.updateSales(sale);
        setChanged();
        notifyObservers(sale);
        setSales(sales);
    }
}
