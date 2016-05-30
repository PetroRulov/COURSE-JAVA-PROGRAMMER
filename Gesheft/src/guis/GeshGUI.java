package guis;

import domain.Sale;
import domain.waters.Water;
import interfaces.IDataProvider;
import util.Service;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.Observer;
import java.util.Vector;

/**
 * Created by prulov on 26.05.2016.
 */
public class GeshGUI extends DefaultTableModel {

    private IDataProvider dataProvider;

    private Service serv;
    private JFrame f;
    private JPanel panel;

    // controller's fields:
    private JTextField tfDate;
    private JTextField tfSurName;
    private JTextField tfYName;
    private JFormattedTextField tfAge;
    private JTextField tfSex;
    private JTextField tfEmail;
    private JComboBox combo;
    private JFormattedTextField tfQuant;
    private JButton buy;


    public GeshGUI(Service serv) {

        this.serv = serv;
        this.f.setDefaultLookAndFeelDecorated(true);
        this.f = new JFrame("* ALCOHOL SHOP - \"BADIGAN\" - ALCOHOL SHOP *");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setMinimumSize(new Dimension(1200, 700));
        f.setLocation(0, 0);

        // setting MenuBar to the Frame
        initMenuBar();

        // first initialisation of the SalesTable displaying
        initSalesDataShow();

        // adding Transaction GUI
        //showTransactionGUI();

        f.pack();
        f.setVisible(true);
    }

    public void setBadigan(IDataProvider dataProvider){

        this.dataProvider = dataProvider;
    }

    private JPanel createSalePannel() {

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.BLACK);

        NumberFormat nf = NumberFormat.getInstance();

