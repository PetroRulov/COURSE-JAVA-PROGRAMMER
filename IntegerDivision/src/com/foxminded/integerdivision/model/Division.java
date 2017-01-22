package com.foxminded.integerdivision.model;

import java.util.ArrayList;
import java.util.List;

public class Division {

    public boolean isIntNumber(String str) {
        if (str.length() == 0) {
            return false;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') || (!Character.isDigit(c) && c != '-') || c == '-' && chars.length == 1) {
                return false;
            }
        }
        return true;
    }

    char[] receiveDividendsDigits(int dividend) {
        return String.valueOf(Math.abs(dividend)).toCharArray();
    }

    int calculateMinuend(int divident, int diviser) {
        int minuend = 0;
        char dividendsDigits[] = receiveDividendsDigits(Math.abs(divident));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dividendsDigits.length; i++) {
            if (minuend < Math.abs(diviser)) {
                sb.append(String.valueOf(dividendsDigits[i]));
                minuend = Integer.parseInt(sb.toString());
            }
        }
        return minuend;
    }

    List<Integer> computeSubtrahends(int dividend, int diviser) {
        char quotientDigits[] = String.valueOf(Math.abs(dividend/diviser)).toCharArray();
        List<Integer> subtrahendsList = new ArrayList<>();
        for (int i = 0; i < quotientDigits.length; i++) {
            if (!String.valueOf(quotientDigits[i]).equals("0")) {
                subtrahendsList.add(Integer.parseInt(String.valueOf(quotientDigits[i])) * Math.abs(diviser));
            }
        }
        return subtrahendsList;
    }

    String calculateIntermediateDividend(int dividend, int diviser) {
        String stringDividend = new String(receiveDividendsDigits(dividend));
        String minuend = String.valueOf(calculateMinuend(dividend, diviser));
        String newDividendsValue = stringDividend.replaceFirst(minuend, "");
        if (newDividendsValue.equals("")) {
            return "0";
        }
        return newDividendsValue;
    }

    String composeSecondLineIndent(int number, int subtrahend) {
        int counter = String.valueOf(Math.abs(number)).length() - String.valueOf(Math.abs(subtrahend)).length();
        StringBuilder indentComposer = new StringBuilder();
        if (counter > 0) {
            for (int i = 0; i < counter; i++) {
                indentComposer.append(" ");
            }
        }
        return indentComposer.toString() + "|";
    }

    public boolean printResult(String[] arguments) {
        boolean isExit = false;
        if ((isIntNumber(arguments[0]) && isIntNumber(arguments[1]))
                && (!"exit".equals(arguments[0]) && !"exit".equals(arguments[1]))) {
            int dividend = Integer.parseInt(arguments[0]), diviser = Integer.parseInt(arguments[1]);
            System.out.println("_" + Math.abs(dividend) + "|" + Math.abs(diviser));
            if (Math.abs(dividend) < Math.abs(diviser)) {
                System.out.println(" " + dividend + "|" + "0");
            } else if (Math.abs(dividend) == Math.abs(diviser)) {
                System.out.println(" " + dividend + "|" + "1");
                int linesLength = String.valueOf(dividend).length();
                StringBuilder indent = new StringBuilder();
                for (int j = 0; j < linesLength; j++) {
                    indent.append(" ");
                }
                System.out.println(indent.toString() + "0");
            } else {
                composeLongDivisionView(dividend, diviser);
            }
        } else {
            if ("exit".equals(arguments[0]) || "exit".equals(arguments[1])) {
                isExit = true;
            } else {
                if (!isIntNumber(arguments[0])) {
                    System.out.println("Dividend has invalid value! Try again, please!");
                } else {
                    System.out.println("Diviser has invalid value! Try again, please!");
                }
            }
        }
        return isExit;
    }

    void composeLongDivisionView(int dividend, int diviser) {
        int modulo = dividend - (dividend/diviser * diviser);
        List<Integer> subtrahendsList = computeSubtrahends(dividend, diviser);
        String currentDivident = "";
        int minuend = 0, delta = 0;
        System.out.println(" " + Math.abs(subtrahendsList.get(0)) + composeSecondLineIndent(dividend, subtrahendsList.get(0)) + dividend / diviser);
        String lastLineLength = "";
        StringBuilder indent = new StringBuilder();
        if (subtrahendsList.size() > 1) {
            for (int i = 0; i < subtrahendsList.size(); i++) {
                minuend = calculateMinuend(dividend, diviser);
                delta = minuend - Math.abs(subtrahendsList.get(i));
                if (delta != 0) {
                    currentDivident = String.valueOf(delta)
                            .concat(calculateIntermediateDividend(dividend, diviser));
                } else {
                    currentDivident = calculateIntermediateDividend(dividend, diviser);
                }
                dividend = Integer.parseInt(currentDivident);
                if (i != 0) {
                    indent.append(" ");
                    System.out.println(indent.toString() + "_" + minuend);
                    lastLineLength = indent.toString() + " " + Math.abs(subtrahendsList.get(i));
                    System.out.println(indent.toString() + " " + Math.abs(subtrahendsList.get(i)));
                }
            }
            int length = lastLineLength.length() - String.valueOf(delta).length();
            StringBuilder lastLineIdents = new StringBuilder();
            for (int k = 0; k < length; k++) {
                lastLineIdents.append(" ");
            }
            System.out.println(lastLineIdents.toString() + modulo);
        } else {
            StringBuilder moduloIdents = new StringBuilder();
            for (int k = 0; k < String.valueOf(Math.abs(dividend)).length(); k++) {
                moduloIdents.append(" ");
            }
            System.out.println(moduloIdents.toString() + modulo);
        }
    }
}
