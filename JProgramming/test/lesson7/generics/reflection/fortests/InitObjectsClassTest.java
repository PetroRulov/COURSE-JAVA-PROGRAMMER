package lesson7.generics.reflection.fortests;

import lesson7.generics.domains.Beer;
import lesson7.generics.domains.Brendy;
import lesson7.generics.domains.Juice;
import lesson7.generics.domains.Vodka;
import lesson7.generics.enums.Drink;
import lesson7.generics.reflection.MyNewDay;
import lesson7.generics.reflection.MyOldDays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by prulov on 29.06.2016.
 */
@RunWith(JUnit4.class)
public class InitObjectsClassTest {

    private InitServiceClass clazz;
    private List<Object> list;
    private Map<String, Object> data;
    private Beer beer = new Beer(Drink.BEER, "Petrovskoye", 0.66, 100, 9.80, 17.90);
    private Juice juice = new Juice(Drink.JUICE, "Nice Peaches", 1.0, 50, 12.4, 25.60);
    private Vodka vodka = new Vodka(Drink.VODKA, "Utro Dobrym ne byvaet", 0.5, 25, 40.5, 90.40);
    private Brendy brendy = new Brendy(Drink.BRENDY, "Slynchev Breg", 0.5, 5, 140.4, 290.00);

    @Before
    public void init(){

        list = new ArrayList<>();
        list.add(beer);
        list.add(juice);
        list.add(vodka);
        list.add(brendy);

        data = new HashMap<>();
        data.put("inTheMorning", juice);
        data.put("forLunch", beer);
        data.put("atFiveOclock", vodka);
        data.put("inTheEvening", brendy);

        clazz = new InitServiceClass();
    }

    @Test
    public void initClassTest(){

        Assert.assertNotNull(clazz.initClass(MyNewDay.class, list));
    }

}
