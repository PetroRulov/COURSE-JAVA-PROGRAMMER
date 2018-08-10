package sorting;

import java.util.Arrays;
import java.util.Random;

public class ShellSorter {

    public static void main(String[] args) {

        int[] unsorted = composeArray(20_000);
        System.out.println(Arrays.toString(unsorted));
        System.out.println();
        shellKnuthSorter(unsorted);
    }

    private static int[] composeArray(int numberElements) {
        int [] result = new int[numberElements];
        Random rand = new Random();
        for (int i = 0; i < numberElements; i++) {
            result[i] = rand.nextInt(100);
        }
        return result;
    }

    public static void shellKnuthSorter(int[] theArray) { // h = h * 3 + 1
        long start = System.currentTimeMillis();
        int nElems = theArray.length;
        int inner, outer;
        int temp;
        int h = 1; // h - приращение (расстояние между элементами)
        // Вычисление исходного значения h
        while(h <= nElems / 3)
        {
            h = h * 3 + 1; // (1, 4, 13, 40, 121, ...) интервальная последовательность Д. Кнута
        }

        while(h > 0) // Последовательное уменьшение h до 1
        {
// h-сортировка файла
            for(outer = h; outer < nElems; outer++)
            {
                temp = theArray[outer];
                inner = outer;
// Первый подмассив (0, 4, 8)
                while(inner > (h - 1) && theArray[inner - h] >= temp)
                {
                    theArray[inner] = theArray[inner - h];
                    inner -= h;
                }
                theArray[inner] = temp;
            }
            h = (h - 1) / 3; // Уменьшение h
        }

        long timeExecution = System.currentTimeMillis() - start;
        System.out.println("time of execution shellKnuthSorter = " + timeExecution + " ms");
        System.out.println(Arrays.toString(theArray));
    }
}
