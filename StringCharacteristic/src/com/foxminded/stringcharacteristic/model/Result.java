package com.foxminded.stringcharacteristic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by prulov on 02.01.2017.
 */
public class Result {
    private char letters[];
    private int numbers[];

    public boolean printResult(String prober) {
        boolean isExit = false;
        if ("exit".equals(prober)) {
            isExit = true;
        } else {
            letters = findUniqueStringsCharacters(prober);
            numbers = findNumbersOfEachCharacter(prober, letters);
            StringBuilder resultBuilder = new StringBuilder();
            for (int i = 0; i < letters.length; i++) {
                resultBuilder.append("\"" + letters[i] + "\" - " + numbers[i] + "\n");
            }
            System.out.println(resultBuilder.toString());
        }
        return isExit;
    }

    public char[] findUniqueStringsCharacters(String str) {
        char literals[] = str.toCharArray();
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < literals.length; i++) {
            uniqueChars.add(literals[i]);
        }
        char[] uniqueCharacters = new char[uniqueChars.size()];
        int j = 0;
        for (Character character : uniqueChars) {
            uniqueCharacters[j] = character;
            j++;
        }
        return uniqueCharacters;
    }

    public int[] findNumbersOfEachCharacter(String str, char chars[]) {
        char literals[] = str.toCharArray();
        int numbers[] = new int[chars.length];
        for (int i = 0; i < numbers.length; i++) {
            int counter = 0;
            char letter = chars[i];
            for (int j = 0; j < literals.length; j++) {
                if (letter == literals[j]) {
                    counter++;
                }
            }
            numbers[i] = counter;
        }
        return numbers;
    }
}
