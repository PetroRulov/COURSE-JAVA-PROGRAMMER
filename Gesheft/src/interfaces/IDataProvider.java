package interfaces;

import domain.Client;
import domain.Sale;
import domain.waters.Water;

import java.util.List;

/**
 * Created by prulov on 25.04.2016.
 */
public interface IDataProvider {

    List<Water> getWaters();

    List<Sale> getSales();

    List<Client> getClts();
}
