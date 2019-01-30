package com.jdevel.format;

/**
 * Represents a format-specific system log
 */
public abstract class FormatSystemLog {

    private Format format;

    /**
     * Constructor, no default constructor ensures that Format parameter is passed
     * @param format format to be set
     */
    public FormatSystemLog(Format format) {
        this.setFormat(format);
    }

    /*
     * Getters and Setters
     */

    /**
     * Getter for format
     * @return format
     */
    public Format getFormat() {
        return this.format;
    }

    /**
     * Setter for format
     * @param format format to be set
     */
    private void setFormat(Format format) {
        this.format = format;
    }

}
