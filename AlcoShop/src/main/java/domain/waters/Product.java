package domain.waters;

import java.math.BigDecimal;

/**
 * Created by prulov on 08.07.2016.
 */
public interface Product {

    //basic
    long getId_water();
    String getDrink();
    String getName();
    Tare getTare();
    double getVolume();
    int getQuant();
    BigDecimal getPrice();





    void setCount(int count);

    String waterShow();

    int getCount();
}
