package com.testing.hamcrest;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersStringsTests {

    @Test
    public void testEqualTo() {

        var testString = "Test";
        assertThat(testString, equalTo("Test"));
    }

    @Test
    public void testEqualIgnoreCase() {

        var testString = "Test";
        assertThat(testString, equalToIgnoringCase("test"));
    }

    @Test
    public void testStringContainsSubstring() {

        var testString = "Test Hamcrest";
        assertThat(testString, containsString("Hamcrest"));
    }

    @Test
    public void testStringContainsSubstringIgnoringCase() {

        var testString = "Test Hamcrest";
        assertThat(testString, containsStringIgnoringCase("hamcrest"));
    }

    @Test
    public void testStringStartsWithPrefix() {

        var testString = "Test Hamcrest";
        assertThat(testString, startsWithIgnoringCase("test"));
    }

    @Test
    public void testStringEndsWithSuffix() {

        var testString = "Test Hamcrest";
        assertThat(testString, endsWithIgnoringCase("hamcrest"));
    }

    @Test
    public void testStringMatchesPattern() {

        var testString = "hamcrest";
        assertThat(testString, matchesPattern("\\bhamcrest\\b"));
    }

    @Test
    public void testStringIsEmpty() {

        var testString = "";
        assertThat(testString, is(emptyString()));
    }

    @Test
    public void testStringIsBlank() {

        var testString = "   ";
        assertThat(testString, is(blankString()));
    }

    @Test
    public void testStringIEqualToCompressingWhiteSpace() {

        var testString = "  Test Hamcrest  ";
        assertThat(testString, equalToCompressingWhiteSpace("Test Hamcrest"));
    }
}
