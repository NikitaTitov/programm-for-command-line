package com.epam.learning.commandLine;

import org.junit.Test;

import static org.junit.Assert.*;


public class OptionsFromCommandLineTest {
    String[] testLine = {"-l", "2", "-r", "4", "-o", "summ"};
    OptionsFromCommandLine options = new OptionsFromCommandLine();

    @Test
    public void testCalculateSimpleMathOperations() throws Exception {
        assertTrue(options.calculateSimpleMathOperations(testLine).equals("6"));
    }

    @Test
    public void testGetValuesFromLine() throws Exception {
        assertTrue(options.getValuesFromLine("l", testLine).equals("2"));

        assertFalse(options.getValuesFromLine("l", testLine).equals("4"));
        assertFalse(options.getValuesFromLine("l", testLine).equals(options.getValuesFromLine("r",testLine)));
    }
}