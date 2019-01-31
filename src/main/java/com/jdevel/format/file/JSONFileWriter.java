package com.jdevel.format.file;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jdevel.format.Format;
import com.jdevel.format.JSONSystemLog;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Used to write JSON objects to file.
 */
public class JSONFileWriter extends FormatFileWriter {

    /**
     * Basic constructor, simply passes default JSON format along with file parameter to super constructor
     * @param file file to which the JSON objects are to be written
     */
    public JSONFileWriter(File file) {
        super(Format.getJsonFormat(), file);
    }

    /**
     * Writes the given JSONSystemLog to file using the private writeJSONObjectToFile() method
     * @param jsonSystemLog jsonSystemLog to be written to file
     * @throws IOException possible exception as FileWriter is used in writeJSONObjectToFile() method
     */
    public void writeJSONSystemLogToFile(JSONSystemLog jsonSystemLog) throws IOException {
        this.writeJSONObjectToFile(jsonSystemLog.getSystemLogJsonObject());
    }

    /**
     * Writes the jsonObject parameter passed to the current file
     * @param jsonObject the jsonObject to be written to file
     */
    private void writeJSONObjectToFile(JSONObject jsonObject) throws IOException {
        FileWriter fileWriter = new FileWriter(this.getFile());

        // Add indentations to JSON data
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        String rawJsonString = jsonObject.toJSONString();
        JsonNode tree = objectMapper.readTree(rawJsonString);

        String formattedJsonString = objectMapper.writeValueAsString(tree);

        fileWriter.write(formattedJsonString);
        fileWriter.close();
    }

}
