package guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by prulov on 15.06.2016.
 */
public class SaleTransactionUI {

    private JFrame frame;
    private JPanel salePanel;

    // data
    private List<String> buyers = new ArrayList<>();
    private List<String> goods = new ArrayList<>();

    // controller's fields:
    private JComboBox comboBuyers;
    private JComboBox comboGoods;
    private JButton addToBasket;
    private JButton sell;


    public SaleTransactionUI() {

        frame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("МАГАЗИН БИЖУТЕРИИ \"НАТАЛИ\"");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1365, 725));
        frame.setLocation(0, 0);

        // first initialisation of the SalesTable displaying
        //initSalesDataShow();

        // adding SaleTransactionUI
        salePanel = createSalePanel();
        frame.getContentPane().add(salePanel);

        initMenuBar();

        frame.pack();
        frame.setVisible(true);
    }

    public JPanel createSalePanel() {

        buyers = initBuyersList();
        goods = initGoodsList();

        salePanel = new JPanel();
        salePanel.setLayout(new GridBagLayout());
        salePanel.setBackground(Color.WHITE);

        NumberFormat nf = NumberFormat.getInstance();
        NumberFormat formatter = new DecimalFormat("#0.00");

        //ImageIcon icon = createImageIcon("strawberry.gif");
        ImageIcon icon = new ImageIcon(getClass().getResource("strawberry.gif"));
        JLabel picture = new JLabel(icon);
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.LEFT);
        //picture.setIcon(icon);
        picture.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        salePanel.add(picture, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));


        JLabel date = new JLabel("Дата продажи:");
        date.setFont(new Font("Garamond", Font.BOLD, 20));
        date.setForeground(Color.RED);
        salePanel.add(date, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JTextField tfDate = new JTextField();
        tfDate.setFont(new Font("Garamond", Font.BOLD, 20));
        tfDate.setForeground(Color.BLACK);
        tfDate.setColumns(6);
        tfDate.setHorizontalAlignment(JTextField.RIGHT);
        tfDate.setText(dateFormat(new Date(System.currentTimeMillis())));
        salePanel.add(tfDate, new GridBagConstraints(1, 1, 3, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel client = new JLabel("Выберите, пожалуйста, Клиента из списка:");
        client.setFont(new Font("Garamond", Font.BOLD, 20));
        client.setForeground(Color.RED);
        salePanel.add(client, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        comboBuyers = new JComboBox(new MyComboBoxModel(buyers));
        comboBuyers.setFont(new Font("Garamond", Font.BOLD, 20));
        comboBuyers.setForeground(Color.BLACK);
        salePanel.add(comboBuyers, new GridBagConstraints(0, 3, 7, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel good = new JLabel("Выберите, пожалуйста, Товар из списка (по артикулу):");
        good.setFont(new Font("Garamond", Font.BOLD, 20));
        good.setForeground(Color.RED);
        salePanel.add(good, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        comboGoods = new JComboBox(new MyComboBoxModel(goods));
        comboGoods.setFont(new Font("Garamond", Font.BOLD, 20));
        comboGoods.setForeground(Color.BLACK);
        salePanel.add(comboGoods, new GridBagConstraints(0, 5, 7, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel quantity = new JLabel("Количество, шт.:");
        quantity.setFont(new Font("Garamond", Font.BOLD, 20));
        quantity.setForeground(Color.RED);
        salePanel.add(quantity, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JFormattedTextField tfQuant = new JFormattedTextField(nf);
        tfQuant.setFont(new Font("Garamond", Font.BOLD, 20));
        tfQuant.setForeground(Color.BLACK);
        tfQuant.setValue(1);
        tfQuant.setHorizontalAlignment(JTextField.RIGHT);
        salePanel.add(tfQuant, new GridBagConstraints(1, 6, 4, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        addToBasket = new JButton("Добавить в корзину");
        addToBasket.setFont(new Font("Garamond", Font.BOLD, 20));
        addToBasket.setForeground(Color.GREEN);
        salePanel.add(addToBasket, new GridBagConstraints(5, 7, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        // adding Listener
        //addToBasket.addActionListener(new BuyControl(serv, this));

        sell = new JButton("Завершить продажу");
        sell.setFont(new Font("Garamond", Font.BOLD, 20));
        sell.setForeground(Color.BLUE);
        salePanel.add(sell, new GridBagConstraints(1, 9, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel price = new JLabel("Цена, грн.:");
        price.setFont(new Font("Garamond", Font.BOLD, 20));
        price.setForeground(Color.RED);
        salePanel.add(price, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JFormattedTextField tfPrice = new JFormattedTextField(formatter);
        tfPrice.setFont(new Font("Garamond", Font.BOLD, 20));
        tfPrice.setForeground(Color.BLACK);
        tfPrice.setValue(0);
        tfPrice.setHorizontalAlignment(JTextField.RIGHT);
        salePanel.add(tfPrice, new GridBagConstraints(1, 7, 4, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        // adding monoTable

        JTable monoSale = new JTable();
        salePanel.add(monoSale, new GridBagConstraints(0, 8, 4, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        return salePanel;
    }

    private List<String> initBuyersList() {

        buyers.add("Дядин");
        buyers.add("Бойко");
        buyers.add("Рулёв");
        return buyers;
    }

    private List<String> initGoodsList() {

        goods.add("Серьги");
        goods.add("Кольцо");
        goods.add("Браслет");
        goods.add("Бусы");
        return goods;
    }

    class MyComboBoxModel extends AbstractListModel implements ComboBoxModel {

        List<String> data = new ArrayList<>();
        String selection = null;

        public MyComboBoxModel(List<String> data) {
            this.data = data;
        }

        public Object getElementAt(int index) {
            return data.get(index);
        }

        public int getSize() {
            return data.size();
        }

        public void setSelectedItem(Object anItem) {
            selection = (String) anItem;
        }

        public Object getSelectedItem() {
            return selection;
        }
    }

    public String dateFormat(Date d) {

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(d);

    }

    private void initMenuBar() {

        Font font = new Font("Verdana", Font.BOLD, 18);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(font);
        menuBar.add(fileMenu);
        JMenu buyMenu = new JMenu("Buy");
        buyMenu.setFont(font);
        fileMenu.add(buyMenu);
        fileMenu.addSeparator();

        buyMenu.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                System.out.println("SaleTransactionUI should be displayed...");
                //showTransactionGUI();
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
        frame.setJMenuBar(menuBar);
    }
}