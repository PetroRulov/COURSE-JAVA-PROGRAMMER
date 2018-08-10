package sorting;

import java.util.Arrays;
import java.util.Random;

public class ShakerSorter {

    public static void main(String[] args) {

        int[] unsorted = composeArray(20_000);
        //int unsorted[] = {44, 6, 5, 28, 7, 13, 21, 1, 15, 11, 2};
        System.out.println(Arrays.toString(unsorted));
        System.out.println();
        shakerSorter(unsorted);
        System.out.println(Arrays.toString(unsorted));
    }

    private static int[] composeArray(int numberElements) {
        int [] result = new int[numberElements];
        Random rand = new Random();
        for (int i = 0; i < numberElements; i++) {
            result[i] = rand.nextInt(100);
        }
        return result;
    }

    public static void shakerSorter(int[] theArray){

        int i = 0, temp;
        int length = theArray.length;
        boolean exchange = false;

        do {
            exchange = false;
            for (i = length - 1; i > 0; i--){
                if (theArray[i - 1] > theArray[i]) {
                    temp = theArray[i - 1];
                    theArray[i - 1] = theArray[i];
                    theArray[i] = temp;
                    exchange = true;
                }
            }
            for (i = 1; i < length; ++i){
                if (theArray[i - 1] > theArray[i]) {
                    temp = theArray[i - 1];
                    theArray[i - 1] = theArray[i];
                    theArray[i] = temp;
                    exchange = true;
                }
            }
        }while(exchange);
    }
}
