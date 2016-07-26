package domain;

import domain.waters.Water;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sale {

    private long id_sale;
    private String date = dateFormat(new Date(System.currentTimeMillis()));
    private Client guest;
    private Water wat;
    private int quant;
    private BigDecimal income;

    public Sale(){}

    public Sale(long id_sale, String date, Client guest, Water wat, int quant){

        this.id_sale = id_sale;
        this.date = date;
        this.guest = guest;
        this.wat = wat;
        this.quant = quant;
        this.income = calcIncome();
    }

    public long getId_sale() {
        return id_sale;
    }

    public BigDecimal calcIncome(){

        MathContext mc = new MathContext(4);
        BigDecimal inCome = this.wat.getPrice().multiply(new BigDecimal(getQuant()));

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

    public void setId_sale(long id_sale) {
        this.id_sale = id_sale;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Client getGuest() {
        return guest;
    }

    public void setGuest(Client guest) {
        this.guest = guest;
    }

    public Water getWat() {
        return wat;
    }

    public void setWat(Water wat) {
        this.wat = wat;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String dateFormat(Date d){

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(d);
    }

    public void saleInfoShow() {

        System.out.printf("%-10s%-26s%-35s%-10s%-10s%-10s%-10s%-10s%n", "| "+getDate(), "| "+getGuest().getSurName()+" "+getGuest().getName(),
                "| "+getWat().getDrink()+ " " + getWat().getName(), "| "+getWat().getVolume(), "| "+getWat().getPrice(),
                "| "+getQuant(), "| "+getIncome(), "|");

    }

}