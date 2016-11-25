package com.epam.learning.commandLine;

public class ConsoleProgram {
    public static void main(String[] args) {
        OptionsFromCommandLine options = new OptionsFromCommandLine();
        String result = options.calculateSimpleMathOperations(args);
        System.out.println(result);

    }
}
