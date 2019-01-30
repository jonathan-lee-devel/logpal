package com.jdevel.format;

/**
 * Represents a format which a format-specific log will be written in
 */
public class Format {

    /*
     * Static Members
     */

    private static final Format jsonFormat;

    /*
     * Static Member Initialization
     */

    static {
        jsonFormat = new Format("JSON", "json");
    }

    /*
     * Static Member Public Accessors
     */

    public static Format getJsonFormat() {
        return Format.jsonFormat;
    }

    /**
     * Name of the format
     */
    private String name;

    /**
     * Extension for the format, i.e. the string following the '.' in files
     */
    private String extension;

    /**
     * Constructor, no default constructor ensures that name and extension parameters are passed
     * @param name name to be set
     * @param extension extension to be set
     */
    public Format(String name, String extension) {
        this.setName(name);
        this.setExtension(extension);
    }

    /*
     * Getters and Setters
     */

    /**
     * Getter for the name
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for the name
     * @param name the name to be set
     */
    private void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the extension
     * @return the extension
     */
    public String getExtension() {
        return this.extension;
    }

    /**
     * Setter for the extension
     * @param extension the extension to be set
     */
    private  void setExtension(String extension) {
        this.extension = extension;
    }

}
