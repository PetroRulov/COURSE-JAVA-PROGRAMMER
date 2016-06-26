package ugis;

import actions.Slider;
import battleFields.BattleField;

import javax.swing.*;
import java.awt.*;

/**
 * Created by prulov on 24.06.2016.
 */
public class BattleView extends JPanel {

    private Slider slide;
    private BattleField batF;
    private JFrame frame;

    public BattleView(Slider slide, BattleField batF){

        this.slide = slide;
        this.batF = batF;

        frame = new JFrame("FURY BATTLEFIELD");
        frame.setLocation(0, 0);
        frame.setMinimumSize(new Dimension(batF.getBF_WIDTH() + 16, batF.getBF_HEIGHT() + 40));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(slide);
        frame.pack();
        frame.setVisible(true);
    }

    public BattleField getBatF() {
        return batF;
    }

    public JFrame getFrame() {
        return frame;
    }

    public Slider getSlide() {
        return slide;
    }
}
