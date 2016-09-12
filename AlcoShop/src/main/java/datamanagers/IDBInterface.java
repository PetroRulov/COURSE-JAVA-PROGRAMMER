package datamanagers;

import domain.Client;
import domain.Order;
import domain.Sale;
import domain.Visitor;
import domain.waters.Product;
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
    List<Visitor> initVisitorsBase();
    List<Order> initOrdersJournal();
    List<Product> getProducts();

    List<Client> getClts();

    List<Sale> getSales();

    List<Water> getWaters();

    List<Visitor> getVisitors();

    List<Order> getOrders();


    // sale transaction
    List<Sale> updateSales(Sale sale);
    List<Order> updateOrders(Order order);
    void soldWaterMinus(Water wat, int quant);

    // add new Client
    List<Client> updateClientBase(Client client);
    List<Visitor> updateVisitorsBase(Visitor visitor);
    //List<Product>updateProductsList();

}