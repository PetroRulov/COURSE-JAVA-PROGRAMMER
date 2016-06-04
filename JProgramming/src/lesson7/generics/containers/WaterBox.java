package lesson7.generics.containers;

import lesson7.generics.domains.Water;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prulov on 05.06.2016.
 */
public class WaterBox<T extends Water> {

    private List<Water> waters;

    public WaterBox(){
        waters = new ArrayList<>();
    }

    public List<Water> getWaters() {
        return new ArrayList<>(waters);
    }

    public void setWaters(List<Water> waters) {
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
}
