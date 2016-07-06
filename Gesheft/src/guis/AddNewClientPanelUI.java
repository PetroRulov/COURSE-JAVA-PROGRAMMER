package guis;

import controllers.AddClientControl;
import util.Service;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

/**
 * Created by prulov on 05.07.2016.
 */
public class AddNewClientPanelUI {

    private Service serv;
    private GeshGUI gGUI;
    private JPanel ncPanel;

    // contol fields
    private JTextField tfSurName;
    private JTextField tfName;
    private JTextField tfAge;
    private JTextField tfSex;
    private JTextField tfEmail;

    private JFormattedTextField tfClID; // Client's ID for Client's Database

    public AddNewClientPanelUI(Service serv){
        this.serv = serv;
        this.ncPanel = createAddNewClientPanel();
    }

    public JPanel createAddNewClientPanel() {

        ncPanel = new JPanel();
        ncPanel.setLayout(new GridBagLayout());
        ncPanel.setBackground(Color.WHITE);

        NumberFormat nf = NumberFormat.getInstance();

        ImageIcon icon = new ImageIcon(getClass().getResource("strawberry.gif"));
        JLabel picture = new JLabel(icon);
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.LEFT);
        //picture.setIcon(icon);
        picture.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        ncPanel.add(picture, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel id = new JLabel("Client's ID #: ");
        id.setFont(new Font("Garamond", Font.ITALIC, 20));
        id.setForeground(Color.BLUE);
        ncPanel.add(id, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfClID = new JFormattedTextField(nf);
        tfClID.setFont(new Font("Garamond", Font.ITALIC, 20));
        tfClID.setForeground(Color.BLACK);
        tfClID.setColumns(12);
        tfClID.setValue(serv.getBad().getClts().size() + 1);
        tfClID.setHorizontalAlignment(JTextField.RIGHT);
        ncPanel.add(tfClID, new GridBagConstraints(1, 1, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel surName = new JLabel("Client's Surname: ");
        surName.setFont(new Font("Garamond", Font.ITALIC, 20));
        surName.setForeground(Color.BLUE);
        ncPanel.add(surName, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfSurName = new JTextField();
        tfSurName.setFont(new Font("Garamond", Font.ITALIC, 20));
        tfSurName.setForeground(Color.BLACK);
        tfSurName.setColumns(12);
        ncPanel.add(tfSurName, new GridBagConstraints(1, 2, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel yName = new JLabel("Name: ");
        yName.setFont(new Font("Garamond", Font.ITALIC, 20));
        yName.setForeground(Color.BLUE);
        yName.setHorizontalAlignment(JLabel.RIGHT);
        ncPanel.add(yName, new GridBagConstraints(4, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfName = new JTextField();
        tfName.setFont(new Font("Garamond", Font.ITALIC, 20));
        tfName.setForeground(Color.BLACK);
        tfName.setColumns(12);
        ncPanel.add(tfName, new GridBagConstraints(5, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel age = new JLabel("Client's date of birth: ");
        age.setFont(new Font("Garamond", Font.ITALIC, 20));
        age.setForeground(Color.BLUE);
        ncPanel.add(age, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfAge = new JTextField();
        tfAge.setForeground(Color.BLACK);
        tfAge.setHorizontalAlignment(JTextField.RIGHT);
        tfAge.setColumns(6);
        tfAge.setText("00/00/0000");
        ncPanel.add(tfAge, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel sex = new JLabel("Sex: ");
        sex.setFont(new Font("Garamond", Font.ITALIC, 20));
        sex.setForeground(Color.BLUE);
        sex.setHorizontalAlignment(JLabel.RIGHT);
        ncPanel.add(sex, new GridBagConstraints(2, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfSex = new JTextField();
        tfSex.setForeground(Color.BLACK);
        tfSex.setColumns(6);
        ncPanel.add(tfSex, new GridBagConstraints(3, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel eMail = new JLabel("E-mail: ");
        eMail.setFont(new Font("Garamond", Font.ITALIC, 20));
        eMail.setForeground(Color.BLUE);
        eMail.setHorizontalAlignment(JLabel.RIGHT);
        ncPanel.add(eMail, new GridBagConstraints(4, 3, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfEmail = new JTextField();
        tfEmail.setForeground(Color.BLACK);
        tfEmail.setColumns(16);
        ncPanel.add(tfEmail, new GridBagConstraints(5, 3, 1, 1, 0, 0, GridBagConstraints.LINE_END, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JButton addNewClient = new JButton("Add new Client");
        addNewClient.setFont(new Font("Garamond", Font.BOLD, 20));
        ncPanel.add(addNewClient, new GridBagConstraints(1, 4, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        addNewClient.addActionListener(new AddClientControl(serv, this, gGUI));

        return ncPanel;

    }

    public JTextField getTfSurName() {
        return tfSurName;
    }

    public String getSurName(){

        return getTfSurName().getText();
    }

    public JTextField getTfName() {
        return tfName;
    }

    public String getName(){

        return getTfName().getText();
    }

    public JTextField getTfAge() {
        return tfAge;
    }

    public String getAge(){

        return getTfAge().getText();
    }

    public JTextField getTfSex() {
        return tfSex;
    }

    public String getSex(){

        return getTfSex().getText();
    }

    public JTextField getTfEmail() {
        return tfEmail;
    }

    public String getEmail(){

        return getTfEmail().getText();
    }

    public JFormattedTextField getTfClID() {
        return tfClID;
    }

    public String getClientID(){

        return getTfClID().getText();
    }

}
