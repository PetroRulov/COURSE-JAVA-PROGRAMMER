import java.awt.*;

/**
 * Created by prulov on 22.03.2016.
 */

public class GeshLauncher {

    public static void main(String[] args)throws InterruptedException {

        SplashScreen splash = SplashScreen.getSplashScreen();
        Thread.sleep(2000);

        Graphics2D g = splash.createGraphics();
        g.setColor(Color.GREEN);
        g.setFont(new Font("Garamond", Font.ITALIC, 21));
        g.drawString("LOADING...", 15, 260);
        String s = "_";
        for(int i = 0; i < 7; i++){
            g.drawString(s, 15, 265);
            s+=s;
            splash.update();
            Thread.sleep(1000);
        }
        splash.close();

        Demo d = new Demo();
        d.openBadiganRun();

//        Service serv = new Service();
//        GeshGUI gGui = new GeshGUI(serv);
//        gGui.setBadigan(serv.getBad());

    }
}
