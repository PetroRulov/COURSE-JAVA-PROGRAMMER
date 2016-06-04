package lesson7.generics.methods;

import java.util.Arrays;
import java.util.List;

/**
 * Created by prulov on 04.06.2016.
 */
public class Wildcards {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(new Integer[]{1, 2, 3});
        print(integers);

        System.out.println();

        List<Long> longers = Arrays.asList(new Long[]{10L, 20L, 30L});
        print(longers);
    }

    public static void print(List<? extends Number> numbers){

        for(Number n : numbers){
            System.out.println(n.toString());
        }
    }
}
