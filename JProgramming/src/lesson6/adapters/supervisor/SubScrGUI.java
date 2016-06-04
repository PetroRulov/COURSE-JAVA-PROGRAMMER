package lesson6.adapters.supervisor;

import lesson6.adapters.supervisor.domains.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by prulov on 24.05.2016.
 */
public class SubScrGUI implements Observer {

    private Publisher publ;
    private int pmIndex = 0;
    private Subscriber sb;
    private Media m;
    private JFrame f;

    public SubScrGUI(Publisher publ) {

        this.publ = publ;
        f = new JFrame("PRINT MEDIA SUBSCRIPTION");
        f.setMinimumSize(new Dimension(800, 350));
        f.setLocation(100, 100);
        f.getContentPane().add(createSubscriptionPannel());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    public Media getM() {
        return m;
    }

    public Publisher getPubl() {
        return publ;
    }

    public Subscriber getSb() {
        return sb;
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
        java.util.List<Media> pms = publ.getML();
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

                if(tfName.getText() != null && tfEmail.getText()!= null && !tfName.getText().equals("") && !tfEmail.getText().equals("")){
                    sb = new Subscriber(tfName.getText(), tfEmail.getText());
                    m = publ.getML().get(pmIndex);

                    publ.subScriptionTransaction(sb, m);

                    //Subscription sbS = new Subscription(sb, m);
                    //update(publ, sbS);

                    JOptionPane.showConfirmDialog(null, "Subscription has been successfully framed!", "Subscription message", JOptionPane.CLOSED_OPTION);

                }else{

                    JOptionPane.showConfirmDialog(null, "Please, input your name and specify your e-mail", "Subscription failed!", JOptionPane.DEFAULT_OPTION);
                    return;
                }
            }
        });
        return panel;
    }

    @Override
    public void update(Observable o, Object arg) {

        publ = (Publisher) o;
        if(arg instanceof Subscription){
            System.out.println(this.toString() + " notified. Event " + ((Subscription) arg).subScriptInfo());
            //((Publisher) o).subScriptionTransaction(sb, m);
            System.out.println("To the e-mail: " + sb.geteMail() + " has been delivered the next message: ");
            System.out.println(m.setMessage());
            ((Publisher) o).printSubScriptionsJournal(((Publisher) o).getSss());
            f.dispose();
        }else{
            System.out.println(this.toString() + " notified.");
        }
    }

    private class RBListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                pmIndex = Integer.parseInt(e.getActionCommand());
            }
        }
    }
