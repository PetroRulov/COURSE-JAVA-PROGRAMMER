package lesson7.generics.containers;

import lesson7.generics.domains.Water;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by prulov on 05.06.2016.
 */
public class WaterBox<T extends Water> {

    private List<T> waters;

    public WaterBox(){
        waters = new ArrayList<>();
    }

    public List<T> getWaters() {
        return new ArrayList<>(waters);
    }

    public void setWaters(List<T> waters) {
        this.waters = waters;
    }

    public void addWater(T w){

        waters.add(w);
    }

    public void removeWater(T w){

        waters.remove(w);
    }

    public T getWaterFromWaters(int x){

        return (T) waters.get(x);
    }

    public void sorterWBbyPriceDecrease(List<T> waters){

        waters.sort(new PriceDecreaseComparator());
    }

    public void sorterWBbyPriceIncrease(List<T> waters){

        waters.sort(new PriceIncreaseComparator());
    }
}


class PriceDecreaseComparator implements Comparator<Water> {

    @Override
    public int compare(Water a, Water b) {
        return a.getPrice() < b.getPrice() ? 1 : a.getPrice() == b.getPrice() ? 0 : -1;
    }
}

class PriceIncreaseComparator implements Comparator<Water> {

    @Override
    public int compare(Water a, Water b) {
        return a.getPrice() < b.getPrice() ? -1 : a.getPrice() == b.getPrice() ? 0 : 1;
    }
}

