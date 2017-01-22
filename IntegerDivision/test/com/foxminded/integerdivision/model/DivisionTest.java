package com.foxminded.integerdivision.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DivisionTest {
    private Division tester;

	/*
	 * Default clauses considering arithmetic rules and method printResult(String [] arguments) in Division.class:
	 *(1) Diviser cannot be equal to 0;
	 *(2) Math.abs(dividend) > Math.abs(diviser);
	 *(3) Math.abs(dividend) > 0.
	 */

    @Before
    public void setUp() throws Exception {
        tester = new Division();
    }

    @After
    public void tearDown() throws Exception {
    }

    // Tests for isIntNumber(String str)
    @Test
    public void testIsIntNumber() {
        String testee = "234560";
        boolean prospect = true;
        assertEquals("IsIntNumber doesn't work correctly at all", prospect, tester.isIntNumber(testee));
    }

    @Test
    public void testIsIntNumberNegativeNumber() {
        String testee = "-234560";
        boolean prospect = true;
        assertEquals("IsIntNumber coudn't rekognise negataive integer number", prospect, tester.isIntNumber(testee));
    }

    @Test
    public void testIsIntNumberEmptyLine() {
        String testee = "";
        boolean prospect = false;
        assertEquals("IsIntNumber counts empty line as integer number", prospect, tester.isIntNumber(testee));
    }

    @Test
    public void testIsIntNumberForJustLetters() {
        String testee = "abc";
        boolean prospect = false;
        assertEquals("IsIntNumber counts letters as integer number", prospect, tester.isIntNumber(testee));
    }

    @Test
    public void testIsIntNumberForJustSymbols() {
        String testee = "-";
        boolean prospect = false;
        assertEquals("IsIntNumber counts symbols as integer number", prospect, tester.isIntNumber(testee));
    }

    @Test
    public void testIsIntNumberForLettersAndSymbols() {
        String testee = "-ab!c?";
        boolean prospect = false;
        assertEquals("IsIntNumber counts letters&symbols as integer number", prospect, tester.isIntNumber(testee));
    }

    @Test
    public void testIsIntNumberForDigitsWithLetters() {
        String testee = "4ab7c8";
        boolean prospect = false;
        assertEquals("IsIntNumber counts digits with letters as integer number", prospect, tester.isIntNumber(testee));
    }

    @Test
    public void testIsIntNumberForDigitsWithSymbols() {
        String testee = "478-";
        boolean prospect = false;
        assertEquals("IsIntNumber counts digits with symbolss as integer number", prospect, tester.isIntNumber(testee));
    }

    @Test
    public void testIsIntNumberForDigitsWithSymbolsAndLetters() {
        String testee = "6a-4&?7b!8c";
        boolean prospect = false;
        assertEquals("IsIntNumber counts digits with symbolss as integer number", prospect, tester.isIntNumber(testee));
    }

    // Tests for receiveDividendsDigits()
    @Test
    public void testReceiveDividendsDigits() {
        int zero = 3406;
        char prospect[] = new char[] { '3', '4', '0', '6' };
        assertArrayEquals("ReceiveDividends doesn't work correctly at all", prospect,
                tester.receiveDividendsDigits(zero));
    }

    @Test
    public void testReceiveDividendsDigitsPositive() {
        int positive = 3457;
        char prospect[] = new char[] { '3', '4', '5', '7' };
        assertArrayEquals("ReceiveDividends doesn't return a char[]", prospect, tester.receiveDividendsDigits(positive));
    }

    @Test
    public void testReceiveDividendsDigitsNegative() {
        int negative = -107;
        char prospect[] = new char[] { '1', '0', '7' };
        assertArrayEquals("ReceiveDividends doesn't ignore '-'", prospect, tester.receiveDividendsDigits(negative));
    }

    @Test
    public void testReceiveDividendsDigitsOneSign() {
        int oneSign = 2;
        char prospect[] = new char[] { '2' };
        assertArrayEquals("ReceiveDividends doesn't return char[] with 1 sign", prospect,
                tester.receiveDividendsDigits(oneSign));
    }

    @Test
    public void testReceiveDividendsDigitsOneSignNegtive() {
        int oneSignNegative = -2;
        char prospect[] = new char[] { '2' };
        assertArrayEquals("ReceiveDividends doesn't return char[] with 1 negative sign", prospect,
                tester.receiveDividendsDigits(oneSignNegative));
    }

    // Tests for calculateMinuend(int dividend, int diviser)
    @Test
    public void testCalculateMinuend() {
        int dividend = 51678;
        int diviser = 62;
        int prospect = 516;
        assertEquals("CalculateMinuend doesn't work correctly at all", prospect,
                tester.calculateMinuend(dividend, diviser));
    }

    @Test
    public void testCalculateMinuendNegtiveDividend() {
        int dividend = -2978;
        int diviser = 18;
        int prospect = 29;
        assertEquals("CalculateMinuend doesn't ignores '-' with divident", prospect,
                tester.calculateMinuend(dividend, diviser));
    }

    @Test
    public void testCalculateMinuendNegativeDiviser() {
        int dividend = 2978;
        int diviser = -18;
        int prospect = 29;
        assertEquals("CalculateMinuend doesn't ignores '-' with diviser", prospect,
                tester.calculateMinuend(dividend, diviser));
    }

    @Test
    public void testCalculateMinuendBothNegative() {
        int dividend = -2978;
        int diviser = -18;
        int prospect = 29;
        assertEquals("CalculateMinuend doesn't ignores '-' with both arguments", prospect,
                tester.calculateMinuend(dividend, diviser));
    }

    @Test
    public void testCalculateMinuendDividendOneSign() {
        int dividend = 9;
        int diviser = 7;
        int prospect = 9;
        assertEquals("CalculateMinuend doesn't work with single-character arguments", prospect,
                tester.calculateMinuend(dividend, diviser));
    }

    @Test
    public void testCalculateMinuendNegativeDividendOneSign() {
        int dividend = -9;
        int diviser = 7;
        int prospect = 9;
        assertEquals("CalculateMinuend doesn't ignores '-' with single-character divident", prospect,
                tester.calculateMinuend(dividend, diviser));
    }

    @Test
    public void testCalculateMinuendNegativeDiviserOneSign() {
        int dividend = 9;
        int diviser = -7;
        int prospect = 9;
        assertEquals("CalculateMinuend doesn't ignores '-' with single-character diviser", prospect,
                tester.calculateMinuend(dividend, diviser));
    }

    @Test
    public void testCalculateMinuendBothNegativeOneSign() {
        int dividend = -9;
        int diviser = -7;
        int prospect = 9;
        assertEquals("CalculateMinuend doesn't ignores '-' with both single-character arguments", prospect,
                tester.calculateMinuend(dividend, diviser));
    }

    // Tests for computeSubtrahends(int dividend, int diviser)
    @Test
    public void testComputeSubtrahends() {
        int dividend = 62874;
        int diviser = 3;
        List<Integer> prospect = Arrays.asList(6, 27, 15, 24);
        assertEquals("ComputeSubtrahends() doesn't work correctly at all", prospect,
                tester.computeSubtrahends(dividend, diviser));
    }

    @Test
    public void testComputeSubtrahendsBothArgumentsNegative() {
        int dividend = -62874;
        int diviser = -3;
        List<Integer> prospect = Arrays.asList(6, 27, 15, 24);
        assertEquals("ComputeSubtrahends() return negative subtrahends when both arguments are negative", prospect,
                tester.computeSubtrahends(dividend, diviser));
    }

    @Test
    public void testComputeSubtrahendsDividendNegative() {
        int dividend = -62874;
        int diviser = 3;
        List<Integer> prospect = Arrays.asList(6, 27, 15, 24);
        assertEquals("ComputeSubtrahends() return negative subtrahends when dividend is negative", prospect,
                tester.computeSubtrahends(dividend, diviser));
    }

    @Test
    public void testComputeSubtrahendsDiviserNegative() {
        int dividend = 62874;
        int diviser = -3;
        List<Integer> prospect = Arrays.asList(6, 27, 15, 24);
        assertEquals("ComputeSubtrahends() return negative subtrahends when diviser is negative", prospect,
                tester.computeSubtrahends(dividend, diviser));
    }

    @Test
    public void testComputeSubtrahendsIfBothArgumentsHaveOneSign() {
        int dividend = 8;
        int diviser = 3;
        List<Integer> prospect = Arrays.asList(6);
        assertEquals("ComputeSubtrahends() doesn't work correctly if arguments are single-character", prospect,
                tester.computeSubtrahends(dividend, diviser));
    }

    @Test
    public void testComputeSubtrahendsIfBothArgumentsHaveOneSignAndDividendNegative() {
        int dividend = -8;
        int diviser = 3;
        List<Integer> prospect = Arrays.asList(6);
        assertEquals("ComputeSubtrahends() doesn't work correctly if arguments are single-character and dividend is negative", prospect,
                tester.computeSubtrahends(dividend, diviser));
    }

    @Test
    public void testComputeSubtrahendsIfBothArgumentsHaveOneSignAndDiviserNegative() {
        int dividend = 8;
        int diviser = -3;
        List<Integer> prospect = Arrays.asList(6);
        assertEquals("ComputeSubtrahends() doesn't work correctly if arguments are single-character and diviser is negative", prospect,
                tester.computeSubtrahends(dividend, diviser));
    }

    @Test
    public void testComputeSubtrahendsIfBothArgumentsHaveOneSignAndNegative() {
        int dividend = -8;
        int diviser = -3;
        List<Integer> prospect = Arrays.asList(6);
        assertEquals("ComputeSubtrahends() doesn't work correctly if arguments are single-character and negative", prospect,
                tester.computeSubtrahends(dividend, diviser));
    }


    // Tests for calculateIntermediateDividend(int dividend, int diviser)
    @Test
    public void testCalculateIntermediateDividend() {
        int dividend = 62874;
        int diviser = 3;
        String prospect = "2874";
        assertEquals("CalculateIntermediateDivident() doesn't work correctly at all", prospect,
                tester.calculateIntermediateDividend(dividend, diviser));
    }

    @Test
    public void testCalculateIntermediateDividendIfDividendNegative() {
        int dividend = -62874;
        int diviser = 3;
        String prospect = "2874";
        assertEquals("CalculateIntermediateDivident() doesn't work correctly if divident negative", prospect,
                tester.calculateIntermediateDividend(dividend, diviser));
    }

    @Test
    public void testCalculateIntermediateDividendIfDiviserNegative() {
        int dividend = 47;
        int diviser = -23;
        String prospect = "0";
        assertEquals("CalculateIntermediateDivident() doesn't work correctly if diviser negative", prospect,
                tester.calculateIntermediateDividend(dividend, diviser));
    }

    @Test
    public void testCalculateIntermediateDividendIfBothArgumentsNegative() {
        int dividend = -47568;
        int diviser = -233;
        String prospect = "68";
        assertEquals("CalculateIntermediateDivident() doesn't work correctly if both arguments are negative", prospect,
                tester.calculateIntermediateDividend(dividend, diviser));
    }

    @Test
    public void testCalculateIntermediateDividendIfBothArgumentsHaveOneSign() {
        int dividend = 8;
        int diviser = 3;
        String prospect = "0";
        assertEquals("CalculateIntermediateDivident() doesn't work correctly if both arguments are simple-character", prospect,
                tester.calculateIntermediateDividend(dividend, diviser));
    }

    @Test
    public void testCalculateIntermediateDividendIfBothArgumentsHaveOneSignAndDividendNegative() {
        int dividend = -8;
        int diviser = 3;
        String prospect = "0";
        assertEquals("CalculateIntermediateDivident() doesn't work correctly if both arguments are simple-character and dividend is negative", prospect,
                tester.calculateIntermediateDividend(dividend, diviser));
    }

    @Test
    public void testCalculateIntermediateDividendIfBothArgumentsHaveOneSignAndDiviserNegative() {
        int dividend = 8;
        int diviser = -3;
        String prospect = "0";
        assertEquals("CalculateIntermediateDivident() doesn't work correctly if both arguments are simple-character and diviser is negative", prospect,
                tester.calculateIntermediateDividend(dividend, diviser));
    }

    @Test
    public void testCalculateIntermediateDividendIfBothArgumentsHaveOneSignAndNegative() {
        int dividend = -8;
        int diviser = -3;
        String prospect = "0";
        assertEquals("CalculateIntermediateDivident() doesn't work correctly if both arguments are simple-character and negative", prospect,
                tester.calculateIntermediateDividend(dividend, diviser));
    }

    // Tests for composeSecondLineIndent(int number, int subtrahend)
    @Test
    public void testComposeSecondLineIndent() {
        int number = 107931;
        int subtrahend = 5;
        String prospect = "     |";
        assertEquals("ComposeSecondLineIndent doesn't work correct at all", prospect, tester.composeSecondLineIndent(number, subtrahend));
    }

    @Test
    public void testComposeSecondLineIndentIfNumberNegative() {
        int number = -107931;
        int subtrahend = 5;
        String prospect = "     |";
        assertEquals("ComposeSecondLineIndent doesn't ignore '-' with number-argument", prospect, tester.composeSecondLineIndent(number, subtrahend));
    }

    @Test
    public void testComposeSecondLineIndentIfSubtrahendNegative() {
        int number = 107931;
        int subtrahend = -55;
        String prospect = "    |";
        assertEquals("ComposeSecondLineIndent doesn't ignore '-' with subtrahend-argument", prospect, tester.composeSecondLineIndent(number, subtrahend));
    }

    @Test
    public void testComposeSecondLineIndentIfBothArgumentsNegative() {
        int number = -107931;
        int subtrahend = -55;
        String prospect = "    |";
        assertEquals("ComposeSecondLineIndent doesn't ignore '-' with both argument", prospect, tester.composeSecondLineIndent(number, subtrahend));
    }

    @Test
    public void testComposeSecondLineIndentIfBothArgumentsHaveOneSign() {
        int number = 5;
        int subtrahend = 1;
        String prospect = "|";
        assertEquals("ComposeSecondLineIndent doesn't ignore '-' with both argument", prospect, tester.composeSecondLineIndent(number, subtrahend));
    }

    // Tests for printResult(String[] arguments)
    @Test
    public void testPrintResultOnlyFirstElementEqualsExit() {
        String testee[] = new String[] {"exit", "notExit"};
        boolean prospect = true;
        assertEquals("PrintResult doesn't return true if one of the elements of the argument equals \"exit\"", prospect, tester.printResult(testee));
    }

    @Test
    public void testPrintResultOnlySecondElementEqualsExit() {
        String testee[] = new String[] {"notExit", "exit"};
        boolean prospect = true;
        assertEquals("PrintResult doesn't return true if one of the elements of the argument equals \"exit\"", prospect, tester.printResult(testee));
    }

    @Test
    public void testPrintResultBothElemenetsEqualsExit() {
        String testee[] = new String[] {"exit", "exit"};
        boolean prospect = true;
        assertEquals("PrintResult doesn't return true if one of the elements of the argument equals \"exit\"", prospect, tester.printResult(testee));
    }

    @Test
    public void testPrintResultBothElementsNotEqualsExit() {
        String testee[] = new String[] {"blabla", "notExit"};
        boolean prospect = false;
        assertEquals("PrintResult returns true if the elements doesn't equals \"exit\"", prospect, tester.printResult(testee));
    }
}
