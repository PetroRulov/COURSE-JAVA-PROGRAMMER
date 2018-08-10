package stack;

import stack.mystack.LinkListStack;
import stack.mystack.StackX;

public class StackXTest {

    public static void main(String[] args)
    {
        StackX theStack = new StackX(10); // Создание нового стека
        theStack.push("A"); // Занесение элементов в стек
        theStack.push("B");
        theStack.push("C");
        theStack.push("D");
        theStack.push("E");
        theStack.push("F");
        theStack.push("G");
        theStack.push("H");
        theStack.push("K");

        theStack.push("L");
        theStack.push("M");

        System.out.println("the peek value = " + theStack.peek());
        theStack.pop();
        System.out.println("the peek value = " + theStack.peek());

        while (!theStack.isEmpty()) { // Пока стек не станет пустым
            String value = theStack.pop(); // Удалить элемент из стека
            System.out.print(value); // Вывод содержимого
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("the peek value = " + theStack.peek());
        System.out.println("Can't pop the element because the " + theStack.pop());
        System.out.println();

        LinkListStack lls = new LinkListStack();
        lls.push("A");
        lls.push("B");
        lls.push("C");
        lls.push("D");
        lls.push("E");
        lls.push("F");
        lls.push("G");

        System.out.println("the peek value = " + lls.peek());
        lls.pop();

        System.out.println("the peek value = " + lls.peek());
        while (!lls.isEmpty()) { // Пока стек не станет пустым
            String value = (String) lls.pop(); // Удалить элемент из стека
            System.out.print(value); // Вывод содержимого
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("the peek value = " + lls.peek());
        System.out.println("Can't pop() " + lls.pop() + " because stack is empty!" );

    }

}
