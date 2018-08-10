package lists.onewaylist;

public class Link {

    private int iData;
    private double dData;
    private Link next;

    public Link(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
        // next automatically null
    }

    public void displayLink() {
        System.out.print("{" + iData + ", " + dData + "}, ");
    }

    public int getiData() {
        return iData;
    }

    public void setiData(int iData) {
        this.iData = iData;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }
}
