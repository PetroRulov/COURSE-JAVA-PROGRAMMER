import bl.Shop;
import datamanagers.DB_Manager;
import datamanagers.MySQL_DB_Manager;
import view.ShopUI;
import view.Splash;

public class Main {

    public static void main(String[] args)throws InterruptedException {

        new Splash();

        Shop shop = new Shop();

        shop.setDBManager(new DB_Manager());
        //shop.setDBManager(new MySQL_DB_Manager());

        new ShopUI(shop);
    }


}