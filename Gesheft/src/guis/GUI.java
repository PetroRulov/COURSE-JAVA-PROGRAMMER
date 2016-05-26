package guis;

import domain.Client;
import domain.waters.Water;
import interfaces.IDataProvider;
import util.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Vector;

/**
 * Created by prulov on 26.05.2016.
 */
public class GUI {

    private IDataProvider dataProvider;
    private Service serv;
    private int watIndex = 0;

    public GUI(Service serv) {

        this.serv = serv;

        JFrame f = new JFrame("\"BADIGAN\" ALCOHOL SHOP TRANSACTION");
        f.setMinimumSize(new Dimension(800, 300));
        f.setLocation(550, 0);
        f.getContentPane().add(createSellingPannel());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    private JPanel createSellingPannel() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.BLACK);

        JLabel date = new JLabel("Date: ");
        date.setFont(new Font("Garamond", Font.BOLD, 20));
        date.setForeground(Color.ORANGE);

        JTextField tfDate = new JTextField();
        tfDate.setFont(new Font("Garamond", Font.BOLD, 20));
        tfDate.setForeground(Color.BLACK);
        tfDate.setColumns(12);
        tfDate.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(date, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        panel.add(tfDate, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel surName = new JLabel("Customer's Surname: ");
        surName.setFont(new Font("Garamond", Font.ITALIC, 20));
        surName.setForeground(Color.ORANGE);
        JTextField tfSurName = new JTextField();
        tfSurName.setFont(new Font("Garamond", Font.ITALIC, 20));
        tfSurName.setForeground(Color.BLACK);
        tfSurName.setColumns(16);
        panel.add(surName, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        panel.add(tfSurName, new GridBagConstraints(1, 1, 4, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel yName = new JLabel("Customer's Name: ");
        yName.setFont(new Font("Garamond", Font.ITALIC, 20));
        yName.setForeground(Color.ORANGE);
        JTextField tfYName = new JTextField();
        tfYName.setFont(new Font("Garamond", Font.ITALIC, 20));
        tfYName.setForeground(Color.BLACK);
        tfYName.setColumns(12);
        panel.add(yName, new GridBagConstraints(5, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        panel.add(tfYName, new GridBagConstraints(6, 1, 4, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel choose = new JLabel("Choose the good: ");
        choose.setFont(new Font("Garamond", Font.BOLD, 20));
        choose.setForeground(Color.ORANGE);
        panel.add(choose, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        Vector<Water> vat = serv.getBad().getStk().getVat();
        JComboBox combo = new JComboBox(vat);
        combo.setFont(new Font("Garamond", Font.BOLD, 20));
        combo.setForeground(Color.BLACK);
        panel.add(combo, new GridBagConstraints(1, 2, 10, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel quant = new JLabel("Quantity: ");
        quant.setFont(new Font("Garamond", Font.BOLD, 20));
        quant.setForeground(Color.ORANGE);
        NumberFormat nf = NumberFormat.getInstance();
        JFormattedTextField tfQuant = new JFormattedTextField(nf);
        tfQuant.setFont(new Font("Garamond", Font.BOLD, 20));
        tfQuant.setForeground(Color.BLACK);
        tfQuant.setValue(1);
        tfQuant.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(quant, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        panel.add(tfQuant, new GridBagConstraints(1, 3, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JButton buy = new JButton("Buy");
        buy.setFont(new Font("Garamond", Font.BOLD, 20));
        panel.add(buy, new GridBagConstraints(1, 4, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        buy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int date = Integer.parseInt(tfDate.getText());

                Client guest = new Client(tfSurName.getText(), tfYName.getText());
//                for(Client n : serv.getBad().getGuests()){
//                    if(tfSurName.getText().equals(n.getSurName()) && tfYName.getText().equals(n.getName())){
//                        guest = n;
//                        break;
//                    }else{
//                        JOptionPane.showConfirmDialog(null, "There is no such Client in database!", "Client Database", JOptionPane.PLAIN_MESSAGE);
//                        System.out.println("There is no such Client in database!");
//                        guest = new Client(tfSurName.getText(), tfYName.getText());
//                    }
//                }


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

        return panel;
    }
}
