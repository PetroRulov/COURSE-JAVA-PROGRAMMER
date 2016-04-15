package lesson4theme5.stack;

/**
 * Created by prulov on 09.04.2016.
 */
public class DemoStack {

    public static void main(String[] args) {
        Stack stk = new Stack();
        stk.push("1");
        stk.push("2");
        stk.push("3");
        stk.push("4");
        stk.push("5");
        stk.printStack();
        System.out.println();

        System.out.println(stk.pop());
        System.out.println();
        stk.printStack();
        System.out.println();

        System.out.println(stk.peek());
        //stk.printStack();
    }
}

