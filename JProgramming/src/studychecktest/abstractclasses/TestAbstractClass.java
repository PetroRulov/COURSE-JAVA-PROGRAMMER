package studychecktest.abstractclasses;

import studychecktest.Challenger;
import studychecktest.interfaceinheritance.Checkable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prulov on 29.07.2016.
 */
public abstract class TestAbstractClass extends Challenger implements Checkable {

    private String name;
    private int age;
    private List<Object> materials;

    public TestAbstractClass() {
    }

    protected abstract List<Object> updateStockCapacity();

    @Override
    public List<Object> updateStock(){

        return new ArrayList<Object>();
    }

}
