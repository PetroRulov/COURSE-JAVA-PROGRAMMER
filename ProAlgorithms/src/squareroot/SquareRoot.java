package squareroot;

import java.util.Scanner;

public class SquareRoot {

    public static void main(String[] args) {

        System.out.print("Input the number: \t");
        double num = new Scanner(System.in).nextDouble();
        System.out.println("result = " + squareRoot(num));
    }

    private static double squareRoot(double num) {
        double aux, res = 1.0;
        do {
            aux = res;
            res = (aux + num / aux) / 2.0;
        } while ( Math.abs(res - aux) >= 2.0);
        if ((int) res * (int) res == (int) num) return 1.0 * (int) res;
        return res;
    }
}

