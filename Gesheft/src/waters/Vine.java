package waters;

import enumerations.*;

public class Vine extends Water {

    private String color;
    private String strength;

    public Vine(Drink drink, String name, String color, String strength, Tare tare, double volume, int quant, double value, double price){

        this.drink = drink;
        this.name = name;
        this.color = color;
        this.strength = strength;
        this.tare = tare;
        this.volume = volume;
        this.quant = quant;
        this.value = value;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public String getStrength() {
        return strength;
    }
}


