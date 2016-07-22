package control;

import bl.Shop;
import domain.Client;
import util.Service;
import view.ShopUI;
import view.panels.AddNewClientPanelUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by prulov on 09.07.2016.
 */
public class AddClientControl implements ActionListener, Observer {

    private Shop shop;
    private Service serv;
    private AddNewClientPanelUI ancPUI;
    private ShopUI shGUI;


    public AddClientControl(Shop shop, AddNewClientPanelUI ancPUI, ShopUI shGUI, Service serv){

        this.shop = shop;
        this.serv = serv;
        this.ancPUI = ancPUI;
        this.shGUI = shGUI;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Client guest = null;
        if(clientDataAreCorrect() && isPresent()){
            JOptionPane.showConfirmDialog(null, "This Client is already present in the database \n Try again, please.", "Clients Database", JOptionPane.PLAIN_MESSAGE);
        }else if(clientDataAreCorrect() && !isPresent()){
            guest = setClient();
            shop.addNewClient(guest);

            JOptionPane.showConfirmDialog(null, "New Client was successfully added in the database!", "Clients Database", JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showConfirmDialog(null, "ERROR: Please, input correct Client's data and try again!",
                    "Clients Database", JOptionPane.PLAIN_MESSAGE);
            return;
        }
    }

    @Override
    public void update(Observable o, Object arg) {

        if (arg instanceof Client) {
            shGUI.clientsTableShow();
        }else{
            System.out.println(this.toString() + " notified.");
        }
    }

    private Client setClient(){

        return new Client(Integer.parseInt(ancPUI.getClientID()), ancPUI.getSurName(), ancPUI.getName(),
                ancPUI.getAge(), ancPUI.getSex(), ancPUI.getEmail());

    }

    private boolean isPresent(){

        for(Client c : shop.getIdbI().getClts()){
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
