package com.foxminded.integerdivision;

import com.foxminded.integerdivision.model.LongDivision;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isExit = false;
        LongDivision division = new LongDivision();
        division.setSearchPeriod(10);

//        while (!isExit) {
//            String dividend = "", diviser = "";
//            try {
//                dividend = reader.readLine();
//                diviser = reader.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            isExit = division.printRESULT(dividend, diviser);
//        }
//        if (reader != null) {
//            try {
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        //System.out.println(division.receiveQuotient(1000, 3));

        String c = division.calculateAfterPointIntermediateDividend(56, 135);
        System.out.print("c = " + c);


    }
}