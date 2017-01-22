package com.foxminded.anagrams.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ConverterTest {
    private Converter tester;
    private String phrase;
    private String invertedPhrase;
    private String convertedPhrase;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private String phraseAnagram;

    @Before
    public void setUp() throws Exception {
        tester = new Converter();
        phrase = new String("!pape&r- bo,a!t");
        invertedPhrase = new String("t!a,ob -r&epap!");
        convertedPhrase = new String("!taob&r- ep,a!p");
        System.setOut(new PrintStream(outContent));
        phraseAnagram = new String("!repa&p- ta,o!b ");
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

    //testing invert()
    @Test
    public void testInvertMethodReturnsNotNull() {
        assertNotNull(tester.invert(phrase));
    }

    @Test
    public void testInvertMethodInversesString() {
        for(int i = 0; i < phrase.length(); i++) {
            assertEquals("invert() doesn't invert indeed!", invertedPhrase.toCharArray()[i], tester.invert(phrase)[i]);
        }
    }

    @Test
    public void testInvertMethodInversesBareString() {
        String testee = "";
        String prospect = "";
        assertArrayEquals("invert() doesn't invert indeed!", prospect.toCharArray(), tester.invert(testee));
    }

    @Test
    public void testInvertMethodInversesLettersAndSymbols() {
        String testee = new String("&*?~asdfgKk-");
        String prospect = new String("-kKgfdsa~?*&");
        assertArrayEquals("invert() doesn't invert indeed!", prospect.toCharArray(), tester.invert(testee));
    }

    @Test
    public void testInvertMethodInversesLettersAndDigits() {
        String testee = new String("as09dfgKk7");
        String prospect = new String("7kKgfd90sa");
        assertArrayEquals("invert() doesn't invert indeed!", prospect.toCharArray(), tester.invert(testee));
    }

    @Test
    public void testInvertMethodInversesLettersAndSymbolsAndDigits() {
        String testee = new String("&*?123asdfgKk-");
        String prospect = new String("-kKgfdsa321?*&");
        assertArrayEquals("invert() doesn't invert indeed!", prospect.toCharArray(), tester.invert(testee));
    }

    @Test
    public void testInvertMethodInversesSymbolsAndDigits() {
        String testee = new String("&*?123-");
        String prospect = new String("-321?*&");
        assertArrayEquals("invert() doesn't invert indeed!", prospect.toCharArray(), tester.invert(testee));
    }

    @Test
    public void testInvertMethodInversesJustLetters() {
        String testee = new String("asdfgKkOl");
        String prospect = new String("lOkKgfdsa");
        assertArrayEquals("invert() doesn't invert indeed!", prospect.toCharArray(), tester.invert(testee));
    }

    @Test
    public void testInvertMethodInversesJustDigits() {
        String testee = new String("123455678");
        String prospect = new String("876554321");
        assertArrayEquals("invert() doesn't invert indeed!", prospect.toCharArray(), tester.invert(testee));
    }

    @Test
    public void testInvertMethodInversesJustSymbols() {
        String testee = new String("|-?!/+=-',.");
        String prospect = new String(".,'-=+/!?-|");
        assertArrayEquals("invert() doesn't invert indeed!", prospect.toCharArray(), tester.invert(testee));
    }

    // testing convert()
    @Test
    public void testConvertMethodReturnsNotNull() {
        assertNotNull(tester.convert(phrase));
    }

    @Test
    public void testConvertMethodConvertsString() {
        assertEquals("convert() doesn't work correctly!", convertedPhrase, tester.convert(phrase));
    }

    @Test
    public void testConnvertMethodConvertsBareString() {
        String testee = "";
        String prospect = "";
        assertEquals("invert() doesn't invert indeed!", prospect, tester.convert(testee));
    }

    @Test
    public void testConnvertMethodConvertsJustLetters() {
        String testee = new String("asdfghjkL");
        String prospect = new String("Lkjhgfdsa");
        assertEquals("invert() doesn't invert indeed!", prospect, tester.convert(testee));
    }

    @Test
    public void testConnvertMethodConvertsJustSymbols() {
        String testee = new String("|-?!/+=-',.");
        String prospect = new String("|-?!/+=-',.");
        assertEquals("invert() doesn't invert indeed!", prospect, tester.convert(testee));
    }

    @Test
    public void testConnvertMethodConvertsJustDigits() {
        String testee = new String("12345557");
        String prospect = new String("12345557");
        assertEquals("invert() doesn't invert indeed!", prospect, tester.convert(testee));
    }

    @Test
    public void testConnvertMethodConvertsLettersAndSymbols() {
        String testee = new String("aA-?bB!~kl&*q");
        String prospect = new String("ql-?kB!~bA&*a");
        assertEquals("invert() doesn't invert indeed!", prospect, tester.convert(testee));
    }

    @Test
    public void testConnvertMethodConvertsLettersAndDigits() {
        String testee = new String("aA43bB88kl24q");
        String prospect = new String("ql43kB88bA24a");
        assertEquals("invert() doesn't invert indeed!", prospect, tester.convert(testee));
    }

    @Test
    public void testConnvertMethodConvertsSymbolsAndDigits() {
        String testee = new String("24-?48!~16&*0");
        String prospect = new String("24-?48!~16&*0");
        assertEquals("invert() doesn't invert indeed!", prospect, tester.convert(testee));
    }

    @Test
    public void testConnvertMethodConvertsLettersAndSymbolsAndDigits() {
        String testee = new String("aN24Fg-?48!~16&*0Kk");
        String prospect = new String("kK24gF-?48!~16&*0Na");
        assertEquals("invert() doesn't invert indeed!", prospect, tester.convert(testee));
    }

    //testing printAnagram()
    @Test
    public void testPrintAnagramMethodWorksCorrect() {
        tester.printAnagram(phrase);
        assertEquals(phraseAnagram, outContent.toString());
    }

}
