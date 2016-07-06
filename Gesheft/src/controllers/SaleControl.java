package controllers;

import domain.Client;
import domain.Sale;
import domain.waters.Water;
import guis.GeshGUI;
import guis.SalePanelUI;
import util.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by prulov on 26.05.2016.
 */
public class SaleControl implements ActionListener, Observer {

    private Service serv;
    private SalePanelUI spUI;
    private GeshGUI gGUI;

    public SaleControl(Service serv, SalePanelUI spUI, GeshGUI gGUI){

        this.serv = serv;
        this.spUI = spUI;
        this.gGUI = gGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        String date = spUI.getDate();

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

        Water wat = spUI.getSelectedWater();

        int quant = Integer.parseInt(spUI.getQuantity());

        if(wat.getQuant() >= quant){
            serv.getBad().getStk().soldWaterMinus(wat, quant);
            JOptionPane.showConfirmDialog(null, "Transaction is possible!", "Transaction possibility", JOptionPane.PLAIN_MESSAGE);
            serv.getBad().sellTransaction(serv.getBad().getSales().size() + 1, date, guest, wat, quant);
        }else{
            JOptionPane.showConfirmDialog(null, "Transaction is NOT possible! \n Please, try again with new quantity of item",
                    "Transaction possibility", JOptionPane.OK_CANCEL_OPTION);
        }

        // optional method just to check correct work
        serv.getBad().getStk().printWaters();
    }

    private Client setTransactionClient(){

        Client buyer = null;
        for(Client c : serv.getBad().getClts()){
            if(c.getId_client() == Integer.parseInt(spUI.getBuyerID())){
                buyer = c;
                break;
            }
        }
        return buyer;
    }

    private boolean isPresent(){

        for(Client c : serv.getBad().getClts()){
            if(c.getId_client() == Integer.parseInt(spUI.getBuyerID())){
                return true;
            }
        }
        return false;
    }

    private boolean clientDataAreCorrect(){

        if(spUI.getBuyerID() != null && Integer.parseInt(spUI.getBuyerID()) > 0 && Integer.parseInt(spUI.getBuyerID()) != 901 ){
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
            gGUI.salesTableShow();
        }else{
            System.out.println(this.toString() + " notified.");
        }
    }

}
