package datamanagers;

import domain.Client;
import domain.Sale;
import domain.waters.Tare;
import domain.waters.Water;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by prulov on 08.07.2016.
 */
public class DB_Manager implements IDBInterface {

    //shop
    private List<Client> clts;
    private List<Sale> sales;
    //stock
    private List<Water> waters;


    public DB_Manager(){

        this.waters = new ArrayList<Water>();
        waters = initStock();
        this.clts = new ArrayList<Client>();
        clts = initClientsBase();
        this.sales = new LinkedList<Sale>();
        sales = initSalesJournal();
    }

    @Override
    public List<Client> getClts() {
        return new ArrayList<Client>(clts);
    }

    @Override
    public List<Sale> getSales() {
        return new LinkedList<Sale>(sales);
    }

    @Override
    public List<Water> getWaters() {
        return new ArrayList<Water>(waters);
    }

    public List<Water> initStock() {

        // WATER
        waters.add(new Water(1, "Soda water", "Petrova", Tare.PAT, 2.0, 200, new BigDecimal(12.4), new BigDecimal(21.7)));
        waters.add(new Water(2, "Soda water", "Petrova", Tare.PAT, 1.0, 200, new BigDecimal(9.6), new BigDecimal(16.5)));
        waters.add(new Water(3, "Soda water", "Petrova", Tare.PAT, 0.5, 200, new BigDecimal(4.8), new BigDecimal(9.6)));
        waters.add(new Water(4, "Soda water", "Petrova", Tare.GLASS, 0.5, 200, new BigDecimal(6.5), new BigDecimal(11.5)));
        waters.add(new Water(5, "Mineral water", "Tselebnaya", Tare.PAT, 0.9, 150, new BigDecimal(12.3), new BigDecimal(24.6)));
        waters.add(new Water(6, "Mineral water",  "Tselebnaya", Tare.GLASS, 0.45, 150, new BigDecimal(6.7), new BigDecimal(13.4)));

        // JUICE
        waters.add(new Water(7, "Juice", "MAPE, Cherry", Tare.TETRAPAC, 1.0, 200, new BigDecimal(12.4), new BigDecimal(21.8)));
        waters.add(new Water(8, "Juice", "MAPE, Peach", Tare.TETRAPAC, 1.0, 200, new BigDecimal(12.4), new BigDecimal(22.0)));
        waters.add(new Water(9, "Juice", "MAPE, Pear", Tare.TETRAPAC, 1.0, 200, new BigDecimal(12.4), new BigDecimal(21.5)));
        waters.add(new Water(10, "Juice", "MAPE, Grape", Tare.TETRAPAC, 1.0, 200, new BigDecimal(11.2), new BigDecimal(20.5)));
        waters.add(new Water(11, "Juice", "MAPE, Pamela", Tare.TETRAPAC, 1.0, 200, new BigDecimal(12.4), new BigDecimal(21.8)));
        waters.add(new Water(12, "Juice", "MAPE, Garnet", Tare.TETRAPAC, 1.0, 200, new BigDecimal(13.6), new BigDecimal(24.0)));
        waters.add(new Water(13, "Juice", "MAPE, Orange", Tare.TETRAPAC, 1.0, 200, new BigDecimal(11.5), new BigDecimal(21.0)));
        waters.add(new Water(14, "Juice", "MAPE, Tomato", Tare.TETRAPAC, 1.0, 200, new BigDecimal(10.5), new BigDecimal(20.4)));

        // VINES
        waters.add(new Water(15, "Vine", "\"Aligote\", white, dry", Tare.GLASS, 0.7, 30, new BigDecimal(28.7), new BigDecimal(56.8)));
        waters.add(new Water(16, "Vine", "\"Risling\", white, dry", Tare.GLASS, 0.7, 30, new BigDecimal(29.3), new BigDecimal(58.6)));
        waters.add(new Water(17, "Vine", "\"Sauvignon Blanc\", white, dry", Tare.GLASS, 0.7, 30, new BigDecimal(32.0), new BigDecimal(64.6)));
        waters.add(new Water(18, "Vine", "\"Shardonney\", white, dry", Tare.GLASS, 0.7, 30, new BigDecimal(28.0), new BigDecimal(54.2)));
        waters.add(new Water(19, "Vine", "\"Shennon Blanc\", white, semidry", Tare.GLASS, 0.7, 30, new BigDecimal(38.2), new BigDecimal(76.0)));
        waters.add(new Water(20, "Vine", "\"Gewuztraminer\", white, semidry", Tare.GLASS, 0.7, 30, new BigDecimal(40.8), new BigDecimal(87.5)));
        waters.add(new Water(21, "Vine", "\"Riunite Moscato\", white, semidry", Tare.GLASS, 0.7, 30, new BigDecimal(44.8), new BigDecimal(94.6)));
        waters.add(new Water(22, "Vine", "\"Southern\", white, semisweet", Tare.GLASS, 0.7, 30, new BigDecimal(50.8), new BigDecimal(106.4)));
        waters.add(new Water(23, "Vine", "\"Bordeux\", red, dry", Tare.GLASS, 0.7, 30, new BigDecimal(38.0), new BigDecimal(76.4)));
        waters.add(new Water(24, "Vine", "\"Merlot\", red, dry", Tare.GLASS, 0.7, 30, new BigDecimal(39.4), new BigDecimal(79.6)));
        waters.add(new Water(25, "Vine", "\"Cabernet Sauvignon\", red, dry", Tare.GLASS, 0.7, 30, new BigDecimal(32.0), new BigDecimal(68.0)));
        waters.add(new Water(26, "Vine", "\"Riunite Rose\", rose, dry", Tare.GLASS, 0.7, 30, new BigDecimal(48.0), new BigDecimal(116.0)));
        waters.add(new Water(27, "Vine", "\"SHABO Classic\", white, semidry", Tare.GLASS, 0.7, 30, new BigDecimal(38.2), new BigDecimal(76.0)));
        waters.add(new Water(28, "Vine", "\"Pinot Noir\", rubin, semidry", Tare.GLASS, 0.7, 30, new BigDecimal(41.8), new BigDecimal(88.2)));
        waters.add(new Water(29, "Vine", "\"Boussole\", red, semidry", Tare.GLASS, 0.7, 30, new BigDecimal(44.8), new BigDecimal(94.6)));
        waters.add(new Water(30, "Vine", "\"Portwein Bastardo\", red, semisweet", Tare.GLASS, 0.7, 30, new BigDecimal(60.0), new BigDecimal(120.0)));
        waters.add(new Water(31, "Vine", "\"INKERMAN\", red, semidry", Tare.TETRAPAC, 0.7, 30, new BigDecimal(74.5), new BigDecimal(164.8)));
        waters.add(new Water(32, "Vine", "\"INKERMAN\", white, semisweet", Tare.TETRAPAC, 0.7, 30, new BigDecimal(70.0), new BigDecimal(162.5)));

        // BURBON
        waters.add(new Water(33, "Burbon", "JIM BEAM", Tare.GLASS, 0.7, 40, new BigDecimal(298.0), new BigDecimal(556.0)));
        waters.add(new Water(34, "Burbon", "JIM BEAM", Tare.PAT, 0.2, 40, new BigDecimal(98.0), new BigDecimal(204.0)));
        waters.add(new Water(35, "Burbon", "Maker's MARK", Tare.GLASS, 0.7, 40, new BigDecimal(338.0), new BigDecimal(604.0)));
        waters.add(new Water(36, "Burbon", "Maker's MARK", Tare.PAT, 0.2, 37, new BigDecimal(95.0), new BigDecimal(199.0)));
        waters.add(new Water(37, "Burbon", "JACK Daniel's", Tare.GLASS, 0.7, 40, new BigDecimal(368.08), new BigDecimal(724.0)));
        waters.add(new Water(38, "Burbon", "JACK Daniel's", Tare.PAT, 0.2, 37, new BigDecimal(95.0), new BigDecimal(201.0)));
        waters.add(new Water(39, "Burbon", "WILD Turkey", Tare.GLASS, 0.7, 40, new BigDecimal(325.0), new BigDecimal(660.0)));
        waters.add(new Water(40, "Burbon", "WILD Turkey", Tare.PAT, 0.2, 38, new BigDecimal(92.0), new BigDecimal(180.0)));
        waters.add(new Water(41, "Burbon", "Brown FORMAN", Tare.GLASS, 0.7, 39, new BigDecimal(348.0), new BigDecimal(712.0)));
        waters.add(new Water(42, "Burbon", "Brown FORMAN", Tare.GLASS, 0.33, 35, new BigDecimal(117.0), new BigDecimal(264.0)));

        // VODKA
        waters.add(new Water(43, "Vodka", "Stolichnaya", Tare.GLASS, 0.7, 40, new BigDecimal(77.0), new BigDecimal(164.0)));
        waters.add(new Water(44, "Vodka", "Stolichnaya", Tare.PAT, 0.25, 39, new BigDecimal(37.0), new BigDecimal(70.0)));
        waters.add(new Water(45, "Vodka", "Cremlin", Tare.CLAY, 1.25, 30, new BigDecimal(167.5), new BigDecimal(320.0)));
        waters.add(new Water(46, "Vodka", "Posolskaya", Tare.GLASS, 0.7, 80, new BigDecimal(47.5), new BigDecimal(95.0)));
        waters.add(new Water(47, "Vodka", "Posolskaya", Tare.GLASS, 0.5, 80, new BigDecimal(37.5), new BigDecimal(75.0)));
        waters.add(new Water(48, "Vodka", "Posolskaya", Tare.GLASS, 0.375, 65,new BigDecimal( 21.3), new BigDecimal(47.5)));
        waters.add(new Water(49, "Vodka", "Fruktovitsa Grape", Tare.GLASS, 0.5, 40, new BigDecimal(27.8), new BigDecimal(65.0)));
        waters.add(new Water(50, "Vodka", "Fruktovitsa Pear", Tare.GLASS, 0.5, 38, new BigDecimal(25.4), new BigDecimal(56.0)));
        waters.add(new Water(51, "Vodka", "Kalashnikov", Tare.TOY, 0.8, 20, new BigDecimal(89.4), new BigDecimal(184.0)));
        waters.add(new Water(52, "Vodka", "PM", Tare.TOY, 0.4, 20, new BigDecimal(47.6), new BigDecimal(98.4)));

        // BRENDY
        waters.add(new Water(53, "Brendy", "METAXA *****", Tare.GLASS, 0.7, 180, new BigDecimal(284.5), new BigDecimal(516.0)));
        waters.add(new Water(54, "Brendy", "TORRES *****", Tare.GLASS, 0.5, 80, new BigDecimal(224.5), new BigDecimal(425.0)));
        waters.add(new Water(55, "Brendy", "TORRES ****", Tare.GLASS, 0.5, 70, new BigDecimal(194.5), new BigDecimal(405.0)));
        waters.add(new Water(56, "Brendy", "Seint Remi XO", Tare.GLASS, 0.5, 30, new BigDecimal(384.5), new BigDecimal(705.0)));
        waters.add(new Water(57, "Brendy", "ARARAT *****", Tare.GLASS, 0.5, 30, new BigDecimal(284.5), new BigDecimal(506.0)));
        waters.add(new Water(58, "Brendy", "ARARAT ****", Tare.GLASS, 0.375, 45, new BigDecimal(201.5), new BigDecimal(436.0)));
        waters.add(new Water(59, "Brendy", "ARARAT ***", Tare.GLASS, 0.5, 60, new BigDecimal(124.5), new BigDecimal(240.0)));
        waters.add(new Water(60, "Brendy", "ZAKARPATSKY *****", Tare.GLASS, 0.5, 93, new BigDecimal(74.5), new BigDecimal(156.0)));
        waters.add(new Water(61, "Brendy", "UZHGOROD *****", Tare.GLASS, 0.5, 46, new BigDecimal(124.5), new BigDecimal(296.0)));

        // TEQUILA
        waters.add(new Water(62, "Tequila", "Jose Cuervo Especial", Tare.GLASS, 0.8, 20, new BigDecimal(584.5), new BigDecimal(1212.0)));
        waters.add(new Water(63, "Tequila", "SAUZA PLATINUM", Tare.GLASS, 0.7, 20, new BigDecimal(564.0), new BigDecimal(1175.0)));
        waters.add(new Water(64, "Tequila", "DON JULIO", Tare.GLASS, 0.7, 20, new BigDecimal(494.5), new BigDecimal(1080.0)));
        waters.add(new Water(65, "Tequila", "CASAD'ORES", Tare.GLASS, 0.7, 20, new BigDecimal(414.5), new BigDecimal(980.0)));
        waters.add(new Water(66, "Tequila", "HERRADURA", Tare.GLASS, 0.7, 20, new BigDecimal(384.5), new BigDecimal(775.0)));
        waters.add(new Water(67, "Tequila", "1800", Tare.GLASS, 1.0, 25, new BigDecimal(561.5), new BigDecimal(1184.0)));

        // BEER
        waters.add(new Water(68, "Beer", "WARSTEINER, Lager", Tare.GLASS, 0.5, 100, new BigDecimal(24.5), new BigDecimal(48.0)));
        waters.add(new Water(69, "Beer", "HOEGAARDEN", Tare.GLASS, 0.66, 150, new BigDecimal(19.8), new BigDecimal(44.0)));
        waters.add(new Water(70, "Beer", "BRIDGEPORT, ALE", Tare.GLASS, 0.5, 100, new BigDecimal(18.5), new BigDecimal(36.0)));
        waters.add(new Water(71, "Beer", "PAULANER, München", Tare.GLASS, 0.64, 100, new BigDecimal(24.5), new BigDecimal(49.0)));
        waters.add(new Water(72, "Beer", "ERDINGER Festweiße", Tare.GLASS, 0.7, 100, new BigDecimal(24.5), new BigDecimal(50.0)));
        waters.add(new Water(73, "Beer", "BUDWEISER Budvar", Tare.GLASS, 0.5, 150, new BigDecimal(21.5), new BigDecimal(44.0)));
        waters.add(new Water(74, "Beer", "GAMBRINUS Bílé", Tare.GLASS, 0.7, 125, new BigDecimal(21.5), new BigDecimal(44.0)));
        waters.add(new Water(75, "Beer", "GUINNES", Tare.GLASS, 0.74, 50, new BigDecimal(21.6), new BigDecimal(52.4)));
        return waters;
    }

