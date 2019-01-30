package com.jdevel.format;

/**
 * Used to generate a format-specific system log from a format-independent log
 */
public abstract class FormatSystemLogGenerator {

    /**
     * Intended format for the generator
     */
    private Format format;

    /**
     * Constructor, sets the format, no default constructor to ensure format parameter is passed
     * @param format format to be set
     */
    public FormatSystemLogGenerator(Format format) {
        this.setFormat(format);
    }

    public abstract FormatSystemLog getFormattedLog();

    /*
     * Getters and Setters
     */

    /**
     * Getter for the format
     * @return the format
     */
    public Format getFormat() {
        return this.format;
    }

    /**
     * Setter for the format
     * @param format format to be set
     */
    private void setFormat(Format format) {
        this.format = format;
    }

}
