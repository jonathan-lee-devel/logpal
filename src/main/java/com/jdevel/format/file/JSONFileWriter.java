package com.jdevel.format.file;

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
        fileWriter.write(jsonObject.toJSONString());
        fileWriter.close();
    }

}
