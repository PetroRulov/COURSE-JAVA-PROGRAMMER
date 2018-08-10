package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSorter {

    public static void main(String[] args) {
        //int[] unsorted = composeArray(20_000);
        int unsorted[] = {44, 6, 5, 28, 7, 13, 21, 1, 15, 11, 2};
        int lastIndex = unsorted.length - 1;
        System.out.println(Arrays.toString(unsorted));
        System.out.println();
        long startTime = System.currentTimeMillis();
        quickSorter(unsorted, 0, lastIndex);
        long timeExecution = System.currentTimeMillis() - startTime;
        System.out.println("time of execution quickSorter = " + timeExecution + " ms");
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

    private static void quickSorter(int[] array, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int curIndex = i - (i - j) / 2;
        System.out.println("Pivot = " + array[curIndex] + ", start = " + start + ", end = " + end);
        while (i < j) {
            while (i < curIndex && (array[i] <= array[curIndex])) {
                i++;
            }
            while (j > curIndex && (array[curIndex] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == curIndex)
                    curIndex = j;
                else if (j == curIndex)
                    curIndex = i;
            }
            //System.out.println(Arrays.toString(array));
        }
        System.out.println(Arrays.toString(array));
        quickSorter(array, start, curIndex);
        quickSorter(array, curIndex + 1, end);

    }

}
