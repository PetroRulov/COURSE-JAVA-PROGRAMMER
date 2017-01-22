package com.foxminded.anagrams;

import com.foxminded.anagrams.model.Converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        boolean isExit = false;
        String phrase = null;

        while (!isExit) {
            try {
                phrase = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!phrase.equals("exit")) {
                Converter converter = new Converter();
                converter.printAnagram(phrase);
                System.out.println();
            } else {
                isExit = phrase.equals("exit");
            }
        }

    }

}