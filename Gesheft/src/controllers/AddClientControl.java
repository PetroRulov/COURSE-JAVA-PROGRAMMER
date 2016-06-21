package controllers;
import domain.Client;
import guis.GeshGUI;
import util.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by prulov on 19.06.2016.
 */
public class AddClientControl implements ActionListener, Observer {

    private Service serv;
    private GeshGUI gGui;

    public AddClientControl(Service serv, GeshGUI gGui) {

        this.serv = serv;
        this.gGui = gGui;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Client guest = null;
        if(clientDataAreCorrect() && isPresent()){
            JOptionPane.showConfirmDialog(null, "This Client is present in the database \n Try again, please.", "Clients Database", JOptionPane.PLAIN_MESSAGE);
        }else if(clientDataAreCorrect() && !isPresent()){
            guest = setClient();
            serv.getBad().addNewClient(Integer.parseInt(gGui.getClientID()), gGui.getSurName(), gGui.getName(), gGui.getAge(), gGui.getSex(),
                    gGui.getEmail());
            JOptionPane.showConfirmDialog(null, "New Client was successfully added in the database!", "Clients Database", JOptionPane.PLAIN_MESSAGE);

            // optional methods displaying result in console
            serv.printClientsBase(serv.getBad().getClts());

        }else{
            JOptionPane.showConfirmDialog(null, "ERROR: Please, input correct Client's data and try again!",
                    "Clients Database", JOptionPane.PLAIN_MESSAGE);
            return;
        }
    }

    @Override
    public void update(Observable o, Object arg) {

        if (arg instanceof Client) {
            gGui.newSalesTableShow();
        }else{
            System.out.println(this.toString() + " notified.");
        }
    }

    private Client setClient(){

        return new Client(Integer.parseInt(gGui.getClientID()), gGui.getSurName(), gGui.getName(),
                gGui.getAge(), gGui.getSex(), gGui.getEmail());

    }

    private boolean isPresent(){

        for(Client c : serv.getBad().getClts()){
            if(c.getId_client() == Integer.parseInt(gGui.getClientID())){
                return true;
            }
        }
        return false;
    }

    private boolean clientDataAreCorrect(){

        if(gGui.getSurName() != null && ! gGui.getSurName().equals("") &&
                gGui.getName() != null && ! gGui.getName().equals("") &&
                gGui.getAge() != null && ! gGui.getAge().equals("") &&
                gGui.getSex() != null && ! gGui.getSex().equals("") &&
                gGui.getEmail() != null && ! gGui.getEmail().equals("")){
            return true;
        }
        return false;
    }
}
