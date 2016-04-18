package lesson5.theme1.theme1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by prulov on 14.04.2016.
 */
public class Window2DGraphics {

    public static void main(String[] args){

        JFrame f = new JFrame();
        f.setLocation(300, 100);
        f.setMinimumSize(new Dimension(800, 600));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.pack();
        f.setVisible(true);

    }
}
