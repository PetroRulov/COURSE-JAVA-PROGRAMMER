package com.foxminded.integerdivision;

import com.foxminded.integerdivision.model.Division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isExit = false;
        Division division = new Division();

        while (!isExit) {
            String dividend = "", diviser = "";
            String arguments[] = null;
            try {
                dividend = reader.readLine();
                diviser = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            arguments = new String[] { dividend, diviser };
            isExit = division.printResult(arguments);
        }
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}