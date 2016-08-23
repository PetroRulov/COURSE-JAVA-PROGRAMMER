package studychecktest.ifmethodrealization;

import java.util.Random;

/**
 * Created by prulov on 21.08.2016.
 */
public class Main {

    public static void main(String[] args) {

        InterfaceInheritor ii = new InterfaceInheritor("dick", "red", 0);
        Dicker dick = new Dicker();
        Dicker neo = new Dicker();

        Random r = new Random();
        int i = r.nextInt(5);
        System.out.print("i = " + i + ", ");
        int a = i>=3?5:10;
        System.out.println(a);
        ii.setQuantity(a);

        if(ii.getQuantity()==10){
            dick=ii.transformation(ii);
            neo = ii.autoTransormattion();
        }
        System.out.println(dick.toString());
        System.out.println(neo.toString());
    }



}
