package guis.oldguis;

import domain.Client;
import domain.Sale;
import domain.waters.Water;
import interfaces.IDataProvider;
import util.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * Created by prulov on 26.05.2016.
 */
public class GeshOLDGUI {

    private IDataProvider dataProvider;
    private Service serv;
    private int watIndex = 0;

    public GeshOLDGUI(Service serv) {

        this.serv = serv;
        //this.bad = bad;
        //this.stk = stk;

        JFrame f = new JFrame("\"BADIGAN\" ALCOHOL SHOP TRANSACTION");
        f.setMinimumSize(new Dimension(800, 600));
        f.setLocation(100, 100);
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
        //Border solidBorder = BorderFactory.createLineBorder(Color.ORANGE, 3);
        //date.setBorder(solidBorder);
        date.setFont(new Font("Garamond", Font.BOLD, 20));
        date.setForeground(Color.ORANGE);

        JTextField tfDate = new JTextField();
        tfDate.setColumns(15);
        panel.add(date, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(tfDate, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        JLabel yName = new JLabel("Your Name: ");
        //yName.setBorder(solidBorder);
        yName.setFont(new Font("Garamond", Font.BOLD, 20));
        yName.setForeground(Color.ORANGE);
        JTextField tfName = new JTextField();
        tfName.setColumns(30);
        panel.add(yName, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(tfName, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        JLabel choose = new JLabel("Choose the good: ");
        java.util.List<Water> wat = serv.getBad().getStk().getWaters();
        ButtonGroup watGroup = new ButtonGroup();
        choose.setFont(new Font("Garamond", Font.BOLD, 20));
        choose.setForeground(Color.ORANGE);

        JPanel pWat = new JPanel();
        pWat.setLayout(new GridLayout(wat.size(), 0));
        pWat.setBorder(BorderFactory.createLineBorder(Color.ORANGE));

        ActionListener rbListener = new RBListener();

        for(int i = 0; i < wat.size(); i++){
            if(wat.get(i) != null){
                JRadioButton rb = new JRadioButton(wat.get(i).toString());
                rb.setActionCommand(String.valueOf(i));
                rb.addActionListener(rbListener);
                if(i==0){
                    rb.setSelected(true);
                }
                watGroup.add(rb);
                pWat.add(rb);
            }
        }

        panel.add(choose, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(pWat, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 3, 0, 0), 0, 0));

//        JLabel choose = new JLabel("Choose the good: ");
//        choose.setFont(new Font("Garamond", Font.BOLD, 20));
//        choose.setForeground(Color.ORANGE);
//        panel.add(choose, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//        Vector<Water> vat = serv.getBad().getStk().getVat();;
//        JComboBox combo = new JComboBox(vat);
//        panel.add(combo, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 3, 0, 0), 0, 0));

        JLabel quant = new JLabel("Quantity: ");
        quant.setFont(new Font("Garamond", Font.BOLD, 20));
        quant.setForeground(Color.ORANGE);
        NumberFormat nf = NumberFormat.getInstance();
        JFormattedTextField tfQuant = new JFormattedTextField(nf);
        tfQuant.setValue(1);
        tfQuant.setColumns(30);
        panel.add(quant, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(tfQuant, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        JButton buy = new JButton("Buy");
        buy.setFont(new Font("Garamond", Font.BOLD, 20));
        panel.add(buy, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        buy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int date = Integer.parseInt(tfDate.getText());
                Client guest = new Client();
                guest.setName(tfName.getText());

                Water wat = serv.getBad().getStk().getWaters().get(watIndex);

                int quant = Integer.parseInt(tfQuant.getText());
                Sale sale = new Sale(date, guest, wat, quant);
                sale.saleInfoShow();
                serv.getBad().sellTransaction(date, guest, wat, quant);
            }
        });

        return panel;
    }

    private class RBListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            watIndex = Integer.parseInt(e.getActionCommand());
        }
    }
}
