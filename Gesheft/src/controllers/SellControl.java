package controllers;

import domain.Client;
import domain.Sale;
import domain.waters.Water;
import guis.GeshGUI;
import util.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by prulov on 26.05.2016.
 */
public class SellControl implements ActionListener, Observer {

    private Service serv;
    private GeshGUI gGui;

    public SellControl(Service serv, GeshGUI gGui){

        this.serv = serv;
        this.gGui = gGui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String date = gGui.getDate();

        Client guest = null;
        if(clientDataAreCorrect() && isPresent()){
            JOptionPane.showConfirmDialog(null, "This Client is already present in the database", "Clients Database", JOptionPane.PLAIN_MESSAGE);
            guest = setTransactionClient();
        }else if(clientDataAreCorrect() && !isPresent()){
            guest = setDefaultClient();
            //JOptionPane.showConfirmDialog(null, "New Client was successfully added in the database!", "Clients Database", JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showConfirmDialog(null, "ERROR: Please, input correct data about Client and try again!",
                    "Clients Database", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        Water wat = gGui.getSelectedWater();

        int quant = Integer.parseInt(gGui.getQuantity());

        if(wat.getQuant() >= quant){
            serv.getBad().getStk().soldWaterMinus(wat, quant);
            JOptionPane.showConfirmDialog(null, "Transaction is possible!", "Transaction possibility", JOptionPane.PLAIN_MESSAGE);
            serv.getBad().sellTransaction(serv.getBad().getSales().size() + 1, date, guest, wat, quant);
        }else{
            JOptionPane.showConfirmDialog(null, "Transaction is NOT possible! \n Please, try again with new quantity of item",
                    "Transaction possibility", JOptionPane.OK_CANCEL_OPTION);
        }

        // optional methods displaying result in console

        serv.getBad().getStk().printWaters();
    }

    private Client setTransactionClient(){

        Client buyer = null;
        for(Client c : serv.getBad().getClts()){
            if(c.getId_client() == Integer.parseInt(gGui.getBuyerID())){
                buyer = c;
                break;
            }
        }
        return buyer;
    }

    private boolean isPresent(){

        for(Client c : serv.getBad().getClts()){
            if(c.getId_client() == Integer.parseInt(gGui.getBuyerID())){
                return true;
            }
        }
        return false;
    }

    private boolean clientDataAreCorrect(){

        if(gGui.getBuyerID() != null && Integer.parseInt(gGui.getBuyerID()) > 0 && Integer.parseInt(gGui.getBuyerID()) != 901 ){
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
            gGui.newSalesTableShow();
        }else{
            System.out.println(this.toString() + " notified.");
        }
    }

}
