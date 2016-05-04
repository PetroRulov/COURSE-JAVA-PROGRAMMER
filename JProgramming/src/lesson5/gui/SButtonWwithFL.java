package lesson5.gui;

import javax.swing.*;
import java.awt.*;

public class SButtonWwithFL extends JFrame{

    public SButtonWwithFL() {

        super("FLOWLAYOUT WINDOW");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

//        FlowLayout newLayout = new FlowLayout();
//        panel.setLayout(newLayout);

        panel.setLayout(new FlowLayout());
        panel.add(new JButton("Button"));
        panel.add(new JButton("+"));
        panel.add(new JButton("-"));
        panel.add(new JButton("Long Space"));
        setContentPane(panel);
        setSize(450, 200);
    }
}
