package lesson7.generics.reflection;

import lesson7.generics.domains.Beer;
import lesson7.generics.domains.Brendy;
import lesson7.generics.domains.Juice;
import lesson7.generics.domains.Vodka;

/**
 * Created by prulov on 22.06.2016.
 */
public class MyNewDay {

    Juice inTheEvening;
    Beer forLunch;
    Vodka inTheMorning;
    Brendy atFiveOclock;

    public MyNewDay(){}

    public MyNewDay(Juice inTheEvening, Beer forLunch, Vodka inTheMorning, Brendy atFiveOclock){

        this.inTheEvening = inTheEvening;
        this.forLunch = forLunch;
        this.inTheMorning = inTheMorning;
        this.atFiveOclock = atFiveOclock;


    }

    @Override
    public String toString(){

        return inTheMorning.getDrink()+"\n"+forLunch.getDrink()+"\n"+atFiveOclock.getDrink()+"\n"+inTheEvening.getDrink();
    }

}
