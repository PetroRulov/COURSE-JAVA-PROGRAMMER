package datamanagers;

import com.alcoshop.database.mysqldatabase.DB_MySQL_Worker;
import domain.Client;
import domain.Order;
import domain.Sale;
import domain.Visitor;
import domain.waters.*;

import java.math.BigDecimal;
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
        waters = initStock();
        this.products = new ArrayList<>();
        products = getProducts();
        this.clts = new ArrayList<Client>();
        clts = initClientsBase();
        this.visitors = new ArrayList<>();
        visitors = initVisitorsBase();
        this.sales = new LinkedList<Sale>();
        sales = initSalesJournal();
        this.orders = new LinkedList<>();
        orders = initOrdersJournal();
    }

    @Override
    public List<Water> initStock() {
        String watersQuery = "select * from stock";
        try {
            Statement statement = mySQLWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(watersQuery);
            while(resultSet.next()){
                Water sql = new Water();
                sql.setId_water(resultSet.getLong("id_water"));
                sql.setDrink(resultSet.getString("drink"));
                sql.setName(resultSet.getString("name"));
                String tare = resultSet.getString("tare");
                if(tare.equals("GLASS")){
                    sql.setTare(Tare.GLASS);
                }else if(tare.equals("PAT")){
                    sql.setTare(Tare.PAT);
                }else if(tare.equals("CLAY")){
                    sql.setTare(Tare.CLAY);
                }else if(tare.equals("TOY")){
                    sql.setTare(Tare.TOY);
                }else{
                    sql.setTare(Tare.TETRAPAC);
                }
                sql.setVolume(resultSet.getDouble("volume"));
                sql.setQuant(resultSet.getInt("quant"));
                sql.setValue(resultSet.getBigDecimal("value"));
                sql.setPrice(resultSet.getBigDecimal("price"));
                waters.add(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return waters;
    }

    @Override
    public List<Client> initClientsBase() {
        String clientsQuery = "select * from clients";
        try {
            Statement statement = mySQLWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(clientsQuery);
            while(resultSet.next()){
                Client sql = new Client();
                sql.setId_client(resultSet.getLong("id_client"));
                sql.setSurName(resultSet.getString("surName"));
                sql.setName(resultSet.getString("name"));
                sql.setDateOfBirth(resultSet.getString("dateOfBirth"));
                sql.setSex(resultSet.getString("sex"));
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
        String salesQuery = "select * from sales";
        try {
            Statement statement = mySQLWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(salesQuery);
            while(resultSet.next()){
                Sale sql = new Sale();
                sql.setId_sale(resultSet.getLong("id_sale"));
                sql.setDate(resultSet.getString("date"));
                sql.setGuest(clts.get((int)resultSet.getLong("id_client")));
                sql.setWat(waters.get((int)resultSet.getLong("id_water")));
                sql.setQuant(resultSet.getInt("quant"));
                sql.setIncome(resultSet.getBigDecimal("income"));
                String let = resultSet.getString("wos");
                if(let.equals("SHOP")){
                    sql.setWos(WaysOfSale.SHOP);
                }else{
                    sql.setWos(WaysOfSale.SITE);
                }
                sql.setOrderID(resultSet.getLong("orderID"));
                sales.add(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sales;
    }

    @Override
    public List<Visitor> initVisitorsBase() {
        String visitorsQuery = "select * from visitors";
        try {
            Statement statement = mySQLWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(visitorsQuery);
            while(resultSet.next()){
                Visitor sql = new Visitor();
                sql.setId_code(resultSet.getLong("id_code"));
                sql.setIdentify(resultSet.getString("identify"));
                sql.setSurName(resultSet.getString("surName"));
                sql.setName(resultSet.getString("name"));
                sql.setTelfax(resultSet.getString("telfax"));
                sql.setAddress(resultSet.getString("address"));
                sql.seteMail(resultSet.getString("eMail"));
                visitors.add(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visitors;
    }

    @Override
    public List<Order> initOrdersJournal() {
        String ordersQuery = "select * from orders";
        try {
            Statement statement = mySQLWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(ordersQuery);
            while(resultSet.next()){
                Order sql = new Order();
                sql.setId_order(resultSet.getLong("id_order"));
                sql.setDate(resultSet.getString("date"));

                String oSt = resultSet.getString("oSt");
                if(oSt.equals("RECIEVED")){
                    sql.setoSt(OrderStatus.RECIEVED);
                }else if(oSt.equals("FORMED")){
                    sql.setoSt(OrderStatus.FORMED);
                }else if(oSt.equals("SHIPPED")){
                    sql.setoSt(OrderStatus.SHIPPED);
                }else{
                    sql.setoSt(OrderStatus.COMPLETED);
                }

                String payTT = resultSet.getString("payTT");
                if(payTT.equals("PREPAID")){
                    sql.setPayTT(PaymentTermsType.PREPAID);
                }else if(payTT.equals("UNPAID")){
                    sql.setPayTT(PaymentTermsType.UNPAID);
                }else{
                    sql.setPayTT(PaymentTermsType.PAID);
                }
                sql.setIncome(resultSet.getBigDecimal("prepayment"));
                sql.setWater(waters.get((int)resultSet.getLong("waterID")));
                sql.setQuantity(resultSet.getInt("quantity"));
                sql.setClient(visitors.get((int)resultSet.getLong("id_visitor")));
                sql.setIncome(resultSet.getBigDecimal("income"));
                orders.add(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        for(Water water : getWaters()){
            products.add((Product) water);
        }
        return products;
    }

    @Override
    public List<Client> getClts() { return new ArrayList<Client>(clts); }

    @Override
    public List<Sale> getSales() { return new LinkedList<Sale>(sales);}

    @Override
    public List<Water> getWaters() {
        return new ArrayList<Water>(waters);
    }

    @Override
    public List<Visitor> getVisitors() {
        return new ArrayList<Visitor>(visitors);
    }

    @Override
    public List<Order> getOrders() {
        return new LinkedList<Order>(orders);
    }

    @Override
    public List<Sale> updateSales(Sale sale) {
        sales.add(sale);
        return sales;
    }

    @Override
    public List<Order> updateOrders(Order order) {
        orders.add(order);
        return orders;
    }

    @Override
    public void soldWaterMinus(Water wat, int quant) {
        Water sold = null;
        for(Water i : waters){
            if(i.equals(wat)){
                sold = i;
                break;
            }
        }
        sold.setQuant(sold.getQuant() - quant);
    }

    @Override
    public List<Client> updateClientBase(Client client) {
        clts.add(client);
        return clts;
    }

    @Override
    public List<Visitor> updateVisitorsBase(Visitor visitor) {
        visitors.add(visitor);
        return visitors;
    }
}
