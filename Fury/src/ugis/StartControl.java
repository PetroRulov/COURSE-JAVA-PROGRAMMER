package ugis;

import actions.Slider;
import tanks.AbstractTank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 30.05.2016.
 */
public class StartControl implements ActionListener {

    private Slider slid;
    private FurGUI fGui;

    public StartControl(Slider slid, FurGUI fGui) {

        this.slid = slid;
        this.fGui = fGui;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        AbstractTank tank = (AbstractTank) fGui.getCombo().getSelectedItem();

        fGui.getF().dispose();

        try {
            slid.runTheGame();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }
}