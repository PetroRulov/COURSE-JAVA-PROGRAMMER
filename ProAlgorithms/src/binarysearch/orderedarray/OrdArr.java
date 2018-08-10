package binarysearch.orderedarray;

public class OrdArr {

    private long[] mass;
    private int length;

    public OrdArr(int max) {
        mass = new long[max];
        length = 0;
    }

    public int size() {
        return length;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = length - 1;
        int curIn;
        while(true) {
            curIn = (lowerBound + upperBound ) / 2;
            if (mass[curIn]==searchKey) {
                return curIn; // Элемент найден
            } else if (lowerBound > upperBound) {
                return length; // Элемент не найден
            } else { // Деление диапазона
                if(mass[curIn] < searchKey)
                    lowerBound = curIn + 1; // В верхней половине
                else
                    upperBound = curIn - 1; // В нижней половине
            }
        }
    }

    public void insert(long value) { // Вставка элемента в массив
        int j;
        for(j = 0; j < length; j++) { // Определение позиции вставки
            if(mass[j] > value) {
                break; // (линейный поиск)
            }
        }
        for(int k = length; k > j; k--) { // Перемещение последующих элементов
            mass[k] = mass[k - 1];
        }
        mass[j] = value; // Вставка
        length++; // Увеличение размера
    }

    public boolean delete(long value) {
        int j = find(value);
        if(j == length) { // Найти не удалось
            return false;
        }
        else {// Элемент найден
            for(int k = j; k < length; k++) { // Перемещение последующих элементов
                mass[k] = mass[k + 1];
                length--; // Уменьшение размера
            }
            return true;
        }
    }

    public void display() { // Вывод содержимого массива
        for(int j = 0; j < length; j++) { // Перебор всех элементов
            System.out.print(mass[j] + " "); // Вывод текущего элемента
        }
        System.out.println("");
    }
}

