package stack.mystack;

import java.util.LinkedList;

public class LinkListStack<T> {

    private final LinkedList<T> tList = new LinkedList<>();

    public void push(T data) { // Размещение элемента на вершине стека
        tList.addFirst(data); // Увеличение top, вставка элемента
    }

    public T pop() {

        return isEmpty() ? null : tList.removeFirst();
        //return tList.removeFirst();
    }

    public T peek() {
        return isEmpty() ? null : tList.getFirst();
        //return tList.getFirst();
    }

    public boolean isEmpty() {
        return tList.isEmpty();
    }

}

