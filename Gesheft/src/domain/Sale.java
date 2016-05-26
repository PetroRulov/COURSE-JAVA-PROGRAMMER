package domain;

import domain.waters.Water;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sale {

    private int date = dateFormat(new Date(System.currentTimeMillis()));
    private Client guest;
    private Water wat;
    private int quant;
    private double income;


    public Sale(){}

    public Sale(int date, Client guest, Water wat, int quant){

        this.date = date;
        this.guest = guest;
        this.wat = wat;
        this.quant = quant;
        this.income = setIncome();
    }

    private double setIncome(){

        return income = this.quant * this.wat.getPrice();

    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getDate() {
        return date;
    }

    public Client getGuest() {
        return guest;
    }

    public double getIncome() {
        return income;
    }

    public int getQuant() {
        return quant;
    }

    public Water getWat() {
        return wat;
    }

    public int dateFormat(Date d){

        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return Integer.parseInt((df.format(d)));

    }

    public void saleInfoShow() {

        System.out.printf("%-10s%-26s%-35s%-10s%-10s%-10s%-10s%-10s%n", "| "+getDate(), "| "+getGuest().getSurName()+" "+getGuest().getName(),
                "| "+getWat().getDrink()+ " " + getWat().getName(), "| "+getWat().getVolume(), "| "+getWat().getPrice(),
                "| "+getQuant(), "| "+getIncome(), "|");

    }

}

