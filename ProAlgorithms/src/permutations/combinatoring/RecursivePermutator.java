package permutations.combinatoring;

import java.io.*;

public class RecursivePermutator {

    public static void main(String[] args) throws FileNotFoundException {

//        try (PrintStream out = new PrintStream(new FileOutputStream("D://TEXT_FILES//testCombine.txt", true)))
//        {
//            System.setOut(out);
//            int a = 16;
//            int b = 12;
//            int c = 74;
//            int d = 1;
//            String str = "abcd";
//            permuteString("", str, a, b, c, d);
//        } finally {
//            System.setIn(System.in);
//            System.out.println("Thanks!!!");
//        }
//        System.out.println("MMMM!!!");

        int a = 16;
        int b = 12;
        int c = 74;
        int d = 1;
        String str = "abcd";
        permuteString("", str, a, b, c, d);

//        System.out.println( getFactorial(str.length()));

        //create a file first
//        PrintWriter outputfile = new PrintWriter("D://TEXT_FILES//testCombine.txt");
//        PrintStream printStream = new PrintStream(new FileOutputStream("D://TEXT_FILES//testCombine.txt", true));
//        String message = "Your output should be here!";
//        System.out.println(message);
//        outputfile.print(message);
//        outputfile.close();
//        printStream.print(message);
//        printStream.close();

        //permuteStringBuilderLogger("", str, a, b, c, d);

    }

    public static void permuteString(String beginningString, String endingString, int a, int b, int c, int d) {
        String novus = "";
        Logger logger = new Logger();
        if (endingString.length() <= 1) {
            novus = beginningString + endingString;
            char[] res = novus.toCharArray();
            for (char re : res) {
                if (re == 'a') {
                    //System.out.print(a + " ");
                    logger.log(a + " ");
                } else if (re == 'b') {
                    //System.out.print(b + " ");
                    logger.log(b + " ");
                } else if (re == 'c') {
                    //System.out.print(c + " ");
                    logger.log(c + " ");
                } else {
                    //System.out.print(d + " ");
                    logger.log(d + " ");
                }
            }
            //System.out.println();
            logger.log(System.lineSeparator());
        } else {
            for (int i = 0; i < endingString.length(); i++) {
                try {
                    String newString = endingString.substring(0, i) + endingString.substring(i + 1);

                    permuteString(beginningString + endingString.charAt(i), newString, a, b, c, d);
                } catch (StringIndexOutOfBoundsException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public static String permuteStringBuilderLogger(String beginningString, String endingString, int a, int b, int c, int d) {
        String novus = "";
        StringBuilder sb = new StringBuilder();
        Logger logger = new Logger();
        if (endingString.length() <= 1) {
            novus = beginningString + endingString;
            char[] res = novus.toCharArray();
            for (char re : res) {
                if (re == 'a') {
                    sb.append(a + " ");
                } else if (re == 'b') {
                    sb.append(b + " ");
                } else if (re == 'c') {
                    sb.append(c + " ");
                } else {
                    sb.append(d + " ");
                }
            }
            logger.log(sb.toString() + System.lineSeparator());
        } else {
            for (int i = 0; i < endingString.length(); i++) {
                try {
                    String newString = endingString.substring(0, i) + endingString.substring(i + 1);

                    permuteStringBuilderLogger(beginningString + endingString.charAt(i), newString, a, b, c, d);
                } catch (StringIndexOutOfBoundsException exception) {
                    exception.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    private static int getNumberOfCombinations(String str) {
        int n = str.length(), i = n;
        while (n != 1) {
            n--;
            i*= n;
        }
        return i;
    }

    private static int getFactorial(int n) {
        int i = n;
        while (n != 1) {
            n--;
            i*= n;
        }
        return i;
    }

}
