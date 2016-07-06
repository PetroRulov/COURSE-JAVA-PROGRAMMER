package guis;

import controllers.SaleControl;
import domain.waters.Water;
import util.Service;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by prulov on 05.07.2016.
 */
public class SalePanelUI {

    private Service serv;
    private GeshGUI gGUI;
    private JPanel salePanel;

    // data
    private List<Water> goods = new ArrayList<>();

    //control fields
    private JTextField tfDate;

    private JFormattedTextField tfBID;
    private JFormattedTextField tfQuant;

    private JComboBox combo;

    public SalePanelUI(Service serv){
        this.serv = serv;
        this.salePanel = createSalePanel();
    }

    public JPanel createSalePanel() {

        salePanel = new JPanel();
        salePanel.setLayout(new GridBagLayout());
        salePanel.setBackground(Color.BLACK);

        goods = serv.getBad().getStk().getWaters();

        NumberFormat nf = NumberFormat.getInstance();

        JLabel date = new JLabel("Date (dd.MM.yyyy): ");
        date.setFont(new Font("Garamond", Font.BOLD, 20));
        date.setForeground(Color.ORANGE);
        salePanel.add(date, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfDate = new JTextField();
        tfDate.setFont(new Font("Garamond", Font.BOLD, 20));
        tfDate.setForeground(Color.BLACK);
        tfDate.setColumns(6);
        tfDate.setHorizontalAlignment(JTextField.RIGHT);
        tfDate.setText(dateFormat(new Date(System.currentTimeMillis())));
        salePanel.add(tfDate, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel id = new JLabel("Customer's identify #: ");
        id.setFont(new Font("Garamond", Font.ITALIC, 20));
        id.setForeground(Color.ORANGE);
        salePanel.add(id, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfBID = new JFormattedTextField(nf);
        tfBID.setFont(new Font("Garamond", Font.ITALIC, 20));
        tfBID.setForeground(Color.BLACK);
        tfBID.setColumns(12);
        tfBID.setHorizontalAlignment(JTextField.RIGHT);
        tfBID.setValue(serv.getBad().getClts().size() + 1);
        salePanel.add(tfBID, new GridBagConstraints(1, 2, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel choose = new JLabel("Choose the good: ");
        choose.setFont(new Font("Garamond", Font.BOLD, 20));
        choose.setForeground(Color.ORANGE);
        salePanel.add(choose, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        combo = new JComboBox(new MyComboBoxModel(goods));
        combo.setFont(new Font("Garamond", Font.BOLD, 20));
        combo.setForeground(Color.BLACK);
        salePanel.add(combo, new GridBagConstraints(1, 4, 10, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel quant = new JLabel("Quantity: ");
        quant.setFont(new Font("Garamond", Font.BOLD, 20));
        quant.setForeground(Color.ORANGE);
        salePanel.add(quant, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfQuant = new JFormattedTextField(nf);
        tfQuant.setFont(new Font("Garamond", Font.BOLD, 20));
        tfQuant.setForeground(Color.BLACK);
        tfQuant.setValue(1);
        tfQuant.setHorizontalAlignment(JTextField.RIGHT);
        salePanel.add(tfQuant, new GridBagConstraints(1, 5, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JButton buy = new JButton("Buy");
        buy.setFont(new Font("Garamond", Font.BOLD, 20));
        salePanel.add(buy, new GridBagConstraints(1, 6, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        buy.addActionListener(new SaleControl(serv, this, gGUI));

        return salePanel;
    }

    public String dateFormat(Date d){

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(d);
    }

    public JTextField getTfDate() {
        return tfDate;
    }

    public String getDate(){

        return getTfDate().getText();
    }

    public JFormattedTextField getTfBID() {
        return tfBID;
    }

    public String getBuyerID(){

        return getTfBID().getText();
    }

    public JFormattedTextField getTfQuant() {
        return tfQuant;
    }

    public String getQuantity(){

        return getTfQuant().getText();
    }

    public JComboBox getCombo() {
        return combo;
    }

    public Water getSelectedWater(){

        return (Water) getCombo().getSelectedItem();
    }
}
