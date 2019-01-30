package com.jdevel.format;

import org.json.simple.JSONObject;

public class JSONSystemLog extends FormatSystemLog {

    /**
     * JSONObject used to store the data for the JSON format SystemLog
     */
    private JSONObject systemLogJsonObject;

    /**
     * Default Constructor, initializes the format as well as the systemLogJsonObject
     */
    public JSONSystemLog() {
        super(Format.getJsonFormat());
        this.setSystemLogJsonObject(new JSONObject());
    }

    public JSONObject getSystemLogJsonObject() {
        return this.systemLogJsonObject;
    }

    private void setSystemLogJsonObject(JSONObject systemLogJsonObject) {
        this.systemLogJsonObject = systemLogJsonObject;
    }

}
