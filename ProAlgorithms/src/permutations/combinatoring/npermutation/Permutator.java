package permutations.combinatoring.npermutation;

import java.util.ArrayList;
import java.util.Collection;

public class Permutator {

    public boolean inputInt(String str) {
        if (str.length() == 0) {
            return false;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') || (!Character.isDigit(c) && c != '-') || c == '-' && chars.length == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean inputExit(String str) {
        if ("exit".equals(str) || "Exit".equals(str) || "ex".equals(str)) {
            return true;
        }
        return false;
    }

    public int recieveNumber(String str) {
        int result = Math.abs(Integer.parseInt(str));
        if(result < 2) {
            System.out.println("The number of components is - 2.");
            return 2;
        }
        System.out.println("The number of components is " + result + ".");
        return result;
    }

    public int[] formIntArray(String[] strArr) {
        int[] result = new int[strArr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public boolean nextSet(int[] arr) {
        int n = arr.length;
        int j = n - 2;
        while (j != -1 && arr[j] >= arr[j + 1]) {
            j--;
            if (j == -1) {
                return false;
            }
        }
        int k = n - 1;
        while (arr[j] >= arr[k]) {
            k--;
        }
        swap(arr, j, k);
        int l = j + 1, r = n - 1;
        while (l < r) {
            swap(arr, l++, r--);
        }
        return true;
    }

    private void swap(int[] arr, int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    public ArrayList<String> formList(int[] arr, String[] strArr) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            result.add(strArr[arr[i] - 1]);
        }
        return result;
    }

    public void displayTheResultOfPermutations(Collection<ArrayList<String>> resultSet) {
        System.out.println();
        System.out.println("Here is the list of permutations: ");
        int counter = 1;
        System.out.printf("%-1s%-20s%n", "#  ", "| Permutations ");
        System.out.println("---|-------------");
        for (ArrayList<String> arr : resultSet) {
            if (counter < 10) {
                System.out.print(counter + "  |  ");
            } else if (counter < 100) {
                System.out.print(counter + " |  ");
            } else {
                System.out.print(counter + "|  ");
            }
            for (String str : arr) {
                System.out.print(str + " ");
            }
            counter++;
            System.out.println();
        }
        System.out.println();
    }

    public boolean haveRepetitions(String[] strArr) {
        boolean result = false;
        for (int i = strArr.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if (strArr[i].equals(strArr[j])) { // есть повторение
                    result = true;
                    break;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }
}
