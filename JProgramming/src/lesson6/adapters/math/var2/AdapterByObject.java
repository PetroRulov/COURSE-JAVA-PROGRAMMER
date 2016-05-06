package lesson6.adapters.math.var2;

import lesson6.adapters.math.Arithmetika;
import lesson6.adapters.math.var2.calc.Calculator;

public class AdapterByObject implements Calculator {

    private Arithmetika arithmetic;

    public AdapterByObject(){

        arithmetic = new Arithmetika();
    }


    @Override
    public int summa(int a, int b) {

        return arithmetic.summa(new int[]{a, b});
    }

    @Override
    public int multiply(int a, int b) {

        return arithmetic.multiply(a, b);
    }
}
