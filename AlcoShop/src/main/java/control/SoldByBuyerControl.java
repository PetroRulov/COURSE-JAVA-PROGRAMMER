package control;

import bl.Shop;
import util.Service;
import view.ShopUI;
import view.panels.SetAdjustedBuyerPanelUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 18.07.2016.
 */
public class SoldByBuyerControl implements ActionListener {

    private Shop shop;
    private Service serv;
    private SetAdjustedBuyerPanelUI buyerUI;
    private ShopUI shGUI;
    private int buyerID;

    public SoldByBuyerControl(Shop shop, SetAdjustedBuyerPanelUI buyerUI, ShopUI shGUI, Service serv, int buyerID){

        this.shop = shop;
        this.serv = serv;
        this.buyerUI = buyerUI;
        this.shGUI = shGUI;
        this.buyerID = buyerUI.getBuyersID();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        shGUI.adjustedByBuyerSalesTableShow();

    }

}
