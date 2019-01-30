package com.jdevel.format;

/**
 * Represents a format which a format-specific log will be written in
 */
public class Format {

    private String name;

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
     * Static Member Getters
     */
    public static Format getJsonFormat() {
        return Format.jsonFormat;
    }

    /*
     * Getters and Setters
     */

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return this.extension;
    }

    private  void setExtension(String extension) {
        this.extension = extension;
    }

}
