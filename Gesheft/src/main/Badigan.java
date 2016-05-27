package main;

import domain.Client;
import domain.Sale;
import domain.waters.Water;

import java.util.*;

/**
 * Created by prulov on 26.05.2016.
 */
public class Badigan extends Observable {

    private Stock stk;
    private List<Client> clts;
    private LinkedList<Sale> sales;
    private Vector<Sale> vectSales;

    public Badigan() {

        this.stk = new Stock();
        this.clts = new ArrayList<Client>();
        initClientsBase();
        this.sales = new LinkedList<Sale>();
        initSalesJournal();

        this.vectSales = new Vector<Sale>();
        initVectorSales();

    }

    public List<Client> getClts() {
        return new ArrayList<Client>(clts);
    }

    public List<Sale> getSales() {
        return new LinkedList<Sale>(sales);
    }

    public Stock getStk() {
        return stk;
    }

    public Vector<Sale> getVectSales() {
        return new Vector<Sale>(vectSales);
    }

    private void initClientsBase(){

        clts.add( new Client("Kennedy", "John", 46, "male", "president@usa.com"));
        clts.add( new Client("Rulov", "Petro", 38, "male", "prulov.pr@gmail.com"));
        clts.add( new Client("Borkeyev", "Sergiy", 39, "male", "s.borkeyev@sap.com"));
        clts.add( new Client("Rulova", "Mariia", 37, "female", "rulyova.ml@gmail.com"));
        clts.add( new Client("Borkeyeva", "Irina", 33, "female", "i.borkeyeva@gmail.com"));
        clts.add( new Client("Judd", "Ashley", 46, "female", "ajudd@yahoo.com"));
        clts.add( new Client("Law", "Jude", 42, "male", "jude.law@gb.com"));
        clts.add( new Client("Bardem", "Javier", 50, "male", "jb@fb.com.sp"));
        clts.add( new Client("Theron", "Charlize", 36, "female", "chther@yahoo.com"));
        clts.add( new Client("Theilor", "Elizabeth", 76, "female", "none"));
        clts.add( new Client("Schwarznegger", "Arnold", 65, "male", "mr.universe8times@yahoo.com"));
        clts.add( new Client("Zapoyniy", "Alkash", 52, "male", "bomzh@ulitsa.ua"));

    }

    private void initSalesJournal(){

        sales.add( new Sale(9032016, clts.get(0), stk.getWat()[5], 3));
        sales.add( new Sale(9032016, clts.get(7), stk.getWat()[4], 1));
        sales.add( new Sale(9032016, clts.get(3), stk.getWat()[1], 5));
        sales.add( new Sale(9032016, clts.get(9), stk.getWat()[0], 2));
        sales.add( new Sale(9032016, clts.get(4), stk.getWat()[2], 3));
        sales.add( new Sale(9032016, clts.get(0), stk.getWat()[3], 5));
        sales.add( new Sale(10032016, clts.get(1), stk.getWat()[9], 1));
        sales.add( new Sale(10032016, clts.get(11), stk.getWat()[17], 4));
        sales.add( new Sale(10032016, clts.get(2), stk.getWat()[34], 8));
        sales.add( new Sale(11032016, clts.get(10), stk.getWat()[45], 6));
        sales.add( new Sale(11032016, clts.get(3), stk.getWat()[61], 5));
        sales.add( new Sale(11032016, clts.get(9), stk.getWat()[66], 4));
        sales.add( new Sale(11032016, clts.get(4), stk.getWat()[62], 2));
        sales.add( new Sale(11032016, clts.get(8), stk.getWat()[59], 1));
        sales.add( new Sale(12032016, clts.get(5), stk.getWat()[9], 1));
        sales.add( new Sale(12032016, clts.get(7), stk.getWat()[44], 2));
        sales.add( new Sale(12032016, clts.get(7), stk.getWat()[36], 3));
        sales.add( new Sale(12032016, clts.get(6), stk.getWat()[30], 4));
        sales.add( new Sale(12032016, clts.get(11), stk.getWat()[38], 3));
        sales.add( new Sale(12032016, clts.get(0), stk.getWat()[27], 5));
        sales.add( new Sale(13032016, clts.get(1), stk.getWat()[41], 4));
        sales.add( new Sale(13032016, clts.get(10), stk.getWat()[23], 3));
        sales.add( new Sale(13032016, clts.get(2), stk.getWat()[45], 2));
        sales.add( new Sale(13032016, clts.get(9), stk.getWat()[19], 1));
        sales.add( new Sale(13032016, clts.get(3), stk.getWat()[48], 3));
        sales.add( new Sale(13032016, clts.get(8), stk.getWat()[17], 3));
        sales.add( new Sale(14032016, clts.get(4), stk.getWat()[50], 4));
        sales.add( new Sale(14032016, clts.get(7), stk.getWat()[9], 6));
        sales.add( new Sale(14032016, clts.get(5), stk.getWat()[14], 3));
        sales.add( new Sale(14032016, clts.get(6), stk.getWat()[52], 7));
        sales.add( new Sale(15032016, clts.get(1), stk.getWat()[12], 3));
        sales.add( new Sale(15032016, clts.get(11), stk.getWat()[55], 2));
        sales.add( new Sale(15032016, clts.get(0), stk.getWat()[9], 1));
        sales.add( new Sale(15032016, clts.get(10), stk.getWat()[58], 1));
        sales.add( new Sale(16032016, clts.get(2), stk.getWat()[7], 1));
        sales.add( new Sale(16032016, clts.get(9), stk.getWat()[60], 8));
        sales.add( new Sale(16032016, clts.get(3), stk.getWat()[5], 5));
        sales.add( new Sale(16032016, clts.get(8), stk.getWat()[62], 3));
        sales.add( new Sale(17032016, clts.get(4), stk.getWat()[3], 2));
        sales.add( new Sale(17032016, clts.get(7), stk.getWat()[0], 3));
        sales.add( new Sale(17032016, clts.get(5), stk.getWat()[65], 1));

    }

