package lesson7.generics.reflection;

import lesson7.generics.domains.Water;

/**
 * Created by prulov on 22.06.2016.
 */
public class MyDay {

    Water inTheEvening;
    Water forLunch;
    Water inTheMorning;
    Water atFiveOclock;

    @Override
    public String toString(){

        return inTheMorning.getDrink()+"\n"+forLunch.getDrink()+"\n"+atFiveOclock.getDrink()+"\n"+inTheEvening.getDrink();
    }

}
