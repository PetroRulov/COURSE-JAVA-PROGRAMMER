import domain.Stock;
import interfaces.IDataProvider;
import waters.Water;

import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.text.NumberFormat;

public class BadiganShopUI {

    private IDataProvider dataProvider;
    //private Stock stk;

    public BadiganShopUI(/*Stock stk*/) {

        //this.stk = stk;

        JFrame f = new JFrame("\"BADIGAN\" ALCOHOL SHOP TRANSACTION");
        f.setMinimumSize(new Dimension(800, 225));
        f.setLocation(100, 100);
        f.getContentPane().add(createSellingPannel());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    public void setStk(IDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public JPanel createSellingPannel(){

        JPanel panel = new JPanel();
        //panel.setLayout(new BorderLayout());
        //panel.setLayout(new GridLayout());
        //panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        //Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        JLabel date = new JLabel("Date: ");
        date.setBounds(50, 25, 50, 25);
        date.setFont(new Font("Garamond", Font.ITALIC, 20));
        date.setForeground(Color.ORANGE);
        //date.setBorder(solidBorder);
        JTextField tfDate = new JTextField(10);
        tfDate.setBounds(100, 25, 150, 25);
        JLabel yName = new JLabel("Your Name: ");
        yName.setBounds(300, 25, 100, 25);
        yName.setFont(new Font("Garamond", Font.ITALIC, 20));
        yName.setForeground(Color.ORANGE);
        JTextField tfName = new JTextField(20);
        tfName.setBounds(400, 25, 325, 25);

        JLabel choose = new JLabel("Choose the good: ");
        choose.setBounds(50, 75, 150, 25);
        choose.setFont(new Font("Garamond", Font.BOLD, 20));
        choose.setForeground(Color.ORANGE);
        //Water[] wat = stk.getWat();
        //List<Water> wat = dataProvider.getListOfProducts();// !!! do not work !!!
        //List<Water> wat = stk.getListOfProducts();
        Vector<Water> wat = dataProvider.getVat();
        JComboBox combo = new JComboBox(wat);
        combo.setBounds(200, 75, 525, 25);



        //JLabel quant = new JLabel("Quantity: ", sb, SwingConstants.LEFT);
        JLabel quant = new JLabel("Quantity: ");
        quant.setFont(new Font("Garamond", Font.ITALIC, 24));
        quant.setForeground(Color.ORANGE);
        quant.setBounds(50, 125, 100, 25);
        NumberFormat nf = NumberFormat.getInstance();
        JFormattedTextField tfQuant = new JFormattedTextField(nf);
        tfQuant.setValue(1);
        tfQuant.setBounds(175, 125, 200, 25);
        JButton buy = new JButton("Buy");
        buy.setBounds(400, 125, 325, 25);
        buy.setFont(new Font("Garamond", Font.BOLD, 20));

        panel.add(yName);
        panel.add(tfName);
        panel.add(date);
        panel.add(tfDate);
        panel.add(choose);
        panel.add(combo);
        panel.add(quant);
        panel.add(tfQuant);
        panel.add(buy);
        return panel;
    }


//    setContentPane(panel);


}




