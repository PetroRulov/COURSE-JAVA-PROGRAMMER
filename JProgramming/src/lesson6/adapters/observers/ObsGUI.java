package lesson6.adapters.observers;

import lesson6.adapters.observers.domains.PrintMedia;
import lesson6.adapters.observers.domains.Subscriber;
import lesson6.adapters.observers.domains.Subscription;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by prulov on 23.05.2016.
 */
public class ObsGUI {

    private SSDept ssDept;
    private int pmIndex = 0;
    Subscriber sb;
    PrintMedia pm;


    public ObsGUI(SSDept ssDept) {

        this.ssDept = ssDept;

        JFrame f = new JFrame("PRINT MEDIA SUBSCRIPTION");
        f.setMinimumSize(new Dimension(800, 350));
        f.setLocation(100, 100);
        f.getContentPane().add(createSubscriptionPannel());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    private JPanel createSubscriptionPannel() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.BLUE);

        JLabel yName = new JLabel("Your Name: ");
        yName.setFont(new Font("Garamond", Font.BOLD, 20));
        yName.setForeground(Color.ORANGE);
        JTextField tfName = new JTextField();
        tfName.setFont(new Font("Garamond", Font.BOLD, 36));
        tfName.setForeground(Color.BLUE);
        tfName.setColumns(15);
        panel.add(yName, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 0, 0));
        panel.add(tfName, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 0, 0));

        JLabel yEmail = new JLabel("Your E-mail: ");
        yEmail.setFont(new Font("Garamond", Font.BOLD, 20));
        yEmail.setForeground(Color.ORANGE);
        JTextField tfEmail = new JTextField();
        tfEmail.setFont(new Font("Garamond", Font.BOLD, 36));
        tfEmail.setForeground(Color.BLUE);
        tfEmail.setColumns(15);
        panel.add(yEmail, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 0, 0));
        panel.add(tfEmail, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 0, 0));

        JLabel chPM = new JLabel("Choose the PrintMedia: ");
        List<PrintMedia> pms = ssDept.getPms();
        ButtonGroup pmsGroup = new ButtonGroup();
        chPM.setFont(new Font("Garamond", Font.BOLD, 20));
        chPM.setForeground(Color.ORANGE);

        JPanel pWat = new JPanel();
        pWat.setLayout(new GridLayout(pms.size(), 0));
        pWat.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        ActionListener rbListener = new RBListener();

        for(int i = 0; i < pms.size(); i++){
            if(pms.get(i) != null){
                JRadioButton rb = new JRadioButton(pms.get(i).toString());
                rb.setActionCommand(String.valueOf(i));
                rb.addActionListener(rbListener);
                if(i==0){
                    rb.setSelected(true);
                }
                pmsGroup.add(rb);
                pWat.add(rb);
            }
        }
        panel.add(chPM, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 0, 0));
        panel.add(pWat, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(10, 3, 0, 0), 0, 0));

        JButton ss = new JButton("Subscription");
        ss.setFont(new Font("Garamond", Font.BOLD, 20));
        panel.add(ss, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 0, 0));

        ss.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(tfName.getText() != null && tfEmail.getText()!= null &&
                        !tfName.getText().equals("") && !tfEmail.getText().equals("")){
                    sb = new Subscriber(tfName.getText(), tfEmail.getText());
                    pm = ssDept.getPms().get(pmIndex);

                    Subscription sbs = new Subscription(sb, pm);
                    sbs.subScriptionInfoShow();
                    ssDept.subScriptionTransaction(sb, pm);
                    ssDept.printSubScriptionsJournal(ssDept.getSss());
                    sbs.sendTheMessage(sb, pm);

                    JOptionPane.showConfirmDialog(null, "Subscription has been successfully framed!", "Subscription message", JOptionPane.CLOSED_OPTION);

                }else{
                    JOptionPane.showConfirmDialog(null, "Please, input your name and specify your e-mail", "Subscription failed!", JOptionPane.DEFAULT_OPTION);
                    return;
                }
            }
        });

        return panel;

    }

    private class RBListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            pmIndex = Integer.parseInt(e.getActionCommand());
        }
    }
}
