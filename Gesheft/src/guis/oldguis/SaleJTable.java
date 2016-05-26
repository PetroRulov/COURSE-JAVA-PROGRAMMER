package guis.oldguis;

import util.Service;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

/**
 * Created by prulov on 26.05.2016.
 */
public class SaleJTable extends JFrame {

    private Service serv;
    private Object[][] data;
    private String[] colNames;


    public SaleJTable(Service serv){

        JFrame frame = new JFrame(" \"BADIGAN\" SALES JOURNAL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1250, 750));
        frame.setLocation(0, 0);

        this.serv = serv;
        colNames = fillColumns();
        data = fillData();

        JTable table = new JTable(data, colNames);

        // This creates a scroll pane as a container for the table; the table is automatically added to the container.
        JScrollPane scrollPane = new JScrollPane(table);

        TableColumn column = null;
        for(int i = 0; i < 11; i++){
            column = table.getColumnModel().getColumn(i);
            if(i == 2 || i == 3){
                column.setPreferredWidth(50);
            }else{
                column.setPreferredWidth(20);
            }

        }

        frame.getContentPane().add(scrollPane);
        frame.setPreferredSize(new Dimension(450, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private String[] fillColumns(){

        String[] colNames = new String[]{
            "#", "Date", "Client's surname", "Clients name", "Drink type", "Drink name", "Tare", "Volume, L", "Quantity", "Price, UAH", "Income, UAH"

        };
        return colNames;
    }

    private Object[][] fillData(){

        Object[][] data = new Object[serv.getBad().getVectSales().size()][11];
        int j = 1;
        for(int i = 0; i < serv.getBad().getVectSales().size(); i++){

            data[i] = new Object[]{
                    j++,
                    serv.getBad().getVectSales().get(i).getDate(),
                    serv.getBad().getVectSales().get(i).getGuest().getSurName(),
                    serv.getBad().getVectSales().get(i).getGuest().getName(),
                    serv.getBad().getVectSales().get(i).getWat().getDrink(),
                    serv.getBad().getVectSales().get(i).getWat().getName(),
                    serv.getBad().getVectSales().get(i).getWat().getTare(),
                    serv.getBad().getVectSales().get(i).getWat().getVolume(),
                    serv.getBad().getVectSales().get(i).getQuant(),
                    serv.getBad().getVectSales().get(i).getWat().getPrice(),
                    serv.getBad().getVectSales().get(i).getIncome()
            };
        }
        return data;
    }


}
