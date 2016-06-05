package lesson7.generics.containers;

import lesson7.generics.domains.Beer;
import lesson7.generics.domains.Juice;
import lesson7.generics.domains.Water;
import lesson7.generics.enums.Drink;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * Created by prulov on 05.06.2016.
 */
public class WaterBoxDemo {

    private static WaterBox<Water> products = new WaterBox<>();


    public static void main(String[] args) {


        List<Water> waters = Arrays.asList(

            new Beer(Drink.BEER, "HEINEKEN", 0.5, 100, 19.7, 39.4),
            new Beer(Drink.BEER, "MIKULINSKE", 0.5, 300, 6.8, 13.5),
            new Beer(Drink.BEER, "DOBRE PIWO", 0.5, 300, 7.7, 15.6),
            new Beer(Drink.BEER, "CERVONA CELKA", 0.5, 300, 9.7, 21.0),
            new Juice(Drink.JUICE, "PEACH", 1.5, 100, 8.5, 17.8),
            new Juice(Drink.JUICE, "GRAPE", 1.0, 100, 6.8, 14.0),
            new Juice(Drink.JUICE, "CHERRY", 1.5, 150, 10.4, 22.5),
            new Juice(Drink.JUICE, "CARROT", 1.5, 200, 9.7, 18.5)
                );

        System.out.println("LIST Waters Displayed:");

        for(int i = 0; i < waters.size(); i++ ){

            System.out.println(waters.get(i).toString());
        }

        System.out.println();
//        System.out.println("NAME Comparator:");
//
//        Collections.sort(waters, new NameComparator());
//
//        for(int i = 0; i < waters.size(); i++ ){
//
//            System.out.println(waters.get(i).toString());
//        }
//
//        System.out.println();
//        System.out.println("PRICE Comparator:");
//
//        Collections.sort(waters, new PriceComparator());
//
//        for(Water w : waters){
//
//            System.out.println(w.toString());
//        }
//
//        System.out.println();

        //products.setWaters(waters);

//        Collections.sort(waters, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
//        System.out.println("WATERBOX PRODUCTS sorted by Names displayed:");
//        System.out.println(products.getWaters() + "\n");
        //Collections.sort(waters, (a, b) -> a.getPrice() < b.getPrice() ? -1 : a.getPrice() == b.getPrice() ? 0 : 1);
        //System.out.println("WATERBOX PRODUCTS sorted by Price displayed:");
        //System.out.println(products.getWaters()+ "\n");

        products.sorterWBbyPriceDecrease(waters);
        products.setWaters(waters);
        System.out.println("WATERBOX PRODUCTS sorted by Prices decreasing displayed:");

        for(int i = 0; i < products.getWaters().size(); i++ ){

            System.out.println(products.getWaters().get(i).toString());
        }

        //System.out.println(products.getWaters()+ "\n");

    }
}

class NameComparator implements Comparator<Water> {

    @Override
    public int compare(Water o1, Water o2) {
        String d1 = o1.getName();
        String d2 = o2.getName();
        int result = d1.compareToIgnoreCase(d2);
        if (result < 0) {
            return 1;
        } else if (result > 0) {
            return -1;
        }
        return 0;
    }
}

class ValueComparator implements Comparator<Water> {
    @Override
    public int compare(Water a, Water b) {
        return a.getPrice() < b.getValue() ? 1 : a.getValue() == b.getValue() ? 0 : -1;
    }
}
