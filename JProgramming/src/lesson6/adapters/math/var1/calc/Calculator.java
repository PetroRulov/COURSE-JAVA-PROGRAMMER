package lesson6.adapters.math.var1.calc;

import lesson6.adapters.math.Arithmetika;

public class Calculator {

    public int summa(int a, int b) {

        //return a + b;
        return Arithmetika.summa(new int[]{a, b});
    }

    public static int multiply(int a, int b) {

        //return a * b;
        return Arithmetika.multiply(a, b);
    }

}
