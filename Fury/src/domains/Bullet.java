package domains;

import enumerations.Direct;
import interfaces.IObjectable;
import tanks.AbstractTank;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bullet implements IObjectable {

    private int speedBullet = 6;
    private int x;
    private int y;
    private Direct direction;
    private AbstractTank tank;
    private Color bullColor = new Color(0, 0, 0);

    private Image[] images;
    private final static String IMAGE_NAME = "bullet.png";
//    private final static String IMAGE_UP = "bull_UP.png";
//    private final static String IMAGE_DOWN = "bull_DOWN.png";
//    private final static String IMAGE_LEFT = "bull_LEFT.png";
//    private final static String IMAGE_RIGHT = "bull_RIGHT.png";
    private Image iBullet;


    public Bullet(int x, int y, Direct direction, AbstractTank tank) {

        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tank = tank;

        //setImages();

        try{
            iBullet = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.err.println("Can't find image of Plant: " + IMAGE_NAME);
        }

    }

//    private void setImages(){
//
//        images = new Image[4];
//        try{
//            images[0] = ImageIO.read(new File(IMAGE_UP));
//            images[1] = ImageIO.read(new File(IMAGE_DOWN));
//            images[2] = ImageIO.read(new File(IMAGE_LEFT));
//            images[3] = ImageIO.read(new File(IMAGE_RIGHT));
//        }catch(IOException e){
//            for(Image i : images){
//                System.err.println("Can't find image BT7: " + i.toString());
//            }
//        }
//    }

    public int getSpeedBullet() {
        return speedBullet;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direct getDirection() {
        return direction;
    }

    public AbstractTank getTank() {
        return tank;
    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }

    @Override
    public void destroy(){

        x = -100;
        y = -100;
        direction = Direct.STOP;
    }

    @Override
    public boolean isDeleted() {

        if(x == -100){
            return true;
        }
        return false;
    }

    @Override
    public void paintComponent(java.awt.Graphics g) {

        g.setColor(bullColor);

        if (tank.getDirection() == Direct.UP || tank.getDirection() == Direct.DOWN) {
            g.fillRect(x, y, 6, 18);
        } else {
            g.fillRect(x, y, 16, 6);
        }
    }


    // one image
    @Override
    public void drawComponent(Graphics g){

        g.drawImage(iBullet, x, y, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }

//    public void drawComponent(Graphics g) {
//
//        if(this.getDirection() == Direct.UP) {
//            iBullet = images[0];
//            g.drawImage(iBullet, x, y, new ImageObserver() {
//
//                @Override
//                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
//                    return false;
//                }
//            });
//        } else if(this.getDirection() == Direct.DOWN) {
//            iBullet = images[1];
//            g.drawImage(iBullet, x, y, new ImageObserver() {
//
//                @Override
//                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
//                    return false;
//                }
//            });
//        } else if(this.getDirection() == Direct.LEFT) {
//            iBullet = images[2];
//            g.drawImage(iBullet, x, y, new ImageObserver() {
//
//                @Override
//                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
//                    return false;
//                }
//            });
//        } else {
//            iBullet = images[3];
//            g.drawImage(iBullet, x, y, new ImageObserver() {
//
//                @Override
//                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
//                    return false;
//                }
//            });
//        }
//    }

}




