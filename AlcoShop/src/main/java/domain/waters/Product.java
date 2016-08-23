package domain.waters;

import java.math.BigDecimal;

/**
 * Created by prulov on 08.07.2016.
 */
public interface Product {

    void setCount(int count);

    String waterShow();

    BigDecimal getPrice();

    int getCount();
}
