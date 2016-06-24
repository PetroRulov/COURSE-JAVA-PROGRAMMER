package lesson7.generics.reflection;

import lesson7.generics.domains.Beer;
import lesson7.generics.domains.Brendy;
import lesson7.generics.domains.Juice;
import lesson7.generics.domains.Vodka;

/**
 * Created by prulov on 22.06.2016.
 */
public class Never {

    private Brendy inTheMorning;
    private Vodka forLunch;
    private Beer atFiveOclock;
    private Juice inTheEvening;

    public Never(){}

    public Never(Brendy inTheMorning , Vodka forLunch, Beer atFiveOclock , Juice inTheEvening ){

        this.inTheMorning = inTheMorning;
        this.forLunch = forLunch;
        this.atFiveOclock = atFiveOclock;
        this.inTheEvening = inTheEvening;

    }

    @Override
    public String toString(){

        return inTheMorning.getDrink()+"\n"+forLunch.getDrink()+"\n"+atFiveOclock.getDrink()+"\n"+inTheEvening.getDrink();
    }

}
