package lesson6.adapters.math.var2;

import java.util.Random;
import lesson6.adapters.math.var2.calc.Calculator;
import lesson6.adapters.math.var2.calc.DefaultCalculator;

public class Launcher {

    public static void main(String[] args) {
        Calculator calc = new AdapterByObject();

        Operations o = new Operations();
        o.setCalc(calc);

        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.println(o.createSummaryReport(r.nextInt(100)));
        }
    }
}

