package guis;

import domain.Client;
import domain.waters.Water;
import guis.oldguis.SaleJTable;
import util.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 26.05.2016.
 */
public class BuyControl implements ActionListener {

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
        if(isPresent()){
            JOptionPane.showConfirmDialog(null, "This Client is present in database", "Clients Database", JOptionPane.PLAIN_MESSAGE);
            guest = setClient();
        }else{
            guest = setClient();
            serv.getBad().addNewClient(gGui.getTfSurName().getText(), gGui.getTfYName().getText(), Integer.parseInt(gGui.getTfAge().getText()),
                gGui.getTfSex().getText(), gGui.getTfEmail().getText());
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
        serv.printSalesJournal(serv.getBad().getSales());
        serv.getBad().getStk().printWat();
        serv.printClientsBase(serv.getBad().getClts());
        new SaleJTable(serv);

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
}
