package control;

import bl.Shop;
import domain.Client;
import domain.waters.Product;
import util.Service;
import view.panels.OrderPanelUI;
import view.panels.SalePanelUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 05.09.2016.
 */
public class DisplayClient implements ActionListener {

    private Shop shop;
    private Service serv;
    private SalePanelUI spUI;

    public DisplayClient(Shop shop, Service serv, SalePanelUI spUI) {
        this.shop = shop;
        this.serv = serv;
        this.spUI = spUI;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        spUI.setTextArea(shop.getIdbI().getClts().get(Integer.parseInt(spUI.getBuyerID())-1).clientInfoShow());
    }
}
