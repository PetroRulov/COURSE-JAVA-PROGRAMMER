package lesson7.generics.methods;

import java.util.Arrays;
import java.util.List;

/**
 * Created by prulov on 04.06.2016.
 */
public class GenericMethodDemo {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList(new String[]{"one", "two", "three"});
        print(strings);

        System.out.println();

        List<Integer> numbers = Arrays.asList(new Integer[]{1, 2, 3});
        print(numbers);
    }

    public static <E> void print(List<E> elements){

        for(E e : elements){
            System.out.println(e.toString());
        }
    }
}
