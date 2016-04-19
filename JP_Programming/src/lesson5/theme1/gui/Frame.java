package lesson5.theme1.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by prulov on 19.04.2016.
 */
public class Frame {

    public static void main(String[] args){

        JFrame myWindow = new JFrame("SAMPLE WINDOW");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setBackground(Color.BLACK);
        myWindow.setLocation(300, 300);
        myWindow.setSize(400, 400);

        //myWindow.pack();
        myWindow.setVisible(true);

    }
}
