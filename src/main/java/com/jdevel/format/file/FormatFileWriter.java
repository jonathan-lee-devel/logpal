package com.jdevel.format.file;

import com.jdevel.format.Format;

import java.io.File;

/**
 * Used to write specific file formats to file.
 * Provides a basic structure,
 * Each supported file format will then have its own FormatFileWriter class
 */
public abstract class FormatFileWriter {

    /**
     * Format which the writer is intended to write
     */
    private Format format;

    /**
     * File which is to be written to
     */
    private File file;

    /**
     * Constructor, passes File parameter to the setter, no default constructor ensures format and file parameter is passed
     * @param file file to be written to, passed to setter
     */
    public FormatFileWriter(Format format, File file) {
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
     * @return the current file used for writing
     */
    public File getFile() {
        return this.file;
    }

    /**
     * Basic setter for the file
     * @param file file to be written to
     */
    public void setFile(File file) {
        this.file = file;
    }

}
