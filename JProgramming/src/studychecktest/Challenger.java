package studychecktest;

import studychecktest.interfaceinheritance.Checkable;

import java.util.List;
import java.util.Map;

/**
 * Created by prulov on 29.07.2016.
 */
public class Challenger implements Checkable {

    @Override
    public List<Object> updateStock() {
        return null;
    }

    @Override
    public Map<String, Object> updateShop() {
        return null;
    }
}
