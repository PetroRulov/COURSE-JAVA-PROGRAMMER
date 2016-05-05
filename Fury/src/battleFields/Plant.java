package battleFields;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Plant extends AbstractComponent {

    private final static String IMAGE_NAME = "plant.png";
//    private final static String IMAGE_PLANT = "plant.png";
//    private final static String IMAGE_PALMS = "plantWithpalms.png";
    private Image iPlant;

    public Plant(){}

    public Plant(int x, int y) throws Exception{

        super(x, y);
        this.wayable = 1;
        this.name = "P";
        this.x = x;
        this.y = y;
        this.color = new Color(180, 180, 180);
        //setImages();

        try{
            iPlant = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.err.println("Can't find image of Plant: " + IMAGE_NAME);
        }

    }

//    protected void setImages(){
//
//        images = new Image[2];
//        try{
//            images[0] = ImageIO.read(new File(IMAGE_PLANT));
//            images[1] = ImageIO.read(new File(IMAGE_PALMS));
//        }catch(IOException e){
//            for(Image i : images){
//                System.err.println("Can't find image of Plant: " + i.toString());
//            }
//        }
//    }

    @Override
    public void paintComponent(Graphics g){

        g.drawImage(iPlant, x, y, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }

//    @Override
//    public void paintComponent(Graphics g){
//
//        if(x % 3 == 0){
//            g.drawImage(images[1], x, y, new ImageObserver() {
//
//                @Override
//                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
//                    return false;
//                }
//            });
//        }else{
//            g.drawImage(images[0], x, y, new ImageObserver() {
//
//                @Override
//                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
//                    return false;
//                }
//            });
//        }
//    }

}