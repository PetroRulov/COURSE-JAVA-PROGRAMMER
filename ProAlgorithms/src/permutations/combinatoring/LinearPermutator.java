package permutations.combinatoring;

/**
 * Created by prulov on 20.06.2017.
 */
public class LinearPermutator {

    public static void main(String[] args) {
        int a = 45;
        int b = 12;
        int c = 74;
        int d = 365;
        //int e = 24;
        String str = "abcd";
        String result[] = permutator(str);
        writeInFile(result, a, b, c, d);
    }

    public static String[] permutator(String string) {
        // формируем массив чисел - факториалов чисел от 0 до ... числа символов строки - length()
        int [] factorials = new int[string.length() + 1];
        factorials[0] = 1;
        for (int i = 1; i <= string.length(); i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        // создаем массив строк с длиной равной элементу массива factorials с индексом, равным длине строки-аргумента
        String result[] = new String[factorials[string.length()]];
        for (int i = 0; i < factorials[string.length()]; i++) {
            String onePermutation = "";
            String temp = string; // abcd
            int positionCode = i;
            for (int position = string.length(); position > 0 ; position--){
                int selected = positionCode / factorials[position - 1];
                onePermutation += temp.charAt(selected);
                positionCode = positionCode % factorials[position - 1];
                temp = temp.substring(0, selected) + temp.substring(selected + 1);
            }
            result[i] = onePermutation;
        }
        return result;
    }

    public static void writeInFile(String[] res, int a, int b, int c, int d) {
        Logger logger = new Logger();
        for (String s : res) {
            char[] combination = s.toCharArray();
            for (char re : combination) {
                if (re == 'a') {
                    logger.log(a + " ");
                } else if (re == 'b') {
                    logger.log(b + " ");
                } else if (re == 'c') {
                    logger.log(c + " ");
                } else {
                    logger.log(d + " ");
                }
            }
            logger.log(System.lineSeparator());
        }
    }

}
