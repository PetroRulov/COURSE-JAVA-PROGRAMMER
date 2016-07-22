package view;

import bl.Shop;
import control.AddClientControl;
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
    private AddNewClientPanelUI anclPUI;
    private SetAdjustedPeriodPanelUI perPUI;
    private SetAdjustedBuyerPanelUI buyerPUI;
    private TableOfSales tsUI;
    private TableClient tclUI;
    private TablePriceList tPL;
    private AdjustedByDateTableOfSales tSabyDate;
    private AdjusyedByBuyerTableOfSales tSbyBuyer;

    public ShopUI(Shop shop) {

        this.shop = shop;
        this.serv = new Service(shop);
        this.hp = new HeadPanel(shop);
        this.spUI = new SalePanelUI(shop, serv);
        this.anclPUI = new AddNewClientPanelUI(shop, serv);
        this.perPUI = new SetAdjustedPeriodPanelUI(shop, serv, this);
        this.buyerPUI = new SetAdjustedBuyerPanelUI(shop, serv, this);
        this.tsUI = new TableOfSales(shop);
        this.tclUI = new TableClient(shop);
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

        JMenuItem salesTable = new JMenuItem("All Sales Table");
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

        JMenu addClient = new JMenu("ADD NEW CLIENT");
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

    public void clientsTableShow(){

        getFrame().getContentPane().removeAll();
        JTable table = tclUI.createClientsTable();
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

    private void showAddingNewClientGUI(){

        getFrame().getContentPane().removeAll();
        panel = anclPUI.createAddNewClientPanel();
        getFrame().getContentPane().add(panel);
        Observer obs = new AddClientControl(shop, anclPUI, this, serv);
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
