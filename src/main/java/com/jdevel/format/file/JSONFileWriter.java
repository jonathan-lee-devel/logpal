package com.jdevel.format.file;

import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Used to write JSON objects to file.
 * Relies on com.codegoogle.simple-json library.
 */
public class JSONFileWriter extends FormatFileWriter {

    public static String fileExtension = "json";

    /**
     * Basic constructor, simply passes parameter to super constructor
     * @param file file to which the JSON objects are to be written
     */
    public JSONFileWriter(File file) {
        super(file);
    }

    /**
     * Writes the jsonObject parameter passed to the current file using JSONFileWriter.writeJSONObjectToFile(...)
     * @param jsonObject the jsonObject to be written to file
     */
    public void writeJSONObjectToFile(JSONObject jsonObject) {
        try {
            JSONFileWriter.writeJSONObjectToFile(this.getFile(), jsonObject);
        } catch(IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Writes the given JSON object parameter to the given file parameter
     * @param file file to which the JSON object is to be wrritten
     * @param jsonObject JSON object which is to be written to file
     * @throws IOException possibly thrown when attempting ot write to file
     */
    public static void writeJSONObjectToFile(File file, JSONObject jsonObject) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(jsonObject.toJSONString());
        fileWriter.close();
    }

}
