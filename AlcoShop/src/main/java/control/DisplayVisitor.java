package control;

import bl.Shop;
import util.Service;
import view.panels.OrderPanelUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 06.09.2016.
 */
public class DisplayVisitor implements ActionListener {

    private Shop shop;
    private Service serv;
    private OrderPanelUI opUI;

    public DisplayVisitor(Shop shop, Service serv, OrderPanelUI opUI) {
        this.shop = shop;
        this.serv = serv;
        this.opUI = opUI;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        opUI.setVisitortAreaText(shop.getIdbI().getVisitors().get(Integer.parseInt(opUI.getVisitorID())-1).visitorInfoShow());
    }
}
