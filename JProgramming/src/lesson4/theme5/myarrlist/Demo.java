package lesson4.theme5.myarrlist;

/**
 * Created by prulov on 08.04.2016.
 */
public class Demo {

    public static void main(String[] args){

        SimpleArrayList n = new SimpleArrayList(0);

        System.out.println();
        n.printList();
        n.addFirst("Alpha");
        n.printList();
        n.addLast("Ypsilon");
        n.printList();
        n.addLast("Iks");
        n.printList();
        n.addLast("Zet");
        n.printList();
        n.addFirst("Lyambda");
        n.printList();
        n.addLast("Beta");
        n.printList();
        n.addFirst("Delta");
        n.printList();
        n.addAfter("Lyambda", "Omega");
        n.printList();
        n.addAfter("Omega", "Ygrek");
        n.printList();
        n.addAfter("Ivanov", "Gamma");
        n.printList();
        n.addAfter("Ivanov", "Gamma");
        n.addAfter("Lyambda", "Sigma");
        n.printList();
        n.removeObject("Omega");
        n.printList();
        n.removeObject("Petrov");
        n.printList();

        System.out.println();

        n.trimToSize(n.getList());
        n.printList();



    }
}
