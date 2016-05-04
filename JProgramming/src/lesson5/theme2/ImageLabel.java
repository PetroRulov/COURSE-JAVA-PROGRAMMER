package lesson5.theme2;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLabel extends JFrame {

    private final static String IMAGE_NAME = "McD.jpg";
    private ImageIcon pRulov = new ImageIcon(IMAGE_NAME);
    private String title;


    public ImageLabel(String title){

        super();
        this.title = title;
        setLocation(50, 50);
        setMinimumSize(new Dimension(750, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel label = new JLabel("PETRO RULOV", pRulov, SwingConstants.CENTER);
        getContentPane().add(label);
    }
}

