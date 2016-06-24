package lesson7.generics.reflection;

import lesson7.generics.domains.*;

public class MyOldDays {

    private Water inTheEvening;
    private Water forLunch;
    private Water inTheMorning;
    private Water atFiveOclock;

    public MyOldDays(){}

    public MyOldDays(Water inTheEvening, Water forLunch, Water inTheMorning, Water atFiveOclock){

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
