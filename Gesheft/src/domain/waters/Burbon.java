package domain.waters;

import enumerations.Drink;
import enumerations.Tare;

/**
 * Created by prulov on 26.05.2016.
 */
public class Burbon extends Water {

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
