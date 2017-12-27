package permutations;

import java.util.ArrayList;
import java.util.Arrays;

public class StrArrOrListsEquality {

    public static void main(String[] args) {

        String[] a = new String[]{"A", "B", "C"};
        String[] b = new String[]{"A", "B", "C"};
        System.out.println(a.equals(b) + " - String arrays with the same strings are not equal!!!"); // false
        System.out.println("Why false? Because method equals() for arrays is not @overrided and compares references, not values (==)");
        System.out.println("Do not use String arrays if you need unique list of strings!");
        System.out.println();

        ArrayList<String> aA = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<String> bB = new ArrayList<>(Arrays.asList("A", "B", "C"));
        System.out.println(aA.equals(bB) + " - ArrayLists with the same strings are equal!!!"); // !!! TRUE !!!
        System.out.println("If you need unique list of strings - use ArrayLists with strings!");
        System.out.println("Because method equals for ArrayLists compares values (by hashCode), not references !(==)");
        System.out.println();

        System.out.println(a.hashCode() == b.hashCode()); // false
        System.out.println("hashCodes of String arrays are different!");
        System.out.println();

        System.out.println(aA.hashCode() == bB.hashCode()); // !!! TRUE !!!
        System.out.println(aA.hashCode() + " - hashCodes of ArrayLists with the same context are equal! - " + bB.hashCode());
    }
}
