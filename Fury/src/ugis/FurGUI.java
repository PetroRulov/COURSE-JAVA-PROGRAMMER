package ugis;

import actions.Slider;
import tanks.AbstractTank;
import tanks.BT7;
import tanks.T34;
import tanks.Tiger;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * Created by prulov on 30.05.2016.
 */
public class FurGUI {

    private Slider slider;
    //private BattleField bF = new BattleField();
    private JFrame f;
    private JPanel panel;

    // controller's fields:
    private JComboBox combo;
    private JButton start;

    // set tanks
    private String agrPos;
    private T34 defender;
    private BT7 agressor;
    private Tiger ogr;

    public FurGUI(Slider slider) {

        this.slider = slider;
        this.f.setDefaultLookAndFeelDecorated(true);
        this.f = new JFrame("* 2DGAME - FURYTANKS - 2DGAME *");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setMinimumSize(new Dimension(1200, 700));
        f.setLocation(0, 0);

        panel = createTankChoosingPannel();
        f.getContentPane().add(panel);

        f.pack();
        f.setVisible(true);
    }

    private JPanel createTankChoosingPannel() {

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.BLACK);

        JLabel choose = new JLabel("Choose the Tank: ");
        choose.setFont(new Font("Garamond", Font.BOLD, 20));
        choose.setForeground(Color.ORANGE);
        panel.add(choose, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        Vector<AbstractTank> tanks = slider.getTanks();
        combo = new JComboBox(tanks);
        combo.setFont(new Font("Garamond", Font.BOLD, 20));
        combo.setForeground(Color.BLACK);
        panel.add(combo, new GridBagConstraints(1, 0, 10, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        start = new JButton("!!!START THE GAME!!!");
        start.setFont(new Font("Garamond", Font.BOLD, 20));
        panel.add(start, new GridBagConstraints(1, 1, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        start.addActionListener(new StartControl(slider, this));

        return panel;
    }

    public JButton getStart() {
        return start;
    }

    public JComboBox getCombo() {
        return combo;
    }

    public JFrame getF() {
        return f;
    }

}
