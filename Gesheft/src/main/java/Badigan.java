package main.java;

import domain.Client;
import domain.Sale;
import domain.waters.*;
import enumerations.Drink;
import enumerations.Tare;
import interfaces.IDB_Manager;
import interfaces.IDataProvider;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

/**
 * Created by prulov on 26.05.2016.
 */
public class Badigan extends Observable implements IDataProvider, IDB_Manager {

    // shop
    private Stock stk;
    private List<Client> clts;
    private List<Sale> sales;

    //stock
    private Water[] wat;
    private List<Water> waters;

    private IDB_Manager iDBmanager;

    public Badigan(){

        this.stk = new Stock();
        this.clts = new ArrayList<>();
        initClientsBase();
        this.sales = new LinkedList<Sale>();
        initSalesJournal();
        this.wat = new Water[100];
        this.waters = new ArrayList<>();

        initStock(); // filling Array
        fillListStock(); // filling List

    }

    @Override
    public List<Client> getClts() {

        if(clts == null){
            initClientsBase();
        }
        return new ArrayList<Client>(clts);
    }

    public Water[] getWat() {
        return wat;
    }

    @Override
    public List<Water> getWaters(){
        return new ArrayList<>(waters);
    }

    @Override
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

    private void initStock() {

        //WATER
        wat[0] = new Water(1, Drink.WATER, "Petrova, soda", Tare.PAT, 2.0, 200, 12.4, 21.7);
        wat[1] = new Water(2, Drink.WATER, "Petrova, soda", Tare.PAT, 1.0, 200, 9.6, 16.5);
        wat[2] = new Water(3, Drink.WATER, "Petrova, soda", Tare.PAT, 0.5, 200, 4.8, 9.6);
        wat[3] = new Water(4, Drink.WATER, "Petrova, soda", Tare.GLASS, 0.5, 200, 6.5, 11.5);
        wat[4] = new Water(5, Drink.WATER, "Tselebnaya, mineral", Tare.PAT, 0.9, 150, 12.3, 24.6);
        wat[5] = new Water(6, Drink.WATER, "Tselebnaya, mineral", Tare.GLASS, 0.45, 150, 6.7, 13.4);

        //JUICE
        wat[6] = new Juice(7, Drink.JUICE, "MAPE, Cherry", Tare.TETRAPAC, 1.0, 200, 12.4, 21.8);
        wat[7] = new Juice(8, Drink.JUICE, "MAPE, Peach", Tare.TETRAPAC, 1.0, 200, 12.4, 22.0);
        wat[8] = new Juice(9, Drink.JUICE, "MAPE, Pear", Tare.TETRAPAC, 1.0, 200, 12.4, 21.5);
        wat[9] = new Juice(10, Drink.JUICE, "MAPE, Grape", Tare.TETRAPAC, 1.0, 200, 11.2, 20.5);
        wat[10] = new Juice(11, Drink.JUICE, "MAPE, Pamela", Tare.TETRAPAC, 1.0, 200, 12.4, 21.8);
        wat[11] = new Juice(12, Drink.JUICE, "MAPE, Garnet", Tare.TETRAPAC, 1.0, 200, 13.6, 24.0);
        wat[12] = new Juice(13, Drink.JUICE, "MAPE, Orange", Tare.TETRAPAC, 1.0, 200, 11.5, 21.0);
        wat[13] = new Juice(14, Drink.JUICE, "MAPE, Tomato", Tare.TETRAPAC, 1.0, 200, 10.5, 20.4);

        //VINES
        wat[14] = new Vine(15, Drink.VINE, "Aligote", "white", "dry", Tare.GLASS, 0.7, 30, 28.7, 56.8);
        wat[15] = new Vine(16, Drink.VINE, "Risling", "white", "dry", Tare.GLASS, 0.7, 30, 29.3, 58.6);
        wat[16] = new Vine(17, Drink.VINE, "Sauvignon Blanc", "white", "dry", Tare.GLASS, 0.7, 30, 32.0, 64.6);
        wat[17] = new Vine(18, Drink.VINE, "Shardonney", "white", "dry", Tare.GLASS, 0.7, 30, 28.0, 54.2);
        wat[18] = new Vine(19, Drink.VINE, "Shennon Blanc", "white", "semidry", Tare.GLASS, 0.7, 30, 38.2, 76.0);
        wat[19] = new Vine(20, Drink.VINE, "Gewuztraminer", "white", "semidry", Tare.GLASS, 0.7, 30, 40.8, 87.5);
        wat[20] = new Vine(21, Drink.VINE, "Riunite Moscato", "white", "semidry", Tare.GLASS, 0.7, 30, 44.8, 94.6);
        wat[21] = new Vine(22, Drink.VINE, "Southern", "white", "semisweet", Tare.GLASS, 0.7, 30, 50.8, 106.4);
        wat[22] = new Vine(23, Drink.VINE, "Bordeux", "red", "dry", Tare.GLASS, 0.7, 30, 38.0, 76.4);
        wat[23] = new Vine(24, Drink.VINE, "Merlot", "red", "dry", Tare.GLASS, 0.7, 30, 39.4, 79.6);
        wat[24] = new Vine(25, Drink.VINE, "Cabernet Sauvignon", "red", "dry", Tare.GLASS, 0.7, 30, 32.0, 68.0);
        wat[25] = new Vine(26, Drink.VINE, "Riunite Rose", "rose", "dry", Tare.GLASS, 0.7, 30, 48.0, 116.0);
        wat[26] = new Vine(27, Drink.VINE, "SHABO Classic", "white", "semidry", Tare.GLASS, 0.7, 30, 38.2, 76.0);
        wat[27] = new Vine(28, Drink.VINE, "Pinot Noir", "rubin", "semidry", Tare.GLASS, 0.7, 30, 41.8, 88.2);
        wat[28] = new Vine(29, Drink.VINE, "Boussole", "red", "semidry", Tare.GLASS, 0.7, 30, 44.8, 94.6);
        wat[29] = new Vine(30, Drink.VINE, "Portwein Bastardo", "red", "semisweet", Tare.GLASS, 0.7, 30, 60.0, 120.0);
        wat[30] = new Vine(31, Drink.VINE, "INKERMAN", "red", "semidry", Tare.TETRAPAC, 0.7, 30, 74.5, 164.8);
        wat[31] = new Vine(32, Drink.VINE, "INKERMAN", "white", "semisweet", Tare.TETRAPAC, 0.7, 30, 70.0, 162.5);

        //BURBON
        wat[32] = new Burbon(33, Drink.BURBON, "JIM BEAM", Tare.GLASS, 0.7, 40, 298.0, 556.0);
        wat[33] = new Burbon(34, Drink.BURBON, "JIM BEAM", Tare.PAT, 0.2, 40, 98.0, 204.0);
        wat[34] = new Burbon(35, Drink.BURBON, "Maker's MARK", Tare.GLASS, 0.7, 40, 338.0, 604.0);
        wat[35] = new Burbon(36, Drink.BURBON, "Maker's MARK", Tare.PAT, 0.2, 37, 95.0, 199.0);
        wat[36] = new Burbon(37, Drink.BURBON, "JACK Daniel's", Tare.GLASS, 0.7, 40, 368.08, 724.0);
        wat[37] = new Burbon(38, Drink.BURBON, "JACK Daniel's", Tare.PAT, 0.2, 37, 95.0, 201.0);
        wat[38] = new Burbon(39, Drink.BURBON, "WILD Turkey", Tare.GLASS, 0.7, 40, 325.0, 660.0);
        wat[39] = new Burbon(40, Drink.BURBON, "WILD Turkey", Tare.PAT, 0.2, 38, 92.0, 180.0);
        wat[40] = new Burbon(41, Drink.BURBON, "Brown FORMAN", Tare.GLASS, 0.7, 39, 348.0, 712.0);
        wat[41] = new Burbon(42, Drink.BURBON, "Brown FORMAN", Tare.GLASS, 0.33, 35, 117.0, 264.0);

        //VODKA
        wat[42] = new Vodka(43, Drink.VODKA, "Stolichnaya", Tare.GLASS, 0.7, 40, 77.0, 164.0);
        wat[43] = new Vodka(44, Drink.VODKA, "Stolichnaya", Tare.PAT, 0.25, 39, 37.0, 70.0);
        wat[44] = new Vodka(45, Drink.VODKA, "Cremlin", Tare.CLAY, 1.25, 30, 167.5, 320.0);
        wat[45] = new Vodka(46, Drink.VODKA, "Posolskaya", Tare.GLASS, 0.7, 80, 47.5, 95.0);
        wat[46] = new Vodka(47, Drink.VODKA, "Posolskaya", Tare.GLASS, 0.5, 80, 37.5, 75.0);
        wat[47] = new Vodka(48, Drink.VODKA, "Posolskaya", Tare.GLASS, 0.375, 65, 21.3, 47.5);
        wat[48] = new Vodka(49, Drink.VODKA, "Fruktovitsa Grape", Tare.GLASS, 0.5, 40, 27.8, 65.0);
        wat[49] = new Vodka(50, Drink.VODKA, "Fruktovitsa Pear", Tare.GLASS, 0.5, 38, 25.4, 56.0);
        wat[50] = new Vodka(51, Drink.VODKA, "Kalashnikov", Tare.TOY, 0.8, 20, 89.4, 184.0);
        wat[51] = new Vodka(52, Drink.VODKA, "PM", Tare.TOY, 0.4, 20, 47.6, 98.4);

        //BRENDY
        wat[52] = new Brendy(53, Drink.BRENDY, "METAXA *****", Tare.GLASS, 0.7, 180, 284.5, 516.0);
        wat[53] = new Brendy(54, Drink.BRENDY, "TORRES *****", Tare.GLASS, 0.5, 80, 224.5, 425.0);
        wat[54] = new Brendy(55, Drink.BRENDY, "TORRES ****", Tare.GLASS, 0.5, 70, 194.5, 405.0);
        wat[55] = new Brendy(56, Drink.BRENDY, "Seint Remi XO", Tare.GLASS, 0.5, 30, 3384.5, 705.0);
        wat[56] = new Brendy(57, Drink.BRENDY, "ARARAT *****", Tare.GLASS, 0.5, 30, 284.5, 506.0);
        wat[57] = new Brendy(58, Drink.BRENDY, "ARARAT ****", Tare.GLASS, 0.375, 45, 201.5, 436.0);
        wat[58] = new Brendy(59, Drink.BRENDY, "ARARAT ***", Tare.GLASS, 0.5, 60, 124.5, 240.0);
        wat[59] = new Brendy(60, Drink.BRENDY, "ZAKARPATSKY *****", Tare.GLASS, 0.5, 93, 74.5, 156.0);
        wat[60] = new Brendy(61, Drink.BRENDY, "UZHGOROD *****", Tare.GLASS, 0.5, 46, 124.5, 296.0);

        //TEQUILA
        wat[61] = new Tequila(62, Drink.TEQUILA, "Jose Cuervo Especial", Tare.GLASS, 0.8, 20, 584.5, 1212.0);
        wat[62] = new Tequila(63, Drink.TEQUILA, "SAUZA PLATINUM", Tare.GLASS, 0.7, 20, 564.0, 1175.0);
        wat[63] = new Tequila(64, Drink.TEQUILA, "DON JULIO", Tare.GLASS, 0.7, 20, 494.5, 1080.0);
        wat[64] = new Tequila(65, Drink.TEQUILA, "CASAD'ORES", Tare.GLASS, 0.7, 20, 414.5, 980.0);
        wat[65] = new Tequila(66, Drink.TEQUILA, "HERRADURA", Tare.GLASS, 0.7, 20, 384.5, 775.0);
        wat[66] = new Tequila(67, Drink.TEQUILA, "1800", Tare.GLASS, 1.0, 25, 561.5, 1184.0);

        //BEER
        wat[67] = new Beer(68, Drink.BEER, "WARSTEINER, Lager", Tare.GLASS, 0.5, 100, 24.5, 48.0);
        wat[68] = new Beer(69, Drink.BEER, "HOEGAARDEN", Tare.GLASS, 0.66, 150, 19.8, 44.0);
        wat[69] = new Beer(70, Drink.BEER, "BRIDGEPORT, ALE", Tare.GLASS, 0.5, 100, 18.5, 36.0);
        wat[70] = new Beer(71, Drink.BEER, "PAULANER, München", Tare.GLASS, 0.64, 100, 24.5, 49.0);
        wat[71] = new Beer(72, Drink.BEER, "ERDINGER Festweiße", Tare.GLASS, 0.7, 100, 24.5, 50.0);
        wat[72] = new Beer(73, Drink.BEER, "BUDWEISER Budvar", Tare.GLASS, 0.5, 150, 21.5, 44.0);
        wat[73] = new Beer(74, Drink.BEER, "GAMBRINUS Bílé", Tare.GLASS, 0.7, 125, 21.5, 44.0);
        wat[74] = new Beer(75, Drink.BEER, "GUINNES", Tare.GLASS, 0.74, 50, 21.6, 52.4);

    }

    private void fillListStock() {

        for(Water w : wat){
            if(w != null){
                waters.add(w);
            }
        }
    }

    @Override
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

    @Override
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

    @Override
    public void soldWaterMinus(Water wat, int quant) {

        Water sold = null;
        for(Water i : getWaters()){
            if(i.equals(wat)){
                sold = i;
                break;
            }
        }
        sold.setQuant(sold.getQuant() - quant);
    }

    public void setiDBmanager(IDB_Manager iDBmanager) {
        this.iDBmanager = iDBmanager;
    }
}