package miscellaneous;

import java.util.ArrayList;
import java.util.Scanner;

public class FindAllIntegerDivisors {

    public static void main(String[] args) {

        String number = null;
        Scanner scan = new Scanner(System.in);
        long num = 0;
        while (!"exit".equals(number)) {
            number = scan.nextLine();
            if (inputIsANumber(number)) {
                num = Long.parseLong(number);
                for (long l:findAllID(num)) {
                    System.out.print(l+", ");
                }
                System.out.println();
            } else {
                System.out.println("Not a number! Try again, please!");
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
        if (line.matches("[-+]?\\d+"))
            return true;
        return false;
    }

}
