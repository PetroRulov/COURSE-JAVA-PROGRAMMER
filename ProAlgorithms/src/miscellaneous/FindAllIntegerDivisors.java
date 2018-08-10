package miscellaneous;

import java.util.ArrayList;
import java.util.Scanner;

public class FindAllIntegerDivisors {

    public static void main(String[] args) {

        String number = null;
        Scanner scan = new Scanner(System.in);

        while (!"exit".equals(number)) {
            System.out.println("Input a value of number not more than 999'999'999'999'999'999: ");
            number = scan.next();
            ArrayList<Long> results = null;
            long a = 0;
            if (!inputIsANumber(number)) {
                if ("exit".equals(number))
                {
                    System.out.println("You have input an \"exit\"! The program finishes it's running!");
                    System.exit(0);
                }
                System.out.println("Error!!! You had input not a number!!!");
            } else {
                if (number.length() > 18) {
                    System.out.println("Error!!! You input to much value");
                } else {
                    a = Long.parseLong(number);
                    results = findAllID(a);
                    for (Long div: results) {
                        System.out.print(div + ", ");
                    }
                    System.out.println();
                }
            }
        }
        System.out.println("You have input an \"exit\"! The program finishes it's running!");
    }

    static ArrayList<Long> findAllID(long num) {
        ArrayList<Long> results = new ArrayList<>();
        long modulo = 0;
        for (long i = 1; i < num / 2 + 1; i++) {
            modulo = num % i;
            if(modulo == 0) {
                results.add(i);
            }
        }
        return results;
    }

    static boolean inputIsANumber(String line){
        char ch;
        char arr[] = line.toCharArray();
        for (int i = 0; i < arr.length; i++){
            ch = arr[i];
            if (!Character.isDigit(ch))
                return false;
        }
        return true;
    }

}
