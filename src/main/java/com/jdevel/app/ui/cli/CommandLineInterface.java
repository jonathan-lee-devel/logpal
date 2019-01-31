package com.jdevel.app.ui.cli;

import com.jdevel.alteration.Alteration;
import com.jdevel.alteration.Procedure;
import com.jdevel.alteration.ProcedureContent;
import com.jdevel.alteration.SystemLog;
import com.jdevel.format.JSONSystemLog;
import com.jdevel.format.JSONSystemLogGenerator;
import com.jdevel.format.file.JSONFileWriter;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

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
        String inputTime = commandLine.getOptionValue("time");

        LocalDateTime time = (inputTime != null) ? (LocalDateTime.parse(inputTime)) : LocalDateTime.now();

        // Creating example SystemLog
        SystemLog systemLog = new SystemLog();

        // Example procedure
        Procedure procedure = new Procedure();
        ProcedureContent content = new ProcedureContent();
        content.setHeader("cmd");
        content.addBody("apt-get install -y git");
        procedure.addContent(content);
        // Creating and adding 10 example Alterations to the example SystemLog
        for (int i = 0; i < 10; i++) {
            Alteration alteration = new Alteration();
            alteration.setId(UUID.randomUUID());
            alteration.setDateTime(time);
            alteration.setTitle("Title[" + i + "]");
            alteration.setType("installation");
            alteration.setProcedure(procedure);
            systemLog.addAlteration(alteration);
        }

        // Generating example JSON SystemLog from example SystemLog
        JSONSystemLogGenerator jsonSystemLogGenerator = new JSONSystemLogGenerator();
        JSONSystemLog jsonSystemLog = jsonSystemLogGenerator.getFormattedLog(systemLog);

        // Write the log to a .json file
        File file = new File("/home/jonathan/test." + jsonSystemLog.getFormat().getExtension());
        JSONFileWriter jsonFileWriter = new JSONFileWriter(file);
        try {
            jsonFileWriter.writeJSONSystemLogToFile(jsonSystemLog);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        System.out.println("COMPLETE!!!");
    }

}