    public void sellTransaction(int date, Client guest, Water wat, int quant){

        if(date != 0 && guest != null && wat != null && quant != 0){
            Sale novus = new Sale(date, guest, wat, quant);
            sales.add(novus);
//            setChanged();
//            notifyObservers(novus);
        }else{
            System.err.println("This sale is not subject to handling!");
        }
    }

    public void addNewClient(String surName, String name, int age, String sex, String eMail){

        if(surName != null && name != null && age != 0 && sex != null && eMail != null){
            Client novus = new Client(surName, name, age, sex, eMail);
            clts.add(novus);
            // for ClientJTable
//            setChanged();
//            notifyObservers(novus);
        }else{
            System.err.println("New cannot be added because of invalid data");
        }
    }

    private void initVectorSales(){

        vectSales.add( new Sale(9032016, clts.get(0), stk.getWat()[5], 3));
        vectSales.add( new Sale(9032016, clts.get(7), stk.getWat()[4], 1));
        vectSales.add( new Sale(9032016, clts.get(3), stk.getWat()[1], 5));
        vectSales.add( new Sale(9032016, clts.get(9), stk.getWat()[0], 2));
        vectSales.add( new Sale(9032016, clts.get(4), stk.getWat()[2], 3));
        vectSales.add( new Sale(9032016, clts.get(0), stk.getWat()[3], 5));
        vectSales.add( new Sale(10032016, clts.get(1), stk.getWat()[9], 1));
        vectSales.add( new Sale(10032016, clts.get(11), stk.getWat()[17], 4));
        vectSales.add( new Sale(10032016, clts.get(2), stk.getWat()[34], 8));
        vectSales.add( new Sale(11032016, clts.get(10), stk.getWat()[45], 6));
        vectSales.add( new Sale(11032016, clts.get(3), stk.getWat()[61], 5));
        vectSales.add( new Sale(11032016, clts.get(9), stk.getWat()[66], 4));
        vectSales.add( new Sale(11032016, clts.get(4), stk.getWat()[62], 2));
        vectSales.add( new Sale(11032016, clts.get(8), stk.getWat()[59], 1));
        vectSales.add( new Sale(12032016, clts.get(5), stk.getWat()[9], 1));
        vectSales.add( new Sale(12032016, clts.get(7), stk.getWat()[44], 2));
        vectSales.add( new Sale(12032016, clts.get(7), stk.getWat()[36], 3));
        vectSales.add( new Sale(12032016, clts.get(6), stk.getWat()[30], 4));
        vectSales.add( new Sale(12032016, clts.get(11), stk.getWat()[38], 3));
        vectSales.add( new Sale(12032016, clts.get(0), stk.getWat()[27], 5));
        vectSales.add( new Sale(13032016, clts.get(1), stk.getWat()[41], 4));
        vectSales.add( new Sale(13032016, clts.get(10), stk.getWat()[23], 3));
        vectSales.add( new Sale(13032016, clts.get(2), stk.getWat()[45], 2));
        vectSales.add( new Sale(13032016, clts.get(9), stk.getWat()[19], 1));
        vectSales.add( new Sale(13032016, clts.get(3), stk.getWat()[48], 3));
        vectSales.add( new Sale(13032016, clts.get(8), stk.getWat()[17], 3));
        vectSales.add( new Sale(14032016, clts.get(4), stk.getWat()[50], 4));
        vectSales.add( new Sale(14032016, clts.get(7), stk.getWat()[9], 6));
        vectSales.add( new Sale(14032016, clts.get(5), stk.getWat()[14], 3));
        vectSales.add( new Sale(14032016, clts.get(6), stk.getWat()[52], 7));
        vectSales.add( new Sale(15032016, clts.get(1), stk.getWat()[12], 3));
        vectSales.add( new Sale(15032016, clts.get(11), stk.getWat()[55], 2));
        vectSales.add( new Sale(15032016, clts.get(0), stk.getWat()[9], 1));
        vectSales.add( new Sale(15032016, clts.get(10), stk.getWat()[58], 1));
        vectSales.add( new Sale(16032016, clts.get(2), stk.getWat()[7], 1));
        vectSales.add( new Sale(16032016, clts.get(9), stk.getWat()[60], 8));
        vectSales.add( new Sale(16032016, clts.get(3), stk.getWat()[5], 5));
        vectSales.add( new Sale(16032016, clts.get(8), stk.getWat()[62], 3));
        vectSales.add( new Sale(17032016, clts.get(4), stk.getWat()[3], 2));
        vectSales.add( new Sale(17032016, clts.get(7), stk.getWat()[0], 3));
        vectSales.add( new Sale(17032016, clts.get(5), stk.getWat()[65], 1));

    }

    public void saleVectorTransaction(int date, Client guest, Water wat, int quant){

        if(date != 0 && guest != null && wat != null && quant != 0){
            Sale novus = new Sale(date, guest, wat, quant);
            vectSales.add(novus);
            setChanged();
            notifyObservers(novus);
        }else{
            System.err.println("This sale is not subject to handling!");
        }
    }


}