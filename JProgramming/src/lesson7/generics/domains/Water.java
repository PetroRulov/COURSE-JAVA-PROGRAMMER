package lesson7.generics.domains;

import lesson7.generics.enums.Drink;

/**
 * Created by prulov on 04.06.2016.
 */
public abstract class Water {

    protected Drink drink;
    protected String name;
    protected double volume;
    protected int quant;
    protected double value;
    protected double price;

    public Water(){}

    public Water(Drink drink, String name, double volume, int quant, double value, double price){

        this.drink = drink;
        this.name = name;
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

    public void waterInfoShow(){

        System.out.printf("%-1s%-10s%-25s%-10s%-10s%-10s%n", "", "|"+getDrink(), "|"+getName(), "|"+getVolume(),
                "|"+getPrice(), "|   " + getQuant() + "    |");

    }

    @Override
    public String toString(){

        return getDrink() + " " + getName() + ", " + " " + getVolume() + "L, price: UAH " + getPrice();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Water){
            Water w = (Water) obj;
            return (drink != null && drink.equals(w.getDrink()) && name.equals(w.getName()) &&
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

    public void setValue(double value) {
        this.value = value;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}


