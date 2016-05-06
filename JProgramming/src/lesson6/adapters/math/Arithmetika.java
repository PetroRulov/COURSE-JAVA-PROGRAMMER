package lesson6.adapters.math;

public class Arithmetika {

    public static int summa(int[] numbers) {
        int summa = 0;
        for (int i : numbers) {
            summa += i;
        }
        System.out.println("Arithmetics");
        return summa;
    }

    public static int multiply(int number, int multiplier) {
        int result = 0;
        for (int i = 0; i < multiplier; i++) {
            result *= multiplier;
        }
        return result;
    }
}

