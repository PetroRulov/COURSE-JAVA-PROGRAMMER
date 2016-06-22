package guis;

import controllers.*;
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
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observer;

/**
 * Created by prulov on 26.05.2016.
 */
public class GeshGUI extends DefaultTableModel {

    private IDataProvider dataProvider;

    private Service serv;
    private JFrame f;
    private JPanel panel;

    // data
    private List<Water> goods = new ArrayList<>();

    // controller's fields:
    private JTextField tfDate;
    private JTextField tfSurName;
    private JTextField tfName;
    private JTextField tfAge;
    private JTextField tfSex;
    private JTextField tfEmail;

    private JFormattedTextField tfBID; // Client's ID for transaction
    private JFormattedTextField tfClID; // Client's ID for Client's Database
    private JFormattedTextField tfQuant;

    private JComboBox combo;

    public GeshGUI(Service serv) {

        this.serv = serv;
        this.f.setDefaultLookAndFeelDecorated(true);
        this.f = new JFrame("* ALCOHOL SHOP - \"BADIGAN\" - ALCOHOL SHOP *");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setMinimumSize(new Dimension(1360, 725));
        f.setLocation(0, 0);

        // setting MenuBar to the Frame
        initMenuBar();

        // first initialisation of the SalesTable displaying
        initSalesDataShow();

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

        goods = serv.getBad().getStk().getWaters();

        NumberFormat nf = NumberFormat.getInstance();

        ImageIcon icon = new ImageIcon(getClass().getResource("strawberry.gif"));
        JLabel picture = new JLabel(icon);
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.LEFT);
        //picture.setIcon(icon);
        picture.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        panel.add(picture, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));


        JLabel date = new JLabel("Date (dd.MM.yyyy): ");
        date.setFont(new Font("Garamond", Font.BOLD, 20));
        date.setForeground(Color.ORANGE);
        panel.add(date, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfDate = new JTextField();
        tfDate.setFont(new Font("Garamond", Font.BOLD, 20));
        tfDate.setForeground(Color.BLACK);
        tfDate.setColumns(6);
        tfDate.setHorizontalAlignment(JTextField.RIGHT);
        tfDate.setText(dateFormat(new Date(System.currentTimeMillis())));
        panel.add(tfDate, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel id = new JLabel("Customer's identify #: ");
        id.setFont(new Font("Garamond", Font.ITALIC, 20));
        id.setForeground(Color.ORANGE);
        panel.add(id, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfBID = new JFormattedTextField(nf);
        tfBID.setFont(new Font("Garamond", Font.ITALIC, 20));
        tfBID.setForeground(Color.BLACK);
        tfBID.setColumns(12);
        tfBID.setHorizontalAlignment(JTextField.RIGHT);
        tfBID.setValue(serv.getBad().getClts().size() + 1);
        panel.add(tfBID, new GridBagConstraints(1, 2, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel choose = new JLabel("Choose the good: ");
        choose.setFont(new Font("Garamond", Font.BOLD, 20));
        choose.setForeground(Color.ORANGE);
        panel.add(choose, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        combo = new JComboBox(new MyComboBoxModel(goods));
        combo.setFont(new Font("Garamond", Font.BOLD, 20));
        combo.setForeground(Color.BLACK);
        panel.add(combo, new GridBagConstraints(1, 4, 10, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel quant = new JLabel("Quantity: ");
        quant.setFont(new Font("Garamond", Font.BOLD, 20));
        quant.setForeground(Color.ORANGE);
        panel.add(quant, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfQuant = new JFormattedTextField(nf);
        tfQuant.setFont(new Font("Garamond", Font.BOLD, 20));
        tfQuant.setForeground(Color.BLACK);
        tfQuant.setValue(1);
        tfQuant.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(tfQuant, new GridBagConstraints(1, 5, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JButton buy = new JButton("Buy");
        buy.setFont(new Font("Garamond", Font.BOLD, 20));
        panel.add(buy, new GridBagConstraints(1, 6, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        buy.addActionListener(new SellControl(serv, this));

        return panel;
    }

    private JPanel createAddNewClientPannel() {

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);

        NumberFormat nf = NumberFormat.getInstance();

        ImageIcon icon = new ImageIcon(getClass().getResource("strawberry.gif"));
        JLabel picture = new JLabel(icon);
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.LEFT);
        //picture.setIcon(icon);
        picture.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        panel.add(picture, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel id = new JLabel("Client's ID #: ");
        id.setFont(new Font("Garamond", Font.ITALIC, 20));
        id.setForeground(Color.BLUE);
        panel.add(id, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfClID = new JFormattedTextField(nf);
        tfClID.setFont(new Font("Garamond", Font.ITALIC, 20));
        tfClID.setForeground(Color.BLACK);
        tfClID.setColumns(12);
        tfClID.setValue(serv.getBad().getClts().size() + 1);
        tfClID.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(tfClID, new GridBagConstraints(1, 1, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel surName = new JLabel("Client's Surname: ");
        surName.setFont(new Font("Garamond", Font.ITALIC, 20));
        surName.setForeground(Color.BLUE);
        panel.add(surName, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfSurName = new JTextField();
        tfSurName.setFont(new Font("Garamond", Font.ITALIC, 20));
        tfSurName.setForeground(Color.BLACK);
        tfSurName.setColumns(12);
        panel.add(tfSurName, new GridBagConstraints(1, 2, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel yName = new JLabel("Name: ");
        yName.setFont(new Font("Garamond", Font.ITALIC, 20));
        yName.setForeground(Color.BLUE);
        yName.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(yName, new GridBagConstraints(4, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfName = new JTextField();
        tfName.setFont(new Font("Garamond", Font.ITALIC, 20));
        tfName.setForeground(Color.BLACK);
        tfName.setColumns(12);
        panel.add(tfName, new GridBagConstraints(5, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel age = new JLabel("Client's date of birth: ");
        age.setFont(new Font("Garamond", Font.ITALIC, 20));
        age.setForeground(Color.BLUE);
        panel.add(age, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfAge = new JTextField();
        tfAge.setForeground(Color.BLACK);
        tfAge.setHorizontalAlignment(JTextField.RIGHT);
        tfAge.setColumns(6);
        tfAge.setText("00/00/0000");
        panel.add(tfAge, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel sex = new JLabel("Sex: ");
        sex.setFont(new Font("Garamond", Font.ITALIC, 20));
        sex.setForeground(Color.BLUE);
        sex.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(sex, new GridBagConstraints(2, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfSex = new JTextField();
        tfSex.setForeground(Color.BLACK);
        tfSex.setColumns(6);
        panel.add(tfSex, new GridBagConstraints(3, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel eMail = new JLabel("E-mail: ");
        eMail.setFont(new Font("Garamond", Font.ITALIC, 20));
        eMail.setForeground(Color.BLUE);
        eMail.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(eMail, new GridBagConstraints(4, 3, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfEmail = new JTextField();
        tfEmail.setForeground(Color.BLACK);
        tfEmail.setColumns(16);
        panel.add(tfEmail, new GridBagConstraints(5, 3, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JButton addNewClient = new JButton("Add new Client");
        addNewClient.setFont(new Font("Garamond", Font.BOLD, 20));
        panel.add(addNewClient, new GridBagConstraints(1, 4, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        addNewClient.addActionListener(new AddClientControl(serv, this));

        return panel;
    }

    public JTextField getTfDate() {
        return tfDate;
    }

    public String getDate(){

        return getTfDate().getText();
    }

    public JTextField getTfSurName() {
        return tfSurName;
    }

    public String getSurName(){

        return getTfSurName().getText();
    }

    public JTextField getTfName() {
        return tfName;
    }

    public String getName(){

        return getTfName().getText();
    }

    public JTextField getTfAge() {
        return tfAge;
    }

    public String getAge(){

        return getTfAge().getText();
    }

    public JTextField getTfSex() {
        return tfSex;
    }

    public String getSex(){

        return getTfSex().getText();
    }

    public JTextField getTfEmail() {
        return tfEmail;
    }

    public String getEmail(){

        return getTfEmail().getText();
    }

    public JFormattedTextField getTfBID() {
        return tfBID;
    }

    public String getBuyerID(){

        return getTfBID().getText();
    }

    public JFormattedTextField getTfClID() {
        return tfClID;
    }

    public String getClientID(){

        return getTfClID().getText();
    }

    public JFormattedTextField getTfQuant() {
        return tfQuant;
    }

    public String getQuantity(){

        return getTfQuant().getText();
    }



    public JComboBox getCombo() {
        return combo;
    }

    public Water getSelectedWater(){

        return (Water) getCombo().getSelectedItem();
    }

    // to get main frame
    public JFrame getF() {
        return f;
    }



    public String dateFormat(Date d){

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(d);
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

        JMenu addClient = new JMenu("Add new Client");
        addClient.setFont(font);
        fileMenu.add(addClient);
        fileMenu.addSeparator();

        addClient.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e) {

                showAddingNewClientGUI();
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

        getF().setJMenuBar(menuBar);
    }

    private JTable createSalesTable(){

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


    // to initiate first SalesTable appearing
    private void initSalesDataShow(){

        JTable table = createSalesTable();
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        getF().getContentPane().add(scrollPane);

    }

    public void newSalesTableShow(){

        getF().getContentPane().removeAll();
        JTable table = createSalesTable();
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        getF().getContentPane().add(scrollPane);
        getF().pack();
        getF().repaint();

    }

    private void showTransactionGUI(){

        getF().getContentPane().removeAll();
        panel = createSalePannel();
        getF().getContentPane().add(panel);
        Observer obs = new SellControl(serv, this);
        serv.getBad().addObserver(obs);
        getF().pack();
        getF().repaint();
    }

    private void showAddingNewClientGUI(){

        getF().getContentPane().removeAll();
        panel = createAddNewClientPannel();
        getF().getContentPane().add(panel);
        Observer obs = new AddClientControl(serv, this);
        serv.getBad().addObserver(obs);
        getF().pack();
        getF().repaint();
    }

    class MyComboBoxModel<E extends Water> extends AbstractListModel implements ComboBoxModel {

        List<E> data = new ArrayList<>();
        Water selection = null;

        public MyComboBoxModel(List<E> data){this.data = data;}

        public Object getElementAt(int index) {
            return data.get(index);
        }

        public int getSize() {
            return data.size();
        }

        public void setSelectedItem(Object anItem) {selection = (E) anItem;}

        public Object getSelectedItem() {return selection;}
    }


}
