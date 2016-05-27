package guis;

import domain.Client;
import domain.Sale;
import domain.waters.Water;
import guis.oldguis.SaleJTable;
import util.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by prulov on 26.05.2016.
 */
public class BuyControl implements ActionListener, Observer {

    private Service serv;
    private GeshGUI gGui;


    public BuyControl(Service serv, GeshGUI gGui){

        this.serv = serv;
        this.gGui = gGui;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int date = Integer.parseInt(gGui.getTfDate().getText());

        Client guest = null;
        if(clientDataAreCorrect() && isPresent()){
            JOptionPane.showConfirmDialog(null, "This Client is present in database", "Clients Database", JOptionPane.PLAIN_MESSAGE);
            guest = setClient();
        }else if(clientDataAreCorrect() && !isPresent()){
            guest = setClient();
            serv.getBad().addNewClient(gGui.getTfSurName().getText(), gGui.getTfYName().getText(), Integer.parseInt(gGui.getTfAge().getText()),
                gGui.getTfSex().getText(), gGui.getTfEmail().getText());
        }else{
            JOptionPane.showConfirmDialog(null, "ERROR: Please, input correct data about Client and try again!",
                    "Clients Database", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        Water wat = (Water) gGui.getCombo().getSelectedItem();
        int quant = Integer.parseInt(gGui.getTfQuant().getText());

        if(wat.getQuant() >= quant){
            serv.getBad().getStk().soldWaterMinus(wat, quant);
            JOptionPane.showConfirmDialog(null, "Transaction is possible!", "Transaction possibility", JOptionPane.PLAIN_MESSAGE);
            serv.getBad().sellTransaction(date, guest, wat, quant);
            serv.getBad().saleVectorTransaction(date, guest, wat, quant);
        }else{
            JOptionPane.showConfirmDialog(null, "Transaction is NOT possible! \n Please, try again with new quantity of item",
                    "Transaction possibility", JOptionPane.OK_CANCEL_OPTION);
        }

        // optional methods displaying result

        serv.getBad().getStk().printWat();
        serv.printClientsBase(serv.getBad().getClts());


    }

    private Client setClient(){

        return new Client(gGui.getTfSurName().getText(), gGui.getTfYName().getText(), Integer.parseInt(gGui.getTfAge().getText()),
                gGui.getTfSex().getText(), gGui.getTfEmail().getText());

    }

    private boolean isPresent(){

        Client guest = new Client(gGui.getTfSurName().getText(), gGui.getTfYName().getText(), Integer.parseInt(gGui.getTfAge().getText()),
                gGui.getTfSex().getText(), gGui.getTfEmail().getText());

        if(serv.getBad().getClts().contains(guest)){
            return true;
        }
        return false;
    }

    private boolean clientDataAreCorrect(){

        if(gGui.getTfSurName().getText() != null && !gGui.getTfSurName().getText().equals("") &&
                gGui.getTfYName().getText() != null && !gGui.getTfYName().getText().equals("") &&
                Integer.parseInt(gGui.getTfAge().getText()) != 0 &&
                gGui.getTfSex().getText() != null && !gGui.getTfSex().getText().equals("") &&
                gGui.getTfEmail().getText() != null && !gGui.getTfEmail().getText().equals("")){

            return true;
        }
        return false;
    }

    @Override
    public void update(Observable o, Object arg) {

        if(arg instanceof Sale){
            System.out.println();
            new SaleJTable(serv);
        }else{
            System.out.println(this.toString() + " notified.");
        }

    }
}
