package fibonacci;

import java.util.Scanner;

public class FibonacciSeries {

    public static void main(String[] args) {
        System.out.print("Input a number:\t");
        Scanner scanner = new Scanner(System.in);
        int number;
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
            System.out.println();
            System.out.println("1. The value of " + number + "-number of Fibonacci's series is = " +
                    + findFibonacciValue(number));
            System.out.println("2. The value of " + number + "-number of Fibonacci's series is = " +
                    + findFibonacciByRecursion(number));
        } else {
            System.out.println("not a number");
            System.exit(0);
        }
    }

    static long findFibonacciValue(int num) {
        if(num == 0) return 0;
        if(num == 1 || num == 2) return 1;
        long a = 0, b = 1, result = 0;
        for (int i = 2; i <= num; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    static long findFibonacciByRecursion(int num) {
        if(num == 0) return 0;
        if(num == 1 || num == 2) return 1;
        return findFibonacciByRecursion(num - 1) + findFibonacciByRecursion(num - 2);
    }
}
