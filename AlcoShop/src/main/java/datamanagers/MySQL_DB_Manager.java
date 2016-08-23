package datamanagers;

import domain.Client;
import domain.Order;
import domain.Sale;
import domain.Visitor;
import domain.waters.Product;
import domain.waters.Water;

import java.util.List;

/**
 * Created by prulov on 01.08.2016.
 */

public class MySQL_DB_Manager implements IDBInterface {

    @Override
    public List<Water> initStock() {
        return null;
    }

    @Override
    public List<Client> initClientsBase() {
        return null;
    }

    @Override
    public List<Sale> initSalesJournal() {
        return null;
    }

    @Override
    public List<Visitor> initVisitorsBase() {
        return null;
    }

    @Override
    public List<Order> initOrdersJournal() {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public List<Client> getClts() {
        return null;
    }

    @Override
    public List<Sale> getSales() {
        return null;
    }

    @Override
    public List<Water> getWaters() {
        return null;
    }

    @Override
    public List<Visitor> getVisitors() {
        return null;
    }

    @Override
    public List<Order> getOrders() {
        return null;
    }

    @Override
    public List<Sale> updateSales(Sale sale) {
        return null;
    }

    @Override
    public List<Order> updateOrders(Order order) {
        return null;
    }

    @Override
    public void soldWaterMinus(Water wat, int quant) {

    }

    @Override
    public List<Client> updateClientBase(Client client) {
        return null;
    }

    @Override
    public List<Visitor> updateVisitorsBase(Visitor visitor) {
        return null;
    }
}
