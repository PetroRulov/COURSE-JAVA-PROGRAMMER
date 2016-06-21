package domain.waters;

import enumerations.Drink;
import enumerations.Tare;

/**
 * Created by prulov on 26.05.2016.
 */
public class Water {

    protected int id_water;
    protected Drink drink;
    protected String name;
    protected Tare tare;
    protected double volume;
    protected int quant;
    protected double value;
    protected double price;

    public Water(){}

    public Water(int id_water, Drink drink, String name, Tare tare, double volume, int quant, double value, double price){

        this.id_water = id_water;
        this.drink = drink;
        this.name = name;
        this.tare = tare;
        this.volume = volume;
        this.quant = quant;
        this.value = value;
        this.price = price;

    }

    public int getId_water() {
        return id_water;
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

    @Override
    public String toString(){

        return "id #" + getId_water() + " " + getDrink() + " " + getName() + ", " + getTare() + " " + getVolume() + "L, price: UAH " + getPrice();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Water){
            Water w = (Water) obj;
            return (drink != null && drink.equals(w.getDrink()) && name.equals(w.getName()) && tare.equals(w.getTare()) &&
                    volume == (w.getVolume()) && price == (w.getPrice()));
        }
        return false;
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
