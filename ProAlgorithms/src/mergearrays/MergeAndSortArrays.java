package mergearrays;

import java.util.Arrays;

public class MergeAndSortArrays {

    public static void main(String[] args) {

        int a[] = new int[]{ -20, -8, -4, 0, 0, 1, 2, 2, 4, 6, 6, 8, 14, 14, 16, 27, 41, 48, 99};
        int b[] = new int[]{ -54,-10, -6, 0, 0, 1, 1, 4, 8, 12, 12, 20, 34, 46, 48, 87, 124};
        displayArr(mergeArraysWithSortASC(a, b));
        System.out.println();

        int c[] = new int[]{48, 0, 89, -4, 12, -55, 48, 7, -12, 20, 5, 6, 0, 4, 2, 1, 124, 2, -8, 18, 25};
        recursiveMergeSort(c, 0, c.length - 1);
        displayArr(c);

    }

    static int[] mergeArraysWithSortASC(int[] a1, int[] a2) {

        int[] a3 = new int[a1.length + a2.length];

        int i=0, j=0;
        for (int k = 0; k < a3.length; k++) {
            if (i > a1.length - 1) {
                int a = a2[j];
                a3[k] = a;
                j++;
            }
            else if (j > a2.length - 1) {
                int a = a1[i];
                a3[k] = a;
                i++;
            }
            else if (a1[i] < a2[j]) {
                int a = a1[i];
                a3[k] = a;
                i++;
            }
            else {
                int b = a2[j];
                a3[k] = b;
                j++;
            }
        }
        return a3;
    }

    static void displayArr(int[] arr) {

        for(int i : arr) {
            System.out.print(i + ", ");
        }
    }

    /*Здесь:
    a – массив;
    lo – позиция первого элемента в массиве (для первой итерации = 0);
    hi – позиция последнего элемента в массиве (для первой итерации = a.length — 1).*/

    static void recursiveMergeSort(int[] a, int lo, int hi) {

        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        recursiveMergeSort(a, lo, mid);
        recursiveMergeSort(a, mid + 1, hi);

        int[] buf = Arrays.copyOf(a, a.length);

        for (int k = lo; k <= hi; k++)
            buf[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {

            if (i > mid) {
                a[k] = buf[j];
                j++;
            } else if (j > hi) {
                a[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                a[k] = buf[j];
                j++;
            } else {
                a[k] = buf[i];
                i++;
            }
        }
    }

}
