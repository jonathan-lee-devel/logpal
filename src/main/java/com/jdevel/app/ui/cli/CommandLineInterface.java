package com.jdevel.app.ui.cli;

import org.apache.commons.cli.*;

public class CommandLineInterface {

    public static void main(String[] args) {
        Options options = new Options();

        Option inputOption = new Option("i", "input", true, "input file path");
        inputOption.setRequired(false);
        options.addOption(inputOption);

        Option outputOption = new Option("o", "output", true, "output file");
        outputOption.setRequired(false);
        options.addOption(outputOption);

        Option timeOption = new Option("t", "time", true, "Time to be set");
        timeOption.setRequired(false);
        options.addOption(timeOption);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine commandLine = null;

        try {
            commandLine = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }

        String inputFilePath = commandLine.getOptionValue("input");
        String outputFilePath = commandLine.getOptionValue("output");
        String time = commandLine.getOptionValue("time");

        System.out.println(inputFilePath);
        System.out.println(outputFilePath);
        System.out.println("Time to be set: " + time);
    }

}
