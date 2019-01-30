package com.jdevel.app;

import com.jdevel.alteration.Alteration;
import com.jdevel.alteration.Procedure;
import com.jdevel.alteration.ProcedureContent;
import com.jdevel.alteration.SystemLog;
import com.jdevel.format.JSONSystemLog;
import com.jdevel.format.JSONSystemLogGenerator;
import com.jdevel.format.file.JSONFileWriter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

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
            alteration.setDateTime(LocalDateTime.now());
            alteration.setTitle("Title[" + i + "]");
            alteration.setType("installation");
            alteration.setProcedure(procedure);
            systemLog.addAlteration(alteration);
        }

        // Generating example JSON SystemLog from example SystemLog
        JSONSystemLogGenerator jsonSystemLogGenerator = new JSONSystemLogGenerator();
        JSONSystemLog jsonSystemLog = jsonSystemLogGenerator.getFormattedLog(systemLog);

        // Display contents in console
        System.out.printf("ATTEMPTING TO WRITE THE FOLLIWING LOG TO FILE\n*\n%s\n*\n", jsonSystemLog.getSystemLogJsonObject().toJSONString());

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
