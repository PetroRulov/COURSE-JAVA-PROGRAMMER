package threads.stargates;

import com.sun.deploy.panel.JavaPanel;

import javax.swing.*;
import java.awt.*;

public class SomeField extends JavaPanel {

    private SomeThing someThing;
    private Gate gate;

    public SomeField() {
        JFrame frame = new JFrame("SomeHappened");
        frame.setMinimumSize(new Dimension(400 , 300));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        someThing = new SomeThing();
        gate = new Gate();

        turnOn();
        move();


        while (true){
            repaint();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void turnOn(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    synchronized (gate){
                        gate.wait();
                    }
                    while (!gate.isOpen()){
                        gateOpen();
                    }
                    synchronized (someThing){
                        someThing.notify();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void move() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    moveSomeThing();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void gateOpen()throws Exception{
        while(!gate.isOpen()){
            gate.open();
            repaint();
            Thread.sleep(gate.getSpeed());

        }
        if(gate.isOpen()){
            synchronized (someThing){
                someThing.notify();
            }
        }
    }

    public void moveSomeThing() throws Exception{
        while (someThing.getX()< 400){
            if (gate.isOpen() && soClose()){
                synchronized (gate){
                    gate.notify();
                }
                synchronized (someThing){
                    someThing.wait();
                }
            }
            someThing.fly();
            Thread.sleep(10);
        }
    }

    public boolean soClose(){
        if(someThing.getX()< 250){
            return false;
        }
        return true;
    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        someThing.draw(g);
        gate.draw(g);
    }
}
