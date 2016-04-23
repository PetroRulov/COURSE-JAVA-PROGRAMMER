package waters;

import enumerations.*;

public class Water {

    protected Drink drink;
    protected String name;
    protected Tare tare;
    protected double volume;
    protected int quant;
    protected double value;
    protected double price;

    public Water(){}

    public Water(Drink drink, String name, Tare tare, double volume, int quant, double value, double price){

        this.drink = drink;
        this.name = name;
        this.tare = tare;
        this.volume = volume;
        this.quant = quant;
        this.value = value;
        this.price = price;

    }

    public Drink getDrink() {
        return drink;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuant() {
        return quant;
    }

    public double getValue() {
        return value;
    }

    public double getVolume() {
        return volume;
    }

    public Tare getTare() {
        return tare;
    }

    public void waterInfoShow(){

        System.out.printf("%-1s%-10s%-25s%-10s%-10s%-10s%-10s%n", "", "|"+getDrink(), "|"+getName(), "|"+getTare(), "|"+getVolume(),
                "|"+getPrice(), "|   " + getQuant() + "    |");

    }

    public void waterPriceList(){

        System.out.printf("%-10s%-25s%-10s%-10s%-8s%-2s%n", "|"+getDrink(), "|"+getName(), "|"+getTare(), "|"+getVolume()+"l",
                "|"+getPrice(), "|");

    }

    public void waterCatalogue(){

        System.out.printf("%-1s%-10s%-25s%-10s%-10s%-2s%n", "", "|"+getDrink(), "|"+getName(), "|"+getTare(), "|"+getVolume()+"l", "|");

    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public void setTare(Tare tare) {
        this.tare = tare;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}


