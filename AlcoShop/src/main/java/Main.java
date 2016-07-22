import bl.Shop;
import datamanagers.DB_Manager;
import view.ShopUI;
import view.Splash;

public class Main {

    public static void main(String[] args)throws InterruptedException {

        new Splash();

        Shop shop = new Shop();

        shop.setDBManager(new DB_Manager());

        new ShopUI(shop);
    }


}