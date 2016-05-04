package lesson4.theme2;

import java.util.Comparator;

public class ComparatorZAString implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2){

        String s1 = (String) o1;
        String s2 = (String) o2;

        int res = o1.toString().compareTo(o2.toString());
        if(res < 0){
            return 1;
        } else if(res > 0){
            return -1;
        }
        return 0;
    }
}
