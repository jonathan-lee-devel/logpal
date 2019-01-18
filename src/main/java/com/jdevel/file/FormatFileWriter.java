package com.jdevel.file;

import java.io.File;

/**
 * Used to write specific file formats to file.
 * Provides a basic structure,
 * Each supported file format will then have its own FormatFileWriter class
 */
public abstract class FormatFileWriter {

    /**
     * File which is to be written to
     */
    private File file;

    /**
     * Basic constructor, passes File parameter to the setter
     * @param file file to be written to, passed to setter
     */
    public FormatFileWriter(File file) {
        this.setFile(file);
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
