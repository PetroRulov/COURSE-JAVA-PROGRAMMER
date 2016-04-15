package lesson4theme2;

import java.util.Iterator;

public class SimpleLinkedList implements Iterable<Object> {

    private Node root;
    private int size;

    public SimpleLinkedList() {
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(Object f) {

        Node n = new Node();
        n.o = f;
        if (root != null) {
            n.ref = root;
        }
        root = n;
        size++;
    }


    public void addLast(Object l) {

        Node n = new Node();
        n.o = l;
        if (root != null) { // i.e. there are elements in OLL
            Node cp = root;
            while (cp.ref != null) { // until we'll find last element (its ref == null)
                cp = cp.ref; // assigning reference to every next element
            }
            cp.ref = n; // as we find last element - assign reference of penult element to last element
        } else {
            root = n; // in case OLL doesn't have elements
        }
        size++;
    }

    public void addAfter(Object obj, Object prev) {

        Node prevPointer = null;
        Node cp = root;

        do {
            if (cp.o == prev) {
                prevPointer = cp;
                break;
            }
            cp = cp.ref;
        } while (cp != null && cp.ref != null);

        if (prevPointer == null) {
            throw new IllegalStateException("List doesn't contain prev object.");
        }
        Node n = new Node();
        n.o = obj;
        if (prevPointer.ref != null) {
            n.ref = prevPointer.ref;
        }
        prevPointer.ref = n;
        size++;
    }

    public void printList() {

        if (size == 0) {
            System.out.println("List is empty!");
        }

        System.out.print("{ ");
        Node cp = root;
        while (cp.ref != null) {
            System.out.print(cp.o + ", ");
            cp = cp.ref;
        }
        System.out.print(cp.o);
        System.out.println(" }");
    }

    private class Node {

        private Object o;
        private Node ref;

    }

    @Override
    public Iterator<Object> iterator() {
        return new SLLIterator();
    }

    private class SLLIterator implements Iterator<Object> {
        private Node cp;
        private Node prev;

        public SLLIterator() {
        }

        @Override
        public boolean hasNext() {
            return (cp == null && root != null) || (cp != null && cp.ref != null);
        }

        @Override
        public Object next() {

            // for first element
            if(cp == null && root != null){
                cp = root;
                return cp.o;
            }
            if(hasNext()){
                // for others
                prev = cp;
                cp = cp.ref;
                return cp.o;
            }
            throw new IllegalStateException("There are no elements anymore in OurSLL");
        }

        @Override
        public void remove() {
            if (!hasNext() && prev == null) {
                // if one element in OurSLL only
                cp = null;
                root = null;
            } else if(!hasNext() && prev != null) {
                // if we remove last element only
                prev.ref = null;
                cp = null;
            } else  if(hasNext() && prev == null) {
                // if element is first
                root = cp.ref;
                cp = root;
            } else {
                // if element in the middle
                prev.ref = cp.ref;
                cp = cp.ref;
            }
            size--;
        }
    }
}
