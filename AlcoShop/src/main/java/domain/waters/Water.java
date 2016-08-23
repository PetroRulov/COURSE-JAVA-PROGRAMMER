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
    protected int count;


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
        this.count = 0;
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

    public BigDecimal getPrice() {return price.setScale(2, BigDecimal.ROUND_HALF_UP);}

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString(){

        return "id #" + getId_water() + " " + getDrink() + " " + getName() + ", " + getTare() + " " + getVolume() +
                "L, price: UAH " + getPrice().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Water)) return false;

        Water water = (Water) o;

        if (getId_water() != water.getId_water()) return false;
        if (Double.compare(water.getVolume(), getVolume()) != 0) return false;
        if (getQuant() != water.getQuant()) return false;
        if (!getDrink().equals(water.getDrink())) return false;
        if (!getName().equals(water.getName())) return false;
        if (getTare() != water.getTare()) return false;
        if (!getValue().equals(water.getValue())) return false;
        return getPrice().equals(water.getPrice());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (getId_water() ^ (getId_water() >>> 32));
        result = 31 * result + getDrink().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getTare().hashCode();
        temp = Double.doubleToLongBits(getVolume());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getQuant();
        result = 31 * result + getValue().hashCode();
        result = 31 * result + getPrice().hashCode();
        return result;
    }

    // service methods
    public void waterInfoShow(){
        System.out.printf("%-1s%-10s%-25s%-10s%-10s%-10s%-10s%-10s%n", "", "|"+getDrink(), "|"+getName(), "|"+getTare(), "|"+getVolume(),
                "|"+getPrice(), "|   " + getQuant() + "    |" + getCount() + "    |");
    }

    public String waterShow(){
        return getDrink()+", "+getName()+", "+getTare()+", "+getVolume()+", "+
                getPrice()+" - " + getCount() +" items,"+ "\n";
    }
}