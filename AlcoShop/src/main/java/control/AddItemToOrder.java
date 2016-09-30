package control;

import bl.Shop;
import domain.waters.Product;
import util.Service;
import view.panels.OrderPanelUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by prulov on 22.08.2016.
 */
public class AddItemToOrder implements ActionListener {

    private Shop shop;
    private Service serv;
    private List<Product> list;
    private OrderPanelUI opUI;

    public AddItemToOrder(Shop shop, Service serv, OrderPanelUI opUI) {
        this.shop = shop;
        this.serv = serv;
        this.opUI = opUI;
        this.list = shop.getIdbI().getProducts();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int quantity = 0;
        if(isInt(opUI.getQuantity())){
            quantity = Integer.parseInt(opUI.getQuantity());
        }else{
            JOptionPane.showConfirmDialog(null, "ERROR: Please, input correct Quantity and try again!",
                    "Error message", JOptionPane.PLAIN_MESSAGE);
            return;
        }


        if(opUI.getSelectedWater()!=null && quantity > 0){
            Product product = null;
            for (int i = 0; i < list.size(); i++) {
                if (opUI.getSelectedWater().equals(list.get(i))) {
                    product = list.get(i);
                    product.setCount(quantity);

                }
            }
            serv.addOrderItems(product);

            for (int i = 0; i < serv.getOrderItems().size(); i++) {
                opUI.setTextArea(serv.getOrderItems().get(i).waterShow());
            }

            BigDecimal outcome = new BigDecimal(0.0);
            for (Product prod : serv.getOrderItems()) {
                outcome = outcome.add(prod.getPrice().multiply(new BigDecimal(prod.getCount())));
            }
            opUI.setTextOrderValue(outcome);
        }else{
            JOptionPane.showConfirmDialog(null, "Order is not formed! \n Please, select item and try again with new quantity",
                    "Order's execution possibility", JOptionPane.OK_CANCEL_OPTION);
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
