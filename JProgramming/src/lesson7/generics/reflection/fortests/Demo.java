package lesson7.generics.reflection.fortests;

import lesson7.generics.domains.Beer;
import lesson7.generics.domains.Brendy;
import lesson7.generics.domains.Juice;
import lesson7.generics.domains.Vodka;
import lesson7.generics.enums.Drink;
import lesson7.generics.reflection.MyNewDay;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prulov on 29.06.2016.
 */
public class Demo {

    public static void main(String[] args) {

        Beer beer = new Beer(Drink.BEER, "Petrovskoye", 0.66, 100, 9.80, 17.90);
        Juice juice = new Juice(Drink.JUICE, "Nice Peaches", 1.0, 50, 12.4, 25.60);
        Vodka vodka = new Vodka(Drink.VODKA, "Utro Dobrym ne byvaet", 0.5, 25, 40.5, 90.40);
        Brendy brendy = new Brendy(Drink.BRENDY, "Slynchev Breg", 0.5, 5, 140.4, 290.00);

        Beer beerN = new Beer(Drink.BEER, "Rulovskoye", 0.66, 100, 9.80, 17.90);
        Juice juiceN = new Juice(Drink.JUICE, "Pamela", 1.0, 50, 12.4, 25.60);
        Vodka vodkaN = new Vodka(Drink.VODKA, "Dobroye Utro, Strana!", 0.5, 25, 40.5, 90.40);
        Brendy brendyN = new Brendy(Drink.BRENDY, "METAXA*****", 0.5, 5, 140.4, 290.00);

        InitServiceClass iServCl = new InitServiceClass();

        Map<String, Object> dataN = new HashMap<>();
        dataN.put("inTheMorning", juiceN);
        dataN.put("forLunch", beerN);
        dataN.put("atFiveOclock", vodkaN);
        dataN.put("inTheEvening", brendyN);

        System.out.println();
        System.out.println("FOR MyNewDay:");
        MyNewDay mND = new MyNewDay(juice, beer, vodka, brendy);
        iServCl.setPrivates(mND, dataN);
    }
}
