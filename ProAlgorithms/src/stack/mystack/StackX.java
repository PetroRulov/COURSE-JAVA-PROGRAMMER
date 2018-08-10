package stack.mystack;

//import java.util.ArrayList;
import java.util.LinkedList;

public class StackX<T> {

    private int maxSize; // Размер массива
    private String[] stArr;
    private int top; // Вершина стэка

    public StackX(int s) { // Конструктор
        maxSize = s; // Определение размера стека
        stArr = new String[maxSize]; // Создание массива
        top = -1; // Пока нет ни одного элемента
    }

    public void push(String str) { // Размещение элемента на вершине стека
         // Увеличение top, вставка элемента
        if (isFull()) throw new FullStackXException("The StackX is overloaded!!!");
        else stArr[++top] = str;
    }

    public String pop() { // Извлечение элемента с вершины стека
        return isEmpty() ? "stack is empty" : stArr[top--];
    }

    public String peek() { // Чтение элемента с вершины стека
        return isEmpty() ? "stack is empty" : stArr[top];
    }

    public boolean isEmpty() { // True, если стек пуст
        return (top == -1);
    }

    public boolean isFull() { // True, если стек полон
        return (top == maxSize-1);
    }

}