        JLabel date = new JLabel("Date (ddMMyyyy): ");
        date.setFont(new Font("Garamond", Font.BOLD, 20));
        date.setForeground(Color.ORANGE);
        panel.add(date, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfDate = new JTextField();
        tfDate.setFont(new Font("Garamond", Font.BOLD, 20));
        tfDate.setForeground(Color.BLACK);
        tfDate.setColumns(6);
        tfDate.setHorizontalAlignment(JTextField.RIGHT);
        tfDate.setText("18032016");
        panel.add(tfDate, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel surName = new JLabel("Customer's Surname: ");
        surName.setFont(new Font("Garamond", Font.ITALIC, 20));
        surName.setForeground(Color.ORANGE);
        panel.add(surName, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfSurName = new JTextField();
        tfSurName.setFont(new Font("Garamond", Font.ITALIC, 20));
        tfSurName.setForeground(Color.BLACK);
        tfSurName.setColumns(12);
        panel.add(tfSurName, new GridBagConstraints(1, 1, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel yName = new JLabel("Name: ");
        yName.setFont(new Font("Garamond", Font.ITALIC, 20));
        yName.setForeground(Color.ORANGE);
        yName.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(yName, new GridBagConstraints(4, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfYName = new JTextField();
        tfYName.setFont(new Font("Garamond", Font.ITALIC, 20));
        tfYName.setForeground(Color.BLACK);
        tfYName.setColumns(12);
        panel.add(tfYName, new GridBagConstraints(5, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel age = new JLabel("Customer's Age: ");
        age.setFont(new Font("Garamond", Font.ITALIC, 20));
        age.setForeground(Color.ORANGE);
        panel.add(age, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfAge = new JFormattedTextField(nf);
        tfAge.setForeground(Color.BLACK);
        tfAge.setHorizontalAlignment(JTextField.RIGHT);
        tfAge.setValue(0);
        tfAge.setColumns(6);
        panel.add(tfAge, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel sex = new JLabel("Sex: ");
        sex.setFont(new Font("Garamond", Font.ITALIC, 20));
        sex.setForeground(Color.ORANGE);
        sex.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(sex, new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfSex = new JTextField();
        tfSex.setForeground(Color.BLACK);
        tfSex.setColumns(6);
        panel.add(tfSex, new GridBagConstraints(3, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel eMail = new JLabel("E-mail: ");
        eMail.setFont(new Font("Garamond", Font.ITALIC, 20));
        eMail.setForeground(Color.ORANGE);
        eMail.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(eMail, new GridBagConstraints(4, 2, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfEmail = new JTextField();
        tfEmail.setForeground(Color.BLACK);
        tfEmail.setColumns(16);
        panel.add(tfEmail, new GridBagConstraints(5, 2, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel choose = new JLabel("Choose the good: ");
        choose.setFont(new Font("Garamond", Font.BOLD, 20));
        choose.setForeground(Color.ORANGE);
        panel.add(choose, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        Vector<Water> vat = serv.getBad().getStk().getVat();
        combo = new JComboBox(vat);
        combo.setFont(new Font("Garamond", Font.BOLD, 20));
        combo.setForeground(Color.BLACK);
        panel.add(combo, new GridBagConstraints(1, 3, 10, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel quant = new JLabel("Quantity: ");
        quant.setFont(new Font("Garamond", Font.BOLD, 20));
        quant.setForeground(Color.ORANGE);
        panel.add(quant, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfQuant = new JFormattedTextField(nf);
        tfQuant.setFont(new Font("Garamond", Font.BOLD, 20));
        tfQuant.setForeground(Color.BLACK);
        tfQuant.setValue(1);
        tfQuant.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(tfQuant, new GridBagConstraints(1, 4, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        buy = new JButton("Buy");
        buy.setFont(new Font("Garamond", Font.BOLD, 20));
        panel.add(buy, new GridBagConstraints(1, 5, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        buy.addActionListener(new BuyControl(serv, this));

        return panel;
    }

    public JButton getBuy() {
        return buy;
    }

    public JComboBox getCombo() {
        return combo;
    }

    public JTextField getTfAge() {
        return tfAge;
    }

    public JTextField getTfDate() {
        return tfDate;
    }

    public JTextField getTfEmail() {
        return tfEmail;
    }

    public JFormattedTextField getTfQuant() {
        return tfQuant;
    }

    public JTextField getTfSex() {
        return tfSex;
    }

    public JTextField getTfSurName() {
        return tfSurName;
    }

    public JTextField getTfYName() {
        return tfYName;
    }

    public JFrame getF() {
        return f;
    }

    private void initMenuBar(){

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

                showTransactionGUI();
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setFont(font);
        fileMenu.add(exitItem);

        exitItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        f.setJMenuBar(menuBar);
    }

    private JTable createSalesTable(){

        Object[] colNames = fillColumns();
        Object[][] data = fillData();

        JTable tSales = new JTable(data, colNames);
        TableColumn column = null;
        for(int i = 0; i < 11; i++){
            column = tSales.getColumnModel().getColumn(i);
            if(i == 2 || i == 3 || i == 5){
                column.setPreferredWidth(250);
            }else{
                column.setPreferredWidth(150);
            }
        }
        return tSales;
    }

    private Object[] fillColumns(){

        String[] heads = new String[]{
          "#", "Date", "Client's surname", "Clients name", "Drink type", "Drink name", "Tare", "Volume, L", "Quantity", "Price, UAH", "Income, UAH"
        };
        Object[] colNames = new Object[heads.length];
        for(int i = 0; i < 11; i++){
            colNames[i] = heads[i];
        }
        return colNames;
    }

//    private Object[][] fillData(){
//
//        Object[][] data = new Object[this.serv.getBad().getSales().size()][11];
//        int j = 1;
//
//        for(int i = 0; i < serv.getBad().getSales().size(); i++){
//        data[i] = new Object[]{
//                j++,
//                serv.getBad().getSales().get(i).getDate(),
//                serv.getBad().getSales().get(i).getGuest().getSurName(),
//                serv.getBad().getSales().get(i).getGuest().getName(),
//                serv.getBad().getSales().get(i).getWat().getDrink(),
//                serv.getBad().getSales().get(i).getWat().getName(),
//                serv.getBad().getSales().get(i).getWat().getTare(),
//                serv.getBad().getSales().get(i).getWat().getVolume(),
//                serv.getBad().getSales().get(i).getQuant(),
//                serv.getBad().getSales().get(i).getWat().getPrice(),
//                serv.getBad().getSales().get(i).getIncome()
//            };
//        }
//        return data;
//    }

    private Object[][] fillData(){

        Object[][] data = new Object[serv.getBad().getSellings().size()][11];
        System.out.println(serv.getBad().getSellings().size());
        int j = 1;
        int i = 0;

//        for(int i = 0; i < serv.getBad().getSellings().size(); i++){
//            data[i] = new Object[]{
//                    j++,
//                    serv.getBad().getSellings().get(i).getDate(),
//                    serv.getBad().getSellings().get(i).getGuest().getSurName(),
//                    serv.getBad().getSellings().get(i).getGuest().getName(),
//                    serv.getBad().getSellings().get(i).getWat().getDrink(),
//                    serv.getBad().getSellings().get(i).getWat().getName(),
//                    serv.getBad().getSellings().get(i).getWat().getTare(),
//                    serv.getBad().getSellings().get(i).getWat().getVolume(),
//                    serv.getBad().getSellings().get(i).getQuant(),
//                    serv.getBad().getSellings().get(i).getWat().getPrice(),
//                    serv.getBad().getSellings().get(i).getIncome()
//            };
//        }
        for(Sale sale : serv.getBad().getSellings()){
            data[i] = new Object[]{
                    j++,
                    sale.getDate(),
                    sale.getGuest().getSurName(),
                    sale.getGuest().getName(),
                    sale.getWat().getDrink(),
                    sale.getWat().getName(),
                    sale.getWat().getTare(),
                    sale.getWat().getVolume(),
                    sale.getQuant(),
                    sale.getWat().getPrice(),
                    sale.getIncome()
            };
        }

//        for(Iterator<Sale> sale = serv.getBad().getSellings().iterator(); sale.hasNext();){
//            data[i] = new Object[]{
//                    j++,
//                    sale.next().getDate(),
//                    sale.next().getGuest().getSurName(),
//                    sale.next().getGuest().getName(),
//                    sale.next().getWat().getDrink(),
//                    sale.next().getWat().getName(),
//                    sale.next().getWat().getTare(),
//                    sale.next().getWat().getVolume(),
//                    sale.next().getQuant(),
//                    sale.next().getWat().getPrice(),
//                    sale.next().getIncome()
//            };
//        }
        return data;
    }

    private void initSalesDataShow(){

        JTable table = createSalesTable();
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        f.getContentPane().add(scrollPane);

    }

    public void newSalesDataShow(){

        f.getContentPane().removeAll();
        JTable table = createSalesTable();
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        f.getContentPane().add(scrollPane);
        f.pack();
        f.repaint();

    }

    private void showTransactionGUI(){

        f.getContentPane().removeAll();
        panel = createSalePannel();
        f.getContentPane().add(panel);
        Observer obs = new BuyControl(serv, this);
        serv.getBad().addObserver(obs);
        f.pack();
        f.repaint();

    }

}
