package guis;

import domain.Client;
import interfaces.IDataProvider;
import util.Service;
import domain.waters.Water;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Vector;

/**
 * Created by prulov on 26.05.2016.
 */
public class BadGUI {

    private IDataProvider dataProvider;
    private Service serv;

    public BadGUI(Service serv) {

        this.serv = serv;

        JFrame f = new JFrame("\"BADIGAN\" ALCOHOL SHOP TRANSACTION");
        f.setMinimumSize(new Dimension(1000, 400));
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
        //Border solidBorder = BorderFactory.createLineBorder(Color.ORANGE, 1);
        JLabel date = new JLabel("Date (ddmmyyyy): ");
        date.setBounds(50, 50, 150, 25);
        date.setFont(new Font("Garamond", Font.ITALIC, 20));
        date.setForeground(Color.ORANGE);
        //date.setBorder(solidBorder);
        JTextField tfDate = new JTextField();
        tfDate.setBounds(200, 50, 250, 25);

        JLabel surName = new JLabel("Your Surname: ");
        surName.setBounds(50, 100, 150, 25);
        surName.setFont(new Font("Garamond", Font.ITALIC, 20));
        surName.setForeground(Color.ORANGE);
        JTextField tfSurName = new JTextField();
        tfSurName.setBounds(200, 100, 300, 25);

        JLabel yName = new JLabel("Your Name: ");
        yName.setBounds(525, 100, 100, 25);
        yName.setFont(new Font("Garamond", Font.ITALIC, 20));
        yName.setForeground(Color.ORANGE);
        JTextField tfYName = new JTextField();
        tfYName.setBounds(625, 100, 250, 25);

        JLabel choose = new JLabel("Choose the good: ");
        choose.setBounds(50, 150, 150, 25);
        choose.setFont(new Font("Garamond", Font.BOLD, 20));
        choose.setForeground(Color.ORANGE);
        //Water[] wat = stk.getWat();
        //List<Water> wat = dataProvider.getListOfProducts();// !!! do not work !!!
        //List<Water> wat = stk.getListOfProducts();
        Vector<Water> vat = serv.getBad().getStk().getVat();
        JComboBox combo = new JComboBox(vat);
        combo.setBounds(200, 150, 425, 25);

        //JLabel quant = new JLabel("Quantity: ", sb, SwingConstants.LEFT);
        JLabel quant = new JLabel("Quantity: ");
        quant.setFont(new Font("Garamond", Font.ITALIC, 24));
        quant.setForeground(Color.ORANGE);
        quant.setBounds(50, 200, 150, 25);
        NumberFormat nf = NumberFormat.getInstance();
        JFormattedTextField tfQuant = new JFormattedTextField(nf);
        tfQuant.setValue(1);
        tfQuant.setBounds(200, 200, 200, 25);
        JButton buy = new JButton("Buy");
        buy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int date = Integer.parseInt(tfDate.getText());
                Client guest = new Client(tfSurName.getText(), tfYName.getText());
                for(Client n : serv.getBad().getGuests()){
                    if(tfSurName.getText().equals(n.getSurName()) && tfYName.getText().equals(n.getName())){
                        guest = n;
                        break;
                    }else{
                        System.out.println("There is no such Client in database!");
                    }
                }
                Water wat = (Water) combo.getSelectedItem();
                int quant = Integer.parseInt(tfQuant.getText());

                if(wat.getQuant() >= quant){
                    serv.getBad().getStk().soldWaterMinus(wat, quant);
                    JOptionPane.showConfirmDialog(null, "Transaction is possible!", "Transaction possibility", JOptionPane.PLAIN_MESSAGE);
                    serv.getBad().sellTransaction(date, guest, wat, quant);
                }else{
                    JOptionPane.showConfirmDialog(null, "Transaction is NOT possible! \n Please, try again with new quantity of item",
                            "Transaction possibility", JOptionPane.OK_CANCEL_OPTION);
                }

                // optional methods displaying result
                serv.printSalesJournal(serv.getBad().getSales());
                serv.getBad().getStk().printWat();
            }
        });
        buy.setBounds(200, 250, 325, 25);
        buy.setFont(new Font("Garamond", Font.BOLD, 20));

        panel.add(surName);
        panel.add(tfSurName);
        panel.add(yName);
        panel.add(tfYName);
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
