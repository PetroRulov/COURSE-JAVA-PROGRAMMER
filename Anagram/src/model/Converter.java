package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prulov on 05.12.2016.
 */
public class Converter {

    private final static String ALPHABET = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz ";
    private String phrase;
    private Anagram anagram;

    public Converter(String phrase) {
        this.phrase = phrase;
        anagram = setAnagram();
    }

    public ArrayList<String> divideIntoWords(String string) {
        int k = 0;
        String str = string;
        ArrayList<String> list = new ArrayList<>();
        String result = null;
        while(str.contains(" ")) {
            k = str.indexOf(" ");
            result = str.substring(0, k);
            list.add(result);
            str = str.substring(k + 1);
        }
        list.add(str);
        return list;
    }

    public char[] charArrFromString(String str) {
        char letters[] = null;
        if (str != null) letters = str.toCharArray();
        return letters;
    }

    public String convert(String str) {
        char chars[] = charArrFromString(str);
        char result[] = new char[chars.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (!isLetter(chars[i])) {
                result[i] = chars[i];
            } else {
                sb.append(String.valueOf(chars[i]));
            }
        }
        String word = sb.toString();
        char[] inversed = invert(word);
        int a = 0;
        for (int j = 0; j < result.length; j++) {
            if (result[j] == '\u0000') {
                result[j] = inversed[a];
                a++;
            }
        }
        return new String(result);
    }

    public List<String> getAnagramma(){
        List<String> anagramma = new ArrayList<>();
        for (String str : divideIntoWords(phrase)) {
            anagramma.add(convert(str));
        }
        return anagramma;
    }

    public Anagram setAnagram() {
        return new Anagram(getAnagramma());
    }

    public boolean isLetter(char ch) {
        if (ALPHABET.contains(String.valueOf(ch))) {
            return true;
        }
        return false;
    }

    public char[] invert(String str) {
        char[] inversed = str.toCharArray();
        char tmp;
        for (int i = 0; i < inversed.length / 2; i++) {
            tmp = inversed[i];
            inversed[i] = inversed[inversed.length - 1 - i];
            inversed[inversed.length - 1 - i] = tmp;
        }
        return inversed;
    }

    public String anagramToString() {
        StringBuilder sb = new StringBuilder();
        for (String s : anagram.getAnagramma()) {
            sb.append(s + " ");
        }
        String anagramma = sb.toString();
        return anagramma.substring(0, anagramma.length() - 1);
    }

}
