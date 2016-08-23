package control.tablisteners;

import bl.Shop;
import control.AddItemToOrder;
import domain.waters.Product;
import view.panels.OrderPanelUI;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

@Deprecated
public class ItemAddToOrderTab implements TableModelListener {

    private Shop shop;
    private OrderPanelUI opUI;
    private AddItemToOrder addITO;
    private List<Product> list;


    public ItemAddToOrderTab(Shop shop, OrderPanelUI opUI, AddItemToOrder addITO){
        this.shop = shop;
        this.opUI = opUI;
        this.addITO = addITO;
        this.list = shop.getIdbI().getProducts();
    }

    @Override
    public void tableChanged(TableModelEvent e) {

        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);

        Product product = null;
        for (int i = 0; i < list.size(); i++) {
            if (opUI.getSelectedWater().equals(list.get(i))) {
                product = list.get(i);
                product.setCount(Integer.parseInt(opUI.getQuantity()));
            }
        }
        model.setValueAt(product.waterShow(), 1, 1);
    }
}
