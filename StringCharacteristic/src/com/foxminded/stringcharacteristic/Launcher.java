package com.foxminded.stringcharacteristic;

import com.foxminded.stringcharacteristic.model.Result;
import com.foxminded.stringcharacteristic.model.ResultsHolder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Launcher {

    public static void main(String[] args) {
        boolean isExit = false;
        String prober = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ResultsHolder resultsHolder = new ResultsHolder();

        while(!isExit){
            try {
                prober = reader.readLine();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            Result result = new Result();

            if (resultsHolder.getResultsMap().containsKey(prober)) {
                System.out.println("!!!APP ALREADY HAS RESULT FOR THIS STRING VALUE!!!");
                isExit = resultsHolder.getResultsMap().get(prober).printResult(prober);
            } else {
                isExit = result.printResult(prober);
                resultsHolder.putResultIntoResultsMap(prober, result);
            }
        }

        if (reader != null) {
            try {
                reader.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
