package ugis;

import java.awt.*;

/**
 * Created by prulov on 30.05.2016.
 */
public class Splash {

    public Splash() throws InterruptedException{

        int y = 700;
        SplashScreen splash = SplashScreen.getSplashScreen();
        Thread.sleep(3000);

        Graphics2D g = splash.createGraphics();
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 28));
        g.drawString("LOADING...", 15, y);
        String s = "_";
        for(int i = 0; i < 8; i++){
            g.drawString(s, 15, y + 5);
            s+=s;
            splash.update();
            Thread.sleep(1000);
        }
        splash.close();

    }

}
