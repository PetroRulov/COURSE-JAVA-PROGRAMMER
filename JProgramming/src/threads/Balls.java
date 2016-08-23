package threads;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Balls extends JPanel{

    public static void main(String[] args) throws Exception{
        new Balls();
    }

    private static final int WIDTH = 400;
    private Ball b;
    private List<Ball> balls = new LinkedList();

    private static final Color[] COLORS = new Color[]{
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            new Color(30,144,255),
            Color.BLUE,
            new Color(123,104,238),
            Color.WHITE,
            Color.BLACK
    };


    public Balls()  throws InterruptedException{
        JFrame frame = new JFrame("BALLS");
        frame.setLocation(450, 150);
        frame.setMinimumSize(new Dimension(WIDTH, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        createBalls();

        while(true){
            repaint();
            Thread.sleep(1000/60);
        }
    }

    public  void createBalls(){
        int line = 10;
        int speed = 10;
        for(Color col: COLORS){
            b = new Ball(col, 20, line, 20, 20, speed);
            balls.add(b);
            new Thread(b).start();
            line+=30;
            speed++;
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Ball ball: balls){
            ball.draw(g);
        }
    }


    class Ball implements Runnable{
        Color color;
        int x;
        int y;
        int w;
        int h;
        int speed;

        Ball(){

        }

        Ball(Color color, int x, int y, int w, int h, int speed){
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.speed = speed;
            this.color = color;
        }

        public void action() throws InterruptedException{
            int step = 1;
            while(true){
                x+=step;
                if(x<0 || x>(WIDTH-36)){step*=-1;}
                Thread.sleep(speed);
            }
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(x, y, w , h);
        }

        @Override
        public void run() {
            try {
                action();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}