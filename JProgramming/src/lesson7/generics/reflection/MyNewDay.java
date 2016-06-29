package lesson7.generics.reflection;

import lesson7.generics.domains.Beer;
import lesson7.generics.domains.Brendy;
import lesson7.generics.domains.Juice;
import lesson7.generics.domains.Vodka;

/**
 * Created by prulov on 22.06.2016.
 */
public class MyNewDay {

    private Juice inTheMorning;
    private Beer forLunch;
    private Vodka atFiveOclock;
    private Brendy inTheEvening;

    public MyNewDay(){}

    public MyNewDay(Juice inTheMorning , Beer forLunch, Vodka atFiveOclock , Brendy inTheEvening ){

        this.inTheMorning = inTheMorning;
        this.forLunch = forLunch;
        this.atFiveOclock = atFiveOclock;
        this.inTheEvening = inTheEvening;

    }

    @Override
    public String toString(){

        return inTheMorning.getDrink()+"\n"+forLunch.getDrink()+"\n"+atFiveOclock.getDrink()+"\n"+inTheEvening.getDrink();
    }

    public Brendy getInTheEvening() {
        return inTheEvening;
    }

    public Vodka getAtFiveOclock() {
        return atFiveOclock;
    }

    public Beer getForLunch() {
        return forLunch;
    }

    public Juice getInTheMorning() {
        return inTheMorning;
    }
}
