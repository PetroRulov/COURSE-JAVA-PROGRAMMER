package lesson8.unicode;

import java.util.Arrays;

/**
 * Created by prulov on 04.07.2016.
 */
public class Characters {

    public static void main(String[] args) {

        char copyright = 169;
        System.out.println(copyright);
        System.out.println();

        copyright = '\u00A9';
        System.out.println(copyright);
        System.out.println();

        printCodePointInfo(100);
        printCodePointInfo(500);
        printCodePointInfo(1000);
        printCodePointInfo(10000);
        printCodePointInfo(50000);
        printCodePointInfo(65600);
        printCodePointInfo(90000);
    }

    private static void printCodePointInfo(int codePoint) {

        char chars[] = Character.toChars(codePoint);
        String str = new String(chars);

        System.out.println("Code Point: " + codePoint);
        System.out.println("Char Array: " + Arrays.toString(chars));
        System.out.println("Res String: " + str);
        System.out.println("String len: " + str.length());
        System.out.println("Code count: " + str.codePointCount(0, str.length()));
        System.out.println();
    }
}
