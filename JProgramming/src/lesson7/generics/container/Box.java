package lesson7.generics.container;

/**
 * Created by prulov on 04.06.2016.
 */
public class Box<T> {

    private T item;

    public Box(){}

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void remove(){ item = null;}

    public static void main(String[] args) {

        Box<Integer> box1 = new Box<>();
        box1.setItem(15);
        System.out.println(box1.getItem());
        box1.setItem(23);
        System.out.println(box1.getItem());
        box1.remove();
        System.out.println(box1.getItem());

        Box<String> stringBox = new Box<>();
        stringBox.setItem("15");
        System.out.println(stringBox.getItem());
        stringBox.setItem("23");
        System.out.println(stringBox.getItem());
        stringBox.remove();
        System.out.println(stringBox.getItem());



    }
}
