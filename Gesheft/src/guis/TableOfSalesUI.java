package guis;

import domain.Sale;
import util.Service;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * Created by prulov on 05.07.2016.
 */
public class TableOfSalesUI extends DefaultTableModel {

    private Service serv;
    private JTable table;

    public TableOfSalesUI(Service serv){

        this.serv = serv;
        this.table = createSalesTable();
        JScrollPane scrollPane = new JScrollPane(table);
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
            }else if(i == 3 || i == 7){
                column.setPreferredWidth(150);
            }else{
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
        Object[][] data = new Object[serv.getBad().getSales().size()][columns];
        int j = 1, i = 0;

        for(Sale sale : serv.getBad().getSales()){
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
                    sale.getWat().getPrice(),
                    sale.getIncome()
            };
            i++;
        }
        return data;
    }

}
