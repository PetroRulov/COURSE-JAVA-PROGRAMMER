package waters;

import enumerations.*;

public class Burbon extends Water{

    public Burbon(Drink drink, String name, Tare tare, double volume, int quant, double value, double price) {

        this.drink = drink;
        this.name = name;
        this.tare = tare;
        this.volume = volume;
        this.quant = quant;
        this.value = value;
        this.price = price;
    }
}
