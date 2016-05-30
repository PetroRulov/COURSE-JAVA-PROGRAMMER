package main;

import domain.waters.*;
import enumerations.Drink;
import enumerations.Tare;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by prulov on 26.05.2016.
 */

public class Stock {

    private Water[] wat;
    private List<Water> waters;
    private Vector<Water> vat;


    public Stock(){

        this.wat = new Water[100];
        this.waters = new ArrayList<>();
        this.vat = new Vector<>();

        initStock(); // filling Array
        fillListStock(); // filling List
        fillVectorStock(); // filling Vector
    }

    public Water[] getWat() {
        return wat;
    }

    public List<Water> getWaters(){
        return new ArrayList<>(waters);
    }

    public Vector<Water> getVat() {

        //fillVectorStock();
        return new Vector<Water>(vat);
    }

    /**-T h e     q u a n t i t y     o f      G o o d s     i n     S t o c k-*/
    public void printWat() {

        System.out.println();
        System.out.println("-----------------------------" + "\"BADIGAN\" WAREHOUSE" + "------------------------------|");
        System.out.println("------------------------------------------------------------------------------|");
        System.out.printf("%-1s%-10s%-25s%-10s%-10s%-10s%-10s%n", "|#", "| Type", "| Name", "| Tare", "| Volume", "| Price", "| Quantity |");
        System.out.println("------------------------------------------------------------------------------|");
        int j = 0;
        for (int i = 0; i < wat.length; i++) {
            if (wat[i] != null) {
                j++;
                System.out.print(j);
                wat[i].waterInfoShow();
            }
        }
        System.out.println("------------------------------------------------------------------------------|");
        System.out.println("--------------------------------------------------------- AT ALL: " + quantRecorder() + " items -|");
        System.out.println("------------------------------------------------------------------------------|");

    }

    public void printWaters() {

        System.out.println();
        System.out.println("-----------------------------" + "\"BADIGAN\" WAREHOUSE" + "------------------------------|");
        System.out.println("------------------------------------------------------------------------------|");
        System.out.printf("%-1s%-10s%-25s%-10s%-10s%-10s%-10s%n", "|#", "| Type", "| Name", "| Tare", "| Volume", "| Price", "| Quantity |");
        System.out.println("------------------------------------------------------------------------------|");
        int j = 0;
        for (int i = 0; i < waters.size(); i++) {
            if (waters.get(i) != null) {
                j++;
                System.out.print(j);
                waters.get(i).waterInfoShow();
            }
        }
        System.out.println("------------------------------------------------------------------------------|");
        System.out.println("--------------------------------------------------------- AT ALL: " + quantCounterList() + " items -|");
        System.out.println("------------------------------------------------------------------------------|");

    }

    private int quantRecorder(){

        int x = 0;
        for (int i = 0; i < wat.length; i++) {
            if (wat[i] != null) {
                x += wat[i].getQuant();

            }
        }
        return x;
    }

    private int quantCounterList(){

        int x = 0;
        for (int i = 0; i < waters.size(); i++) {
            if (waters.get(i) != null) {
                x += waters.get(i).getQuant();
            }
        }
        return x;
    }

