package domain.waters;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by prulov on 08.07.2016.
 */
public class Water implements Product, Serializable {

    protected long id_water;
    protected String drink;
    protected String name;
    protected Tare tare;
    protected double volume;
    protected int quant;
    protected BigDecimal value;
    protected BigDecimal price;

    public Water(){}

    public Water(long id_water, String drink, String name, Tare tare, double volume, int quant, BigDecimal value, BigDecimal price){

        this.id_water = id_water;
        this.drink = drink;
        this.name = name;
        this.tare = tare;
        this.volume = volume;
        this.quant = quant;
        this.value = value;
        this.price = price;

    }

    public long getId_water() {
        return id_water;
    }

    public void setId_water(long id_water) {
        this.id_water = id_water;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tare getTare() {
        return tare;
    }

    public void setTare(Tare tare) {
        this.tare = tare;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getPrice() {return price;}

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString(){

        return "id #" + getId_water() + " " + getDrink() + " " + getName() + ", " + getTare() + " " + getVolume() +
                "L, price: UAH " + getPrice().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Water){
            Water w = (Water) obj;
            return (id_water > 0 && id_water == w.getId_water() && drink != null && drink.equals(w.getDrink()) &&
                    name.equals(w.getName()) && tare.equals(w.getTare()) &&
                    volume == w.getVolume() && quant == w.getQuant() && value == w.getValue() && price == w.getPrice());
        }
        return false;
    }



    // service methods

    public void waterInfoShow(){

        System.out.printf("%-1s%-10s%-25s%-10s%-10s%-10s%-10s%n", "", "|"+getDrink(), "|"+getName(), "|"+getTare(), "|"+getVolume(),
                "|"+getPrice(), "|   " + getQuant() + "    |");

    }
}