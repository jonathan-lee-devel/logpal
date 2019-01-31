package com.jdevel.format.file;

import com.jdevel.format.Format;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ListIterator;

public class JSONFileReader extends FormatFileReader {

    /**
     * Constructor, passes File parameter to the setter, no default constructor ensures format and file parameter is passed
     *
     * @param file   file to be read from, passed to setter
     */
    public JSONFileReader(File file) {
        super(Format.getJsonFormat(), file);
    }

    public JSONObject readJSONObjectFromFile() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(this.getFile()));

        JSONObject jsonFileObject = (JSONObject) obj;

        JSONArray jsonAlterationsArray = (JSONArray) jsonFileObject.get("alterations");

        ListIterator<JSONObject> alterationsArrayIterator = jsonAlterationsArray.listIterator();
        while (alterationsArrayIterator.hasNext()) {
            JSONObject currentAlteration = alterationsArrayIterator.next();
            String dateTime = (String) currentAlteration.get("dateTime");
            String id = (String) currentAlteration.get("id");
            String title = (String) currentAlteration.get("title");
            String type = (String) currentAlteration.get("type");

            System.out.printf("%s\n%s\n%s\n%s\n", dateTime, id, title, type);
        }

        return jsonFileObject;
    }
}
