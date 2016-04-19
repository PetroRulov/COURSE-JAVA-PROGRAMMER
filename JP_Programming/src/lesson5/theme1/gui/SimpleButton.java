package lesson5.theme1.gui;

import javax.swing.*;
import java.awt.*;

public class SimpleButton extends JFrame {

    public SimpleButton(){

        super("SIMPLE BUTTON");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        JButton newButton = new JButton();
        getContentPane().add(newButton);

    }
}
