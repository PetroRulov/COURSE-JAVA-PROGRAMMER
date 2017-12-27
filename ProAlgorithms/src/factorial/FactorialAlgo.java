package factorial;

import java.math.BigInteger;

public class FactorialAlgo {

    public static void main(String[] args) {
        int a = 10;
        System.out.println(factorialRecursive(a));
        System.out.println(findFactorial(a));
    }

    public static BigInteger factorialRecursive(int num) {
        return (num <= 1) ? BigInteger.ONE :
                new BigInteger(String.valueOf(num)).multiply(factorialRecursive(num - 1));
    }

    public static BigInteger findFactorial(int num)
    {
        BigInteger result = BigInteger.ONE;
        while(num > 0)
        {
            result = result.multiply(new BigInteger(String.valueOf(num)));
            num--;
        }
        return result;
    }
}