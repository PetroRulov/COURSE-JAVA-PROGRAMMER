package mergearrays;

public class MergeArrays {

    public static void main(String[] args) {

        String[] a = new String[]{"Вася", "Петя", "Маша", "Николай", "Егор", "Марина", "Елена", "Ольга", "Наталья", "Максим"};
        String[] b = new String[]{"2", "3", "0", "4", "5", "13", "6"};
        String[] c = mergeArrays(a, b);
        for (String s: c) {
            System.out.print("\"" + s + "\" ");
        }
        System.out.println();

    }

    static String[] mergeArrays(String[] first, String[] second) {
        String[] result = new String[first.length + second.length];
        int l1 = first.length, l2 = second.length, aux = 0;
        int k = 0, i = 0;
        if (l1 >= l2) {
            for (; k < l2 * 2; i++, k+=2) {
                result[k] = first[i];
                result[k+1] = second[i];
            }
            for(; k < result.length; i++, k++) {
                result[k] = first[i];
            }
        } else {
            for (; k < l1 * 2; i++, k+=2) {
                result[k] = first[i];
                result[k+1] = second[i];
            }
            for(; k < result.length; i++, k++) {
                result[k] = second[i];
            }
        }
        return result;
    }
}
