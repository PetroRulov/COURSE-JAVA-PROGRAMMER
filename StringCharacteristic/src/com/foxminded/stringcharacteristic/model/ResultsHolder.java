package com.foxminded.stringcharacteristic.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prulov on 03.01.2017.
 */
public class ResultsHolder {
    private Map<String, Result> resultsMap = new HashMap<>();

    public Map<String, Result> getResultsMap() {
        return resultsMap;
    }

    public void putResultIntoResultsMap(String str, Result result) {
        resultsMap.put(str, result);
    }

    public boolean checkIfExit(String str) {
        boolean isExit = false;
        if ("exit".equals(str)) {
            isExit = true;
        }
        return isExit;
    }
}
