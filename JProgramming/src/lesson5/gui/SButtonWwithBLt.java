package lesson5.gui;

import javax.swing.*;
import java.awt.*;

public class SButtonWwithBLt extends JFrame {

    public SButtonWwithBLt(){

        super("FLOWLAYOUT WINDOW");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().add(new JButton("Button"), BorderLayout.NORTH);
        getContentPane().add(new JButton("+"), BorderLayout.EAST);
        getContentPane().add(new JButton("-"), BorderLayout.WEST);
        getContentPane().add(new JButton("Long Space"), BorderLayout.SOUTH);
        getContentPane().add(new JButton("CENTER"), BorderLayout.CENTER);
        setSize(450, 200);
    }
}
