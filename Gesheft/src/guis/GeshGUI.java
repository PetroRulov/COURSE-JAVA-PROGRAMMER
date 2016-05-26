package guis;

import domain.waters.Water;
import interfaces.IDataProvider;
import util.Service;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Vector;

/**
 * Created by prulov on 26.05.2016.
 */
public class GeshGUI {

    private IDataProvider dataProvider;
    private Service serv;

    // controller's fields:
    private JTextField tfDate;
    private JTextField tfSurName;
    private JTextField tfYName;
    private JFormattedTextField tfAge;
    private JTextField tfSex;
    private JTextField tfEmail;
    private JComboBox combo;
    private JFormattedTextField tfQuant;
    private JButton buy;


    public GeshGUI(Service serv) {

        this.serv = serv;

        JFrame f = new JFrame("\"BADIGAN\" ALCOHOL SHOP TRANSACTION");
        f.setMinimumSize(new Dimension(800, 350));
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

        NumberFormat nf = NumberFormat.getInstance();

        JLabel date = new JLabel("Date (ddMMyyyy): ");
        date.setFont(new Font("Garamond", Font.BOLD, 20));
        date.setForeground(Color.ORANGE);
        panel.add(date, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfDate = new JTextField();
        tfDate.setFont(new Font("Garamond", Font.BOLD, 20));
        tfDate.setForeground(Color.BLACK);
        tfDate.setColumns(6);
        tfDate.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(tfDate, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel surName = new JLabel("Customer's Surname: ");
        surName.setFont(new Font("Garamond", Font.ITALIC, 20));
        surName.setForeground(Color.ORANGE);
        panel.add(surName, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfSurName = new JTextField();
        tfSurName.setFont(new Font("Garamond", Font.ITALIC, 20));
        tfSurName.setForeground(Color.BLACK);
        tfSurName.setColumns(12);
        panel.add(tfSurName, new GridBagConstraints(1, 1, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel yName = new JLabel("Name: ");
        yName.setFont(new Font("Garamond", Font.ITALIC, 20));
        yName.setForeground(Color.ORANGE);
        yName.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(yName, new GridBagConstraints(4, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfYName = new JTextField();
        tfYName.setFont(new Font("Garamond", Font.ITALIC, 20));
        tfYName.setForeground(Color.BLACK);
        tfYName.setColumns(12);
        panel.add(tfYName, new GridBagConstraints(5, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel age = new JLabel("Customer's Age: ");
        age.setFont(new Font("Garamond", Font.ITALIC, 20));
        age.setForeground(Color.ORANGE);
        panel.add(age, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfAge = new JFormattedTextField(nf);
        tfAge.setForeground(Color.BLACK);
        tfAge.setHorizontalAlignment(JTextField.RIGHT);
        tfAge.setValue(0);
        tfAge.setColumns(6);
        panel.add(tfAge, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel sex = new JLabel("Sex: ");
        sex.setFont(new Font("Garamond", Font.ITALIC, 20));
        sex.setForeground(Color.ORANGE);
        sex.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(sex, new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfSex = new JTextField();
        tfSex.setForeground(Color.BLACK);
        tfSex.setColumns(6);
        panel.add(tfSex, new GridBagConstraints(3, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel eMail = new JLabel("E-mail: ");
        eMail.setFont(new Font("Garamond", Font.ITALIC, 20));
        eMail.setForeground(Color.ORANGE);
        eMail.setHorizontalAlignment(JLabel.RIGHT);
        panel.add(eMail, new GridBagConstraints(4, 2, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfEmail = new JTextField();
        tfEmail.setForeground(Color.BLACK);
        tfEmail.setColumns(16);
        panel.add(tfEmail, new GridBagConstraints(5, 2, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel choose = new JLabel("Choose the good: ");
        choose.setFont(new Font("Garamond", Font.BOLD, 20));
        choose.setForeground(Color.ORANGE);
        panel.add(choose, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        Vector<Water> vat = serv.getBad().getStk().getVat();
        combo = new JComboBox(vat);
        combo.setFont(new Font("Garamond", Font.BOLD, 20));
        combo.setForeground(Color.BLACK);
        panel.add(combo, new GridBagConstraints(1, 3, 10, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel quant = new JLabel("Quantity: ");
        quant.setFont(new Font("Garamond", Font.BOLD, 20));
        quant.setForeground(Color.ORANGE);
        panel.add(quant, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfQuant = new JFormattedTextField(nf);
        tfQuant.setFont(new Font("Garamond", Font.BOLD, 20));
        tfQuant.setForeground(Color.BLACK);
        tfQuant.setValue(1);
        tfQuant.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(tfQuant, new GridBagConstraints(1, 4, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        buy = new JButton("Buy");
        buy.setFont(new Font("Garamond", Font.BOLD, 20));
        panel.add(buy, new GridBagConstraints(1, 5, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        buy.addActionListener(new BuyControl(serv, this));

        return panel;
    }

    public JButton getBuy() {
        return buy;
    }

    public JComboBox getCombo() {
        return combo;
    }

    public JTextField getTfAge() {
        return tfAge;
    }

    public JTextField getTfDate() {
        return tfDate;
    }

    public JTextField getTfEmail() {
        return tfEmail;
    }

    public JFormattedTextField getTfQuant() {
        return tfQuant;
    }

    public JTextField getTfSex() {
        return tfSex;
    }

    public JTextField getTfSurName() {
        return tfSurName;
    }

    public JTextField getTfYName() {
        return tfYName;
    }

}
