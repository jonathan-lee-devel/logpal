package com.jdevel;

import com.jdevel.file.JSONFileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.time.LocalDateTime;

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
    }

}
