package view;

import bl.Shop;
import control.AddClientControl;
import control.AddVisitorControl;
import control.SaleControl;
import util.Service;
import view.panels.*;
import view.tables.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observer;

/**
 * Created by prulov on 08.07.2016.
 */
public class ShopUI {

    private Shop shop;
    private Service serv;
    private JFrame frame;
    private JPanel panel;
    private String head = "* ALCOHOL SHOP - \"COCK TAIL\" - ALCOHOL SHOP *";

    // different panels and tables
    private HeadPanel hp;
    private SalePanelUI spUI;
    private OrderPanelUI ordpUI;
    private AddNewClientPanelUI anclPUI;
    private AddNewVisitorPanelUI anvsPUI;
    private SetAdjustedPeriodPanelUI perPUI;
    private SetAdjustedBuyerPanelUI buyerPUI;
    private TableOfSales tsUI;
    private TableOfOrders toUI;
    private TableClient tclUI;
    private TableVisitors tvsUI;
    private TablePriceList tPL;
    private AdjustedByDateTableOfSales tSabyDate;
    private AdjusyedByBuyerTableOfSales tSbyBuyer;

    public ShopUI(Shop shop) {

        this.shop = shop;
        this.serv = new Service(shop);
        this.hp = new HeadPanel(shop);
        this.spUI = new SalePanelUI(shop, serv);
        this.ordpUI = new OrderPanelUI(shop, serv);
        this.anclPUI = new AddNewClientPanelUI(shop, serv);
        this.anvsPUI = new AddNewVisitorPanelUI(shop, serv);
        this.perPUI = new SetAdjustedPeriodPanelUI(shop, serv, this);
        this.buyerPUI = new SetAdjustedBuyerPanelUI(shop, serv, this);
        this.tsUI = new TableOfSales(shop);
        this.toUI = new TableOfOrders(shop);
        this.tclUI = new TableClient(shop);
        this.tvsUI = new TableVisitors(shop);
        this.tPL = new TablePriceList(shop);
        this.tSabyDate = new AdjustedByDateTableOfSales(shop, perPUI);
        this.tSbyBuyer = new AdjusyedByBuyerTableOfSales(shop, buyerPUI);

        this.frame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame(head);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1360, 725));
        frame.setLocation(0, 0);

        frame.setJMenuBar(createMenuBar());

        panel = hp.createHeadPieceUI();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    private JMenuBar createMenuBar(){

        Font bigFont = new Font("Verdana", Font.BOLD, 21);
        Font font = new Font("Verdana", Font.BOLD, 18);
        Font fant = new Font("Verdana", Font.BOLD, 15);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("FILE");
        fileMenu.setFont(bigFont);
        menuBar.add(fileMenu);

        JMenu tables = new JMenu("DATA TABLES");
        tables.setFont(font);
        fileMenu.add(tables);
        fileMenu.addSeparator();

        JMenuItem clientsTable = new JMenuItem("Clients");
        clientsTable.setFont(fant);
        clientsTable.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        tables.add(clientsTable);
        tables.addSeparator();

        clientsTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                clientsTableShow();
            }
        });

        JMenuItem salesTable = new JMenuItem("All Sales History Table");
        salesTable.setFont(fant);
        salesTable.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        tables.add(salesTable);
        tables.addSeparator();

        salesTable.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                salesTableShow();
            }
        });

        JMenuItem adjustPeriod = new JMenuItem("Adjusted period Sales Table");
        adjustPeriod.setFont(fant);
        adjustPeriod.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
        tables.add(adjustPeriod);
        tables.addSeparator();

        adjustPeriod.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                showAdjustPeriodGUI();
            }
        });

        JMenuItem adjustedBuyer = new JMenuItem("Adjusted by Buyer Sales Table");
        adjustedBuyer.setFont(fant);
        adjustedBuyer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
        tables.add(adjustedBuyer);
        tables.addSeparator();

        adjustedBuyer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                showAdjustBuyerGUI();
            }
        });

        JMenuItem priceList = new JMenuItem("Price-List");
        priceList.setFont(fant);
        priceList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
        tables.add(priceList);
        tables.addSeparator();

        priceList.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                priceListShow();
            }
        });

        JMenuItem orders = new JMenuItem("All Orders Journal");
        orders.setFont(fant);
        orders.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, ActionEvent.ALT_MASK));
        tables.add(orders);
        tables.addSeparator();

        orders.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                ordersJournalShow();
            }
        });

        JMenuItem visitors = new JMenuItem("Visitors");
        visitors.setFont(fant);
        visitors.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7, ActionEvent.ALT_MASK));
        tables.add(visitors);
        tables.addSeparator();

        visitors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                visitorsTableShow();
            }
        });

        JMenu buyMenu = new JMenu("NEW SALE");
        buyMenu.setFont(font);
        fileMenu.add(buyMenu);
        fileMenu.addSeparator();

        buyMenu.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e) {

                showTransactionGUI();
            }
        });

        JMenu orderMenu = new JMenu("NEW ORDER");
        orderMenu.setFont(font);
        fileMenu.add(orderMenu);
        fileMenu.addSeparator();

        orderMenu.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e) {

                showOrderGUI();
            }
        });

        JMenu addCustomers = new JMenu("ADD NEW CUSTOMERS");
        addCustomers.setFont(font);
        fileMenu.add(addCustomers);
        fileMenu.addSeparator();

        JMenuItem addClient = new JMenuItem("Add new Client");
        addClient.setFont(fant);
        addCustomers.add(addClient);
        addCustomers.addSeparator();

        addClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                showAddingNewClientGUI();
            }
        });

        JMenuItem addVisitor = new JMenuItem("Add new Visitor");
        addVisitor.setFont(fant);
        addCustomers.add(addVisitor);
        addCustomers.addSeparator();

        addVisitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                showAddingNewVisitorGUI();
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

        return menuBar;
    }

    public void salesTableShow(){

        getFrame().getContentPane().removeAll();
        JTable table = tsUI.createSalesTable();
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        getFrame().getContentPane().add(scrollPane);
        getFrame().pack();
        getFrame().repaint();
    }

    public void ordersJournalShow(){

        getFrame().getContentPane().removeAll();
        JTable table = toUI.createOrdersTable();
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        getFrame().getContentPane().add(scrollPane);
        getFrame().pack();
        getFrame().repaint();
    }

    public void clientsTableShow(){

        getFrame().getContentPane().removeAll();
        JTable table = tclUI.createClientsTable();
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        getFrame().getContentPane().add(scrollPane);
        getFrame().pack();
        getFrame().repaint();
    }

    public void visitorsTableShow(){

        getFrame().getContentPane().removeAll();
        JTable table = tvsUI.createVisitorsTable();
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        getFrame().getContentPane().add(scrollPane);
        getFrame().pack();
        getFrame().repaint();
    }

    public void priceListShow(){

        getFrame().getContentPane().removeAll();
        JTable table = tPL.createPriceListTable();
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        getFrame().getContentPane().add(scrollPane);
        getFrame().pack();
        getFrame().repaint();

    }

    private void showTransactionGUI(){

        getFrame().getContentPane().removeAll();
        panel = spUI.createSalePanel();
        getFrame().getContentPane().add(panel);
        Observer obs = new SaleControl(shop, spUI, this, serv);
        shop.addObserver(obs);
        getFrame().pack();
        getFrame().repaint();
    }

    private void showOrderGUI(){

        getFrame().getContentPane().removeAll();
        panel = ordpUI.createOrderPanel();
        getFrame().getContentPane().add(panel);
        getFrame().pack();
        getFrame().repaint();
    }

    private void showAddingNewClientGUI(){

        getFrame().getContentPane().removeAll();
        panel = anclPUI.createAddNewClientPanel();
        getFrame().getContentPane().add(panel);
        Observer obs = new AddClientControl(shop, anclPUI, this, serv);
        shop.addObserver(obs);
        getFrame().pack();
        getFrame().repaint();
    }

    private void showAddingNewVisitorGUI(){

        getFrame().getContentPane().removeAll();
        panel = anvsPUI.createAddNewVisitorPanel();
        getFrame().getContentPane().add(panel);
        Observer obs = new AddVisitorControl(shop, anvsPUI, this, serv);
        shop.addObserver(obs);
        getFrame().pack();
        getFrame().repaint();
    }


    //util methods
    private void showAdjustPeriodGUI(){

        getFrame().getContentPane().removeAll();
        panel = perPUI.getPeriodPanel();
        getFrame().getContentPane().add(panel);
        getFrame().pack();
        getFrame().repaint();
    }

    private void showAdjustBuyerGUI(){

        getFrame().getContentPane().removeAll();
        panel = buyerPUI.getBuyerPanel();
        getFrame().getContentPane().add(panel);
        getFrame().pack();
        getFrame().repaint();
    }


    public void adjustedByDateSalesTableShow(){

        getFrame().getContentPane().removeAll();
        JTable table = tSabyDate.createAdjustedByDateSalesTable(perPUI.getInitialDate(), perPUI.getFinishDate());
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        getFrame().getContentPane().add(scrollPane);
        getFrame().pack();
        getFrame().repaint();
    }

    public void adjustedByBuyerSalesTableShow(){

        getFrame().getContentPane().removeAll();
        JTable table = tSbyBuyer.createAdjustedByBuyerSalesTable(buyerPUI.getBuyersID());
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        getFrame().getContentPane().add(scrollPane);
        getFrame().pack();
        getFrame().repaint();
    }

}
