package datamanagers;

import com.mysqlcon.MySQL_DB_Worker;
import domain.Client;
import domain.Order;
import domain.Sale;
import domain.Visitor;
import domain.waters.*;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
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

    private MySQL_DB_Worker mySQLWorker;

    //shop
    private List<Client> clts;
    private List<Sale> sales;
    private List<Visitor> visitors;
    private List<Order> orders;
    //stock
    private List<Water> waters;
    private List<Product> products;

    public MySQL_DB_Manager(){

        mySQLWorker = new MySQL_DB_Worker();

        this.waters = new ArrayList<Water>();
        waters = initStock();
        this.products = new ArrayList<>();
        products = fillStock();
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
                sql.setWat(waters.get((int)resultSet.getLong("id_water")-1));
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
                sql.setPrepayment(resultSet.getBigDecimal("prepayment"));
                sql.setWater(waters.get((int)resultSet.getLong("waterID")-1));
                sql.setQuantity(resultSet.getInt("quantity"));
                sql.setClient(visitors.get((int)resultSet.getLong("id_visitor")-1));
                sql.setIncome(resultSet.getBigDecimal("income"));
                orders.add(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Product> getProducts(){
        return new ArrayList<Product>(products);
    }

    @Override
    public List<Product> fillStock() {
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
                products.add(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        String update = "INSERT INTO sales(date, id_client, id_water, quant, income, wos, orderID) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = mySQLWorker.getConnection().prepareStatement(update);
            preparedStatement.setString(1, sale.getDate());
            preparedStatement.setLong(2, sale.getGuest().getId_client());
            preparedStatement.setLong(3, sale.getWat().getId_water());
            preparedStatement.setInt(4, sale.getQuant());
            preparedStatement.setBigDecimal(5, sale.getIncome());
            preparedStatement.setString(6, sale.getWos().name());
            preparedStatement.setLong(7, sale.getOrderID());
            preparedStatement.execute();
            //mySQLWorker.getConnection().commit();

        } catch (SQLException e) {
//            try {
//                mySQLWorker.getConnection().rollback();
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
            e.printStackTrace();
        }
        return sales;
    }

    @Override
    public List<Order> updateOrders(Order order) {
        orders.add(order);
        String update = "INSERT INTO orders(id_order, date, oSt, payTT, prepayment, waterID, quantity, id_visitor, income) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = mySQLWorker.getConnection().prepareStatement(update);
            preparedStatement.setLong(1, order.getId_order());
            preparedStatement.setString(2, order.getDate());
            preparedStatement.setString(3, order.getoSt().name());
            preparedStatement.setString(4, order.getPayTT().name());
            preparedStatement.setBigDecimal(5, order.getPrepayment());
            preparedStatement.setLong(6, order.getWater().getId_water());
            preparedStatement.setInt(7, order.getQuantity());
            preparedStatement.setLong(8, order.getClient().getId_code());
            preparedStatement.setBigDecimal(9, order.getIncome());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void soldWaterMinus(Water wat, int quant) {
        String soldWaterminus = "UPDATE `alcoshop`.`stock` SET `quant`=? WHERE `id_water`=?;";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = mySQLWorker.getConnection().prepareStatement(soldWaterminus);
            preparedStatement.setInt(1, wat.getQuant() - quant);// first(1) parameter where first ? met
            preparedStatement.setInt(2, (int)wat.getId_water());// second(2) parameter where second ? met
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        waters.get((int)wat.getId_water()-1).setQuant(wat.getQuant() - quant);
    }

    @Override
    public List<Client> updateClientBase(Client client) {
        clts.add(client);
        String update = "INSERT INTO clients(id_client, surName, name, dateOfBirth, sex, email) " +
                "VALUES(?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = mySQLWorker.getConnection().prepareStatement(update);
            preparedStatement.setLong(1, client.getId_client());
            preparedStatement.setString(2, client.getSurName());
            preparedStatement.setString(3, client.getName());
            preparedStatement.setString(4, client.getDateOfBirth());
            preparedStatement.setString(5, client.getSex());
            preparedStatement.setString(6, client.geteMail());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clts;
    }

    @Override
    public List<Visitor> updateVisitorsBase(Visitor visitor) {
        visitors.add(visitor);
        String update = "INSERT INTO visitors(identify, surName, name, telfax, address, email) " +
                "VALUES(?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = mySQLWorker.getConnection().prepareStatement(update);
            preparedStatement.setString(1, visitor.getIdentify());
            preparedStatement.setString(2, visitor.getSurName());
            preparedStatement.setString(3, visitor.getName());
            preparedStatement.setString(4, visitor.getTelfax());
            preparedStatement.setString(5, visitor.getAddress());
            preparedStatement.setString(6, visitor.geteMail());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visitors;
    }

    @Override
    public List<Product> addToStock(Product product) {
        products.add(product);
        String update = "INSERT INTO stock(id_water, drink, name, tare, volume, quant, value, price, count) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = mySQLWorker.getConnection().prepareStatement(update);
            preparedStatement.setLong(1, product.getId_water());
            preparedStatement.setString(2, product.getDrink());
            preparedStatement.setString(3, product.getName());
            preparedStatement.setString(4, product.getTare().name());
            preparedStatement.setDouble(5, product.getVolume());
            preparedStatement.setInt(6, product.getQuant());
            preparedStatement.setBigDecimal(7, product.getValue());
            preparedStatement.setBigDecimal(8, product.getPrice());
            preparedStatement.setInt(9, product.getCount());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> updateStock() {

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
                products.add(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