    private void initStock() {

        //WATER
        wat[0] = new Water(Drink.WATER, "Petrova, soda", Tare.PAT, 2.0, 200, 12.4, 21.7);
        wat[1] = new Water(Drink.WATER, "Petrova, soda", Tare.PAT, 1.0, 200, 9.6, 16.5);
        wat[2] = new Water(Drink.WATER, "Petrova, soda", Tare.PAT, 0.5, 200, 4.8, 9.6);
        wat[3] = new Water(Drink.WATER, "Petrova, soda", Tare.GLASS, 0.5, 200, 6.5, 11.5);
        wat[4] = new Water(Drink.WATER, "Tselebnaya, mineral", Tare.PAT, 0.9, 150, 12.3, 24.6);
        wat[5] = new Water(Drink.WATER, "Tselebnaya, mineral", Tare.GLASS, 0.45, 150, 6.7, 13.4);

        //JUICE
        wat[6] = new Juice(Drink.JUICE, "MAPE, Cherry", Tare.TETRAPAC, 1.0, 200, 12.4, 21.8);
        wat[7] = new Juice(Drink.JUICE, "MAPE, Peach", Tare.TETRAPAC, 1.0, 200, 12.4, 22.0);
        wat[8] = new Juice(Drink.JUICE, "MAPE, Pear", Tare.TETRAPAC, 1.0, 200, 12.4, 21.5);
        wat[9] = new Juice(Drink.JUICE, "MAPE, Grape", Tare.TETRAPAC, 1.0, 200, 11.2, 20.5);
        wat[10] = new Juice(Drink.JUICE, "MAPE, Pamela", Tare.TETRAPAC, 1.0, 200, 12.4, 21.8);
        wat[11] = new Juice(Drink.JUICE, "MAPE, Garnet", Tare.TETRAPAC, 1.0, 200, 13.6, 24.0);
        wat[12] = new Juice(Drink.JUICE, "MAPE, Orange", Tare.TETRAPAC, 1.0, 200, 11.5, 21.0);
        wat[13] = new Juice(Drink.JUICE, "MAPE, Tomato", Tare.TETRAPAC, 1.0, 200, 10.5, 20.4);

        //VINES
        wat[14] = new Vine(Drink.VINE, "Aligote", "white", "dry", Tare.GLASS, 0.7, 30, 28.7, 56.8);
        wat[15] = new Vine(Drink.VINE, "Risling", "white", "dry", Tare.GLASS, 0.7, 30, 29.3, 58.6);
        wat[16] = new Vine(Drink.VINE, "Sauvignon Blanc", "white", "dry", Tare.GLASS, 0.7, 30, 32.0, 64.6);
        wat[17] = new Vine(Drink.VINE, "Shardonney", "white", "dry", Tare.GLASS, 0.7, 30, 28.0, 54.2);
        wat[18] = new Vine(Drink.VINE, "Shennon Blanc", "white", "semidry", Tare.GLASS, 0.7, 30, 38.2, 76.0);
        wat[19] = new Vine(Drink.VINE, "Gewuztraminer", "white", "semidry", Tare.GLASS, 0.7, 30, 40.8, 87.5);
        wat[20] = new Vine(Drink.VINE, "Riunite Moscato", "white", "semidry", Tare.GLASS, 0.7, 30, 44.8, 94.6);
        wat[21] = new Vine(Drink.VINE, "Southern", "white", "semisweet", Tare.GLASS, 0.7, 30, 50.8, 106.4);
        wat[22] = new Vine(Drink.VINE, "Bordeux", "red", "dry", Tare.GLASS, 0.7, 30, 38.0, 76.4);
        wat[23] = new Vine(Drink.VINE, "Merlot", "red", "dry", Tare.GLASS, 0.7, 30, 39.4, 79.6);
        wat[24] = new Vine(Drink.VINE, "Cabernet Sauvignon", "red", "dry", Tare.GLASS, 0.7, 30, 32.0, 68.0);
        wat[25] = new Vine(Drink.VINE, "Riunite Rose", "rose", "dry", Tare.GLASS, 0.7, 30, 48.0, 116.0);
        wat[26] = new Vine(Drink.VINE, "SHABO Classic", "white", "semidry", Tare.GLASS, 0.7, 30, 38.2, 76.0);
        wat[27] = new Vine(Drink.VINE, "Pinot Noir", "rubin", "semidry", Tare.GLASS, 0.7, 30, 41.8, 88.2);
        wat[28] = new Vine(Drink.VINE, "Boussole", "red", "semidry", Tare.GLASS, 0.7, 30, 44.8, 94.6);
        wat[29] = new Vine(Drink.VINE, "Portwein Bastardo", "red", "semisweet", Tare.GLASS, 0.7, 30, 60.0, 120.0);
        wat[30] = new Vine(Drink.VINE, "INKERMAN", "red", "semidry", Tare.TETRAPAC, 0.7, 30, 74.5, 164.8);
        wat[31] = new Vine(Drink.VINE, "INKERMAN", "white", "semisweet", Tare.TETRAPAC, 0.7, 30, 70.0, 162.5);

        //BURBON
        wat[32] = new Burbon(Drink.BURBON, "JIM BEAM", Tare.GLASS, 0.7, 40, 298.0, 556.0);
        wat[33] = new Burbon(Drink.BURBON, "JIM BEAM", Tare.PAT, 0.2, 40, 98.0, 204.0);
        wat[34] = new Burbon(Drink.BURBON, "Maker's MARK", Tare.GLASS, 0.7, 40, 338.0, 604.0);
        wat[35] = new Burbon(Drink.BURBON, "Maker's MARK", Tare.PAT, 0.2, 37, 95.0, 199.0);
        wat[36] = new Burbon(Drink.BURBON, "JACK Daniel's", Tare.GLASS, 0.7, 40, 368.08, 724.0);
        wat[37] = new Burbon(Drink.BURBON, "JACK Daniel's", Tare.PAT, 0.2, 37, 95.0, 201.0);
        wat[38] = new Burbon(Drink.BURBON, "WILD Turkey", Tare.GLASS, 0.7, 40, 325.0, 660.0);
        wat[39] = new Burbon(Drink.BURBON, "WILD Turkey", Tare.PAT, 0.2, 38, 92.0, 180.0);
        wat[40] = new Burbon(Drink.BURBON, "Brown FORMAN", Tare.GLASS, 0.7, 39, 348.0, 712.0);
        wat[41] = new Burbon(Drink.BURBON, "Brown FORMAN", Tare.GLASS, 0.33, 35, 117.0, 264.0);

        //VODKA
        wat[42] = new Vodka(Drink.VODKA, "Stolichnaya", Tare.GLASS, 0.7, 40, 77.0, 164.0);
        wat[43] = new Vodka(Drink.VODKA, "Stolichnaya", Tare.PAT, 0.25, 39, 37.0, 70.0);
        wat[44] = new Vodka(Drink.VODKA, "Cremlin", Tare.CLAY, 1.25, 30, 167.5, 320.0);
        wat[45] = new Vodka(Drink.VODKA, "Posolskaya", Tare.GLASS, 0.7, 80, 47.5, 95.0);
        wat[46] = new Vodka(Drink.VODKA, "Posolskaya", Tare.GLASS, 0.5, 80, 37.5, 75.0);
        wat[47] = new Vodka(Drink.VODKA, "Posolskaya", Tare.GLASS, 0.375, 65, 21.3, 47.5);
        wat[48] = new Vodka(Drink.VODKA, "Fruktovitsa Grape", Tare.GLASS, 0.5, 40, 27.8, 65.0);
        wat[49] = new Vodka(Drink.VODKA, "Fruktovitsa Pear", Tare.GLASS, 0.5, 38, 25.4, 56.0);
        wat[50] = new Vodka(Drink.VODKA, "Kalashnikov", Tare.TOY, 0.8, 20, 89.4, 184.0);
        wat[51] = new Vodka(Drink.VODKA, "PM", Tare.TOY, 0.4, 20, 47.6, 98.4);

        //BRENDY
        wat[52] = new Brendy(Drink.BRENDY, "METAXA *****", Tare.GLASS, 0.7, 180, 284.5, 516.0);
        wat[53] = new Brendy(Drink.BRENDY, "TORRES *****", Tare.GLASS, 0.5, 80, 224.5, 425.0);
        wat[54] = new Brendy(Drink.BRENDY, "TORRES ****", Tare.GLASS, 0.5, 70, 194.5, 405.0);
        wat[55] = new Brendy(Drink.BRENDY, "Seint Remi XO", Tare.GLASS, 0.5, 30, 3384.5, 705.0);
        wat[56] = new Brendy(Drink.BRENDY, "ARARAT *****", Tare.GLASS, 0.5, 30, 284.5, 506.0);
        wat[57] = new Brendy(Drink.BRENDY, "ARARAT ****", Tare.GLASS, 0.375, 45, 201.5, 436.0);
        wat[58] = new Brendy(Drink.BRENDY, "ARARAT ***", Tare.GLASS, 0.5, 60, 124.5, 240.0);
        wat[59] = new Brendy(Drink.BRENDY, "ZAKARPATSKY *****", Tare.GLASS, 0.5, 93, 74.5, 156.0);
        wat[60] = new Brendy(Drink.BRENDY, "UZHGOROD *****", Tare.GLASS, 0.5, 46, 124.5, 296.0);

        //TEQUILA
        wat[61] = new Tequila(Drink.TEQUILA, "Jose Cuervo Especial", Tare.GLASS, 0.8, 20, 584.5, 1212.0);
        wat[62] = new Tequila(Drink.TEQUILA, "SAUZA PLATINUM", Tare.GLASS, 0.7, 20, 564.0, 1175.0);
        wat[63] = new Tequila(Drink.TEQUILA, "DON JULIO", Tare.GLASS, 0.7, 20, 494.5, 1080.0);
        wat[64] = new Tequila(Drink.TEQUILA, "CASAD'ORES", Tare.GLASS, 0.7, 20, 414.5, 980.0);
        wat[65] = new Tequila(Drink.TEQUILA, "HERRADURA", Tare.GLASS, 0.7, 20, 384.5, 775.0);
        wat[66] = new Tequila(Drink.TEQUILA, "1800", Tare.GLASS, 1.0, 25, 561.5, 1184.0);

        //BEER
        wat[67] = new Beer(Drink.BEER, "WARSTEINER, Lager", Tare.GLASS, 0.5, 100, 24.5, 48.0);
        wat[68] = new Beer(Drink.BEER, "HOEGAARDEN", Tare.GLASS, 0.66, 150, 19.8, 44.0);
        wat[69] = new Beer(Drink.BEER, "BRIDGEPORT, ALE", Tare.GLASS, 0.5, 100, 18.5, 36.0);
        wat[70] = new Beer(Drink.BEER, "PAULANER, München", Tare.GLASS, 0.64, 100, 24.5, 49.0);
        wat[71] = new Beer(Drink.BEER, "ERDINGER \"Festweiße\"", Tare.GLASS, 0.7, 100, 24.5, 50.0);
        wat[72] = new Beer(Drink.BEER, "BUDWEISER \"Budvar\"", Tare.GLASS, 0.5, 150, 21.5, 44.0);
        wat[73] = new Beer(Drink.BEER, "GAMBRINUS \"Bílé\"", Tare.GLASS, 0.7, 125, 21.5, 44.0);
        wat[74] = new Beer(Drink.BEER, "GUINNES", Tare.GLASS, 0.74, 50, 21.6, 52.4);

    }

    private void fillListStock() {

        for(Water w : wat){
            if(w != null){
                waters.add(w);
            }
        }
    }

    private void fillVectorStock() {

        for(Water w : wat){
            if(w != null){
                vat.add(w);

            }
        }
    }

    public void soldWaterMinus(Water wat, int quant){

        Water sold = null;
        for(Water i : getVat()){
            if(i.equals(wat)){
                sold = i;
                break;
            }
        }
        sold.setQuant(sold.getQuant() - quant);
    }

}

