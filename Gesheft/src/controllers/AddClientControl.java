package controllers;
import domain.Client;
import guis.AddNewClientPanelUI;
import guis.GeshGUI;
import interfaces.IDB_Manager;
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
    private AddNewClientPanelUI ancPUI;
    private GeshGUI gGUI;
    private IDB_Manager idbManager;


    public AddClientControl(Service serv, AddNewClientPanelUI ancPUI, GeshGUI gGUI) {

        this.serv = serv;
        this.ancPUI = ancPUI;
        this.gGUI = gGUI;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Client guest = null;
        if(clientDataAreCorrect() && isPresent()){
            JOptionPane.showConfirmDialog(null, "This Client is present in the database \n Try again, please.", "Clients Database", JOptionPane.PLAIN_MESSAGE);
        }else if(clientDataAreCorrect() && !isPresent()){
            guest = setClient();
            serv.getBad().addNewClient(Integer.parseInt(ancPUI.getClientID()), ancPUI.getSurName(), ancPUI.getName(), ancPUI.getAge(), ancPUI.getSex(),
                    ancPUI.getEmail());
//            idbManager.addNewClient(Integer.parseInt(ancPUI.getClientID()), ancPUI.getSurName(), ancPUI.getName(), ancPUI.getAge(), ancPUI.getSex(),
//                    ancPUI.getEmail());
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
            gGUI.clientsTableShow();
        }else{
            System.out.println(this.toString() + " notified.");
        }
    }

    private Client setClient(){

        return new Client(Integer.parseInt(ancPUI.getClientID()), ancPUI.getSurName(), ancPUI.getName(),
                ancPUI.getAge(), ancPUI.getSex(), ancPUI.getEmail());

    }

    private boolean isPresent(){

        for(Client c : serv.getBad().getClts()){
            if(c.getId_client() == Integer.parseInt(ancPUI.getClientID())){
                return true;
            }
        }
        return false;
    }

    private boolean clientDataAreCorrect(){

        if(ancPUI.getSurName() != null && ! ancPUI.getSurName().equals("") &&
                ancPUI.getName() != null && ! ancPUI.getName().equals("") &&
                ancPUI.getAge() != null && ! ancPUI.getAge().equals("") &&
                ancPUI.getSex() != null && ! ancPUI.getSex().equals("") &&
                ancPUI.getEmail() != null && ! ancPUI.getEmail().equals("")){
            return true;
        }
        return false;
    }
}
