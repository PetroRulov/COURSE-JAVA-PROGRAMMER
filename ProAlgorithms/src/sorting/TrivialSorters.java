package sorting;

import java.util.Arrays;
import java.util.Random;

public class TrivialSorters {

    public static void main(String[] args) {
        // ASC - ascending
        // DESC - descending

        //int unsorted[] = new int[]{12, 7, -3, 0, 1, 4, 14, 6, 3, 26, -6, 2, 0, 1, 5, -18, 2, 15};
        int[] unsorted = composeArray(20_000);
        System.out.println(Arrays.toString(unsorted));
        System.out.println();
        bubbleSorterASC(unsorted);
        System.out.println();
        bubbleSorterDESC(unsorted);
        System.out.println();
        selectionSorterASC(unsorted);
        System.out.println();
        selectionSorterDESC(unsorted);
        System.out.println();
        insertionSorterASC(unsorted);
        System.out.println();
        insertionSorterDESC(unsorted);
    }

    private static int[] composeArray(int numberElements) {
        int [] result = new int[numberElements];
        Random rand = new Random();
        for (int i = 0; i < numberElements; i++) {
            result[i] = rand.nextInt(100);
        }
        return result;
    }

    private static void bubbleSorterASC(int[] unsorted) {
        long start = System.currentTimeMillis();

        //method's body
        int out, in, temp;
        for (out = unsorted.length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (unsorted[in] > unsorted[in + 1]) {
                    temp = unsorted[in];
                    unsorted[in] = unsorted[in + 1];
                    unsorted[in + 1] = temp;
                }
            }
        }
        // the End.

        long timeExecution = System.currentTimeMillis() - start;
        System.out.println("time of execution ASCBubbleSorter = " + timeExecution + " ms");
        System.out.println(Arrays.toString(unsorted));
    }

    private static void bubbleSorterDESC(int[] unsorted) {
        long start = System.currentTimeMillis();

        //method's body
        int out, in, temp;
        for (out = unsorted.length - 1; out > 0; out--) {
            for (in = 0; in < out; in++) {
                if (unsorted[in] < unsorted[in + 1]) {
                    temp = unsorted[in];
                    unsorted[in] = unsorted[in + 1];
                    unsorted[in + 1] = temp;
                }
            }
        }
        // the End.

        long timeExecution = System.currentTimeMillis() - start;
        System.out.println("time of execution DESCBubbleSorter = " + timeExecution + " ms");
        System.out.println(Arrays.toString(unsorted));
    }

    private static void selectionSorterASC(int[] unsorted) {
        long start = System.currentTimeMillis();

        //method's body
        int out, in, temp, min;
        for (out = 0; out < unsorted.length - 1; out++) {
            min = out;
            for (in = (out + 1); in < unsorted.length; in++ ) {
                if (unsorted[in] < unsorted[min]) {
                    min = in;
                }
            }
            temp = unsorted[out];
            unsorted[out] = unsorted[min];
            unsorted[min] = temp;
        }
        //the End.

        long timeExecution = System.currentTimeMillis() - start;
        System.out.println("time of execution ASCselectionSorter = " + timeExecution + " ms");
        System.out.println(Arrays.toString(unsorted));
    }

    private static void selectionSorterDESC(int[] unsorted) {
        long start = System.currentTimeMillis();

        //method's body
        int out, in, temp, max;
        for (out = 0; out < unsorted.length - 1; out++) {
            max = out;
            for (in = (out + 1); in < unsorted.length; in++ ) {
                if (unsorted[in] > unsorted[max]) {
                    max = in;
                }
            }
            temp = unsorted[out];
            unsorted[out] = unsorted[max];
            unsorted[max] = temp;
        }
        //the End.

        long timeExecution = System.currentTimeMillis() - start;
        System.out.println("time of execution DESCselectionSorter = " + timeExecution + " ms");
        System.out.println(Arrays.toString(unsorted));
    }

    private static void insertionSorterASC(int[] unsorted) {
        long start = System.currentTimeMillis();

        //method's body
        int out, in, pointedElem;
        for (out = 1; out < unsorted.length; out++) {
            pointedElem = unsorted[out];
            in = out;
            while (in > 0 && unsorted[in -1] >= pointedElem) {
                unsorted[in] = unsorted[in - 1];
                --in;
            }
            unsorted[in] = pointedElem;
        }
        //the End.

        long timeExecution = System.currentTimeMillis() - start;
        System.out.println("time of execution ASCinsertionSorter = " + timeExecution + " ms");
        System.out.println(Arrays.toString(unsorted));
    }

    private static void insertionSorterDESC(int[] unsorted) {
        long start = System.currentTimeMillis();

        //method's body
        int out, in, pointedElem;
        for (out = 1; out < unsorted.length; out++) {
            pointedElem = unsorted[out];
            in = out;
            while (in > 0 && unsorted[in -1] <= pointedElem) {
                unsorted[in] = unsorted[in - 1];
                --in;
            }
            unsorted[in] = pointedElem;
        }
        //the End.

        long timeExecution = System.currentTimeMillis() - start;
        System.out.println("time of execution DESCinsertionSorter = " + timeExecution + " ms");
        System.out.println(Arrays.toString(unsorted));
    }
}
