package domain;

import interfaces.IDataProvider;
import waters.Water;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class StockCopy implements IDataProvider {

    private Vector<Water> vaters;


    @Override
    public List<Water> getWaters() {

        return new ArrayList<Water>(vaters);
    }

    @Override
    public Vector<Water> getVat() {
        return null;
    }
}
