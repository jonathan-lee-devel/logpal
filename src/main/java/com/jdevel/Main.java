package com.jdevel;

import com.jdevel.alteration.Alteration;
import com.jdevel.alteration.SystemLog;
import com.jdevel.alteration.SystemLogJSONGenerator;
import com.jdevel.file.JSONFileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        // Creating test JSON object
        JSONObject jsonObject = new JSONObject();

        LocalDateTime currentDateTime = LocalDateTime.now();
        jsonObject.put("dateTime", currentDateTime);

        jsonObject.put("title", "Installed Google Chrome");

        // Creating test JSON array
        JSONArray companies = new JSONArray();
        companies.add("eBay");
        companies.add("JetBrains");
        jsonObject.put("Companies", companies);


        System.out.println("Main:\n" + jsonObject.toJSONString());

        File file = new File("/home/jonathan/test.json");

        JSONFileWriter jsonFileWriter = new JSONFileWriter(file);
        jsonFileWriter.writeJSONObjectToFile(jsonObject);

        SystemLog systemLog = new SystemLog();

        for (int i = 0; i < 10; i++) {
            Alteration alteration = new Alteration();
            alteration.setId(UUID.randomUUID());
            alteration.setDateTime(LocalDateTime.now());
            alteration.setTitle("Title[" + i + "]");
            alteration.setType("installation");
            alteration.setReferences(new ArrayList<UUID>());
            systemLog.addAlteration(alteration);
        }

        JSONObject jsonLog = SystemLogJSONGenerator.getJSONObjectFromSystemLog(systemLog);
        jsonFileWriter.writeJSONObjectToFile(jsonLog);
        System.out.println("complete!");
        System.out.println("Log:\n" + jsonLog.toJSONString());
    }

}
