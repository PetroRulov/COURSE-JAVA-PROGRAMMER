package control;

import bl.Shop;
import util.Service;
import view.ShopUI;
import view.panels.SetAdjustedPeriodPanelUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 16.07.2016.
 */
public class SoldByPeriodControl implements ActionListener{

    private Shop shop;
    private Service serv;
    private SetAdjustedPeriodPanelUI periodUI;
    private ShopUI shGUI;
    private String initDate;
    private String endDate;


    public SoldByPeriodControl(Shop shop, SetAdjustedPeriodPanelUI periodUI, ShopUI shGUI, Service serv, String initDate, String endDate){

        this.shop = shop;
        this.serv = serv;
        this.periodUI = periodUI;
        this.shGUI = shGUI;
        this.initDate = periodUI.getInitialDate();
        this.endDate = periodUI.getFinishDate();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        shGUI.adjustedByDateSalesTableShow();

    }

}