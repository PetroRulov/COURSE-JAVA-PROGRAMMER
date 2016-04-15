package lesson4theme5.myarrlist;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArrayList implements Iterable<Object> {

    private int counter;
    private Object list[];

    public SimpleArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            this.list = new Object[initialCapacity];
            this.counter = initialCapacity;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public int getCount() {
        return counter;
    }

    public void setCount(int count) {
        this.counter = count;
    }

    public Object[] getList() {
        return list;
    }

    public void setList(Object[] list) {
        this.list = list;
    }

    public void addFirst(Object obj){

        checkCapasity();
        Object[] newCapArr = new Object[(list.length + 1)];
        System.arraycopy(list, 0, newCapArr, 1, list.length);
        newCapArr[0] = obj;
        list = newCapArr;
        counter++;
        trimToSize(list);
    }

    public void addLast(Object obj){

        checkCapasity();
        list[counter++] = obj;
    }

    public void addAfter(Object prev, Object obj){

        checkCapasity();
        int i = 0;
        for (; i < counter; i++){
            if (list[i].equals(prev)) {
                System.arraycopy(list, (i+1), list, (i+2), counter-i-1);
                list[i+1] = obj;
                counter++;
                trimToSize(list);
                return;
            }
        }
        if(i == counter){
            System.out.println("There is no such Object as " + prev.toString() + " in this ArrayList!");
        }
    }

    // auxiliary method
    private void checkCapasity(){

        if(counter == list.length){
            Object[] increasedCapArr = new Object[(list.length * 3) / 2 + 1];
            System.arraycopy(list, 0, increasedCapArr, 0, list.length);
            list = increasedCapArr;
        }
    }

    public void removeObject(Object obj) {

        int i = 0;
        for (; i < counter; i++) {
            if (list[i].equals(obj)) {
                System.arraycopy(list, i, list, i-1, counter-i);
                list[--counter] = null;
                return;
            }
        }
        if(i == counter){
            System.out.println("There is no such Object as " + obj.toString() + " in this ArrayList!");
        }
    }

    public void printList(){

        System.out.println(Arrays.toString(list));
    }

    public void trimToSize(Object objects[]){

        int index = receiveCount();
        Object[] newCapArr = new Object[index];
        System.arraycopy(objects, 0, newCapArr, 0, index);
        list = newCapArr;
    }

    private int receiveCount(){

        int index = 0;
        for(int i = 0; i < list.length; i++){
            if(list[i] == null){
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public Iterator<Object> iterator() {
        return new SALIterator();
    }
}


    class SALIterator implements Iterator<Object> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }



