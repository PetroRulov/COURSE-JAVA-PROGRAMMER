package interfaces;

import waters.Water;

import java.util.List;
import java.util.Vector;

/**
 * Created by prulov on 25.04.2016.
 */
public interface IDataProvider {

    List<Water> getWaters();

    Vector<Water> getVat();
}
