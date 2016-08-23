package view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectComboBoxModel<E> extends AbstractListModel implements ComboBoxModel {

    List<E> data = new ArrayList<E>();
    E selection = null;

    public ObjectComboBoxModel(List<E> data){this.data = data;}

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (E) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Object getElementAt(int index) {
        return data.get(index);
    }
}
