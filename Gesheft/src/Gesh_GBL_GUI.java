import domain.Stock;
import waters.Water;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.Vector;

public class Gesh_GBL_GUI {

    //private Badigan bad;
    private Stock stk;

    public Gesh_GBL_GUI(Stock stk) {

        //this.bad = bad;
        this.stk = stk;

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

//        JLabel choose = new JLabel("Choose the good: ");
//        Water[] wat = stk.getWat();
//        ButtonGroup watGroup = new ButtonGroup();
//        choose.setFont(new Font("Garamond", Font.BOLD, 20));
//        choose.setForeground(Color.ORANGE);
//
//        JPanel pWat = new JPanel();
//        pWat.setLayout(new GridLayout(wat.length, 0));
//        pWat.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
//        for(Water w : wat){
//            if(w != null){
//                JRadioButton rb = new JRadioButton(w.toString());
//                watGroup.add(rb);
//                pWat.add(rb);
//            }
//        }
//        panel.add(choose, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//        panel.add(pWat, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 3, 0, 0), 0, 0));

        JLabel choose = new JLabel("Choose the good: ");
        choose.setFont(new Font("Garamond", Font.BOLD, 20));
        choose.setForeground(Color.ORANGE);
        panel.add(choose, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        Vector<Water> wat = stk.getVat();
        JComboBox combo = new JComboBox(wat);
        panel.add(combo, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 3, 0, 0), 0, 0));

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

        return panel;
    }
}








