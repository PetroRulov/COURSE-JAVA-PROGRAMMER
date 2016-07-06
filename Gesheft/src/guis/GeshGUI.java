package guis;

import controllers.AddClientControl;
import controllers.SaleControl;
import interfaces.IDataProvider;
import util.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observer;

/**
 * Created by prulov on 26.05.2016.
 */
public class GeshGUI extends JFrame {

    private IDataProvider dataProvider;

    private Service serv;
    private JFrame frame;
    private JPanel panel;

    // different panels
    private HPPanelUI hp;

    private SalePanelUI spUI;
    private AddNewClientPanelUI ancPUI;
    private TableOfSalesUI tsUI;
    private TableOfClientsUI tclUI;

    public GeshGUI(Service serv) {

        this.serv = serv;
        this.hp = new HPPanelUI(serv);
        this.spUI = new SalePanelUI(serv);
        this.ancPUI = new AddNewClientPanelUI(serv);
        this.tsUI = new TableOfSalesUI(serv);
        this.tclUI = new TableOfClientsUI(serv);

        this.frame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("* ALCOHOL SHOP - \"BADIGAN\" - ALCOHOL SHOP *");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1360, 725));
        frame.setLocation(0, 0);

        frame.setJMenuBar(createMenuBar());

        panel = hp.createHeadPieceUI();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    public void setDataProvider(IDataProvider dataProvider){

        this.dataProvider = dataProvider;
    }

    public JFrame getFrame() {
        return frame;
    }

    private JMenuBar createMenuBar(){

        Font font = new Font("Verdana", Font.BOLD, 18);
        Font fant = new Font("Verdana", Font.BOLD, 15);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("FILE");
        fileMenu.setFont(font);
        menuBar.add(fileMenu);

        JMenu tables = new JMenu("Tables");
        tables.setFont(font);
        fileMenu.add(tables);
        fileMenu.addSeparator();

        JMenuItem clientsTable = new JMenuItem("Clients");
        clientsTable.setFont(fant);
        tables.add(clientsTable);
        tables.addSeparator();

        clientsTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientsTableShow();
            }
        });

        JMenuItem salesTable = new JMenuItem("Sales Table");
        salesTable.setFont(fant);
        salesTable.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        tables.add(salesTable);
        tables.addSeparator();

        salesTable.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                salesTableShow();
            }
        });

        JMenu buyMenu = new JMenu("Sale");
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

    private void showTransactionGUI(){

        getFrame().getContentPane().removeAll();
        panel = spUI.createSalePanel();
        getFrame().getContentPane().add(panel);
        Observer obs = new SaleControl(serv, spUI, this);
        serv.getBad().addObserver(obs);
        getFrame().pack();
        getFrame().repaint();
    }

    private void showAddingNewClientGUI(){

        getFrame().getContentPane().removeAll();
        panel = ancPUI.createAddNewClientPanel();
        getFrame().getContentPane().add(panel);
        Observer obs = new AddClientControl(serv, ancPUI, this);
        serv.getBad().addObserver(obs);
        getFrame().pack();
        getFrame().repaint();
    }

}
