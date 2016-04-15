package lesson4theme2;

import java.util.Iterator;

public class Launcher {

    public static void main(String[] args){

        System.err.println("Test Iterator");
        System.out.println();

        SimpleLinkedList sll = new SimpleLinkedList();
        sll.addFirst("test 1");
        sll.addFirst("test 2");
        sll.addFirst("test 3");

        for(Object o : sll){
            String s = (String) o;
            System.out.println(o);
        }

        for(Iterator<Object> it = sll.iterator(); it.hasNext();){
            it.next();
            it.remove();
            break;
        }

        sll.printList();
    }
}
