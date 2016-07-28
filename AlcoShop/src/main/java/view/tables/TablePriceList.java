package view.tables;

import bl.Shop;
import domain.waters.Water;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.math.BigDecimal;

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

        Object[][] data = new Object[shop.getIdbI().getWaters().size()][columns];
        int j = 1, i = 0;

        for(Water water : shop.getIdbI().getWaters()){
            data[i] = new Object[]{
                    j++,
                    water.getId_water(),
                    water.getDrink(),
                    water.getName(),
                    water.getTare(),
                    water.getVolume(),
                    water.getQuant(),
                    water.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP).toString()
            };
            i++;
        }
        return data;

    }



}