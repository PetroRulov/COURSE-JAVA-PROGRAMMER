package domain;

import domain.waters.Water;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sale {

    private int id_sale;
    private String date = dateFormat(new Date(System.currentTimeMillis()));
    private Client guest;
    private Water wat;
    private int quant;
    private double income;

    public Sale(){}

    public Sale(int id_sale, String date, Client guest, Water wat, int quant){

        this.id_sale = id_sale;
        this.date = date;
        this.guest = guest;
        this.wat = wat;
        this.quant = quant;
        this.income = setIncome();
    }

    public int getId_sale() {
        return id_sale;
    }

    public double setIncome(){

        income = this.quant * this.wat.getPrice();

        String str = String.valueOf(income);
        int dotIndex = str.indexOf(".");

        String before = String.valueOf((int) income);
        String incStr = null;
        if((str.length()-dotIndex)>=3){
            incStr = String.valueOf((int) income) + "." + str.substring(dotIndex+1, (dotIndex+3));
        }else{
            incStr = str;
        }

        String first = incStr.substring(incStr.length()-2, incStr.length()-1);
        String second = incStr.substring(incStr.length()-1);
        if(second.equals("9")){
            if(!first.equals("9")){
                incStr = before + "." + String.valueOf(Integer.parseInt(first)+1);
            }else{
                incStr = String.valueOf(Integer.parseInt(before)+1);
            }
        }
        return income = Double.parseDouble(incStr);
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public String getDate() {
        return date;
    }

    public Client getGuest() {
        return guest;
    }

    public double getIncome() {
        return income;
    }

    public Water getWat() {
        return wat;
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

