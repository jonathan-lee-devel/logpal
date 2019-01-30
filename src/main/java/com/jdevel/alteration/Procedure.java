package com.jdevel.alteration;

import java.util.ArrayList;
import java.util.ListIterator;

public class Procedure {

    /**
     * Contents of the procedure
     */
    private ArrayList<ProcedureContent> contents;

    /**
     * Default constructor, simply initializes contents to empty list
     */
    public Procedure() {
        this.contents = new ArrayList<>();
    }

    /*
     * List Access Methods
     */

    /**
     * Adds content to contents list
     * @param content content to be added
     * @return success flag
     */
    public boolean addContent(ProcedureContent content) {
        return this.getContents().add(content);
    }

    /**
     * Removes content from contents list
     * @param content content to be removed
     * @return success flag
     */
    public boolean removeContent(ProcedureContent content) {
        return this.getContents().remove(content);
    }

    /**
     * Getter for ListIterator for contents list
     * @return iterator for contents list
     */
    public ListIterator<ProcedureContent> getContentsIterator() {
        return this.getContents().listIterator();
    }

    /*
     * Getters and Setters
     */

    private ArrayList<ProcedureContent> getContents() {
        return this.contents;
    }

    private void setContents(ArrayList<ProcedureContent> contents) {
        this.contents = contents;
    }

}
