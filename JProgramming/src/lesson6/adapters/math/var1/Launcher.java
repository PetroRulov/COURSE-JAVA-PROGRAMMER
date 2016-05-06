package lesson6.adapters.math.var1;

import java.util.Random;
import lesson6.adapters.math.var1.calc.*;

public class Launcher {

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        Operations o = new Operations();
        o.setCalc(calc);

        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.println(o.createSummaryReport(r.nextInt(100)));
        }

    }
}
