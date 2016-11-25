package com.epam.learning.commandLine;

import org.apache.commons.cli.*;

import java.io.OutputStream;
import java.io.PrintWriter;

public class OptionsFromCommandLine {
    String calculateSimpleMathOperations(String[] args) {
        if (args.length == 0) {
            printHelp(allOptions(), 200, "How to use :", "", 3, 5, false, System.out);
            System.exit(0);
        }
        String result = "";
        int answer = 0;
        int left = Integer.parseInt(getValuesFromLine("l", args));
        int right = Integer.parseInt(getValuesFromLine("r", args));
        String operation = getValuesFromLine("o", args);
        if (operation.equals("mult")) {
            answer = left * right;
        }
        if (operation.equals("div")) {
            answer = left / right;
        }
        if (operation.equals("summ")) {
            answer = left + right;
        }
        if (operation.equals("sub")) {
            answer = left - right;
        }

        return result.valueOf(answer);
    }

    private Options allOptions() {
        Option leftOption = createOption("l", true, "Left operand type int, required option");
        Option rightOption = createOption("r", true, "Right operand type int, required option");
        Option signOption = createOption("o", true, "Operation for operands(example summ(+), sub(-), mult(*), div(/) ), required option");
        Option helpOption = new Option("h", "help");

        Options posixOptions = new Options();
        posixOptions.addOption(leftOption);
        posixOptions.addOption(rightOption);
        posixOptions.addOption(signOption);
        posixOptions.addOption(helpOption);

        return posixOptions;
    }

    private Option createOption(String shortName, boolean state, String explaining) {
        Option option = new Option(shortName, state, explaining);
        option.setArgs(1);
        option.setArgName(explaining);
        return option;
    }

    String getValuesFromLine(String nameOption, String[] args) {
        String result = "";
        CommandLineParser cmdLineParser = new PosixParser();
        CommandLine commandLine;
        try {
            commandLine = cmdLineParser.parse(allOptions(), args);
            if (commandLine.hasOption("h") || commandLine.hasOption("help")) {
                printHelp(allOptions(), 200, "How to use :", "", 3, 5, false, System.out);
                System.exit(0);
            }
            if (commandLine.hasOption(nameOption)) {
                result = commandLine.getOptionValue(nameOption);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static void printHelp(
            final Options options,
            final int printedRowWidth,
            final String header,
            final String footer,
            final int spacesBeforeOption,
            final int spacesBeforeOptionDescription,
            final boolean displayUsage,
            final OutputStream out) {

        final String commandLineSyntax = "java ConsoleProgram.jar";
        final PrintWriter writer = new PrintWriter(out);
        final HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.printHelp(
                writer,
                printedRowWidth,
                commandLineSyntax,
                header,
                options,
                spacesBeforeOption,
                spacesBeforeOptionDescription,
                footer,
                displayUsage);
        writer.flush();
    }

}
