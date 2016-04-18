package lesson5.theme1.theme1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by prulov on 15.04.2016.
 */
public class FillJPanel extends JPanel {

    static int x = 0;
    static int y = 0;
    static int width = 400;
    static int height = 200;

    public FillJPanel(){

        JFrame frame = new JFrame("DAY 5, FillJPanel, Frame 5_1_8");
        frame.setLocation(100, 100);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jP = new JPanel();
//        FlowLayout fLO = new FlowLayout();
//        jP.setLayout(fLO);

        JTextArea field = new JTextArea("VAR 1");
        JFormattedTextField res = new JFormattedTextField("Variant # 1");
        jP.add(field);
        jP.add(res);

        //jP.setBackground(Color.BLACK);
        frame.setContentPane(jP);
        //frame.getContentPane().add(this);

        frame.pack();
        frame.setVisible(true);
    }

//    @Override
//    protected void paintComponent(Graphics g){
//
//        super.paintComponent(g);
//        g.setColor(Color.BLUE);
//        g.fillRect(x, y, width, height);
//    }

    public static void main(String[] args) throws Exception {

        FillJPanel fJP = new FillJPanel();
        Thread.sleep(500);

        width = 800;
        height = 600;

        fJP.repaint();
    }
}
