package view;

import domain.waters.Product;
import domain.waters.Water;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prulov on 05.07.2016.
 */

public class MyComboBoxModel<E extends Product> extends AbstractListModel implements ComboBoxModel {

    List<E> data = new ArrayList<E>();
    Product selection = null;

    public MyComboBoxModel(List<E> data){this.data = data;}

    public Object getElementAt(int index) {
        return data.get(index);
    }

    public int getSize() {
        return data.size();
    }

    public void setSelectedItem(Object anItem) {selection = (E) anItem;}

    public Object getSelectedItem() {return selection;}
}
