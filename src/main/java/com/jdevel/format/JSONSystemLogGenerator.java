package com.jdevel.format;

import com.jdevel.alteration.Alteration;
import com.jdevel.alteration.SystemLog;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ListIterator;
import java.util.UUID;

/**
 * System log generator for the JSON format
 */
public class JSONSystemLogGenerator extends FormatSystemLogGenerator {

    /**
     * Default constructor, simply passes the Format.getJsonFormat() to the super (format parameter)
     */
    public JSONSystemLogGenerator() {
        super(Format.getJsonFormat());
    }

    /**
     * Returns JSON-format log from the format-independent SystemLog parameter passed
     * @param systemLog format-independent log for which a format-specific log is to be generated
     * @return JSON-format log generated from the format-independent SystemLog parameter passed
     */
    @Override
    public JSONSystemLog getFormattedLog(SystemLog systemLog) {
        JSONSystemLog jsonSystemLog = new JSONSystemLog();

        // Obtain reference to inner JSON object of JSONSystemLog object
        JSONObject jsonSystemLogObject = jsonSystemLog.getSystemLogJsonObject();
        // Create JSON array to store all alterations
        JSONArray jsonAlterationsArray = new JSONArray();

        // Iterate through all alterations of the SystemLog parameter, adding alterations to JSON alterations array
        ListIterator<Alteration> alterationListIterator = systemLog.getAlterationsIterator();
        while (alterationListIterator.hasNext()) {
            Alteration alteration = alterationListIterator.next();
            JSONObject jsonAlteration = new JSONObject();
            jsonAlteration.put("id", alteration.getId().toString());
            jsonAlteration.put("dateTime", alteration.getDateTime().toString());
            jsonAlteration.put("title", alteration.getTitle());
            jsonAlteration.put("type", alteration.getType());
            // Procedure
            // References
            jsonAlterationsArray.add(jsonAlteration);
        }
        // Add JSON alterations array to inner JSON object of JSONSystemLog object
        jsonSystemLogObject.put("alterations", jsonAlterationsArray);

        return jsonSystemLog;
    }

    /*
     * STATIC METHODS MOST LIKELY WILL BE REMOVED
     */

    private static JSONObject getJSONObjectFromSystemLog(SystemLog systemLog) {
        // JSON object representing the log
        JSONObject jsonLog = new JSONObject();
        // Array of alterations to be put into log JSON object
        JSONArray jsonAlterations = new JSONArray();

        // Add each alteration from system log parameter to the JSON alterations array
        ListIterator<Alteration> alterationListIterator = systemLog.getAlterationsIterator();
        while (alterationListIterator.hasNext()) {
            jsonAlterations.add( JSONSystemLogGenerator.getJSONObjectFromAlteration(alterationListIterator.next()) );
        }
        // Add the JSON alterations array to the log
        jsonLog.put("alterations", jsonAlterations);


        // Return generated JSON log
        return jsonLog;
    }

    private static JSONObject getJSONObjectFromAlteration(Alteration alteration) {
        // JSON object representing the alteration
        JSONObject jsonAlteration = new JSONObject();

        jsonAlteration.put("id", alteration.getId());
        jsonAlteration.put("dateTime", alteration.getDateTime());
        jsonAlteration.put("title", alteration.getTitle());
        jsonAlteration.put("type", alteration.getType());

        // Array for the references
        JSONArray jsonReferences = new JSONArray();
        // Add all references in the references ArrayList to the JSON references Array
        ListIterator<UUID> referencesListIterator = alteration.getReferencesIterator();
        while (referencesListIterator.hasNext()) {
            jsonReferences.add( referencesListIterator.next() );
        }
        // Add the JSON references Array to the JSON alteration
        jsonAlteration.put("references", jsonReferences);

        // Return generated JSON alteration
        return jsonAlteration;
    }

}
