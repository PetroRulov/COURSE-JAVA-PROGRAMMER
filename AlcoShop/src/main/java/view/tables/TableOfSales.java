package view.tables;

import bl.Shop;
import domain.Sale;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.math.BigDecimal;

public class TableOfSales extends DefaultTableModel {

    private Shop shop;
    private JTable table;

    public TableOfSales(Shop shop){

        this.shop = shop;
        this.table = createSalesTable();
        table.setFillsViewportHeight(true);

    }

    public JTable createSalesTable(){

        int columns = 13;
        Object[] colNames = fillColumns();
        Object[][] data = fillData();

        JTable tSales = new JTable(data, colNames);
        tSales.setAutoCreateRowSorter(false);
        TableColumn column = null;
        for(int i = 0; i < columns; i++){
            column = tSales.getColumnModel().getColumn(i);
            if(i == 0 || i == 2 || i == 5) {
                column.setPreferredWidth(45);
            }else if(i == 1){
                column.setPreferredWidth(90);
            }else if(i == 7) {
                column.setPreferredWidth(210);
            } else {
                column.setPreferredWidth(120);
            }
        }
        return tSales;
    }

    private Object[] fillColumns(){

        int columns = 13;
        String[] heads = new String[]{
                "#", "Date", "BuyerID", "Buyer's surname", "Buyer's name", "DrinkID",  "Drink type", "Drink name", "Tare", "Volume, L", "Quantity",
                "Price, UAH", "Income, UAH"};
        Object[] colNames = new Object[heads.length];
        for(int i = 0; i < columns; i++){
            colNames[i] = heads[i];
        }
        return colNames;
    }


    private Object[][] fillData(){

        int columns = 12;
        Object[][] data = new Object[shop.getIdbI().getSales().size()][columns];
        int j = 1, i = 0;

        for(Sale sale : shop.getIdbI().getSales()){
            data[i] = new Object[]{
                    j++,
                    sale.getDate(),
                    sale.getGuest().getId_client(),
                    sale.getGuest().getSurName(),
                    sale.getGuest().getName(),
                    sale.getWat().getId_water(),
                    sale.getWat().getDrink(),
                    sale.getWat().getName(),
                    sale.getWat().getTare(),
                    sale.getWat().getVolume(),
                    sale.getQuant(),
                    sale.getWat().getPrice().setScale(2, BigDecimal.ROUND_HALF_UP).toString(),
                    sale.getIncome().setScale(2, BigDecimal.ROUND_HALF_UP).toString()
            };
            i++;
        }
        return data;
    }

}

