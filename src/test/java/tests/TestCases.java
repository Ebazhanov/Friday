package tests;

import org.testng.annotations.Test;
import schema.AddressParser;

import static org.testng.Assert.assertEquals;

public class TestCases {

    private final AddressParser parser = new AddressParser();

    // 1. Write a simple program that does the task for the most simple cases, e.g.

    @Test
    public void shouldParseSimpleAddress1() {
        final String input = "Winterallee 3";
        final String expectedJson = "{\"street\":\"Winterallee\",\"housenumber\":\"3\"}";
        final String actualJson = parser.parse(input);
        assertEquals(expectedJson, actualJson);
    }

    @Test
    public void shouldParseSimpleAddress2() {
        final String input = "Musterstrasse 45";
        final String expectedJson = "{\"street\":\"Musterstrasse\",\"housenumber\":\"45\"}";
        final String actualJson = parser.parse(input);
        assertEquals(expectedJson, actualJson);
    }

    @Test
    public void shouldParseSimpleAddress3() {
        final String input = "Blaufeldweg 123B";
        final String expectedJson = "{\"street\":\"Blaufeldweg\",\"housenumber\":\"123B\"}";
        final String actualJson = parser.parse(input);
        assertEquals(expectedJson, actualJson);
    }

    // 2. Consider more complicated cases

    @Test
    public void shouldParseComplicatedAddress1() {
        final String input = "Am Bächle 23";
        final String expectedJson = "{\"street\":\"Am Bächle\",\"housenumber\":\"23\"}";
        final String actualJson = parser.parse(input);
        assertEquals(expectedJson, actualJson);
    }

    @Test
    public void shouldParseComplicatedAddress2() {
        final String input = "Auf der Vogelwiese 23 b";
        final String expectedJson = "{\"street\":\"Auf der Vogelwiese\",\"housenumber\":\"23 b\"}";
        final String actualJson = parser.parse(input);
        assertEquals(expectedJson, actualJson);
    }

}