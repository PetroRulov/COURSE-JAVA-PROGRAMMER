package lesson5.theme1.theme2;

import javax.swing.*;
import java.awt.*;

public class Inscription extends JPanel {

    public Inscription(){

    JFrame frame = new JFrame("DAY 5, Inscription in JPanel, Frame 5_2_2");
    frame.setLocation(300, 100);
    frame.setMinimumSize(new Dimension(800, 600));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout blt = new BorderLayout();
        this.setLayout(blt);

    JLabel field = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit", JLabel.CENTER);
        field.setFont(new Font("Garamond", Font.ITALIC, 36));
        field.setForeground(Color.ORANGE);
        this.add(field);
        frame.getContentPane().add(this);

    frame.pack();
    frame.setVisible(true);
}


    @Override
    protected void paintComponent(Graphics g){

        //super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);

    }

    public static void main(String[] args) throws Exception {
        new Inscription();

    }
}


