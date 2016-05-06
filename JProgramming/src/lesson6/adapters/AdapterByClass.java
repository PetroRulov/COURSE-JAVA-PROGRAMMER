package lesson6.adapters;

/**
 * Created by prulov on 06.05.2016.
 */
public class AdapterByClass extends Adaptee implements Target {


    @Override
    public String newRequst() {
        return oldRequest();
    }
}
