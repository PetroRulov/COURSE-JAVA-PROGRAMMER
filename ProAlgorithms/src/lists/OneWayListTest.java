package lists;

import lists.onewaylist.Link;
import lists.onewaylist.OneWayList;

public class OneWayListTest {

    public static void main(String[] args) {

        OneWayList owl = new OneWayList();
        System.out.println(owl.isEmpty());
        System.out.println();

        owl.insertFirst(22, 2.99);
        owl.insertFirst(44, 4.99);
        owl.insertFirst(66, 6.99);
        owl.insertFirst(88, 8.99);
        owl.insertFirst(111, 10.99);

        System.out.println(owl.isEmpty());
        System.out.print("Element with 22 = ");
        owl.find(22).displayLink();
        System.out.println();
        System.out.println();

        Link d = owl.delete(66);

        owl.displayList();
        while (!owl.isEmpty()) {
            Link aLink = owl.deleteFirst();
            System.out.print("Deleted ");
            aLink.displayLink();
            System.out.println("");
        }
        owl.displayList();

    }
}
