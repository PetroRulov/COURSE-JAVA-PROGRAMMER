package view.tables;

import bl.Shop;
import domain.waters.Product;
import util.Service;

import javax.swing.*;
import javax.swing.table.TableColumn;

/**
 * Created by prulov on 22.08.2016.
 */
@Deprecated
public class OrderTab {

    private Shop shop;
    private Service serv;
    private JTable table;
    private int columns;

    public OrderTab(Shop shop, Service serv){
        this.shop = shop;
        this.serv = serv;
        this.columns = 4;
        this.table = createOrderTab();
        table.setFillsViewportHeight(true);

    }

    private JTable createOrderTab() {

        Object[] colNames = fillColumns();
        Object[][] data = fillData();

        JTable ordTab = new JTable(data, colNames);
        ordTab.setAutoCreateRowSorter(false);
        TableColumn column = null;
        for(int i = 0; i < columns; i++){
            column = ordTab.getColumnModel().getColumn(i);
            if(i == 0 || i == 1) {
                column.setPreferredWidth(60);
            }else if(i == 2){
                column.setPreferredWidth(240);
            }else if(i == 3){
                column.setPreferredWidth(180);
            }else{
                column.setPreferredWidth(150);
            }
        }
        return ordTab;
    }

    private Object[][] fillData() {
        Object[][] data = new Object[shop.getIdbI().getClts().size()][columns];
        int j = 1, i = 0;

        for(Product prod : serv.getOrderItems()){
            data[i] = new Object[]{
                    j++,
                    prod.waterShow(),
                    prod.getPrice(),
                    prod.getCount()
            };
            i++;
        }
        return data;
    }

    private Object[] fillColumns() {

        String[] heads = new String[]{
                "#", "Water", "Price", "Quantity"};
        Object[] colNames = new Object[heads.length];
        for(int i = 0; i < columns; i++){
            colNames[i] = heads[i];
        }
        return colNames;
    }

    public JTable getTable() {
        return table;
    }
}