    @Override
    public List<Client> initClientsBase(){


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
        return clts;
    }

    @Override
    public List<Sale> initSalesJournal(){

        sales.add( new Sale(1, "01.06.2016", clts.get(0), waters.get(5), 3));
        sales.add( new Sale(2, "01.06.2016", clts.get(7), waters.get(4), 1));
        sales.add( new Sale(3, "01.06.2016", clts.get(3), waters.get(1), 5));
        sales.add( new Sale(4, "01.06.2016", clts.get(9), waters.get(0), 2));
        sales.add( new Sale(5, "01.06.2016", clts.get(4), waters.get(2), 3));
        sales.add( new Sale(6, "01.06.2016", clts.get(0), waters.get(3), 5));
        sales.add( new Sale(7, "02.06.2016", clts.get(1), waters.get(9), 1));
        sales.add( new Sale(8, "02.06.2016", clts.get(11), waters.get(17), 4));
        sales.add( new Sale(9, "02.06.2016", clts.get(2), waters.get(34), 8));
        sales.add( new Sale(10, "02.06.2016", clts.get(10), waters.get(45), 6));
        sales.add( new Sale(11, "03.06.2016", clts.get(3), waters.get(61), 5));
        sales.add( new Sale(12, "03.06.2016", clts.get(9), waters.get(66), 4));
        sales.add( new Sale(13, "03.06.2016", clts.get(4), waters.get(62), 2));
        sales.add( new Sale(14, "03.06.2016", clts.get(8), waters.get(59), 1));
        sales.add( new Sale(15, "04.06.2016", clts.get(5), waters.get(9), 1));
        sales.add( new Sale(16, "04.06.2016", clts.get(7), waters.get(44), 2));
        sales.add( new Sale(17, "04.06.2016", clts.get(7), waters.get(36), 3));
        sales.add( new Sale(18, "04.06.2016", clts.get(6), waters.get(30), 4));
        sales.add( new Sale(19, "04.06.2016", clts.get(11), waters.get(38), 3));
        sales.add( new Sale(20, "04.06.2016", clts.get(0), waters.get(27), 5));
        sales.add( new Sale(21, "05.06.2016", clts.get(1), waters.get(41), 4));
        sales.add( new Sale(22, "05.06.2016", clts.get(10), waters.get(23), 3));
        sales.add( new Sale(23, "05.06.2016", clts.get(2), waters.get(45), 2));
        sales.add( new Sale(24, "05.06.2016", clts.get(9), waters.get(19), 1));
        sales.add( new Sale(25, "05.06.2016", clts.get(3), waters.get(48), 3));
        sales.add( new Sale(26, "05.06.2016", clts.get(8), waters.get(17), 3));
        sales.add( new Sale(27, "06.06.2016", clts.get(4), waters.get(50), 4));
        sales.add( new Sale(28, "06.06.2016", clts.get(7), waters.get(9), 6));
        sales.add( new Sale(29, "06.06.2016", clts.get(5), waters.get(14), 3));
        sales.add( new Sale(30, "06.06.2016", clts.get(6), waters.get(52), 7));
        sales.add( new Sale(31, "07.06.2016", clts.get(1), waters.get(12), 3));
        sales.add( new Sale(32, "07.06.2016", clts.get(11), waters.get(55), 2));
        sales.add( new Sale(33, "07.06.2016", clts.get(0), waters.get(9), 1));
        sales.add( new Sale(34, "07.06.2016", clts.get(10), waters.get(58), 1));
        sales.add( new Sale(35, "08.06.2016", clts.get(2), waters.get(7), 1));
        sales.add( new Sale(36, "08.06.2016", clts.get(9), waters.get(60), 8));
        sales.add( new Sale(37, "08.06.2016", clts.get(3), waters.get(5), 5));
        sales.add( new Sale(38, "08.06.2016", clts.get(8), waters.get(62), 3));
        sales.add( new Sale(39, "09.06.2016", clts.get(4), waters.get(3), 2));
        sales.add( new Sale(40, "09.06.2016", clts.get(7), waters.get(0), 3));
        sales.add( new Sale(41, "09.06.2016", clts.get(5), waters.get(65), 1));
        return sales;
    }

    @Override
    public List<Sale> updateSales(Sale sale){
        sales.add(sale);
        return sales;
    }

    @Override
    public List<Client> updateClientBase(Client client){
        clts.add(client);
        return clts;
    }

    @Override
    public void soldWaterMinus(Water wat, int quant) {
        Water sold = null;
        for(Water i : waters){
            if(i.equals(wat)){
                sold = i;
                break;
            }
        }
        sold.setQuant(sold.getQuant() - quant);
    }

}
