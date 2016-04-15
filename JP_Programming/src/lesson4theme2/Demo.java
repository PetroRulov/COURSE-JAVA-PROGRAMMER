package lesson4theme2;

import java.util.*;
import java.util.Collections;

public class Demo {

    public static void main(String[] args) {

        LinkedList<String> llData = new LinkedList<String>();
        llData.add("Astarta");//9
        llData.add("Ganza");//5
        llData.add("Priority");//3
        llData.add("Ypsilon");//0
        llData.add("Falcon");//6
        llData.add("Util");//1
        llData.add("Sebring");//2
        llData.add("Clonea");//7
        llData.add("Bastard");//8
        llData.add("Marine");//4

        printList(llData);
        System.out.println();
//        ComparatorZAString a = new ComparatorZAString();
//        Collections.sort(llData, a);
//        printList(llData);

        Collections.sort(llData, new Comparator<Object>() {

            @Override
            public int compare(Object o1, Object o2) {
                String s1 = (String) o1;
                String s2 = (String) o2;

                int res = o1.toString().compareTo(o2.toString());
                if (res < 0) {
                    return 1;
                } else if (res > 0) {
                    return -1;
                }
                return 0;
            }
        });

        printList(llData);

    }

    public static void printList(LinkedList<String> llData) {

        System.out.print("{ ");
        int index = 0;
        for(String str : llData){
            System.out.print(index + "-" + str);
            index++;
            if(index < llData.size()){
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }

}
