package com.foxminded.integerdivision.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongDivision {

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

    void composeLongDivisionView(int dividend, int diviser) {
        int modulo = dividend - (dividend/diviser * diviser);
        List<Integer> subtrahendsList = computeSubtrahends(dividend, diviser);
        String currentDivident = "";
        int minuend = 0, delta = 0;
        System.out.println(" " + Math.abs(subtrahendsList.get(0)) + composeSecondLineIndent(dividend, subtrahendsList.get(0)) + dividend/diviser);
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

    public static String receiveQuotient(int dividend, int diviser) {
        String result = "";
        if ((dividend < 0) ^ (diviser < 0)) {
            result += "-";
        }
        int integerQuotient = Math.abs(dividend) / Math.abs(diviser);
        result += String.valueOf(integerQuotient);
        int modulo = (Math.abs(dividend) % Math.abs(diviser)) * 10;
        if (modulo == 0) {
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        result += ".";

        String finish = "";
        StringBuilder resultBuilder = new StringBuilder(result);
        while (/*modulo != 0 ||*/ finish.length() < 11) {
            if (map.containsKey(modulo)) {
                int beg = map.get(modulo);
                String part1 = resultBuilder.toString().substring(0, beg);
                String part2 = resultBuilder.toString().substring(beg, resultBuilder.toString().length());
                if (!"0".equals(part2)) {
                    result = part1 + "(" + part2 + ")";
                } else {
                    result = part1;
                }
                return result;
            }
            map.put(modulo, resultBuilder.toString().length());
            integerQuotient = modulo / Math.abs(diviser);
            resultBuilder.append(String.valueOf(integerQuotient));
            modulo = (modulo % diviser) * 10;
            int dotIndex = resultBuilder.toString().indexOf(".");
            finish = resultBuilder.toString().substring(dotIndex + 1);
        }
        return resultBuilder.toString();
    }

    public boolean printRESULT(String dvdnd, String dvsr) {
        boolean isExit = false;

        if ((isIntNumber(dvdnd) && isIntNumber(dvsr)) && (!"0".equals(dvsr))
                && (!"exit".equals(dvdnd) && !"exit".equals(dvsr))) {
            int dividend = Integer.parseInt(dvdnd), diviser = Integer.parseInt(dvsr);
            int modulo = dividend - (dividend/diviser * diviser);
            int initialDividend = dividend;

            if (Math.abs(dividend) >= Math.abs(diviser)) {
                // first Line if dividend >= diviser
                System.out.println("_" + Math.abs(dividend) + "|" + Math.abs(diviser));
                if (Math.abs(dividend) == Math.abs(diviser)) {
                    System.out.println(" " + dividend + "|" + "1");
                    int linesLength = String.valueOf(dividend).length();
                    StringBuilder indent = new StringBuilder();
                    for (int j = 0; j < linesLength; j++) {
                        indent.append(" ");
                    }
                    System.out.println(indent.toString() + "0");
                } else {
                    if (modulo == 0) {
                        composeLongDivisionView(dividend, diviser);
                    } else {
                        composeLongDivisionViewForBigDividend(dividend, diviser, initialDividend);
                    }
                }
            } else {
                if (dividend == 0) {
                    System.out.println("_" + Math.abs(dividend) + "|" + Math.abs(diviser));
                    System.out.println(" " + Math.abs(dividend) + "|" + "0");

                } else {
                    while(Math.abs(dividend) < Math.abs(diviser)) {
                        dividend *= 10;
                    }
                    StringBuilder lessIndent = new StringBuilder();
                    for (int i = 0; i < String.valueOf(dividend).length() - String.valueOf(initialDividend).length(); i++) {
                        lessIndent.append(" ");
                    }
                    // first line if dividend < diviser
                    System.out.println("_" + Math.abs(initialDividend) + lessIndent.toString() + "|" + Math.abs(diviser));
                    composeLongDivisionViewForSmallDividend(dividend, diviser, initialDividend);
                }
            }

        } else {
            if ("exit".equals(dvdnd) || "exit".equals(dvsr)) {
                isExit = true;
            } else {
                if (!isIntNumber(dvdnd)) {
                    System.out.println("Dividend has invalid value! Try again, please!");
                } else {
                    System.out.println("Diviser has invalid value! Try again, please!");
                }
            }
        }
        return isExit;
    }

    private void composeLongDivisionViewForBigDividend(int dividend, int diviser, int initialDividend) {
        int modulo = Math.abs(dividend - (dividend/diviser * diviser));
        List<Integer> subtrahendsList = computeSubtrahends(dividend, diviser);
        String currentDivident = "";
        int minuend = 0, delta = 0;
        System.out.println(" " + Math.abs(subtrahendsList.get(0)) + composeSecondLineIndent(dividend, subtrahendsList.get(0)) +
                receiveQuotient(initialDividend, diviser));
        StringBuilder indent = new StringBuilder();
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
                System.out.println(indent.toString() + " " + Math.abs(subtrahendsList.get(i)));
            }
        }
        while (modulo < Math.abs(diviser)){
            modulo *= 10;
        }
        composeAfterPointLongDivisionView(initialDividend, modulo, diviser, indent.toString().length());
    }

    private void composeAfterPointLongDivisionView(int dividend, int moduloDividend, int diviser, int length) {
        List<Integer> subtrahendsList = computeAfterPointSubtrahends(dividend, diviser);
        String currentDivident = "";
        int minuend = 0, delta = 0;
        String lastLine = "";
        StringBuilder previousIndent = new StringBuilder();
        for (int i = 0; i < length; i++) {
            previousIndent.append(" ");
        }
        StringBuilder indent = new StringBuilder(previousIndent);
        for (int i = 0; i < subtrahendsList.size(); i++) {
            minuend = calculateAfterPointMinuend(moduloDividend, diviser);
            delta = minuend - Math.abs(subtrahendsList.get(i));
            if (delta != 0) {
                currentDivident = String.valueOf(delta).concat(calculateAfterPointIntermediateDividend(moduloDividend, diviser));
            } else {
                currentDivident = calculateAfterPointIntermediateDividend(moduloDividend, diviser);
            }
            moduloDividend = Integer.parseInt(currentDivident);
            indent.append(" ");
            System.out.println(indent.toString()+ "_" + minuend);
            lastLine = indent.toString()+ " " + Math.abs(subtrahendsList.get(i));
            System.out.println(lastLine);
        }
        int lengthLastLine = lastLine.length() - String.valueOf(delta).length();
        StringBuilder lastLineIdents = new StringBuilder();
        for (int k = 0; k < lengthLastLine; k++) {
            lastLineIdents.append(" ");
        }
        System.out.println(lastLineIdents.toString() + delta);
    }

    public void composeLongDivisionViewForSmallDividend(int dividend, int diviser, int initialDividend) {

        int modulo = (Math.abs(dividend) % Math.abs(diviser)) * 10;
        List<Integer> subtrahendsList = computeSubtrahends(dividend, diviser);
        String currentDivident = "";
        int minuend = 0, delta = 0;
        System.out.println(" " + Math.abs(subtrahendsList.get(0)) + composeSecondLineIndent(dividend, subtrahendsList.get(0)) +
                receiveQuotient(initialDividend, diviser));
        subtrahendsList = computeAfterPointSubtrahends(dividend, diviser);
        int j = 0;
        for (Integer integer : subtrahendsList) {
            System.out.println(j + " subtrahend = " + integer);
            j++;
        }
        String lastLine = "";
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < subtrahendsList.size(); i++) {
            minuend = calculateAfterPointMinuend(modulo, diviser);
            delta = minuend - Math.abs(subtrahendsList.get(i));
            if (delta != 0) {
                while (delta < Math.abs(diviser)){
                    delta *= 10;
                }
                modulo = delta;
            } else {
                currentDivident = calculateAfterPointIntermediateDividend(modulo, diviser);// dividend
                modulo = Integer.parseInt(currentDivident);
            }
            indent.append(" ");
            System.out.println(indent.toString() + "_" + minuend);
            lastLine = indent.toString()+ " " + Math.abs(subtrahendsList.get(i));
            System.out.println(lastLine);
        }
        int lengthLastLine = lastLine.length() - String.valueOf(delta).length();
        StringBuilder lastLineIdents = new StringBuilder();
        for (int k = 0; k < (lengthLastLine + String.valueOf(modulo).length() - 1); k++) {
            lastLineIdents.append(" ");
        }
        System.out.println(lastLineIdents.toString() + delta / 10);

    }

    // !!!AFTER POINT CALCULATIONS!!!
    List<Integer> computeAfterPointSubtrahends(int dividend, int diviser) {
        String quotient = receiveQuotient(dividend, diviser);
        int dotIndex = quotient.indexOf(".");
        String afterPointQutient = quotient.substring(dotIndex + 1);
        char afterPointQuotientDigits[] = afterPointQutient.toCharArray();
        Integer firstSubtrahend = computeSubtrahends(dividend, diviser).get(0);
        List<Integer> subtrahendsList = new ArrayList<>();
        for (int i = 0; i < afterPointQuotientDigits.length; i++) {
            char c = afterPointQuotientDigits[i];
            if (!"0".equals(String.valueOf(c)) && Character.isDigit(c) &&
                    !firstSubtrahend.equals(Integer.parseInt(String.valueOf(c)) * Math.abs(diviser))) {
                subtrahendsList.add(Integer.parseInt(String.valueOf(c)) * Math.abs(diviser));
            }
        }
        return subtrahendsList;
    }

    int calculateAfterPointMinuend(int dividend, int diviser) {
        int minuend = 0;
        char dividendsDigits[] = receiveDividendsDigits(Math.abs(dividend));
        StringBuilder minuendBuilder = new StringBuilder();
        for (int i = 0; i < dividendsDigits.length; i++) {
            if (minuend < Math.abs(diviser)) {
                minuendBuilder.append(String.valueOf(dividendsDigits[i]));
                minuend = Integer.parseInt(minuendBuilder.toString());
            }
        }
        return minuend;
    }

    String calculateAfterPointIntermediateDividend(int dividend, int diviser) {
        String stringDividend = new String(receiveDividendsDigits(dividend));
        String minuend = String.valueOf(calculateAfterPointMinuend(dividend, diviser));
        String newDividendsValue = stringDividend.replaceFirst(minuend, "");
        if (newDividendsValue.equals("")) {
            return "0";
        }
        return newDividendsValue;
    }
}