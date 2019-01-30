package com.jdevel.format;

import com.jdevel.alteration.Alteration;
import com.jdevel.alteration.SystemLog;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.UUID;

/**
 * System log generator for the JSON format
 */
public class JSONSystemLogGenerator extends FormatGenerator {

    public static JSONObject getJSONObjectFromSystemLog(SystemLog systemLog) {
        // JSON object representing the log
        JSONObject jsonLog = new JSONObject();
        // Array of alterations to be put into log JSON object
        JSONArray jsonAlterations = new JSONArray();

        // Add each alteration from system log parameter to the JSON alterations array
        for (Alteration alteration : systemLog.getAlterations()) {
            jsonAlterations.add( JSONSystemLogGenerator.getJSONObjectFromAlteration(alteration) );
        }
        // Add the JSON alterations array to the log
        jsonLog.put("alterations", jsonAlterations);


        // Return generated JSON log
        return jsonLog;
    }

    public static JSONObject getJSONObjectFromAlteration(Alteration alteration) {
        // JSON object representing the alteration
        JSONObject jsonAlteration = new JSONObject();

        jsonAlteration.put("id", alteration.getId());
        jsonAlteration.put("dateTime", alteration.getDateTime());
        jsonAlteration.put("title", alteration.getTitle());
        jsonAlteration.put("type", alteration.getType());

        // Array for the references
        JSONArray jsonReferences = new JSONArray();
        for (UUID id : alteration.getReferences()) {
            jsonReferences.add(id);
        }
        jsonAlteration.put("references", jsonReferences);

        // Return generated JSON alteration
        return jsonAlteration;
    }

}
