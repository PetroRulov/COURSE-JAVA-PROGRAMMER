package control;

import bl.Shop;
import domain.Client;
import domain.Sale;
import domain.waters.Water;
import domain.waters.WaysOfSale;
import util.Service;
import view.ShopUI;
import view.panels.SalePanelUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by prulov on 26.05.2016.
 */
public class SaleControl implements ActionListener, Observer {

    private Shop shop;
    private Service serv;
    private SalePanelUI spUI;
    private ShopUI shGUI;


    public SaleControl(Shop shop, SalePanelUI spUI, ShopUI shGUI, Service serv){

        this.shop = shop;
        this.serv = serv;
        this.spUI = spUI;
        this.shGUI = shGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(spUI.getSelectedWater()!=null && Integer.parseInt(spUI.getQuantity())>0){
            long id = shop.getSales().size() + 1;

            String date = spUI.getDate();

            Client guest = null;
            if(clientDataAreCorrect() && clientIsPresent()){
                JOptionPane.showConfirmDialog(null, "This Client is already present in the database", "Clients Database", JOptionPane.PLAIN_MESSAGE);
                guest = setTransactionClient();
            }else if(clientDataAreCorrect() && !clientIsPresent()){
                guest = setDefaultClient();
            }else{
                JOptionPane.showConfirmDialog(null, "ERROR: Please, input correct data about Client and try again!",
                        "Clients Database", JOptionPane.PLAIN_MESSAGE);
                return;
            }

            Water wat = spUI.getSelectedWater();

            int quant = Integer.parseInt(spUI.getQuantity());

            if(wat.getQuant() >= quant){
                shop.getIdbI().soldWaterMinus(wat, quant);
                JOptionPane.showConfirmDialog(null, "Transaction is possible!", "Transaction possibility", JOptionPane.PLAIN_MESSAGE);
                Sale neo = new Sale(id, date, guest, wat, quant);
                if(clientIsPresent()){
                    BigDecimal fin = neo.getIncome().multiply(new BigDecimal(0.9));
                    neo.setIncome(fin.setScale(2, BigDecimal.ROUND_HALF_UP));
                }
                WaysOfSale wos = WaysOfSale.SHOP;
                neo.setWos(wos);
                long orderID = 0;
                neo.setOrderID(orderID);
                shop.addSaleTransaction(neo);
            }else{
                JOptionPane.showConfirmDialog(null, "Transaction is NOT possible! \n Please, try again with new quantity of item",
                        "Transaction possibility", JOptionPane.OK_CANCEL_OPTION);
            }
        }else{
            JOptionPane.showConfirmDialog(null, "Transaction is NOT possible! \n Please, select item and correct quantity",
                    "Transaction possibility", JOptionPane.OK_CANCEL_OPTION);
        }
    }

    private Client setTransactionClient(){
        Client buyer = null;
        for(Client c : shop.getIdbI().getClts()){
            if(c.getId_client() == Integer.parseInt(spUI.getBuyerID())){
                buyer = c;
                break;
            }
        }
        return buyer;
    }

    private boolean clientIsPresent(){
        for(Client c : shop.getIdbI().getClts()){
            if(c.getId_client() == Integer.parseInt(spUI.getBuyerID())){
                return true;
            }
        }
        return false;
    }

    private boolean clientDataAreCorrect(){
        if(Integer.parseInt(spUI.getBuyerID()) > 0 && Integer.parseInt(spUI.getBuyerID()) != 901 ){
            return true;
        }
        return false;
    }

    private Client setDefaultClient(){
        return new Client(901, "default", "default", "default", "default", "default");
    }

    @Override
    public void update(Observable o, Object arg) {

        if (arg instanceof Sale) {
            shGUI.salesTableShow();
        }else{
            System.out.println(this.toString() + " notified.");
        }
    }
}

