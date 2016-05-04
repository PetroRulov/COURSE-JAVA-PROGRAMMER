package lesson5.theme1.theme5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Frame_5_5_4_AngeredFriend extends JPanel {

    JLabel cL;
    int x = 300;
    int y = 300;


    public Frame_5_5_4_AngeredFriend() {

        JFrame frame = new JFrame("CLICK ME:-)!");
        frame.setLocation(50, 0);
        frame.setMinimumSize(new Dimension(700, 700));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //this.addMouseMotionListener(new MouseAdapter()


        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
//                System.out.println("Click");
//                System.out.println(e.getX() + " : " + e.getY()+ " ; " + a + " : " + b);
//                if (Math.abs(e.getX() - a + 35) < 35 && Math.abs(e.getY() - b + 35) < 35) {
//                    System.out.println("YOU WIN");
//                    System.exit(0);
                //}

            }


            @Override
            public void mouseMoved(MouseEvent e){

                if(circleInFrame()){

                    if(e.getX() + 10 <= x){
                        x++;
                        repaint();
                    }
                    if(e.getX() - 10 >= x){
                        x--;
                        repaint();
                    }
                    if(e.getY() + 10 <= y){
                        y++;
                        repaint();
                    }
                    if(e.getY() - 10 >= y){
                        y--;
                        repaint();
                    }
                }else{
                    if(e.getY() > y){
                        y++;

                        repaint();
                    }else{
                        y--;

                        repaint();
                    }
                    if(e.getX() > x){
                        x++;

                        repaint();
                    }else{
                        x--;

                        repaint();
                    }
                }
            }

            private boolean circleInFrame(){

                if(x >= 10 & x < 590 && y >= 10 && y < 590){
                    return true;
                }
                return false;
            }

        });





//        {
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//                if(e.getX() >= 125 && e.getX() <= 375 && e.getY() >= 25 && e.getY() <= 275){
//                    repaint();
//                }
//
//            }
//        });

        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    public void paintComponent (Graphics g){

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(255, 0, 0));
        g.fillOval(x, y, 50, 50);
        g2d.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Garamond", Font.BOLD, 10));
        g.drawString("Click me!", x + 5, y + 30);

    }

    // point of entrance
    public static void main(String[] args){

        new Frame_5_5_4_AngeredFriend();
    }

}
