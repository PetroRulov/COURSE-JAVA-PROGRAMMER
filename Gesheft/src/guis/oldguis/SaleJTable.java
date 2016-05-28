package guis.oldguis;

import guis.GeshGUI;
import util.Service;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 * Created by prulov on 26.05.2016.
 */
public class SaleJTable extends DefaultTableModel {

    private Service serv;
    private Object[][] data;
    private String[] colNames;
    //private JFrame frame;


    public SaleJTable(Service serv){

        JFrame frame = new JFrame(" \"BADIGAN\" SALES JOURNAL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Verdana", Font.BOLD, 18);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(font);
        menuBar.add(fileMenu);
        JMenu buyMenu = new JMenu("Buy");
        buyMenu.setFont(font);
        fileMenu.add(buyMenu);

        fileMenu.addSeparator();

        buyMenu.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e) {


                GeshGUI geshGUI = new GeshGUI(serv);

//                Observer obs = new BuyControl(serv, geshGUI);
//                serv.getBad().addObserver(obs);
                frame.dispose();
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setFont(font);
        fileMenu.add(exitItem);

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        frame.setJMenuBar(menuBar);
        frame.setMinimumSize(new Dimension(1150, 650));
        frame.setLocation(0, 0);

        this.serv = serv;
        colNames = fillColumns();
        data = fillData();

        JTable table = new JTable(data, colNames);

        // This creates a scroll pane as a container for the table; the table is automatically added to the container.
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);

        TableColumn column = null;
        for(int i = 0; i < 11; i++){
            column = table.getColumnModel().getColumn(i);
            if(i == 2 || i == 3 || i == 5){
                column.setPreferredWidth(100);
            }else{
                column.setPreferredWidth(20);
            }
        }

        table.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {

                fireTableChanged(e);

            }
        });

        //frame.setPreferredSize(new Dimension(450, 200));
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

    public void newDataAvailable(TableModelEvent event) {
        fireTableChanged(event);
    }

    public void addRow(Vector rowData) {
        insertRow(getRowCount(), rowData);
    }



}
