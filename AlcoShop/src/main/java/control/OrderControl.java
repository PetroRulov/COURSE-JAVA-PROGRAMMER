package control;

import bl.Shop;
import domain.Order;
import domain.Visitor;
import domain.waters.*;
import util.Service;
import view.ShopUI;
import view.panels.OrderPanelUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class OrderControl implements ActionListener {

    private Shop shop;
    private Service serv;
    private OrderPanelUI opUI;
    private ShopUI shGUI;

    public OrderControl(Shop shop, OrderPanelUI opUI, ShopUI shGUI, Service serv){
        this.shop = shop;
        this.serv = serv;
        this.opUI = opUI;
        this.shGUI = shGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Visitor guest = null;
        if(visitorIsPresent()){
            guest = setTransactionVisitor();
        }else{
            JOptionPane.showConfirmDialog(null, "ERROR: Please, input correct data about Visitor and try again!",
                    "Clients Database", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        long id = Long.parseLong(opUI.getOrderID());
        String date = opUI.getDate();
        OrderStatus ordSt = opUI.getSelectedOrderStatus();
        PaymentTermsType pTT = opUI.getSelectedPaymentTermType();

        for(Product product : serv.getOrderItems()){
            Water wat = (Water) product;
            int count = product.getCount();

            if(wat.getQuant() >= count){
                shop.getIdbI().soldWaterMinus(wat, count);
                JOptionPane.showConfirmDialog(null, "Order execution is possible!", "Order's execution possibility", JOptionPane.PLAIN_MESSAGE);
                Order neo = new Order(id, date, ordSt, pTT, wat, count, guest);
                BigDecimal income = neo.calcIncome(count);
                neo.setIncome(income);
                shop.addNewOrderInJournal(neo);

            }else{
                JOptionPane.showConfirmDialog(null, "Order execution is NOT possible! \n Please, try again with new quantity of item",
                    "Order's execution possibility", JOptionPane.OK_CANCEL_OPTION);
            }
            serv.clearOrderItems();
        }
    }

    private Visitor setTransactionVisitor(){
        Visitor customer = null;
        for(Visitor v : shop.getIdbI().getVisitors()){
            if(v.getId_code() == Integer.parseInt(opUI.getVisitorID())){
                customer = v;
                break;
            }
        }
        return customer;
    }

    private boolean visitorIsPresent(){
        for(Visitor v : shop.getIdbI().getVisitors()){
            if(v.getId_code() == Integer.parseInt(opUI.getVisitorID())){
                return true;
            }
        }
        return false;
    }
}
