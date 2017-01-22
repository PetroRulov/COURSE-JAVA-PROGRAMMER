package com.foxminded.anagrams.model;

public class Converter {

    public String convert(String str) {
        char chars[] = str.toCharArray();
        char result[] = new char[chars.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (!Character.isLetter(chars[i])) {
                result[i] = chars[i];
            } else {
                sb.append(String.valueOf(chars[i]));
            }
        }
        String word = sb.toString();
        char[] inversedWord = invert(word);
        int letterCounter = 0;
        for (int j = 0; j < result.length; j++) {
            if (result[j] == '\u0000') {
                result[j] = inversedWord[letterCounter];
                letterCounter++;
            }
        }
        return new String(result);
    }

    public char[] invert(String str) {
        char[] inversedWord = str.toCharArray();
        char tmp;
        for (int i = 0; i < inversedWord.length / 2; i++) {
            tmp = inversedWord[i];
            inversedWord[i] = inversedWord[inversedWord.length - 1 - i];
            inversedWord[inversedWord.length - 1 - i] = tmp;
        }
        return inversedWord;
    }

    public void printAnagram(String phrase) {
        String anagram[] = phrase.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String string : anagram) {
            sb.append(convert(string) + " ");
        }
        System.out.print(sb.toString());
    }

}