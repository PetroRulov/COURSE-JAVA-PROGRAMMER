package lesson7.generics.domains;

import lesson7.generics.enums.Drink;

/**
 * Created by prulov on 04.06.2016.
 */
public class Vodka extends Water {

    public Vodka(){}

    public Vodka(Drink drink, String name, double volume, int quant, double value, double price) {

        this.drink = drink;
        this.name = name;
        this.volume = volume;
        this.quant = quant;
        this.value = value;
        this.price = price;

    }
}