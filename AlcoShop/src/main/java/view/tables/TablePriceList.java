package view.tables;

import bl.Shop;
import domain.Sale;
import domain.waters.Product;
import domain.waters.Water;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by prulov on 09.07.2016.
 */
public class TablePriceList {

    private Shop shop;
    private JTable table;
    private int columns;

    public TablePriceList(Shop shop){

        this.shop = shop;
        columns = 8;
        this.table = createPriceListTable();
        table.setFillsViewportHeight(true);
    }

    public JTable createPriceListTable() {

        Object[] colNames = fillColumns();
        Object[][] data = fillData();

        JTable priceList = new JTable(data, colNames);
        priceList.setAutoCreateRowSorter(false);
        TableColumn column = null;
        for(int i = 0; i < columns; i++){
            column = priceList.getColumnModel().getColumn(i);
            if(i == 0 || i == 1) {
                column.setPreferredWidth(45);
            }else if(i == 2 || i == 4){
                column.setPreferredWidth(90);
            }else if(i == 3){
                column.setPreferredWidth(180);
            }else{
                column.setPreferredWidth(90);
            }
        }
        return priceList;
    }

    private Object[] fillColumns() {
        String[] heads = new String[]{
                "#", "ID", "Type", "Name", "Tare", "Volume, L",  "Quantity", "Price, UAH"};
        Object[] colNames = new Object[heads.length];
        for(int i = 0; i < columns; i++){
            colNames[i] = heads[i];
        }
        return colNames;
    }

    private Object[][] fillData() {
        Object[][] data = new Object[shop.getIdbI().getProducts().size()][columns];
        int j = 1, i = 0;
        for(Product product : shop.getIdbI().getProducts()){
            data[i] = new Object[]{
                    j++,
                    product.getId_water(),
                    product.getDrink(),
                    product.getName(),
                    product.getTare(),
                    product.getVolume(),
                    product.getQuant(),
                    product.getPrice()
            };
            i++;
        }
        return data;
    }
}
