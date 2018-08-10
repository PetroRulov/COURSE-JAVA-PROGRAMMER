package lists.onewaylist;

public class OneWayList {

    private Link first;

    public OneWayList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.setNext(first);
        first = newLink;
    }

    public Link find(int key) {
        Link current = first;
        while (current.getiData() != key) {
            if (current.getNext() == null) return null;
            else current = current.getNext();
        }
        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current.getiData() != key) {
            if (current.getNext() == null) return null;
            else {
                previous = current;
                current = current.getNext();
            }
        }
        if (current == first) first = first.getNext();
        else previous.setNext(current.getNext());
        return current;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.getNext();
        return temp;
    }

    public void displayList() {
        System.out.print("OneWayList (first --> last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("");
    }


}
