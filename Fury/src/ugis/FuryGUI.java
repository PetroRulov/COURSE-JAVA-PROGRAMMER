package ugis;

import actions.Slider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by prulov on 04.06.2016.
 */
public class FuryGUI extends JPanel {

    private JFrame f;
    private Slider slid;
    private ArrayList<String> results;

    public FuryGUI() throws Exception {

        this.results = new ArrayList<>();

        f = new JFrame("* FURYTANKS - START MENU - FURYTANKS *");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setMinimumSize(new Dimension(1200, 700));
        f.setLocation(0, 0);

        f.getContentPane().add(createTankChoosingPannel());
        f.pack();
        f.setVisible(true);

    }

    private JPanel createTankChoosingPannel() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.BLACK);

        JLabel result = new JLabel("Results: ");
        result.setFont(new Font("Garamond", Font.BOLD, 20));
        result.setForeground(Color.ORANGE);
        panel.add(result, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JTextField tfResult = new JTextField(40);
        tfResult.setFont(new Font("Garamond", Font.BOLD, 20));
        tfResult.setForeground(Color.ORANGE);
        if (results.size() == 0 || results.size() == 1 ) {
            tfResult.setText("0 objects destroyed");
        }else {
            tfResult.setText("1 HQ was destroyed");
        }

        panel.add(tfResult, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel choose = new JLabel("Choose the Tank: ");
        choose.setFont(new Font("Garamond", Font.BOLD, 20));
        choose.setForeground(Color.ORANGE);
        panel.add(choose, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        Vector<String> tanks = initTanks();;
        JComboBox combo = new JComboBox(tanks);
        combo.setFont(new Font("Garamond", Font.BOLD, 20));
        combo.setForeground(Color.BLACK);
        panel.add(combo, new GridBagConstraints(1, 1, 10, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JButton start = new JButton("!!!START THE GAME!!!");
        start.setFont(new Font("Garamond", Font.BOLD, 20));
        panel.add(start, new GridBagConstraints(1, 2, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                f.dispose();
                //f.getContentPane().removeAll();
                Slider slide = null;
                if(combo.getSelectedItem().equals("Tank T-34")) try {
                    slide = new Slider().runTheGame();

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        return panel;
    }

    private Vector<String> initTanks(){

        Vector<String> tanks = new Vector<>();
        tanks.add("Tank T-34");
        tanks.add("Tank BT7");
        tanks.add("Tank Tiger");
        return tanks;

    }

    public static void main(String[] args) throws Exception {

        //new Splash();
        //Slider slider = new Slider();
        //slider.runTheGame();
        new FuryGUI();

    }

    public ArrayList<String> getResults() {
        return new ArrayList<String>(results);
    }

    public void showNewStartGUI(){

        f.getContentPane().removeAll();
        JPanel panel = createTankChoosingPannel();
        f.getContentPane().add(panel);
        f.pack();
        f.repaint();

    }
}
