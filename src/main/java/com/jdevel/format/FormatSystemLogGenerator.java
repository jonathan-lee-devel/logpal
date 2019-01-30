package com.jdevel.format;

import com.jdevel.alteration.SystemLog;

/**
 * Used to generate a format-specific system log from a format-independent log from the alteration package
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

    /**
     * Returns a format-specific log, procedure will vary across formats
     * @param systemLog format-independent log for which a format-specific log is to be generated
     * @return format-specific log
     */
    public abstract FormatSystemLog getFormattedLog(SystemLog systemLog);

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
