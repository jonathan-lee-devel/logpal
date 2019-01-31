package com.jdevel.format.file;

import com.jdevel.format.Format;

import java.io.File;

/**
 * Used to read specific file formats
 * Provides a basic structure,
 * Each supported file format will then have its own FormatFileReader class
 */
public abstract class FormatFileReader {

    /**
     * Format which the reader is intended to reader
     */
    private Format format;

    /**
     * File which is to be read from
     */
    private File file;

    /**
     * Constructor, passes File parameter to the setter, no default constructor ensures format and file parameter is passed
     * @param file file to be read from, passed to setter
     */
    public FormatFileReader(Format format, File file) {
        this.setFormat(format);
        this.setFile(file);
    }

    /*
     * Getters and Setters
     */

    public Format getFormat() {
        return this.format;
    }

    private void setFormat(Format format) {
        this.format = format;
    }

    /**
     * Basic getter for the file
     * @return the current file used for reading
     */
    public File getFile() {
        return this.file;
    }

    /**
     * Basic setter for the file
     * @param file file to be read from
     */
    public void setFile(File file) {
        this.file = file;
    }

}
