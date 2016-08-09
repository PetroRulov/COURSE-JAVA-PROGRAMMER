package domain;

import domain.waters.Delivery;
import domain.waters.OrderStatus;
import domain.waters.OrderType;
import domain.waters.Water;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by prulov on 08.08.2016.
 */
public class Order implements Serializable {

    private long id_order;
    private String date = dateFormat(new Date(System.currentTimeMillis()));
    private OrderStatus oSt;
    private OrderType oT;
    private Water water;
    private int quantity;
    private Client client;
    private Delivery delivery;
    private BigDecimal income;

    public Order(){}

    public Order(long id_order, String date, OrderStatus oSt, OrderType oT, Water water, int quantity, Client client,
                 Delivery delivery, BigDecimal income){
        this.id_order = id_order;
        this.date = date;
        this.oSt = oSt;
        this.oT = oT;
        this.water = water;
        this.quantity = quantity;
        this.client = client;
        this.delivery = delivery;
        this.income = calcIncome();

    }

    private String dateFormat(Date d){

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(d);
    }

    public BigDecimal calcIncome(){

        MathContext mc = new MathContext(4);
        BigDecimal inCome = this.water.getPrice().multiply(new BigDecimal(getQuantity()));

        if(inCome.compareTo(new BigDecimal("500")) == -1){
            income = inCome;
        }else if((inCome.compareTo(new BigDecimal("500")) == 0 || inCome.compareTo(new BigDecimal("500")) == 1) &&
                inCome.compareTo(new BigDecimal("1000")) == -1){
            income = inCome.multiply(new BigDecimal(0.95));
        }else{
            income = inCome.multiply(new BigDecimal(0.9)) ;
        }
        return income;
    }

    public long getId_order() {
        return id_order;
    }

    public void setId_order(long id_order) {
        this.id_order = id_order;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public OrderStatus getoSt() {
        return oSt;
    }

    public void setoSt(OrderStatus oSt) {
        this.oSt = oSt;
    }

    public OrderType getoT() {
        return oT;
    }

    public void setoT(OrderType oT) {
        this.oT = oT;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }
}
