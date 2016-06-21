package main;

import domain.Client;
import domain.Sale;
import domain.waters.Water;
import interfaces.IDataProvider;

import java.util.*;

/**
 * Created by prulov on 26.05.2016.
 */
public class Badigan extends Observable implements IDataProvider {

    private Stock stk;
    private List<Client> clts;
    private List<Sale> sales;

    public Badigan(){

        this.stk = new Stock();
        this.clts = new ArrayList<>();
        initClientsBase();
        this.sales = new LinkedList<Sale>();
        initSalesJournal();

    }

    public List<Client> getClts() {

        if(clts == null){
            initClientsBase();
        }
        return new ArrayList<Client>(clts);
    }

    public List<Sale> getSales() {

        if(sales == null){
            initSalesJournal();
        }
        return new LinkedList<Sale>(sales);
    }

    public Stock getStk() {
        return stk;
    }

    private void initClientsBase(){

        clts.add( new Client(1, "Kennedy", "John", "07/07/1927", "male", "president@usa.com"));
        clts.add( new Client(2, "Rulov", "Petro", "10/07/1977", "male", "prulov.pr@gmail.com"));
        clts.add( new Client(3, "Borkeyev", "Sergiy", "12/01/1977", "male", "s.borkeyev@sap.com"));
        clts.add( new Client(4, "Rulova", "Mariia", "08/11/1978", "female", "rulyova.ml@gmail.com"));
        clts.add( new Client(5, "Borkeyeva", "Irina", "11/07/1981", "female", "i.borkeyeva@gmail.com"));
        clts.add( new Client(6, "Judd", "Ashley", "17/07/1967", "female", "ajudd@yahoo.com"));
        clts.add( new Client(7, "Law", "Jude", "06/07/1977", "male", "jude.law@gb.com"));
        clts.add( new Client(8, "Bardem", "Javier", "12/11/1966", "male", "jb@fb.com.sp"));
        clts.add( new Client(9, "Theron", "Charlize", "11/07/1980", "female", "chther@yahoo.com"));
        clts.add( new Client(10, "Theilor", "Elizabeth", "12/12/1922", "female", "none"));
        clts.add( new Client(11, "Schwarznegger", "Arnold", "05/01/1951", "male", "mr.universe8times@yahoo.com"));
        clts.add( new Client(12, "Zapoyniy", "Alkash", "none", "male", "bomzh@ulitsa.ua"));

    }

    private void initSalesJournal(){

        sales.add( new Sale(1, "01.06.2016", clts.get(0), stk.getWat()[5], 3));
        sales.add( new Sale(2, "01.06.2016", clts.get(7), stk.getWat()[4], 1));
        sales.add( new Sale(3, "01.06.2016", clts.get(3), stk.getWat()[1], 5));
        sales.add( new Sale(4, "01.06.2016", clts.get(9), stk.getWat()[0], 2));
        sales.add( new Sale(5, "01.06.2016", clts.get(4), stk.getWat()[2], 3));
        sales.add( new Sale(6, "01.06.2016", clts.get(0), stk.getWat()[3], 5));
        sales.add( new Sale(7, "02.06.2016", clts.get(1), stk.getWat()[9], 1));
        sales.add( new Sale(8, "02.06.2016", clts.get(11), stk.getWat()[17], 4));
        sales.add( new Sale(9, "02.06.2016", clts.get(2), stk.getWat()[34], 8));
        sales.add( new Sale(10, "02.06.2016", clts.get(10), stk.getWat()[45], 6));
        sales.add( new Sale(11, "03.06.2016", clts.get(3), stk.getWat()[61], 5));
        sales.add( new Sale(12, "03.06.2016", clts.get(9), stk.getWat()[66], 4));
        sales.add( new Sale(13, "03.06.2016", clts.get(4), stk.getWat()[62], 2));
        sales.add( new Sale(14, "03.06.2016", clts.get(8), stk.getWat()[59], 1));
        sales.add( new Sale(15, "04.06.2016", clts.get(5), stk.getWat()[9], 1));
        sales.add( new Sale(16, "04.06.2016", clts.get(7), stk.getWat()[44], 2));
        sales.add( new Sale(17, "04.06.2016", clts.get(7), stk.getWat()[36], 3));
        sales.add( new Sale(18, "04.06.2016", clts.get(6), stk.getWat()[30], 4));
        sales.add( new Sale(19, "04.06.2016", clts.get(11), stk.getWat()[38], 3));
        sales.add( new Sale(20, "04.06.2016", clts.get(0), stk.getWat()[27], 5));
        sales.add( new Sale(21, "05.06.2016", clts.get(1), stk.getWat()[41], 4));
        sales.add( new Sale(22, "05.06.2016", clts.get(10), stk.getWat()[23], 3));
        sales.add( new Sale(23, "05.06.2016", clts.get(2), stk.getWat()[45], 2));
        sales.add( new Sale(24, "05.06.2016", clts.get(9), stk.getWat()[19], 1));
        sales.add( new Sale(25, "05.06.2016", clts.get(3), stk.getWat()[48], 3));
        sales.add( new Sale(26, "05.06.2016", clts.get(8), stk.getWat()[17], 3));
        sales.add( new Sale(27, "06.06.2016", clts.get(4), stk.getWat()[50], 4));
        sales.add( new Sale(28, "06.06.2016", clts.get(7), stk.getWat()[9], 6));
        sales.add( new Sale(29, "06.06.2016", clts.get(5), stk.getWat()[14], 3));
        sales.add( new Sale(30, "06.06.2016", clts.get(6), stk.getWat()[52], 7));
        sales.add( new Sale(31, "07.06.2016", clts.get(1), stk.getWat()[12], 3));
        sales.add( new Sale(32, "07.06.2016", clts.get(11), stk.getWat()[55], 2));
        sales.add( new Sale(33, "07.06.2016", clts.get(0), stk.getWat()[9], 1));
        sales.add( new Sale(34, "07.06.2016", clts.get(10), stk.getWat()[58], 1));
        sales.add( new Sale(35, "08.06.2016", clts.get(2), stk.getWat()[7], 1));
        sales.add( new Sale(36, "08.06.2016", clts.get(9), stk.getWat()[60], 8));
        sales.add( new Sale(37, "08.06.2016", clts.get(3), stk.getWat()[5], 5));
        sales.add( new Sale(38, "08.06.2016", clts.get(8), stk.getWat()[62], 3));
        sales.add( new Sale(39, "09.06.2016", clts.get(4), stk.getWat()[3], 2));
        sales.add( new Sale(40, "09.06.2016", clts.get(7), stk.getWat()[0], 3));
        sales.add( new Sale(41, "09.06.2016", clts.get(5), stk.getWat()[65], 1));

    }

    public void sellTransaction(int id, String date, Client guest, Water wat, int quant){

        if(date != null && guest != null && wat != null && quant != 0){
            Sale novus = new Sale(id, date, guest, wat, quant);
            sales.add(novus);
            setChanged();
            notifyObservers(novus);
        }else{
            System.err.println("This sale is not subject to handling!");
        }
    }

    public void addNewClient(int id, String surName, String name, String age, String sex, String eMail){

        if(surName != null && name != null && age != null && sex != null && eMail != null){
            Client novus = new Client(id, surName, name, age, sex, eMail);
            clts.add(novus);
            setChanged();
            notifyObservers(novus);
        }else{
            System.err.println("New Client cannot be added because of invalid data");
        }
    }
}