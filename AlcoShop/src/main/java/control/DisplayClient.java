package control;

import bl.Shop;
import domain.Client;
import domain.waters.Product;
import util.Service;
import view.panels.OrderPanelUI;
import view.panels.SalePanelUI;

import javax.swing.*;
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

        int code = 0;
        if(isInt(spUI.getBuyerID())){
            code = Integer.parseInt(spUI.getBuyerID());
        }else{
            JOptionPane.showConfirmDialog(null, "ERROR: Please, input correct Buyer's ID and try again!",
                    "Error message", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        if(code >=0 && code <= shop.getIdbI().getClts().size() - 1){
            spUI.setTextArea(shop.getIdbI().getClts().get(code).clientInfoShow());
        }else{
            JOptionPane.showConfirmDialog(null, "ERROR: Please, input correct Buyer's ID and try again!",
                    "Error message", JOptionPane.PLAIN_MESSAGE);
            return;
        }

    }

    private boolean isInt(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
