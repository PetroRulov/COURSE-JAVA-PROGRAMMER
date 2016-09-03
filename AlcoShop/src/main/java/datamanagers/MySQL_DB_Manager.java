package datamanagers;

import com.alcoshop.database.mysqldatabase.DB_MySQL_Worker;
import domain.Client;
import domain.Order;
import domain.Sale;
import domain.Visitor;
import domain.waters.Product;
import domain.waters.Water;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by prulov on 01.08.2016.
 */

public class MySQL_DB_Manager implements IDBInterface {

    private DB_MySQL_Worker mySQLWorker;

    //shop
    private List<Client> clts;
    private List<Sale> sales;
    private List<Visitor> visitors;
    private List<Order> orders;
    //stock
    private List<Water> waters;
    private List<Product> products;

    public MySQL_DB_Manager(){

        mySQLWorker = new DB_MySQL_Worker();

        this.waters = new ArrayList<Water>();
        //waters = initStock();
        this.products = new ArrayList<>();
        //products = getProducts();
        this.clts = new ArrayList<Client>();
        clts = initClientsBase();
        this.sales = new LinkedList<Sale>();
        //sales = initSalesJournal();
        this.visitors = new ArrayList<>();
        //visitors = initVisitorsBase();
        this.orders = new LinkedList<>();
        //orders = initOrdersJournal();
    }

    @Override
    public List<Water> initStock() {
        return null;
    }
    @Override
    public List<Client> initClientsBase() {
        String clientsQuery = "select * from clients";
        try {
            Statement statement = mySQLWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(clientsQuery);
            while(resultSet.next()){
                Client sql = new Client();
                sql.setId_client(resultSet.getInt(1));
                sql.setSurName(resultSet.getString(2));
                sql.setName(resultSet.getString(3));
                sql.setDateOfBirth(resultSet.getString(4));
                sql.setSex(resultSet.getString(5));
                sql.seteMail(resultSet.getString("eMail"));
                clts.add(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clts;
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
        return new ArrayList<Water>(waters);
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
